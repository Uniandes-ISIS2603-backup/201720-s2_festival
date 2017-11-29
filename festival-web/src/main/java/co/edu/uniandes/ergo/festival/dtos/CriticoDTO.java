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
    /**
     * Atributo que contiene el ID del crítico.
     */
    private Long id;
    /**
     * Atributo que contiene el Nombre del Crítico.
     */
    private String nombre;

    public CriticoDTO() {
        //Método constructor por Defecto.
    }
    /**
     * Método que construye un CríticoDTO a partir de su versión Entity-
     * @param critico CriticoEntity, Entidad del Crítico.
     */
    public CriticoDTO(CriticoEntity critico) {
        if (critico != null) {
            this.id = critico.getId();
            this.nombre = critico.getName();
        }
    }
    /**
     * Método que obtiene el ID del crítico.
     * @return Long, ID del crítico.
     */
    public Long getId() {
        return id;
    }
    /**
     * Método que obtiene el Nombre del crítico.
     * @return String, Nombre del crítico.
     */
    public String getName() {
        return nombre;
    }
    /**
     * Método que establece el ID del crítico.
     * @param id Long, nuevo ID del crítico.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Método que establece el Nombre del Crítico.
     * @param nombre String, nuevo Nombre del Crítico.
     */
    public void setName(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Método que convierte este Crítico a su versión Entidad.
     * @return CriticoEntity, Entidad del Crítico.
     */
    CriticoEntity toEntity() {
        CriticoEntity entCritico = new CriticoEntity();
        entCritico.setId(this.id);
        entCritico.setName(this.nombre);
        
        return entCritico;
    }
}
