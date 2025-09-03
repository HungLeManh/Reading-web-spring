package com.io.readingweb.service;

import com.io.readingweb.dto.request.RegisterDTO;
import com.io.readingweb.dto.response.UserInfoDTO;
import com.io.readingweb.entity.Role;
import com.io.readingweb.entity.User;
import com.io.readingweb.repository.RoleRepository;
import com.io.readingweb.repository.UserRepository;
import com.io.readingweb.util.RoleName;
import com.io.readingweb.util.UserStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public long register(RegisterDTO registerDTO){

        if (userRepository.findByUsernameOrEmail(registerDTO.getUsername(), registerDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Username or email already exists");
        }

        if (userRepository.findByUsernameOrEmail(registerDTO.getUsername(), registerDTO.getEmail()).isEmpty()) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

            Set<Role> roleSet = new HashSet<>();
            Role role = roleRepository.findByRoleName(RoleName.valueOf("USER")).orElseThrow(() -> new RuntimeException("role do not exists"));
            roleSet.add(role);

            User user = User.builder()
                    .fullName(registerDTO.getFullName())
                    .email(registerDTO.getEmail())
                    .username(registerDTO.getUsername())
                    .password(passwordEncoder.encode(registerDTO.getPassword()))
                    .avatarUrl(registerDTO.getAvatarUrl())
                    .roles(roleSet)
                    .createdAt(LocalDate.now())
                    .updatedAt(LocalDate.now())
                    .status(UserStatus.ACTIVE)
                    .build();

            userRepository.save(user);

            return user.getUserId();
        }

        return 1;
    }

    public UserInfoDTO getUserInfo(String username) {
        User user = userRepository.findByUsernameOrEmail(username, username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Set<String> roleNames = user.getRoles().stream()
                .map(r -> r.getRoleName().toString())
                .collect(Collectors.toSet());

        return UserInfoDTO.builder()
                .userId(user.getUserId())
                .fullName(user.getFullName())
                .username(user.getUsername())
                .email(user.getEmail())
                .roles(roleNames)
                .avatarUrl(user.getAvatarUrl())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .status(user.getStatus())
                .build();


    }

}
