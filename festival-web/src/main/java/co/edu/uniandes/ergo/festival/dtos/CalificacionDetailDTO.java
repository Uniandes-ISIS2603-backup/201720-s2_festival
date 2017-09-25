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

    private BoletaDTO boleta;
    
    public CalificacionDetailDTO(){
    }
    public CalificacionDetailDTO(CalificacionEntity createCalificacion) {
        super(createCalificacion);
        if(!(createCalificacion.getBoleta()==null)){
            boleta = new BoletaDTO(createCalificacion.getBoleta());
        }
        else{
            boleta = new BoletaDTO();
        }
        
    }

    public CalificacionEntity toEntity() {
        CalificacionEntity entity = new CalificacionEntity();
        entity.setCalificacion(this.getCalificacion());
        entity.setComentario(this.getComentario());
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setBoleta(boleta.toEntity());
        return entity;
        
    }

    public BoletaDTO getBoleta() {
        return boleta;
    }

    public void setBoleta(BoletaDTO boleta) {
        this.boleta = boleta;
    }
    
}
