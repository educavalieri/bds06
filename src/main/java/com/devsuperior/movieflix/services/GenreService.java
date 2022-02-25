package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.dto.GenreTestDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Transactional
    public List<GenreDTO> findAll(){
        List<Genre> entity = genreRepository.findAll();
        List<GenreDTO> dto = entity.stream().map(x -> new GenreDTO(x, x.getMovies())).collect(Collectors.toList());
        List<Movie> movies = new ArrayList<>();
        return dto;
    }

    @Transactional
    public Page<GenreTestDTO> findAllTest(Pageable pageable){
        Page<Genre> entity = genreRepository.findAll(pageable);
        List<Long> numbers = new ArrayList<>();
        entity.stream().map(x -> {
            MovieDTO dtoTemp = new MovieDTO();
            dtoTemp.setId(x.getId());
            numbers.add(dtoTemp.getId());
            return null;
        }).collect(Collectors.toList());

        Page<GenreTestDTO> dto = entity.map(x -> new GenreTestDTO(x, numbers));
        List<Movie> movies = new ArrayList<>();
        return dto;
    }



}
