package br.com.rotadacerveja.API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rotadacerveja.API.dto.BeerResponse;
import br.com.rotadacerveja.API.exception.NotFoundException;
import br.com.rotadacerveja.API.service.BeerService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("beer")
@CrossOrigin
@RequiredArgsConstructor
public class BeerController {

  private final BeerService beerService;

   @GetMapping("/{name}")
  public ResponseEntity<Mono<BeerResponse>> getBeer(@PathVariable String name){
    System.out.println(name);
    return beerService.findByName(name)
    .map(b -> ResponseEntity.ok(Mono.just(b)))
    .orElseThrow(() -> new NotFoundException());
  }
}
