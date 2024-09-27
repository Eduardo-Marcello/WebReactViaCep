package br.com.marcello.webclient.Controller;

import br.com.marcello.webclient.model.ViaCepResponse;
import br.com.marcello.webclient.service.ViaCepClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class ViaCepClientController {
    private final ViaCepClient viaCepClient;


    @GetMapping("{cep}")
    public Mono<ViaCepResponse> getCepInfo(@PathVariable String cep) {
        return viaCepClient.getCepInfo(cep);
    }
}
