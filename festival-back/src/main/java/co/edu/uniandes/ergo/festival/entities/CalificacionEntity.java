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
     /**
      * Atributo que contiene el valor de la Calificación.
      */
     private double calificacion;
     /**
      * Atributo que contiene el comentario de la Calificación.
      */
     private String comentario;
     /**
      * Método que obtiene el valor de la Calificación.
      * @return double, Valor de la Calificación.
      */
    public double getCalificacion() {
        return calificacion;
    }
    /**
     * Método que establece el valor de la Calificación.
     * @param calificacion double, nuevo Valor de la Calificación.
     */
    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
    /**
     * Método que obtiene el Comentario de la Calificación.
     * @return String, Comentario de la Calificación.
     */
    public String getComentario() {
        return comentario;
    }
    /**
     * Método que establece el Comentario de la Calificación.
     * @param comentario String, nuevo comentario de la Calificación.
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
