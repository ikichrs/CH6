package com.binar.challenge4.firebase;

import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;


@Service
public class FirebaseMessageService {
    public String sendNotification(FirebaseEntity firebaseEntity) {
        Notification notification = Notification
                .builder()
                .setTitle(firebaseEntity.getSubject())
                .setBody(firebaseEntity.getContent())
                .setImage(firebaseEntity.getImage())
                .build();

        return notification+"Message sudah di output";
    }
}
