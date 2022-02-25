package com.devsuperior.movieflix.controllers;


import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.ReviewInsertDTO;
import com.devsuperior.movieflix.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewResource {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> findAll(){
        List<ReviewDTO> dto = reviewService.findAll();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ReviewDTO> findById(@PathVariable("id") Long id){
        ReviewDTO dto = reviewService.findId(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ReviewDTO> insertReview(@Valid @RequestBody ReviewInsertDTO dto){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(dto.getMovieId())
                .toUri();
        String text = dto.getText();
        Long movieId = dto.getMovieId();
        ReviewDTO newDto = reviewService.insertReview(text, movieId);
        return ResponseEntity.created(uri).body(newDto);
    }


}
