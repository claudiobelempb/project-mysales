package br.com.surb.mysales.services.product;

import br.com.surb.mysales.entities.Product;
import br.com.surb.mysales.repositories.ProductRepository;
import br.com.surb.mysales.shared.models.*;
import br.com.surb.mysales.specifications.ProductSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductFindAllListService {
  private final ProductRepository productRepository;

  public ProductFindAllListService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> execute(){
    return productRepository.findAll();
  }

  public PageFilterModel<Product> execute(FilterModel filter){
    Pageable pageable = filter.toSpringPageable();
    Specification<Product> specification = specificationBuild(filter);

    Page<Product> page = productRepository.findAll(specification, pageable);
    return new PageFilterModel<>(page);
  }

  private Specification<Product> specificationBuild(FilterModel pageFilterModel){
    Specification<Product> specification = Specification.where(null);
    List<EqualFilterModel> eqs = pageFilterModel.getEqualFilter();
    List<InFilterModel> ins = pageFilterModel.getInFilter();
    //List<DateFilterModel> dateFilter = pageFilterModel.getDateFilter();

    for (EqualFilterModel eq: eqs){
      specification = specification.and(ProductSpecification.equal(eq));
    }

    for (InFilterModel in: ins){
      specification = specification.and(ProductSpecification.in(in));
    }

    /*for (DateFilterModel df: dateFilter){
      specification = specification.and(ProductSpecification.dateBetween(df));
    }*/

    return specification;
  }
}
