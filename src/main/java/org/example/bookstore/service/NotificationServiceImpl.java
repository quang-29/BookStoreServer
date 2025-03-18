package org.example.bookstore.service;

import jakarta.transaction.Transactional;
import lombok.Setter;
import org.example.bookstore.model.Notification;
import org.example.bookstore.model.User;
import org.example.bookstore.payload.response.APIResponse;
import org.example.bookstore.payload.response.PagingResponse;
import org.example.bookstore.repository.NotificationRepository;
import org.example.bookstore.repository.UserRepository;
import org.example.bookstore.security.JwtTokenProvider;
import org.example.bookstore.service.Interface.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private  NotificationRepository notificationRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;


    @Override
    public PagingResponse<List<Notification>> getNotifications(Map<Object, String> filters) {
        int page = Integer.parseInt(filters.getOrDefault("page", "-1"));
        int limit = Integer.parseInt(filters.getOrDefault("limit", "-1"));
        String order = filters.get("order");
        if (page == -1 && limit == -1) {
            Specification<Notification> notificationSpecification = NotificationSpecification.filtersNotification(filters.get("userId"), filters.get("search"));
            List<Notification> notifications = notificationRepository.findAll(notificationSpecification, Sort.by(Sort.Direction.DESC, "createdAt"));
            int totalNew = (int) notifications.stream()
                    .filter(notification -> notification.getIsRead() == 0)
                    .count();
            return new PagingResponse<>(notifications, "NOTIFICATION_GET_LIST_SUCCESS", 1, (long) notifications.size(), totalNew);
        }
        page = Math.max(Integer.parseInt(filters.getOrDefault("page", "-1")), 1) - 1;
        Pageable pageable = PageRequest.of(page, limit, Sort.by("createdAt").descending());
        pageable = getPageable(pageable, page, limit, order);
        Specification<Notification> notificationSpecification = NotificationSpecification.filtersNotification(filters.get("userId"), filters.get("search"));
        Page<Notification> notifications = notificationRepository.findAll(notificationSpecification, pageable);
        int totalNew = (int) notifications.getContent().stream()
                .filter(notification -> notification.getIsRead() == 0)
                .count();
        return new PagingResponse<>(notifications.getContent(), "NOTIFICATION_GET_LIST_SUCCESS", notifications.getTotalPages(), notifications.getTotalElements(), totalNew);
    }

    @Override
    @Transactional
    public APIResponse<Notification> markReadNotification(String notificationId) {
        Notification notification = notificationRepository.findById(UUID.fromString(notificationId))
                .orElseThrow(() -> new RuntimeException("NOTIFICATION_NOT_FOUND"));
        notification.setIsRead(1);
        notificationRepository.save(notification);
        return new APIResponse<>(notification, "NOTIFICATION_READ");
    }

    @Override
    @Transactional
    public APIResponse<Boolean> deleteNotification(String notificationId) {
        Notification notification = notificationRepository.findById(UUID.fromString(notificationId))
                .orElseThrow(() -> new RuntimeException("NOTIFICATION_NOT_FOUND"));
        for (User user : notification.getUsers()) {
            user.getNotifications().remove(notification);
        }
        userRepository.saveAll(notification.getUsers());
        notification.getUsers().clear();
        notificationRepository.delete(notification);
        return new APIResponse<>(true, "NOTIFICATION_DELETE_SUCCESS");
    }

    @Override
    @Transactional
    public APIResponse<Boolean> readAllNotification(String token) {

        User user = jwtTokenProvider.getUser(token);
        List<Notification> notificationList = user.getNotifications();
        for(Notification notification : notificationList){
            notification.setIsRead(1);
        }
        notificationRepository.saveAll(notificationList);
        return new APIResponse<>(true, "NOTIFICATION_READ_ALL");
    }

    private Pageable getPageable(Pageable pageable, int page, int limit, String order) {
        if (StringUtils.hasText(order)) {
            String[] orderParams = order.split(" ");
            if (orderParams.length == 2) {
                Sort.Direction direction = orderParams[1].equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
                pageable = PageRequest.of(page, limit, Sort.by(new Sort.Order(direction, orderParams[0])));
            }
        }
        return pageable;
    }


}
