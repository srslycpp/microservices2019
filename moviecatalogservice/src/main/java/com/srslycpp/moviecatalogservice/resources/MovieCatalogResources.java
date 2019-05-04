package com.srslycpp.moviecatalogservice.resources;

import com.srslycpp.moviecatalogservice.models.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("catalog")
public class MovieCatalogResources {

    @RequestMapping("/{userID}")
    public List<CatalogItem> getCatalog(@PathVariable("userID") String userID){
            return Collections.singletonList(new CatalogItem("Transformer", "Very interesting movie", 2));

    }
}
