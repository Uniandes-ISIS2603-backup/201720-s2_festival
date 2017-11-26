/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author dj.bautista10
 */
@Entity
public class CriticoEntity extends PersonaEntity{
    /**
     * Atributo que contiene la Lista de Críticas del Crítico.
     */
    @PodamExclude
    @OneToMany
    private List<CriticaEntity> criticas;
    /**
     * Atributo que contiene la Lista de Películas del Crítico.
     */
    @PodamExclude
    @ManyToMany(mappedBy = "criticos")
    private List<PeliculaEntity> peliculas;
    
    /**
     * Métogo que obtiene la Lista de Críticas del Crítico.
     * @return List<CriticaEntity>, Lista de Críticas del Crítico.
     */
    public List<CriticaEntity> getCriticas(){
        return criticas;
    }
    /**
     * Método que obtiene la Lista de Películas del Crítico.
     * @return List<PeliculaEntity>, Lista de Pelíuclas del Crítico.
     */
    public List<PeliculaEntity> GetPeliculas(){
        return peliculas;
    }
    /**
     * Método que establece la Lista de Películas del Crítico.
     * @param peliculas List<PeliculaEntity>, nueva Lista de Películas del Crítico.
     */
    public void setPeliculas(List<PeliculaEntity> peliculas){
        this.peliculas = peliculas;
    }
    /**
     * Método que establece la Lista de Críticas del Crítico.
     * @param criticas List<CriticaEntity>, nueva Lista de Críticas del Crítico.
     */
    public void setCriticas(List<CriticaEntity> criticas){
        this.criticas = criticas;
    }
    /**
     * Método que agrega una Crítica a la Lista de Críticas del Crítico.
     * @param critica CriticaEntity, nueva Crítica.
     */
    public void addCritica(CriticaEntity critica){
        criticas.add(critica);
    }
    /**
     * Método que agrega una nueva Película a la Lista de Películas del Crítico.
     * @param pelicula PeliculaEntity, nueva Película del Crítico.
     */
    public void addPelicula(PeliculaEntity pelicula) {
        peliculas.add(pelicula);
    }
}