package com.bonolex.movieland.service;

import com.bonolex.movieland.entity.Movie;
import com.bonolex.movieland.jdbc.dao.JdbcMovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service

public class MovieServiceImpl implements MovieService {

 @Autowired
 private JdbcMovieDao jdbcMovieDao;

    @Override
    public List<Movie> getMovies() {
        return jdbcMovieDao.findAll();
    }
}
