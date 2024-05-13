package br.com.surb.mysales.dto.product;

import br.com.surb.mysales.dto.category.CategoryDTO;
import br.com.surb.mysales.dto.supplier.SupplierDTO;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public record ProductCreateDTO(
   Long id,
   String sku,
   String name,
   BigDecimal price,
   Integer stock,
   String description,
   CategoryDTO category,
   SupplierDTO supplier
) implements Serializable {

  @Serial
  private static final long serialVersionUID = 5102161462547613039L;


}
