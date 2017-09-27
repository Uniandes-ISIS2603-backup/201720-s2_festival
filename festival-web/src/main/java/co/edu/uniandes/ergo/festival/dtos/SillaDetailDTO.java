/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.entities.SillaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author f.reyes948
 */
public class SillaDetailDTO extends SillaDTO {
    
    /**
     * Representación Minimum de las BoletasEntity asociadas.
     */
    private List<BoletaDTO> boletas;
    
    /**
     * Represetnación Minimum de la SalaEntity asociada.
     */
    private SalaDTO sala;
    
    /**
     * Constructor sin parámetros.
     */
    public SillaDetailDTO(){
        
    }
    
    /**
     * Crea una SillaDetailDTO a partir de la entidad.
     * @param entity La entidad SillaEntity.
     */
    public SillaDetailDTO(SillaEntity entity){
        super(entity);
        if (!(entity.getBoletas() == null || entity.getBoletas().isEmpty())){
            boletas = listBoletas2DTO(entity);
        }
        if (!(entity.getSala() == null)){
            sala = new SalaDTO(entity.getSala());
        }       
    }

    /**
     * @return the boletas
     */
    public List<BoletaDTO> getBoletas() {
        return boletas;
    }

    /**
     * @param boletas the boletas to set
     */
    public void setBoletas(List<BoletaDTO> boletas) {
        this.boletas = boletas;
    }

    /**
     * @return the sala
     */
    public SalaDTO getSala() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(SalaDTO sala) {
        this.sala = sala;
    }
    
    /**
     * Convierte las BoletaEntity de una SillaEntity en DTO.
     * @param entity La SillaEntity.
     * @return Una lista con las BoletaEntity en Representación Minimum.
     */
    private List<BoletaDTO> listBoletas2DTO(SillaEntity entity){
        List<BoletaDTO> resp = new ArrayList();
        for (BoletaEntity boleta : entity.getBoletas()){
            resp.add(new BoletaDTO(boleta));
        }
        return resp;
    }
    
    /**
     * Convierte una SillaEntity en Representación Detail a una SillaEntity.
     * @return La SillaEntity.
     */
    public SillaEntity toEntity(){
        SillaEntity entity = super.toEntity();
        entity.setSala(sala.toEntity());
        entity.setBoletas(listDTO2Boletas());
        return entity;
    }
    
    /**
     * Convierte las BoletaDTO de una SillaDetailDTO en BoletaEntity.
     * @param entity La SillaEntity.
     * @return Una lista con las BoletaEntity.
     */
    private List<BoletaEntity> listDTO2Boletas(){
        List<BoletaEntity> resp = new ArrayList();
        if (boletas != null){
            for (BoletaDTO boleta : boletas){
                resp.add(boleta.toEntity());
            }
        }
        return resp;
    }
}
