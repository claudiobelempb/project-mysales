package br.com.surb.mysales.services.product;

import br.com.surb.mysales.dto.product.ProductResponse;
import br.com.surb.mysales.entities.Product;
import br.com.surb.mysales.mapper.ProductMapper;
import br.com.surb.mysales.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductFindAllService {
  private final ProductRepository productRepository;

  public ProductFindAllService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Transactional(readOnly = true)
  public Page<ProductResponse> execute(Pageable pageable) {
    Page<Product> products = productRepository.findAll(pageable);
    return ProductMapper.toPageResponse(products);
  }
}
