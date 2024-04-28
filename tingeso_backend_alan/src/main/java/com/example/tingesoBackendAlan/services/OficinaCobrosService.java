package com.example.tingesoBackendAlan.services;

import com.example.tingesoBackendAlan.entities.AutoEntity;
import com.example.tingesoBackendAlan.entities.HistorialEntity;
import com.example.tingesoBackendAlan.entities.RelacionReparacionHistorialEntity;
import com.example.tingesoBackendAlan.entities.ReparacionEntity;
import com.example.tingesoBackendAlan.repositories.*;
import com.example.tingesoBackendAlan.services.DescuentosService;
import com.example.tingesoBackendAlan.services.RecargosService;
import com.example.tingesoBackendAlan.services.AutoService;
import com.example.tingesoBackendAlan.services.ReparacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import  java.util.ArrayList;

@Service
public class OficinaCobrosService {

    @Autowired
    ReparacionRepository reparacionRepository;
    @Autowired
    AutoRepository autoRepository;
    @Autowired
    HistorialRepository historialRepository;
    @Autowired
    RelacionReparacionHistorialRepository relacionReparacionHistorialRepository;
    @Autowired
    AutoService autoService;
    @Autowired
    ReparacionService reparacionService;
    @Autowired
    DescuentosService descuentosService;
    @Autowired
    BonoService bonoService;
    @Autowired
    BonoRepository bonoRepository;

    public double calcularMontoReparacion(Long idReparacion) {
        double montoReparacion = 0;
        ReparacionEntity reparacion = reparacionRepository.findByIdReparacion(idReparacion);
        String patente = reparacion.getPatente();
        AutoEntity auto = autoRepository.findByPatente(patente);
        String tipoMotor = auto.getTipoMotor();
        Integer tipoReparacion = reparacion.getTipoReparacion();
        switch (tipoReparacion) {
            case 1:
                switch (tipoMotor) {
                    case "Gasolina":
                        montoReparacion = 120000;
                        break;
                    case "Diesel":
                        montoReparacion = 120000;
                        break;
                    case "Hibrido":
                        montoReparacion = 180000;
                        break;
                    case "Electrico":
                        montoReparacion = 220000;
                        break;
                    default:
                        montoReparacion = 0;
                        break;
                }
                break;
            case 2:
                switch (tipoMotor) {
                    case "Gasolina":
                        montoReparacion = 130000;
                        break;
                    case "Diesel":
                        montoReparacion = 130000;
                        break;
                    case "Hibrido":
                        montoReparacion = 190000;
                        break;
                    case "Electrico":
                        montoReparacion = 230000;
                        break;
                    default:
                        montoReparacion = 0;
                        break;
                }
                break;
            case 3:
                switch (tipoMotor) {
                    case "Gasolina":
                        montoReparacion = 350000;
                        break;
                    case "Diesel":
                        montoReparacion = 450000;
                        break;
                    case "Hibrido":
                        montoReparacion = 700000;
                        break;
                    case "Electrico":
                        montoReparacion = 800000;
                        break;
                    default:
                        montoReparacion = 0;
                        break;
                }
                break;
            case 4:
                switch (tipoMotor) {
                    case "Gasolina":
                        montoReparacion = 210000;
                        break;
                    case "Diesel":
                        montoReparacion = 210000;
                        break;
                    case "Hibrido":
                        montoReparacion = 300000;
                        break;
                    case "Electrico":
                        montoReparacion = 300000;
                        break;
                    default:
                        montoReparacion = 0;
                        break;
                }
                break;
            case 5:
                switch (tipoMotor) {
                    case "Gasolina":
                        montoReparacion = 150000;
                        break;
                    case "Diesel":
                        montoReparacion = 150000;
                        break;
                    case "Hibrido":
                        montoReparacion = 200000;
                        break;
                    case "Electrico":
                        montoReparacion = 250000;
                        break;
                    default:
                        montoReparacion = 0;
                        break;
                }
                break;
            case 6:
                switch (tipoMotor) {
                    case "Gasolina":
                        montoReparacion = 100000;
                        break;
                    case "Diesel":
                        montoReparacion = 120000;
                        break;
                    case "Hibrido":
                        montoReparacion = 450000;
                        break;
                    case "Electrico":
                        montoReparacion = 0;
                        break;
                    default:
                        montoReparacion = 0;
                        break;
                }
                break;
            case 7:
                switch (tipoMotor) {
                    case "Gasolina":
                        montoReparacion = 100000;
                        break;
                    case "Diesel":
                        montoReparacion = 100000;
                        break;
                    case "Hibrido":
                        montoReparacion = 100000;
                        break;
                    case "Electrico":
                        montoReparacion = 100000;
                        break;
                    default:
                        montoReparacion = 0;
                        break;
                }
                break;
            case 8:
                switch (tipoMotor) {
                    case "Gasolina":
                        montoReparacion = 180000;
                        break;
                    case "Diesel":
                        montoReparacion = 180000;
                        break;
                    case "Hibrido":
                        montoReparacion = 210000;
                        break;
                    case "Electrico":
                        montoReparacion = 250000;
                        break;
                    default:
                        montoReparacion = 0;
                        break;
                }
                break;
            case 9:
                switch (tipoMotor) {
                    case "Gasolina":
                        montoReparacion = 150000;
                        break;
                    case "Diesel":
                        montoReparacion = 150000;
                        break;
                    case "Hibrido":
                        montoReparacion = 180000;
                        break;
                    case "Electrico":
                        montoReparacion = 180000;
                        break;
                    default:
                        montoReparacion = 0;
                        break;
                }
                break;
            case 10:
                switch (tipoMotor) {
                    case "Gasolina":
                        montoReparacion = 130000;
                        break;
                    case "Diesel":
                        montoReparacion = 140000;
                        break;
                    case "Hibrido":
                        montoReparacion = 220000;
                        break;
                    case "Electrico":
                        montoReparacion = 0;
                        break;
                    default:
                        montoReparacion = 0;
                        break;
                }
                break;
            case 11:
                switch (tipoMotor) {
                    case "Gasolina":
                        montoReparacion = 80000;
                        break;
                    case "Diesel":
                        montoReparacion = 80000;
                        break;
                    case "Hibrido":
                        montoReparacion = 80000;
                        break;
                    case "Electrico":
                        montoReparacion = 80000;
                        break;
                    default:
                        montoReparacion = 0;
                        break;
                }
                break;
            default:
                switch (tipoMotor) {
                    case "Gasolina":
                        montoReparacion = 0;
                        break;
                    case "Diesel":
                        montoReparacion = 0;
                        break;
                    case "Hibrido":
                        montoReparacion = 0;
                        break;
                    case "Electrico":
                        montoReparacion = 0;
                        break;
                    default:
                        montoReparacion = 0;
                        break;
                }
                break;
        }
        return montoReparacion;
    }

