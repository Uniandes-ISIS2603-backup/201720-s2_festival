/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.AbonoEntity;
/**
 *
 * @author jc.corrales
 */
public class AbonoDetailDTO extends AbonoDTO
{
    public AbonoDetailDTO() {
    }
        
    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param abono: Es la entidad que se va a convertir a DTO
     */
    public AbonoDetailDTO(AbonoEntity abono) {
        super(abono);
    }

    @Override
    public AbonoEntity toEntity() {
        AbonoEntity entity = super.toEntity();

        return entity;

    }
}
