package com.starwars.feigndemo.component.impl;

import com.starwars.feigndemo.component.StarWarsApiClient;
import com.starwars.feigndemo.dto.StarWarsApiCharacterResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class StarWarsApiClientImpl implements StarWarsApiClient {

    private final String apiUrl;

    public StarWarsApiClientImpl(@Value("${api.starwars}") String apiUrl) {
        this.apiUrl = apiUrl;
    }

    @Override
    public StarWarsApiCharacterResponse searchForCharacters(Integer page) {
        final RestTemplate restTemplate = new RestTemplate();
        final String getPeopleUrl = String.format("%s/people/", this.apiUrl);
        final Map<String, Object> params = new HashMap<>();
        params.put("page", page);
        return restTemplate.getForObject(getPeopleUrl, StarWarsApiCharacterResponse.class, params);
    }
}
