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
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.FestivalEntity;
import java.util.Date;

/**
 * FestivalDTO Objeto de transferencia de datos de Festivales. Los DTO
 * contienen las represnetaciones de los JSON que se transfieren entre el
 * cliente y el servidor.
 *
 * @author ISIS2603
 */
public class FestivalDTO {

    private Long id;

    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private String patrocinador;
    /**
     * Constructor por defecto
     */
    public FestivalDTO() {
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param Festival: Es la entidad que se va a convertir a DTO
     */
    public FestivalDTO(FestivalEntity Festival) {
        this.id = Festival.getId();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaDin) {
        this.fechaFin = fechaDin;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public FestivalEntity toEntity() {
        FestivalEntity entity = new FestivalEntity();
        entity.setId(this.id);
        entity.setNombre(this.nombre);
        entity.setFechaInicio(this.fechaInicio);
        entity.setFechaFin(this.fechaFin);
        entity.setPatrocinador(this.patrocinador);
        return entity;
    }
    
}
