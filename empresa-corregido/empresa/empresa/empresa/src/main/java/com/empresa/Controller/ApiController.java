package com.empresa.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {


    @GetMapping("/publico")
    public Map<String, String> publico() {
        return Map.of(
                "mensaje", "Este endpoint es público",
                "acceso", "todos"
        );
    }


    @GetMapping("/privado")
    public Map<String, Object> privado(Authentication auth) {
        return Map.of(
                "mensaje", "Endpoint privado — solo rol USER",
                "usuario", auth.getName(),
                "roles", auth.getAuthorities().toString()
        );
    }


    @GetMapping("/admin")
    public Map<String, Object> admin(Authentication auth) {
        return Map.of(
                "mensaje", "Endpoint de administración — solo rol ADMIN",
                "usuario", auth.getName(),
                "roles", auth.getAuthorities().toString()
        );
    }
}