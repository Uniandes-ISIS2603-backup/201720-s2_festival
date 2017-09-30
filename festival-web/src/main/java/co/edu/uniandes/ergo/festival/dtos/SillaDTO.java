/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.SillaEntity;

/**
 *
 * @author f.reyes948
 */
public class SillaDTO {
    
    /**
     * Identificador de la SillaEntity en la base de datos.
     */
    private Long id;
    
    private String name;
    /**
     * Indica la tarifa pagada por la silla.
     */
    private double tarifa;
    
    /**
     * Indica si la silla es o no preferencial.
     */
    private boolean esPreferencial;
    
    /**
     * Constructor sin parámetros.
     */
    public SillaDTO(){
        
    }
    
    /**
     * Costruye una SillaDTO a partir de la entidad.
     * @param entity La entidad SillaEntity.
     */
    public SillaDTO(SillaEntity entity){
        if (entity != null){
            id = entity.getId();
            tarifa = entity.getTarifa();
            esPreferencial = entity.isEsPreferencial();
            name = entity.getName();
        }
    }

    /**
     * @return the tarifa
     */
    public double getTarifa() {
        return tarifa;
    }

    /**
     * @param tarifa the tarifa to set
     */
    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    /**
     * @return the esPreferencial
     */
    public boolean isEsPreferencial() {
        return esPreferencial;
    }

    /**
     * @param esPreferencial the esPreferencial to set
     */
    public void setEsPreferencial(boolean esPreferencial) {
        this.esPreferencial = esPreferencial;
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
     * Retorna una SillaEntity a partir del DTO.
     * @return la SillaEntity.
     */
    public SillaEntity toEntity(){
        SillaEntity entity = new SillaEntity();
        entity.setId(id);
        entity.setTarifa(tarifa);
        entity.setEsPreferencial(esPreferencial);
        entity.setName(name);
        return entity;
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
}
