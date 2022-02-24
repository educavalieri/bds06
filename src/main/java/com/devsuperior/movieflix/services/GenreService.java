package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Transactional
    public Page<GenreDTO> findAll(Pageable pageable){
        Page<Genre> entity = genreRepository.findAll(pageable);
        Page<GenreDTO> dto = entity.map(x -> new GenreDTO(x));
        return dto;
    }



}
