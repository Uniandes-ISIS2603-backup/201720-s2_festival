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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author dj.bautista10
 */
@Entity
public class FuncionEntity extends BaseEntity implements Serializable{
    
    private Date horaInicio;
    
    private Date horaFin;
    
    @PodamExclude
    @OneToMany(mappedBy="funcion")
    private List<BoletaEntity> boletas;

    @PodamExclude
    @OneToMany(mappedBy="funcion")
    private List<CríticaEntity> criticas;
    
    @PodamExclude
    @ManyToOne
    private PeliculaEntity pelicula;
    
    @PodamExclude
    @ManyToOne
    private SalaEntity sala;
    
    
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
    
    
    
    
}
