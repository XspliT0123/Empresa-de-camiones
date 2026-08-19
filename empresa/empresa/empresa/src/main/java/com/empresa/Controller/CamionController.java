package com.empresa.Controller;

import com.empresa.Model.CamionModel;
import com.empresa.Service.CamionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camiones")
public class CamionController {

    private final CamionService camionService;

    public CamionController(CamionService camionService) {
        this.camionService = camionService;
    }

    @PostMapping
    public ResponseEntity<String> registrarCamion(@RequestBody CamionModel camion) {

        try {
            camionService.registrarCamiones(camion);
            return ResponseEntity.ok("Camión registrado correctamente");

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<CamionModel>> listarCamiones() {
        return ResponseEntity.ok(camionService.listarCamiones());
    }
}
