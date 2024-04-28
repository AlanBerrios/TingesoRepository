package com.example.tingesoBackendAlan.services;

import com.example.tingesoBackendAlan.entities.AutoEntity;
import com.example.tingesoBackendAlan.entities.BonoEntity;
import com.example.tingesoBackendAlan.services.BonoService;
import com.example.tingesoBackendAlan.entities.ReparacionEntity;
import com.example.tingesoBackendAlan.repositories.AutoRepository;
import com.example.tingesoBackendAlan.repositories.BonoRepository;
import com.example.tingesoBackendAlan.repositories.ReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.DayOfWeek;
import java.time.LocalTime;

import java.time.LocalTime;

@Service
public class DescuentosService {

    @Autowired
    AutoRepository autoRepository;
    @Autowired
    ReparacionRepository reparacionRepository;
    @Autowired
    BonoRepository bonoRepository;
    @Autowired
    BonoService bonoService;

    public double calcularDescuentoNumeroDeReparaciones(String patente) {
        double descuento = 0;
        AutoEntity auto = autoRepository.findByPatente(patente);
        Integer numeroReparaciones = reparacionRepository.countByPatente(patente);
        String tipoMotor = auto.getTipoMotor();

        switch (tipoMotor) {
            case "Gasolina":
                if (numeroReparaciones >= 1 && numeroReparaciones <= 2) {
                    descuento = 0.05;
                } else if (numeroReparaciones >= 3 && numeroReparaciones <= 5) {
                    descuento = 0.10;
                } else if (numeroReparaciones >= 6 && numeroReparaciones <= 9) {
                    descuento = 0.15;
                } else if (numeroReparaciones >= 10) {
                    descuento = 0.20;
                }
                break;
            case "Diesel":
                if (numeroReparaciones >= 1 && numeroReparaciones <= 2) {
                    descuento = 0.07;
                } else if (numeroReparaciones >= 3 && numeroReparaciones <= 5) {
                    descuento = 0.12;
                } else if (numeroReparaciones >= 6 && numeroReparaciones <= 9) {
                    descuento = 0.17;
                } else if (numeroReparaciones >= 10) {
                    descuento = 0.22;
                }
                break;
            case "Hibrido":
                if (numeroReparaciones >= 1 && numeroReparaciones <= 2) {
                    descuento = 0.10;
                } else if (numeroReparaciones >= 3 && numeroReparaciones <= 5) {
                    descuento = 0.15;
                } else if (numeroReparaciones >= 6 && numeroReparaciones <= 9) {
                    descuento = 0.20;
                } else if (numeroReparaciones >= 10) {
                    descuento = 0.25;
                }
                break;
            case "Electrico":
                if (numeroReparaciones >= 1 && numeroReparaciones <= 2) {
                    descuento = 0.08;
                } else if (numeroReparaciones >= 3 && numeroReparaciones <= 5) {
                    descuento = 0.13;
                } else if (numeroReparaciones >= 6 && numeroReparaciones <= 9) {
                    descuento = 0.18;
                } else if (numeroReparaciones >= 10) {
                    descuento = 0.23;
                }
                break;

            default:
                descuento = 0;
                break;
        }

        return descuento;
    }

    public double calcularDescuentoDiaDeAtencion(ReparacionEntity reparacion) {
        double descuento = 0;
        DayOfWeek dia = reparacion.getFechaIngreso().getDayOfWeek();
        LocalTime hora = reparacion.getHoraIngreso();

        LocalTime horaInicio = LocalTime.of(9, 0, 0);
        LocalTime horaFin = LocalTime.of(12, 0, 0);

        if ((dia.equals(DayOfWeek.MONDAY) || dia.equals(DayOfWeek.THURSDAY)) &&
                (hora.isAfter(horaInicio) || hora.equals(horaInicio)) &&
                (hora.isBefore(horaFin) || hora.equals(horaFin))) {
            descuento = 0.10;
        }
        return descuento;
    }

}