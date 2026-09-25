package desafio.nubank.springboot.repository;

import desafio.nubank.springboot.model.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactsRepository extends JpaRepository<Contacts, Long> {
}
