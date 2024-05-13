package br.com.surb.mysales.dto.category;

import br.com.surb.mysales.entities.Product;
import java.util.List;

public record CategoryAndProductsDTO(
  Long id,
  String name,
  List<Product> products
) {
}
