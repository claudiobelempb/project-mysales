package br.com.surb.mysales.dto.category;

import br.com.surb.mysales.dto.product.ProductCustomDTO;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

public record CategoryCustomRequest(
  Long id,
  String name,
  Set<ProductCustomDTO> products
) implements Serializable {

  @Serial
  private static final long serialVersionUID = -8600833457598685223L;
}
