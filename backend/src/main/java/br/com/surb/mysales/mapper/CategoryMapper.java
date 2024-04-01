package br.com.surb.mysales.mapper;

import br.com.surb.mysales.dto.category.CategoryCustomRequest;
import br.com.surb.mysales.dto.category.CategoryCustomResponse;
import br.com.surb.mysales.dto.category.CategoryRequest;
import br.com.surb.mysales.dto.category.CategoryResponse;
import br.com.surb.mysales.dto.product.ProductCustomResponse;
import br.com.surb.mysales.entities.Category;
import br.com.surb.mysales.entities.Product;
import java.util.stream.Collectors;

public final class CategoryMapper {
  public static Category toRequest(CategoryRequest request){
    Category response = new Category();

    response.setId(request.id());
    response.setName(request.name());

    return response;
  }

  public static CategoryResponse toResponse(Category entity){
    return new CategoryResponse(
      entity.getId(),
      entity.getName()
      );
  }

  public static Category toCustomRequest(CategoryCustomRequest request){
    Category response = new Category();

    response.setId(request.id());
    response.setName(request.name());

    response.getProducts().clear();
    for(ProductCustomResponse prod: request.products()){
      Product product = new Product();
      product.setId(prod.id());
      response.getProducts().add(product);
    }

    return response;
  }

  public static CategoryCustomResponse toCustomResponse(Category entity){
    return new CategoryCustomResponse(
      entity.getId(),
      entity.getName(),
      entity.getProducts().stream().map(product -> new ProductCustomResponse(
        product.getId(),
        product.getSku(),
        product.getName(),
        product.getPrice(),
        product.getDescription(),
        product.getCategories().stream().map(category -> new CategoryResponse(category.getId(), category.getName())).collect(Collectors.toSet())
      )).collect(Collectors.toSet())
    );
  }

}