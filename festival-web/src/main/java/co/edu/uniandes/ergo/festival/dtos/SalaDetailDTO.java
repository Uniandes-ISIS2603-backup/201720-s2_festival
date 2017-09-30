/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.FuncionEntity;
import co.edu.uniandes.ergo.festival.entities.SalaEntity;
import co.edu.uniandes.ergo.festival.entities.SillaEntity;
import co.edu.uniandes.ergo.festival.entities.TeatroEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author f.mayenberger10
 */
public class SalaDetailDTO extends SalaDTO {
    
    //private List<FuncionDTO> funcionesDTO;
    private List<SillaDTO> sillasDTO;
    //private TeatroDTO teatroDTO;
    
    public SalaDetailDTO() {
        super();
    }

    public SalaDetailDTO(SalaEntity entity) {
        super(entity);
        System.out.println("1");
        /*TeatroEntity teatro = entity.getTeatro();
        if (teatro != null) {
            teatroDTO = new TeatroDTO(teatro);
        }
        
        System.out.println("2");
        List<FuncionEntity> funciones = entity.getFunciones();
        if (funciones !=  null) {
            funcionesDTO = new ArrayList<>();
            for (FuncionEntity funcion : funciones) {
                funcionesDTO.add(new FuncionDTO(funcion));
            }
        }
        */
        System.out.println("3");
        List<SillaEntity> sillas = entity.getSillas();
        if (sillas != null) {
            sillasDTO = new ArrayList<>();
            for (SillaEntity silla : sillas) {
                sillasDTO.add(new SillaDTO(silla));
            }
        }
    }

    @Override
    public SalaEntity toEntity() {
        SalaEntity retornar = super.toEntity();
        
        /*System.out.println("4");
        if (getTeatroDTO() != null) {
            retornar.setTeatro(getTeatroDTO().toEntity());
        }
        
        System.out.println("5");
        if (getFuncionesDTO() != null) {
            List<FuncionEntity> funciones = new ArrayList<>();
            for (FuncionDTO dto : getFuncionesDTO()) {
                funciones.add(dto.toEntity());
            }
            retornar.setFunciones(funciones);
        }
        */
        System.out.println("6");
        if (getSillasDTO() != null) {
            List<SillaEntity> sillas = new ArrayList<>();
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
    /*public List<FuncionDTO> getFuncionesDTO() {
        return funcionesDTO;
    }*/

    /**
     * @return the sillasDTO
     */
    public List<SillaDTO> getSillasDTO() {
        return sillasDTO;
    }

    /**
     * @return the teatroDTO
     */
    /*public TeatroDTO getTeatroDTO() {
        return teatroDTO;
    }*/
    
    /**
     * @param funcionesDTO the funcionesDTO to set
     */
    /*public void setFuncionesDTO(List<FuncionDTO> funcionesDTO) {
        this.funcionesDTO = funcionesDTO;
    }*/

    /**
     * @param sillasDTO the sillasDTO to set
     */
    public void setSillasDTO(List<SillaDTO> sillasDTO) {
        this.sillasDTO = sillasDTO;
    }

    /**
     * @param teatroDTO the teatroDTO to set
     */
    /*public void setTeatroDTO(TeatroDTO teatroDTO) {
        this.teatroDTO = teatroDTO;
    }*/
}
