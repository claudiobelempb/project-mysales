package br.com.surb.mysales.services.product;

import br.com.surb.mysales.dto.product.ProductCreateDTO;
import br.com.surb.mysales.dto.product.ProductDTO;
import br.com.surb.mysales.entities.Product;
import br.com.surb.mysales.mapper.ProductMapper;
import br.com.surb.mysales.repositories.CategoryRepository;
import br.com.surb.mysales.repositories.ProductRepository;
import br.com.surb.mysales.repositories.SupplierRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProductCreateService {
  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;
  private final SupplierRepository supplierRepository;

  public ProductCreateService(ProductRepository productRepository, CategoryRepository categoryRepository, SupplierRepository supplierRepository) {
    this.productRepository = productRepository;
    this.categoryRepository = categoryRepository;
    this.supplierRepository = supplierRepository;
  }

  @Transactional
  public ProductCreateDTO execute(ProductCreateDTO dto) {
    Product response = ProductMapper.toCreateEntity(dto, categoryRepository, supplierRepository);
    response = productRepository.save(response);
    return ProductMapper.toCreateDTO(response);

  }
}
