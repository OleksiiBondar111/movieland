package com.bonolex.movieland.jdbc.dao;

import com.bonolex.movieland.entity.Movie;
import com.bonolex.movieland.jdbc.entityrowmapper.MovieRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcMovieDaoImpl implements JdbcMovieDao {

    private static final Logger logger = LoggerFactory.getLogger(JdbcMovieDaoImpl.class);
    private static final RowMapper movieRowMapper = new MovieRowMapper();
    private static final String FIND_ALL =
            "SELECT m.id, m.name_russian,m.name_native, m.release_year, m.rating, m.price, p.picture_path FROM movie m JOIN poster p ON p.movie_id=m.id";
    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public JdbcMovieDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Movie> findAll() {
        try {
            List<Movie> movies = jdbcTemplate.query(FIND_ALL, movieRowMapper);
            return movies;
        } catch (DataAccessException e) {
            logger.error("findAll:", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}