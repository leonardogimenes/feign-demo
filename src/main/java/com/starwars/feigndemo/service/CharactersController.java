package com.starwars.feigndemo.service;

import com.starwars.feigndemo.annotation.LogExecutionTime;
import com.starwars.feigndemo.api.StarWarsApiClient;
import com.starwars.feigndemo.dto.StarWarsApiCharacterResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class CharactersController {

    private final StarWarsApiClient starWarsApiClient;

    public CharactersController(StarWarsApiClient starWarsApiClient) {
        this.starWarsApiClient = starWarsApiClient;
    }

    @GetMapping(value = "/people/")
    @LogExecutionTime
    public StarWarsApiCharacterResponse searchCharacters(@RequestParam(value = "page", required = false) final Integer page){
        return starWarsApiClient.searchForCharacters(page);
    }

    @GetMapping(value = "/people/{id}/")
    @LogExecutionTime
    public StarWarsApiCharacterResponse searchCharacterById(@PathVariable("id") Integer id) {
        return starWarsApiClient.searchForCharacters(id);
    }
}
