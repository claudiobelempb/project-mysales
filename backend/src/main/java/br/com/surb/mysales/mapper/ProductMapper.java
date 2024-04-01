package br.com.surb.mysales.mapper;

import br.com.surb.mysales.dto.category.CategoryResponse;
import br.com.surb.mysales.dto.product.*;
import br.com.surb.mysales.entities.Category;
import br.com.surb.mysales.entities.Product;
import java.util.stream.Collectors;

public final class ProductMapper {
  public static Product toRequest(ProductRequest request){
    Product response = new Product();

    response.setId(request.id());
    response.setSku(request.sku());
    response.setName(request.name());
    response.setDescription(request.description());

    return response;
  }

  public static ProductResponse toResponse(Product entity){
    return new ProductResponse(
      entity.getId(),
      entity.getSku(),
      entity.getName(),
      entity.getPrice(),
      entity.getDescription()
    );
  }

  public static Product toCreateRequest(ProductCreateRequest request){
    if (request == null) {
      return null;
    }
    Product response = new Product();

    response.setId(request.id());
    response.setSku(request.sku());
    response.setName(request.name());
    response.setPrice(request.price());
    response.setDescription(request.description());

    response.getCategories().clear();
    for (CategoryResponse cat: request.categories()){
      Category category = new Category();
      category.setId(cat.id());
      category.setName(cat.name());
      response.getCategories().add(category);
    }

    return response;
  }

  public static ProductCreateResponse toCreateResponse(Product entity){
    if (entity == null) {
      return null;
    }
    return new ProductCreateResponse(
      entity.getId(),
      entity.getName(),
      entity.getSku(),
      entity.getPrice(),
      entity.getDescription(),
      entity.getCategories()
        .stream()
        .map(category -> new CategoryResponse(
          category.getId(),
          category.getName()))
        .collect(Collectors.toSet())
    );
  }

  public static Product toCustomRequest(ProductCustomRequest request){
    if (request == null) {
      return null;
    }
    Product response = new Product();

    response.setId(request.id());
    response.setSku(request.sku());
    response.setName(request.name());
    response.setPrice(request.price());
    response.setDescription(request.description());

    response.getCategories().clear();
    for (CategoryResponse cat: request.categories()){
      Category category = new Category();
      category.setId(cat.id());
      category.setName(cat.name());
      response.getCategories().add(category);
    }

    return response;
  }

  public static ProductCustomResponse toCustomResponse(Product entity){
    if (entity == null) {
      return null;
    }
    return new ProductCustomResponse(
      entity.getId(),
      entity.getName(),
      entity.getSku(),
      entity.getPrice(),
      entity.getDescription(),
      entity.getCategories()
        .stream()
        .map(category -> new CategoryResponse(
          category.getId(),
          category.getName()))
        .collect(Collectors.toSet())
    );
  }

}
