package com.example.tingesoBackendAlan.controllers;

import com.example.tingesoBackendAlan.entities.ReparacionEntity;
import com.example.tingesoBackendAlan.services.ReparacionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReparacionController.class)
public class ReparacionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ReparacionService reparacionService;

    @Test
    public void listReparaciones_ShouldReturnReparaciones() throws Exception {
        ReparacionEntity reparacion1 = new ReparacionEntity(
                1L,
                "ABC123",
                1,
                "Reparación 1",
                0,
                LocalDate.parse("2021-06-01"), // Fecha de ingreso
                LocalTime.parse("10:00:00"),    // Hora de ingreso
                LocalDate.parse("2021-06-01"), // Fecha de salida
                LocalTime.parse("12:00:00"),    // Hora de salida
                LocalDate.parse("2021-06-01"), // Fecha de retiro
                LocalTime.parse("14:00:00")     // Hora de retiro
        );
        ReparacionEntity reparacion2 = new ReparacionEntity(
                2L,
                "DEF456",
                2,
                "Reparación 2",
                0,
                LocalDate.parse("2021-06-02"), // Fecha de ingreso
                LocalTime.parse("10:00:00"),    // Hora de ingreso
                LocalDate.parse("2021-06-02"), // Fecha de salida
                LocalTime.parse("12:00:00"),    // Hora de salida
                LocalDate.parse("2021-06-02"), // Fecha de retiro
                LocalTime.parse("14:00:00")     // Hora de retiro
        );

        List<ReparacionEntity> reparacionList = new ArrayList<>(Arrays.asList(reparacion1, reparacion2));

        given(reparacionService.getReparaciones()).willReturn((ArrayList<ReparacionEntity>) reparacionList);

        mockMvc.perform(get("/api/reparaciones/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].idReparacion", is(1)))
                .andExpect(jsonPath("$[1].idReparacion", is(2)));
    }

    @Test
    public void getReparacionById_ShouldReturnReparacion() throws Exception {
        ReparacionEntity reparacion = new ReparacionEntity(
                1L,
                "ABC123",
                1,
                "Reparación 1",
                0,
                LocalDate.parse("2021-06-01"), // Fecha de ingreso
                LocalTime.parse("10:00:00"),    // Hora de ingreso
                LocalDate.parse("2021-06-01"), // Fecha de salida
                LocalTime.parse("12:00:00"),    // Hora de salida
                LocalDate.parse("2021-06-01"), // Fecha de retiro
                LocalTime.parse("14:00:00")     // Hora de retiro
        );
        given(reparacionService.getReparacionById(1L)).willReturn(reparacion);

        mockMvc.perform(get("/api/reparaciones/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idReparacion", is(1)));
    }

    @Test
    public void getReparacionByPatente_ShouldReturnReparacion() throws Exception {
        ReparacionEntity reparacion = new ReparacionEntity(
                1L,
                "ABC123",
                1,
                "Reparación 1",
                0,
                LocalDate.parse("2021-06-01"), // Fecha de ingreso
                LocalTime.parse("10:00:00"),    // Hora de ingreso
                LocalDate.parse("2021-06-01"), // Fecha de salida
                LocalTime.parse("12:00:00"),    // Hora de salida
                LocalDate.parse("2021-06-01"), // Fecha de retiro
                LocalTime.parse("14:00:00")     // Hora de retiro
        );
        given(reparacionService.getReparacionByPatente("ABC123")).willReturn(reparacion);

        mockMvc.perform(get("/api/reparaciones/patente/{patente}", "ABC123"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idReparacion", is(1)));
    }

    @Test
    public void countNumeroReparacionesByPatente_ShouldReturnCount() throws Exception {
        long count = 5;
        given(reparacionService.countNumeroReparacionesByPatente("ABC123")).willReturn(count);

        mockMvc.perform(get("/api/reparaciones/countByPatente/{patente}", "ABC123"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(5)));
    }

    @Test
    public void saveReparacion_ShouldReturnSavedReparacion() throws Exception {
        ReparacionEntity savedReparacion = new ReparacionEntity(
                1L,
                "ABC123",
                1,
                "Reparación 1",
                0,
                LocalDate.parse("2021-06-01"), // Fecha de ingreso
                LocalTime.parse("10:00:00"),    // Hora de ingreso
                LocalDate.parse("2021-06-01"), // Fecha de salida
                LocalTime.parse("12:00:00"),    // Hora de salida
                LocalDate.parse("2021-06-01"), // Fecha de retiro
                LocalTime.parse("14:00:00")     // Hora de retiro
        );
        given(reparacionService.saveReparacion(Mockito.any(ReparacionEntity.class))).willReturn(savedReparacion);

        String reparacionJson = """
        {
            "idReparacion": 1,
            "patente": "ABC123",
            "tipoReparacion": 1,
            "descripcion": "Reparación 1",
            "montoReparacion": 0,
            "fechaIngreso": "2021-06-01",
            "horaIngreso": "10:00:00",
            "fechaSalida": "2021-06-01",
            "horaSalida": "12:00:00",
            "fechaRetiro": "2021-06-01",
            "horaRetiro": "14:00:00"
        }
        """;

        mockMvc.perform(post("/api/reparaciones/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(reparacionJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idReparacion", is(1)));
    }

    @Test
    public void updateReparacion_ShouldReturnUpdatedReparacion() throws Exception {
        ReparacionEntity updatedReparacion = new ReparacionEntity(
                1L,
                "ABC123",
                1,
                "Reparación 1",
                0,
                LocalDate.parse("2021-06-01"), // Fecha de ingreso
                LocalTime.parse("10:00:00"),    // Hora de ingreso
                LocalDate.parse("2021-06-01"), // Fecha de salida
                LocalTime.parse("12:00:00"),    // Hora de salida
                LocalDate.parse("2021-06-01"), // Fecha de retiro
                LocalTime.parse("14:00:00")     // Hora de retiro
        );
        given(reparacionService.updateReparacion(Mockito.any(ReparacionEntity.class))).willReturn(updatedReparacion);

        String reparacionJson = """
        {
            "idReparacion": 1,
            "patente": "ABC123",
            "tipoReparacion": 1,
            "descripcion": "Reparación 1",
            "montoReparacion": 0,
            "fechaIngreso": "2021-06-01",
            "horaIngreso": "10:00:00",
            "fechaSalida": "2021-06-01",
            "horaSalida": "12:00:00",
            "fechaRetiro": "2021-06-01",
            "horaRetiro": "14:00:00"
        }
        """;

        mockMvc.perform(put("/api/reparaciones/", "ABC123")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(reparacionJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idReparacion", is(1)));
    }

    @Test
    public void deleteReparacionById_ShouldReturn204() throws Exception {
        when(reparacionService.deleteReparacion(1L)).thenReturn(true);

        mockMvc.perform(delete("/api/reparaciones/id/{id}", 1))
                .andExpect(status().isNoContent());
    }
}
