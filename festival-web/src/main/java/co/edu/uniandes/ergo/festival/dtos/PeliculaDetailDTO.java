/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.CriticoEntity;
import co.edu.uniandes.ergo.festival.entities.FuncionEntity;
import co.edu.uniandes.ergo.festival.entities.PeliculaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dj.bautista10
 */
public class PeliculaDetailDTO extends PeliculaDTO {

    private List<CriticoDTO> criticos;
    private List<FuncionDTO> funciones;

    public PeliculaDetailDTO() {
        super();
    }

    public PeliculaDetailDTO(PeliculaEntity pelicula) {
        super(pelicula);

        if (pelicula.getCriticos() != null) {
            criticos = new ArrayList<>();
            for (CriticoEntity cri : pelicula.getCriticos()) {
                criticos.add(new CriticoDTO(cri));
            }
        }

        if (pelicula.getFunciones() != null) {
            funciones = new ArrayList<>();
            for (FuncionEntity func : pelicula.getFunciones()) {
                funciones.add(new FuncionDTO(func));
            }
        }
    }

    public List<CriticoDTO> getCriticos() {
        return criticos;
    }

    public List<FuncionDTO> getFunciones() {
        return funciones;
    }

    @Override
    public PeliculaEntity toEntity() {
        PeliculaEntity pelicula = super.toEntity();

        if (this.getCriticos() != null) {
            List<CriticoEntity> entCriticos = new ArrayList<CriticoEntity>();
            for (CriticoDTO cri : criticos) {
                entCriticos.add(cri.toEntity());
            }
            pelicula.setCriticos(entCriticos);
        }

        if (this.getFunciones() != null) {
            List<FuncionEntity> entFunciones = new ArrayList<FuncionEntity>();
            for (FuncionDTO func : funciones) {
                entFunciones.add(func.toEntity());
            }
            pelicula.setFunciones(entFunciones);
        }

        return pelicula;
    }
}
