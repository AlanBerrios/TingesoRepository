package com.example.tingesoBackendAlan.services;

import com.example.tingesoBackendAlan.entities.HistorialEntity;
import com.example.tingesoBackendAlan.repositories.HistorialRepository;
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
public class HistorialServiceTest {

    @MockBean
    private HistorialRepository historialRepository;

    @Autowired
    private HistorialService historialService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetHistoriales() {
        // Datos de prueba
        HistorialEntity historial1 = new HistorialEntity();
        historial1.setIdHistorial(1L);
        historial1.setRut("12345678-9");
        historial1.setNumeroReparaciones(3);
        historial1.setMontoTotalFinal(150000.0);
        HistorialEntity historial2 = new HistorialEntity();
        historial2.setIdHistorial(2L);
        historial2.setRut("98765432-1");
        historial2.setNumeroReparaciones(1);
        historial2.setMontoTotalFinal(50000.0);
        List<HistorialEntity> historiales = new ArrayList<>();
        historiales.add(historial1);
        historiales.add(historial2);

        historialRepository.save(historial1);
        historialRepository.save(historial2);

        // Configurar comportamiento simulado del repositorio
        when(historialRepository.findAll()).thenReturn(historiales);

        // Llamar al método del servicio
        List<HistorialEntity> historialesObtenidos = historialService.getHistoriales2();

        // Verificar que los resultados sean los esperados
        assertEquals(historiales.size(), historialesObtenidos.size());
        assertEquals(historiales.get(0).getIdHistorial(), historialesObtenidos.get(0).getIdHistorial());
        assertEquals(historiales.get(1).getIdHistorial(), historialesObtenidos.get(1).getIdHistorial());
    }

    @Test
    public void testGetHistoriales2() {
        // Datos de prueba
        HistorialEntity historial1 = new HistorialEntity();
        historial1.setIdHistorial(1L);
        HistorialEntity historial2 = new HistorialEntity();
        historial2.setIdHistorial(2L);
        List<HistorialEntity> historiales = new ArrayList<>();
        historiales.add(historial1);
        historiales.add(historial2);

        historialRepository.save(historial1);
        historialRepository.save(historial2);

        // Configurar comportamiento simulado del repositorio
        when(historialRepository.findAll()).thenReturn(historiales);

        // Llamar al método del servicio
        List<HistorialEntity> historialesObtenidos = historialService.getHistoriales2();

        // Verificar que los resultados sean los esperados
        assertEquals(historiales.size(), historialesObtenidos.size());
        assertEquals(historiales.get(0).getIdHistorial(), historialesObtenidos.get(0).getIdHistorial());
        assertEquals(historiales.get(1).getIdHistorial(), historialesObtenidos.get(1).getIdHistorial());
    }

    @Test
    public void testGetHistorialById() {
        // Datos de prueba
        HistorialEntity historial = new HistorialEntity();
        historial.setIdHistorial(1L);

        historialRepository.save(historial);

        // Configurar comportamiento simulado del repositorio
        when(historialRepository.findByIdHistorial(1L)).thenReturn(historial);

        // Llamar al método del servicio
        HistorialEntity historialObtenido = historialService.getHistorialById(1L);

        // Verificar que los resultados sean los esperados
        assertEquals(historial.getIdHistorial(), historialObtenido.getIdHistorial());
    }

    @Test
    public void testGetHistorialByPatente() {
        // Datos de prueba
        HistorialEntity historial = new HistorialEntity();
        historial.setPatente("ABC123");

        historialRepository.save(historial);

        // Configurar comportamiento simulado del repositorio
        when(historialRepository.findByPatente("ABC123")).thenReturn(historial);

        // Llamar al método del servicio
        HistorialEntity historialObtenido = historialService.getHistorialByPatente("ABC123");

        // Verificar que los resultados sean los esperados
        assertEquals(historial.getPatente(), historialObtenido.getPatente());
    }

    @Test
    public void testSaveHistorial() {
        // Datos de prueba
        HistorialEntity historial = new HistorialEntity();
        historial.setIdHistorial(1L);

        // Configurar comportamiento simulado del repositorio
        when(historialRepository.save(historial)).thenReturn(historial);

        // Llamar al método del servicio
        HistorialEntity historialObtenido = historialService.saveHistorial(historial);

        // Verificar que los resultados sean los esperados
        assertEquals(historial.getIdHistorial(), historialObtenido.getIdHistorial());
    }

    @Test
    public void testUpdateHistorial() {
        // Datos de prueba
        HistorialEntity historial = new HistorialEntity();
        historial.setIdHistorial(1L);

        // Configurar comportamiento simulado del repositorio
        when(historialRepository.save(historial)).thenReturn(historial);

        // Llamar al método del servicio
        HistorialEntity historialObtenido = historialService.updateHistorial(historial);

        // Verificar que los resultados sean los esperados
        assertEquals(historial.getIdHistorial(), historialObtenido.getIdHistorial());
    }

}
