package com.example.tingesoBackendAlan.services;


import com.example.tingesoBackendAlan.entities.AutoEntity;
import com.example.tingesoBackendAlan.entities.BonoEntity;
import com.example.tingesoBackendAlan.repositories.BonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BonoService {

    @Autowired
    BonoRepository bonoRepository;

    public ArrayList<BonoEntity> getBonos(){
        return (ArrayList<BonoEntity>) bonoRepository.findAll();
    }
    public BonoEntity saveBono(BonoEntity bono){
        return bonoRepository.save(bono);
    }
    public BonoEntity getBonoById(Long idBono){
        return bonoRepository.findByIdBono(idBono);
    }
    public BonoEntity getBonoByMarca(String marca){
        return bonoRepository.findByMarca(marca);
    }
    public BonoEntity updateBono(BonoEntity bono) {
        return bonoRepository.save(bono);
    }
    public Boolean deleteBono(Long idBono) {
        bonoRepository.deleteById(idBono);
        return true;
    }

    public double usarBono(String marca){
        double monto = 0;
        BonoEntity bono = bonoRepository.findByMarca(marca);

        if(bono.getNumeroBonos() == 0){
            return monto;
        }
        else{
            monto = bono.getMontoBono();
            bono.setNumeroBonos(bono.getNumeroBonos()-1);
            bonoRepository.save(bono);
            return monto;
        }
    }

}
