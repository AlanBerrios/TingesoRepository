package com.example.tingesoBackendAlan.controllers;

import com.example.tingesoBackendAlan.entities.HistorialEntity;
import com.example.tingesoBackendAlan.services.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historial")
@CrossOrigin("*")
public class HistorialController {

    HistorialService historialService;

    @Autowired
    public HistorialController(HistorialService historialService) {
        this.historialService = historialService;
    }

    @GetMapping("/")
    public ResponseEntity<List<HistorialEntity>> listHistoriales() {
        List<HistorialEntity> historiales = historialService.getHistoriales();
        return ResponseEntity.ok(historiales);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<HistorialEntity> getHistorialById(@PathVariable Long id) {
        HistorialEntity historial = historialService.getHistorialById(id);
        return ResponseEntity.ok(historial);
    }

    @GetMapping("/{patente}")
    public ResponseEntity<HistorialEntity> getHistorialByPatente(@PathVariable String patente) {
        HistorialEntity historial = historialService.getHistorialByPatente(patente);
        return ResponseEntity.ok(historial);
    }

    @PostMapping("/")
    public ResponseEntity<HistorialEntity> saveHistorial(@RequestBody HistorialEntity historial) {
        HistorialEntity historialNew = historialService.saveHistorial(historial);
        return ResponseEntity.ok(historialNew);
    }

    @PutMapping("/")
    public ResponseEntity<HistorialEntity> updateHistorial(@RequestBody HistorialEntity historial){
        HistorialEntity historialUpdated = historialService.updateHistorial(historial);
        return ResponseEntity.ok(historialUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteHistorialById(@PathVariable Long id) throws Exception {
        var isDeleted = historialService.deleteHistorial(id);
        return ResponseEntity.noContent().build();
    }


}