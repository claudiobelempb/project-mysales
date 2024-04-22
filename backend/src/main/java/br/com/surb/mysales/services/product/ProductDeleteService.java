package br.com.surb.mysales.services.product;

import br.com.surb.mysales.repositories.ProductRepository;
import br.com.surb.mysales.shared.constants.ConstantException;
import br.com.surb.mysales.shared.exeptions.resources.ResourceNotFondExecption;
import br.com.surb.mysales.shared.exeptions.services.ServiceDataIntegrityViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductDeleteService {
  private final ProductRepository productRepository;

  public ProductDeleteService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  public void execute(Long id){

    if(!productRepository.existsById(id)) throw new ResourceNotFondExecption(ConstantException.ENTITY_NOT_FOUND);

    try {
      productRepository.deleteById(id);
    }catch (DataIntegrityViolationException e){
      throw new ServiceDataIntegrityViolationException(ConstantException.DATA_INTEGRITY_VIOLATION);
    }

  }
}
