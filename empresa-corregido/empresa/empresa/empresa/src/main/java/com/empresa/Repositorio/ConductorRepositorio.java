package com.empresa.Repositorio;

import com.empresa.Model.ConductorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConductorRepositorio extends JpaRepository<ConductorModel, Integer> {
    Optional<ConductorModel> findByDocumento(int documento);
    boolean existsByDocumento(int documento);
}
