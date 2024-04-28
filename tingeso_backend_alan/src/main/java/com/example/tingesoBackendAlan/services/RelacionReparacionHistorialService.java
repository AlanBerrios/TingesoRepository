package com.example.tingesoBackendAlan.services;

import com.example.tingesoBackendAlan.entities.RelacionReparacionHistorialEntity;
import com.example.tingesoBackendAlan.repositories.RelacionReparacionHistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelacionReparacionHistorialService {

    @Autowired
    RelacionReparacionHistorialRepository relacionReparacionHistorialRepository;

    public List<RelacionReparacionHistorialEntity> getRelacionReparacionHistorial() {
        return relacionReparacionHistorialRepository.findAll();
    }

    public RelacionReparacionHistorialEntity getRelacionReparacionHistorialById(Long id) {
        return relacionReparacionHistorialRepository.findById(id).get();
    }

    public RelacionReparacionHistorialEntity saveRelacionReparacionHistorial(RelacionReparacionHistorialEntity relacionReparacionHistorial) {
        return relacionReparacionHistorialRepository.save(relacionReparacionHistorial);
    }

    public RelacionReparacionHistorialEntity updateRelacionReparacionHistorial(RelacionReparacionHistorialEntity relacionReparacionHistorial) {
        return relacionReparacionHistorialRepository.save(relacionReparacionHistorial);
    }

    public Boolean deleteRelacionReparacionHistorial(Long id) {
        relacionReparacionHistorialRepository.deleteById(id);
        return true;
    }

    public RelacionReparacionHistorialEntity getRelacionReparacionHistorialByHistorialId(Long idHistorial) {
        return relacionReparacionHistorialRepository.findByIdHistorial(idHistorial);
    }

    public RelacionReparacionHistorialEntity getRelacionReparacionHistorialByReparacionId(Long idReparacion) {
        return relacionReparacionHistorialRepository.findByIdReparacion(idReparacion);
    }
}
