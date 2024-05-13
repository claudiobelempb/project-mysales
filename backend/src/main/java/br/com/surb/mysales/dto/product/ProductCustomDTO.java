package br.com.surb.mysales.dto.product;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public record ProductCustomDTO(
     Long id,
     String sku,
     String name,
     BigDecimal price,
     String description,
     Long categoryId,
     Long supllierId
) implements Serializable {

  @Serial
  private static final long serialVersionUID = 5102161462547613039L;


}
