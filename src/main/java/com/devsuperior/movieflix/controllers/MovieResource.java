package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

    @Autowired
    private MovieService movieService;


    @GetMapping(value = "findAll")
    public ResponseEntity<Page<MovieDTO>> findAll(Pageable pageable){
        Page<MovieDTO> list = movieService.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable("id") Long id){
        MovieDTO dto = movieService.findById(id);
        return ResponseEntity.ok().body(dto);

    }

    @GetMapping
    public ResponseEntity<Page<MovieDTO>> findByGenreId(
            @RequestParam(value = "genreId", defaultValue = "0") Long genreId,
            Pageable pageable){
        Page<MovieDTO> dto = movieService.findByGenreId(genreId, pageable);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}/reviews")
    public ResponseEntity<Page<ReviewDTO>> findReviewByUserId(
            @PathVariable("id") Long movieId,
            Pageable pageable){
        Page<ReviewDTO> dto = movieService.findReviewByMovieId(movieId, pageable);
        return ResponseEntity.ok().body(dto);
    }


}
