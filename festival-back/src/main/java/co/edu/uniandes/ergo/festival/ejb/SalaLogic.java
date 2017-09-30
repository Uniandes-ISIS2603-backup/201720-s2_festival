/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;

import co.edu.uniandes.ergo.festival.entities.SalaEntity;
import co.edu.uniandes.ergo.festival.entities.SillaEntity;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
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
    @Inject
    private SillaLogic sillas;
    
    public SalaEntity create (SalaEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Logic creando sala {0}", entity.getName());
        int numSillas = entity.getNumSillas();
        int preferenciales = entity.getNumSillasPreferenciales();
        
        if(preferenciales > numSillas) {
            throw new BusinessLogicException("no puede haber más sillas preferenciales que el total de sillas");
        }
        crearSillas(entity, numSillas, preferenciales);
        
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
    
    public SalaEntity update(SalaEntity nueva) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Logic updateando la sala con id {0}", nueva.getId());
        SalaEntity vieja = persistence.find(nueva.getId());
        SalaEntity terminada = persistence.update(nueva);
        if(nueva.getNumSillas() != vieja.getNumSillas() || nueva.getNumSillasPreferenciales() != vieja.getNumSillasPreferenciales()) {
            borrarSillas(vieja);
            crearSillas(terminada, nueva.getNumSillas(), nueva.getNumSillasPreferenciales());
        }
        return terminada;
    }
    
    public void remove(Long id) {
        LOGGER.log(Level.INFO, "Logic eliminando sala con id {0}", id);
        persistence.remove(id);
    }
    
    private void borrarSillas(SalaEntity entity) throws BusinessLogicException {
        for (SillaEntity silla : entity.getSillas()) {
            sillas.deleteSilla(silla.getId());
        }
    }
    
    private void crearSillas(SalaEntity entity, int numSillas, int numPreferenciales) throws BusinessLogicException {
        int numCuadrado = (int)Math.sqrt(numSillas);
        int letra = 64;
        for (int i = 0; i < numSillas; i++) {
            if(i%numCuadrado == 0) letra++;
            SillaEntity nueva = new SillaEntity();
            nueva.setSala(entity);
            nueva.setName("" + (char)letra + i%numCuadrado);
            if (numSillas - numPreferenciales <= i) nueva.setEsPreferencial(true);
            else nueva.setEsPreferencial(false);
            sillas.createSilla(nueva);
        }
    }
}
