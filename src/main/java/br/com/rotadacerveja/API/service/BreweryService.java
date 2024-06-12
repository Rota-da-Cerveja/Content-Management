package br.com.rotadacerveja.API.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.rotadacerveja.API.repository.BreweryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BreweryService {

    private final BreweryRepository breweryRepository;

    private static Logger logger = LoggerFactory.getLogger(BreweryService.class);

    @Value("${brewery.limit:6}")
    private int limit;

    public List<String> findRandomBreweryNames(){
        logger.info("Limit: "+limit);
        return breweryRepository.findRandomBreweryNames(limit);
    }

}
