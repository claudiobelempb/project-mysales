package br.com.surb.mysales.controllers.product;

import static java.util.concurrent.CompletableFuture.runAsync;
import br.com.surb.mysales.services.product.ProductDeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/v1/products")
@CrossOrigin("*")
public class ProductDeleteResource {
  private final ProductDeleteService productDeleteService;

  public ProductDeleteResource(ProductDeleteService productDeleteService) {
    this.productDeleteService = productDeleteService;
  }

  @DeleteMapping(value = "/{id}")
  public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable Long id) {
    return runAsync(() -> productDeleteService.execute(id))
      .thenApply((__) -> ResponseEntity.noContent().build());
  }
}