    public double calcularMontoTotalNetoReparaciones(Long idHistorial) {
        double montoTotal = 0;
        double montoReparacion = 0;

        // para esto busquemos las reparaciones asociadas al idHistorial
        List<RelacionReparacionHistorialEntity> relacionReparacionHistorialEntities = relacionReparacionHistorialRepository.findAllByIdHistorial(idHistorial);
        // con las reparaciones asociadas, obtengamos cada reparacion con su id
        List<ReparacionEntity> reparaciones = new ArrayList<>();
        for (RelacionReparacionHistorialEntity relacionReparacionHistorialEntity : relacionReparacionHistorialEntities) {
            ReparacionEntity reparacion = reparacionRepository.findByIdReparacion(relacionReparacionHistorialEntity.getIdReparacion());
            reparaciones.add(reparacion);
        }

        // para cada reparacion, calculemos el monto total
        for (ReparacionEntity reparacion : reparaciones) {
            String patente = reparacion.getPatente();
            AutoEntity auto = autoRepository.findByPatente(patente);
            String tipoMotor = auto.getTipoMotor();
            Integer tipoReparacion = reparacion.getTipoReparacion();

            Long idReparacion = reparacion.getIdReparacion();

            // calculamos el monto de la reparacion i
            montoReparacion = calcularMontoReparacion(idReparacion);

            // sumamos el monto de la reparacion al monto total
            montoTotal += montoReparacion;
        }
        // devolvemos el monto total neto
        return montoTotal;
    }

