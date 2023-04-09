package org.sangtran.dto;


public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message
) {
}