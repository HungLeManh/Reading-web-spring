package com.io.readingweb.controller;

import com.io.readingweb.dto.response.StoryDetailDTO;
import com.io.readingweb.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/story")
public class StoryController {
    private final StoryRepository storyRepository;

    @GetMapping("/detail/{id}")
    public ResponseEntity<StoryDetailDTO> getStoryDetail(){

    }
}
