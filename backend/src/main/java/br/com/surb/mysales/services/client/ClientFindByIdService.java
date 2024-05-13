package br.com.surb.mysales.services.client;

import br.com.surb.mysales.dto.client.ClientDTO;
import br.com.surb.mysales.entities.Client;
import br.com.surb.mysales.mapper.ClientMapper;
import br.com.surb.mysales.repositories.ClientRepository;
import br.com.surb.mysales.shared.constants.ConstantException;
import br.com.surb.mysales.shared.exeptions.resources.ResourceNotFondExecption;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Objects;

@Service
public class ClientFindByIdService {
  private final ClientRepository clientRepository;

  public ClientFindByIdService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Transactional(readOnly = true)
  public ClientDTO execute(Long id) {
    Objects.requireNonNull(id);
    Client entity = clientRepository
      .findById(id)
      .orElseThrow(() -> new ResourceNotFondExecption(ConstantException.ENTITY_NOT_FOUND));
    return ClientMapper.toDTO(entity);
  }
}
