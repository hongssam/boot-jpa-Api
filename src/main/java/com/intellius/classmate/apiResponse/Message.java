package com.intellius.classmate.apiResponse;

import lombok.*;

@Getter@Setter
@NoArgsConstructor
public class Message {
    private String message;
    private Object data;

    @Builder
    public Message(Object data, String message) {
        this.data = data;
        this.message = message;
    }
}
