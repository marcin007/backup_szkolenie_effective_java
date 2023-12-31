package com.pivovarit.rental;

import com.pivovarit.rental.Movie;
import com.pivovarit.rental.MovieId;
import com.pivovarit.rental.MovieType;

import java.util.List;
import java.util.Optional;

interface MovieRepository {


    List<Movie> findAll();

    List<Movie> findAllByType(MovieType type);

    Optional<Movie> findOneById(MovieId id);

    void save(Movie movie);
}
