package com.io.readingweb.controller;

import com.io.readingweb.dto.response.UserInfoDTO;
import com.io.readingweb.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/info")
    public ResponseEntity<UserInfoDTO> getUserInfo() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();

            UserInfoDTO userInfo = userService.getUserInfo(username);
            return ResponseEntity.ok(userInfo);
        } catch (Exception e) {
            log.error("Error getting user info: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
