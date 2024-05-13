package br.com.surb.mysales.services.client;

import br.com.surb.mysales.dto.client.ClientDTO;
import br.com.surb.mysales.entities.Client;
import br.com.surb.mysales.mapper.ClientMapper;
import br.com.surb.mysales.repositories.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientFindAllService {
  private final ClientRepository clientRepository;

  public ClientFindAllService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Transactional(readOnly = true)
  public Page<ClientDTO> execute(Pageable pageable) {
    Page<Client> response = clientRepository.findAll(pageable);
    return response.map(client -> ClientMapper.toDTO(client));
  }
}
