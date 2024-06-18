package br.com.rotadacerveja.API.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public record BeerResponse(
  String name,
  @JsonProperty("minimum_temperature")
  Double minimumTemperature,
  @JsonProperty("maximum_temperature")
  Double maximumTemperature,
  Integer ibu,
  @JsonProperty("alcohol_content")
  Integer alcoholContent,
  String description,
  String type,
  Double volume,
  String brewery,
  String color,
  String glass,
  Integer body,
  Integer aroma,
  Integer malt,
  List<String> harmonization) {}
