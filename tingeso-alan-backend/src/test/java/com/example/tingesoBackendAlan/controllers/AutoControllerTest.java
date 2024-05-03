package com.example.tingesoBackendAlan.controllers;

import com.example.tingesoBackendAlan.entities.AutoEntity;
import com.example.tingesoBackendAlan.services.*;
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

@WebMvcTest(AutoController.class)
public class AutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AutoService autoService;
    @MockBean
    OficinaCobrosService oficinaCobrosService;
    @MockBean
    HistorialService historialService;
    @MockBean
    RecargosService recargosService;
    @MockBean
    DescuentosService descuentosService;

    @Test
    public void listAutos_ShouldReturnAutos() throws Exception {
        AutoEntity auto1 = new AutoEntity(
                "ABC123",
                "Toyota",
                "Corolla",
                "Sedan",
                2010,
                "Gasolina",
                2,
                6700);
        AutoEntity auto2 = new AutoEntity(
                "DEF456",
                "Chevrolet",
                "Spark",
                "Hatchback",
                2015,
                "Gasolina",
                4,
                5000);

        List<AutoEntity> autoList = new ArrayList<>(Arrays.asList(auto1, auto2));

        given(autoService.getAutos()).willReturn((ArrayList<AutoEntity>) autoList);

        mockMvc.perform(get("/api/auto/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].patente", is("ABC123")))
                .andExpect(jsonPath("$[1].patente", is("DEF456")));
    }

    @Test
    public void getAutoByPatente_ShouldReturnAuto() throws Exception {
        AutoEntity auto = new AutoEntity();
        auto.setPatente("ABC123");

        given(autoService.getAutoByPatente("ABC123")).willReturn(auto);

        mockMvc.perform(get("/api/auto/{patente}", "ABC123"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.patente", is("ABC123")));
    }

    @Test
    public void saveAuto_ShouldReturnSavedAuto() throws Exception {
        AutoEntity savedAuto = new AutoEntity();
        savedAuto.setPatente("ABC123");

        given(autoService.saveAuto(Mockito.any(AutoEntity.class))).willReturn(savedAuto);

        String autoJson = """
        {
            "patente": "ABC123"
        }
        """;

        mockMvc.perform(post("/api/auto/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(autoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.patente", is("ABC123")));
    }

    @Test
    public void updateAuto_ShouldReturnUpdatedAuto() throws Exception {
        AutoEntity updatedAuto = new AutoEntity();
        updatedAuto.setPatente("ABC123");

        given(autoService.updateAuto(Mockito.any(AutoEntity.class))).willReturn(updatedAuto);

        String autoJson = """
        {
            "patente": "ABC123"
        }
        """;

        mockMvc.perform(put("/api/auto/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(autoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.patente", is("ABC123")));
    }

    @Test
    public void deleteAutoByPatente_ShouldReturn204() throws Exception {
        when(autoService.deleteAuto("ABC123")).thenReturn(true);

        mockMvc.perform(delete("/api/auto/{patente}", "ABC123"))
                .andExpect(status().isNoContent());
    }

}

