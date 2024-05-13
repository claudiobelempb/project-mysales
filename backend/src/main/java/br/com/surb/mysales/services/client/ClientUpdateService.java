package br.com.surb.mysales.services.client;

import br.com.surb.mysales.dto.client.ClientDTO;
import br.com.surb.mysales.entities.Client;
import br.com.surb.mysales.mapper.ClientMapper;
import br.com.surb.mysales.repositories.ClientRepository;
import br.com.surb.mysales.shared.constants.ConstantException;
import br.com.surb.mysales.shared.exeptions.resources.ResourceNotFondExecption;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientUpdateService {
  private final ClientRepository clientRepository;

  public ClientUpdateService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Transactional
  public ClientDTO execute(Long id, ClientDTO dto) {
    try {
      Client entity = clientRepository.getReferenceById(id);
      entity = ClientMapper.toEntity(entity, dto);
      entity = clientRepository.save(entity);
      return ClientMapper.toDTO(entity);
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFondExecption(ConstantException.ENTITY_NOT_FOUND);
    }

  }
}
