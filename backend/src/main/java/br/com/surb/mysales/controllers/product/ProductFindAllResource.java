package br.com.surb.mysales.controllers.product;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import br.com.surb.mysales.dto.product.ProductDTO;
import br.com.surb.mysales.services.product.ProductFindAllService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/v1/products")
@CrossOrigin("*")
public class ProductFindAllResource {
  private final ProductFindAllService productFindAllService;

  public ProductFindAllResource(ProductFindAllService productFindAllService) {
    this.productFindAllService = productFindAllService;
  }

  @GetMapping()
  public CompletableFuture<ResponseEntity<Page<ProductDTO>>> handle(Pageable pageable) {
    return supplyAsync(() -> productFindAllService.execute(pageable)).thenApply((product) -> ResponseEntity.ok().body(product));
  }
}
