/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;

import co.edu.uniandes.ergo.festival.entities.PeliculaEntity;
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
public class PeliculaPersistence {

    private static final Logger LOGGER = Logger.getLogger(PeliculaPersistence.class.getName());


    @PersistenceContext(unitName = "festivalPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto Pelicula que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public PeliculaEntity create(PeliculaEntity entity) {
        LOGGER.info("Creando una película nueva.");
        em.persist(entity);
        return entity;
    }

    /**
     * Actualiza un pelicula.
     *
     * @param entity: la Pelicula que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un pelicula con los cambios aplicados.
     */
    public PeliculaEntity update(PeliculaEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando Pelicula con id={0}", entity.getId());
        return em.merge(entity);
    }

    /**
     *
     * Borra un pelicula de la base de datos recibiendo como argumento el id de
     * la Pelicula
     *
     * @param id: id correspondiente al Pelicula a borrar.
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando Pelicula con id={0}", id);
        PeliculaEntity entity = em.find(PeliculaEntity.class, id);
        em.remove(entity);
    }

    /**
     * Busca si hay algun pelicula con el id que se envía de argumento
     *
     * @param id: id correspondiente al Pelicula buscada.
     * @return un pelicula.
     */
    public PeliculaEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando Pelicula con id={0}", id);
        return em.find(PeliculaEntity.class, id);
    }

    /**
     * Devuelve todas lospeliculaes de la base de datos.
     *
     * @return una lista con todas lospeliculaes que encuentre en la base de
     * datos, "select u from PeliculaEntity u" es como un "select * from
     * PeliculaEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<PeliculaEntity> findAll() {
        LOGGER.info("Consultando todos los peliculaes");
        TypedQuery query = em.createQuery("select u from PeliculaEntity u", PeliculaEntity.class);
        return query.getResultList();
    }
    
        public PeliculaEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando pelicula por nombre={0}", name);
        TypedQuery<PeliculaEntity> q = em.createQuery("select u from PeliculaEntity u where u.name = :name", PeliculaEntity.class);
        q = q.setParameter("name", name);
        return q.getSingleResult();
    }
}
