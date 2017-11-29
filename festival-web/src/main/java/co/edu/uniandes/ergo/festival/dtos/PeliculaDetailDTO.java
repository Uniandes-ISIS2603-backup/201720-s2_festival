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
    /**
     * Atributo que contiene la Lista de Críticos de esta Película.
     */
    private List<CriticoDTO> criticos;
    /**
     * Atributo que contiene la lista de Funciones de esta Película.
     */
    private List<FuncionDTO> funciones;
    /**
     * Método constructor por defecto.
     */
    public PeliculaDetailDTO() {
        super();
    }
    /**
     * Método que construye una PeliculaDetailDTO a partir de la versión Entidad de Película.
     * @param pelicula 
     */
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
    /**
     * Método que obtiene la lista de Críticos de esta Película.
     * @return List<CriticoDTO>, lista de Críticos de la Película.
     */
    public List<CriticoDTO> getCriticos() {
        return criticos;
    }
    /**
     * Método que obtiene las Funciones de esta Película.
     * @return List<FuncionDTO>, lista de Funciones de la Película.
     */
    public List<FuncionDTO> getFunciones() {
        return funciones;
    }
    /**
     * Método que construye una PeliculaEntity a partir de este DTO.
     * @return PeliculaEntity, Entidad de la Película.
     */
    @Override
    public PeliculaEntity toEntity() {
        PeliculaEntity pelicula = super.toEntity();

        if (this.getCriticos() != null) {
            List<CriticoEntity> entCriticos = new ArrayList<>();
            for (CriticoDTO cri : criticos) {
                entCriticos.add(cri.toEntity());
            }
            pelicula.setCriticos(entCriticos);
        }

        if (this.getFunciones() != null) {
            List<FuncionEntity> entFunciones = new ArrayList<>();
            for (FuncionDTO func : funciones) {
                entFunciones.add(func.toEntity());
            }
            pelicula.setFunciones(entFunciones);
        }

        return pelicula;
    }
}
