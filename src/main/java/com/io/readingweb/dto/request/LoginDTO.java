package com.io.readingweb.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
    private String usernameOrEmail;
    private String password;
}