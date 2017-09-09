/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.PeliculaEntity;

/**
 *
 * @author dj.bautista10
 */
public class PeliculaDetailDTO extends PeliculaDTO {
    
    public PeliculaDetailDTO(){
        
    }
    
    public PeliculaDetailDTO(PeliculaEntity pelicula){
        super(pelicula);
    }
    
    public PeliculaEntity toEntity(){
        PeliculaEntity pelicula = super.toEntity();
        return pelicula;
    }
}
