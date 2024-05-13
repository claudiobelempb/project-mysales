package br.com.surb.mysales.controllers.product;

import br.com.surb.mysales.entities.Product;
import br.com.surb.mysales.services.product.ProductFindAllListService;
import br.com.surb.mysales.shared.models.FilterModel;
import br.com.surb.mysales.shared.models.PageFilterModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/products")
public class ProductFindAllListController {
  private final ProductFindAllListService productFindAllListService;

  public ProductFindAllListController(ProductFindAllListService productFindAllListService) {
    this.productFindAllListService = productFindAllListService;
  }

  /*@GetMapping(value = "/lists")
  public ResponseEntity<List<Product>> handle(){
    List<Product> products = productFindAllListService.execute();
    return ResponseEntity.ok(products);
  }*/

  @GetMapping(value = "/lists")
  public ResponseEntity<PageFilterModel<Product>> handle(
    @RequestParam Map<String, String> params
  ){
    FilterModel filter = new FilterModel(params);
    PageFilterModel<Product> products = productFindAllListService.execute(filter);
    return ResponseEntity.ok(products);
  }
}
