package com.example.tingesoBackendAlan.services;

import com.example.tingesoBackendAlan.entities.ClienteEntity;
import com.example.tingesoBackendAlan.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<ClienteEntity> getClientes(){
        return (ArrayList<ClienteEntity>) clienteRepository.findAll();
    }
    public ClienteEntity saveCliente(ClienteEntity cliente){
        return clienteRepository.save(cliente);
    }
    public ClienteEntity getClienteByRut(String rut){
        return clienteRepository.findByRut(rut);
    }
    public ClienteEntity updateCliente(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }
    public Boolean deleteCliente(String rut) {
        clienteRepository.deleteByRut(rut);
        return true;
    }

}
