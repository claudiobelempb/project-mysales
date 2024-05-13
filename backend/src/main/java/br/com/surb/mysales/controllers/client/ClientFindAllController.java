package br.com.surb.mysales.controllers.client;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import br.com.surb.mysales.dto.client.ClientDTO;
import br.com.surb.mysales.services.client.ClientFindAllService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/v1/clients")
@CrossOrigin("*")
public class ClientFindAllController {
  private final ClientFindAllService clientFindAllService;

  public ClientFindAllController(ClientFindAllService clientFindAllService) {
    this.clientFindAllService = clientFindAllService;
  }

  @GetMapping
  public CompletableFuture<ResponseEntity<Page<ClientDTO>>> handle(
    Pageable pageable
  ) {
    return supplyAsync(() -> clientFindAllService.execute(pageable)).thenApply((product) -> ResponseEntity.ok().body(product));
  }
}
