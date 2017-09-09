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
public class SillaDetailDTO extends SillaDTO {
    
    /**
     * Constructor sin parámetros.
     */
    public SillaDetailDTO(){
        
    }
    
    /**
     * Crea una SillaDetailDTO a partir de la entidad.
     * @param entity La entidad SillaeEntity.
     */
    public SillaDetailDTO(SillaEntity entity){
        super(entity);
    }
    
    /**
     * Convierte la SillaDetailDTO a un entity.
     * @return La SillaEntity.
     */
    public SillaEntity toEntity(){
        return super.toEntity();
    }
}
