package com.lessercodes.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.lessercodes.msscbreweryclient.Config;
import com.lessercodes.msscbreweryclient.web.model.BeerDto;

@Component
public class BreweryClient {

    private static final String BEER_PATH_V1 = "/api/v1/beer/";

    private final Config config;
    private final RestTemplate restTemplate;

    public BreweryClient(
            Config config,
            RestTemplateBuilder restTemplateBuilder) {
        this.config = config;
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeer(UUID beerId) {
        return restTemplate.getForObject(config.getApihost() + BEER_PATH_V1 + beerId, BeerDto.class);
    }

    public URI saveBeer(BeerDto beerDto) {
        return restTemplate.postForLocation(config.getApihost() + BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID beerId, BeerDto beerDto) {
        restTemplate.put(config.getApihost() + BEER_PATH_V1 + beerId, beerDto);
    }

    public void deleteBeer(UUID beerId) {
        restTemplate.delete(config.getApihost() + BEER_PATH_V1 + beerId);
    }

}
