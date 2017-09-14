/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author f.reyes948
 */
@Entity
public class CríticaEntity extends BaseEntity{
    
    /**
     * Comentario hecho por el crítico sobre una función.
     */
    private String comentario;
    
    /**
     * Crítico que hace la crítica.
     */
    @ManyToOne()
    private CriticoEntity crítico;
    
    /**
     * Función sobre la que es la crítica.
     */
    @ManyToOne(optional = false)
    private FuncionEntity función;

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
    
    
    
}
