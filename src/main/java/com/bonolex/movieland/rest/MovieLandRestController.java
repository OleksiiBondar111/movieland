package com.bonolex.movieland.rest;

import com.bonolex.movieland.entity.Movie;
import com.bonolex.movieland.exceptions.EntityErrorResponse;
import com.bonolex.movieland.exceptions.MovieNotFoundException;
import com.bonolex.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by OBondar on 10.03.2019.
 */

@RestController
@RequestMapping("/v1")
public class MovieLandRestController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movie")
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> handleException(Exception exception) {
        EntityErrorResponse errorResponse = new EntityErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<EntityErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
