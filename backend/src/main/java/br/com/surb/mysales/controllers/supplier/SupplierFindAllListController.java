package br.com.surb.mysales.controllers.supplier;

import br.com.surb.mysales.entities.Supplier;
import br.com.surb.mysales.services.supplier.SupplierFindAllListService;
import br.com.surb.mysales.shared.models.FilterModel;
import br.com.surb.mysales.shared.models.PageFilterModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/suppliers")
public class SupplierFindAllListController {
  private final SupplierFindAllListService supplierFindAllListService;

  public SupplierFindAllListController(SupplierFindAllListService supplierFindAllListService) {
    this.supplierFindAllListService = supplierFindAllListService;
  }

  /*@GetMapping(value = "/lists")
  public ResponseEntity<List<Supplier>> handle(){
    List<Supplier> suppliers = supplierFindAllListService.execute();
    return ResponseEntity.ok(suppliers);
  }*/

  @GetMapping(value = "/lists")
  public ResponseEntity<PageFilterModel<Supplier>> handle(
    @RequestParam Map<String, String> params
  ){
    FilterModel filter = new FilterModel(params);
    PageFilterModel<Supplier> categories = supplierFindAllListService.execute(filter);
    return ResponseEntity.ok(categories);
  }
}
