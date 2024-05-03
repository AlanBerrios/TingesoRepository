package com.example.tingesoBackendAlan.controllers;

import com.example.tingesoBackendAlan.entities.ClienteEntity;
import com.example.tingesoBackendAlan.services.ClienteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ClienteService clienteService;

    @Test
    public void listClientes_ShouldReturnClientes() throws Exception {
        ClienteEntity cliente1 = new ClienteEntity(
                "12345678-9",
                "Cliente1",
                "Apellido1",
                "cliente1@example.com",
                "123456789",
                "Direccion1");
        ClienteEntity cliente2 = new ClienteEntity(
                "98765432-1",
                "Cliente2",
                "Apellido2",
                "cliente2@example.com",
                "987654321",
                "Direccion2");

        List<ClienteEntity> clienteList = new ArrayList<>(Arrays.asList(cliente1, cliente2));

        given(clienteService.getClientes()).willReturn((ArrayList<ClienteEntity>) clienteList);

        mockMvc.perform(get("/api/clientes/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].rut", is("12345678-9")))
                .andExpect(jsonPath("$[1].rut", is("98765432-1")));
    }

    @Test
    public void getClienteByRut_ShouldReturnCliente() throws Exception {
        ClienteEntity cliente = new ClienteEntity(
                "12345678-9",
                "Cliente1",
                "Apellido1",
                "cliente1@example.com",
                "123456789",
                "Direccion1");
        given(clienteService.getClienteByRut("12345678-9")).willReturn(cliente);

        mockMvc.perform(get("/api/clientes/{rut}", "12345678-9"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.rut", is("12345678-9")));
    }

    @Test
    public void saveCliente_ShouldReturnSavedCliente() throws Exception {
        ClienteEntity savedCliente = new ClienteEntity(
                "12345678-9",
                "Cliente1",
                "Apellido1",
                "cliente1@example.com",
                "123456789",
                "Direccion1");

        given(clienteService.saveCliente(Mockito.any(ClienteEntity.class))).willReturn(savedCliente);

        String clienteJson = """
        {
            "rut": "12345678-9",
            "nombre": "Cliente1",
            "apellido": "Apellido1",
            "correo": "cliente1@example.com",
            "telefono": "123456789",
            "direccion": "Direccion1"         
        }
        """;

        mockMvc.perform(post("/api/clientes/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(clienteJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rut", is("12345678-9")));
    }

    @Test
    public void updateCliente_ShouldReturnUpdatedCliente() throws Exception {
        ClienteEntity updatedCliente = new ClienteEntity(
                "12345678-9",
                "Cliente1",
                "Apellido1",
                "cliente1@example.com",
                "123456789",
                "Direccion1");

        given(clienteService.updateCliente(Mockito.any(ClienteEntity.class))).willReturn(updatedCliente);

        String clienteJson = """
        {
            "rut": "12345678-9",
            "nombre": "Cliente1",
            "apellido": "Apellido1",
            "email": "cliente1@example.com",
            "telefono": "123456789",
            "direccion": "Direccion1"
        }
        """;

        mockMvc.perform(put("/api/clientes/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(clienteJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("Cliente1")));
    }

    @Test
    public void deleteClienteByRut_ShouldReturn204() throws Exception {
        when(clienteService.deleteCliente("12345678-9")).thenReturn(true);

        mockMvc.perform(delete("/api/clientes/{rut}", "12345678-9"))
                .andExpect(status().isNoContent());
    }
}
