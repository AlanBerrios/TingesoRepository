package com.example.tingesoBackendAlan.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "historial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HistorialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idHistorial;

    @Column(name = "patente")
    private String patente;
    @Column(name = "rut")
    private String rut;

}
