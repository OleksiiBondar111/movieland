package com.bonolex.movieland.jdbc.entityrowmapper;

import com.bonolex.movieland.entity.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by OBondar on 10.03.2019.
 */
public class MovieRowMapper {

    public Movie mapRow(ResultSet resultSet) throws SQLException {
        Movie movie = new Movie();
        movie.setNameRussian(resultSet.getString("name_russian"));
        movie.setNameNative(resultSet.getString("name_native"));
        movie.setPicturePath(resultSet.getString("picture_path"));
        movie.setPrice(resultSet.getDouble("price"));
        movie.setRating(resultSet.getDouble("rating"));
        movie.setYearOfRelease(resultSet.getString("release_year"));
        movie.setId(resultSet.getLong("id"));
        return movie;
    }
}

