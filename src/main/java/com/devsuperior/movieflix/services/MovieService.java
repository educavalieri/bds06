package com.devsuperior.movieflix.services;


import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;


    public Page<MovieDTO> findAll(Pageable pageable) {
        Page<Movie> entity = movieRepository.findAll(pageable);
        Page<MovieDTO> dto = entity.map(x -> new MovieDTO(x));
        return dto;
    }

    public MovieDTO findById(Long id) {
        Optional<Movie> entity = movieRepository.findById(id);
        Movie aux = entity.get();
        MovieDTO dto = new MovieDTO(aux);
        return dto;
    }

    public Page<MovieDTO> findByGenreId(Long genreId, Pageable pageable){
        Page<Movie> entity = movieRepository.findByGenreId(genreId, pageable);
        Page<MovieDTO> dto = entity.map(x -> new MovieDTO(x));
        return dto;
    }

}








