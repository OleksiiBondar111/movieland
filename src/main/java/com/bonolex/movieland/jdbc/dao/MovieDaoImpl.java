package com.bonolex.movieland.jdbc.dao;

import com.bonolex.movieland.entity.Movie;
import com.bonolex.movieland.jdbc.entityrowmapper.MovieRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by OBondar on 10.03.2019.
 */

@Repository
@Transactional
public class MovieDaoImpl implements MovieDao {

    private DataSource dataSource;
    private static MovieRowMapper movieRowMapper = new MovieRowMapper();
    private static final String FIND_ALL = "SELECT m.id, m.name_russian, " +
            "                                            m.name_native, m.release_year, m.rating, m.price, p.picture_path  " +
            "FROM movie m JOIN poster p ON p.movie_id=m.id";

    @Autowired
    public MovieDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int save(Movie movie) {
        return 0;
    }

    public int update(Movie movie) {
        return 0;
    }

    public int delete(int id) {
        return 0;
    }

    public Movie fndById(int id) {
        return null;
    }

    public List<Movie> findAll() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FIND_ALL)) {

            List<Movie> movies = new ArrayList<>();
            while (resultSet.next()) {
                movies.add(movieRowMapper.mapRow(resultSet));
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
