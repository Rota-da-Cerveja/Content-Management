package br.com.rotadacerveja.API.service;

import org.springframework.stereotype.Service;

import br.com.rotadacerveja.API.dto.PublicationResponse;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
@RequiredArgsConstructor
public class PublicationService {

    private final Sinks.Many<PublicationResponse> publicationProducer;

    public Flux<PublicationResponse> getPublication(){
        return publicationProducer.asFlux();
    }
    
}
