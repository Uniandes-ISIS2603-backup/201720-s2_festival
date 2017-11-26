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
    private PeliculaLogic peliLogic;

    @Inject
    private CriticoPersistence persistence;
    /**
     * Método que obtiene una Lista con todos los críticos.
     * @return List<CriticoEntity>, Lista con todos los Críticos.
     */
    public List<CriticoEntity> getCriticos() {
        LOGGER.info("Inicia el proceso de consultar todas los críticos.");
        List<CriticoEntity> criticos = persistence.findAll();
        LOGGER.info("Termina el proceso de consultar todas los críticos.");
        return criticos;
    }
    /**
     * Metodo que obtiene un Crítico según su ID.
     * @param id Long, ID del Crítico.
     * @return CriticoEntity, información del Crítico.
     */
    public CriticoEntity getCritico(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el crítico con id={0}", id);

        CriticoEntity critico = persistence.find(id);

        if (critico == null) {
            LOGGER.log(Level.SEVERE, "La película con el id {0} no existe", id);
        }

        LOGGER.log(Level.INFO, "Termina proceso de consultar el crítico con id={0}", id);
        return critico;
    }
    /**
     * Método que crea un nuevo Crítico.
     * @param nueva CriticoEntity, información del Crítico.
     * @return CriticoEntity, Crítico recientemente agregado.
     * @throws BusinessLogicException 
     */
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
    /**
     * Método que actualiza un Crítico.
     * @param id Long, ID del Crítico a actualizar.
     * @param entity CriticoEntity, nueva información del Crítico.
     * @return CriticoEntity, Información del Crítico actualizada.
     * @throws BusinessLogicException 
     */
    public CriticoEntity updateCritico(Long id, CriticoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar libro con id={0}", id);
        if (persistence.find(id) == null) {
            throw new BusinessLogicException("No se encuentra el crítico con el id " + id + " ");
        }
        CriticoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el crítico con id={0}", entity.getId());
        return newEntity;
    }
    /**
     * Método que borra un Crítico según su ID.
     * @param id Long, ID del Crítico a Borrar.
     */
    public void deleteCritico(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el crítico con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar el crítico con id={0}", id);
    }
    /**
     * Método que obtiene las Películas de un Crítico.
     * @param id Long, ID del Critico cuyas Películas se desea obtener.
     * @return List<PeliculaEntity>, Lista de las Películas del Crítico.
     * @throws BusinessLogicException 
     */
    public List<PeliculaEntity> getPeliculas(Long id) throws BusinessLogicException {
        CriticoEntity elCri = getCritico(id);
        List<PeliculaEntity> pelis = elCri.GetPeliculas();
        if (pelis == null) {
            throw new BusinessLogicException("EL crítico no tiene una lista de películas");
        }
        return pelis;
    }
    /**
     * Método que obtiene una Película del Crítico.
     * @param criticoId Long, ID del Crítico.
     * @param pelId Long, ID de la Película.
     * @return PeliculaEntity, una Película del Crítico.
     * @throws BusinessLogicException 
     */
    public PeliculaEntity getPelicula(Long criticoId, Long pelId) throws BusinessLogicException {

        CriticoEntity elCri = getCritico(criticoId);
        List<PeliculaEntity> pelis = getPeliculas(criticoId);
        PeliculaEntity borrador = new PeliculaEntity();
        borrador.setId(criticoId);
        int index = pelis.indexOf(borrador);
        if (index >= 0) {
            return pelis.get(index);
        }
        throw new BusinessLogicException("no existe la película con id " + pelId + " asignada al critico con id " + criticoId);
    }
    /**
     * Método que asocia una Película a un Crítico.
     * @param crId Long, ID del Crítico.
     * @param pelId Long, ID de la Película.
     * @return PeliculaEntity, Película asociada.
     * @throws BusinessLogicException 
     */
    public PeliculaEntity addPelicula(Long crId, Long pelId) throws BusinessLogicException {
        CriticoEntity critico = getCritico(crId);
        LOGGER.log(Level.INFO, "Inicia proceso de asociar la película con id ={0}", pelId);
        PeliculaEntity peli = peliLogic.addCritico(pelId, critico);
        critico.addPelicula(peli);
        persistence.update(critico); // NO ESTOY SEGURO SI SE DEBE PONER ESE UPDATE
        return peli;
    }
    /**
     * Método que remueve una Película de un Crítico.
     * @param crId Long, ID del Crítico.
     * @param pelId Long, ID de la Película.
     * @throws BusinessLogicException 
     */
    public void removePelicula(Long crId, Long pelId) throws BusinessLogicException {
        CriticoEntity critico = getCritico(crId);
        LOGGER.log(Level.INFO, "Inicia proceso de desaosociar la película con id ={0}", pelId);
        peliLogic.removeCritico(pelId, crId);
    }

}
