package com.lessercodes.msscbreweryclient.web.client;

import java.util.UUID;

import com.lessercodes.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lessercodes.msscbreweryclient.web.model.BeerDto;

import lombok.val;

@SpringBootTest
public class BreweryClientTest {

    @Autowired
    private BreweryClient client;

    @Test
    void getBeer() {
        val beerDto = client.getBeer(UUID.randomUUID());
        Assertions.assertNotNull(beerDto);
    }

    @Test
    void saveBeer() {
        val beerDto = BeerDto.builder().beerName("New Beer").build();
        val beerUri = client.saveBeer(beerDto);
        Assertions.assertNotNull(beerUri);
    }

    @Test
    void updateBeer() {
        val beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("Updated Beer").build();
        client.updateBeer(beerDto.getId(), beerDto);
    }

    @Test
    void deleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomer() {
        val customerDto = client.getCustomer(UUID.randomUUID());
        Assertions.assertNotNull(customerDto);
    }

    @Test
    void saveCustomer() {
        val customerDto = CustomerDto.builder().name("New Customer").build();
        val customerLocation = client.saveCustomer(customerDto);
        Assertions.assertNotNull(customerLocation);
    }

    @Test
    void updateCustomer() {
        val customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("Updated Customer").build();
        client.updateCustomer(customerDto.getId(), customerDto);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }

}
