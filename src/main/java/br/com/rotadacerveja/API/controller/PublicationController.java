package br.com.rotadacerveja.API.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rotadacerveja.API.dto.PublicationResponse;
import br.com.rotadacerveja.API.service.PublicationService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("publication")
@RequiredArgsConstructor
@CrossOrigin
public class PublicationController {

    private final PublicationService publicationService;
    
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<PublicationResponse> getPublications(){
        return publicationService.getPublication();
    }
}
