package br.com.rotadacerveja.API.service;

import org.springframework.stereotype.Service;

import br.com.rotadacerveja.API.dto.ContentResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContentService {
    
    private final BreweryService breweryService;

    public ContentResponse getContent() {
        ContentResponse contentResponse = new ContentResponse(breweryService.findRandomBreweryNames());
        return contentResponse;
    }
}
