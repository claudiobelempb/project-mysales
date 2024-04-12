package br.com.surb.mysales.services.product;

import br.com.surb.mysales.dto.product.ProductRequest;
import br.com.surb.mysales.dto.product.ProductResponse;
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
  public ProductResponse execute(ProductRequest request) {
    Product response = ProductMapper.toRequest(request);
    System.out.println(response);
    System.out.println(response.getId());
    response = productRepository.save(response);
    return ProductMapper.toResponse(response);

  }
}
