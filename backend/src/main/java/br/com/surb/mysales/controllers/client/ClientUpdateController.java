package br.com.surb.mysales.controllers.client;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import br.com.surb.mysales.dto.client.ClientDTO;
import br.com.surb.mysales.services.client.ClientUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/v1/clients")
@CrossOrigin("*")
public class ClientUpdateController {
  private final ClientUpdateService clientUpdateService;

  public ClientUpdateController(ClientUpdateService clientUpdateService) {
    this.clientUpdateService = clientUpdateService;
  }

  @PutMapping(value = "/{id}")
  public CompletableFuture<ResponseEntity<ClientDTO>> handle(
    @PathVariable Long id,
    @RequestBody ClientDTO request
  ) {
    return supplyAsync(() -> clientUpdateService.execute(id, request))
      .thenApply((response) -> ResponseEntity.ok().body(response));
  }
}
