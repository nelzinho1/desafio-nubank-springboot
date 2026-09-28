package desafio.nubank.springboot.controller;

import desafio.nubank.springboot.dto.ContactsRequestDto;
import desafio.nubank.springboot.model.Clients;
import desafio.nubank.springboot.model.Contacts;
import desafio.nubank.springboot.repository.ClientsRepository;
import desafio.nubank.springboot.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactsRepository contactsRepository;

    @Autowired
    private ClientsRepository clientsRepository;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ContactsRequestDto dto) {
        Optional<Clients> clientsOptional = clientsRepository.findById(dto.getClientsId());
        if (clientsOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não encontrato.");
        }
        Contacts contats = new Contacts();
        contats.setCel(dto.getCel());
        contats.setEmail(dto.getEmail());
        contats.setClients(clientsOptional.get());
        contactsRepository.save(contats);

        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso." + contats);
    }

}
