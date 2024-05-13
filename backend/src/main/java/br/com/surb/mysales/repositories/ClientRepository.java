package br.com.surb.mysales.repositories;

import br.com.surb.mysales.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
