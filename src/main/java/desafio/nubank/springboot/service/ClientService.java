package desafio.nubank.springboot.service;

import desafio.nubank.springboot.dto.ClientsRequestDto;
import desafio.nubank.springboot.model.Clients;
import desafio.nubank.springboot.model.Contacts;
import desafio.nubank.springboot.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientsRepository clientsRepository;

    public Clients salveClients(ClientsRequestDto dto) {
        Clients clients = new Clients();
        clients.setName(dto.getName());

        if (dto.getContactsDto() != null && !dto.getContactsDto().isEmpty()) {
            // express lambda
            List<Contacts> contacts = dto.getContactsDto().stream().map(c -> {
                Contacts contact = new Contacts();
                contact.setCel(c.getCel());
                contact.setEmail(c.getEmail());
                contact.setClients(clients);
                return contact;
            }).toList();
            clients.setContacts(contacts);
        }

        return clientsRepository.save(clients);
    }

    public List<Clients> listAll() {
        return clientsRepository.findAll().stream().map()
    }

}
