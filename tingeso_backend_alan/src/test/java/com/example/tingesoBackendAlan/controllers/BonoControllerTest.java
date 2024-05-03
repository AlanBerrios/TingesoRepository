package com.example.tingesoBackendAlan.controllers;

import com.example.tingesoBackendAlan.entities.BonoEntity;
import com.example.tingesoBackendAlan.services.BonoService;
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

@WebMvcTest(BonoController.class)
public class BonoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BonoService bonoService;

    @Test
    public void listBonos_ShouldReturnBonos() throws Exception {
        BonoEntity bono1 = new BonoEntity(
                1L,
                "Marca1",
                10,
                10000);
        BonoEntity bono2 = new BonoEntity(
                2L,
                "Marca2",
                20,
                20000);

        List<BonoEntity> bonoList = new ArrayList<>(Arrays.asList(bono1, bono2));

        given(bonoService.getBonos()).willReturn((ArrayList<BonoEntity>) bonoList);

        mockMvc.perform(get("/api/bono/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].marca", is("Marca1")))
                .andExpect(jsonPath("$[1].marca", is("Marca2")));
    }

    @Test
    public void getBonoByMarca_ShouldReturnBono() throws Exception {
        BonoEntity bono = new BonoEntity(
                1L,
                "Marca1",
                10,
                10000);

        given(bonoService.getBonoByMarca("Marca1")).willReturn(bono);

        mockMvc.perform(get("/api/bono/{marca}", "Marca1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.marca", is("Marca1")));
    }

    @Test
    public void saveBono_ShouldReturnSavedBono() throws Exception {
        BonoEntity savedBono = new BonoEntity(
                1L,
                "Marca1",
                10,
                10000);

        given(bonoService.saveBono(Mockito.any(BonoEntity.class))).willReturn(savedBono);

        String bonoJson = """
        {
            "marca": "Marca1",
            "valor": 10
        }
        """;

        mockMvc.perform(post("/api/bono/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bonoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.marca", is("Marca1")));
    }

    @Test
    public void updateBono_ShouldReturnUpdatedBono() throws Exception {
        BonoEntity updatedBono = new BonoEntity(
                1L,
                "Marca1",
                20,
                20000);

        given(bonoService.updateBono(Mockito.any(BonoEntity.class))).willReturn(updatedBono);

        String bonoJson = """
        {
            "idBono": 1,
            "marca": "Marca1",
            "numeroBonos": 20,
            "montoBono": 20000
        }
        """;

        mockMvc.perform(put("/api/bono/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bonoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numeroBonos", is(20)));
    }

    @Test
    public void deleteBonoById_ShouldReturn204() throws Exception {
        when(bonoService.deleteBono(1L)).thenReturn(true);

        mockMvc.perform(delete("/api/bono/{idBono}", 1))
                .andExpect(status().isNoContent());
    }

    @Test
    public void usarBono_ShouldReturn204() throws Exception {
        mockMvc.perform(put("/api/bono/usar/{marca}", "Marca1"))
                .andExpect(status().isNoContent());
    }
}
