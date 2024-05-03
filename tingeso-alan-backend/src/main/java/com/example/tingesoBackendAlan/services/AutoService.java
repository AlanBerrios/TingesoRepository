package com.example.tingesoBackendAlan.services;

import com.example.tingesoBackendAlan.entities.AutoEntity;
import com.example.tingesoBackendAlan.repositories.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AutoService {
    @Autowired
    AutoRepository autoRepository;

    public ArrayList<AutoEntity> getAutos(){
        return (ArrayList<AutoEntity>) autoRepository.findAll();
    }
    public AutoEntity saveAuto(AutoEntity auto){
        return autoRepository.save(auto);
    }
    public AutoEntity getAutoByPatente(String patente){
        return autoRepository.findByPatente(patente);
    }
    public AutoEntity updateAuto(AutoEntity auto) {
        return autoRepository.save(auto);
    }
    public Boolean deleteAuto(String patente) {
        autoRepository.deleteByPatente(patente);
        return true;
    }






}
