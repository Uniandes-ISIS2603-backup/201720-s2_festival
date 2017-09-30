/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author dj.bautista10
 */
@Entity
public class PeliculaEntity extends BaseEntity implements Serializable {

    private String genero;
    private int duracionMinutos;
    private String director;
    private int creditos;
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

    public int getCreditos() {
        return creditos;
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

    public void setCreditos(int creditos) {
        this.creditos = creditos;
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
