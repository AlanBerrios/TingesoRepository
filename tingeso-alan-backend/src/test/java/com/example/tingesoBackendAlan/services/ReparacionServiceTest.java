package com.example.tingesoBackendAlan.services;

import com.example.tingesoBackendAlan.entities.ReparacionEntity;
import com.example.tingesoBackendAlan.repositories.ReparacionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ReparacionServiceTest {

    @MockBean
    private ReparacionRepository reparacionRepository;

    @Autowired
    private ReparacionService reparacionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetReparaciones() {
        // Datos de prueba
        ReparacionEntity reparacion1 = new ReparacionEntity();
        reparacion1.setIdReparacion(1L);
        ReparacionEntity reparacion2 = new ReparacionEntity();
        reparacion2.setIdReparacion(2L);
        List<ReparacionEntity> reparaciones = new ArrayList<>();
        reparaciones.add(reparacion1);
        reparaciones.add(reparacion2);

        reparacionRepository.save(reparacion1);
        reparacionRepository.save(reparacion2);

        // Configurar comportamiento simulado del repositorio
        when(reparacionRepository.findAll()).thenReturn(reparaciones);

        // Llamar al método del servicio
        List<ReparacionEntity> reparacionesObtenidas = reparacionService.getReparaciones();

        // Verificar que los resultados sean los esperados
        assertEquals(reparaciones.size(), reparacionesObtenidas.size());
        assertEquals(reparaciones.get(0).getIdReparacion(), reparacionesObtenidas.get(0).getIdReparacion());
        assertEquals(reparaciones.get(1).getIdReparacion(), reparacionesObtenidas.get(1).getIdReparacion());
    }
}
