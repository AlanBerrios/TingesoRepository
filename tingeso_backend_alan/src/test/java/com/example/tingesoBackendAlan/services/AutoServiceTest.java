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
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AutoServiceTest {

    @MockBean
    private AutoRepository autoRepository;

    @Autowired
    private AutoService autoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAutos() {
        // Datos de prueba
        AutoEntity auto1 = new AutoEntity();
        auto1.setPatente("ABC123");
        AutoEntity auto2 = new AutoEntity();
        auto2.setPatente("DEF456");
        ArrayList<AutoEntity> autos = new ArrayList<>();
        autos.add(auto1);
        autos.add(auto2);

        // Configurar comportamiento simulado del repositorio
        when(autoRepository.findAll()).thenReturn(autos);

        // Llamar al método del servicio
        ArrayList<AutoEntity> autosObtenidos = autoService.getAutos();

        for (AutoEntity auto : autosObtenidos) {
            System.out.println(auto.getPatente());
        }

        for (AutoEntity auto : autos) {
            System.out.println(auto.getPatente());
        }

        // Verificar que los resultados sean los esperados
        assertEquals(autos.size(), autosObtenidos.size());
        assertEquals(autos.get(0).getPatente(), autosObtenidos.get(0).getPatente());
        assertEquals(autos.get(1).getPatente(), autosObtenidos.get(1).getPatente());
    }

    @Test
    public void testGetAutoByPatente() {
        // Datos de prueba
        String patente = "ABC123";
        AutoEntity auto = new AutoEntity();
        auto.setPatente(patente);

        // Configurar comportamiento simulado del repositorio
        when(autoRepository.findByPatente(patente)).thenReturn(auto);

        // Llamar al método del servicio
        AutoEntity autoObtenido = autoService.getAutoByPatente(patente);

        // Verificar que el resultado sea el esperado
        assertEquals(patente, autoObtenido.getPatente());
    }

    @Test
    public void testSaveAuto() {
        // Datos de prueba
        AutoEntity auto = new AutoEntity();
        auto.setPatente("ABC123");

        // configurar comportamiento simulado del repositorio
        when(autoRepository.save(auto)).thenReturn(auto);

        // Llamar al método del servicio
        AutoEntity autoObtenido = autoService.saveAuto(auto);

        // Verificar que el resultado sea el esperado
        assertEquals(auto.getPatente(), autoObtenido.getPatente());
    }

    @Test
    public void testUpdateAuto() {
        // Datos de prueba
        AutoEntity auto = new AutoEntity();
        auto.setPatente("ABC123");

        // Configurar comportamiento simulado del repositorio
        when(autoRepository.save(auto)).thenReturn(auto);

        // Llamar al método del servicio
        AutoEntity autoObtenido = autoService.updateAuto(auto);

        // Verificar que el resultado sea el esperado
        assertEquals(auto.getPatente(), autoObtenido.getPatente());
    }


}
