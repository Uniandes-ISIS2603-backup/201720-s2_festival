/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.SalaEntity;

/**
 *
 * @author f.mayenberger10
 */
public class SalaDTO {
    /**
     * Atributo que contiene el ID de esta Sala.
     */
    private Long id;
    /**
     * Atributo que contiene el Nombre de esta Sala.
     */
    private String name;
    /**
     * Atributo que contiene el número de sillas de esta Sala.
     */
    private int numSillas;
    /**
     * Atributo que contiene el número de sillas preferenciales de esta Sala.
     */
    private int numSillasPreferenciales;
    /**
     * Método constructors por Defecto.
     */
    public SalaDTO() {
        //Método constructor por Defecto.
    }
    /**
     * Método constructors que construye una SalaDTO a partir de la version Entity.
     * @param entity SalaEntity, Entidad de la Sala.
     */
    public SalaDTO(SalaEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.numSillas = entity.getNumSillas();
        this.numSillasPreferenciales = entity.getNumSillasPreferenciales();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Método que construye la versión Entity de esta Sala.
     * @return SalaEntity
     */
    public SalaEntity toEntity() {
        SalaEntity retornar = new SalaEntity();
        retornar.setId(this.id);
        retornar.setName(this.name);
        retornar.setNumSillas(this.getNumSillas());
        retornar.setNumSillasPreferenciales(this.getNumSillasPreferenciales());
        return retornar;
    }

    /**
     * @return the numSillas
     */
    public int getNumSillas() {
        return numSillas;
    }

    /**
     * @param numSillas the numSillas to set
     */
    public void setNumSillas(int numSillas) {
        this.numSillas = numSillas;
    }

    /**
     * @return the numSillasPreferenciales
     */
    public int getNumSillasPreferenciales() {
        return numSillasPreferenciales;
    }

    /**
     * @param numSillasPreferenciales the numSillasPreferenciales to set
     */
    public void setNumSillasPreferenciales(int numSillasPreferenciales) {
        this.numSillasPreferenciales = numSillasPreferenciales;
    }
}
