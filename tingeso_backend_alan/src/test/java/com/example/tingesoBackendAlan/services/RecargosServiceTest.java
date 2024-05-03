package com.example.tingesoBackendAlan.services;

import com.example.tingesoBackendAlan.entities.AutoEntity;
import com.example.tingesoBackendAlan.entities.ReparacionEntity;
import com.example.tingesoBackendAlan.repositories.ReparacionRepository;
import com.example.tingesoBackendAlan.services.RecargosService;
import com.example.tingesoBackendAlan.services.ReparacionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RecargosServiceTest {

    @Autowired
    private ReparacionService reparacionService;

    @MockBean
    private ReparacionRepository reparacionRepository;

    @Autowired
    private RecargosService recargosService;

    @BeforeEach
    public void setup() {MockitoAnnotations.openMocks(this);}

    @Test
    public void testCalcularRecargoPorKilometrajeSedan() {
        AutoEntity auto = new AutoEntity();
        auto.setKilometraje(6000);
        auto.setTipo("Sedan");

        double recargo = recargosService.calcularRecargoPorKilometraje(auto);
        assertEquals(0.03, recargo);
    }

    @Test
    public void testCalcularRecargoPorKilometrajeSedan2() {
        AutoEntity auto = new AutoEntity();
        auto.setKilometraje(12002);
        auto.setTipo("Sedan");

        double recargo = recargosService.calcularRecargoPorKilometraje(auto);
        assertEquals(0.07, recargo);
    }

    @Test
    public void testCalcularRecargoPorKilometrajeSedan3() {
        AutoEntity auto = new AutoEntity();
        auto.setKilometraje(25002);
        auto.setTipo("Sedan");

        double recargo = recargosService.calcularRecargoPorKilometraje(auto);
        assertEquals(0.12, recargo);
    }

    @Test
    public void testCalcularRecargoPorKilometrajeSedan4() {
        AutoEntity auto = new AutoEntity();
        auto.setKilometraje(40002);
        auto.setTipo("Sedan");

        double recargo = recargosService.calcularRecargoPorKilometraje(auto);
        assertEquals(0.20, recargo);
    }

    @Test
    public void testCalcularRecargoPorKilometrajeSUV1() {
        AutoEntity auto = new AutoEntity();
        auto.setKilometraje(6000);
        auto.setTipo("SUV");

        double recargo = recargosService.calcularRecargoPorKilometraje(auto);
        assertEquals(0.05, recargo);
    }

    @Test
    public void testCalcularRecargoPorKilometrajeSUV2() {
        AutoEntity auto = new AutoEntity();
        auto.setKilometraje(12002);
        auto.setTipo("SUV");

        double recargo = recargosService.calcularRecargoPorKilometraje(auto);
        assertEquals(0.09, recargo);
    }

    @Test
    public void testCalcularRecargoPorKilometrajeSUV3() {
        AutoEntity auto = new AutoEntity();
        auto.setKilometraje(25002);
        auto.setTipo("SUV");

        double recargo = recargosService.calcularRecargoPorKilometraje(auto);
        assertEquals(0.12, recargo);
    }

    @Test
    public void testCalcularRecargoPorKilometrajeSUV4() {
        AutoEntity auto = new AutoEntity();
        auto.setKilometraje(40002);
        auto.setTipo("SUV");

        double recargo = recargosService.calcularRecargoPorKilometraje(auto);
        assertEquals(0.20, recargo);
    }

    @Test
    public void testCalcularRecargoPorAntiguedadDelVehiculoSedan0() {
        AutoEntity auto = new AutoEntity();
        auto.setTipo("Sedan");
        auto.setAnio(2023);

        double recargo = recargosService.calcularRecargoPorAntiguedadDelVehiculo(auto);
        assertEquals(0, recargo);
    }

    @Test
    public void testCalcularRecargoPorAntiguedadDelVehiculoSedan1() {
        AutoEntity auto = new AutoEntity();
        auto.setTipo("Sedan");
        auto.setAnio(2015);

        double recargo = recargosService.calcularRecargoPorAntiguedadDelVehiculo(auto);
        assertEquals(0.05, recargo);
    }

    @Test
    public void testCalcularRecargoPorAntiguedadDelVehiculoSedan2() {
        AutoEntity auto = new AutoEntity();
        auto.setTipo("Sedan");
        auto.setAnio(2010);

        double recargo = recargosService.calcularRecargoPorAntiguedadDelVehiculo(auto);
        assertEquals(0.09, recargo);
    }

    @Test
    public void testCalcularRecargoPorAntiguedadDelVehiculoSedan3() {
        AutoEntity auto = new AutoEntity();
        auto.setTipo("Sedan");
        auto.setAnio(2005);

        double recargo = recargosService.calcularRecargoPorAntiguedadDelVehiculo(auto);
        assertEquals(0.15, recargo);
    }

    @Test
    public void testCalcularRecargoPorAntiguedadDelVehiculoSUV0() {
        AutoEntity auto = new AutoEntity();
        auto.setTipo("SUV");
        auto.setAnio(2023);

        double recargo = recargosService.calcularRecargoPorAntiguedadDelVehiculo(auto);
        assertEquals(0, recargo);
    }

    @Test
    public void testCalcularRecargoPorAntiguedadDelVehiculoSUV1() {
        AutoEntity auto = new AutoEntity();
        auto.setTipo("SUV");
        auto.setAnio(2015);

        double recargo = recargosService.calcularRecargoPorAntiguedadDelVehiculo(auto);
        assertEquals(0.07, recargo);
    }

    @Test
    public void testCalcularRecargoPorAntiguedadDelVehiculoSUV2() {
        AutoEntity auto = new AutoEntity();
        auto.setTipo("SUV");
        auto.setAnio(2010);

        double recargo = recargosService.calcularRecargoPorAntiguedadDelVehiculo(auto);
        assertEquals(0.11, recargo);
    }

    @Test
    public void testCalcularRecargoPorAntiguedadDelVehiculoSUV3() {
        AutoEntity auto = new AutoEntity();
        auto.setTipo("SUV");
        auto.setAnio(2005);

        double recargo = recargosService.calcularRecargoPorAntiguedadDelVehiculo(auto);
        assertEquals(0.2, recargo);
    }



    @Test
    public void testCalcularRecargoPorRetrasoRecogidaVehiculo(){
        AutoEntity auto = new AutoEntity();
        auto.setPatente("ABC123");

        ReparacionEntity reparacion = new ReparacionEntity();
        reparacion.setPatente("ABC123");
        reparacion.setFechaIngreso(LocalDate.of(2024, 04, 28));
        reparacion.setFechaSalida(LocalDate.of(2024, 04, 28));
        reparacion.setFechaRetiro(LocalDate.of(2024, 04, 30));

        double recargo = recargosService.calcularRecargoPorRetrasoRecogidaVehiculo(reparacion);
        assertEquals(0.10, recargo);
    }

}

