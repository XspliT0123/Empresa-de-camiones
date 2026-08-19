package com.empresa.Service;

import com.empresa.Model.CamionModel;
import com.empresa.Repositorio.CamionRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CamionServiceImple implements CamionService{
    private final CamionRepositorio camionRepositorio;

    public CamionServiceImple(CamionRepositorio camionRepositorio) {
        this.camionRepositorio = camionRepositorio;
    }

    @Override
    public void registrarCamiones(CamionModel model) {
        if(camionRepositorio.existsByPlaca(model.getPlaca())){
            throw new RuntimeException("La placa ya existe");
        }
        camionRepositorio.save(model);
    }

    @Override
    public List<CamionModel> listarCamiones() {
        return camionRepositorio.findAll();
    }
}
