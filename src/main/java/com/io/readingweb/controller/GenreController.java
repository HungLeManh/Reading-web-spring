package com.io.readingweb.controller;

import com.io.readingweb.dto.request.AddGenreDTO;
import com.io.readingweb.service.GenreService;
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
public class GenreController {
    private final GenreService genreService;

    @PostMapping("/admin/add-genre")
    public ResponseEntity<Long> addGenre(@RequestBody AddGenreDTO genreDTO){
        try {
            Long genreId = genreService.addGenre(genreDTO);
            return ResponseEntity.ok(genreId);
        } catch (Exception e) {
            log.error("Error add genre: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
