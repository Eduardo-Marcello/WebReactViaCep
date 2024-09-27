package br.com.marcello.webclient.service;

import br.com.marcello.webclient.model.ViaCepResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ViaCepClient {
    private final WebClient webClient;

    public ViaCepClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://viacep.com.br/ws/").build();
    }

    public Mono<ViaCepResponse> getCepInfo(String cep) {
        return webClient.get()
                .uri("{cep}/json", cep)
                .retrieve()
                .bodyToMono(ViaCepResponse.class);
    }
}
