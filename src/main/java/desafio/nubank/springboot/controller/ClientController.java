package desafio.nubank.springboot.controller;

import desafio.nubank.springboot.dto.ClientsRequestDto;
import desafio.nubank.springboot.dto.ClientsResponseDto;
import desafio.nubank.springboot.dto.ContactsResponseDto;
import desafio.nubank.springboot.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientsResponseDto> create(@RequestBody ClientsRequestDto dto) {
        ClientsResponseDto createdClient = clientService.salveClients(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
    }

    @GetMapping
    public ResponseEntity<List<ClientsResponseDto>> listAll() {
        return ResponseEntity.ok(clientService.listAll());
    }

    // como esta se referindo ao id tem que passar o parametro path variable
    @GetMapping("/{id}/contacts")
    public ResponseEntity<List<ContactsResponseDto>> listContacts(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.contactListForClient(id));
    }
}
