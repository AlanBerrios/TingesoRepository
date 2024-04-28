package com.example.tingesoBackendAlan.services;

import com.example.tingesoBackendAlan.entities.HistorialEntity;
import com.example.tingesoBackendAlan.repositories.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HistorialService {
    @Autowired
    HistorialRepository historialRepository;

    public ArrayList<HistorialEntity> getHistoriales(){
        return (ArrayList<HistorialEntity>) historialRepository.findAll();
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
