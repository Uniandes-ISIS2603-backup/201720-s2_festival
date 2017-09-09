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
    // TODO: Hacer entidad Boleta 
    //private BoletaEntity boleta;
    
    
     /**
     * @param direccion la direccion a modificar del Estudiante.
     */
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    /**
     * @return la dirección del Espectador.
     */
    public String getDireccion(){
        return direccion;
    }
}
