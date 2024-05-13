package br.com.surb.mysales.dto.client;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public record ClientCustomDTO(
  String name,
  String email,
  String cpf,
  LocalDate birth,
  String address,
  String teleohone
) implements Serializable {

  @Serial
  private static final long serialVersionUID = 7794111273558933331L;
}
