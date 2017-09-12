/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;


import co.edu.uniandes.ergo.festival.entities.FuncionEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author m.neira10
 */
@Stateless
public class FuncionPersistence {
     private static final Logger LOGGER = Logger.getLogger(SillaPersistence.class.getName());
    
    @PersistenceContext(unitName = "festivalPU")
    protected EntityManager em;
    
     public FuncionEntity create(FuncionEntity entity){
        LOGGER.log(Level.INFO, "Creando una Funcion nueva.");
        
        em.persist(entity);
        
        LOGGER.log(Level.INFO, "Silla nueva creada.");
        
        return entity;
    }
    
    public FuncionEntity find(Long id){
        LOGGER.log(Level.INFO, "Buscando Funcion con id: {0}", id);
        
        return em.find(FuncionEntity.class, id);
    }
    
    public List<FuncionEntity> findAll(){
        LOGGER.log(Level.INFO, "Buscando todas las Funciones.");
        
        TypedQuery query = em.createQuery("select u from FuncionEntity u", FuncionEntity.class);
        
        return query.getResultList();
    }
    public FuncionEntity update(FuncionEntity entity){
        LOGGER.log(Level.INFO, "Actualizando Funcion con id: {0}", entity.getId());
        
        return em.merge(entity);
    }
    
    public FuncionEntity delete(Long id){
        LOGGER.log(Level.INFO, "Borrando la Funcion con id: {0}", id);
        FuncionEntity ent = em.find(FuncionEntity.class, id);
        em.remove(ent);
        return ent;
    }
    
    
}
