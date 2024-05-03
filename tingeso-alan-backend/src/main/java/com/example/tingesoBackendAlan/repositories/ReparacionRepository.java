package com.example.tingesoBackendAlan.repositories;

import com.example.tingesoBackendAlan.entities.ReparacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReparacionRepository extends JpaRepository<ReparacionEntity, Long> {

    public ReparacionEntity findByPatente(String patente);
    public ReparacionEntity findByIdReparacion(Long idReparacion);
    List<ReparacionEntity> findByFechaIngreso(LocalDate fechaIngreso);
    List<ReparacionEntity> findAllByPatente(String patente);
    List<ReparacionEntity> findByTipoReparacion(Integer tipoReparacion);
    Integer countByPatente(String patente);



    @Query("SELECT r FROM ReparacionEntity r WHERE r.patente = :patente AND r.fechaIngreso = :fechaIngreso")
    List<ReparacionEntity> findByPatenteAndFechaIngreso(@Param("patente") String patente, @Param("fechaIngreso") LocalDate fechaIngreso);

}