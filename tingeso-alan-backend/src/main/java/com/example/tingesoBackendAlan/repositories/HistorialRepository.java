package com.example.tingesoBackendAlan.repositories;

import com.example.tingesoBackendAlan.entities.AutoEntity;
import com.example.tingesoBackendAlan.entities.HistorialEntity;
import com.example.tingesoBackendAlan.entities.ReparacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HistorialRepository extends JpaRepository<HistorialEntity, Long> {

    HistorialEntity findByIdHistorial(Long idHistorial);
    HistorialEntity findByPatente(String patente);
    HistorialEntity findByRut(String rut);
    long countByPatente(String patente);

    @Query(value = "SELECT * FROM historial WHERE historial.idHistorial = :idHistorial", nativeQuery = true)
    AutoEntity findByIdHistorialQuery(@Param("idHistorial") Long idHistorial);

    void deleteByIdHistorial(Long idHistorial);
}
