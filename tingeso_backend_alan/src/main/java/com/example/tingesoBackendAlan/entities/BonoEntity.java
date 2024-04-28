package com.example.tingesoBackendAlan.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "bonos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class BonoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idBono;

    @Column(name = "marca")
    private String marca;
    @Column(name = "numero_bonos")
    private Integer numeroBonos;
    @Column(name = "monto_bono")
    private Integer montoBono;

}
