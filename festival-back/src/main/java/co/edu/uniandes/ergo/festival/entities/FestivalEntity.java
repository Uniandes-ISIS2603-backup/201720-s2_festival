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
import javax.persistence.Entity;

/**
 *
 * @author ISIS2603
 */
@Entity
public class FestivalEntity extends BaseEntity implements Serializable {
   private Long id;
   private String nombre;
   private Date fechaInicio;
   private Date fechaFin;
   private String patrocinador;

   /**
    * @return the id of festival
    */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 
     * @return the nombre of festival
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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

    /**
     * 
     * @return the patrocinador of festival
     */
    public String getPatrocinador() {
        return patrocinador;
    }

    /**
     * 
     * @param patrocinador the patrocinador to set
     */
    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }
   
}
