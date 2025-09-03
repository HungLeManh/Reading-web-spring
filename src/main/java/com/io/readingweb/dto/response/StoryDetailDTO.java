package com.io.readingweb.dto.response;

import com.io.readingweb.entity.Chapter;
import com.io.readingweb.entity.Genre;
import com.io.readingweb.entity.User;
import com.io.readingweb.util.StoryStatus;
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
public class StoryDetailDTO {
    private long storyId;
    private String title;
    private String slug;
    private String description;
    private String coverImage;
    private StoryStatus status;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private User author;
    private Set<Genre> genres;
    private Set<Chapter> chapters;
}
