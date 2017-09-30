/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;

import co.edu.uniandes.ergo.festival.entities.CriticoEntity;
import co.edu.uniandes.ergo.festival.entities.FuncionEntity;
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
  
    @Inject
    private FuncionLogic funLogic;

    public List<PeliculaEntity> getPeliculas() {
        LOGGER.info("Inicia el proceso de consultar todas las películas.");
        List<PeliculaEntity> peliculas = persistence.findAll();
        LOGGER.info("Termina el proceso de consultar todas las películas.");
        return peliculas;
    }

    public PeliculaEntity getPelicula(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la película con id={0}", id);

        PeliculaEntity pelicula = persistence.find(id);

        if (pelicula == null) {
            LOGGER.log(Level.SEVERE, "La película con el id {0} no existe", id);
            throw new BusinessLogicException("La película con el id " + id + " no existe"); //ESTO TAL VEZ PUEDE DAÑAR LAS PRUEBAS DE POSTMAN //
        }

        LOGGER.log(Level.INFO, "Termina proceso de consultar la película con id={0}", id);
        return pelicula;
    }

    public PeliculaEntity createPelicula(PeliculaEntity nueva) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de la película.");

        //int val = ValidarCreate(nueva);
        int val = 0;
        if (val != 0) {
            String excepcion = (val == 1) ? "El nombre de la película no es válido."
                    : (val == 2) ? "Ya existe una película con el mismo nombre"
                            : (val == 3) ? "La película no puede durar 0 minutos"
                                    : "La película debe tener al menos 1 género";

            throw new BusinessLogicException(excepcion);
        }
        
        PeliculaEntity conId = persistence.create(nueva);
        LOGGER.info("Termina proceso de creación de la película.");
        return conId;
    }

    public PeliculaEntity updatePelicula(Long id, PeliculaEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar libro con id={0}", id);
        if (persistence.find(id) == null) {
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

//    public int ValidarCreate(PeliculaEntity peli) {
//        LOGGER.log(Level.INFO, "corto={0}", peli.getCorto());
//        LOGGER.log(Level.INFO, "nombre={0}", peli.getName());
//        LOGGER.log(Level.INFO, "diracionMinutos={0}", peli.getDuracionMinutos());
//        LOGGER.log(Level.INFO, "director={0}", peli.getDirector());
//        LOGGER.log(Level.INFO, "creiditos={0}", peli.getCreditos());
//        LOGGER.log(Level.INFO, "pais={0}", peli.getPais());
//        LOGGER.log(Level.INFO, "datos={0}", peli.getDatos());
//        return (peli.getName() == null || peli.getName().isEmpty()) ? 1
//                : (persistence.findByName(peli.getName()) != null) ? 2
//                : (peli.getDuracionMinutos() == 0) ? 3
//                : (peli.getGeneros() == null || peli.getGeneros().isEmpty()) ? 4
//                : 0;
//
//    }

    public PeliculaEntity addCritico(Long pelId, CriticoEntity critico) throws BusinessLogicException {
        PeliculaEntity peli = getPelicula(pelId);
        peli.addCritico(critico);
        persistence.update(peli);
        return peli;
    }
    
    public void removeCritico(Long pelId, Long crId) throws BusinessLogicException{
        PeliculaEntity pelicula = getPelicula(pelId);
        CriticoEntity borrar = new CriticoEntity();
        borrar.setId(crId);
        pelicula.removeCritico(borrar);
        persistence.update(pelicula);
    }
    
    public PeliculaEntity addFuncion(Long pelId, Long funId) throws BusinessLogicException{
        PeliculaEntity pelicula = getPelicula(pelId);
        LOGGER.log(Level.INFO, "Inicia proceso de asociar la función con id ={0}", funId);
        FuncionEntity funcion = funLogic.addPelicula(funId, pelicula);
        pelicula.addFuncion(funcion);
        persistence.update(pelicula); // NO ESTOY SEGURO SI SE DEBE PONER ESE UPDATE
        return pelicula;
    }
    
    public List<FuncionEntity> getFunciones(Long id) throws BusinessLogicException {
        PeliculaEntity pelicula = getPelicula(id);
        List<FuncionEntity> pelis = pelicula.getFunciones();
        if (pelis == null) {
            throw new BusinessLogicException("La película no tiene una lista de funciones");
        }
        return pelis;
    }
    
    public FuncionEntity getFuncion(Long peliculaId, Long funcionId) throws BusinessLogicException {

        PeliculaEntity pelicula = getPelicula(peliculaId);
        List<FuncionEntity> funciones = getFunciones(peliculaId);
        FuncionEntity borrador = new FuncionEntity();
        borrador.setId(funcionId);
        int index = funciones.indexOf(borrador);
        if (index >= 0) {
            return funciones.get(index);
        }
        throw new BusinessLogicException("no existe la función con id " + funcionId + " asignada al pelicula con id " + peliculaId);
    }
}
