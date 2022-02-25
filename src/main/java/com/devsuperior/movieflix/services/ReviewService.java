package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AuthService authService;

    @Transactional
    public List<ReviewDTO> findAll(){
        List<Review> entity = reviewRepository.findAll();
        List<ReviewDTO> dto = entity.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
        return dto;

    }

    @Transactional
    public ReviewDTO findId(Long id){
        Review review = reviewRepository.findById(id).get();
        return new ReviewDTO(review);

    }

    @PostMapping
    @Transactional
    public ReviewDTO insertReview(String text, Long movieId){
        Review entity = new Review();
        User user = authService.Authenticated();
        User userEntity = userRepository.findByEmail(user.getUsername());
        Movie movie = movieRepository.getOne(movieId);
        entity.setId(entity.getId());
        entity.setUser(userEntity);
        entity.setMovie(movie);
        entity.setText(text);
        reviewRepository.save(entity);
        return new ReviewDTO(entity);
    }



}
