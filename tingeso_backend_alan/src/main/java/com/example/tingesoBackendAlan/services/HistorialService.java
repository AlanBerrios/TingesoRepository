package com.example.tingesoBackendAlan.services;

import com.example.tingesoBackendAlan.entities.HistorialEntity;
import com.example.tingesoBackendAlan.repositories.HistorialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistorialService {
    @Autowired
    HistorialRepository historialRepository;
    @Autowired
    RelacionReparacionHistorialService relacionReparacionHistorialService;
    @Autowired
    OficinaCobrosService oficinaCobrosService;

    public ArrayList<HistorialEntity> getHistoriales2(){
        return (ArrayList<HistorialEntity>) historialRepository.findAll();
    }
    public List<HistorialEntity> getHistoriales() {
        List<HistorialEntity> historiales = historialRepository.findAll();

        // Calcular montoTotal y numeroReparaciones para cada historial
        for (HistorialEntity historial : historiales) {
            Long idHistorial = historial.getIdHistorial(); // Supongamos que el ID es un Long
            int numeroReparaciones = relacionReparacionHistorialService.countByHistorialId(idHistorial);
            double montoTotal = oficinaCobrosService.calcularMontoTotalFinal(idHistorial);
            // Establecer los valores calculados en el historial
            historial.setNumeroReparaciones(numeroReparaciones);
            historial.setMontoTotalFinal(montoTotal);
        }
        return historiales;
    }
    public HistorialEntity saveHistorial(HistorialEntity historial){
        return historialRepository.save(historial);
    }
    public HistorialEntity getHistorialById(Long idHistorial){
        return historialRepository.findByIdHistorial(idHistorial);
    }
    public HistorialEntity getHistorialByPatente(String patente){
        return historialRepository.findByPatente(patente);
    }
    public HistorialEntity updateHistorial(HistorialEntity historial) {
        return historialRepository.save(historial);
    }
    public Boolean deleteHistorial(Long idHistorial) {
        historialRepository.deleteByIdHistorial(idHistorial);
        return true;
    }






}
