package com.empresa.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class ConductorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

 private String nombre;
 private int documento;
 private int celular;


    public ConductorModel(String nombre, int documento, int celular){
      this.nombre=nombre;
      this.documento=documento;
      this.celular=celular;
  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ConductorModel() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }
}
