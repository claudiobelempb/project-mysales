package br.com.surb.mysales.controllers.product;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import br.com.surb.mysales.dto.product.ProductDTO;
import br.com.surb.mysales.services.product.ProductFindByIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/v1/products")
@CrossOrigin("*")
public class ProductFindByIdResource {

  private final ProductFindByIdService productFindByIdService;

  public ProductFindByIdResource(ProductFindByIdService productFindByIdService) {
    this.productFindByIdService = productFindByIdService;
  }

  @GetMapping(value = "/{id}")
  public CompletableFuture<ResponseEntity<ProductDTO>> handle(@PathVariable Long id) {
    Objects.isNull(id);
    return supplyAsync(() -> productFindByIdService.execute(id)).thenApply((response) -> ResponseEntity.ok().body(response));
  }
}
