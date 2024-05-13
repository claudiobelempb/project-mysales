package br.com.surb.mysales.services.product;

import br.com.surb.mysales.dto.product.ProductRequest;
import br.com.surb.mysales.dto.product.ProductDTO;
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
  public ProductDTO execute(Long id, ProductDTO dto) {
    try {
      Product entity = productRepository.getReferenceById(id);
      entity = ProductMapper.toEntityDTO(entity, dto);
      entity = productRepository.save(entity);
      return ProductMapper.toDTO(entity);
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFondExecption(ConstantException.ENTITY_NOT_FOUND);
    }

  }

}
