package desafio.nubank.springboot.repository;

import desafio.nubank.springboot.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Long> {
}
