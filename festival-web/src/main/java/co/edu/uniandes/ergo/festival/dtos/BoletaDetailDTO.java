/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
/**
 *
 * @author jc.corrales
 */
public class BoletaDetailDTO extends BoletaDTO {

    public BoletaDetailDTO() {
    }
    /**
     * Atributo que contiene el ID de la silla asociada;
     */
    private Long idSilla;
    /**
     * Atributo que contiene el ID de la función asociada.
     */
    private Long idFuncion;
    /**
     * Atributo que contiene el ID del espectador asociado.
     */
    private Long idEspectador;
    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param boleta: Es la entidad que se va a convertir a DTO
     */
    public BoletaDetailDTO(BoletaEntity boleta)
    {
        super(boleta);
        if (boleta.getSilla() != null)
        {
            this.idSilla = boleta.getSilla().getId();
        }
        else
        {
            this.idSilla = Long.parseLong("0");
        }
        if(boleta.getFuncion() != null)
        {
            this.idFuncion = boleta.getFuncion().getId();
        }
        else
        {
           this.idFuncion = Long.parseLong("0");
        }
    }

    public Long getIdSilla()
    {
        return this.idSilla;
    }
    
    public void setIdSilla(Long idSilla)
    {
        this.idSilla = idSilla;
    }
    public Long getIdFuncion()
    {
        return this.idFuncion;
    }
    public void setIdFuncion(Long idFuncion)
    {
        this.idFuncion = idFuncion;
    }
    
    public Long getIDEspectador()
    {
        return this.idEspectador;
    }
    
    public void setIdEspectador(Long idEspectador)
    {
        this.idEspectador= idEspectador;
    }
    
    @Override
    public BoletaEntity toEntity() {
        BoletaEntity entity = super.toEntity();

        return entity;

    }
}