package com.example.tingesoBackendAlan.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "reparaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ReparacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idReparacion;

    @Column(name = "patente")
    private String patente;
    @Column(name = "tipo_reparacion")
    private Integer tipoReparacion;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "monto_reparacion")
    private double montoReparacion;
    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;
    @Column(name = "hora_ingreso")
    private LocalTime horaIngreso;
    @Column(name = "fecha_salida")
    private LocalDate fechaSalida;
    @Column(name = "hora_salida")
    private LocalTime horaSalida;
    @Column(name = "fecha_retiro")
    private LocalDate fechaRetiro;
    @Column(name = "hora_retiro")
    private LocalTime horaRetiro;

}