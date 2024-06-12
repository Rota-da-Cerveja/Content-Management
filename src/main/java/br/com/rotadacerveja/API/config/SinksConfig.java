package br.com.rotadacerveja.API.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.rotadacerveja.API.dto.PublicationResponse;
import reactor.core.publisher.Sinks;

@Configuration
public class SinksConfig {

    @Bean
    public Sinks.Many<PublicationResponse> publicationProducer() {
        return Sinks.many().multicast().onBackpressureBuffer();
    }
}
