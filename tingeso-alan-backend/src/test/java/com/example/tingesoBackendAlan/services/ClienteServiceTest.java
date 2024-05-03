package com.example.tingesoBackendAlan.services;

import com.example.tingesoBackendAlan.entities.ClienteEntity;
import com.example.tingesoBackendAlan.repositories.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClienteServiceTest {

    @MockBean
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetClientes() {
        // Datos de prueba
        ClienteEntity cliente1 = new ClienteEntity();
        cliente1.setRut("123456789-0");
        ClienteEntity cliente2 = new ClienteEntity();
        cliente2.setRut("987654321-0");
        ArrayList<ClienteEntity> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);

        // Configurar comportamiento simulado del repositorio
        when(clienteRepository.findAll()).thenReturn(clientes);

        // Llamar al método del servicio
        ArrayList<ClienteEntity> clientesObtenidos = clienteService.getClientes();

        // Verificar que los resultados sean los esperados
        assertEquals(clientes.size(), clientesObtenidos.size());
        assertEquals(clientes.get(0).getRut(), clientesObtenidos.get(0).getRut());
        assertEquals(clientes.get(1).getRut(), clientesObtenidos.get(1).getRut());
    }

    @Test
    public void testGetClienteByRut() {
        // Datos de prueba
        String rut = "123456789-0";
        ClienteEntity cliente = new ClienteEntity();
        cliente.setRut(rut);

        // Configurar comportamiento simulado del repositorio
        when(clienteRepository.findByRut(rut)).thenReturn(cliente);

        // Llamar al método del servicio
        ClienteEntity clienteObtenido = clienteService.getClienteByRut(rut);

        // Verificar que el resultado sea el esperado
        assertEquals(rut, clienteObtenido.getRut());
    }

    @Test
    public void testSaveCliente() {
        // Datos de prueba
        ClienteEntity cliente = new ClienteEntity();
        cliente.setRut("123456789-0");

        // Configurar comportamiento simulado del repositorio
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        // Llamar al método del servicio
        ClienteEntity clienteObtenido = clienteService.saveCliente(cliente);

        // Verificar que el resultado sea el esperado
        assertEquals(cliente.getRut(), clienteObtenido.getRut());
    }

    @Test
    public void testUpdateCliente() {
        // Datos de prueba
        ClienteEntity cliente = new ClienteEntity();
        cliente.setRut("123456789-0");

        // Configurar comportamiento simulado del repositorio
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        // Llamar al método del servicio
        ClienteEntity clienteObtenido = clienteService.updateCliente(cliente);

        // Verificar que el resultado sea el esperado
        assertEquals(cliente.getRut(), clienteObtenido.getRut());
    }
}
