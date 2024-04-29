package com.example.tingesoBackendAlan.controllers;

    import com.example.tingesoBackendAlan.entities.ClienteEntity;
import com.example.tingesoBackendAlan.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("*")
public class ClienteController {

    ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ClienteEntity>> listClientes() {
        List<ClienteEntity> clientes = clienteService.getClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{rut}")
    public ResponseEntity<ClienteEntity> getClienteByRut(@PathVariable String rut) {
        ClienteEntity cliente = clienteService.getClienteByRut(rut);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping("/")
    public ResponseEntity<ClienteEntity> saveCliente(@RequestBody ClienteEntity cliente) {
        ClienteEntity clienteNew = clienteService.saveCliente(cliente);
        return ResponseEntity.ok(clienteNew);
    }

    @PutMapping("/")
    public ResponseEntity<ClienteEntity> updateCliente(@RequestBody ClienteEntity cliente){
        ClienteEntity clienteUpdated = clienteService.updateCliente(cliente);
        return ResponseEntity.ok(clienteUpdated);
    }

    @DeleteMapping("/{rut}")
    public ResponseEntity<Boolean> deleteClienteByRut(@PathVariable String rut) throws Exception {
        var isDeleted = clienteService.deleteCliente(rut);
        return ResponseEntity.noContent().build();
    }
}
