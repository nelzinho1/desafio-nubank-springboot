package desafio.nubank.springboot.controller;

import desafio.nubank.springboot.dto.ClientsRequestDto;
import desafio.nubank.springboot.model.Clients;
import desafio.nubank.springboot.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Clients> create(@RequestBody ClientsRequestDto dto) {
        Clients createdClient = clientService.salveClients(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
    }
}
