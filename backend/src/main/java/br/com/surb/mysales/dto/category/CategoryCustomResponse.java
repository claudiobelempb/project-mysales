package br.com.surb.mysales.dto.category;

import br.com.surb.mysales.dto.product.ProductCustomResponse;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

public record CategoryCustomResponse(
  Long id,
  String name
) implements Serializable {

  @Serial
  private static final long serialVersionUID = -2246702875565942581L;
}
