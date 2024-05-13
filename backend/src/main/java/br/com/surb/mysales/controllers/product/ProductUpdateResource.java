package br.com.surb.mysales.controllers.product;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import br.com.surb.mysales.dto.product.ProductRequest;
import br.com.surb.mysales.dto.product.ProductDTO;
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
  public CompletableFuture<ResponseEntity<ProductDTO>> handle(
      @PathVariable Long id, @RequestBody ProductDTO dto
  ) {
    return supplyAsync(() -> productUpdateService.execute(id, dto)).thenApply((entity) -> ResponseEntity.ok().body(entity));
  }
}
