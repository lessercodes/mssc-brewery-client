package com.lessercodes.msscbreweryclient;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@ConfigurationProperties(prefix = "sfg.brewery")
@ConstructorBinding
public class Config {

    private final String apihost;

}
