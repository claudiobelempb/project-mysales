package br.com.surb.mysales.resources.product;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import br.com.surb.mysales.dto.product.ProductRequest;
import br.com.surb.mysales.dto.product.ProductResponse;
import br.com.surb.mysales.services.product.ProductUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/v1/products")
@CrossOrigin("*")
public class ProductUpdateResource {

  private final ProductUpdateService productUpdateService;

  public ProductUpdateResource(ProductUpdateService productUpdateService) {
    this.productUpdateService = productUpdateService;
  }

  @PutMapping(value = "/{id}")
  public CompletableFuture<ResponseEntity<ProductResponse>> handle(
      @PathVariable Long id, @RequestBody ProductRequest request
  ) {
    return supplyAsync(() -> productUpdateService.execute(id, request)).thenApply((entity) -> ResponseEntity.ok().body(entity));
  }
}