    public double calcularRecargos(Long idHistorial) {
        double recargo = 0;
        RecargosService recargosService = new RecargosService();
        // obtenemos el historial
        HistorialEntity historial = historialRepository.findByIdHistorial(idHistorial);
        // obtenemos la patente del historial
        String patente = historial.getPatente();
        // obtenemos el auto asociado a la patente
        AutoEntity auto = autoRepository.findByPatente(patente);

        // obtenemos una reparacion relacionada al historial
        List<RelacionReparacionHistorialEntity> relacionReparacionHistorialEntities = relacionReparacionHistorialRepository.findAllByIdHistorial(idHistorial);
        Long idReparacion = relacionReparacionHistorialEntities.get(0).getIdReparacion();
        ReparacionEntity reparacion = reparacionRepository.findByIdReparacion(idReparacion);

        // calculamos el recargo por kilometraje
        recargo = recargosService.calcularRecargoPorKilometraje(auto);

        // calculamos el recargo por antiguedad del vehiculo
        recargo += recargosService.calcularRecargoPorAntiguedadDelVehiculo(auto);

        // calculamos el recargo por atraso de retiro
        recargo += recargosService.calcularRecargoPorRetrasoRecogidaVehiculo(reparacion);

        // Redondear el recargo total a 3 decimales
        BigDecimal bdRecargo = BigDecimal.valueOf(recargo);
        bdRecargo = bdRecargo.setScale(3, BigDecimal.ROUND_HALF_UP);
        // Obtener el recargo total redondeado como double
        recargo = bdRecargo.doubleValue();

        // devolvemos el recargo
        return recargo;
    }

    public double calcularDescuentos(Long idHistorial) {
        double descuento = 0;
        double descuento1 = 0;
        double descuento2 = 0;
        // obtenemos el historial
        HistorialEntity historial = historialRepository.findByIdHistorial(idHistorial);
        // obtenemos la patente del historial
        String patente = historial.getPatente();
        // obtenemos el auto asociado a la patente
        AutoEntity auto = autoRepository.findByPatente(patente);

        // obtenemos una reparacion relacionada al historial
        List<RelacionReparacionHistorialEntity> relacionReparacionHistorialEntities = relacionReparacionHistorialRepository.findAllByIdHistorial(idHistorial);
        Long idReparacion = relacionReparacionHistorialEntities.get(0).getIdReparacion();
        ReparacionEntity reparacion = reparacionRepository.findByIdReparacion(idReparacion);

        // calculamos el descuento por numero de reparaciones
        descuento1 = descuentosService.calcularDescuentoNumeroDeReparaciones(auto.getPatente());

        // calculamos el descuento por dia de atencion
        descuento2 = descuentosService.calcularDescuentoDiaDeAtencion(reparacion);

        // sumamos los descuentos
        descuento = descuento1 + descuento2;
        // Redondear el descuento total a 3 decimales
        BigDecimal bdDescuento = BigDecimal.valueOf(descuento);
        bdDescuento = bdDescuento.setScale(3, BigDecimal.ROUND_HALF_UP);
        // Obtener el descuento total redondeado como double
        descuento = bdDescuento.doubleValue();
        // devolvemos el descuento
        return descuento;
    }

    public double calcularMontoTotalFinal(double montoTotalNeto, Long idHistorial) {
        double montoTotalFinal = 0;
        double recargo = 0;
        double descuento = 0;
        RecargosService recargosService = new RecargosService();
        DescuentosService descuentosService = new DescuentosService();

        // obtenemos el historial
        HistorialEntity historial = historialRepository.findByIdHistorial(idHistorial);
        // obtenemos la patente del historial
        String patente = historial.getPatente();
        // obtenemos el auto asociado a la patente
        AutoEntity auto = autoRepository.findByPatente(patente);

        // obtenemos una reparacion relacionada al historial
        List<RelacionReparacionHistorialEntity> relacionReparacionHistorialEntities = relacionReparacionHistorialRepository.findAllByIdHistorial(idHistorial);
        Long idReparacion = relacionReparacionHistorialEntities.get(0).getIdReparacion();
        ReparacionEntity reparacion = reparacionRepository.findByIdReparacion(idReparacion);

        // calculamos el recargo
        recargo = calcularRecargos(idHistorial);

        // calculamos el descuento
        descuento = calcularDescuentos(idHistorial);

        // calculamos el monto total final
        montoTotalFinal = montoTotalNeto + (montoTotalNeto * recargo) - (montoTotalNeto * descuento);

        // restamos el bono
        montoTotalFinal = montoTotalFinal - bonoService.usarBono(auto.getMarca());

        // sumamos el IVA
        montoTotalFinal += montoTotalFinal * 0.19;


        // devolvemos el monto total final
        return montoTotalFinal;
    }


}

