package com.empresa.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CamionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private String tipoVehi;

    public CamionModel() {
    }

    public CamionModel(String placa, String tipoVehi) {
        this.placa = placa;
        this.tipoVehi = tipoVehi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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