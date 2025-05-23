package com.example.testpush_notification.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/v1/notification")
public class PushNotificationController {

    private final FCMService fcmService;

    public PushNotificationController(FCMService fcmService) {
        this.fcmService = fcmService;
    }

    @PostMapping("/send-notification")
    public String sendNotification(@RequestParam String token, @RequestParam String title, @RequestParam String body) {
        try {
            fcmService.sendMessage(token, title, body);
            return "Notification sent successfully!";
        } catch (FirebaseMessagingException e) {
            return "Failed to send notification: " + e.getMessage();
        }
    }
}
