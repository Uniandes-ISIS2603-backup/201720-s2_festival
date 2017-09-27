/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author f.reyes948
 */
@Entity
public class SillaEntity extends BaseEntity implements Serializable{
    
    /**
     * Sala a la que pertenece una silla.
     */
//    @ManyToOne(cascade = CascadeType.PERSIST)
    @ManyToOne
    @PodamExclude
//    @Column(nullable = false) //¿Por qué no sirve? Porque se debe usar 
//    @JoinColumn para las columnas con llaves foráneas. 
    @JoinColumn(nullable = false)
    private SalaEntity sala;
    
    /**
     * Boletas que tienen esta silla.
     */
    @OneToMany(mappedBy="silla", cascade = {CascadeType.REMOVE})
//    @OneToMany(mappedBy="silla")
    @PodamExclude
    private ArrayList<BoletaEntity> boletas;

    /**
     * Indica la tarifa pagada por la silla.
     */
    private double tarifa;
    
    /**
     * Indica si la silla es o no preferencial.
     */
    private boolean esPreferencial;

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
     * @return the sala
     */
    public SalaEntity getSala() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(SalaEntity sala) {
        this.sala = sala;
    }

    /**
     * @return the boletas
     */
    public ArrayList<BoletaEntity> getBoletas() {
        return boletas;
    }

    /**
     * @param boletas the boletas to set
     */
    public void setBoletas(ArrayList<BoletaEntity> boletas) {
        this.boletas = boletas;
    }
    
    
}
