package com.example.tingesoBackendAlan.controllers;

import com.example.tingesoBackendAlan.entities.ReparacionEntity;
import com.example.tingesoBackendAlan.services.ReparacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reparaciones")
@CrossOrigin("*")
public class ReparacionController {

    ReparacionService reparacionService;

    @Autowired
    public ReparacionController(ReparacionService reparacionService) {
        this.reparacionService = reparacionService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ReparacionEntity>> listReparaciones() {
        List<ReparacionEntity> reparaciones = reparacionService.getReparaciones();
        return ResponseEntity.ok(reparaciones);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ReparacionEntity> getReparacionById(@PathVariable Long id) {
        ReparacionEntity reparacion = reparacionService.getReparacionById(id);
        return ResponseEntity.ok(reparacion);
    }

    @GetMapping("/patente/{patente}")
    public ResponseEntity<ReparacionEntity> getReparacionByPatente(@PathVariable String patente) {
        ReparacionEntity reparacion = reparacionService.getReparacionByPatente(patente);
        return ResponseEntity.ok(reparacion);
    }

    @GetMapping("/countByPatente/{patente}")
    public ResponseEntity<Long> countNumeroReparacionesByPatente(@PathVariable String patente) {
        long count = reparacionService.countNumeroReparacionesByPatente(patente);
        return ResponseEntity.ok(count);
    }

    @PostMapping("/")
    public ResponseEntity<ReparacionEntity> saveReparacion(@RequestBody ReparacionEntity reparacion) {
        ReparacionEntity reparacionNew = reparacionService.saveReparacion(reparacion);
        return ResponseEntity.ok(reparacionNew);
    }

    @PutMapping("/patente/{patente}")
    public ResponseEntity<ReparacionEntity> updateReparacion(@PathVariable String patente, @RequestBody ReparacionEntity reparacion) {
        // Verificar si la reparación existe
        ReparacionEntity reparacionExistente = reparacionService.getReparacionByPatente(patente);
        if (reparacionExistente == null) {
            // La reparación no existe, devolver un error
            return ResponseEntity.notFound().build();
        }

        reparacionExistente.setTipoReparacion(reparacion.getTipoReparacion());
        reparacionExistente.setDescripcion(reparacion.getDescripcion());
        reparacionExistente.setFechaIngreso(reparacion.getFechaIngreso());
        reparacionExistente.setHoraIngreso(reparacion.getHoraIngreso());
        reparacionExistente.setFechaSalida(reparacion.getFechaSalida());
        reparacionExistente.setHoraSalida(reparacion.getHoraSalida());
        reparacionExistente.setFechaRetiro(reparacion.getFechaRetiro());
        reparacionExistente.setHoraRetiro(reparacion.getHoraRetiro());

        ReparacionEntity reparacionActualizada = reparacionService.updateReparacion(reparacionExistente);
        return ResponseEntity.ok(reparacionActualizada);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteReparacionById(@PathVariable Long id) throws Exception {
        var isDeleted = reparacionService.deleteReparacion(id);
        return ResponseEntity.noContent().build();
    }






}