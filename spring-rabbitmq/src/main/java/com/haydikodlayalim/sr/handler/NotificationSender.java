package com.haydikodlayalim.sr.handler;

import com.haydikodlayalim.sr.model.Notification;
import com.haydikodlayalim.sr.producer.NotificationProducer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class NotificationSender {

    @Autowired
    private NotificationProducer producer;

    public void getThread() {
        Thread thread = new Thread(() -> {
            Notification notification = new Notification();
            notification.setNotificationId(UUID.randomUUID().toString());
            notification.setCraetedAt(new Date());
            notification.setMessage("message delivered....");
            notification.setSeen(false);
            producer.sendToQueue(notification);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setName("Notification sender");
        thread.start();
    }

    @PostConstruct
    public void init() {
        getThread();
    }
}
