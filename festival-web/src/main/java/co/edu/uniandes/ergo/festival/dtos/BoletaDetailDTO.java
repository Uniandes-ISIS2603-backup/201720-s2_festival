/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.entities.SillaEntity;
import co.edu.uniandes.ergo.festival.entities.FuncionEntity;
import co.edu.uniandes.ergo.festival.entities.EspectadorEntity;
import co.edu.uniandes.ergo.festival.entities.CalificacionEntity;
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
    private SillaDTO silla;
    /**
     * Atributo que contiene el ID de la función asociada.
     */
    private FuncionDTO funcion;
    /**
     * Atributo que contiene el ID del espectador asociado.
     */
    private EspectadorDTO espectador;
    /**
     * Atributo que contiene el ID de la calificación asociada.
     */
    private CalificacionDTO calificacion;
    /**
     * Atributos que contienen
     */
    private AbonoDTO abono;
    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param boleta: Es la entidad que se va a convertir a DTO
     */
    public BoletaDetailDTO(BoletaEntity boleta)
    {
        super(boleta);
        this.silla = new SillaDTO(boleta.getSilla());
        this.funcion = new FuncionDTO(boleta.getFuncion());
        this.calificacion = new CalificacionDTO(boleta.getCalificacion());
        this.espectador = new EspectadorDTO(boleta.getEspectador());
        this.abono = new AbonoDTO(boleta.getAbono());        
    }

    public SillaDTO getSilla()
    {
        return this.silla;
    }
    
    public void setSilla(SillaDTO silla)
    {
        this.silla = silla;
    }
    public FuncionDTO getFuncion()
    {
        return this.funcion;
    }
    public void setFuncion(FuncionDTO funcion)
    {
        this.funcion = funcion;
    }
    
    public EspectadorDTO getEspectador()
    {
        return this.espectador;
    }
    
    public void setEspectador(EspectadorDTO espectador)
    {
        this.espectador= espectador;
    }
    public CalificacionDTO getCalificacion()
    {
        return this.calificacion;
    }
    public void setCalificacion(CalificacionDTO calificacion)
    {
        this.calificacion = calificacion;
    }
    public AbonoDTO getAbono()
    {
        return this.abono;
    }
    public void setAbono(AbonoDTO abono)
    {
        this.abono = abono;
    }
    @Override
    public BoletaEntity toEntity() {
        BoletaEntity entity = super.toEntity();
        if(abono != null)
        {
            entity.setAbono(abono.toEntity());
        }
        if(calificacion != null)
        {
            entity.setCalificacion(calificacion.toEntity());
        }
        if(espectador != null)
        {
            entity.setEspectador(espectador.toEntity());
        }
        if(funcion != null)
        {
            entity.setFuncion(funcion.toEntity());
        }
        if(silla != null)
        {
            entity.setSilla(silla.toEntity());
        }
        //entity.setFuncion(tempFuncion);
        return entity;

    }
}