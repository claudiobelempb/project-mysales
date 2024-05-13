package br.com.surb.mysales.mapper;

import br.com.surb.mysales.dto.category.CategoryCustomRequest;
import br.com.surb.mysales.dto.category.CategoryCustomResponse;
import br.com.surb.mysales.dto.category.CategoryRequest;
import br.com.surb.mysales.dto.category.CategoryDTO;
import br.com.surb.mysales.entities.Category;

public final class CategoryMapper {
  public static Category toRequest(CategoryRequest request){
    Category response = new Category();

    response.setId(request.id());
    response.setName(request.name());

    return response;
  }

  public static CategoryDTO toResponse(Category entity){
    return new CategoryDTO(
      entity.getId(),
      entity.getName()
      );
  }

  public static Category toCustomRequest(CategoryCustomRequest request){
    Category response = new Category();

    response.setId(request.id());
    response.setName(request.name());

    return response;
  }

  public static CategoryCustomResponse toCustomResponse(Category entity){
    return new CategoryCustomResponse(
      entity.getId(),
      entity.getName()
    );
  }

}
