package com.srslycpp.movieinfoservice.resources;

import com.srslycpp.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieInfoService {

    @RequestMapping("/{movieId}")
    public Movie getMovie(@PathVariable("movieId") String movieID){

        return new Movie("SomeMovie", "SomeMovieFromMovieInfoService Port:8084");
    }
}
