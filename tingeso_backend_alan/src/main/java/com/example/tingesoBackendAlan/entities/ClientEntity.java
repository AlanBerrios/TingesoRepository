package com.example.tingesoBackendAlan.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ClientEntity {

    @Id
    @Column(name = "rut", unique = true, nullable = false)
    private String rut;
    @Column(name = "nombre")
    private String nombre;

}
