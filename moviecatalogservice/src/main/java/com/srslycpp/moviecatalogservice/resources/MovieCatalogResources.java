package com.srslycpp.moviecatalogservice.resources;

import com.srslycpp.moviecatalogservice.models.CatalogItem;
import com.srslycpp.moviecatalogservice.models.Movie;
import com.srslycpp.moviecatalogservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("catalog")
public class MovieCatalogResources {

    @RequestMapping("/{userID}")
    public List<CatalogItem> getCatalog(@PathVariable("userID") String userID){

        RestTemplate restTemplate = new RestTemplate();

        //Get all rated movie IDs
        List<Rating> ratings = Arrays.asList(
                new Rating("1", 11),
                new Rating("1", 11),
                new Rating("1", 11),
                new Rating("1", 11),
                new Rating("1", 11),
                new Rating("1", 11),
                new Rating("1", 11),
                new Rating("2", 3)
        );

     return ratings.stream().map(rating -> {

         //For each movie ID, call movie info service and get the details
         Movie movie = restTemplate.getForObject("http://localhost:8084/movies/"+ rating.getMovieId(), Movie.class);
         Rating ratin = restTemplate.getForObject("http://localhost:8085/rating/"+ movie.getName(), Rating.class);

         //Put them all together
         return new CatalogItem(movie.getName(),movie.getDesc() ,ratin.getRating());
     })
             .collect(Collectors.toList());




     //            return Collections.singletonList(new CatalogItem("Transformer", "Very interesting movie", 2));

    }
}
