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
public class BoletaDTO
{
        /**
     * Constante que representa que esta boleta está disponible.
     */
    public static final String DISPONIBLE="DISPONIBLE";
    /**
     * Constante que representa que esta boleta está reservada.
     */
    public static final String RESERVADA="RESERVADA";
    /**
     * Constate que representa que esta boleta está comprada.
     */
    public static final String COMPRADA="COMPRADA";
    /**
     * Atributo que contiene el ID.
     */
    private Long id;
    /**
     * Atributo que contiene el código de barras.
     */
    private Long codigoDeBarras;
    /**
     * Atributo que contiene el estado .
     */
    private String estado;
    /**
     * Atributo que contiene el precio.
     */
    private Double precio;
    /**
     * Constructor por defecto
     */
    public BoletaDTO()
    {
        //Método constructor por Defecto.
    }
     /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en la entidad que viene de argumento.
     * @param boleta: Es la entidad que se va a convertir a DTO 
     */
    public BoletaDTO(BoletaEntity boleta)
    {
        if(boleta != null)
        {
            this.id = boleta.getId();
            this.codigoDeBarras = boleta.getCodigoBarras();
            Integer estadoBoleta = boleta.getEstado();
            if(estadoBoleta.equals(BoletaEntity.DISPONIBLE))
            {
                this.estado = DISPONIBLE;
            }
            else if(estadoBoleta.equals(BoletaEntity.RESERVADA))
            {
                this.estado = RESERVADA;
            }
            else if(estadoBoleta.equals(BoletaEntity.COMPRADA))
            {
                this.estado = COMPRADA;
            }
            else
            {
                this.estado = DISPONIBLE;
            }
            this.precio = boleta.getPrecio();
        }
    }
    /**
     * Método que obtiene el ID.
     * @return Long, ID de la boleta.
     */
    public Long getId()
    {
        return id;
    }
    /**
     * Método que establece el ID.
     * @param id Long, ID nuevo.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Método que obtiene el código de barras.
     * @return Long, código de barras.
     */
    public Long getCodigoDeBarras()
    {
        return codigoDeBarras;
    }
    /**
     * Método que establece el código de barras de la boleta.
     * @param codigoDeBarras Long, nuevo código de barras.
     */
    public void setCodigoDeBarras(Long codigoDeBarras)
    {
        this.codigoDeBarras = codigoDeBarras;
    }
    /**
     * Método que obtiene el estado de la boleta.
     * @return String, estado de la boleta.
     */
    public String getEstado()
    {
        return estado;
    }
    /**
     * Método que establece el estado de la boleta.
     * @param estado 
     */
    public void setEstado(String estado)
    {
        this.estado = estado;
    }
    /**
     * Método que retorna el precio de esta boleta.
     * @return Double, precio.
     */
    public Double getPrecio()
    {
        return this.precio;
    }
    /**
     * Método que establece el precio de esta boleta.
     * @param precio Double, precio.
     */
    public void setPrecio(Double precio)
    {
        this.precio = precio;
    }
    /**
     * Convertir DTO a Entity.
     * @return BoletaEntity, un Entity con los valores del DTO.
     */
    public BoletaEntity toEntity()
    {
        BoletaEntity entity = new BoletaEntity();
        entity.setId(this.id);
        entity.setCodigoDeBarras(this.codigoDeBarras);
        if(estado.equals(DISPONIBLE))
        {
            entity.setEstado(BoletaEntity.DISPONIBLE);
        }
        else if(estado.equals(RESERVADA))
        {
             entity.setEstado(BoletaEntity.RESERVADA);
        }
        else if(estado.equals(COMPRADA))
        {
             entity.setEstado(BoletaEntity.COMPRADA);
        }
        else
        {
            entity.setEstado(BoletaEntity.DISPONIBLE);
        }
        entity.setPrecio(this.precio);
        return entity;
    }
    
}
