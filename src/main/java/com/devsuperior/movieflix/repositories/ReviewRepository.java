package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT DISTINCT obj FROM Review obj INNER JOIN obj.movie mov WHERE " +
            "(:movie IS NULL OR :movie IN mov )" )
    Page<Review> findReviewByIdUser(Movie movie, Pageable pageable);
}
