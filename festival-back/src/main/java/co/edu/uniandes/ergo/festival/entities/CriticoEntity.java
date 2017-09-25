/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author dj.bautista10
 */
@Entity
public class CriticoEntity extends PersonaEntity{
    
    @PodamExclude
    @OneToMany(mappedBy = "critico")
    private List<CriticaEntity> criticas;
    @PodamExclude
    @OneToMany
    private List<PeliculaEntity> peliculas;
    

    public List<CriticaEntity> getCriticas(){
        return criticas;
    }
    
    public List<PeliculaEntity> GetPeliculas(){
        return peliculas;
    }
    
    public void setPeliculas(List<PeliculaEntity> peliculas){
        this.peliculas = peliculas;
    }
    public void setCriticas(List<CriticaEntity> criticas){
        this.criticas = criticas;
    }
    
    public void addCritica(CriticaEntity critica){
        criticas.add(critica);
    }
}
