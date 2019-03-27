package com.bonolex.movieland.jdbc.dao;
import com.bonolex.movieland.entity.Movie;
import java.util.List;


public interface JdbcMovieDao {
    List<Movie> findAll();

}
