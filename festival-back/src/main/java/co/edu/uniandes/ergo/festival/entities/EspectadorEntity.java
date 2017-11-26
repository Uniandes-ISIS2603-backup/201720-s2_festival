/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.entities;

import java.io.Serializable;
import java.util.List;
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
    private List<BoletaEntity> boletas;
    /**
     * Atributo que contiene la Lista de Abonos de este Espectador.
     */
    @PodamExclude
    @OneToMany
    private List<AbonoEntity> abonos;

    /**
     * @param direccion la direccion a modificar del Estudiante.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Método que establece las Boletas de este Espectador.
     * @param boletas List<BoletaEntity>, nuevas Boletas de este Espectador.
     */
    public void setBoletas(List<BoletaEntity> boletas) {
        this.boletas = boletas;
    }
    /**
     * Método que agrega un Abono a este Espectador.
     * @param abono AbonoEntity, nuevo Abono del Espectador.
     */
    public void addAbono(AbonoEntity abono){
        abonos.add(abono);
    }
    /**
     * Método que establece la Lista de Abonos del Espectador.
     * @param abonos List<AbonoEntity>, nueva Lista de Abonos del Espectador.
     */
    public void setAbonos(List<AbonoEntity> abonos) {
        this.abonos = abonos;
    }
    /**
     * @return la dirección del Espectador.
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * Método que obtiene la Lista de Abonos del Espectador.
     * @return List<AbonoEntity>, Lista de Abonos del Espectador.
     */
    public List<AbonoEntity> getAbonos(){
        return abonos;
    }
    /**
     * Método que obtiene la Lista de Boletas del Espectador.
     * @return List<BoletaEntity>, Lista de Boletas del Espectador.
     */
    public List<BoletaEntity> getBoletas() {
        return boletas;
    }
    /**
     * Método que agrega una Boleta a la Lista de Boletas del Espectador.
     * @param boleta BoletaEntity, nueva Boleta del Espectador.
     */
    public void addBoleta(BoletaEntity boleta) {
        this.boletas.add(boleta);
    }
}
