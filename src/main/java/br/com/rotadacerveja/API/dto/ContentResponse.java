package br.com.rotadacerveja.API.dto;

import java.util.List;

public record ContentResponse(List<String> breweries, List<PartialBeerResponse> beers) {}
