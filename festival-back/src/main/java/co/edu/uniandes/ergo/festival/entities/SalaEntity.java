/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author f.mayenberger10
 */
@Entity
public class SalaEntity extends BaseEntity implements Serializable {

    @PodamExclude
    @OneToMany
    private List<FuncionEntity> funciones;
    @PodamExclude
    @OneToMany(mappedBy="sala", cascade = {CascadeType.REMOVE})
    private List<SillaEntity> sillas;
    @PodamExclude
    @ManyToOne
    private TeatroEntity teatro;
    private int numSillas;
    private int numSillasPreferenciales;
    
    /**
     * @return the funciones
     */
    public List<FuncionEntity> getFunciones() {
        return funciones;
    }

    /**
     * @param funciones the funciones to set
     */
    public void setFunciones(List<FuncionEntity> funciones) {
        this.funciones = funciones;
    }

    /**
     * @return the sillas
     */
    public List<SillaEntity> getSillas() {
        return sillas;
    }

    /**
     * @param sillas the sillas to set
     */
    public void setSillas(List<SillaEntity> sillas) {
        this.sillas = sillas;
    }

    /**
     * @return the teatro
     */
    public TeatroEntity getTeatro() {
        return teatro;
    }

    /**
     * @param teatro the teatro to set
     */
    public void setTeatro(TeatroEntity teatro) {
        this.teatro = teatro;
    }

    /**
     * @return the numSillas
     */
    public int getNumSillas() {
        return numSillas;
    }

    /**
     * @param numSillas the numSillas to set
     */
    public void setNumSillas(int numSillas) {
        this.numSillas = numSillas;
    }

    /**
     * @return the numSillasPreferenciales
     */
    public int getNumSillasPreferenciales() {
        return numSillasPreferenciales;
    }

    /**
     * @param numSillasPreferenciales the numSillasPreferenciales to set
     */
    public void setNumSillasPreferenciales(int numSillasPreferenciales) {
        this.numSillasPreferenciales = numSillasPreferenciales;
    }
}
