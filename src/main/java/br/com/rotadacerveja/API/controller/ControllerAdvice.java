package br.com.rotadacerveja.API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.rotadacerveja.API.exception.BreweryNotFoundException;

@org.springframework.web.bind.annotation.ControllerAdvice
@CrossOrigin
public class ControllerAdvice {
   @ExceptionHandler({BreweryNotFoundException.class})
  ResponseEntity<Void> handleBreweryNotFound(BreweryNotFoundException ex){
    return ResponseEntity.notFound().build();
  }
}
