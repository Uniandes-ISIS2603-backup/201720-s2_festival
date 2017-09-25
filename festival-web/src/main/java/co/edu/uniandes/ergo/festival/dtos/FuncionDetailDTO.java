/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.FuncionEntity;
import java.util.List;

/**
 *
 * @author m.neira10
 */
public class FuncionDetailDTO extends FuncionDTO{

    
    private List<BoletaDTO> boletas;
    private List<CriticaDTO> criticas;
    private PeliculaDTO pelicula;
    
    public FuncionDetailDTO(FuncionEntity createFuncion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public FuncionEntity toEntity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
