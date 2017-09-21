/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;

import co.edu.uniandes.ergo.festival.entities.SalaEntity;
import co.edu.uniandes.ergo.festival.persistence.SalaPersistence;
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
public class SalaLogic {
    private static final Logger LOGGER = Logger.getLogger(SalaLogic.class.getName());
    
    @Inject
    private SalaPersistence persistence;
    
    public SalaEntity create (SalaEntity entity) {
        LOGGER.log(Level.INFO, "Logic creando sala {0}", entity.getName());
        return persistence.create(entity);
    }
    
    public List<SalaEntity> get() {
        LOGGER.log(Level.INFO, "Logic buscando todas las salas");
        return persistence.findAll();
    }
    
    public SalaEntity get(Long id) {
        LOGGER.log(Level.INFO, "Logic buscando sala con id {0}" , id);
        return persistence.find(id);
    }
    
    public SalaEntity update(SalaEntity nueva) {
        LOGGER.log(Level.INFO, "Logic updateando la sala con id {0}", nueva.getId());
        return persistence.update(nueva);
    }
    
    public void remove(Long id) {
        LOGGER.log(Level.INFO, "Logic eliminando sala con id {0}", id);
        persistence.remove(id);
    }
}
