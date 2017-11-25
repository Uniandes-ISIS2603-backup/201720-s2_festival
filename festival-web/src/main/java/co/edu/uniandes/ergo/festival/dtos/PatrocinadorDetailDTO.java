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
    /**
     * Método constructor por defecto.
     */
    public PatrocinadorDetailDTO() {
        super();
    }
    /**
     * Método que contruye un PatrocinadorDetailDTO a partir de la versión entidad de Patrocinador.
     * @param entity PatrocinadorEntity, Entidad de Patrocinador.
     */
    public PatrocinadorDetailDTO(PatrocinadorEntity entity) {
        super(entity);
        
        if (entity.getFestival() != null)
            festival = new FestivalDTO(entity.getFestival());
    }
    /**
     * Método que construye un PatrocinadorEntity a partir de este DTO.
     * @return PatrocinadorEntity.
     */
    @Override
    public PatrocinadorEntity toEntity() {
        PatrocinadorEntity retornar = super.toEntity();
        
        if (getFestival() != null) {
            retornar.setFestival(getFestival().toEntity());
        }
        return retornar;
    }
    /**
     * Método que obtiene el Festival de este Patrocinador.
     * @return the festival
     */
    public FestivalDTO getFestival() {
        return festival;
    }
    /**
     * Método que establece el Festival de este Patrocinador.
     * @param festival the festival to set
     */
    public void setFestival(FestivalDTO festival) {
        this.festival = festival;
    }
}
