package desafio.nubank.springboot.controller;

import desafio.nubank.springboot.model.Clients;
import desafio.nubank.springboot.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Clients> listAll() {
        return clientService.listAll();
    }
}
