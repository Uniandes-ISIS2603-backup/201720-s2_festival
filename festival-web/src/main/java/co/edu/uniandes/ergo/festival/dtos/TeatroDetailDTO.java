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
       //Método constructor por Defecto.
   }
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public TeatroDetailDTO(TeatroEntity entity)
    {
       super(entity);
      salas = listSalas2DTO(entity);
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
        entity.setSalas(listDTO2Salas());
         return entity;
    }

   public List<SalaDTO> getSalas() {
       return salas;
   }

   public void setSalas(List<SalaDTO> salas) {
        this.salas = salas;
   }
   
   private List<SalaDTO> listSalas2DTO(TeatroEntity entity){
        List<SalaDTO> lista = new ArrayList();
        for (SalaEntity sala : entity.getSalas()){
            lista.add(new SalaDTO(sala));
        }
        return lista;
    }
   private List<SalaEntity> listDTO2Salas(){
        List<SalaEntity> resp = new ArrayList();
        if (salas != null){
            for (SalaDTO sala : salas){
                resp.add(sala.toEntity());
            }
        }
        return resp;
    }
}
