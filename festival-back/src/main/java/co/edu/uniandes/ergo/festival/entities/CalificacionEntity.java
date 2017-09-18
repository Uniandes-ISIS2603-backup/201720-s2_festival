/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author m.neira10
 */
 @Entity
public class CalificacionEntity extends BaseEntity implements Serializable {
     
     private double calificacion;
     
     private String comentario;
//     
//     @PodamExclude
//     @OneToOne(mappedBy=)
//     private Boleta boleta;

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
     
     
    
}
