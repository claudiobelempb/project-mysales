package br.com.surb.mysales.dto.product;

import br.com.surb.mysales.dto.category.CategoryDTO;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

public record ProductCustomRequest(
   Long id,
   String sku,
   String name,
   BigDecimal price,
   String description,
   Set<CategoryDTO> categories
) implements Serializable {

  @Serial
  private static final long serialVersionUID = 5102161462547613039L;
}
