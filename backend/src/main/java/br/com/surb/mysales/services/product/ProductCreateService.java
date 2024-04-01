package br.com.surb.mysales.services.product;

import br.com.surb.mysales.dto.product.ProductCreateRequest;
import br.com.surb.mysales.dto.product.ProductCreateResponse;
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
  public ProductCreateResponse execute(ProductCreateRequest request) {
    Product entity = ProductMapper.toCreateRequest(request);
    entity = productRepository.save(entity);
    return ProductMapper.toCreateResponse(entity);

  }
}
