package br.com.surb.mysales.services.product;

import br.com.surb.mysales.dto.category.CategoryResponse;
import br.com.surb.mysales.dto.product.ProductCreateRequest;
import br.com.surb.mysales.dto.product.ProductCreateResponse;
import br.com.surb.mysales.entities.Category;
import br.com.surb.mysales.entities.Product;
import br.com.surb.mysales.mapper.ProductMapper;
import br.com.surb.mysales.repositories.CategoryRepository;
import br.com.surb.mysales.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProductCreateService {
  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;

  public ProductCreateService(ProductRepository productRepository, CategoryRepository categoryRepository) {
    this.productRepository = productRepository;
    this.categoryRepository = categoryRepository;
  }

  @Transactional
  public ProductCreateResponse execute(ProductCreateRequest request) {
    Product entity = ProductMapper.toCreateRequest(request);
    entity.getCategories().clear();

    for (CategoryResponse cat: request.categories()){
      Category category = categoryRepository.getReferenceById(cat.id());
      entity.getCategories().add(category);
    }
    entity = productRepository.save(entity);
    return ProductMapper.toCreateResponse(entity);

  }
}
