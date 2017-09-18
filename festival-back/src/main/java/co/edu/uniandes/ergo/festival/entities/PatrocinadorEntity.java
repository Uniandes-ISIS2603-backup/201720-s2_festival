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
 * @author f.mayenberger10
 */
@Entity
public class PatrocinadorEntity extends PersonaEntity implements Serializable {

    
    private double patrocinio;
    private long NIT;
    /**
     * @return the patrocinio
     */
    public double getPatrocinio() {
        return patrocinio;
    }

    /**
     * @param patrocinio the patrocinio to set
     */
    public void setPatrocinio(double patrocinio) {
        this.patrocinio = patrocinio;
    }

    /**
     * @return the NIT
     */
    public long getNIT() {
        return NIT;
    }

    /**
     * @param NIT the NIT to set
     */
    public void setNIT(long NIT) {
        this.NIT = NIT;
    }
    
}
