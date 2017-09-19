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
    
    public PatrocinadorDetailDTO(PatrocinadorEntity entity) {
        super(entity);
        
        if (entity.getFestival() != null)
            festival = new FestivalDTO(entity.getFestival());
    }

    @Override
    public PatrocinadorEntity toEntity() {
        PatrocinadorEntity retornar = new PatrocinadorEntity();
        retornar.setId(super.getId());
        retornar.setNIT(super.getNIT());
        retornar.setName(super.getName());
        retornar.setPatrocinio(super.getPatrocinio());
        retornar.setFestival(festival.toEntity());
        return retornar;
    }
    
    /**
     * @return the festival
     */
    public FestivalDTO getFestival() {
        return festival;
    }
}
