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
    /**
     * Método que obtiene la Silla asociada a esta boleta.
     * @return SillaDTO, Silla asociada a esta Boleta.
     */
    public SillaDTO getSilla()
    {
        return this.silla;
    }
    /**
     * Método que establece la Silla asociada a esta Boleta.
     * @param silla SillaDTO, nueva Silla asociada a esta Boleta.
     */
    public void setSilla(SillaDTO silla)
    {
        this.silla = silla;
    }
    /**
     * Método que obtiene la función asociada a esta Boleta.
     * @return FuncionDTO, Función asociada a esta Boleta.
     */
    public FuncionDTO getFuncion()
    {
        return this.funcion;
    }
    /**
     * Método que establece la Función asociada a esta Boleta.
     * @param funcion FuncionDTO, nueva Función asociada a esta Boleta.
     */
    public void setFuncion(FuncionDTO funcion)
    {
        this.funcion = funcion;
    }
    /**
     * Método que obtiene el Espectador asociado a esta Boleta.
     * @return EspectadorDTO, Espectador asociado a esta Boleta.
     */
    public EspectadorDTO getEspectador()
    {
        return this.espectador;
    }
    /**
     * Método que establece el Espectador asociado a esta Boleta.
     * @param espectador EspectadorDTO, nuevo Espectador asociado a esta Boleta.
     */
    public void setEspectador(EspectadorDTO espectador)
    {
        this.espectador= espectador;
    }
    /**
     * Método que obtiene la Calificación asociada a esta Boleta.
     * @return CalificacionDTO, Calificación asociada a esta Boleta.
     */
    public CalificacionDTO getCalificacion()
    {
        return this.calificacion;
    }
    /**
     * Método que establece la Calificación asociada a esta Boleta.
     * @param calificacion CalificacionDTO, nueva Calificación asociada a esta Boleta.
     */
    public void setCalificacion(CalificacionDTO calificacion)
    {
        this.calificacion = calificacion;
    }
    /**
     * Método que obtiene el Abono asociado a esta Boleta.
     * @return AbonoDTO, Abono asociado a esta Boleta.
     */
    public AbonoDTO getAbono()
    {
        return this.abono;
    }
    /**
     * Método que establece el Abono asociado a esta Boleta.
     * Nota: El Abono nuevo debe contener a esta Boleta.
     * @param abono AbonoDTO, nuevo Abono asociado a esta boleta.
     */
    public void setAbono(AbonoDTO abono)
    {
        this.abono = abono;
    }
    /**
     * Convertir DTO a Entity.
     * @return BoletaEntity, un Entity con los valores del DTO.
     */
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