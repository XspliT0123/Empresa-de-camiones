package com.empresa.Repositorio;

import com.empresa.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<UsuarioModel, Integer> {
    Optional<UsuarioModel> findByUsername(String username);
    boolean existsByUsername(String username);
}
