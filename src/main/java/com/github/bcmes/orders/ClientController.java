package com.github.bcmes.orders;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@Validated
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public ResponseEntity<List<ClientControllerListResponse>> listAll() {
        List<ClientDomain> clientsDomain = clientRepository.findAll();
        List<ClientControllerListResponse> clientsResponse = clientsDomain.stream().map(ClientControllerListResponse::new).toList();
        return ResponseEntity.ok(clientsResponse);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid ClientControllerInputCreate clientControllerInputCreate) {
        ClientDomain clientDomain = clientControllerInputCreate.toClientDomain();
        clientRepository.save(clientDomain);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/test2")
    public ResponseEntity<List<ClientControllerListResponse>> listAll2() {
        List<ClientDomain> clientsDomain = clientRepository.findAll();
        List<ClientControllerListResponse> clientsResponse = clientsDomain.stream().map(ClientControllerListResponse::new).toList();
        return ResponseEntity.ok(clientsResponse);
    }

    @PostMapping("test2")
    public ResponseEntity<Void> create2(@RequestBody @Valid ClientControllerInputCreate clientControllerInputCreate) {
        ClientDomain clientDomain = clientControllerInputCreate.toClientDomain();
        clientRepository.save(clientDomain);
        return ResponseEntity.noContent().build();
    }
}
