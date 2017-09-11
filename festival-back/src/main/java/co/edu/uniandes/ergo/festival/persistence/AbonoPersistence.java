/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;

import co.edu.uniandes.ergo.festival.entities.AbonoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 *
 * @author jc.corrales
 */
@Stateless
public class AbonoPersistence
{
    private static final Logger LOGGER = Logger.getLogger(AbonoPersistence.class.getName());
    
    @PersistenceContext(unitName = "festivalPU")
    protected EntityManager em;
    /**
     * Método que crea un abono nuevo en la base de datos.
     * @param entity AbonoEntity
     * @return AbonoEntity
     */
    public AbonoEntity create(AbonoEntity entity)
    {
        LOGGER.log(Level.INFO, "Creando un Abono nuevo.");
        em.persist(entity);
        LOGGER.log(Level.INFO, "Abono nuevo creado.");
        return entity;
    }
    
    /**
     * Busca un Abono con el id especificado.
     * @param id Long, ID del abono.
     * @return AbonoEntity
     */
    public AbonoEntity find(Long id){
        LOGGER.log(Level.INFO, "Buscando Abono con id: {0}", id);
        
        return em.find(AbonoEntity.class, id);
    }
    /**
     * Método que retorna todos los abonos.
     * @return List<AbonoEntity> Lista de Abonos
     */
    public List<AbonoEntity> findAll(){
        LOGGER.log(Level.INFO, "Buscando todos los abonos.");
        
        TypedQuery query = em.createQuery("select u from AbonoEntity u", AbonoEntity.class);
        
        return query.getResultList();
    }
    /**
     * Método que actualiza un Abono.
     * @param entity AbonoEntity, abono a actualizar.
     * @return AbonoEntity, Abono actualizado
     */
    public AbonoEntity update(AbonoEntity entity){
        LOGGER.log(Level.INFO, "Actualizando Abono con id: {0}", entity.getId());
        
        return em.merge(entity);
    }
    /**
     * Método que elimina un abono de la base de datos.
     * @param id Long, ID del abono a eliminar.
     */
    public void delete(Long id){
        LOGGER.log(Level.INFO, "Borrando el Abono con id: {0}", id);
        
        em.remove(em.find(AbonoEntity.class, id));
    }
}
