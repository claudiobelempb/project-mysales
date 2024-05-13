package br.com.surb.mysales.shared.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record InFilterModel(
  String column,
  List<String> values,
  Boolean isIn
) implements Serializable {

  @Serial
  private static final long serialVersionUID = 3499328901234606176L;
}
