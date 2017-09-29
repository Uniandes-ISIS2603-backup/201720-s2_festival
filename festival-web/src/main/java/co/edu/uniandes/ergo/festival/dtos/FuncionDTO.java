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
    private Date horaInicio;
    
    private Date horaFin;
    
    private Long id;
    
    private String name;

    public FuncionDTO(FuncionEntity entity) {
        if(entity != null)
        {
            this.horaInicio = entity.getHoraInicio();
            this.horaFin = entity.getHoraFin();
            this.id = entity.getId();
            this.name = entity.getName();
        }
    }
    
    public FuncionDTO(){
        
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
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
