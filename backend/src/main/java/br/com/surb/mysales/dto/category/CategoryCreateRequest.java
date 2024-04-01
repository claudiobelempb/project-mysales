package br.com.surb.mysales.dto.category;

import br.com.surb.mysales.dto.product.ProductCreateResponse;
import br.com.surb.mysales.dto.product.ProductResponse;
import java.util.List;
import java.util.Set;

public record CategoryCreateRequest(
  Long id,
  String name,
  List<ProductCreateResponse> products
) {
}
