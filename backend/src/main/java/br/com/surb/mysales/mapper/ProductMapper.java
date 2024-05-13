package br.com.surb.mysales.mapper;

import br.com.surb.mysales.dto.category.CategoryDTO;
import br.com.surb.mysales.dto.product.ProductCreateDTO;
import br.com.surb.mysales.dto.product.ProductCustomDTO;
import br.com.surb.mysales.dto.product.ProductDTO;
import br.com.surb.mysales.dto.supplier.SupplierDTO;
import br.com.surb.mysales.entities.Category;
import br.com.surb.mysales.entities.Product;
import br.com.surb.mysales.entities.Supplier;
import br.com.surb.mysales.repositories.CategoryRepository;
import br.com.surb.mysales.repositories.SupplierRepository;
import org.springframework.data.domain.Page;

public final class ProductMapper {

  public static ProductDTO toDTO(Product entity){
    return new ProductDTO(
      entity.getId(),
      entity.getSku(),
      entity.getName(),
      entity.getStock(),
      entity.getPrice(),
      entity.getDescription()
    );
  }

  public static Product toEntity(ProductDTO dto){
    if (dto == null) {
      return null;
    }
    Product entity = new Product();
    entity.setName(dto.name());
    entity.setPrice(dto.price());
    entity.setDescription(dto.description());

    return entity;
  }

  public static Product toEntityDTO(Product entity, ProductDTO dto){
    if (dto == null) {
      return null;
    }
    entity.setId(dto.id());
    entity.setSku(dto.sku());
    entity.setStock(dto.stock());
    entity.setName(dto.name());
    entity.setPrice(dto.price());
    entity.setDescription(dto.description());

    return entity;
  }

  public static ProductCreateDTO toCreateDTO(
    Product entity
  ){
    if (entity == null) {
      return null;
    }
    return new ProductCreateDTO(
      entity.getId(),
      entity.getSku(),
      entity.getName(),
      entity.getPrice(),
      entity.getStock(),
      entity.getDescription(),
      new CategoryDTO(entity.getCategory().getId(), entity.getCategory().getName()),
      new SupplierDTO(entity.getSupplier().getId(), entity.getSupplier().getName())
    );
  }

  public static Product toCreateEntity(
    ProductCreateDTO dto,
    CategoryRepository categoryRepository,
    SupplierRepository supplierRepository
  ){
    if (dto == null) {
      return null;
    }
    Product entity = new Product();
    entity.setName(dto.name());
    entity.setStock(dto.stock());
    entity.setPrice(dto.price());
    entity.setDescription(dto.description());
    entity.setCategory(new Category(dto.category().id(), dto.category().name()));
    /*entity.setCategory(categoryRepository.getReferenceById(dto.category().id()));*/
    entity.setSupplier(new Supplier(dto.supplier().id(), dto.supplier().name()));
    /*entity.setSupplier(supplierRepository.getReferenceById(dto.supplier().id()));*/
    return entity;
  }

  public static Page<ProductDTO> toPageResponse(Page<Product> products){
    if (products == null) {
      return null;
    }
    return products.map(response -> new ProductDTO(
      response.getId(),
      response.getSku(),
      response.getName(),
      response.getStock(),
      response.getPrice(),
      response.getDescription()
    ));
  }

}
