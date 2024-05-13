package br.com.surb.mysales.dto.supplier;

import br.com.surb.mysales.entities.Product;
import java.util.List;

public record SupplierAndProductsDTO(
  Long id,
  String name,
  List<Product> products
) {
}
