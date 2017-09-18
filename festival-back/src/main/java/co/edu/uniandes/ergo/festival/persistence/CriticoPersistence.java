/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;

import co.edu.uniandes.ergo.festival.entities.CriticoEntity;
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
public class CriticoPersistence {

    private static final Logger LOGGER = Logger.getLogger(CriticoPersistence.class.getName());

    @PersistenceContext(unitName = "festivalPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto Critico que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public CriticoEntity create(CriticoEntity entity) {
        LOGGER.info("Creando una película nueva.");
        em.persist(entity);
        return entity;
    }

    /**
     * Actualiza un critico.
     *
     * @param entity: la Critico que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un critico con los cambios aplicados.
     */
    public CriticoEntity update(CriticoEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando Critico con id={0}", entity.getId());
        return em.merge(entity);
    }

    /**
     *
     * Borra un critico de la base de datos recibiendo como argumento el id de
     * la Critico
     *
     * @param id: id correspondiente al Critico a borrar.
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando Critico con id={0}", id);
        CriticoEntity entity = em.find(CriticoEntity.class, id);
        em.remove(entity);
    }

    /**
     * Busca si hay algun critico con el id que se envía de argumento
     *
     * @param id: id correspondiente al Critico buscada.
     * @return un critico.
     */
    public CriticoEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando Critico con id={0}", id);
        return em.find(CriticoEntity.class, id);
    }

    /**
     * Devuelve todas loscriticoes de la base de datos.
     *
     * @return una lista con todas loscriticoes que encuentre en la base de
     * datos, "select u from CriticoEntity u" es como un "select * from
     * CriticoEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<CriticoEntity> findAll() {
        LOGGER.info("Consultando todos los criticoes");
        TypedQuery query = em.createQuery("select u from CriticoEntity u", CriticoEntity.class);
        return query.getResultList();
    }
}
