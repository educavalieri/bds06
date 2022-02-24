package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Long> {

//    @Query("SELECT obj FROM Movie obj WHERE " +
//            "( :genreId IS NULL OR obj.genre.id = :genreId) " )
//    Page<Movie> findByGenreIdOld(Long genreId, Pageable pageable);

    @Query("SELECT DISTINCT obj FROM Movie obj INNER JOIN obj.genre gen WHERE " +
            "(:genre IS NULL OR :genre IN gen )" +
            "ORDER BY obj.title " )
    Page<Movie> findByGenreId(Genre genre, Pageable pageable);


}
