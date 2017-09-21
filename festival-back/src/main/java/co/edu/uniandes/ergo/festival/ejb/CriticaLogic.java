/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;

import co.edu.uniandes.ergo.festival.entities.CriticaEntity;
import co.edu.uniandes.ergo.festival.persistence.CriticaPersistence;
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
public class CriticaLogic {
    
    private static final Logger LOGGER = Logger.getLogger(CriticaLogic.class.getName());
    
    @Inject
    private CriticaPersistence persistence;
    
    /**
     * Ordena a la persistencia crear una CriticaEntity.
     * @param entity La CriticaEntity a ser creada.
     * @return La CriticaEntity creada.
     */
    public CriticaEntity createCritica(CriticaEntity entity){
        LOGGER.log(Level.INFO, "Inicia proceso de crear una CriticaEntity.");
        return persistence.create(entity);
    }
    
    /**
     * Obtiene la información de una CriticaEntity de la persistencia.
     * @param id id de la CriticaEntity a consultar.
     * @return La CriticaEntity con el id buscado.
     */
    public CriticaEntity getCritica(Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una CriticaEntity.");
        return persistence.find(id);
    }
    
    /**
     * Obtiene la información de todas las CriticaEntity de la persistencia.
     * @return 
     */
    public List<CriticaEntity> getCriticas(){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las CriticaEntity.");
        return persistence.findAll();        
    }
    
    /**
     * Actualiza la información de una CriticaEntity.
     * @param entity La información de la CriticaEntity actualizada.
     * @return La CriticaEntity actualizada.
     */
    public CriticaEntity updateCritica(CriticaEntity entity){
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una CriticaEntity.");
        return persistence.update(entity);
    }
    
    /**
     * Elimian una CriticaEntity de la persistencia.
     * @param id el id de la CriticaEntity a eliminar.
     */
    public void deleteCritica(Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una CriticaEntity.");
        persistence.delete(id);
    }
}
