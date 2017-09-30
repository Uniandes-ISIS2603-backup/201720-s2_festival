/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.CriticaEntity;
import co.edu.uniandes.ergo.festival.entities.CriticoEntity;
import co.edu.uniandes.ergo.festival.entities.PeliculaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dj.bautista10
 */
public class CriticoDetailDTO extends CriticoDTO {

    private List<PeliculaDTO> peliculas;
    //private List<CriticaDTO> criticas;

    public CriticoDetailDTO() {
        super();
    }

    public CriticoDetailDTO(CriticoEntity critico) {
        super(critico);
        if (critico.GetPeliculas() != null) {
            peliculas = new ArrayList<>();
            for (PeliculaEntity pelicula : critico.GetPeliculas()) {
                peliculas.add(new PeliculaDTO(pelicula));
            }
        }

//        if(critico.getCriticas() != null){
//        criticas = new ArrayList<>();
//        for(CriticoEntity critica : critico.getCriticas()){
//        criticas.add(new CriticaDTO(critica));
//        }
//        }
    }

    public List<PeliculaDTO> getPeliculas() {
        return peliculas;
    }

//    public List<CriticaDTO> getCriticas(){
//        return criticas;
//    }
    public void setPeliculas(List<PeliculaDTO> peliculas) {
        this.peliculas = peliculas;
    }

//    public void setCriticas(List<CriticaDTO> criticas){
//        this.criticas = criticas
//    }
    @Override
    public CriticoEntity toEntity() {
        CriticoEntity entCritico = super.toEntity();
        if (peliculas != null) {
            List<PeliculaEntity> ePeliculas = new ArrayList<>();
            for (PeliculaDTO pelicula : peliculas) {
                ePeliculas.add(pelicula.toEntity());
            }
            entCritico.setPeliculas(ePeliculas);
        }

//        if (criticas != null) {
//            List<CriticaEntity> eCriticas = new ArrayList<>();
//            for (CriticaDTO critica : criticas) {
//                eCriticas.add(critica.toEntity());
//            }
//            entCritico.setCriticas(eCriticas);
//        }
        return entCritico;
    }
}
