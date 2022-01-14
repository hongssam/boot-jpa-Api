package com.intellius.classmate.firebase;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FirebaseCloudMessageService {
    //private final String API_URL = "https://fcm.googleapis.com/v1/projects/classmate-f0d55/messages:send";

    public void sendMessageTo(String targetToken, String title, String body) throws FirebaseMessagingException {
        Message message = Message.builder()
                // putAllData Map<String, String>
                .putData("title", title)
                .putData("content", body)
                .setNotification(Notification.builder()
                    .setTitle("제목이구요")
                    .setBody("내용입니다")
                    .build())
                .setToken(targetToken)
                .build();

        String response = FirebaseMessaging.getInstance().send(message);
        System.out.println("Successfully sent message : " + response);
    }
}



