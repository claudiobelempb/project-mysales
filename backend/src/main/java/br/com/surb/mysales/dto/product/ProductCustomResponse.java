package br.com.surb.mysales.dto.product;

import br.com.surb.mysales.dto.category.CategoryResponse;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

public record ProductCustomResponse(
   Long id,
   String sku,
   String name,
   BigDecimal price,
   String description
) implements Serializable {

  @Serial
  private static final long serialVersionUID = 5102161462547613039L;


}
