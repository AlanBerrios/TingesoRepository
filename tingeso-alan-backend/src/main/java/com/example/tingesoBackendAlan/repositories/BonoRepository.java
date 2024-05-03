package com.example.tingesoBackendAlan.repositories;

import com.example.tingesoBackendAlan.entities.AutoEntity;
import com.example.tingesoBackendAlan.entities.BonoEntity;
import com.example.tingesoBackendAlan.entities.ReparacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BonoRepository extends JpaRepository<BonoEntity, Long> {

    public BonoEntity findByIdBono(Long idBono);
    public BonoEntity findByMarca(String marca);
    @Query(value = "SELECT * FROM bono WHERE bono.idBono = :idBono", nativeQuery = true)
    AutoEntity findByIdBonoQuery(@Param("idBono") Long idBono);

}
