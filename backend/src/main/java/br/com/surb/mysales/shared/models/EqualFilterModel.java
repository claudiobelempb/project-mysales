package br.com.surb.mysales.shared.models;

import java.io.Serial;
import java.io.Serializable;

public record EqualFilterModel(
   String column,
   String value,
   Boolean isEqual
) implements Serializable {

  @Serial
  private static final long serialVersionUID = 3499328901234606176L;

}
