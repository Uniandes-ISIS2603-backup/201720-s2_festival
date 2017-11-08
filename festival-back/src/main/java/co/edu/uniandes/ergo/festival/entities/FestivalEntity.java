/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.ergo.festival.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ISIS2603
 */
@Entity
public class FestivalEntity extends BaseEntity implements Serializable {
   
    @Temporal(TemporalType.DATE)
   private Date fechaInicio;
   @Temporal(TemporalType.DATE)
   private Date fechaFin;
   
   @PodamExclude
   @OneToMany(mappedBy="festival")
   private List<PatrocinadorEntity>patrocinadores;
   @PodamExclude
   @OneToMany(mappedBy="festival")
   private List<TeatroEntity> teatros;
   @PodamExclude
   @OneToMany
   private List<PeliculaEntity> peliculas;
   @PodamExclude
   @OneToMany
   private List<EspectadorEntity> espectadores;
   @PodamExclude
   @OneToMany
   private List<CriticoEntity> criticos;
   @PodamExclude
   @OneToMany(mappedBy="festival")
   private List<FuncionEntity> funciones;
   
   
     /**
     * 
     * @return the fechaInicio of festival
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * 
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * 
     * @return the fechaFin of festival
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * 
     * @param fechaFin the festivalFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<TeatroEntity> getTeatros() {
        return teatros;
    }

    public void setTeatros(List<TeatroEntity> teatro) {
        this.teatros = teatro;
    }

    public List<PeliculaEntity> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<PeliculaEntity> peliculas) {
        this.peliculas = peliculas;
    }

    public List<EspectadorEntity> getEspectadores() {
        return espectadores;
    }

    public void setEspectadores(List<EspectadorEntity> espectadores) {
        this.espectadores = espectadores;
    }

    public List<CriticoEntity> getCriticos() {
        return criticos;
    }

    public void setCriticos(List<CriticoEntity> criticos) {
        this.criticos = criticos;
    }

    public List<PatrocinadorEntity> getPatrocinadores() {
        return patrocinadores;
    }

    public void setPatrocinadores(List<PatrocinadorEntity> patrocinador) {
        this.patrocinadores = patrocinador;
    }

    public List<TeatroEntity> getTeatro() {
        return teatros;
    }

    public void setTeatro(List<TeatroEntity> teatro) {
        this.teatros = teatro;
    }

    public List<FuncionEntity> getFunciones() {
        return funciones;
    }

    public void setFunciones(List<FuncionEntity> funcion) {
        this.funciones = funcion;
    }
   
}
