package org.sangtran.notification;


public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message
) {
}