/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;

/**
 *
 * @author aitor
 */
public class Pais implements Serializable {
    
    private int id;
    private String nombrePais;
    private Presidente presidente;

    public Pais() {
    }

    public Pais(int id, String nombrePais, Presidente presidente) {
        this.id = id;
        this.nombrePais = nombrePais;
        this.presidente = presidente;
    }

    public Presidente getPresidente() {
        return presidente;
    }

    public void setPresidente(Presidente presidente) {
        this.presidente = presidente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
    
    
}
