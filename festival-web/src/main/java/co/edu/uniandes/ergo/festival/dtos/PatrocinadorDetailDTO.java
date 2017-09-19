/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.PatrocinadorEntity;

/**
 *
 * @author f.mayenberger10
 */
public class PatrocinadorDetailDTO extends PatrocinadorDTO {
    private FestivalDTO festival;
    
    public PatrocinadorDetailDTO() {
        super();
    }
    
    public PatrocinadorDetailDTO(PatrocinadorEntity entity) {
        super(entity);
        
        if (entity.getFestival() != null)
            festival = new FestivalDTO(entity.getFestival());
    }

    @Override
    public PatrocinadorEntity toEntity() {
        PatrocinadorEntity retornar = super.toEntity();
        
        if (getFestival() != null) {
            retornar.setFestival(getFestival().toEntity());
        }
        return retornar;
    }
    
    /**
     * @return the festival
     */
    public FestivalDTO getFestival() {
        return festival;
    }

    /**
     * @param festival the festival to set
     */
    public void setFestival(FestivalDTO festival) {
        this.festival = festival;
    }
}
