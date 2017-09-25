/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.ejb.CriticoLogic;
import co.edu.uniandes.ergo.festival.entities.FuncionEntity;
import co.edu.uniandes.ergo.festival.entities.SalaEntity;
import co.edu.uniandes.ergo.festival.entities.SillaEntity;
import co.edu.uniandes.ergo.festival.entities.TeatroEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author f.mayenberger10
 */
public class SalaDetailDTO extends SalaDTO {

    private List<FuncionDTO> funcionesDTO;
    private List<SillaDTO> sillasDTO;
    private TeatroDTO teatroDTO;
    
    public SalaDetailDTO() {
//        super();
    }

    public SalaDetailDTO(SalaEntity entity) {
        super(entity);

        TeatroEntity teatro = entity.getTeatro();
        if (teatro != null) {
            teatroDTO = new TeatroDTO(teatro);
        }

        List<FuncionEntity> funciones = entity.getFunciones();
        funcionesDTO = new ArrayList<>();
        if (funciones != null) {
            for (FuncionEntity funcion : funciones) {
                funcionesDTO.add(new FuncionDTO(funcion));
            }
        }

        List<SillaEntity> sillas = entity.getSillas();
        sillasDTO = new ArrayList<>();
        if (sillas != null) {
            for (SillaEntity silla : sillas) {
                sillasDTO.add(new SillaDTO(silla));
            }
        }
    }

    @Override
    public SalaEntity toEntity() {
        SalaEntity retornar = super.toEntity();
        
        if (getTeatroDTO() != null) {
            retornar.setTeatro(getTeatroDTO().toEntity());
        }

        List<FuncionEntity> funciones = new ArrayList<>();
        if (getFuncionesDTO() != null) {
            for (FuncionDTO dto : getFuncionesDTO()) {
                funciones.add(dto.toEntity());
            }
            retornar.setFunciones(funciones);
        }

        List<SillaEntity> sillas = new ArrayList<>();
        if (getSillasDTO() != null) {
            for (SillaDTO dto : getSillasDTO()) {
                sillas.add(dto.toEntity());
            }
            retornar.setSillas(sillas);
        }

        return retornar;
    }

    /**
     * @return the funcionesDTO
     */
    public List<FuncionDTO> getFuncionesDTO() {
        return funcionesDTO;
    }

    /**
     * @return the sillasDTO
     */
    public List<SillaDTO> getSillasDTO() {
        return sillasDTO;
    }

    /**
     * @return the teatroDTO
     */
    public TeatroDTO getTeatroDTO() {
        return teatroDTO;
    }
    
    
    /**
     * @param funcionesDTO the funcionesDTO to set
     */
    public void setFuncionesDTO(List<FuncionDTO> funcionesDTO) {
        this.funcionesDTO = funcionesDTO;
    }

    /**
     * @param sillasDTO the sillasDTO to set
     */
    public void setSillasDTO(List<SillaDTO> sillasDTO) {
        this.sillasDTO = sillasDTO;
    }

    /**
     * @param teatroDTO the teatroDTO to set
     */
    public void setTeatroDTO(TeatroDTO teatroDTO) {
        this.teatroDTO = teatroDTO;
    }
}
