package com.io.readingweb.controller;

import com.io.readingweb.dto.request.LoginDTO;
import com.io.readingweb.dto.request.RegisterDTO;
import com.io.readingweb.dto.response.LoginResponseDTO;
import com.io.readingweb.service.AuthService;
import com.io.readingweb.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {
    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestBody RegisterDTO registerDTO) {
        try {
            long userId = userService.register(registerDTO);
            return ResponseEntity.ok(userId);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        try {
            LoginResponseDTO response = authService.login(loginDTO);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
