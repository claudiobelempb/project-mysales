package br.com.surb.mysales.resources.product;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import br.com.surb.mysales.dto.product.ProductRequest;
import br.com.surb.mysales.dto.product.ProductResponse;
import br.com.surb.mysales.services.product.ProductCreateService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/v1/products")
public class ProductCreateResource {

  private final ProductCreateService productCreateService;

  public ProductCreateResource(ProductCreateService productCreateService) {
    this.productCreateService = productCreateService;
  }

  @PostMapping
  public CompletableFuture<ResponseEntity<ProductResponse>> handle(@Valid @RequestBody ProductRequest dto) {
    ProductResponse obj = productCreateService.execute(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{productId}").buildAndExpand(obj.id()).toUri();
    return supplyAsync(() -> obj).thenApply((__) -> ResponseEntity.created(uri).body(obj));
  }
}
