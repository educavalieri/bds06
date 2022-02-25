package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ReviewInsertDTO {

    @NotBlank
    @NotEmpty
    private String text;
    private Long movieId;

    public ReviewInsertDTO(){

    }

    public ReviewInsertDTO(String text, Long movieId) {
        this.text = text;
        this.movieId = movieId;
    }

    public ReviewInsertDTO(Review entity){
        text = entity.getText();
        movieId = entity.getMovie().getId();

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }



}
