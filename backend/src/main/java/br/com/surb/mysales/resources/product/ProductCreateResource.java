package br.com.surb.mysales.resources.product;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import br.com.surb.mysales.dto.product.ProductCreateRequest;
import br.com.surb.mysales.dto.product.ProductCreateResponse;
import br.com.surb.mysales.dto.product.ProductRequest;
import br.com.surb.mysales.dto.product.ProductResponse;
import br.com.surb.mysales.services.product.ProductCreateService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/v1/products")
@CrossOrigin("*")
public class ProductCreateResource {

  private final ProductCreateService productCreateService;

  public ProductCreateResource(ProductCreateService productCreateService) {
    this.productCreateService = productCreateService;
  }

  @PostMapping
  public CompletableFuture<ResponseEntity<ProductCreateResponse>> handle(@Valid @RequestBody ProductCreateRequest request) {
    ProductCreateResponse response = productCreateService.execute(request);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{productId}").buildAndExpand(response.id()).toUri();
    return supplyAsync(() -> response).thenApply((__) -> ResponseEntity.created(uri).body(response));
  }
}
