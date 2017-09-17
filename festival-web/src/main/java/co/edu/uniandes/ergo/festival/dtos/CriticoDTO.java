/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.CriticoEntity;

/**
 *
 * @author dj.bautista10
 */
public class CriticoDTO {

    private Long id;
    private String nombre;

    public CriticoDTO() {

    }

    public CriticoDTO(CriticoEntity critico) {
        if (critico != null) {
            this.id = critico.getId();
            this.nombre = critico.getName();
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String nombre) {
        this.nombre = nombre;
    }

    CriticoEntity toEntity() {
        CriticoEntity entCritico = new CriticoEntity();
        entCritico.setId(this.id);
        entCritico.setName(this.nombre);
        
        return entCritico;
    }
}
