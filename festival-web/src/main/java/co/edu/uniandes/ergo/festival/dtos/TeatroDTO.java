/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.TeatroEntity;

/**
 *
 * @author de.gutierrez
 */
public class TeatroDTO
{    
    /**
     * Atributo que contiene el ID del Teatro.
     */
    private Long id;
    /**
     * Atributo que contiene el nombre del Teatro.
     */
    private String nombre;
    /**
     * Atributo que contiene la tarifa básica del Teatro.
     */
    private Double tarifaBasica; 
    /**
     * Constructor vacío para JAX-RS.
     */
    public TeatroDTO(){
        //Método constructor por Defecto.
    }
    /**
     * Método que construye un TeatroDTO a partir de la versión Entity.
     * @param teatro TeatroEntity, Entidad del Teatro.
     */
    public TeatroDTO(TeatroEntity teatro)
    {
        this.id = teatro.getId();
        this.nombre = teatro.getName();
        this.tarifaBasica = teatro.getTarifaBasica();
    }
    /**
     * Método que obtiene el ID del Teatro.
     * @return Long, ID del Teatro.
     */
    public Long getId() {
        return id;
    }
    /**
     * Método que establece el ID del Teatro.
     * @param id Long, nuevo ID del Teatro.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Método que obtiene el Nombre del Teatro.
     * @return String, nombre del Teatro.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método que establece el nombre del Teatro.
     * @param nombre String, nuevo nombre del Teatro.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo que obtiene la Tarifa Básica del Teatro.
     * @return Double, Tarifa Básica del Teatro.
     */
    public Double getTarifaBasica() {
        return tarifaBasica;
    }
    /**
     * Método que establece la Tarifa Básica del Teatro.
     * @param tarifaBasica Double, Tarifa Básica del Teatro.
     */
    public void setTarifaBasica(Double tarifaBasica) {
        this.tarifaBasica = tarifaBasica;
    }
    /**
     * Método que convierte este Teatro a su versión Entidad.
     * @return TeatroEntity, Entidad del Teatro.
     */
    public TeatroEntity toEntity()
    {
        TeatroEntity entity = new TeatroEntity();
        entity.setId(this.id);
        entity.setName(this.nombre);
        entity.setTarifaBasica(tarifaBasica);
        return entity;
    }
}
