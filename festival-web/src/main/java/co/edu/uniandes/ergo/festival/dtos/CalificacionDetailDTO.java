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
public class CalificacionDetailDTO extends CalificacionDTO{
    /**
     * Atributo que contiene la Boleta Asociada.
     */
    private BoletaDTO boleta;
    /**
     * Método Constructor por Defecto.
     */
    public CalificacionDetailDTO(){
    }
    /**
     * Método que construye CalificacionDetailDTO a partir de su versión Entity.
     * @param createCalificacion 
     */
    public CalificacionDetailDTO(CalificacionEntity createCalificacion) {
        super(createCalificacion);
//        if(!(createCalificacion.getBoleta()==null)){
//            boleta = new BoletaDTO(createCalificacion.getBoleta());
//        }
//        else{
//            boleta = new BoletaDTO();
//        }
        
    }
    /**
     * Método que construye un objeto Entity a partir de este DTO.
     * @return CalificaciónEntity, Entidad de Calificación.
     */
    public CalificacionEntity toEntity() {
        CalificacionEntity entity = new CalificacionEntity();
        entity.setCalificacion(this.getCalificacion());
        entity.setComentario(this.getComentario());
        entity.setId(this.getId());
        entity.setName(this.getName());
       
        return entity;
        
    }
    /**
     * Método que obtiene la Boleta de esta Calificación.
     * @return 
     */
    public BoletaDTO getBoleta() {
        return boleta;
    }
    /**
     * Método que establece la Boleta asociada a esta Calificación.
     * @param boleta 
     */
    public void setBoleta(BoletaDTO boleta) {
        this.boleta = boleta;
    }
    
}
