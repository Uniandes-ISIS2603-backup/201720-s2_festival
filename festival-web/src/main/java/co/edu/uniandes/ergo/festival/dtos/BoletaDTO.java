/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
/**
 *
 * @author jc.corrales
 */
public class BoletaDTO
{
    /**
     * Atributo que contiene el ID.
     */
    private Long id;
    /**
     * Constructor por defecto
     */
    public BoletaDTO()
    {
        
    }
    
     /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en la entidad que viene de argumento.
     * @param boleta: Es la entidad que se va a convertir a DTO 
     */
    public BoletaDTO(BoletaEntity boleta)
    {
        this.id = boleta.getId();
    }
    /**
     * Método que obtiene el ID.
     * @return Long, ID de la boleta.
     */
    public Long getId()
    {
        return id;
    }
    /**
     * Método que establece el ID.
     * @param id Long, ID nuevo.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Convertir DTO a Entity.
     * @return BoletaEntity, un Entity con los valores del DTO.
     */
    public BoletaEntity toEntity()
    {
        BoletaEntity entity = new BoletaEntity();
        entity.setId(this.id);
        return entity;
    }
}
