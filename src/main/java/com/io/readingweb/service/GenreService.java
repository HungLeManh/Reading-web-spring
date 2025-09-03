package com.io.readingweb.service;

import com.io.readingweb.dto.request.AddGenreDTO;
import com.io.readingweb.entity.Genre;
import com.io.readingweb.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public long addGenre(AddGenreDTO genreDTO){

        if(genreRepository.findByName(genreDTO.getName()).isPresent()){
            throw new RuntimeException("genre has already exists");
        }

        if(genreRepository.findByName(genreDTO.getName()).isEmpty()){
            Genre genre = new Genre();
            genre.setName(genreDTO.getName());
            genreRepository.save(genre);

            return genre.getGenreId();
        }
        return 1;
    }
}
