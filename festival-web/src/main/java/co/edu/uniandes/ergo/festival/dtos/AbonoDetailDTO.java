/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.AbonoEntity;
import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jc.corrales
 */
public class AbonoDetailDTO extends AbonoDTO
{
    
    private List<BoletaDTO> boletas;
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
        List<BoletaEntity> boletas = abono.getBoletas();
        this.boletas = listEntity2DetailDTO(boletas);
    }

    @Override
    public AbonoEntity toEntity() {
        AbonoEntity entity = super.toEntity();
        
        return entity;

    }
    public List<BoletaDTO> getBoletas()
    {
        return this.boletas;
    }
    public void setBoletas(List<BoletaDTO> boletas)
    {
        this.boletas = boletas;
    }
    
         /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos BoletaEntity a una lista de
     * objetos BoletaDetailDTO (json)
     *
     * @param entityList corresponde a la lista de boletas de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de boletas en forma DTO (json)
     */
    private List<BoletaDTO> listEntity2DetailDTO(List<BoletaEntity> entityList) {
        List<BoletaDTO> list = new ArrayList<>();
        for (BoletaEntity entity : entityList) {
            list.add(new BoletaDetailDTO(entity));
        }
        return list;
    }
}
