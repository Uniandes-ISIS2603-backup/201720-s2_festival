/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.PeliculaEntity;

/**
 *
 * @author dj.bautista10
 */
public class PeliculaDTO {
    /**
     * Atributo que contiene el ID del la Película.
     */
    private long id;
    /**
     * Atributo que contiene el Nombre de la Película.
     */
    private String nombre;
    /**
     * Atributo que contiene el Género de la Película.
     */
    private String genero;
    /**
     * Atributo que contiene la duración en minutos de la Película.
     */
    private int duracionMinutos;
    /**
     * Atributo que contiene el nombre del Director de la Película.
     */
    private String director;
    /**
     * Atributo que contiene la URL de la imagen de la Película.
     */
    private String imagen;
    /**
     * Atributo que contiene el nombre del País de Origen de la Película.
     */
    private String pais;
    /**
     * Atributo que contiene Datos adicionales de la Película.
     */
    private String datos;
    /**
     * Atributo que contiene el nombre del Corto de la Película.
     */
    private String corto;
    /**
     * Constructor por Defecto.
     */
    public PeliculaDTO() {

    }
    /**
     * Métoco constructor de la Película. Utiliza la versión entity para construir una PeliculaDTO.
     * @param pelicula PeliculaEntity, Entidad de la Película.
     */
    public PeliculaDTO(PeliculaEntity pelicula) {
        if (pelicula != null) {
            this.id = pelicula.getId();
            this.nombre = pelicula.getName();
            this.genero = pelicula.getGenero();
            this.duracionMinutos = pelicula.getDuracionMinutos();
            this.director = pelicula.getDirector();
            this.imagen = pelicula.getImagen();
            this.pais = pelicula.getPais();
            this.datos = pelicula.getDatos();
            this.corto = pelicula.getCorto();
        }
    }
    /**
     * Método que obtiene el ID de la Película.
     * @return Long, ID de la película.
     */
    public long getId() {
        return id;
    }
    /**
     * Método que obtiene el Nombre de la Película.
     * @return String, Nombre de la Película.
     */
    public String getname() {
        return nombre;
    }
    /**
     * Método que obtiene el género de la Película.
     * @return String, género de la Película.
     */
    public String getGenero() {
        return genero;
    }
    /**
     * Método que obtiene la duración en minutos de la Película.
     * @return int, duración en minutos de la Película.
     */
    public int getDuracionMinutos() {
        return duracionMinutos;
    }
    /**
     * Método que obtiene el nombre del Director de la Película.
     * @return String, nombre del Director de la Película.
     */
    public String getDirector() {
        return director;
    }
    /**
     * Método que obtiene la URL de la Imagen de la Película.
     * @return Stirng, URL de la Imagen de la Película.
     */
    public String getImagen() {
        return imagen;
    }
    /**
     * Metodo que obtiene el nombre del País de la Película.
     * @return String, nombre del país de la película.
     */
    public String getPais() {
        return pais;
    }
    /**
     * Método que obtiene el nombre del Corto de la Película.
     * @return String, nombre del corto de la película.
     */
    public String getCorto() {
        return corto;
    }
    /**
     * Método que obtiene datos adicionales de la Película.
     * @return String, Datos adicionales de la Película.
     */
    public String getDatos() {
        return datos;
    }
    /**
     * Método que establece el nombre de la Película.
     * @param nombre String, nuevo nombre de la Película.
     */
    public void setname(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Método que establece el ID de la Película.
     * @param id Long, nuevo ID de la Película.
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * Método que establece la duración en minutos de la Película.
     * @param duracionMinutos int, Nueva duración en minutos de la Película.
     */
    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }
    /**
     * Método que establece el nombre del Director de la Película.
     * @param director String, nuevo Nombre del Director de la Película.
     */
    public void setDirector(String director) {
        this.director = director;
    }
    /**
     * Método que establece la URL de la Imagen de la Película.
     * @param imagen String, nueva URL de la Imagen de la Película.
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    /**
     * Método que establece el nombre del País de la Película.
     * @param pais String, nuevo Nombre del País de la Película.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
    /**
     * Método que establece el nombre del Corto de la Película.
     * @param corto String, nuevo nombre de corto de la Película
     */
    public void setCorto(String corto) {
        this.corto = corto;
    }
    /**
     * Método que establece los datos adicionales de la Película.
     * @param datos String, nuevos datos adicionales de la Película.
     */
    public void setDatos(String datos) {
        this.datos = datos;
    }
    /**
     * Método que establece el género de la Película.
     * @param genero String, nuevo género de la Película.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
    /**
     * Método que construye una Entidad de Película a partir de este DTO.
     * @return PeliculaEntity, Entidad de Película.
     */
    public PeliculaEntity toEntity() {
        PeliculaEntity pelicula = new PeliculaEntity();
        pelicula.setId(this.id);
        pelicula.setName(this.nombre);
        pelicula.setGenero(this.genero);
        pelicula.setDuracionMinutos(this.duracionMinutos);
        pelicula.setDirector(this.director);
        pelicula.setImagen(this.imagen);
        pelicula.setPais(this.pais);
        pelicula.setCorto(this.corto);
        pelicula.setDatos(this.datos);

        return pelicula;
    }
}