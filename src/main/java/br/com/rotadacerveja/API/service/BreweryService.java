package br.com.rotadacerveja.API.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.rotadacerveja.API.dto.BreweryResponse;
import br.com.rotadacerveja.API.entity.Brewery;
import br.com.rotadacerveja.API.repository.BreweryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BreweryService {

    private final BreweryRepository breweryRepository;

    private static Logger logger = LoggerFactory.getLogger(BreweryService.class);

    @Value("${brewery.limit:6}")
    private int limit;

    public List<String> findRandomBreweryNames() {
        logger.info("Limit: " + limit);
        return breweryRepository.findRandomBreweryNames(limit);
    }

    public Optional<BreweryResponse> findByName(String name) {
        return breweryRepository.findByName(name.replace("-", " ")).map(this::convertToResponse);
    }

    private BreweryResponse convertToResponse(Brewery brewery) {

        return BreweryResponse.builder()
                .name(brewery.getName())
                .description(brewery.getDescription())
                .brewmaster(brewery.getBrewmaster())
                .latitude(brewery.getLatitude())
                .longitude(brewery.getLongitude())
                .beers(brewery.getBeers().stream().map(b -> b.getName()).toList())
                .build();
    }
}
