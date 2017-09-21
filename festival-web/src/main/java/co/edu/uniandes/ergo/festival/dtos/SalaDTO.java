/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.SalaEntity;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author f.mayenberger10
 */
public class SalaDTO {

    private Long id;
    private String name;
    
    public SalaDTO() {
    }
    
    public SalaDTO(SalaEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
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
        return retornar;
    }
}