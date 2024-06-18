package br.com.rotadacerveja.API.service;

import org.springframework.stereotype.Service;

import br.com.rotadacerveja.API.dto.ContentResponse;
import br.com.rotadacerveja.API.dto.PartialBeerResponse;
import br.com.rotadacerveja.API.entity.Beer;
import br.com.rotadacerveja.API.repository.BeerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContentService {
    
    private final BreweryService breweryService;
    private final BeerRepository beerRepository;

    public ContentResponse getContent() {
        ContentResponse contentResponse = new ContentResponse(breweryService.findRandomBreweryNames(), beerRepository.findRandomBeers().stream().map(this::convertResponse).toList());
        return contentResponse;
    }

    private PartialBeerResponse convertResponse(Beer beer){
        return new PartialBeerResponse(beer.getName(), beer.getDescription());
    }
}
