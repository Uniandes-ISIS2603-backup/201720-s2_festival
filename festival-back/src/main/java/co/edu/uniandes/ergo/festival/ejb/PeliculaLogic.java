/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;

import co.edu.uniandes.ergo.festival.entities.PeliculaEntity;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import co.edu.uniandes.ergo.festival.persistence.PeliculaPersistence;
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
public class PeliculaLogic {

    private static final Logger LOGGER = java.util.logging.Logger.getLogger(PeliculaLogic.class.getName());

    @Inject
    private PeliculaPersistence persistence;

    public List<PeliculaEntity> getPeliculas() {
        LOGGER.info("Inicia el proceso de consultar todas las películas.");
        List<PeliculaEntity> peliculas = persistence.findAll();
        LOGGER.info("Termina el proceso de consultar todas las películas.");
        return peliculas;
    }

    public PeliculaEntity getPeliculas(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la película con id={0}", id);

        PeliculaEntity pelicula = persistence.find(id);

        if (pelicula == null) {
            LOGGER.log(Level.SEVERE, "La película con el id {0} no existe", id);
        }

        LOGGER.log(Level.INFO, "Termina proceso de consultar la película con id={0}", id);
        return pelicula;
    }

    public PeliculaEntity createPelicula(PeliculaEntity nueva) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de la película.");

        int val = ValidarCreate(nueva); 
        if (val == 0) {
            PeliculaEntity conId = persistence.create(nueva);
            LOGGER.info("Termina proceso de creación de la película.");
            return conId;
        }
        String excepcion = (val == 1) ? "El nombre de la película no es válido." :
                           (val == 2) ? "Ya existe una película con el mismo nombre" :
                           (val == 3) ? "La película no puede durar 0 minutos" :
                                        "La película debe tener al menos 1 género" ;
        
        throw new BusinessLogicException(excepcion);
    }
    
    public PeliculaEntity updatePelicula(Long id, PeliculaEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar libro con id={0}", id);
        if (persistence.find(id) == null){
            throw new BusinessLogicException("No se encuentra la película con el id " + id + " "); 
        }
        PeliculaEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar la pelícla con id={0}", entity.getId());
        return newEntity;
    }
    
    public void deletePelicula(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar la película con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar la película con id={0}", id);
    }
    

    public int ValidarCreate(PeliculaEntity peli) {
        
        return (peli.getName() == null || peli.getName().isEmpty()) ? 1 : 
                (persistence.findByName(peli.getName()) != null)? 2 : 
                (peli.getDuracionMinutos() == 0) ? 3 :
                ( peli.getGeneros() == null || peli.getGeneros().isEmpty()) ? 4 :
                0;
        
    }
}
