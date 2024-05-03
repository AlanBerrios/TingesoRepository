package com.example.tingesoBackendAlan.controllers;


import com.example.tingesoBackendAlan.entities.BonoEntity;
import com.example.tingesoBackendAlan.services.BonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bono")
@CrossOrigin("*")
public class BonoController {

    BonoService bonoService;

    @Autowired
    public BonoController(BonoService bonoService) {
        this.bonoService = bonoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<BonoEntity>> listBonos() {
        List<BonoEntity> bonos = bonoService.getBonos();
        return ResponseEntity.ok(bonos);
    }

    @GetMapping("/{marca}")
    public ResponseEntity<BonoEntity> getBonoByMarca(@PathVariable String marca) {
        BonoEntity bono = bonoService.getBonoByMarca(marca);
        return ResponseEntity.ok(bono);
    }

    @PostMapping("/")
    public ResponseEntity<BonoEntity> saveBono(@RequestBody BonoEntity bono) {
        BonoEntity bonoNew = bonoService.saveBono(bono);
        return ResponseEntity.ok(bonoNew);
    }

    @PutMapping("/")
    public ResponseEntity<BonoEntity> updateBono(@RequestBody BonoEntity bono){
        BonoEntity bonoUpdated = bonoService.updateBono(bono);
        return ResponseEntity.ok(bonoUpdated);
    }

    @DeleteMapping("/{idBono}")
    public ResponseEntity<Boolean> deleteBonoById(@PathVariable Long idBono) throws Exception {
        var isDeleted = bonoService.deleteBono(idBono);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/usar/{marca}")
    public ResponseEntity<Boolean> usarBono(@PathVariable String marca){
        bonoService.usarBono(marca);
        return ResponseEntity.noContent().build();
    }


}
