/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 *
 * @author dj.bautista10
 */
@Entity
public class FuncionEntity extends BaseEntity implements Serializable{
    
    @Temporal(TemporalType.DATE)
    private Date horaInicio;
    
    @Temporal(TemporalType.DATE)
    private Date horaFin;
    
    @PodamExclude
    @OneToMany(mappedBy = "funcion", orphanRemoval = true)
    private List<BoletaEntity> boletas;

    @PodamExclude
    @OneToMany(orphanRemoval = true, mappedBy = "funcion")
    private List<CriticaEntity> criticas;
    
    @PodamExclude
    @ManyToOne
    private PeliculaEntity pelicula;
    
    @PodamExclude
    @ManyToOne
    private SalaEntity sala;
    
    @PodamExclude
    @ManyToOne
    private FestivalEntity festival;
    
    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }
    
    public List<BoletaEntity> getBoletas()
    {
        return boletas;
    }
    
    public void setBoletas(List<BoletaEntity> boletas)
    {
        this.boletas = boletas;
    }
    
    public List<CriticaEntity> getCriticas()
    {
        return criticas;
    }
    
    public void setCriticas(List<CriticaEntity> criticas)
    {
        this.criticas = criticas;
    }
    
    public PeliculaEntity getPelicula()
    {
        return pelicula;
    }
    
    public void setPelicula(PeliculaEntity pelicula)
    {
        this.pelicula = pelicula;
    }
    
    public SalaEntity getSala()
    {
        return sala;
    }
    
    public void setSala(SalaEntity sala)
    {
        this.sala = sala;
    }

    public FestivalEntity getFestival() {
        return festival;
    }

    public void setFestival(FestivalEntity festival) {
        this.festival = festival;
    }
}
