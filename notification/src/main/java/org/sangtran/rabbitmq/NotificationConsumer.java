package org.sangtran.rabbitmq;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sangtran.dto.NotificationRequest;
import org.sangtran.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest) {
        log.info("Consumed {} from queue", notificationRequest);
        notificationService.send(notificationRequest);
    }
}