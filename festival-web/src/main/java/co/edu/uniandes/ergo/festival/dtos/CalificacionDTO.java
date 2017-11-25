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
    /**
     * Atributo que contiene el Valor de la Calificación.
     */
    private Double calificacion;
    /**
     * Atributo que contiene el Comentario de la Calificación.
     */
    private String comentario;
    /**
     * Atributo que contiene el ID de la Calificación.
     */
    private Long id;
    /**
     * Atributo que contiene el Nombre de la Calificación.
     */
    private String name;
    /**
     * Método contructor por Defecto.
     */
    public CalificacionDTO(){

    }
    /**
     * Método que construye una CalificacionDTO a partir de su versión Entidad.
     * @param entity CalificacionEntity, Entidad de Calificacion.
     */
    public CalificacionDTO(CalificacionEntity entity){
        if(entity != null)
        {
            this.calificacion = entity.getCalificacion();
            this.comentario = entity.getComentario();
            this.id = entity.getId();
            this.name = entity.getName();
        }
    }
    /**
     * Método que obtiene el Valor de la Calificación.
     * @return Double, Valor de la Calificación.
     */
    public Double getCalificacion() {
        return calificacion;
    }
    /**
     * Método que establece el Valor de la Calificación.
     * @param calificacion Double, nuevo Valor de la Calificación.
     */
    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }
    /**
     * Método que obtiene el Comentario de la Calificación.
     * @return String, Comentario de la Calificación.
     */
    public String getComentario() {
        return comentario;
    }
    /**
     * Método que establece el Comentario de la Calificación.
     * @param comentario String, nuevo Comentario de la Calificación.
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    /**
     * Método que obtiene el ID de la Calificación.
     * @return Long, ID de la Calificación.
     */
    public Long getId() {
        return id;
    }
    /**
     * Método que establece el ID de la Calificación.
     * @param id Long, nuevo ID de la Calificación.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Método que establece el Nombre de la Calificación.
     * @return String, Nombre de la Calificación.
     */
    public String getName() {
        return name;
    }
    /**
     * Método que establece el Nombre de la Calificación.
     * @param name String, nuevo Nombre de la Calificación.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Método que crea un objeto CalificacionEntity a partir de este DTO.
     * @return CalificacionEntity, Entidad de la Calificación.
     */
    public CalificacionEntity toEntity(){
        CalificacionEntity entity = new CalificacionEntity();
        if(calificacion != null)
            entity.setCalificacion(calificacion);
        if(comentario != null)
            entity.setComentario(comentario);
        if(id != null)
            entity.setId(id);
        if(name != null)
            entity.setName(name);
        return entity;
    }
}
