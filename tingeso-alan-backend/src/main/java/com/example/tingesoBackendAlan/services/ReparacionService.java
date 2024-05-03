package com.example.tingesoBackendAlan.services;

import com.example.tingesoBackendAlan.entities.ReparacionEntity;
import com.example.tingesoBackendAlan.repositories.ReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ReparacionService {

    @Autowired
    ReparacionRepository reparacionRepository;

    public long countNumeroReparacionesByPatente(String patente){
        return reparacionRepository.countByPatente(patente);
    }
    public List<ReparacionEntity> getReparaciones() {
        return reparacionRepository.findAll();
    }
    public ReparacionEntity getReparacionById(Long id) {
        return reparacionRepository.findById(id).get();
    }
    public ReparacionEntity getReparacionByPatente(String patente) {
        return reparacionRepository.findByPatente(patente);
    }
    public ReparacionEntity saveReparacion(ReparacionEntity reparacion) {
        return reparacionRepository.save(reparacion);
    }
    public ReparacionEntity updateReparacion(ReparacionEntity reparacion) {
        return reparacionRepository.save(reparacion);
    }
    public Boolean deleteReparacion(Long id){
        reparacionRepository.deleteById(id);
        return true;
    }
}

