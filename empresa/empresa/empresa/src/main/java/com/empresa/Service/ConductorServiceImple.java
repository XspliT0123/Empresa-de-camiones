package com.empresa.Service;

import com.empresa.Model.ConductorModel;
import com.empresa.Repositorio.ConductorRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConductorServiceImple implements ConductorService {

    private final ConductorRepositorio conductorRepositorio;

    public ConductorServiceImple(ConductorRepositorio conductorRepositorio) {
        this.conductorRepositorio = conductorRepositorio;
    }

    @Override
    public void registrarConductores(ConductorModel model) {

        if (conductorRepositorio.existsByDocumento(model.getDocumento())) {
            throw new RuntimeException("El documento ya existe");
        }

        conductorRepositorio.save(model);
    }

    @Override
    public List<ConductorModel> listarConductores() {
        return conductorRepositorio.findAll();
    }
}

