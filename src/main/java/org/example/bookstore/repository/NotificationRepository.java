package org.example.bookstore.repository;

import org.example.bookstore.model.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, UUID>, JpaSpecificationExecutor<Notification> {
    Page<Notification> findByContextContainingIgnoreCase(String name, Pageable pageable);
}
