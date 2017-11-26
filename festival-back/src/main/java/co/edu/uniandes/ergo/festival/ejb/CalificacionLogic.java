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
    /**
     * Método que crea una Calificación.
     * @param entity CalificacionEntity, Información de la Calificación.
     * @param bol BoletaEntity, Información de la Boleta asociada.
     * @return CalificacionEntity, Calificación con toda la información.
     * @throws BusinessLogicException 
     */
    public CalificacionEntity createCalificacion(CalificacionEntity entity,BoletaEntity bol) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de crear una CalificacionEntity.");        
        return persistence.create(entity);
    }
    /**
     * Método que obtiene una Calificación con un ID especificado.
     * @param id Long, ID de la Calificación.
     * @return CalificacionEntity, toda la información de la Calificación.
     */
    public CalificacionEntity getCalificacion(Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una CalificacionEntity.");
        return persistence.find(id);
    }
    /**
     * Método que entrega una Lista con todas las Calificaciones.
     * @return List<CalificacionEntity>, Lista de Calificaciones.
     */
    public List<CalificacionEntity> getCalificaciones(){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las CalificacionEntity.");
        return persistence.findAll();
    }
    /**
     * Método que actualiza una Calificación.
     * @param entity CalificacionEntity, nueva Informacion de la Calificacion.
     * @return CalificacionEntity, Calificacion actualizada.
     */
    public CalificacionEntity updateCalificacion(CalificacionEntity entity){
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una CalificacionEntity.");
        return persistence.update(entity);
    }
    /**
     * Método que elimina una Calificacion con un ID especificado.
     * @param id Long, ID de la Calificacion.
     */
    public void deleteCalificacion(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una CalificacionEntity.");
        persistence.delete(id);
    }
    
}
