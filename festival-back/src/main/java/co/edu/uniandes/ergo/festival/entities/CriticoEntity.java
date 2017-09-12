/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.entities;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author dj.bautista10
 */
@Entity
public class CriticoEntity extends PersonaEntity{
    
    @OneToMany
    private ArrayList<CriticaEntity> criticas;
    @OneToMany
    private ArrayList<PeliculaEntity> peliculas;
    
    
    public ArrayList<CriticaEntity> getCriticas(){
        return criticas;
    }
    
    public ArrayList<PeliculaEntity> GetPeliculas(){
        return peliculas;
    }
    
    public void setPeliculas(ArrayList<PeliculaEntity> peliculas){
        this.peliculas = peliculas;
    }
    public void setCriticas(ArrayList<CriticaEntity> criticas){
        this.criticas = criticas;
    }
    
    public void addCritica(CriticaEntity critica){
        criticas.add(critica);
    }
}
