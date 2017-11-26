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
    /**
     * Atributo que contiene la duración en minutos de la Función.
     */
    private int duracionMinutos;
    /**
     * Atributo que contiene el Nombre del Directos de la Película.
     */
    private String director;
    /**
     * Atributo que contiene el Nombre de la URL de la Imagen de la Película.
     */
    private String imagen;
    /**
     * Atributo que contiene el nombre del País de la Película.
     */
    private String pais;
    /**
     * Atributo que contiene datos adicionales.
     */
    private String datos;
    /**
     * Atributo que contiene el nombre del Corto de la Película.
     */
    private String corto;
    /**
     * Atributo que contiene la Lista de Funciones que presentan esta Película.
     */
    /**
     * Atributo que contiene la Sinopsis de la Película.
     */
    private String sinopsis;
    @PodamExclude
    @OneToMany(mappedBy = "pelicula")
    private List<FuncionEntity> funciones;
    /**
     * Atributo que contiene la Lista de Críticos de esta Película.
     */
    @PodamExclude
    @ManyToMany
    private List<CriticoEntity> criticos;
    /**
     * Método que obtiene las Funciones que presentan esta Película.
     * @return List<FuncionEntity>, Lista de Funciones que presentan esta Película.
     */
    public List<FuncionEntity> getFunciones() {
        return funciones;
    }
    /**
     * Método que obtiene el género de esta Película.
     * @return String, Género de la Película.
     */
    public String getGenero() {
        return genero;
    }
    /**
     * Método que obtiene la Duración en Minutos de la Película.
     * @return int, Duración en minutos de la Película.
     */
    public int getDuracionMinutos() {
        return duracionMinutos;
    }
    /**
     * Mëtodo que obtiene el nombre del Director de la Película.
     * @return String, NOmbre del Director de la Película.
     */
    public String getDirector() {
        return director;
    }
    /**
     * Método que obtiene la URL de la Imagen de la Película.
     * @return String, URL de la Imagen de la Película.
     */
    public String getImagen() {
        return imagen;
    }
    /**
     * Método que obtiene el Nombre del País de la Película.
     * @return String, Nombre del País de la Película.
     */
    public String getPais() {
        return pais;
    }
    /**
     * Método que obtiene el Nombre del Corto de la Películ.a
     * @return String, Nombre del Corto de la Película.
     */
    public String getCorto() {
        return corto;
    }
    /**
     * Método que obtiene Datos Adicionales.
     * @return String.
     */
    public String getDatos() {
        return datos;
    }
    /**
     * Método que obtiene la Lista de Críticos de la Película.
     * @return List<CriticoEntity>, Lista de Críticos de la Película.
     */
    public List<CriticoEntity> getCriticos() {
        return criticos;
    }
    /**
     * Método que establece el género de la Película.
     * @param genero String, nuevo Género de la Película.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
    /**
     * Método que establece la Duración en Minutos de la Película.
     * @param duracionMinutos 
     */
    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }
    /**
     * Método que establece el Nombre del Director de la Película.
     * @param director String, nuevo nombre del Director de la Película.
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
     * Método que establece el Nombre del País de Origen de la Película.
     * @param pais String, nuevo nombre del País de la Película.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
    /**
     * Método que establece el Nombre del Corto de la Película.
     * @param corto String, nuevo Nombre del Corto de la Película.
     */
    public void setCorto(String corto) {
        this.corto = corto;
    }
    /**
     * Método que establece datos adicionales.
     * @param datos String
     */
    public void setDatos(String datos) {
        this.datos = datos;
    }
    /**
     * Método que establece las Funciones que presentan la Película.
     * @param funciones List<FuncionEntity>, Nueva lista de Funciones de la Película.
     */
    public void setFunciones(List<FuncionEntity> funciones) {
        this.funciones = funciones;
    }
    /**
     * Método que agrega una Función a la Película.
     * @param funcion FuncionEntity, nueva Función de la Película.
     */
    public void addFuncion(FuncionEntity funcion) {
        funciones.add(funcion);
    }
    /**
     * Método que establece los críticos de la Película.
     * @param criticos List<CriticoEntity>, nueva Lista de Críticos de la Película.
     */
    public void setCriticos(List<CriticoEntity> criticos) {
        this.criticos = criticos;
    }
    /**
     * Método que agrega un Crítico a la Película.
     * @param critico CriticoEntity, nuevo Crítico de la Película.
     */
    public void addCritico(CriticoEntity critico) {
        criticos.add(critico);
    }
    /**
     * Método que Remueve un Crítico de la Película.
     * @param critico CriticoEntity, información del Crítico a remover.
     */
    public void removeCritico(CriticoEntity critico) {
        criticos.remove(critico);
    }
    /**
     * Método que obtiene la Sinopsis de una Película.
     * @return String, Sinopsis de la Película.
     */
    public String getSinopsis()
    {
        return sinopsis;
    }
    /**
     * Método que establece la Sinopsis de una Película.
     * @param sinopsis String, nueva Sinopsis de la Película.
     */
    public void setSinopsis(String sinopsis)
    {
        this.sinopsis = sinopsis;
    }
}
