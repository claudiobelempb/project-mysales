package br.com.surb.mysales.controllers.client;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import br.com.surb.mysales.dto.client.ClientDTO;
import br.com.surb.mysales.services.client.ClientCreateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/v1/clients")
@CrossOrigin("*")
public class ClientCreateController {
  private final ClientCreateService clientCreateService;

  public ClientCreateController(ClientCreateService clientCreateService) {
    this.clientCreateService = clientCreateService;
  }

  @PostMapping
  public CompletableFuture<ResponseEntity<ClientDTO>> handle(@RequestBody ClientDTO dto){
    ClientDTO response = clientCreateService.execute(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.id()).toUri();
    return supplyAsync(() -> response).thenApply((__) -> ResponseEntity.created(uri).body(response));
  }

}
