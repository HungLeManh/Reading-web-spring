package com.io.readingweb.dto.request;

import lombok.Getter;

@Getter
public class RegisterDTO {
    private String fullName;
    private String username;
    private String email;
    private String password;
    private String avatarUrl;

    public RegisterDTO(String fullName, String username, String email, String password, String avatarUrl){
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatarUrl = avatarUrl;
    }
}
