/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.SalaEntity;
import co.edu.uniandes.ergo.festival.entities.TeatroEntity;
import java.util.*;

/**
 *
 * @author de.gutierrez
 */
public class TeatroDetailDTO extends TeatroDTO
{
       private List<SalaDTO> salas;
    
   public TeatroDetailDTO()
   {
       
   }
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public TeatroDetailDTO(TeatroEntity entity)
    {
       super(entity);
       if(entity != null)
       {
        salas = new ArrayList<>();
        for(SalaEntity entitySala: entity.getSalas())
        {
            salas.add(new SalaDTO(entitySala));           
        }
       }
    }
 
     /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public TeatroEntity toEntity()
    {
        TeatroEntity entity = super.toEntity();
        if(salas != null)
         {
           List<SalaEntity> salasEntity = new ArrayList<>();
           for(SalaDTO slas: salas)
           {
               salasEntity.add(slas.toEntity());
           }
         entity.setSalas(salasEntity);
         }        
         return entity;
    }

   public List<SalaDTO> getSalas() {
       return salas;
   }

   public void setSalas(List<SalaDTO> salas) {
        this.salas = salas;
   }
}
