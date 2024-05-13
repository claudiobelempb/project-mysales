package br.com.surb.mysales.services.client;

import br.com.surb.mysales.repositories.ClientRepository;
import br.com.surb.mysales.shared.constants.ConstantException;
import br.com.surb.mysales.shared.exeptions.resources.ResourceNotFondExecption;
import br.com.surb.mysales.shared.exeptions.services.ServiceDataIntegrityViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientDeleteService {
  private final ClientRepository clientRepository;

  public ClientDeleteService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  public void execute(Long id){

    if(!clientRepository.existsById(id)) throw new ResourceNotFondExecption(ConstantException.ENTITY_NOT_FOUND);

    try {
      clientRepository.deleteById(id);
    }catch (DataIntegrityViolationException e){
      throw new ServiceDataIntegrityViolationException(ConstantException.DATA_INTEGRITY_VIOLATION);
    }

  }
}
