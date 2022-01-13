package com.intellius.classmate.firebase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.apache.http.HttpHeaders;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class FirebaseCloudMessageService {
    private final String API_URL = "https://fcm.googleapis.com/v1/projects/classmate-f0d55/messages:send";
    private final ObjectMapper objectMapper;

    public void sendMessageTo(String targetToken, String title, String body) throws IOException{
//        URL url = new URL(API_URL);
//        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//        httpURLConnection.setRequestProperty("Authorization", "Bearer " + getAccessToken());
//        httpURLConnection.setRequestProperty("Content-Type", "application/json; UTF-8");
//
//        httpURLConnection.setDoOutput(true);
//        System.out.println(httpURLConnection.getRequestProperties());
//        String message = makeMessage(targetToken, title, body);
//        System.out.println(message );
//        DataOutputStream outputStream = new DataOutputStream(httpURLConnection.getOutputStream());
//        //outputStream.writeBytes(fcmMessage.toString());
//        outputStream.write(message.getBytes("UTF-8"));
//        outputStream.flush();
//        outputStream.close();
//
//        int responseCode = httpURLConnection.getResponseCode();
//
//        if (responseCode == 200) {
//            String response = inputstreamToString(httpURLConnection.getInputStream());
//            System.out.println("Message sent to Firebase for delivery, response:");
//            System.out.println(response);
//        } else {
//            System.out.println("Unable to send message to Firebase:");
//            String response = inputstreamToString(httpURLConnection.getErrorStream());
//            System.out.println(response);
//        }

        String message = makeMessage(targetToken, title, body);
        System.out.println("message = " + message);
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(message, MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(API_URL)
                .post(requestBody)
                .addHeader(HttpHeaders.AUTHORIZATION, "Bearer" + getAccessToken())
                .addHeader(HttpHeaders.CONTENT_TYPE, "application/json; UTF-8")
                .build();

        Response response = client.newCall(request)
                .execute();

        System.out.println(response.body().string());
    }

    private static String inputstreamToString(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.nextLine());
        }
        return stringBuilder.toString();
    }

//    private String makeMessage(String targetToken, String title, String body) throws JsonProcessingException {
//        FcmMessage fcmMessage = FcmMessage.builder()
//                .message(FcmMessage.Message.builder()
//                        .token(targetToken)
//                        .data(FcmMessage.Data.builder()
//                                .type("warning")
//                                .content("1234")
//                                .build()
//                        )
//                        .build()
//                )
//                .build();
//
//        return objectMapper.writeValueAsString(fcmMessage);
//    }

    private String makeMessage(String targetToken, String title, String body) throws JsonProcessingException {
        FcmMessage fcmMessage = FcmMessage.builder()
                .data(FcmMessage.Data.builder()
                        .type("warning")
                        .content("1234")
                        .build()
                )
                .token(targetToken)
                .build();

        return objectMapper.writeValueAsString(fcmMessage);
    }

    private String getAccessToken() throws IOException {
        String MESSAGING_SCOPE = "https://www.googleapis.com/auth/firebase.messaging";
        String[] SCOPES = { MESSAGING_SCOPE };


        String firebaseConfigPath = "firebase/classmate-f0d55-firebase-adminsdk-ukuat-f67da27d7c.json";
        GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(new ClassPathResource(firebaseConfigPath).getInputStream())
                .createScoped(Arrays.asList(SCOPES));

        googleCredentials.refreshIfExpired();
        System.out.println("googleCredentials.getAccessToken().getTokenValue() = " + googleCredentials.getAccessToken().getTokenValue());
        return googleCredentials.getAccessToken().getTokenValue();
    }
}



