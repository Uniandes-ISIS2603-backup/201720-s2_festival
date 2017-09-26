/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;

import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.entities.CalificacionEntity;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import co.edu.uniandes.ergo.festival.persistence.CalificacionPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author m.neira10
 */
@Stateless
public class CalificacionLogic {
     private static final Logger LOGGER = Logger.getLogger(SillaLogic.class.getName());
    
    @Inject
    private CalificacionPersistence persistence;
    
    public CalificacionEntity createCalificacion(CalificacionEntity entity,BoletaEntity bol) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de crear una CalificacionEntity.");
        entity.setBoleta(bol);
        if(entity.getBoleta()==null){
            throw new BusinessLogicException("La calificacion no tiene una boleta asignada");
        }
        if(entity.getBoleta().getCalificacion()==null){
            return persistence.create(entity);
        }
        if(entity.getBoleta().getCalificacion().size()==1){
            throw new BusinessLogicException("La boleta ya tiene una calificacion.");
        }
        
        return persistence.create(entity);
    }
    
    public CalificacionEntity getCalificacion(Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una CalificacionEntity.");
        return persistence.find(id);
    }
    
    public List<CalificacionEntity> getCalificaciones(){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las CalificacionEntity.");
        return persistence.findAll();
    }
    
    public CalificacionEntity updateCalificacion(CalificacionEntity entity){
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una CalificacionEntity.");
        return persistence.update(entity);
    }
    
    public void deleteCalificacion(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una CalificacionEntity.");
        persistence.delete(id);
    }
    
}
