package br.com.rotadacerveja.API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rotadacerveja.API.dto.BreweryResponse;
import br.com.rotadacerveja.API.exception.BreweryNotFoundException;
import br.com.rotadacerveja.API.service.BreweryService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("brewery")
@RequiredArgsConstructor
@CrossOrigin
public class BreweryController {

  private final BreweryService breweryService;

  @GetMapping("/{name}")
  public ResponseEntity<Mono<BreweryResponse>> getBrewery(@PathVariable String name){
    System.out.println(name);

    return breweryService.findByName(name)
    .map(b -> ResponseEntity.ok(Mono.just(b)))
    .orElseThrow(() -> new BreweryNotFoundException());
  }
}
