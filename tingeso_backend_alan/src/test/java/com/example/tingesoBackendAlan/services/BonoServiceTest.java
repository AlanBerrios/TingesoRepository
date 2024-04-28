package com.example.tingesoBackendAlan.services;

import com.example.tingesoBackendAlan.entities.AutoEntity;
import com.example.tingesoBackendAlan.entities.BonoEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
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
public class BonoServiceTest {

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
    @Autowired
    private BonoService bonoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // inicializa los campos anotados con @MockBean
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

        double montobono = bonoService.usarBono("Toyota");
        assertEquals(70000, montobono);
    }

}
