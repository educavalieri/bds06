package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

import java.util.ArrayList;
import java.util.List;

public class GenreDTO {

    private Long id;
    private String name;

    List<MovieDTO> movies = new ArrayList<>();

    public GenreDTO(){
    }

    public GenreDTO(Long id, String name, List<MovieDTO> movies) {
        this.id = id;
        this.name = name;
        this.movies = movies;
    }

    public GenreDTO(Genre entity) {
        id = entity.getId();
        name = entity.getName();
    }


    public GenreDTO(Genre entity, List<Movie> movies ){
        this(entity);
        movies.forEach(x -> this.movies.add(new MovieDTO(x)));
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

    public List<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }
}
