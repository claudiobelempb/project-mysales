package br.com.surb.mysales.dto.category;

import br.com.surb.mysales.dto.product.ProductCreateDTO;
import java.util.List;

public record CategoryCreateRequest(
  Long id,
  String name,
  List<ProductCreateDTO> products
) {
}
