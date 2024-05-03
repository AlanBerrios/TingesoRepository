package com.example.tingesoBackendAlan.services;

import com.example.tingesoBackendAlan.entities.AutoEntity;
import com.example.tingesoBackendAlan.entities.ReparacionEntity;
import com.example.tingesoBackendAlan.repositories.AutoRepository;
import com.example.tingesoBackendAlan.repositories.ReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;


@Service
public class RecargosService {
    @Autowired
    AutoRepository autoRepository;
    @Autowired
    ReparacionRepository reparacionRepository;

    public double calcularRecargoPorKilometraje(AutoEntity auto) {
        double recargo = 0;
        int kilometraje = auto.getKilometraje();
        String tipoAuto = auto.getTipo();

        switch (tipoAuto) {
            case "Sedan", "Hatchback":
                if (kilometraje >= 0 && kilometraje <= 5000) {
                    recargo = 0;
                } else if (kilometraje >= 5001 && kilometraje <= 12000) {
                    recargo = 0.03;
                } else if (kilometraje >= 12001 && kilometraje <= 25000) {
                    recargo = 0.07;
                } else if (kilometraje >= 25001 && kilometraje <= 40000) {
                    recargo = 0.12;
                } else if (kilometraje >= 40001) {
                    recargo = 0.20;
                }
                break;
            case "SUV", "Pickup", "Furgoneta":
                if (kilometraje >= 0 && kilometraje <= 5000) {
                    recargo = 0;
                } else if (kilometraje >= 5001 && kilometraje <= 12000) {
                    recargo = 0.05;
                } else if (kilometraje >= 12001 && kilometraje <= 25000) {
                    recargo = 0.09;
                } else if (kilometraje >= 25001 && kilometraje <= 40000) {
                    recargo = 0.12;
                } else if (kilometraje >= 40001) {
                    recargo = 0.20;
                }
                break;

        }
        return recargo;
    }

    public double calcularRecargoPorAntiguedadDelVehiculo(AutoEntity auto) {
        double recargo = 0;
        int anioAuto = auto.getAnio();
        LocalDate fechaActual = LocalDate.now();
        int antiguedad = fechaActual.getYear() - anioAuto;
        String tipoAuto = auto.getTipo();

        switch (tipoAuto) {
            case "Sedan", "Hatchback":
                if (antiguedad >= 0 && antiguedad <= 5) {
                    recargo = 0;
                } else if (antiguedad >= 6 && antiguedad <= 10) {
                    recargo = 0.05;
                } else if (antiguedad >= 11 && antiguedad <= 15) {
                    recargo = 0.09;
                } else if (antiguedad >= 16) {
                    recargo = 0.15;
                }
                break;
            case "SUV", "Pickup", "Furgoneta":
                if (antiguedad >= 0 && antiguedad <= 5) {
                    recargo = 0;
                } else if (antiguedad >= 6 && antiguedad <= 10) {
                    recargo = 0.07;
                } else if (antiguedad >= 11 && antiguedad <= 15) {
                    recargo = 0.11;
                } else if (antiguedad >= 16) {
                    recargo = 0.20;
                }
                break;

        }
        return recargo;
    }

    public double calcularRecargoPorRetrasoRecogidaVehiculo(ReparacionEntity reparacion) {
        double recargo = 0;
        LocalDate fechaSalida = reparacion.getFechaSalida();
        LocalDate fechaRetiro = reparacion.getFechaRetiro();

        if (fechaSalida == null || fechaRetiro == null) {
            return recargo;
        }

        // Calcular la diferencia en días entre las fechas de salida y retiro
        long diasDiferencia = ChronoUnit.DAYS.between(fechaSalida, fechaRetiro);

        // Si hay retraso en la recogida, aplicar un recargo
        if (diasDiferencia > 0) {
            recargo = diasDiferencia * 0.05;
        }

        return recargo;
    }

}