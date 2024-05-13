package br.com.surb.mysales.services.client;

import br.com.surb.mysales.dto.client.ClientDTO;
import br.com.surb.mysales.entities.Client;
import br.com.surb.mysales.mapper.ClientMapper;
import br.com.surb.mysales.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientCreateService {
  private final ClientRepository clientRepository;

  public ClientCreateService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  public ClientDTO execute(ClientDTO dto){
    Client client = ClientMapper.toEntity(dto);
    client = clientRepository.save(client);
    return ClientMapper.toDTO(client);
  }
}
