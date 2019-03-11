package com.bonolex.movieland.service;

import com.bonolex.movieland.entity.Movie;

import java.util.List;

/**
 * Created by OBondar on 10.03.2019.
 */
public interface MovieService {
    int saveMovie(Movie movie);

    int updateMovie(Movie movie);

    int deleteMovie(int id);

    Movie getMovie(int id);

    List<Movie> getMovies();

}
