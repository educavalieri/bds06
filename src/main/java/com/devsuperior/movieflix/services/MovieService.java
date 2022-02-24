package com.devsuperior.movieflix.services;


import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private ReviewRepository reviewRepository;


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

//    public Page<MovieDTO> findByGenreIdOld(Long genreId, Pageable pageable){
//        Page<Movie> entity = movieRepository.findByGenreIdOld(genreId, pageable);
//        Page<MovieDTO> dto = entity.map(x -> new MovieDTO(x));
//        return dto;
//    }

    public Page<MovieDTO> findByGenreId(Long genreId, Pageable pageable){
        Genre genre = (genreId == 0) ? null : genreRepository.getOne(genreId) ;
        Page<Movie> entity = movieRepository.findByGenreId(genre, pageable);
        Page<MovieDTO> dto = entity.map(x -> new MovieDTO(x));
        return dto;
    }

    @Transactional
    public Page<ReviewDTO> findReviewByMovieId(Long movieId, Pageable pageable) {
        Movie movie = (movieId == 0) ? null : movieRepository.getOne(movieId);
        Page<Review> entity = reviewRepository.findReviewByIdUser(movie, pageable);
        Page<ReviewDTO> dto = entity.map( x -> new ReviewDTO(x));
        return dto;

    }


}








