package br.com.rotadacerveja.API.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rotadacerveja.API.service.PublicationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("publication")
@RequiredArgsConstructor
public class PublicationController {

    private final PublicationService publicationService;
    
}
