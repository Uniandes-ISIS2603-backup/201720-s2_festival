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
 * @author de.gutierrez
 */
@Entity 
public class TeatroEntity extends BaseEntity implements Serializable
{
    private String nombre;

    @PodamExclude
    @OneToMany
    private List<SalaEntity> salas;

    public List<SalaEntity> getSala() {
        return salas;
    }

    public void setSala(List<SalaEntity> sala) {
        this.salas = sala;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
