package com.example.tingesoBackendAlan.controllers;

import com.example.tingesoBackendAlan.entities.RelacionReparacionHistorialEntity;
import com.example.tingesoBackendAlan.services.RelacionReparacionHistorialService;
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

@WebMvcTest(RelacionReparacionHistorialController.class)
public class RelacionReparacionHistorialControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    RelacionReparacionHistorialService relacionReparacionHistorialService;

    @Test
    public void listRelacionReparacionHistorial_ShouldReturnRelacionReparacionHistorials() throws Exception {
        RelacionReparacionHistorialEntity relacion1 = new RelacionReparacionHistorialEntity(1L, 1L, 1L);
        RelacionReparacionHistorialEntity relacion2 = new RelacionReparacionHistorialEntity(2L, 2L, 2L);

        List<RelacionReparacionHistorialEntity> relacionList = new ArrayList<>(Arrays.asList(relacion1, relacion2));

        given(relacionReparacionHistorialService.getRelacionReparacionHistorial()).willReturn((ArrayList<RelacionReparacionHistorialEntity>) relacionList);

        mockMvc.perform(get("/api/relacionreparacionhistorial/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idRelacionReparacionHistorial", is(1)))
                .andExpect(jsonPath("$[1].idRelacionReparacionHistorial", is(2)));
    }

    @Test
    public void getRelacionReparacionHistorialById_ShouldReturnRelacionReparacionHistorial() throws Exception {
        RelacionReparacionHistorialEntity relacion = new RelacionReparacionHistorialEntity(1L, 1L, 1L);
        given(relacionReparacionHistorialService.getRelacionReparacionHistorialById(1L)).willReturn(relacion);

        mockMvc.perform(get("/api/relacionreparacionhistorial/id/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idRelacionReparacionHistorial", is(1)));
    }

    @Test
    public void saveRelacionReparacionHistorial_ShouldReturnSavedRelacionReparacionHistorial() throws Exception {
        RelacionReparacionHistorialEntity savedRelacion = new RelacionReparacionHistorialEntity(1L, 1L, 1L);
        given(relacionReparacionHistorialService.saveRelacionReparacionHistorial(Mockito.any(RelacionReparacionHistorialEntity.class))).willReturn(savedRelacion);

        String relacionJson = """
        {
            "idHistorial": 1,
            "idReparacion": 1
        }
        """;

        mockMvc.perform(post("/api/relacionreparacionhistorial/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(relacionJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idRelacionReparacionHistorial", is(1)));
    }

    @Test
    public void updateRelacionReparacionHistorial_ShouldReturnUpdatedRelacionReparacionHistorial() throws Exception {
        RelacionReparacionHistorialEntity updatedRelacion = new RelacionReparacionHistorialEntity(1L, 1L, 1L);
        given(relacionReparacionHistorialService.updateRelacionReparacionHistorial(Mockito.any(RelacionReparacionHistorialEntity.class))).willReturn(updatedRelacion);

        String relacionJson = """
        {
            "idRelacionReparacionHistorial": 1,
            "idHistorial": 1,
            "idReparacion": 1
        }
        """;

        mockMvc.perform(put("/api/relacionreparacionhistorial/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(relacionJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idRelacionReparacionHistorial", is(1)));
    }

    @Test
    public void deleteRelacionReparacionHistorialById_ShouldReturn204() throws Exception {
        when(relacionReparacionHistorialService.deleteRelacionReparacionHistorial(1L)).thenReturn(true);

        mockMvc.perform(delete("/api/relacionreparacionhistorial/{id}", 1))
                .andExpect(status().isNoContent());
    }

    @Test
    public void getRelacionReparacionHistorialByHistorialId_ShouldReturnRelacionReparacionHistorial() throws Exception {
        RelacionReparacionHistorialEntity relacion = new RelacionReparacionHistorialEntity(1L, 1L, 1L);
        given(relacionReparacionHistorialService.getRelacionReparacionHistorialByHistorialId(1L)).willReturn(relacion);

        mockMvc.perform(get("/api/relacionreparacionhistorial/historial/{idHistorial}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idRelacionReparacionHistorial", is(1)));
    }

    @Test
    public void getRelacionReparacionHistorialByReparacionId_ShouldReturnRelacionReparacionHistorial() throws Exception {
        RelacionReparacionHistorialEntity relacion = new RelacionReparacionHistorialEntity(1L, 1L, 1L);
        given(relacionReparacionHistorialService.getRelacionReparacionHistorialByReparacionId(1L)).willReturn(relacion);

        mockMvc.perform(get("/api/relacionreparacionhistorial/reparacion/{idReparacion}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idRelacionReparacionHistorial", is(1)));
    }
}
