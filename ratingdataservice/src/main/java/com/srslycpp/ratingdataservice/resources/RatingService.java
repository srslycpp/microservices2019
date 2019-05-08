package com.srslycpp.ratingdataservice.resources;

import com.srslycpp.ratingdataservice.models.Ratings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
public class RatingService {

    @RequestMapping("/{movieId}")
    public Ratings getRatings(@PathVariable("movieId") String movieId){
        return new Ratings(movieId, 8);
    }
}
