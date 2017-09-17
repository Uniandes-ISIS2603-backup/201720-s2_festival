/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.AbonoEntity;

/**
 *
 * @author jc.corrales
 */
public class AbonoDTO
{
    /**
     * Atributo que contiene el ID.
     */
    private Long id;
    
    /**
     * Constructor por defecto
     */
    public AbonoDTO()
    {
        
    }
    
     /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en la entidad que viene de argumento.
     * @param editorial: Es la entidad que se va a convertir a DTO 
     */
    public AbonoDTO(AbonoEntity abono)
    {
        this.id = abono.getId();
    }
    /**
     * Método que obtiene el ID.
     * @return Long, ID del Abono.
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
    public AbonoEntity toEntity()
    {
        AbonoEntity entity = new AbonoEntity();
        entity.setId(this.id);
        return entity;
    }
    
}
