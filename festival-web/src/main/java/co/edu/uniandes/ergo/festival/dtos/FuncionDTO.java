/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.FuncionEntity;
import java.util.Date;

/**
 *
 * @author m.neira10
 */
public class FuncionDTO {
    /**
     * Atributo que contiene la hora de Inicio de esta Funcion.
     */
    private Date horaInicio;
    /**
     * Atributo que contiene la hora de terminación de esta Función.
     */
    private Date horaFin;
    /**
     * Atributo que contiene el ID de esta Función.
     */
    private Long id;
    /**
     * Atributo que contiene el Nombre de esta Función.
     */
    private String name;
    /**
     * Método que construye una FuncionDTO a partir de su versión Entity.
     * @param entity 
     */
    public FuncionDTO(FuncionEntity entity) {
        if(entity != null)
        {
            this.horaInicio = entity.getHoraInicio();
            this.horaFin = entity.getHoraFin();
            this.id = entity.getId();
            this.name = entity.getName();
        }
    }
    /**
     * Método constructor por Defecto.
     */
    public FuncionDTO(){
        //Método constructor por Defecto.
    }
    /**
     * Método que obtiene la hora de inicio de esta Función.
     * @return Date, fecha de inicio de la Función.
     */
    public Date getHoraInicio() {
        return horaInicio;
    }
    /**
     * Método que establece la hora de Inicio de esta Función.
     * @param horaInicio Date, nueva fecha de inicio de la Función.
     */
    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }
    /**
     * Método que obtiene la hora de Terminación de esta Función.
     * @return Date, fecha de Terminación de la Función.
     */
    public Date getHoraFin() {
        return horaFin;
    }
    /**
     * Método que establece la hora de Terminación de esta Función.
     * @param horaFin Date, fecha de Terminación de la Función.
     */
    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }
    /**
     * Método que obtiene el ID de esta Función.
     * @return Long, ID de la Función.
     */
    public Long getId() {
        return id;
    }
    /**
     * Método que establece el ID de esta Función.
     * @param id Long, nuevo ID de la Función.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Método que obtiene el Nombre de esta Función.
     * @return String, Nombre de la Función.
     */
    public String getName() {
        return name;
    }
    /**
     * Método que establece el Nombre de esta Función.
     * @param name String, nuevo Nombre de la Función.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Método que construye una FuncionEntity a partir de este DTO.
     * @return FuncionEntity. Entidad de la Función.
     */
    public FuncionEntity toEntity(){
        FuncionEntity entity = new FuncionEntity();
        if(horaInicio != null)
            entity.setHoraInicio(horaInicio);
        if(horaFin != null)
            entity.setHoraFin(horaFin);
        if(id != null)
            entity.setId(id);
        if(name != null)
            entity.setName(name);
        
        return entity;
    }
}
