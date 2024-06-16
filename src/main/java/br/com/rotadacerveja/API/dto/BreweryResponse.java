package br.com.rotadacerveja.API.dto;

import java.util.List;

public record BreweryResponse(String name, String brewmaster, String description, List<Float> location) {

}
