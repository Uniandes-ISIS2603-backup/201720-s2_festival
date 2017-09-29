/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;

import co.edu.uniandes.ergo.festival.entities.CriticoEntity;
import co.edu.uniandes.ergo.festival.entities.PeliculaEntity;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import co.edu.uniandes.ergo.festival.persistence.CriticoPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author dj.bautista10
 */
@Stateless
public class CriticoLogic {

    private static final Logger LOGGER = java.util.logging.Logger.getLogger(CriticoLogic.class.getName());

    @Inject
    private CriticoPersistence persistence;
    
    @Inject
    private PeliculaLogic peliculaLogic;

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
    
    /**
     * Retorna las PeliculaEntity asociadas a un CriticoEntity.
     * @param criticosid La identificación del CriticoEntity.
     * @return Una lista de las PeliculaEntity.
     */
    public List<PeliculaEntity> getPeliculasCritico(Long criticosid){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar las PeliculaEntity "
                + "del CriticoEntity con id={0}", criticosid);
        CriticoEntity critico = persistence.find(criticosid);
        return critico.GetPeliculas();
    }
    
    /**
     * Actualiza las PeliculaEntity de la CriticoEntity.
     * @param criticosid La identificación de la CriticoEntity.
     * @param peliculas La lista con las nuevas PeliculaEntity.
     * @return La CriticoEntity actualizada.
     */
    public CriticoEntity updatePeliculasCritico(Long criticosid, List<PeliculaEntity> peliculas){
        CriticoEntity critico = persistence.find(criticosid);
        List<PeliculaEntity> nuevasPeliculas = new ArrayList();
        PeliculaEntity  nuevaPelicula;
        for (PeliculaEntity pelicula : peliculas) {
            nuevaPelicula = peliculaLogic.getPelicula(pelicula.getId());
            if (nuevaPelicula == null){
                throw new WebApplicationException("La pelicula con id: " 
                        + pelicula.getId() + " no existe.", 404);
            }
            nuevasPeliculas.add(nuevaPelicula);
        }
        critico.setPeliculas(nuevasPeliculas);
        return critico;
    }
    
}
