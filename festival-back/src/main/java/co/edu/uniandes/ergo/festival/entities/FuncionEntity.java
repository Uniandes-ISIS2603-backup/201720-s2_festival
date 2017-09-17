/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 *
 * @author dj.bautista10
 */
@Entity
public class FuncionEntity extends BaseEntity implements Serializable{
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date horaInicio;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date horaFin;

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }
    
    
    
    
}
