package com.starwars.feigndemo;

import com.starwars.feigndemo.component.StarWarsApiClient;
import com.starwars.feigndemo.dto.StarWarsApiCharacterResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class FeignDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(final StarWarsApiClient starWarsApiClient){
        return args -> {
            if (args.length > 0) {
                final Integer page = Integer.parseInt(args[0].split("=")[1]);
                StarWarsApiCharacterResponse starWarsApiCharacterResponse = starWarsApiClient.searchForCharacters(page);
                log.info("Total: {}", starWarsApiCharacterResponse.getCount());
                log.info("page: {}", page);
                starWarsApiCharacterResponse.getStarWarsCharacters().forEach(starWarsCharacter -> {
                    log.info("---- Person ----");
                    log.info("Name: {}", starWarsCharacter.getName());
                    log.info("From: {}", starWarsCharacter.getHomeWorld());
                });
            }
            System.exit(0);
        };
    }

}
