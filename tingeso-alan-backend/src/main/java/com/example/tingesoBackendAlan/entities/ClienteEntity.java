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

public class ClienteEntity {

    @Id
    @Column(name = "rut", unique = true, nullable = false)
    private String rut;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "correo")
    private String correo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;


}
