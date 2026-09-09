package com.empresa.Controller;

import com.empresa.Model.UsuarioModel;
import com.empresa.Service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<String> registrarUsuario(
            @RequestBody UsuarioModel usuario) {

        try {
            usuarioService.registrarUsuario(usuario);
            return ResponseEntity.ok("Usuario registrado correctamente");

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}