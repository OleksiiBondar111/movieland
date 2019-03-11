package com.bonolex.movieland.jdbc.dao;

import com.bonolex.movieland.entity.Movie;

import java.util.List;

/**
 * Created by OBondar on 10.03.2019.
 */
public interface MovieDao {
    int save(Movie movie);

    int update(Movie movie);

    int delete(int id);

    Movie fndById(int id);

    List<Movie> findAll();

}
