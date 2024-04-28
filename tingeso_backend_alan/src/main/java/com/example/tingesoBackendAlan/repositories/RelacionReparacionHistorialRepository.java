package com.example.tingesoBackendAlan.repositories;

import com.example.tingesoBackendAlan.entities.AutoEntity;
import com.example.tingesoBackendAlan.entities.RelacionReparacionHistorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RelacionReparacionHistorialRepository extends JpaRepository<RelacionReparacionHistorialEntity, Long> {

    RelacionReparacionHistorialEntity findByIdRelacionReparacionHistorial(Long idRelacionReparacionHistorial);
    RelacionReparacionHistorialEntity findByIdHistorial(Long idHistorial);
    List<RelacionReparacionHistorialEntity> findAllByIdHistorial(Long idHistorial);
    RelacionReparacionHistorialEntity findByIdReparacion(Long idReparacion);

    @Query(value = "SELECT * FROM relacion_reparacion_historial WHERE relacion_reparacion_historial.idRelacionReparacionHistorial = :idRelacionReparacionHistorial", nativeQuery = true)
    AutoEntity findByIdRelacionReparacionHistorialQuery(@Param("idRelacionReparacionHistorial") Long idRelacionReparacionHistorial);


}
