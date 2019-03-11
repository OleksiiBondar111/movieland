package com.bonolex.movieland.service;

import com.bonolex.movieland.entity.Movie;
import com.bonolex.movieland.jdbc.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by OBondar on 10.03.2019.
 */

@Service

public class MovieServiceImpl implements MovieService {

 @Autowired
 private MovieDao movieDao;

    @Override
    public int saveMovie(Movie movie) {
        return 0;
    }

    @Override
    public int updateMovie(Movie movie) {
        return 0;
    }

    @Override
    public int deleteMovie(int id) {
        return 0;
    }

    @Override
    public Movie getMovie(int id) {
        return null;
    }

    @Override
    public List<Movie> getMovies() {
        return movieDao.findAll();
    }
}
