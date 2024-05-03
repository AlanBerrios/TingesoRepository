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
import java.util.ArrayList;

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

    @Test
    public void testGetBonos() {
        BonoEntity bono1 = new BonoEntity();
        bono1.setMarca("Toyota");
        BonoEntity bono2 = new BonoEntity();
        bono2.setMarca("Nissan");
        ArrayList<BonoEntity> bonos = new ArrayList<>();
        bonos.add(bono1);
        bonos.add(bono2);

        when(bonoRepository.findAll()).thenReturn(bonos);

        ArrayList<BonoEntity> bonosObtenidos = bonoService.getBonos();

        for (BonoEntity bono : bonosObtenidos) {
            System.out.println(bono.getMarca());
        }

        for (BonoEntity bono : bonos) {
            System.out.println(bono.getMarca());
        }
    }

    @Test
    public void testSaveBono() {
        BonoEntity bono = new BonoEntity();
        bono.setMarca("Toyota");

        when(bonoRepository.save(bono)).thenReturn(bono);

        BonoEntity bonoObtenido = bonoService.saveBono(bono);

        assertEquals(bono.getMarca(), bonoObtenido.getMarca());
    }

    @Test
    public void testGetBonoById() {
        Long idBono = 1L;
        BonoEntity bono = new BonoEntity();
        bono.setIdBono(idBono);

        when(bonoRepository.findByIdBono(idBono)).thenReturn(bono);

        BonoEntity bonoObtenido = bonoService.getBonoById(idBono);

        assertEquals(idBono, bonoObtenido.getIdBono());
    }

    @Test
    public void testGetBonoByMarca() {
        String marca = "Toyota";
        BonoEntity bono = new BonoEntity();
        bono.setMarca(marca);

        when(bonoRepository.findByMarca(marca)).thenReturn(bono);

        BonoEntity bonoObtenido = bonoService.getBonoByMarca(marca);

        assertEquals(marca, bonoObtenido.getMarca());
    }

    @Test
    public void testUpdateBono() {
        BonoEntity bono = new BonoEntity();
        bono.setMarca("Toyota");

        when(bonoRepository.save(bono)).thenReturn(bono);

        BonoEntity bonoObtenido = bonoService.updateBono(bono);

        assertEquals(bono.getMarca(), bonoObtenido.getMarca());
    }

    @Test
    public void testDeleteBono() {
        Long idBono = 1L;
        BonoEntity bono = new BonoEntity();
        bono.setIdBono(idBono);

        boolean resultado = bonoService.deleteBono(idBono);

        assertEquals(true, resultado);
    }

    @Test
    public void testUsarBono() {
        String marca = "Toyota";
        BonoEntity bono = new BonoEntity();
        bono.setMarca(marca);
        bono.setNumeroBonos(5);
        bono.setMontoBono(70000);

        when(bonoRepository.findByMarca(marca)).thenReturn(bono);

        double monto = bonoService.usarBono(marca);

        assertEquals(70000, monto);
    }

    @Test
    public void testUsarBonoNoExiste() {
        String marca = "Toyota";
        BonoEntity bono = null;

        when(bonoRepository.findByMarca(marca)).thenReturn(bono);

        double monto = bonoService.usarBono(marca);

        assertEquals(0, monto);
    }

    @Test
    public void testUsarBonoSinBonos() {
        String marca = "Toyota";
        BonoEntity bono = new BonoEntity();
        bono.setMarca(marca);
        bono.setNumeroBonos(0);
        bono.setMontoBono(70000);

        when(bonoRepository.findByMarca(marca)).thenReturn(bono);

        double monto = bonoService.usarBono(marca);

        assertEquals(0, monto);
    }

}
