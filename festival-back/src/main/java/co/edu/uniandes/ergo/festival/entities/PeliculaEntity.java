/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.entities;

import java.io.Serializable;
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
public class PeliculaEntity extends BaseEntity implements Serializable {
    /**
     * Atributo que contiene el Género de la Película.
     */
    private String genero;
    private int duracionMinutos;
    private String director;
    private String imagen;
    private String pais;
    private String datos;
    private String corto;

    @PodamExclude
    @OneToMany(mappedBy = "pelicula")
    private List<FuncionEntity> funciones;

    @PodamExclude
    @ManyToMany
    private List<CriticoEntity> criticos;

    public List<FuncionEntity> getFunciones() {
        return funciones;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public String getDirector() {
        return director;
    }

    public String getImagen() {
        return imagen;
    }

    public String getPais() {
        return pais;
    }

    public String getCorto() {
        return corto;
    }

    public String getDatos() {
        return datos;
    }

    public List<CriticoEntity> getCriticos() {
        return criticos;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCorto(String corto) {
        this.corto = corto;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public void setFunciones(List<FuncionEntity> funciones) {
        this.funciones = funciones;
    }

    public void addFuncion(FuncionEntity funcion) {
        funciones.add(funcion);
    }

    public void setCriticos(List<CriticoEntity> criticos) {
        this.criticos = criticos;
    }

    public void addCritico(CriticoEntity critico) {
        criticos.add(critico);
    }

    public void removeCritico(CriticoEntity critico) {
        criticos.remove(critico);
    }
}
