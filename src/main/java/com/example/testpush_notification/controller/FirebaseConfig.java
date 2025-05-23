package com.example.testpush_notification.controller;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FirebaseConfig {

    @PostConstruct
    public void initialize() {
        try {
            InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("serviceAccountKey.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            FirebaseApp.initializeApp(options);

        } catch (IOException e) {
            System.out.println("Firebase initialization failed");
            e.printStackTrace();
        }
    }
}
