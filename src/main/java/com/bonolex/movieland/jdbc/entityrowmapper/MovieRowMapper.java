package com.bonolex.movieland.jdbc.entityrowmapper;

import com.bonolex.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;


public class MovieRowMapper implements RowMapper {

    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
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

