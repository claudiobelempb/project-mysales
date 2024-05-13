package br.com.surb.mysales.controllers.client;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import br.com.surb.mysales.dto.client.ClientDTO;
import br.com.surb.mysales.services.client.ClientFindByIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/v1/clients")
@CrossOrigin("*")
public class ClientFindByIdController {
  private final ClientFindByIdService clientFindByIdService;

  public ClientFindByIdController(ClientFindByIdService clientFindByIdService) {
    this.clientFindByIdService = clientFindByIdService;
  }

  @GetMapping(value = "/{id}")
  public CompletableFuture<ResponseEntity<ClientDTO>> handle(@PathVariable Long id) {
    return supplyAsync(() -> clientFindByIdService.execute(id)).thenApply((product) -> ResponseEntity.ok().body(product));
  }
}
