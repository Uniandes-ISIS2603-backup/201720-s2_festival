/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;

import co.edu.uniandes.ergo.festival.entities.SillaEntity;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 *
 * @author f.reyes948
 */
@Stateless
public class SillaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(SillaPersistence.class.getName());
    
    @PersistenceContext(unitName = "festivalPU")
    protected EntityManager em;
    
    /**
     * Crea una nueva silla.
     * @param entity Entidad de la silla a crear.
     * @return La entidad con el id.
     */
    public SillaEntity create(SillaEntity entity){
        LOGGER.log(Level.INFO, "Creando la silla nueva.");
        
        em.persist(entity);
        
        LOGGER.log(Level.INFO, "Silla nueva creada.");
        
        return entity;
    }
    
    /**
     * Busca una silla con el id especificado.
     * @param id El id de la silla en la base de datos.
     * @return La silla buscada.
     */
    public SillaEntity find(Long id){
        LOGGER.log(Level.INFO, "Buscando silla con id: {0}", id);
        
        return em.find(SillaEntity.class, id);
    }
    
    /**
     * Consulta todas las sillas del festival.
     * @return Una List con las sillas.
     */
    public List<SillaEntity> findAll(){
        LOGGER.log(Level.INFO, "Buscando todas las sillas.");
        
        TypedQuery query = em.createQuery("select u from SillaEntity u", SillaEntity.class);
        
        return query.getResultList();
    }
    
    /**
     * Actualiza la información de una silla en la base de datos.
     * @param entity La silla a actualizar.
     * @return La silla actualizada.
     */
    public SillaEntity update(SillaEntity entity){
        LOGGER.log(Level.INFO, "Actualizando silla con id: {0}", entity.getId());
        
        return em.merge(entity);
    }
    
    /**
     * Elimina la silla con el id dado.
     * @param id El id de la silla a eliminar.
     */
    public void delete(Long id){
        LOGGER.log(Level.INFO, "Borrando la silla con id: {0}", id);
        
        em.remove(em.find(SillaEntity.class, id));
    }
}
