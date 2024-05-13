package br.com.surb.mysales.services.supplier;

import br.com.surb.mysales.entities.Supplier;
import br.com.surb.mysales.repositories.SupplierRepository;
import br.com.surb.mysales.shared.models.EqualFilterModel;
import br.com.surb.mysales.shared.models.InFilterModel;
import br.com.surb.mysales.shared.models.FilterModel;
import br.com.surb.mysales.shared.models.PageFilterModel;
import br.com.surb.mysales.specifications.SupplierSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierFindAllListService {
  private final SupplierRepository supplierRepository;

  public SupplierFindAllListService(SupplierRepository supplierRepository) {
    this.supplierRepository = supplierRepository;
  }

  public PageFilterModel<Supplier> execute(FilterModel filter){
    Pageable pageable = filter.toSpringPageable();
    Specification<Supplier> specification = specificationBuild(filter);

    Page<Supplier> page = supplierRepository.findAll(specification, pageable);
    return new PageFilterModel<>(page);
  }

  private Specification<Supplier> specificationBuild(FilterModel pageFilterModel){
    Specification<Supplier> specification = Specification.where(null);
    List<EqualFilterModel> eqs = pageFilterModel.getEqualFilter();
    List<InFilterModel> ins = pageFilterModel.getInFilter();

    for (EqualFilterModel eq: eqs){
      specification = specification.and(SupplierSpecification.equal(eq));
    }

    for (InFilterModel in: ins){
      specification = specification.and(SupplierSpecification.in(in));
    }
    return specification;
  }
}
