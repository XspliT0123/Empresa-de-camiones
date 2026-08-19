package com.empresa.Service;

import com.empresa.Model.ConductorModel;

import java.util.List;

public interface ConductorService {
    void registrarConductores(ConductorModel model);
    List<ConductorModel> listarConductores();
}
