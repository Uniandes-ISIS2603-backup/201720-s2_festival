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
public class PersonaEntity extends BaseEntity implements Serializable{
    
    /**
     * Nombre de la persona.
     */
    private String nombre;
    
    
    
    
}