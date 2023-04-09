package org.sangtran.service;

import org.sangtran.dto.NotificationRequest;
import org.sangtran.entity.Notification;

import org.sangtran.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@ComponentScan("org.sangtran.repository")
public class NotificationService {

//    @Autowired
//    private NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
//        this.notificationRepository.save(
//                Notification.builder()
//                        .toCustomerId(notificationRequest.toCustomerId())
//                        .toCustomerEmail(notificationRequest.toCustomerName())
//                        .sender("sangtran")
//                        .message(notificationRequest.message())
//                        .sentAt(LocalDateTime.now())
//                        .build()
//        );
    }
}
