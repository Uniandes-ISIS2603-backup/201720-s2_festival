/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author dj.bautista10
 */
@Entity
public class EspectadorEntity extends PersonaEntity {

    /**
     * Dirección del Espectador.
     */
    private String direccion;

    /**
     * Boleta asociada a un espectador
     */
    @PodamExclude
    @OneToMany
    private ArrayList<BoletaEntity> boletas;
    @PodamExclude
    @OneToMany
    private ArrayList<AbonoEntity> abonos;

    /**
     * @param direccion la direccion a modificar del Estudiante.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setBoletas(ArrayList<BoletaEntity> boletas) {
        this.boletas = boletas;
    }

    public void addAbono(AbonoEntity abono){
        abonos.add(abono);
    }
    public void setAbonos(ArrayList<AbonoEntity> abonos) {
        this.abonos = abonos;
    }

    /**
     * @return la dirección del Espectador.
     */
    public String getDireccion() {
        return direccion;
    }
    
    public ArrayList<AbonoEntity> getAbonos(){
        return abonos;
    }

    
    public ArrayList<BoletaEntity> getBoletas() {
        return boletas;
    }
}
