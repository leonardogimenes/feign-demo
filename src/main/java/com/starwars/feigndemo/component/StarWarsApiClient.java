package com.starwars.feigndemo.component;

import com.starwars.feigndemo.dto.StarWarsApiCharacterResponse;

public interface StarWarsApiClient {

    StarWarsApiCharacterResponse searchForCharacters(final Integer page);
}
