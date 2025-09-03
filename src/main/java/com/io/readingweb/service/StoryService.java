package com.io.readingweb.service;

import com.io.readingweb.dto.response.StoryDetailDTO;
import com.io.readingweb.entity.Story;
import com.io.readingweb.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoryService {
    private final StoryRepository storyRepository;

    public StoryDetailDTO getStoryDetail(Long storyId){
        Story story = storyRepository.findById(storyId).orElseThrow(() -> new RuntimeException("story do not exist"));
        StoryDetailDTO storyDetailDTO = StoryDetailDTO.builder()
                .title(story.getTitle())
                .slug(story.getSlug())
                .description(story.getDescription())
                .coverImage(story.getCoverImage())
                .status(story.getStatus())
                .createdAt(story.getCreatedAt())
                .updatedAt(story.getUpdatedAt())
                .author(story.getAuthor())
                .genres(story.getGenres())
                .chapters(story.getChapters())
                .build();
        return storyDetailDTO;
    }
}
