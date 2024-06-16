package br.com.rotadacerveja.API.exception;

public class BreweryNotFoundException extends RuntimeException {
  public BreweryNotFoundException(){
    super("Brewery Not Found");
  }
}
