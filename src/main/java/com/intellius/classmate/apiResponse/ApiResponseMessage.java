package com.intellius.classmate.apiResponse;

import lombok.*;

@Getter@Setter
@NoArgsConstructor
public class ApiResponseMessage {
    private String message;
    private Object data;

    @Builder
    public ApiResponseMessage(Object data, String message) {
        this.data = data;
        this.message = message;
    }
}
