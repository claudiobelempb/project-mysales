package br.com.surb.mysales.dto.product;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public record ProductRequest(
   Long id,
   String sku,
   String name,
   BigDecimal price,
   String description
) implements Serializable {

  @Serial
  private static final long serialVersionUID = 5102161462547613039L;
}
