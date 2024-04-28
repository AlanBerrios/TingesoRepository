package com.example.tingesoBackendAlan.controllers;

import com.example.tingesoBackendAlan.entities.AutoEntity;
import com.example.tingesoBackendAlan.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auto")
@CrossOrigin("*")
public class AutoController {

    AutoService autoService;

    @Autowired
    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<AutoEntity>> listAutos() {
        List<AutoEntity> autos = autoService.getAutos();
        return ResponseEntity.ok(autos);
    }


    @GetMapping("/{patente}")
    public ResponseEntity<AutoEntity> getAutoByPatente(@PathVariable String patente) {
        AutoEntity auto = autoService.getAutoByPatente(patente);
        return ResponseEntity.ok(auto);
    }

    @PostMapping("/")
    public ResponseEntity<AutoEntity> saveAuto(@RequestBody AutoEntity auto) {
        AutoEntity autoNew = autoService.saveAuto(auto);
        return ResponseEntity.ok(autoNew);
    }

    @PutMapping("/")
    public ResponseEntity<AutoEntity> updateAuto(@RequestBody AutoEntity auto){
        AutoEntity autoUpdated = autoService.updateAuto(auto);
        return ResponseEntity.ok(autoUpdated);
    }

    @DeleteMapping("/{patente}")
    public ResponseEntity<Boolean> deleteAutoByPatente(@PathVariable String patente) throws Exception {
        var isDeleted = autoService.deleteAuto(patente);
        return ResponseEntity.noContent().build();
    }


}