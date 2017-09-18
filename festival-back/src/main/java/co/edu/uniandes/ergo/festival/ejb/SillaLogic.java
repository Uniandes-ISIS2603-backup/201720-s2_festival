/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;

import co.edu.uniandes.ergo.festival.entities.SillaEntity;
import co.edu.uniandes.ergo.festival.persistence.SillaPersistence;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 *
 * @author f.reyes948
 */
@Stateless
public class SillaLogic {
    
    private static final Logger LOGGER = Logger.getLogger(SillaLogic.class.getName());
    
    @Inject
    private SillaPersistence persistence;
    
    /**
     * Ordena a la persistencia crear una SillaEntity.
     * @param entity La SillaEntity a ser creada.
     * @return La SillaEntity creada.
     */
    public SillaEntity createSilla(SillaEntity entity){
        LOGGER.log(Level.INFO, "Inicia proceso de crear una SillaEntity.");
        return persistence.create(entity);
    }
    
    /**
     * Obtiene la información de una SillaEntity de la persistencia.
     * @param id id de la SillaEntity a consultar.
     * @return La SillaEntity con el id buscado.
     */
    public SillaEntity getSilla(Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una SillaEntity.");
        return persistence.find(id);
    }
    
    /**
     * Obtiene la información de todas las SillaEntity de la persistencia.
     * @return 
     */
    public List<SillaEntity> getSillas(){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las SillaEntity.");
        return persistence.findAll();        
    }
    
    /**
     * Actualiza la información de una SillaEntity.
     * @param entity La información de la SillaEntity actualizada.
     * @return La SillaEntity actualizada.
     */
    public SillaEntity updateSilla(SillaEntity entity){
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una SillaEntity.");
        return persistence.update(entity);
    }
    
    /**
     * Elimian una SillaEntity de la persistencia.
     * @param id el id de la SillaEntity a eliminar.
     */
    public void deleteSilla(Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una SillaEntity.");
        persistence.delete(id);
    }
}
