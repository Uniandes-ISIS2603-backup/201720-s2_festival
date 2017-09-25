/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author m.neira10
 */
 @Entity
public class CalificacionEntity extends BaseEntity implements Serializable {
     
     private double calificacion;
     
     private String comentario;
     
     @OneToOne(mappedBy = "calificacion")
     @PodamExclude
     private BoletaEntity boleta;

    public BoletaEntity getBoleta() {
        return boleta;
    }

    public void setBoleta(BoletaEntity boleta) {
        this.boleta = boleta;
    }


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
