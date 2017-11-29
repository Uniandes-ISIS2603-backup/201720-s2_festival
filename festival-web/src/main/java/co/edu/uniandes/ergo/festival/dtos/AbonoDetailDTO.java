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
    /**
     * Atributo que contiene la lista de Boletas.
     */
    private List<BoletaDTO> boletas;
    /**
     * Atributo que contiene el espectador dueño del Abono.
     */
    private EspectadorDTO espectador;
    /**
     * Método constructor vacío de AbonoDetailDTO, es necesario dejarlo vacío por razones de funcionalidad.
     */
    public AbonoDetailDTO() {
        //Método constructor por Defecto.
    }
        
    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param abono: Es la entidad que se va a convertir a DTO
     */
    public AbonoDetailDTO(AbonoEntity abono) {
        super(abono);
        List<BoletaEntity> boletasTemp = abono.getBoletas();
        this.boletas = listEntity2DetailDTO(boletasTemp);
        if(abono.getEspectador() != null)
        {
            this.espectador = new EspectadorDTO(abono.getEspectador());
        }
    }
    /**
     * Método que convierte a Entity.
     * @return 
     */
    @Override
    public AbonoEntity toEntity() {
        AbonoEntity entity = super.toEntity();
        if(espectador != null)
        {
            entity.setEspectador(espectador.toEntity());
        }
        if(boletas != null)
        {
            List <BoletaEntity> boletasEntity = new ArrayList<>();
            for(int i = 0; i < boletas.size(); i++)
            {
                boletasEntity.add(boletas.get(i).toEntity());
            }
            entity.setBoletas(boletasEntity);
        }
        return entity;
    }
    /**
     * Método que entrega las Boletas que pertenecen a este Abono.
     * @return List<BoletaDTO>, Boletas de este Abono.
     */
    public List<BoletaDTO> getBoletas()
    {
        return this.boletas;
    }
    /**
     * Método que establece las boletas de este Abono.
     * @param boletas List<BoletaDTO>, nuevas Boletas de este Abono.
     */
    public void setBoletas(List<BoletaDTO> boletas)
    {
        this.boletas = boletas;
    }
    /**
     * Método que devuelve el Espectador dueño de esta Boleta.
     * @return  EspectadorDTO, espectador dueño de este Abono.
     */
    public EspectadorDTO getEspectador()
    {
        return this.espectador;
    }
    /**
     * Método que establece el Espectador dueño de este Abono.
     * @param espectador EspectadorDTO
     */
    public void setEspectador(EspectadorDTO espectador)
    {
        this.espectador = espectador;
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
