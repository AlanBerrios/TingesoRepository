package com.example.tingesoBackendAlan.repositories;

import com.example.tingesoBackendAlan.entities.BonoEntity;
import com.example.tingesoBackendAlan.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {

    public ClienteEntity findByRut(String rut);
    public void deleteByRut(String rut);
    @Query(value = "SELECT * FROM cliente WHERE cliente.rut = :rut", nativeQuery = true)
    ClienteEntity findByRutQuery(@Param("rut") String rut);
}
