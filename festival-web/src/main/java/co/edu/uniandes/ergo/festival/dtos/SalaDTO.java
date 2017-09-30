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

    private Long id;
    private String name;
    private int numSillas;
    private int numSillasPreferenciales;
    
    public SalaDTO() {
    }
    
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
