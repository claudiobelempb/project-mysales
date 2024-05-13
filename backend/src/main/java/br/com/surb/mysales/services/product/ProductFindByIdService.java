package br.com.surb.mysales.services.product;

import br.com.surb.mysales.dto.product.ProductDTO;
import br.com.surb.mysales.entities.Product;
import br.com.surb.mysales.mapper.ProductMapper;
import br.com.surb.mysales.repositories.ProductRepository;
import br.com.surb.mysales.shared.constants.ConstantException;
import br.com.surb.mysales.shared.exeptions.resources.ResourceNotFondExecption;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Objects;

@Service
public class ProductFindByIdService {
  private final ProductRepository productRepository;

  public ProductFindByIdService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Transactional(readOnly = true)
  public ProductDTO execute(Long id) {
    Objects.requireNonNull(id);
    Product response = productRepository
      .findById(id)
      .orElseThrow(() -> new ResourceNotFondExecption(ConstantException.ENTITY_NOT_FOUND));
    return ProductMapper.toDTO(response);
  }
}
