/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;

import co.edu.uniandes.ergo.festival.entities.TeatroEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author de.gutierrez
 */
@Stateless
public class TeatroPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(TeatroPersistence.class.getName());
    @PersistenceContext (unitName = "festivalPU")
    protected EntityManager em;
    
    /**
     * Creacia un nuevo teatro
     * @param entity objeto Teatro que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public TeatroEntity create(TeatroEntity entity)
    {
        LOGGER.info("Creando un teatro");
        em.persist(entity);
        LOGGER.info("Creando el tetro");
        return entity;
    }
    
    /**
     * Busca el teatro con id que se envia por parametro
     * @param id correspondiente al teatro buscado.
     */
    public TeatroEntity find (Long id)
    {
        LOGGER.log(Level.INFO, "Obteniendo teatro por el id", id);
        return em.find(TeatroEntity.class, id);
    }
    
    /**
     * Devuelve todos los teatros de la base de datos
     * @return una lista con todos los teatros
     */
    public List<TeatroEntity> findAll()
    {
         LOGGER.info("Consultando todos los teatros");
         TypedQuery query = em.createQuery("select u from TeatroEntity u", TeatroEntity.class);
         return query.getResultList();
    }
    
    /**
     * A ctualiza la informacion de un teatro
     * @param  entity: El teatro que va actualizar
     *@return el teatro actualizado
     */
    public TeatroEntity update(TeatroEntity entity)
    {
       LOGGER.log(Level.INFO, "Actualizando teatro", TeatroEntity.class);
       return em.merge(entity);
    }
    
    /**
     * Elimina un teatro con el id que se envia por parametro
     * @param  id: id correspondiente al teatro a eliminar
     */
    public void delete(Long id)
    {
        LOGGER.log(Level.INFO,"Eliminando teatro", TeatroEntity.class);
        TeatroEntity entity = find(id);
        
        em.remove(entity);
    }
}
