/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;

import co.edu.uniandes.ergo.festival.entities.CriticaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author f.reyes948
 */
@Stateless
public class CriticaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(CriticaPersistence.class.getName());
    
    @PersistenceContext(unitName = "festivalPU")
    protected EntityManager em;
    
    /**
     * Crea una nueva crítica.
     * @param entity Entidad de la crítica a crear.
     * @return La entidad con el id.
     */
    public CriticaEntity create(CriticaEntity entity){
        LOGGER.log(Level.INFO, "Creando la crítica nueva.");
        
        em.persist(entity);
        
        LOGGER.log(Level.INFO, "Crítica nueva creada.");
        
        return entity;
    }
    
    /**
     * Busca una crítica con el id especificado.
     * @param id El id de la crítica en la base de datos.
     * @return La crítica buscada.
     */
    public CriticaEntity find(Long id){
        LOGGER.log(Level.INFO, "Buscando crítica con id: {0}", id);
        
        return em.find(CriticaEntity.class, id);
    }
    
    /**
     * Consulta todas las críticas del festival.
     * @return Una List con las críticas.
     */
    public List<CriticaEntity> findAll(){
        LOGGER.log(Level.INFO, "Buscando todas las críticas.");
        
        TypedQuery query = em.createQuery("select u from CríticaEntity u", CriticaEntity.class);
        
        return query.getResultList();
    }
    
    /**
     * Actualiza la información de una crítica en la base de datos.
     * @param entity La crítica a actualizar.
     * @return La crítica actualizada.
     */
    public CriticaEntity update(CriticaEntity entity){
        LOGGER.log(Level.INFO, "Actualizando crítica con id: {0}", entity.getId());
        
        return em.merge(entity);
    }
    
    /**
     * Elimina la crítica con el id dado.
     * @param id El id de la crítica a eliminar.
     */
    public void delete(Long id){
        LOGGER.log(Level.INFO, "Borrando la crítica con id: {0}", id);
        
        em.remove(em.find(CriticaEntity.class, id));
    }
    
}
