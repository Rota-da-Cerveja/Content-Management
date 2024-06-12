package br.com.rotadacerveja.API.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.rotadacerveja.API.dto.PublicationResponse;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Sinks;

@Component
@RequiredArgsConstructor
public class GeneretadPublicationService {
    
    private final Sinks.Many<PublicationResponse> publicationProducer;
    private final AtomicInteger count = new AtomicInteger();


    @Scheduled(fixedRate = 1000)
    public void generate(){
        System.out.println(count.getAndIncrement());
    }

}
