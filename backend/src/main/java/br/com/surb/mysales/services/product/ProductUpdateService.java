package br.com.surb.mysales.services.product;

import br.com.surb.mysales.dto.product.ProductRequest;
import br.com.surb.mysales.dto.product.ProductResponse;
import br.com.surb.mysales.entities.Product;
import br.com.surb.mysales.mapper.ProductMapper;
import br.com.surb.mysales.repositories.ProductRepository;
import br.com.surb.mysales.shared.constants.ConstantException;
import br.com.surb.mysales.shared.exeptions.resources.ResourceNotFondExecption;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductUpdateService {
  private final ProductRepository productRepository;

  public ProductUpdateService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Transactional
  public ProductResponse execute(Long id, ProductRequest request) {
    try {
      Product entity = productRepository.getReferenceById(id);
      entity = ProductMapper.toRequest(entity, request);
      entity = productRepository.save(entity);
      return ProductMapper.toResponse(entity);
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFondExecption(ConstantException.ENTITY_NOT_FOUND);
    }

  }

}
