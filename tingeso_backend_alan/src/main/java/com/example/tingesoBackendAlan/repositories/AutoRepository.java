package com.example.tingesoBackendAlan.repositories;

import com.example.tingesoBackendAlan.entities.AutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoRepository extends JpaRepository<AutoEntity, String> {

    public AutoEntity findByPatente(String patente);
    List<AutoEntity> findByMarca(String marca);
    List<AutoEntity> findByModelo(String modelo);
    List<AutoEntity> findByAnioGreaterThan(int anio);
    List<AutoEntity> findByKilometrajeBetween(Integer startKilometraje, Integer endKilometraje);
    List<AutoEntity> findByTipoMotor(String tipoMotor);
    List<AutoEntity> findByNumeroAsientosGreaterThan(int numeroAsientos);

    @Query(value = "SELECT * FROM autos WHERE autos.patente = :patente", nativeQuery = true)
    AutoEntity findByPatenteNativeQuery(@Param("patente") String patente);


    void deleteByPatente(String patente);

}