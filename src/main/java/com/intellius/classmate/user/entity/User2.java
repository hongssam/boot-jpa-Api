package com.intellius.classmate.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class User2 {
    private UserInfo userInfo;
    private UserDetail userDetail;

    @Builder
    @AllArgsConstructor
    @Getter
    public static class UserInfo{
        private String id;
    }

    @Builder
    @AllArgsConstructor
    @Getter
    public static class UserDetail{
        private String name;
        private String token;

    }
}
