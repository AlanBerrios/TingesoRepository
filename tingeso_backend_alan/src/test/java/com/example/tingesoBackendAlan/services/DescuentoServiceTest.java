package com.example.tingesoBackendAlan.services;

import com.example.tingesoBackendAlan.entities.AutoEntity;
import com.example.tingesoBackendAlan.entities.BonoEntity;
import com.example.tingesoBackendAlan.entities.ReparacionEntity;
import com.example.tingesoBackendAlan.repositories.AutoRepository;
import com.example.tingesoBackendAlan.repositories.BonoRepository;
import com.example.tingesoBackendAlan.repositories.ReparacionRepository;
import com.example.tingesoBackendAlan.services.DescuentosService;
import com.example.tingesoBackendAlan.services.ReparacionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DescuentoServiceTest {

    @Autowired
    private ReparacionService reparacionService;

    @MockBean
    private AutoRepository autoRepository;

    @MockBean
    private ReparacionRepository reparacionRepository;

    @MockBean
    private BonoRepository bonoRepository;

    @Autowired
    private DescuentosService descuentosService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // inicializa los campos anotados con @MockBean
    }

    @Test
    public void testDescuentoNumeroDeReparaciones() {

        AutoEntity auto = new AutoEntity();
        ReparacionEntity reparacion = new ReparacionEntity();

        auto.setPatente("ABC123");
        auto.setTipoMotor("Gasolina");

        reparacion.setPatente("ABC123");
        reparacionRepository.save(reparacion);

        // Configura el comportamiento simulado de reparacionRepository
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(reparacionRepository.countByPatente("ABC123")).thenReturn(1);

        double descuento = descuentosService.calcularDescuentoNumeroDeReparaciones("ABC123");
        assertEquals(0.05, descuento);
    }

    @Test
    public void testCalcularDescuentoDiaDeAtencion() {
        AutoEntity auto = new AutoEntity();
        ReparacionEntity reparacion = new ReparacionEntity();

        auto.setPatente("ABC123");

        reparacion.setPatente("ABC123");
        reparacion.setTipoReparacion(1);
        reparacion.setIdReparacion(1L);
        reparacion.setFechaIngreso(LocalDate.parse("2024-04-29"));
        reparacion.setHoraIngreso(LocalTime.parse("10:00"));
        reparacion.setFechaSalida(LocalDate.parse("2024-04-30"));
        reparacion.setHoraSalida(LocalTime.parse("11:00"));
        reparacion.setFechaRetiro(LocalDate.parse("2024-05-01"));
        reparacion.setHoraRetiro(LocalTime.parse("12:00"));

        double descuento = descuentosService.calcularDescuentoDiaDeAtencion(reparacion);
        assertEquals(0.10, descuento);
    }


    @Test
    public void testCalcularDescuentoPorBono() {

        AutoEntity auto = new AutoEntity();
        auto.setPatente("ABC123");
        auto.setMarca("Toyota");

        BonoEntity bono = new BonoEntity();
        bono.setMarca("Toyota");
        bono.setNumeroBonos(5);
        bono.setMontoBono(70000);
        bonoRepository.save(bono);

        when(bonoRepository.findByMarca("Toyota")).thenReturn(bono);

        double montobono = descuentosService.calcularDescuentoPorBono(auto);
        assertEquals(70000, montobono);
    }
}

