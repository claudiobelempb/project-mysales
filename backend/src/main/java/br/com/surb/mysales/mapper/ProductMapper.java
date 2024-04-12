package br.com.surb.mysales.mapper;

import br.com.surb.mysales.dto.product.*;
import br.com.surb.mysales.entities.Product;

public final class ProductMapper {

  public static Product toRequest(ProductRequest request){
    Product response = new Product();
    response.setSku(request.sku());
    response.setName(request.name());
    response.setPrice(request.price());
    response.setDescription(request.description());
    return response;
  }

  public static ProductResponse toResponse(Product entity){
    return new ProductResponse(
      entity.getId(),
      entity.getSku(),
      entity.getName(),
      entity.getPrice(),
      entity.getDescription(),
      entity.getCreatedAt()
    );
  }

  public static Product toRequest(Product entity, ProductRequest request){
    entity.setSku(request.sku());
    entity.setName(request.name());
    entity.setPrice(request.price());
    entity.setDescription(request.description());
    return entity;
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
      entity.getDescription()
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
      entity.getDescription()

    );
  }

}
