package br.com.rotadacerveja.API.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PublicationResponse(
  String author, 
  @JsonProperty("publication_date")
  LocalDateTime publicationDate, 
  String summary) {
}
