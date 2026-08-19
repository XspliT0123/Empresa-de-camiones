package com.empresa.Controller;


import com.empresa.Model.ConductorModel;
import com.empresa.Service.ConductorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conductores")
public class ConductorController {

    private final ConductorService conductorService;

    public ConductorController(ConductorService conductorService) {
        this.conductorService = conductorService;
    }

    @PostMapping
    public ResponseEntity<String> registrarConductor(
            @RequestBody ConductorModel conductor) {

        try {
            conductorService.registrarConductores(conductor);
            return ResponseEntity.ok("Conductor registrado correctamente");

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<ConductorModel>> listarConductores() {
        return ResponseEntity.ok(conductorService.listarConductores());
    }
}