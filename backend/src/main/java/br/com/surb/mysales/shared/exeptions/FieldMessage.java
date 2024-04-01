package br.com.surb.mysales.shared.exeptions;

import java.io.Serial;
import java.io.Serializable;

public record FieldMessage(
   String fildName,
   String message
) implements Serializable {

  @Serial
  private static final long serialVersionUID = 2723399791602903670L;



}
