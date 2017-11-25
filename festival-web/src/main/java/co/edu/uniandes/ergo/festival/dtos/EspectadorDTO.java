/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.EspectadorEntity;

/**
 *
 * @author dj.bautista10
 */
public class EspectadorDTO {
    /**
     * Atributo que contiene el ID del Espectdor.
     */
    private Long id;
    /**
     * Atributo que contiene el Nombre del Espectador.
     */
    private String nombre;
    /**
     * Atributo que contiene la Dirección del Espectador.
     */
    private String direccion;
    /**
     * Método constructor por defecto.
     */
    public EspectadorDTO() {

    }
    /**
     * Método que construye un EspectadorDTO a partir de su versión Entidad.
     * @param espec EspectadorEntity, Entidad del Espectador.
     */
    public EspectadorDTO(EspectadorEntity espec) {
        if (espec != null) {

            System.out.println("-------------------------------------------------------> " + espec.getName());
            this.id = espec.getId();
            this.nombre = espec.getName();
            System.out.println("direccion -------------------------------------------------------> " + espec.getDireccion());
            this.direccion = espec.getDireccion();
        }
    }
    /**
     * Método que obtiene el ID del Espectador.
     * @return Long, ID del Espectador.
     */
    public Long getId() {
        return id;
    }
    /**
     * Método que obtiene el Nombre del Espectador.
     * @return String, nombre del Espectador.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método que obtiene la Dirección de un Espectador.
     * @return String, Dirección de un Espectador.
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * Método que establece el ID del Espectador.
     * @param id Long, nuevo ID del Espectador.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Método que establece el Nombre del Espectador.
     * @param nombre String, nuevo Nombre del Espectador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Método que establece la Dirección del Espectador.
     * @param direccion String, nueva Dirección del Espectador.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Método que construye un objeto EspectadorEntity a partir de este DTO.
     * @return 
     */
    public EspectadorEntity toEntity() {
        EspectadorEntity entEsp = new EspectadorEntity();
        if (id != null) {
            entEsp.setId(this.id);
        }
        if (nombre != null) {
            entEsp.setName(this.nombre);
        }
        if (direccion != null) {
            entEsp.setDireccion(this.direccion);
        }
        return entEsp;
    }
}
