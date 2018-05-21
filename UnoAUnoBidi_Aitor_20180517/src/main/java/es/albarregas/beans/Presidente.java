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
public class Presidente implements Serializable {
    
    private int id;
    private String nombrePresidente;
    private Pais pais;

    public Presidente() {
    }

    public Presidente(int id, String nombrePresidente, Pais pais) {
        this.id = id;
        this.nombrePresidente = nombrePresidente;
        this.pais = pais;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePresidente() {
        return nombrePresidente;
    }

    public void setNombrePresidente(String nombrePresidente) {
        this.nombrePresidente = nombrePresidente;
    }
    
    
}
