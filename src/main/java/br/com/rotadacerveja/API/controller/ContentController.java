package br.com.rotadacerveja.API.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rotadacerveja.API.dto.ContentResponse;
import br.com.rotadacerveja.API.service.ContentService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("content")
@CrossOrigin
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @GetMapping

    public ResponseEntity<Mono<ContentResponse>> generatedContent(){
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just(contentService.getContent()));
    }

}
