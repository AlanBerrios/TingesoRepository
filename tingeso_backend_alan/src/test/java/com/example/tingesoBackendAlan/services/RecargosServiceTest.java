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
    public void setup() {
        MockitoAnnotations.openMocks(this); // inicializa los campos anotados con @MockBean
    }

    @Test
    public void testCalcularRecargoPorKilometraje() {
        AutoEntity auto = new AutoEntity();
        auto.setKilometraje(6000);
        auto.setTipo("Sedan");

        double recargo = recargosService.calcularRecargoPorKilometraje(auto);
        assertEquals(0.03, recargo);
    }


    @Test
    public void testCalcularRecargoPorAntiguedadDelVehiculo() {
        AutoEntity auto = new AutoEntity();
        auto.setTipo("Sedan");
        auto.setAnio(2015);

        double recargo = recargosService.calcularRecargoPorAntiguedadDelVehiculo(auto);
        assertEquals(0.05, recargo);
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

