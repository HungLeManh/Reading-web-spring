package com.io.readingweb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chapters")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapter_id")
    private long chapterId;

    @Column(name = "chapter_number")
    private int chapterNumber;

    @Column(name = "title")
    private String title;

    @Column(name = "is_blocked")
    private Boolean isBlocked;

    @Column(name = "price")  // gia tinh bang dau-bean neu isBlocked = true
    private int price;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "update_at")
    private LocalDate updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "story_id", referencedColumnName = "story_id")
    private Story story;
}
