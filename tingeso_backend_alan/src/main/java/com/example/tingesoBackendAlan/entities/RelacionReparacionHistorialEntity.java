package com.example.tingesoBackendAlan.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "relacion_reparacion_historial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RelacionReparacionHistorialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idRelacionReparacionHistorial;

    @Column(name = "id_historial")
    private Long idHistorial;

    @Column(name = "id_reparacion")
    private Long idReparacion;
}
