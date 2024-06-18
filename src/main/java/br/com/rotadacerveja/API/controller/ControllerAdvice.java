package br.com.rotadacerveja.API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.rotadacerveja.API.exception.NotFoundException;

@org.springframework.web.bind.annotation.ControllerAdvice
@CrossOrigin
public class ControllerAdvice {
   @ExceptionHandler({NotFoundException.class})
  ResponseEntity<Void> handleBreweryNotFound(NotFoundException ex){
    return ResponseEntity.notFound().build();
  }
}
