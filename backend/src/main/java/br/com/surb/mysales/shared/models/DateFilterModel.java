package br.com.surb.mysales.shared.models;

import java.io.Serial;
import java.io.Serializable;

public record DateFilterModel(
   String column,
   String startDate,
   String endDate
) implements Serializable {

  @Serial
  private static final long serialVersionUID = -869377304975670039L;
}
