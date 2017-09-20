/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;

import co.edu.uniandes.ergo.festival.entities.CriticoEntity;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import co.edu.uniandes.ergo.festival.persistence.CriticoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author dj.bautista10
 */
@Stateless
public class CriticoLogic {

    private static final Logger LOGGER = java.util.logging.Logger.getLogger(CriticoLogic.class.getName());

    @Inject
    private CriticoPersistence persistence;

    public List<CriticoEntity> getCriticos() {
        LOGGER.info("Inicia el proceso de consultar todas los críticos.");
        List<CriticoEntity> criticos = persistence.findAll();
        LOGGER.info("Termina el proceso de consultar todas los críticos.");
        return criticos;
    }

    public CriticoEntity getCritico(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el crítico con id={0}", id);

        CriticoEntity critico = persistence.find(id);

        if (critico == null) {
            LOGGER.log(Level.SEVERE, "La película con el id {0} no existe", id);
        }

        LOGGER.log(Level.INFO, "Termina proceso de consultar el crítico con id={0}", id);
        return critico;
    }

    public CriticoEntity createCritico(CriticoEntity nueva) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de el crítico.");

        //int val = ValidarCreate(nueva);
        int val = 0;
        if (val != 0) {
            String excepcion = (val == 1) ? "El nombre de el crítico no es válido."
                    : (val == 2) ? "Ya existe una película con el mismo nombre"
                            : (val == 3) ? "La película no puede durar 0 minutos"
                                    : "La película debe tener al menos 1 género";

            throw new BusinessLogicException(excepcion);
        }
        
        CriticoEntity conId = persistence.create(nueva);
        LOGGER.info("Termina proceso de creación de el crítico.");
        return conId;
    }

    public CriticoEntity updateCritico(Long id, CriticoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar libro con id={0}", id);
        if (persistence.find(id) == null) {
            throw new BusinessLogicException("No se encuentra el crítico con el id " + id + " ");
        }
        CriticoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el crítico con id={0}", entity.getId());
        return newEntity;
    }

    public void deleteCritico(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el crítico con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar el crítico con id={0}", id);
    }
}
