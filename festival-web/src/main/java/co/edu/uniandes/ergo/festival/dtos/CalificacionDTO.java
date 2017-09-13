/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.CalificacionEntity;

/**
 *
 * @author m.neira10
 */
public class CalificacionDTO {
    private double calificacion;
    private String comentario;

    private Long id;

    private String name;


    public CalificacionDTO(){

    }
    public CalificacionDTO(CalificacionEntity entity){
        this.calificacion = entity.getCalificacion();
        this.comentario = entity.getComentario();
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
         
    public CalificacionEntity toEntity(){
        CalificacionEntity entity = new CalificacionEntity();
        entity.setCalificacion(calificacion);
        entity.setComentario(comentario);
        entity.setId(id);
        entity.setName(name);
        return entity;
    }
}
