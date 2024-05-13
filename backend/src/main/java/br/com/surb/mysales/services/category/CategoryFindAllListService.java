package br.com.surb.mysales.services.category;

import br.com.surb.mysales.entities.Category;
import br.com.surb.mysales.repositories.CategoryRepository;
import br.com.surb.mysales.shared.models.EqualFilterModel;
import br.com.surb.mysales.shared.models.InFilterModel;
import br.com.surb.mysales.shared.models.FilterModel;
import br.com.surb.mysales.shared.models.PageFilterModel;
import br.com.surb.mysales.specifications.CategorySpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryFindAllListService {
  private final CategoryRepository categoryRepository;

  public CategoryFindAllListService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public List<Category> execute(){
    return categoryRepository.findAll();
  }

  public PageFilterModel<Category> execute(FilterModel filter){
    Pageable pageable = filter.toSpringPageable();
    Specification<Category> specification = specificationBuild(filter);

    Page<Category> page = categoryRepository.findAll(specification, pageable);
    return new PageFilterModel<>(page);
  }

  private Specification<Category> specificationBuild(FilterModel pageFilterModel){
    Specification<Category> specification = Specification.where(null);
    List<EqualFilterModel> eqs = pageFilterModel.getEqualFilter();
    List<InFilterModel> ins = pageFilterModel.getInFilter();

    for (EqualFilterModel eq: eqs){
      specification = specification.and(CategorySpecification.equal(eq));
    }

    for (InFilterModel in: ins){
      specification = specification.and(CategorySpecification.in(in));
    }
    return specification;
  }

}
