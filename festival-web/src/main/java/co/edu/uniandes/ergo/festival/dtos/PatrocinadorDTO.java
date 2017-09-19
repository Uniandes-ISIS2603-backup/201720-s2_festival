/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.PatrocinadorEntity;

/**
 *
 * @author f.mayenberger10
 */
public class PatrocinadorDTO {

    private Long id;
    private String name;
    private Double patrocinio;
    private Long NIT;
    
    public PatrocinadorDTO() {
        
    }
    public PatrocinadorDTO(PatrocinadorEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.patrocinio = entity.getPatrocinio();
        this.NIT = entity.getNIT();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return the patrocinio
     */
    public Double getPatrocinio() {
        return patrocinio;
    }

    /**
     * @param patrocinio the patrocinio to set
     */
    public void setPatrocinio(Double patrocinio) {
        this.patrocinio = patrocinio;
    }

    /**
     * @return the NIT
     */
    public Long getNIT() {
        return NIT;
    }

    /**
     * @param NIT the NIT to set
     */
    public void setNIT(Long NIT) {
        this.NIT = NIT;
    }
    
    public PatrocinadorEntity toEntity() {
        PatrocinadorEntity retornar = new PatrocinadorEntity();
        retornar.setId(this.getId());
        retornar.setNIT(NIT);
        retornar.setPatrocinio(patrocinio);
        retornar.setName(this.getName());
        return retornar;
    }
}
