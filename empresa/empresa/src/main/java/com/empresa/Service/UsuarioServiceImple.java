package com.empresa.Service;

import com.empresa.Model.UsuarioModel;
import com.empresa.Repositorio.UsuarioRepositorio;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImple implements UsuarioService {

    private final UsuarioRepositorio usuarioRepositorio;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImple(
            UsuarioRepositorio usuarioRepositorio,
            PasswordEncoder passwordEncoder) {

        this.usuarioRepositorio = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registrarUsuario(UsuarioModel usuario) {

        if (usuarioRepositorio.existsByUsername(usuario.getUsername())) {
            throw new RuntimeException("El usuario ya existe");
        }

        usuario.setPassword(
                passwordEncoder.encode(usuario.getPassword())
        );

        usuarioRepositorio.save(usuario);
    }
}