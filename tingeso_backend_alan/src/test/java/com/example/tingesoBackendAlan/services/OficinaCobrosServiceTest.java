package com.example.tingesoBackendAlan.services;

import ch.qos.logback.classic.Logger;
import com.example.tingesoBackendAlan.entities.*;
import com.example.tingesoBackendAlan.repositories.*;
import com.example.tingesoBackendAlan.services.DescuentosService;
import com.example.tingesoBackendAlan.services.ReparacionService;
import com.example.tingesoBackendAlan.services.OficinaCobrosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.time.LocalTime;
import  java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OficinaCobrosServiceTest {

    @Autowired
    private ReparacionService reparacionService;
    @Autowired
    private OficinaCobrosService oficinaCobrosService;
    @Autowired
    private HistorialService historialService;
    @Autowired
    private RelacionReparacionHistorialService relacionReparacionHistorialService;
    @Autowired
    private RecargosService recargosService;
    @Autowired
    private DescuentosService descuentosService;
    @Autowired
    private BonoService bonoService;

    @MockBean
    ReparacionRepository reparacionRepository;
    @MockBean
    AutoRepository autoRepository;
    @MockBean
    HistorialRepository historialRepository;
    @MockBean
    RelacionReparacionHistorialRepository relacionReparacionHistorialRepository;
    @MockBean
    BonoRepository bonoRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // inicializa los campos anotados con @MockBean
    }


    @Test
    public void testCalcularMontoReparacion() {
        // Crear y guardar un auto
        AutoEntity auto = new AutoEntity();
        auto.setPatente("ABC123");
        auto.setTipoMotor("Gasolina");
        autoRepository.save(auto);

        // Crear y guardar una reparación asociada al auto
        ReparacionEntity reparacion = new ReparacionEntity();
        reparacion.setPatente("ABC123");
        reparacion.setIdReparacion(1L);
        reparacion.setTipoReparacion(1);
        reparacionRepository.save(reparacion);

        // Configurar el comportamiento de los mocks para que devuelvan los objetos guardados
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(reparacionRepository.findByIdReparacion(1L)).thenReturn(reparacion);

        // Ejecutar el método que queremos probar
        double monto = oficinaCobrosService.calcularMontoReparacion(reparacion.getIdReparacion());

        // Verificar que el monto calculado es el esperado
        assertEquals(120000, monto);
    }


    @Test
    public void testCalcularMontoTotalNetoReparaciones() {
        // Crear y guardar un auto
        AutoEntity auto = new AutoEntity();
        auto.setPatente("ABC123");
        auto.setTipoMotor("Gasolina");
        autoRepository.save(auto);

        // Crear y guardar dos reparaciones asociadas al auto
        ReparacionEntity reparacion = new ReparacionEntity();
        reparacion.setPatente("ABC123");
        reparacion.setTipoReparacion(1);
        reparacion.setIdReparacion(1L);
        reparacionRepository.save(reparacion);

        ReparacionEntity reparacion2 = new ReparacionEntity();
        reparacion2.setPatente("ABC123");
        reparacion2.setTipoReparacion(4);
        reparacion2.setIdReparacion(2L);
        reparacionRepository.save(reparacion2);

        // Crear y guardar un historial asociado al auto
        HistorialEntity historial = new HistorialEntity();
        historial.setPatente("ABC123");
        historialRepository.save(historial);

        // Crear y guardar dos relaciones entre reparaciones e historial
        RelacionReparacionHistorialEntity relacionReparacionHistorial = new RelacionReparacionHistorialEntity();
        relacionReparacionHistorial.setIdHistorial(historial.getIdHistorial());
        relacionReparacionHistorial.setIdReparacion(reparacion.getIdReparacion());
        relacionReparacionHistorialRepository.save(relacionReparacionHistorial);

        RelacionReparacionHistorialEntity relacionReparacionHistorial2 = new RelacionReparacionHistorialEntity();
        relacionReparacionHistorial2.setIdHistorial(historial.getIdHistorial());
        relacionReparacionHistorial2.setIdReparacion(reparacion2.getIdReparacion());
        relacionReparacionHistorialRepository.save(relacionReparacionHistorial2);

        // Configurar el comportamiento de los mocks para que devuelvan los objetos guardados
        when(reparacionRepository.findByIdReparacion(reparacion.getIdReparacion())).thenReturn(reparacion);
        when(reparacionRepository.findByIdReparacion(reparacion2.getIdReparacion())).thenReturn(reparacion2);
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(historialRepository.findByIdHistorial(historial.getIdHistorial())).thenReturn(historial);
        when(relacionReparacionHistorialRepository.findAllByIdHistorial(historial.getIdHistorial()))
                .thenReturn(Arrays.asList(relacionReparacionHistorial, relacionReparacionHistorial2));

        // Ejecutar el método que queremos probar
        double montoNeto = oficinaCobrosService.calcularMontoTotalNetoReparaciones(historial.getIdHistorial());

        // Verificar que el monto calculado es el esperado
        assertEquals(330000, montoNeto);
    }

    @Test
    public void testCalcularRecargos() {

        // Crear y guardar un auto
        AutoEntity auto = new AutoEntity();
        auto.setPatente("ABC123");
        auto.setTipoMotor("Gasolina");
        auto.setTipo("Sedan");
        auto.setKilometraje(6000);
        auto.setAnio(2010);
        autoRepository.save(auto);

        // Crear y guardar una reparación asociada al auto
        ReparacionEntity reparacion = new ReparacionEntity();
        reparacion.setPatente("ABC123");
        reparacion.setTipoReparacion(1);
        reparacion.setIdReparacion(1L);
        reparacion.setFechaIngreso(LocalDate.parse("2021-06-01"));
        reparacion.setHoraIngreso(LocalTime.parse("10:00"));
        reparacion.setFechaSalida(LocalDate.parse("2021-06-02"));
        reparacion.setHoraSalida(LocalTime.parse("11:00"));
        reparacion.setFechaRetiro(LocalDate.parse("2021-06-03"));
        reparacion.setHoraRetiro(LocalTime.parse("11:30"));
        reparacionRepository.save(reparacion);

        // Crear y guardar un historial asociado al auto
        HistorialEntity historial = new HistorialEntity();
        historial.setPatente("ABC123");
        historial.setIdHistorial(3L);
        historialRepository.save(historial);

        // Crear y guardar una relación entre reparación e historial
        RelacionReparacionHistorialEntity relacionReparacionHistorial = new RelacionReparacionHistorialEntity();
        relacionReparacionHistorial.setIdHistorial(historial.getIdHistorial());
        relacionReparacionHistorial.setIdReparacion(reparacion.getIdReparacion());
        relacionReparacionHistorialRepository.save(relacionReparacionHistorial);

        // Configurar el comportamiento de los mocks para que devuelvan los objetos guardados
        when(reparacionRepository.findByIdReparacion(reparacion.getIdReparacion())).thenReturn(reparacion);
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(historialRepository.findByIdHistorial(historial.getIdHistorial())).thenReturn(historial);
        when(relacionReparacionHistorialRepository.findAllByIdHistorial(historial.getIdHistorial()))
                .thenReturn(Arrays.asList(relacionReparacionHistorial));

        // Ejecutar el método que queremos probar
        double recargo = oficinaCobrosService.calcularRecargos(historial.getIdHistorial());
        assertEquals(0.17, recargo);


    }

    @Test
    public void testCalcularDescuentos() {

        // Crear y guardar un auto
        AutoEntity auto = new AutoEntity();
        auto.setPatente("ABC123");
        auto.setTipoMotor("Gasolina");
        auto.setTipo("Sedan");
        auto.setMarca("Toyota");
        auto.setKilometraje(6000);
        auto.setAnio(2010);
        autoRepository.save(auto);

        // Crear y guardar una reparación asociada al auto
        ReparacionEntity reparacion = new ReparacionEntity();
        reparacion.setPatente("ABC123");
        reparacion.setTipoReparacion(1);
        reparacion.setIdReparacion(1L);
        reparacion.setFechaIngreso(LocalDate.parse("2024-04-29"));
        reparacion.setHoraIngreso(LocalTime.parse("10:00"));
        reparacion.setFechaSalida(LocalDate.parse("2024-04-30"));
        reparacion.setHoraSalida(LocalTime.parse("11:00"));
        reparacion.setFechaRetiro(LocalDate.parse("2024-05-01"));
        reparacion.setHoraRetiro(LocalTime.parse("12:00"));
        reparacionRepository.save(reparacion);

        // Crear y guardar un historial asociado al auto
        HistorialEntity historial = new HistorialEntity();
        historial.setPatente("ABC123");
        historial.setIdHistorial(3L);
        historialRepository.save(historial);

        // Crear y guardar una relación entre reparación e historial
        RelacionReparacionHistorialEntity relacionReparacionHistorial = new RelacionReparacionHistorialEntity();
        relacionReparacionHistorial.setIdHistorial(historial.getIdHistorial());
        relacionReparacionHistorial.setIdReparacion(reparacion.getIdReparacion());
        relacionReparacionHistorialRepository.save(relacionReparacionHistorial);

        // Configurar el comportamiento de los mocks para que devuelvan los objetos guardados
        when(reparacionRepository.findByIdReparacion(reparacion.getIdReparacion())).thenReturn(reparacion);
        when(historialRepository.findByIdHistorial(historial.getIdHistorial())).thenReturn(historial);
        when(relacionReparacionHistorialRepository.findAllByIdHistorial(historial.getIdHistorial()))
                .thenReturn(Arrays.asList(relacionReparacionHistorial));
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(reparacionRepository.countByPatente("ABC123")).thenReturn(1);

        // Ejecutar el método que queremos probar
        double descuento = oficinaCobrosService.calcularDescuentos(historial.getIdHistorial());
        assertEquals(0.15, descuento);

    }


    @Test
    public void testCalcularMontoTotalFinalReparaciones() {

        // Crear y guardar un auto
        AutoEntity auto = new AutoEntity();
        auto.setPatente("ABC123");
        auto.setTipoMotor("Gasolina");
        auto.setTipo("Sedan");
        auto.setMarca("Toyota");
        auto.setKilometraje(6000);
        auto.setAnio(2010);
        autoRepository.save(auto);

        // Crear y guardar dos reparaciones asociadas al auto
        ReparacionEntity reparacion = new ReparacionEntity();
        reparacion.setPatente("ABC123");
        reparacion.setTipoReparacion(1);
        reparacion.setIdReparacion(1L);
        reparacion.setFechaIngreso(LocalDate.parse("2021-06-01"));
        reparacion.setHoraIngreso(LocalTime.parse("10:00"));
        reparacion.setFechaSalida(LocalDate.parse("2021-06-02"));
        reparacion.setHoraSalida(LocalTime.parse("11:00"));
        reparacion.setFechaRetiro(LocalDate.parse("2021-06-03"));
        reparacion.setHoraRetiro(LocalTime.parse("11:30"));
        reparacionRepository.save(reparacion);

        ReparacionEntity reparacion2 = new ReparacionEntity();
        reparacion2.setPatente("ABC123");
        reparacion2.setTipoReparacion(4);
        reparacion2.setIdReparacion(2L);
        reparacion2.setFechaIngreso(LocalDate.parse("2021-06-01"));
        reparacion2.setHoraIngreso(LocalTime.parse("10:00"));
        reparacion2.setFechaSalida(LocalDate.parse("2021-06-02"));
        reparacion2.setHoraSalida(LocalTime.parse("11:00"));
        reparacion2.setFechaRetiro(LocalDate.parse("2021-06-03"));
        reparacion2.setHoraRetiro(LocalTime.parse("11:30"));
        reparacionRepository.save(reparacion2);

        // Crear y guardar un historial asociado al auto
        HistorialEntity historial = new HistorialEntity();
        historial.setPatente("ABC123");
        historial.setIdHistorial(3L);
        historialRepository.save(historial);

        // Crear y guardar dos relaciones entre reparaciones e historial
        RelacionReparacionHistorialEntity relacionReparacionHistorial = new RelacionReparacionHistorialEntity();
        relacionReparacionHistorial.setIdHistorial(historial.getIdHistorial());
        relacionReparacionHistorial.setIdReparacion(reparacion.getIdReparacion());
        relacionReparacionHistorialRepository.save(relacionReparacionHistorial);

        RelacionReparacionHistorialEntity relacionReparacionHistorial2 = new RelacionReparacionHistorialEntity();
        relacionReparacionHistorial2.setIdHistorial(historial.getIdHistorial());
        relacionReparacionHistorial2.setIdReparacion(reparacion2.getIdReparacion());
        relacionReparacionHistorialRepository.save(relacionReparacionHistorial2);

        // Crear y guardar bono
        BonoEntity bono = new BonoEntity();
        bono.setMarca("Toyota");
        bono.setNumeroBonos(5);
        bono.setMontoBono(70000);
        bonoRepository.save(bono);

        // Configurar el comportamiento de los mocks para que devuelvan los objetos guardados

        when(reparacionRepository.countByPatente("ABC123")).thenReturn(2);
        when(historialRepository.findByIdHistorial(historial.getIdHistorial())).thenReturn(historial);
        when(relacionReparacionHistorialRepository.findAllByIdHistorial(historial.getIdHistorial()))
                .thenReturn(Arrays.asList(relacionReparacionHistorial, relacionReparacionHistorial2));
        when(reparacionRepository.findByIdReparacion(reparacion.getIdReparacion())).thenReturn(reparacion);
        when(reparacionRepository.findByIdReparacion(reparacion2.getIdReparacion())).thenReturn(reparacion2);
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(bonoRepository.findByMarca("Toyota")).thenReturn(bono);


        // Ejecutar el método que queremos probar
        double montoFinal = oficinaCobrosService.calcularMontoTotalFinal(historial.getIdHistorial());

        // Verificar que el monto calculado es el esperado
        assertEquals(356524, montoFinal);
    }


}
