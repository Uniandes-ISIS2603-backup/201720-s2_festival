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
    
    public PatrocinadorEntity create (PatrocinadorEntity entity) {
        LOGGER.log(Level.INFO, "Logic creando patrocinador");
        return persistence.create(entity);
    }
    
    public List<PatrocinadorEntity> get() {
        LOGGER.log(Level.INFO, "Logic buscando todos los patrocinadores");
        return persistence.findAll();
    }
    
    public PatrocinadorEntity get(Long id) {
        LOGGER.log(Level.INFO, "Logic buscando patrocinador con id {0}" , id);
        return persistence.find(id);
    }
    
    
    public PatrocinadorEntity update(PatrocinadorEntity nuevo) {
        LOGGER.log(Level.INFO, "Logic updateando el patrocinador con id {0}", nuevo.getId());
        return persistence.update(nuevo);
    }
    
    public void remove(Long id) {
        LOGGER.log(Level.INFO, "Logic eliminando patrocinador con id {0}", id);
        persistence.remove(id);
    }
}
