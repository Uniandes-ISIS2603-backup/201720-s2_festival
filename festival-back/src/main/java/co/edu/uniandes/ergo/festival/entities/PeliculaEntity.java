/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;

/**
 *
 * @author dj.bautista10
 */
@Entity
public class PeliculaEntity extends BaseEntity implements Serializable {
    private String nombre;
    private ArrayList<String> generos;
    private int duracionMinutos;
    private String director;
    private int creditos;
    private String pais;
    private String datos;
    private String corto;
    //private Critico critico;
    
    
    public String getNombre(){
        return nombre;
    }
    
    public ArrayList<String> getGeneros(){
        return generos;
    }
    
    public int getDuracionMinutos(){
        return duracionMinutos;
    }
    
    public String getDirector(){
        return director;
    }
    
    public int getCreditos(){
        return creditos;
    }
    
    public String getPais(){
        return pais;
    }
    
    public String getCorto(){
        return corto;
    }
    
    public String getDatos(){
        return datos;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setGenero(String genero){
        generos.add(genero);
    }
    
    public void deleteGenero(int position){
        generos.remove(position);
    }
    
    public void modifyGenero(int position, String genero){
        generos.set(position, genero);
    }
    
    public void setDuracionMinutos(int duracionMinutos){
        this.duracionMinutos = duracionMinutos;
    }
    
    public void setDirector(String director){
        this.director = director;
    }
    
    public void setCreditos(int creditos){
        this.creditos = creditos;
    }
    
    public void setPais(String pais){
        this.pais = pais;
    }
    
    public void setCorto(String corto){
        this.corto = corto;
    }
    
    public void setDatos(String datos){
        this.datos = datos;
    }
    
    public void setGeneros(ArrayList<String> generos){
        this.generos = generos;
    }
}