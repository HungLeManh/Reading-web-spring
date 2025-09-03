package com.io.readingweb.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddGenreDTO {
    private String name;

    public AddGenreDTO(String name){
        this.name = name;
    }
}
