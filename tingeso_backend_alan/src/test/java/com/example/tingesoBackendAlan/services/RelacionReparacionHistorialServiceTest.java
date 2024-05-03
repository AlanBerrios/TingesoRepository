package com.example.tingesoBackendAlan.services;

import com.example.tingesoBackendAlan.entities.RelacionReparacionHistorialEntity;
import com.example.tingesoBackendAlan.repositories.RelacionReparacionHistorialRepository;
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
public class RelacionReparacionHistorialServiceTest {

    @MockBean
    private RelacionReparacionHistorialRepository relacionReparacionHistorialRepository;

    @Autowired
    private RelacionReparacionHistorialService relacionReparacionHistorialService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetRelacionReparacionHistorial() {
        // Datos de prueba
        RelacionReparacionHistorialEntity relacion1 = new RelacionReparacionHistorialEntity();
        relacion1.setIdHistorial(1L);
        relacion1.setIdReparacion(1L);
        RelacionReparacionHistorialEntity relacion2 = new RelacionReparacionHistorialEntity();
        relacion2.setIdHistorial(2L);
        relacion2.setIdReparacion(2L);
        List<RelacionReparacionHistorialEntity> relaciones = new ArrayList<>();
        relaciones.add(relacion1);
        relaciones.add(relacion2);

        relacionReparacionHistorialRepository.save(relacion1);
        relacionReparacionHistorialRepository.save(relacion2);

        // Configurar comportamiento simulado del repositorio
        when(relacionReparacionHistorialRepository.findAll()).thenReturn(relaciones);

        // Llamar al método del servicio
        List<RelacionReparacionHistorialEntity> relacionesObtenidas = relacionReparacionHistorialService.getRelacionReparacionHistorial();

        // Verificar que los resultados sean los esperados
        assertEquals(relaciones.size(), relacionesObtenidas.size());
        assertEquals(relaciones, relacionesObtenidas);
    }

    @Test
    public void testGetRelacionReparacionHistorialById() {
        // Datos de prueba
        RelacionReparacionHistorialEntity relacion = new RelacionReparacionHistorialEntity();
        relacion.setIdHistorial(1L);
        relacion.setIdReparacion(1L);

        relacionReparacionHistorialRepository.save(relacion);

        // Configurar comportamiento simulado del repositorio
        when(relacionReparacionHistorialRepository.findById(1L)).thenReturn(java.util.Optional.of(relacion));

        // Llamar al método del servicio
        RelacionReparacionHistorialEntity relacionObtenida = relacionReparacionHistorialService.getRelacionReparacionHistorialById(1L);

        // Verificar que los resultados sean los esperados
        assertEquals(relacion, relacionObtenida);
    }

    @Test
    public void testSaveRelacionReparacionHistorial() {
        // Datos de prueba
        RelacionReparacionHistorialEntity relacion = new RelacionReparacionHistorialEntity();
        relacion.setIdHistorial(1L);
        relacion.setIdReparacion(1L);

        // Configurar comportamiento simulado del repositorio
        when(relacionReparacionHistorialRepository.save(relacion)).thenReturn(relacion);

        // Llamar al método del servicio
        RelacionReparacionHistorialEntity relacionObtenida = relacionReparacionHistorialService.saveRelacionReparacionHistorial(relacion);

        // Verificar que los resultados sean los esperados
        assertEquals(relacion, relacionObtenida);
    }

    @Test
    public void testUpdateRelacionReparacionHistorial() {
        // Datos de prueba
        RelacionReparacionHistorialEntity relacion = new RelacionReparacionHistorialEntity();
        relacion.setIdHistorial(1L);
        relacion.setIdReparacion(1L);

        // Configurar comportamiento simulado del repositorio
        when(relacionReparacionHistorialRepository.save(relacion)).thenReturn(relacion);

        // Llamar al método del servicio
        RelacionReparacionHistorialEntity relacionObtenida = relacionReparacionHistorialService.updateRelacionReparacionHistorial(relacion);

        // Verificar que los resultados sean los esperados
        assertEquals(relacion, relacionObtenida);
    }

    @Test
    public void testDeleteRelacionReparacionHistorial() {
        // Datos de prueba
        RelacionReparacionHistorialEntity relacion = new RelacionReparacionHistorialEntity();
        relacion.setIdHistorial(1L);
        relacion.setIdReparacion(1L);

        relacionReparacionHistorialRepository.save(relacion);

        // Llamar al método del servicio
        Boolean resultado = relacionReparacionHistorialService.deleteRelacionReparacionHistorial(1L);

        // Verificar que los resultados sean los esperados
        assertEquals(true, resultado);
    }

    @Test
    public void testGetRelacionReparacionHistorialByHistorialId() {
        // Datos de prueba
        RelacionReparacionHistorialEntity relacion = new RelacionReparacionHistorialEntity();
        relacion.setIdHistorial(1L);
        relacion.setIdReparacion(1L);

        relacionReparacionHistorialRepository.save(relacion);

        // Configurar comportamiento simulado del repositorio
        when(relacionReparacionHistorialRepository.findByIdHistorial(1L)).thenReturn(relacion);

        // Llamar al método del servicio
        RelacionReparacionHistorialEntity relacionObtenida = relacionReparacionHistorialService.getRelacionReparacionHistorialByHistorialId(1L);

        // Verificar que los resultados sean los esperados
        assertEquals(relacion, relacionObtenida);
    }

    @Test
    public void testGetRelacionReparacionHistorialByReparacionId() {
        // Datos de prueba
        RelacionReparacionHistorialEntity relacion = new RelacionReparacionHistorialEntity();
        relacion.setIdHistorial(1L);
        relacion.setIdReparacion(1L);

        relacionReparacionHistorialRepository.save(relacion);

        // Configurar comportamiento simulado del repositorio
        when(relacionReparacionHistorialRepository.findByIdReparacion(1L)).thenReturn(relacion);

        // Llamar al método del servicio
        RelacionReparacionHistorialEntity relacionObtenida = relacionReparacionHistorialService.getRelacionReparacionHistorialByReparacionId(1L);

        // Verificar que los resultados sean los esperados
        assertEquals(relacion, relacionObtenida);
    }

    @Test
    public void testCountByHistorialId() {
        // Datos de prueba
        RelacionReparacionHistorialEntity relacion1 = new RelacionReparacionHistorialEntity();
        relacion1.setIdHistorial(1L);
        relacion1.setIdReparacion(1L);
        RelacionReparacionHistorialEntity relacion2 = new RelacionReparacionHistorialEntity();
        relacion2.setIdHistorial(1L);
        relacion2.setIdReparacion(2L);
        List<RelacionReparacionHistorialEntity> relaciones = new ArrayList<>();
        relaciones.add(relacion1);
        relaciones.add(relacion2);

        relacionReparacionHistorialRepository.save(relacion1);
        relacionReparacionHistorialRepository.save(relacion2);

        // Configurar comportamiento simulado del repositorio
        when(relacionReparacionHistorialRepository.countByIdHistorial(1L)).thenReturn(2);

        // Llamar al método del servicio
        Integer cantidad = relacionReparacionHistorialService.countByHistorialId(1L);

        // Verificar que los resultados sean los esperados
        assertEquals(2, cantidad);
    }

}
