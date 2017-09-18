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
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param boleta: Es la entidad que se va a convertir a DTO
     */
    public BoletaDetailDTO(BoletaEntity boleta) {
        super(boleta);
    }

    @Override
    public BoletaEntity toEntity() {
        BoletaEntity entity = super.toEntity();

        return entity;

    }
}