package br.com.surb.mysales.dto.product;

import br.com.surb.mysales.dto.category.CategoryResponse;
import br.com.surb.mysales.entities.Category;
import br.com.surb.mysales.shared.constants.ConstantValidator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public record ProductCreateRequest(
   Long id,
   String sku,
   String name,
   BigDecimal price,
   String description,
   Set<CategoryResponse> categories
) implements Serializable {

  @Serial
  private static final long serialVersionUID = 5102161462547613039L;
}
