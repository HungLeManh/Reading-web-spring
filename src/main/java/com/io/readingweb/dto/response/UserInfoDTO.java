package com.io.readingweb.dto.response;

import com.io.readingweb.entity.Role;
import com.io.readingweb.util.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserInfoDTO {
    private long userId;
    private String username;
    private String email;
    private String fullName;
    private String avatarUrl;
    private UserStatus status;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Set<Role> roles;
}
