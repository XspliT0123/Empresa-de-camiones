package com.empresa.Repositorio;

import com.empresa.Model.CamionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CamionRepositorio extends JpaRepository<CamionModel, Integer> {
    Optional<CamionModel> findByPlaca(String placa);
    boolean existsByPlaca(String placa);
}