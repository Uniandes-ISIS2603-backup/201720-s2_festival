/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author f.reyes948
 */
@Entity
public class CriticaEntity extends BaseEntity{
    
//    /**
//     * Función a la que pertenece una crítica.
//     */
//    @PodamExclude
//    @ManyToOne()
//    private FuncionEntity funcion;
//    
//    /**
//     * Crítico que hace la crítica.
//     */
//    @ManyToOne()
//    @PodamExclude
//    private CriticoEntity critico;
    
    /**
     * Comentario hecho por el crítico sobre una función.
     */
    @Column(length=500)
    private String comentario;

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
