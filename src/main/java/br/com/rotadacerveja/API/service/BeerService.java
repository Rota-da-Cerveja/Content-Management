package br.com.rotadacerveja.API.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.rotadacerveja.API.dto.BeerResponse;
import br.com.rotadacerveja.API.entity.Beer;
import br.com.rotadacerveja.API.entity.Harmonization;
import br.com.rotadacerveja.API.repository.BeerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BeerService {
  
    private final BeerRepository beerRepository;

    public Optional<BeerResponse> findByName(String name) {
        return beerRepository.findByName(name.replace("-", " ")).map(this::convertToResponse);
    }

    private BeerResponse convertToResponse(Beer beer){
        return BeerResponse.builder()
        .name(beer.getName())
        .minimumTemperature(beer.getMinimumTemperature())
        .maximumTemperature(beer.getMaximumTemperature())
        .ibu(beer.getIbu())
        .alcoholContent(beer.getAlcoholContent())
        .description(beer.getDescription())
        .type(beer.getType())
        .volume(beer.getVolume())
        .brewery(beer.getBrewery().getName())
        .color(beer.getColor())
        .aroma(beer.getAroma())
        .body(beer.getBody())
        .malt(beer.getMalt())
        .glass(beer.getGlass())
        .harmonization(beer.getHarmonization().stream().map(Harmonization::getFood).toList())
        .build();
    }
}
