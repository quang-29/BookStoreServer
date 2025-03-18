package org.example.bookstore.service.Interface;

import org.example.bookstore.model.Notification;
import org.example.bookstore.payload.response.APIResponse;
import org.example.bookstore.payload.response.DataResponse;
import org.example.bookstore.payload.response.PagingResponse;

import java.util.List;
import java.util.Map;

public interface NotificationService {
    PagingResponse<List<Notification>> getNotifications(Map<Object, String> filters);
    APIResponse<Notification> markReadNotification(String notificationId);
    APIResponse<Boolean> deleteNotification(String notificationId);
    APIResponse<Boolean> readAllNotification(String token);

}
