package ru.job4j.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.model.Notification;
import ru.job4j.repository.NotificationRepository;

@Slf4j
@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @KafkaListener(topics = "job4j_notifications")
    public void receiveNotification(Notification notification) {
        System.out.println(notification);
        log.info(notification.toString());
        notificationRepository.save(notification);
    }
}
