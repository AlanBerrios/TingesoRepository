package com.example.tingesoBackendAlan.controllers;

import com.example.tingesoBackendAlan.entities.HistorialEntity;
import com.example.tingesoBackendAlan.services.HistorialService;
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

@WebMvcTest(HistorialController.class)
public class HistorialControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    HistorialService historialService;

    @Test
    public void listHistoriales_ShouldReturnHistoriales() throws Exception {
        HistorialEntity historial1 = new HistorialEntity(1L, "ABC123", "12345678-9", 2, 50000);
        HistorialEntity historial2 = new HistorialEntity(2L, "DEF456", "98765432-1", 1, 60000);

        List<HistorialEntity> historialList = new ArrayList<>(Arrays.asList(historial1, historial2));

        given(historialService.getHistoriales()).willReturn((ArrayList<HistorialEntity>) historialList);

        mockMvc.perform(get("/api/historial/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idHistorial", is(1)))
                .andExpect(jsonPath("$[1].idHistorial", is(2)));
    }

    @Test
    public void listHistoriales2_ShouldReturnHistoriales2() throws Exception {
        HistorialEntity historial1 = new HistorialEntity(1L, "ABC123", "12345678-9", 2, 50000);
        HistorialEntity historial2 = new HistorialEntity(2L, "DEF456", "98765432-1", 1, 60000);

        List<HistorialEntity> historialList = new ArrayList<>(Arrays.asList(historial1, historial2));

        given(historialService.getHistoriales2()).willReturn((ArrayList<HistorialEntity>) historialList);

        mockMvc.perform(get("/api/historial/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idHistorial", is(1)))
                .andExpect(jsonPath("$[1].idHistorial", is(2)));
    }

    @Test
    public void getHistorialById_ShouldReturnHistorial() throws Exception {
        HistorialEntity historial = new HistorialEntity(1L, "ABC123", "12345678-9", 2, 50000);
        given(historialService.getHistorialById(1L)).willReturn(historial);

        mockMvc.perform(get("/api/historial/id/{idHistorial}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idHistorial", is(1)));
    }

    @Test
    public void getHistorialByPatente_ShouldReturnHistorial() throws Exception {
        HistorialEntity historial = new HistorialEntity(1L, "ABC123", "12345678-9", 2, 50000);
        given(historialService.getHistorialByPatente("ABC123")).willReturn(historial);

        mockMvc.perform(get("/api/historial/{patente}", "ABC123"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idHistorial", is(1)));
    }

    @Test
    public void saveHistorial_ShouldReturnSavedHistorial() throws Exception {
        HistorialEntity savedHistorial = new HistorialEntity(1L, "ABC123", "12345678-9", 2, 50000);
        given(historialService.saveHistorial(Mockito.any(HistorialEntity.class))).willReturn(savedHistorial);

        String historialJson = """
        {
            "idHistorial": 1,
            "patente": "ABC123",
            "rut": "12345678-9",
            "numeroReparaciones": 2,
            "montoTotalFinal": 50000
        }
        """;

        mockMvc.perform(post("/api/historial/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(historialJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idHistorial", is(1)));
    }

    @Test
    public void updateHistorial_ShouldReturnUpdatedHistorial() throws Exception {
        HistorialEntity updatedHistorial = new HistorialEntity(1L, "ABC123", "12345678-9", 2, 50000);
        given(historialService.updateHistorial(Mockito.any(HistorialEntity.class))).willReturn(updatedHistorial);

        String historialJson = """
        {
            "idHistorial": 1,
            "patente": "ABC123",
            "rut": "12345678-9",
            "numeroReparaciones": 2,
            "montoTotalFinal": 50000
        }
        """;

        mockMvc.perform(put("/api/historial/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(historialJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idHistorial", is(1)));
    }

    @Test
    public void deleteHistorialById_ShouldReturn204() throws Exception {
        when(historialService.deleteHistorial(1L)).thenReturn(true);

        mockMvc.perform(delete("/api/historial/{id}", 1))
                .andExpect(status().isNoContent());
    }
}
