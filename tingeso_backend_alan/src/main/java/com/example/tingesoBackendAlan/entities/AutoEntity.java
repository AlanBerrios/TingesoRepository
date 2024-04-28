package com.example.tingesoBackendAlan.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "autos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class AutoEntity {

    @Id
    @Column(name = "patente", unique = true, nullable = false)
    private String patente;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "anio")
    private Integer anio;
    @Column(name = "tipoMotor")
    private String tipoMotor;
    @Column(name = "numeroAsientos")
    private Integer numeroAsientos;
    @Column(name = "kilometraje")
    private Integer kilometraje;

}