package br.com.surb.mysales.mapper;

import br.com.surb.mysales.dto.product.ProductRequest;
import br.com.surb.mysales.dto.product.ProductResponse;
import br.com.surb.mysales.entities.Product;

public final class ProductMapper {
  public static Product toRequest(ProductRequest request){
    return Product.builder()
      .id(request.id())
      .sku(request.sku())
      .name(request.name())
      .price(request.price())
      .description(request.description())
      .build();
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

}
