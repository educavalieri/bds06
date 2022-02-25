package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;

import java.util.ArrayList;
import java.util.List;

public class GenreTestDTO {

    private Long id;
    private String name;
    private List<Long> movieIds = new ArrayList<>();

    public GenreTestDTO(){
    }

    public GenreTestDTO(Long id, String name, List<Long> movieIds) {
        this.id = id;
        this.name = name;
        this.movieIds = movieIds;
    }

    public GenreTestDTO(Genre entity, List<Long> movieIds) {
        this.id = entity.getId();
        this.name = entity.getName();
        movieIds.forEach( x -> this.movieIds.add(x));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getMovieIds() {
        return movieIds;
    }

    public void setMovieIds(List<Long> movieIds) {
        this.movieIds = movieIds;
    }
}
