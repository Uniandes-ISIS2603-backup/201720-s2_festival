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
public class TeatroDTO
{
 
    private Long id;
    private String nombre;
    
    /**
     * Constructor vacío para JAX-RS.
     */
    public TeatroDTO(){
        
    }
    
    public TeatroDTO(TeatroEntity teatro)
    {
        this.id = teatro.getId();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public TeatroEntity toEntity()
    {
        TeatroEntity entity = new TeatroEntity();
        entity.setId(this.id);
        entity.setNombre(this.nombre);
        return entity;
    }
}
