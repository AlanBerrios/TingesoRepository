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
    public void testDescuentoNumeroDeReparacionesGasolina2() {

        AutoEntity auto = new AutoEntity();
        ReparacionEntity reparacion = new ReparacionEntity();
        ReparacionEntity reparacion2 = new ReparacionEntity();

        auto.setPatente("ABC123");
        auto.setTipoMotor("Gasolina");

        reparacion.setPatente("ABC123");
        reparacion.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion);


        // Configura el comportamiento simulado de reparacionRepository
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(reparacionRepository.countByPatente("ABC123")).thenReturn(2);

        double descuento = descuentosService.calcularDescuentoNumeroDeReparaciones("ABC123");
        assertEquals(0.05, descuento);
    }
    @Test
    public void testDescuentoNumeroDeReparacionesGasolina3() {

        AutoEntity auto = new AutoEntity();
        ReparacionEntity reparacion = new ReparacionEntity();
        ReparacionEntity reparacion2 = new ReparacionEntity();
        ReparacionEntity reparacion3 = new ReparacionEntity();

        auto.setPatente("ABC123");
        auto.setTipoMotor("Gasolina");

        reparacion.setPatente("ABC123");
        reparacion.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion);

        reparacion2.setPatente("ABC123");
        reparacion2.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion2);

        reparacion3.setPatente("ABC123");
        reparacion3.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion3);

        // Configura el comportamiento simulado de reparacionRepository
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(reparacionRepository.countByPatente("ABC123")).thenReturn(3);

        double descuento = descuentosService.calcularDescuentoNumeroDeReparaciones("ABC123");
        assertEquals(0.10, descuento);
    }
    @Test
    public void testDescuentoNumeroDeReparacionesGasolina6() {

        AutoEntity auto = new AutoEntity();
        ReparacionEntity reparacion = new ReparacionEntity();
        ReparacionEntity reparacion2 = new ReparacionEntity();
        ReparacionEntity reparacion3 = new ReparacionEntity();
        ReparacionEntity reparacion4 = new ReparacionEntity();
        ReparacionEntity reparacion5 = new ReparacionEntity();
        ReparacionEntity reparacion6 = new ReparacionEntity();

        auto.setPatente("ABC123");
        auto.setTipoMotor("Gasolina");

        reparacion.setPatente("ABC123");
        reparacion.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion);

        reparacion2.setPatente("ABC123");
        reparacion2.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion2);

        reparacion3.setPatente("ABC123");
        reparacion3.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion3);

        reparacion4.setPatente("ABC123");
        reparacion4.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion4);

        reparacion5.setPatente("ABC123");
        reparacion5.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion5);

        reparacion6.setPatente("ABC123");
        reparacion6.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion6);

        // Configura el comportamiento simulado de reparacionRepository
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(reparacionRepository.countByPatente("ABC123")).thenReturn(6);

        double descuento = descuentosService.calcularDescuentoNumeroDeReparaciones("ABC123");
        assertEquals(0.15, descuento);
    }
    @Test
    public void testDescuentoNumeroDeReparacionesGasolina10() {

        AutoEntity auto = new AutoEntity();
        ReparacionEntity reparacion = new ReparacionEntity();
        ReparacionEntity reparacion2 = new ReparacionEntity();
        ReparacionEntity reparacion3 = new ReparacionEntity();
        ReparacionEntity reparacion4 = new ReparacionEntity();
        ReparacionEntity reparacion5 = new ReparacionEntity();
        ReparacionEntity reparacion6 = new ReparacionEntity();
        ReparacionEntity reparacion7 = new ReparacionEntity();
        ReparacionEntity reparacion8 = new ReparacionEntity();
        ReparacionEntity reparacion9 = new ReparacionEntity();
        ReparacionEntity reparacion10 = new ReparacionEntity();

        auto.setPatente("ABC123");
        auto.setTipoMotor("Gasolina");

        reparacion.setPatente("ABC123");
        reparacion.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion);

        reparacion2.setPatente("ABC123");
        reparacion2.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion2);

        reparacion3.setPatente("ABC123");
        reparacion3.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion3);

        reparacion4.setPatente("ABC123");
        reparacion4.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion4);

        reparacion5.setPatente("ABC123");
        reparacion5.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion5);

        reparacion6.setPatente("ABC123");
        reparacion6.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion6);

        reparacion7.setPatente("ABC123");
        reparacion7.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion7);

        reparacion8.setPatente("ABC123");
        reparacion8.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion8);

        reparacion9.setPatente("ABC123");
        reparacion9.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion9);

        reparacion10.setPatente("ABC123");
        reparacion10.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion10);

        // Configura el comportamiento simulado de reparacionRepository
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(reparacionRepository.countByPatente("ABC123")).thenReturn(10);

        double descuento = descuentosService.calcularDescuentoNumeroDeReparaciones("ABC123");
        assertEquals(0.20, descuento);
    }

    @Test
    public void testDescuentoNumeroDeReparacionesDiesel2() {

        AutoEntity auto = new AutoEntity();
        ReparacionEntity reparacion = new ReparacionEntity();
        ReparacionEntity reparacion2 = new ReparacionEntity();

        auto.setPatente("ABC123");
        auto.setTipoMotor("Diesel");

        reparacion.setPatente("ABC123");
        reparacion.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion);

        // Configura el comportamiento simulado de reparacionRepository
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(reparacionRepository.countByPatente("ABC123")).thenReturn(2);

        double descuento = descuentosService.calcularDescuentoNumeroDeReparaciones("ABC123");
        assertEquals(0.07, descuento);
    }
    @Test
    public void testDescuentoNumeroDeReparacionesDiesel3() {

        AutoEntity auto = new AutoEntity();
        ReparacionEntity reparacion = new ReparacionEntity();
        ReparacionEntity reparacion2 = new ReparacionEntity();
        ReparacionEntity reparacion3 = new ReparacionEntity();

        auto.setPatente("ABC123");
        auto.setTipoMotor("Diesel");

        reparacion.setPatente("ABC123");
        reparacion.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion);

        reparacion2.setPatente("ABC123");
        reparacion2.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion2);

        reparacion3.setPatente("ABC123");
        reparacion3.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion3);

        // Configura el comportamiento simulado de reparacionRepository
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(reparacionRepository.countByPatente("ABC123")).thenReturn(3);

        double descuento = descuentosService.calcularDescuentoNumeroDeReparaciones("ABC123");
        assertEquals(0.12, descuento);
    }
    @Test
    public void testDescuentoNumeroDeReparacionesDiesel6() {

        AutoEntity auto = new AutoEntity();
        ReparacionEntity reparacion = new ReparacionEntity();
        ReparacionEntity reparacion2 = new ReparacionEntity();
        ReparacionEntity reparacion3 = new ReparacionEntity();
        ReparacionEntity reparacion4 = new ReparacionEntity();
        ReparacionEntity reparacion5 = new ReparacionEntity();
        ReparacionEntity reparacion6 = new ReparacionEntity();

        auto.setPatente("ABC123");
        auto.setTipoMotor("Diesel");

        reparacion.setPatente("ABC123");
        reparacion.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion);

        reparacion2.setPatente("ABC123");
        reparacion2.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion2);

        reparacion3.setPatente("ABC123");
        reparacion3.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion3);

        reparacion4.setPatente("ABC123");
        reparacion4.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion4);

        reparacion5.setPatente("ABC123");
        reparacion5.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion5);

        reparacion6.setPatente("ABC123");
        reparacion6.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion6);

        // Configura el comportamiento simulado de reparacionRepository
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(reparacionRepository.countByPatente("ABC123")).thenReturn(6);

        double descuento = descuentosService.calcularDescuentoNumeroDeReparaciones("ABC123");
        assertEquals(0.17, descuento);
    }
    @Test
    public void testDescuentoNumeroDeReparacionesDiesel10() {

        AutoEntity auto = new AutoEntity();
        ReparacionEntity reparacion = new ReparacionEntity();
        ReparacionEntity reparacion2 = new ReparacionEntity();
        ReparacionEntity reparacion3 = new ReparacionEntity();
        ReparacionEntity reparacion4 = new ReparacionEntity();
        ReparacionEntity reparacion5 = new ReparacionEntity();
        ReparacionEntity reparacion6 = new ReparacionEntity();
        ReparacionEntity reparacion7 = new ReparacionEntity();
        ReparacionEntity reparacion8 = new ReparacionEntity();
        ReparacionEntity reparacion9 = new ReparacionEntity();
        ReparacionEntity reparacion10 = new ReparacionEntity();

        auto.setPatente("ABC123");
        auto.setTipoMotor("Diesel");

        reparacion.setPatente("ABC123");
        reparacion.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion);

        reparacion2.setPatente("ABC123");
        reparacion2.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion2);

        reparacion3.setPatente("ABC123");
        reparacion3.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion3);

        reparacion4.setPatente("ABC123");
        reparacion4.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion4);

        reparacion5.setPatente("ABC123");
        reparacion5.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion5);

        reparacion6.setPatente("ABC123");
        reparacion6.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion6);

        reparacion7.setPatente("ABC123");
        reparacion7.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion7);

        reparacion8.setPatente("ABC123");
        reparacion8.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion8);

        reparacion9.setPatente("ABC123");
        reparacion9.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion9);

        reparacion10.setPatente("ABC123");
        reparacion10.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion10);

        // Configura el comportamiento simulado de reparacionRepository
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(reparacionRepository.countByPatente("ABC123")).thenReturn(10);

        double descuento = descuentosService.calcularDescuentoNumeroDeReparaciones("ABC123");
        assertEquals(0.22, descuento);
    }

    @Test
    public void testDescuentoNumeroDeReparacionesHibrido2() {

        AutoEntity auto = new AutoEntity();
        ReparacionEntity reparacion = new ReparacionEntity();
        ReparacionEntity reparacion2 = new ReparacionEntity();

        auto.setPatente("ABC123");
        auto.setTipoMotor("Hibrido");

        reparacion.setPatente("ABC123");
        reparacion.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion);

        // Configura el comportamiento simulado de reparacionRepository
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(reparacionRepository.countByPatente("ABC123")).thenReturn(2);

        double descuento = descuentosService.calcularDescuentoNumeroDeReparaciones("ABC123");
        assertEquals(0.10, descuento);
    }
    @Test
    public void testDescuentoNumeroDeReparacionesHibrido3() {

        AutoEntity auto = new AutoEntity();
        ReparacionEntity reparacion = new ReparacionEntity();
        ReparacionEntity reparacion2 = new ReparacionEntity();
        ReparacionEntity reparacion3 = new ReparacionEntity();

        auto.setPatente("ABC123");
        auto.setTipoMotor("Hibrido");

        reparacion.setPatente("ABC123");
        reparacion.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion);

        reparacion2.setPatente("ABC123");
        reparacion2.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion2);

        reparacion3.setPatente("ABC123");
        reparacion3.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion3);

        // Configura el comportamiento simulado de reparacionRepository
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(reparacionRepository.countByPatente("ABC123")).thenReturn(3);

        double descuento = descuentosService.calcularDescuentoNumeroDeReparaciones("ABC123");
        assertEquals(0.15, descuento);
    }
    @Test
    public void testDescuentoNumeroDeReparacionesHibrido6() {

        AutoEntity auto = new AutoEntity();
        ReparacionEntity reparacion = new ReparacionEntity();
        ReparacionEntity reparacion2 = new ReparacionEntity();
        ReparacionEntity reparacion3 = new ReparacionEntity();
        ReparacionEntity reparacion4 = new ReparacionEntity();
        ReparacionEntity reparacion5 = new ReparacionEntity();
        ReparacionEntity reparacion6 = new ReparacionEntity();

        auto.setPatente("ABC123");
        auto.setTipoMotor("Hibrido");

        reparacion.setPatente("ABC123");
        reparacion.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion);

        reparacion2.setPatente("ABC123");
        reparacion2.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion2);

        reparacion3.setPatente("ABC123");
        reparacion3.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion3);

        reparacion4.setPatente("ABC123");
        reparacion4.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion4);

        reparacion5.setPatente("ABC123");
        reparacion5.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion5);

        reparacion6.setPatente("ABC123");
        reparacion6.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion6);

        // Configura el comportamiento simulado de reparacionRepository
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(reparacionRepository.countByPatente("ABC123")).thenReturn(6);

        double descuento = descuentosService.calcularDescuentoNumeroDeReparaciones("ABC123");
        assertEquals(0.20, descuento);
    }
    @Test
    public void testDescuentoNumeroDeReparacionesHibrido10() {

        AutoEntity auto = new AutoEntity();
        ReparacionEntity reparacion = new ReparacionEntity();
        ReparacionEntity reparacion2 = new ReparacionEntity();
        ReparacionEntity reparacion3 = new ReparacionEntity();
        ReparacionEntity reparacion4 = new ReparacionEntity();
        ReparacionEntity reparacion5 = new ReparacionEntity();
        ReparacionEntity reparacion6 = new ReparacionEntity();
        ReparacionEntity reparacion7 = new ReparacionEntity();
        ReparacionEntity reparacion8 = new ReparacionEntity();
        ReparacionEntity reparacion9 = new ReparacionEntity();
        ReparacionEntity reparacion10 = new ReparacionEntity();

        auto.setPatente("ABC123");
        auto.setTipoMotor("Hibrido");

        reparacion.setPatente("ABC123");
        reparacion.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion);

        reparacion2.setPatente("ABC123");
        reparacion2.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion2);

        reparacion3.setPatente("ABC123");
        reparacion3.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion3);

        reparacion4.setPatente("ABC123");
        reparacion4.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion4);

        reparacion5.setPatente("ABC123");
        reparacion5.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion5);

        reparacion6.setPatente("ABC123");
        reparacion6.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion6);

        reparacion7.setPatente("ABC123");
        reparacion7.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion7);

        reparacion8.setPatente("ABC123");
        reparacion8.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion8);

        reparacion9.setPatente("ABC123");
        reparacion9.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion9);

        reparacion10.setPatente("ABC123");
        reparacion10.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion10);

        // Configura el comportamiento simulado de reparacionRepository
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(reparacionRepository.countByPatente("ABC123")).thenReturn(10);

        double descuento = descuentosService.calcularDescuentoNumeroDeReparaciones("ABC123");
        assertEquals(0.25, descuento);
    }

    @Test
    public void testDescuentoNumeroDeReparacionesElectrico2() {

        AutoEntity auto = new AutoEntity();
        ReparacionEntity reparacion = new ReparacionEntity();
        ReparacionEntity reparacion2 = new ReparacionEntity();

        auto.setPatente("ABC123");
        auto.setTipoMotor("Electrico");

        reparacion.setPatente("ABC123");
        reparacion.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion);

        // Configura el comportamiento simulado de reparacionRepository
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(reparacionRepository.countByPatente("ABC123")).thenReturn(2);

        double descuento = descuentosService.calcularDescuentoNumeroDeReparaciones("ABC123");
        assertEquals(0.08, descuento);
    }
    @Test
    public void testDescuentoNumeroDeReparacionesElectrico3() {

        AutoEntity auto = new AutoEntity();
        ReparacionEntity reparacion = new ReparacionEntity();
        ReparacionEntity reparacion2 = new ReparacionEntity();
        ReparacionEntity reparacion3 = new ReparacionEntity();

        auto.setPatente("ABC123");
        auto.setTipoMotor("Electrico");

        reparacion.setPatente("ABC123");
        reparacion.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion);

        reparacion2.setPatente("ABC123");
        reparacion2.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion2);

        reparacion3.setPatente("ABC123");
        reparacion3.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion3);

        // Configura el comportamiento simulado de reparacionRepository
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(reparacionRepository.countByPatente("ABC123")).thenReturn(3);

        double descuento = descuentosService.calcularDescuentoNumeroDeReparaciones("ABC123");
        assertEquals(0.13, descuento);
    }
    @Test
    public void testDescuentoNumeroDeReparacionesElectrico6() {

        AutoEntity auto = new AutoEntity();
        ReparacionEntity reparacion = new ReparacionEntity();
        ReparacionEntity reparacion2 = new ReparacionEntity();
        ReparacionEntity reparacion3 = new ReparacionEntity();
        ReparacionEntity reparacion4 = new ReparacionEntity();
        ReparacionEntity reparacion5 = new ReparacionEntity();
        ReparacionEntity reparacion6 = new ReparacionEntity();

        auto.setPatente("ABC123");
        auto.setTipoMotor("Electrico");

        reparacion.setPatente("ABC123");
        reparacion.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion);

        reparacion2.setPatente("ABC123");
        reparacion2.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion2);

        reparacion3.setPatente("ABC123");
        reparacion3.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion3);

        reparacion4.setPatente("ABC123");
        reparacion4.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion4);

        reparacion5.setPatente("ABC123");
        reparacion5.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion5);

        reparacion6.setPatente("ABC123");
        reparacion6.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion6);

        // Configura el comportamiento simulado de reparacionRepository
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(reparacionRepository.countByPatente("ABC123")).thenReturn(6);

        double descuento = descuentosService.calcularDescuentoNumeroDeReparaciones("ABC123");
        assertEquals(0.18, descuento);
    }
    @Test
    public void testDescuentoNumeroDeReparacionesElectrico10() {

        AutoEntity auto = new AutoEntity();
        ReparacionEntity reparacion = new ReparacionEntity();
        ReparacionEntity reparacion2 = new ReparacionEntity();
        ReparacionEntity reparacion3 = new ReparacionEntity();
        ReparacionEntity reparacion4 = new ReparacionEntity();
        ReparacionEntity reparacion5 = new ReparacionEntity();
        ReparacionEntity reparacion6 = new ReparacionEntity();
        ReparacionEntity reparacion7 = new ReparacionEntity();
        ReparacionEntity reparacion8 = new ReparacionEntity();
        ReparacionEntity reparacion9 = new ReparacionEntity();
        ReparacionEntity reparacion10 = new ReparacionEntity();

        auto.setPatente("ABC123");
        auto.setTipoMotor("Electrico");

        reparacion.setPatente("ABC123");
        reparacion.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion);

        reparacion2.setPatente("ABC123");
        reparacion2.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion2);

        reparacion3.setPatente("ABC123");
        reparacion3.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion3);

        reparacion4.setPatente("ABC123");
        reparacion4.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion4);

        reparacion5.setPatente("ABC123");
        reparacion5.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion5);

        reparacion6.setPatente("ABC123");
        reparacion6.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion6);

        reparacion7.setPatente("ABC123");
        reparacion7.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion7);

        reparacion8.setPatente("ABC123");
        reparacion8.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion8);

        reparacion9.setPatente("ABC123");
        reparacion9.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion9);

        reparacion10.setPatente("ABC123");
        reparacion10.setFechaSalida(LocalDate.now().minusMonths(1));
        reparacionRepository.save(reparacion10);

        // Configura el comportamiento simulado de reparacionRepository
        when(autoRepository.findByPatente("ABC123")).thenReturn(auto);
        when(reparacionRepository.countByPatente("ABC123")).thenReturn(10);

        double descuento = descuentosService.calcularDescuentoNumeroDeReparaciones("ABC123");
        assertEquals(0.23, descuento);
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
}

