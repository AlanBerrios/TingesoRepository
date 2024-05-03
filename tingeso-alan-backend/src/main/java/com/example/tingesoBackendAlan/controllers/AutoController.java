package com.example.tingesoBackendAlan.controllers;

import com.example.tingesoBackendAlan.entities.AutoEntity;
import com.example.tingesoBackendAlan.entities.HistorialEntity;
import com.example.tingesoBackendAlan.services.*;
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
    @Autowired
    OficinaCobrosService oficinaCobrosService;
    @Autowired
    HistorialService historialService;
    @Autowired
    RecargosService recargosService;
    @Autowired
    DescuentosService descuentosService;

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

    @GetMapping("/sumaReparacionesNeto/{patente}")
    public ResponseEntity<Double> getSumaReparacionesNeto(@PathVariable String patente) {
        HistorialEntity historial = historialService.getHistorialByPatente(patente);
        double sumaReparacionesNeto = oficinaCobrosService.calcularMontoTotalNetoReparaciones(historial.getIdHistorial());
        return ResponseEntity.ok(sumaReparacionesNeto);
    }

    @GetMapping("/montoRecargo/{patente}")
    public ResponseEntity<Double> getMontoRecargo(@PathVariable String patente) {
        double montoRecargo = oficinaCobrosService.calcularMontoConRecargo(patente);
        return ResponseEntity.ok(montoRecargo);
    }

    @GetMapping("/montoDescuento/{patente}")
    public ResponseEntity<Double> getMontoDescuento(@PathVariable String patente) {
        double montoDescuento = oficinaCobrosService.calcularMontoConDescuento(patente);
        return ResponseEntity.ok(montoDescuento);
    }

    @GetMapping("/montoTotal/{patente}")
    public ResponseEntity<Double> getMontoTotal(@PathVariable String patente) {
        HistorialEntity historial = historialService.getHistorialByPatente(patente);
        double montoTotal = oficinaCobrosService.calcularMontoTotalFinal(historial.getIdHistorial());
        return ResponseEntity.ok(montoTotal);
    }


}