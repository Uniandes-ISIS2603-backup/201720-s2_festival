/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.SalaEntity;
import co.edu.uniandes.ergo.festival.entities.SillaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author f.mayenberger10
 */
public class SalaDetailDTO extends SalaDTO {
    
    
    private List<SillaDTO> sillasDTO;

    /**
     * Método constructor por Defecto.
     */
    public SalaDetailDTO() {
        super();
    }
    /**
     * Método que construye una SalaDetailDTO a partir de la entidad.
     * @param entity 
     */
    public SalaDetailDTO(SalaEntity entity) {
        super(entity);
        System.out.println("1");
        List<SillaEntity> sillas = entity.getSillas();
        if (sillas != null) {
            sillasDTO = new ArrayList<>();
            for (SillaEntity silla : sillas) {
                sillasDTO.add(new SillaDTO(silla));
            }
        }
    }
    /**
     * Método que convierte esta Sala a su versión Entidad.
     * @return SalaEntity, Entidad de la Sala.
     */
    @Override
    public SalaEntity toEntity() {
        SalaEntity retornar = super.toEntity();
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
     * Método que obtiene las Sillas de esta Sala.
     * @return the sillasDTO
     */
    public List<SillaDTO> getSillasDTO() {
        return sillasDTO;
    }

    /**
     * Método que establece las Sillas de esta Sala.
     * @param sillasDTO the sillasDTO to set
     */
    public void setSillasDTO(List<SillaDTO> sillasDTO) {
        this.sillasDTO = sillasDTO;
    }
}
