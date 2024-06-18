package br.com.rotadacerveja.API.exception;

public class NotFoundException extends RuntimeException {
  public NotFoundException(){
    super("Brewery Not Found");
  }
}
