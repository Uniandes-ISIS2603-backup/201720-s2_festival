/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author f.reyes948
 */
@Entity
public class SillaEntity extends BaseEntity implements Serializable{
    
    private String prueba;
    
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
     * Sala a la que pertenece la silla.
     */
    @PodamExclude
    @ManyToOne(optional = false)
    private SalaEntity sala;
    
    /**
     * Boletas que tienen esta silla.
     */
    @PodamExclude
    @OneToMany(mappedBy="silla")
    private ArrayList<BoletaEntity> boletas;

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

    /**
     * @return the prueba
     */
    public String getPrueba() {
        return prueba;
    }

    /**
     * @param prueba the prueba to set
     */
    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }
    
    
}
