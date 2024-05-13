package br.com.surb.mysales.controllers.client;

import static java.util.concurrent.CompletableFuture.runAsync;
import br.com.surb.mysales.services.client.ClientDeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/v1/clients")
@CrossOrigin("*")
public class ClientDeleteController {
  private final ClientDeleteService clientDeleteService;

  public ClientDeleteController(ClientDeleteService clientDeleteService) {
    this.clientDeleteService = clientDeleteService;
  }

  @DeleteMapping(value = "/{id}")
  public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable Long id) {
    return runAsync(() -> clientDeleteService.execute(id))
      .thenApply((__) -> ResponseEntity.noContent().build());
  }
}
