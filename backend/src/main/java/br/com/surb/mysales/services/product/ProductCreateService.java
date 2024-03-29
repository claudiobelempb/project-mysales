package br.com.surb.mysales.services.product;

import br.com.surb.mysales.dto.product.ProductRequest;
import br.com.surb.mysales.dto.product.ProductResponse;
import br.com.surb.mysales.entities.Product;
import br.com.surb.mysales.mapper.ProductMapper;
import br.com.surb.mysales.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProductCreateService {
  private final ProductRepository productRepository;

  public ProductCreateService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Transactional
  public ProductResponse execute(ProductRequest request) {
    Product entity = ProductMapper.toRequest(request);
    entity = productRepository.save(entity);
    return ProductMapper.toResponse(entity);
  }
}
