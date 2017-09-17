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
public class CriticaDetailDTO extends CriticaDTO {
    
    /**
     * Constructor sin parámetros.
     */
    public CriticaDetailDTO(){
        
    }
    
    /**
     * Crea una CriticaDetailDTO a partir de la entidad.
     * @param entity La entidad CriticaEntity.
     */
    public CriticaDetailDTO(CriticaEntity entity){
        super(entity);
    }
    
    /**
     * Convierte la CriticaDetailDTO a un entity.
     * @return La CriticaEntity.
     */
    public CriticaEntity toEntity(){
        return super.toEntity();
    }
}
