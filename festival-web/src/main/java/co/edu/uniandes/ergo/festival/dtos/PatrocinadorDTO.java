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
    /**
     * Atributo que contiene el ID del Patrocinador.
     */
    private Long id;
    /**
     * Atributo que contiene el nombre del Patrocinador.
     */
    private String name;
    /**
     * Atributo que contiene el valor del Patrocinio.
     */
    private Double patrocinio;
    /**
     * Atributo que contiene el NIT del Patrocinador.
     */
    private Long NIT;
    /**
     * Constructor por Defecto.
     */
    public PatrocinadorDTO() {
        //Método constructor por Defecto.
    }
    /**
     * Método que construye un PatrocinadorDTO a partir de su versión Entity.
     * @param entity PatrocinadorEntity.
     */
    public PatrocinadorDTO(PatrocinadorEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.patrocinio = entity.getPatrocinio();
        this.NIT = entity.getNIT();
    }

    /**
     * Método que obtiene el ID del Patrocinador.
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * Método que establece el ID del Patrocinador.
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Método que obtiene el nombre del Patrocinador.
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * Método que establece el nombre del Patrocinador.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Método que obtiene el valor del Patrocinio.
     * @return the patrocinio
     */
    public Double getPatrocinio() {
        return patrocinio;
    }
    /**
     * Método que establece el valor del Patrocinio.
     * @param patrocinio the patrocinio to set
     */
    public void setPatrocinio(Double patrocinio) {
        this.patrocinio = patrocinio;
    }
    /**
     * Método que obtiene el NIT del Patrocinador.
     * @return the NIT
     */
    public Long getNIT() {
        return NIT;
    }
    /**
     * Método que establece el NIT del Patrocinador.
     * @param NIT the NIT to set
     */
    public void setNIT(Long NIT) {
        this.NIT = NIT;
    }
    /**
     * Método que construye un PatrocinadorEntity a partir de este DTO:
     * @return PatrocinadorEntity, Entidad del Patrocinador.
     */
    public PatrocinadorEntity toEntity() {
        PatrocinadorEntity retornar = new PatrocinadorEntity();
        retornar.setId(this.getId());
        retornar.setNIT(NIT);
        retornar.setPatrocinio(patrocinio);
        retornar.setName(this.getName());
        return retornar;
    }
}
