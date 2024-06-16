package br.com.rotadacerveja.API.dto;

import java.util.List;

import lombok.Builder;

@Builder
public record BreweryResponse(String name, String brewmaster, String description, Float latitude, Float longitude,
    List<String> beers) {
}
