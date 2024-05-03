package com.example.tingesoBackendAlan.controllers;

import com.example.tingesoBackendAlan.entities.RelacionReparacionHistorialEntity;
import com.example.tingesoBackendAlan.services.RelacionReparacionHistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relacionreparacionhistorial")
@CrossOrigin("*")
public class RelacionReparacionHistorialController {

    RelacionReparacionHistorialService relacionReparacionHistorialService;

    @Autowired
    public RelacionReparacionHistorialController(RelacionReparacionHistorialService relacionReparacionHistorialService) {
        this.relacionReparacionHistorialService = relacionReparacionHistorialService;
    }

    @GetMapping("/")
    public ResponseEntity<List<RelacionReparacionHistorialEntity>> listRelacionReparacionHistorial() {
        List<RelacionReparacionHistorialEntity> relacionReparacionHistorials = relacionReparacionHistorialService.getRelacionReparacionHistorial();
        return ResponseEntity.ok(relacionReparacionHistorials);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<RelacionReparacionHistorialEntity> getRelacionReparacionHistorialById(@PathVariable Long id) {
        RelacionReparacionHistorialEntity relacionReparacionHistorial = relacionReparacionHistorialService.getRelacionReparacionHistorialById(id);
        return ResponseEntity.ok(relacionReparacionHistorial);
    }

    @PostMapping("/")
    public ResponseEntity<RelacionReparacionHistorialEntity> saveRelacionReparacionHistorial(@RequestBody RelacionReparacionHistorialEntity relacionReparacionHistorial) {
        RelacionReparacionHistorialEntity relacionReparacionHistorialNew = relacionReparacionHistorialService.saveRelacionReparacionHistorial(relacionReparacionHistorial);
        return ResponseEntity.ok(relacionReparacionHistorialNew);
    }

    @PutMapping("/")
    public ResponseEntity<RelacionReparacionHistorialEntity> updateRelacionReparacionHistorial(@RequestBody RelacionReparacionHistorialEntity relacionReparacionHistorial){
        RelacionReparacionHistorialEntity relacionReparacionHistorialUpdated = relacionReparacionHistorialService.updateRelacionReparacionHistorial(relacionReparacionHistorial);
        return ResponseEntity.ok(relacionReparacionHistorialUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRelacionReparacionHistorialById(@PathVariable Long id) throws Exception {
        var isDeleted = relacionReparacionHistorialService.deleteRelacionReparacionHistorial(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/historial/{idHistorial}")
    public ResponseEntity<RelacionReparacionHistorialEntity> getRelacionReparacionHistorialByHistorialId(@PathVariable Long idHistorial) {
        RelacionReparacionHistorialEntity relacionReparacionHistorial = relacionReparacionHistorialService.getRelacionReparacionHistorialByHistorialId(idHistorial);
        return ResponseEntity.ok(relacionReparacionHistorial);
    }

    @GetMapping("/reparacion/{idReparacion}")
    public ResponseEntity<RelacionReparacionHistorialEntity> getRelacionReparacionHistorialByReparacionId(@PathVariable Long idReparacion) {
        RelacionReparacionHistorialEntity relacionReparacionHistorial = relacionReparacionHistorialService.getRelacionReparacionHistorialByReparacionId(idReparacion);
        return ResponseEntity.ok(relacionReparacionHistorial);
    }

}