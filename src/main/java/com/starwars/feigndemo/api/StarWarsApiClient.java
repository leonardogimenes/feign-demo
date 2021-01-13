package com.starwars.feigndemo.api;

import com.starwars.feigndemo.dto.StarWarsApiCharacterResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "starwarsapi", url = "${api.starwars}")
public interface StarWarsApiClient {

    @GetMapping("/people/")
    StarWarsApiCharacterResponse searchForCharacters(@RequestParam("page") final Integer page);
}
