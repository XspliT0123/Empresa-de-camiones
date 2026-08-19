package com.empresa.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class CamionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String placa;
    private String tipoVehi;

    public CamionModel() {
    }

    public CamionModel(String placa, String tipoVehi){
        this.placa=placa;
        this.tipoVehi=tipoVehi;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoVehi() {
        return tipoVehi;
    }

    public void setTipoVehi(String tipoVehi) {
        this.tipoVehi = tipoVehi;
    }
}
