/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;

import co.edu.uniandes.ergo.festival.entities.EspectadorEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author dj.bautista10
 */
@Stateless
public class EspectadorPersistence {

    private static final Logger LOGGER = Logger.getLogger(EspectadorPersistence.class.getName());

    @PersistenceContext(unitName = "espectadorPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto Espectador que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public EspectadorEntity create(EspectadorEntity entity) {
        LOGGER.info("Creando una película nueva.");
        em.persist(entity);
        return entity;
    }

    /**
     * Actualiza un espectador.
     *
     * @param entity: la Espectador que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un espectador con los cambios aplicados.
     */
    public EspectadorEntity update(EspectadorEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando Espectador con id={0}", entity.getId());
        return em.merge(entity);
    }

    /**
     *
     * Borra un espectador de la base de datos recibiendo como argumento el id de
     * la Espectador
     *
     * @param id: id correspondiente al Espectador a borrar.
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando Espectador con id={0}", id);
        EspectadorEntity entity = em.find(EspectadorEntity.class, id);
        em.remove(entity);
    }

    /**
     * Busca si hay algun espectador con el id que se envía de argumento
     *
     * @param id: id correspondiente al Espectador buscada.
     * @return un espectador.
     */
    public EspectadorEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando Espectador con id={0}", id);
        return em.find(EspectadorEntity.class, id);
    }

    /**
     * Devuelve todas losespectadores de la base de datos.
     *
     * @return una lista con todas losespectadores que encuentre en la base de
     * datos, "select u from EspectadorEntity u" es como un "select * from
     * EspectadorEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<EspectadorEntity> findAll() {
        LOGGER.info("Consultando todos los espectadores");
        TypedQuery query = em.createQuery("select u from EspectadorEntity u", EspectadorEntity.class);
        return query.getResultList();
    }
}