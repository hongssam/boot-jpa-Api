package com.intellius.classmate.firebase;

import com.google.firebase.messaging.Notification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

//@Builder
//@AllArgsConstructor
//@Getter
//public class FcmMessage {
//    private Message message;
//
//    @Builder
//    @AllArgsConstructor
//    @Getter
//    public static class Message{
//        private Notification notification;
//        private String token;
//    }
//
//    @Builder
//    @AllArgsConstructor
//    @Getter
//    public static class Notification {
//        private String body;
//        private String title;
//    }
//}

//@Builder
//@AllArgsConstructor
//@Getter
//public class FcmMessage {
//    private Message message;
//
//    @Builder
//    @AllArgsConstructor
//    @Getter
//    public static class Message{
//        private Data data;
//        private String token;
//    }
//
//    @Builder
//    @AllArgsConstructor
//    @Getter
//    public static class Data {
//        private String type;
//        private String content;
//    }
//}



@Builder
@AllArgsConstructor
@Getter
public class FcmMessage {
    private Data data;
    private String token;

    @Builder
    @AllArgsConstructor
    @Getter
    public static class Data {
        private String type;
        private String content;
    }

}