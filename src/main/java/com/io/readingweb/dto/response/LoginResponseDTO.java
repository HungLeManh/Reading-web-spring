package com.io.readingweb.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class LoginResponseDTO {
    private String token;
    private String tokenType;
    private Long userId;
    private String username;
    private String email;
}