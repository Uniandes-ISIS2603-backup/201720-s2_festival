/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;


import co.edu.uniandes.ergo.festival.entities.CalificacionEntity;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Level;
import javax.persistence.TypedQuery;

/**
 *
 * @author m.neira10
 */
@Stateless
public class CalificacionPersistence {
     private static final Logger LOGGER = Logger.getLogger(SillaPersistence.class.getName());
    
    @PersistenceContext(unitName = "festivalPU")
    protected EntityManager em;
    /**
     * Método que crea una nueva Calificación.
     * @param entity
     * @return 
     */
    public CalificacionEntity create(CalificacionEntity entity){
        LOGGER.log(Level.INFO, "Creando la calificacion nueva.");
        
        em.persist(entity);
        
        LOGGER.log(Level.INFO, "Silla nueva creada.");
        
        return entity;
    }
    /**
     * Método que busca una Calificación según su ID.
     * @param id Long ID de la Calificación a buscar.
     * @return CalificaciónEntity, Calificacion buscada.
     */
    public CalificacionEntity find(Long id){
        LOGGER.log(Level.INFO, "Buscando calificacion con id: ", id);
        
        return em.find(CalificacionEntity.class, id);
    }
    /**
     * Metodo que obtiene una Lista con todas las Calificaiones.
     * @return List<CalificacionEntity>, Lista de Calificaciones.
     */
    public List<CalificacionEntity> findAll(){
        LOGGER.log(Level.INFO, "Buscando todas las calificaciones.");
        
        TypedQuery query = em.createQuery("select u from CalificacionEntity u", CalificacionEntity.class);
        
        return query.getResultList();
    }
    /**
     * Método que actualiza una Calificación.
     * @param entity CalificacionEntity, nueva información de la Calificación.
     * @return CalificacionEntity, Calificación actualizada.
     */
    public CalificacionEntity update(CalificacionEntity entity){
        LOGGER.log(Level.INFO, "Actualizando calificacion con id: {0}", entity.getId());
        
        return em.merge(entity);
    }
    /**
     * Metodo que elimina una Calificación según su ID.
     * @param id Long, ID de la Calificación a borrar.
     * @return CalificacionEntity, Calificación Borrada.
     */
    public CalificacionEntity delete(Long id){
        LOGGER.log(Level.INFO, "Borrando la calificacion con id: ", id);
        CalificacionEntity ent =em.find(CalificacionEntity.class, id);
        em.remove(ent);
        return ent;
    }
}
