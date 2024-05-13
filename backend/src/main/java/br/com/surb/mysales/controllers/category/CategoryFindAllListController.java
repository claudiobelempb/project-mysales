package br.com.surb.mysales.controllers.category;

import br.com.surb.mysales.entities.Category;
import br.com.surb.mysales.services.category.CategoryFindAllListService;
import br.com.surb.mysales.shared.models.FilterModel;
import br.com.surb.mysales.shared.models.PageFilterModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/categories")
public class CategoryFindAllListController {
  private final CategoryFindAllListService categoryFindAllListService;

  public CategoryFindAllListController(CategoryFindAllListService categoryFindAllListService) {
    this.categoryFindAllListService = categoryFindAllListService;
  }

  @GetMapping(value = "/lists")
  public ResponseEntity<PageFilterModel<Category>> handle(
    @RequestParam Map<String, String>  params
  ){
    FilterModel filter = new FilterModel(params);
    PageFilterModel<Category> categories = categoryFindAllListService.execute(filter);
    return ResponseEntity.ok(categories);
  }
}
