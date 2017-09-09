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
 * @author f.reyes948
 */
@Entity
public class SillaEntity extends BaseEntity implements Serializable{
    
    /**
     * Indica si la silla está reservada.
     */
    private boolean reservada;

    /**
     * Indica la tarifa pagada por la silla.
     */
    private double tarifa;
    
    /**
     * Indica si la silla es o no preferencial.
     */
    private boolean esPreferencial;

    /**
     * @return the reservada
     */
    public boolean isReservada() {
        return reservada;
    }

    /**
     * @param reservada the reservada to set
     */
    public void setReservada(boolean reservada) {
        this.reservada = reservada;
    }

    /**
     * @return the tarifa
     */
    public double getTarifa() {
        return tarifa;
    }

    /**
     * @param tarifa the tarifa to set
     */
    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    /**
     * @return the esPreferencial
     */
    public boolean isEsPreferencial() {
        return esPreferencial;
    }

    /**
     * @param esPreferencial the esPreferencial to set
     */
    public void setEsPreferencial(boolean esPreferencial) {
        this.esPreferencial = esPreferencial;
    }
    
    
}
