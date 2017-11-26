/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;

import co.edu.uniandes.ergo.festival.entities.PatrocinadorEntity;
import co.edu.uniandes.ergo.festival.persistence.PatrocinadorPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author f.mayenberger10
 */
@Stateless
public class PatrocinadorLogic {
    private static final Logger LOGGER = Logger.getLogger(PatrocinadorLogic.class.getName());
    
    @Inject
    private PatrocinadorPersistence persistence;
    /**
     * Método que crea un nuevo Patrocinador.
     * @param entity PatrocinadorEntity, toda la información del Patrocinador.
     * @return PatrocinadorEntity.
     */
    public PatrocinadorEntity create (PatrocinadorEntity entity) {
        LOGGER.log(Level.INFO, "Logic creando patrocinador");
        return persistence.create(entity);
    }
    /**
     * Método que obtiene una Lista con todos los Patrocinadores.
     * @return List<PatrocinadorEntity>, Lista con todos los Patrocinadores.
     */
    public List<PatrocinadorEntity> get() {
        LOGGER.log(Level.INFO, "Logic buscando todos los patrocinadores");
        return persistence.findAll();
    }
    /**
     * Método que obtiene un Patrocinador especificado por su ID.
     * @param id Long, ID del Patrocinador.
     * @return PatrocinadorEntity, Patrocinador buscado.
     */
    public PatrocinadorEntity get(Long id) {
        LOGGER.log(Level.INFO, "Logic buscando patrocinador con id {0}" , id);
        return persistence.find(id);
    }
    /**
     * Método que actualiza la información de un Patrocinador.
     * @param nuevo PatrocinadorEntity, nueva información de un Patrocinador.
     * @return 
     */
    public PatrocinadorEntity update(PatrocinadorEntity nuevo) {
        LOGGER.log(Level.INFO, "Logic updateando el patrocinador con id {0}", nuevo.getId());
        return persistence.update(nuevo);
    }
    /**
     * Método que borra un Patrocinador especificado por su ID.
     * @param id Long, ID del Patrocinador a borrar.
     */
    public void remove(Long id) {
        LOGGER.log(Level.INFO, "Logic eliminando patrocinador con id {0}", id);
        persistence.remove(id);
    }
}
