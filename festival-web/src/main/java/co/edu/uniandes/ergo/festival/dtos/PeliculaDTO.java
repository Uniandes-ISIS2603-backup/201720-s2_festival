/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.PeliculaEntity;
import java.util.List;

/**
 *
 * @author dj.bautista10
 */
public class PeliculaDTO {

    private long id;
    private String nombre;
    private List<String> generos;
    private int duracionMinutos;
    private String director;
    private int creditos;
    private String pais;
    private String datos;
    private String corto;

    public PeliculaDTO() {

    }

    public PeliculaDTO(PeliculaEntity pelicula) {
        if (pelicula != null) {
            this.id = pelicula.getId();
            this.nombre = pelicula.getName();
            this.generos = pelicula.getGeneros();
            this.duracionMinutos = pelicula.getDuracionMinutos();
            this.director = pelicula.getDirector();
            this.creditos = pelicula.getCreditos();
            this.pais = pelicula.getPais();
            this.datos = pelicula.getDatos();
            this.corto = pelicula.getCorto();
        }
    }

    public long getId() {
        return id;
    }

    public String getname() {
        return nombre;
    }

    public List<String> getGeneros() {
        return generos;
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

    public void setname(String nombre) {
        this.nombre = nombre;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setGenero(String genero) {
        generos.add(genero);
    }

    public void deleteGenero(int position) {
        generos.remove(position);
    }

    public void modifyGenero(int position, String genero) {
        generos.set(position, genero);
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

    public PeliculaEntity toEntity() {

        PeliculaEntity pelicula = new PeliculaEntity();
        pelicula.setId(this.id);
        pelicula.setName(this.nombre);
        pelicula.setGeneros(this.generos);
        pelicula.setDuracionMinutos(this.duracionMinutos);
        pelicula.setDirector(this.director);
        pelicula.setCreditos(this.creditos);
        pelicula.setPais(this.pais);
        pelicula.setCorto(this.corto);
        pelicula.setDatos(this.datos);

        return pelicula;
    }

}
