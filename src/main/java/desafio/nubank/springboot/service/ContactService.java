package desafio.nubank.springboot.service;
import desafio.nubank.springboot.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactsRepository contactsRepository;


}
