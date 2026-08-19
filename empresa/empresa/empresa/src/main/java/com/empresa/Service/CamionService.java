package com.empresa.Service;

import com.empresa.Model.CamionModel;

import java.util.List;

public interface CamionService {
    void registrarCamiones(CamionModel model);
    List<CamionModel> listarCamiones();
}
