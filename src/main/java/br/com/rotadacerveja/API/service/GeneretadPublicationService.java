package br.com.rotadacerveja.API.service;

import java.time.LocalDateTime;
import java.util.Random;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.rotadacerveja.API.dto.PublicationResponse;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Sinks;

@Component
@RequiredArgsConstructor
public class GeneretadPublicationService {

    private static String[] persons = { "BrewMaster", "Cervejeiro123", "LúpuloLovers", "MalteMania", "BrewBrothers", "CervejaNaVeia", "ArtesanalBrasil", "HopHead", "CervejaArte", "BrewBuzz", "MalteEBreu", "LúpuloLivre", "BeerNerd", "CervejaCriativa", "ArtesanalGourmet", "Cerveja&Cultura", "BrewTalks", "CervejaDoMês", "HopCraft", "BrewBliss"};

    private static String[] contents = {"Experimentamos a nova IPA com lúpulos exclusivos do Brasil. Sensacional!", "Uma stout envelhecida em barris de carvalho. Sabor intenso e complexo!", "Nova Pilsen com toques de maracujá, refrescante e perfeita para o verão.", "Hoje vamos falar sobre a importância do malte na produção de cervejas artesanais.", "Lançamento da nova linha de cervejas frutadas, venha conferir!", "Degustação às cegas com cervejas artesanais locais. Resultados surpreendentes!", "Dicas para harmonizar sua cerveja com pratos típicos brasileiros.", "IPA duplo lúpulo da semana: notas cítricas e amargor equilibrado.", "Explorando as tendências de cervejas ácidas e sour.", "Novo rótulo da nossa premiada Witbier já está disponível.", "Participamos de um festival de cervejas artesanais e trouxemos as melhores dicas.", "Como fazer uma cerveja artesanal em casa: guia passo a passo.", "Os melhores estilos de cerveja para o inverno: dicas e sugestões.", "A influência das leveduras na complexidade das cervejas.", "Cerveja e gastronomia: combinando sabores e aromas.", "Entrevista exclusiva com o mestre cervejeiro da Cervejaria XYZ.", "O que é dry hopping e como ele influencia o sabor da cerveja.", "Conheça a cerveja do mês: uma Red Ale com toques de caramelo.", "Tour virtual pela fábrica de cerveja artesanal HopCraft. Não perca!", "Os benefícios das cervejas artesanais para a saúde quando consumidas com moderação."};

    private final Sinks.Many<PublicationResponse> publicationProducer;
    private final Random rng = new Random();
    private final Sinks.EmitFailureHandler emitFailureHandler = (signalType, emitResult) -> emitResult
            .equals(Sinks.EmitResult.FAIL_NON_SERIALIZED) ? true : false;

    @Scheduled(fixedRate = 3000)
    public void generate() {
        String person = persons[rng.nextInt(persons.length)];
        String content = contents[rng.nextInt(contents.length)];
        PublicationResponse publication = new PublicationResponse(person, LocalDateTime.now(), content);
        publicationProducer.emitNext(publication, emitFailureHandler);
    }

}
