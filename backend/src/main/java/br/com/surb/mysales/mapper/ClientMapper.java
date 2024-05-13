package br.com.surb.mysales.mapper;

import br.com.surb.mysales.dto.client.ClientCustomDTO;
import br.com.surb.mysales.dto.client.ClientDTO;
import br.com.surb.mysales.entities.Client;

public final class ClientMapper {

  public static Client toCustomEntity(ClientCustomDTO dto){
    Client entity = new Client();
    entity.setName(dto.name());
    entity.setEmail(dto.email());
    entity.setCpf(dto.cpf());
    entity.setBirth(dto.birth());
    entity.setAddress(dto.address());
    entity.setTeleohone(dto.teleohone());
    return entity;
  }

  public static Client toEntity(ClientDTO dto){
    return new Client(
      dto.id(),
      dto.name(),
      dto.email(),
      dto.cpf(),
      dto.birth(),
      dto.address(),
      dto.teleohone(),
      dto.createdAt()
    );
  }

  public static Client toEntity(Client entity, ClientDTO dto){
    entity.setName(dto.name());
    entity.setEmail(dto.email());
    entity.setCpf(dto.cpf());
    entity.setBirth(dto.birth());
    entity.setAddress(dto.address());
    entity.setTeleohone(dto.teleohone());
    return entity;
  }

  public static ClientDTO toDTO(Client entity){
    return new ClientDTO(
      entity.getId(),
      entity.getName(),
      entity.getEmail(),
      entity.getCpf(),
      entity.getBirth(),
      entity.getAddress(),
      entity.getTeleohone(),
      entity.getCreatedAt()
    );

  }
}
