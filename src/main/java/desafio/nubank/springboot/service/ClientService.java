package desafio.nubank.springboot.service;

import desafio.nubank.springboot.dto.ClientsRequestDto;
import desafio.nubank.springboot.dto.ClientsResponseDto;
import desafio.nubank.springboot.dto.ContactsResponseDto;
import desafio.nubank.springboot.model.Clients;
import desafio.nubank.springboot.model.Contacts;
import desafio.nubank.springboot.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientsRepository clientsRepository;

    public ClientsResponseDto salveClients(ClientsRequestDto dto) {
        Clients clients = new Clients();
        clients.setName(dto.getName());

        if (dto.getContacts() != null && !dto.getContacts().isEmpty()) {
            // expression lambda
            List<Contacts> contacts = dto.getContacts()
                    .stream()
                    .map(c -> {

                        Contacts contact = new Contacts();
                        contact.setCel(c.getCel());
                        contact.setEmail(c.getEmail());
                        contact.setClients(clients);
                        return contact;
                    }).toList();

            clients.setContacts(contacts);
        }
        Clients saved = clientsRepository.save(clients);

        return toDto(saved);
    }

    // listar todos os clientes com seus contatos.
    public List<ClientsResponseDto> listAll() {
        return clientsRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<ContactsResponseDto> contactListForClient(Long clientId) {

        Clients clients = clientsRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));
        return clients.getContacts()
                .stream()
                .map(c -> {

            ContactsResponseDto contactDto = new ContactsResponseDto();
            contactDto.setId(c.getId());
            contactDto.setCel(c.getCel());
            contactDto.setEmail(c.getEmail());
            return contactDto;

        }).collect(Collectors.toList());
    }

    private ClientsResponseDto toDto(Clients clients) {
        ClientsResponseDto dto = new ClientsResponseDto();
        dto.setId(clients.getId());
        dto.setName(clients.getName());

        List<ContactsResponseDto> contacts = clients.getContacts()
                .stream()
                .map(c -> {

                    ContactsResponseDto contactDto = new ContactsResponseDto();

                    contactDto.setId(c.getId());
                    contactDto.setCel(c.getCel());
                    contactDto.setEmail(c.getEmail());
                    contactDto.setClientsId(clients.getId());

                    return contactDto;
                }).toList();
        dto.setContacts(contacts);

        return dto;
    }
}
