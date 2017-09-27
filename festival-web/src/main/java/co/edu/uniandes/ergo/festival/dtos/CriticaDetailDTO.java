/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.CriticaEntity;

/**
 *
 * @author f.reyes948
 */
public class CriticaDetailDTO extends CriticaDTO {
    
    /**
     * Represetnación Minimum de la FuncionEntity asociada.
     */
    private FuncionDTO funcion;
    
    /**
     * Represetnación Minimum de la CriticoEntity asociada.
     */
    private CriticoDTO critico;
    
    /**
     * Constructor sin parámetros.
     */
    public CriticaDetailDTO(){
        
    }
    
    /**
     * Crea una CriticaDetailDTO a partir de la entidad.
     * @param entity La entidad CriticaEntity.
     */
    public CriticaDetailDTO(CriticaEntity entity){
        super(entity);
        if (entity.getFuncion() != null){
            funcion = new FuncionDTO(entity.getFuncion());
        }
        if (entity.getCritico() != null){
            critico = new CriticoDTO(entity.getCritico());  
        }
    }
    
    /**
     * Convierte la CriticaDetailDTO a un entity.
     * @return La CriticaEntity.
     */
    public CriticaEntity toEntity(){
        return super.toEntity();
    }

    /**
     * @return the funcion
     */
    public FuncionDTO getFuncion() {
        return funcion;
    }

    /**
     * @param funcion the funcion to set
     */
    public void setFuncion(FuncionDTO funcion) {
        this.funcion = funcion;
    }

    /**
     * @return the critico
     */
    public CriticoDTO getCritico() {
        return critico;
    }

    /**
     * @param critico the critico to set
     */
    public void setCritico(CriticoDTO critico) {
        this.critico = critico;
    }
}
