/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.CriticaEntity;

/**
 *
 * @author f.reyes948
 */
public class CriticaDTO {
    
    /**
     * Identificador de la CriticaEntity en la base de datos.
     */
    private Long id;
    
    /**
     * Comentario hecho por el crítico sobre una función.
     */
    private String comentario;
    
    /**
     * Constructor sin parámetros.
     */
    public CriticaDTO(){
        
    }
    
    /**
     * Costruye una CriticaDTO a partir de la entidad.
     * @param entity La entidad CriticaEntity.
     */
    public CriticaDTO(CriticaEntity entity){
        if (entity != null){
            id = entity.getId();
            comentario = entity.getComentario();
        }
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
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
     * Retorna una CriticaEntity a partir del DTO.
     * @return la CriticaEntity.
     */
    public CriticaEntity toEntity(){
        CriticaEntity entity = new CriticaEntity();
        entity.setId(id);
        entity.setComentario(comentario);
        return entity;
    }
}
