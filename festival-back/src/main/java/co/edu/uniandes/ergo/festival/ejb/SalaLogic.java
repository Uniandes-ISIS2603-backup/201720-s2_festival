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
    /**
     * Método que crea una Sala Nueva.
     * @param entity SalaEntity, toda la información de la nueva Sala.
     * @return
     * @throws BusinessLogicException 
     */
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
    /**
     * Método que obtiene todas las Salas.
     * @return List<SalaEntity>, Lista de Salas.
     */
    public List<SalaEntity> get() {
        LOGGER.log(Level.INFO, "Logic buscando todas las salas");
        return persistence.findAll();
    }
    /**
     * Método que obtiene una Sala según su ID.
     * @param id Long, ID de la Sala.
     * @return SalaEntity, toda la información de la Sala.
     */
    public SalaEntity get(Long id) {
        LOGGER.log(Level.INFO, "Logic buscando sala con id {0}" , id);
        return persistence.find(id);
    }
    /**
     * Método que actualiza una Sala, con un ID específico, con información nueva.
     * @param nueva SalaEntity, nueva información de la Sala.
     * @return SalaEntity, Sala con la información actualizada.
     * @throws BusinessLogicException 
     */
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
    /**
     * Método que borra una Sala con un ID especificado.
     * @param id Long, ID de la Sala a Borrar.
     */
    public void remove(Long id) {
        LOGGER.log(Level.INFO, "Logic eliminando sala con id {0}", id);
        persistence.remove(id);
    }
    /**
     * Método que borra las Sillas de una Sala.
     * @param entity SalaEntity, información de la Salas cuyas Sillas hay que borrar.
     * @throws BusinessLogicException 
     */
    private void borrarSillas(SalaEntity entity) throws BusinessLogicException {
        for (SillaEntity silla : entity.getSillas()) {
            sillas.deleteSilla(silla.getId());
        }
    }
    /**
     * Método que crea las Sillas de una Sala.
     * @param entity SalaEntity, Sala
     * @param numSillas int, número de Sillas a crear.
     * @param numPreferenciales int, número de Sillas preferenciales a crear.
     * @throws BusinessLogicException 
     */
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