/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.TeatroEntity;

/**
 *
 * @author de.gutierrez
 */
public class TeatroDetailDTO extends TeatroDTO
{
      
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public TeatroDetailDTO(TeatroEntity entity)
    {
       super(entity);
    }
    
     /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public TeatroEntity toEntity()
    {
        TeatroEntity entity = new TeatroEntity();
        
        return entity;
    }
}
