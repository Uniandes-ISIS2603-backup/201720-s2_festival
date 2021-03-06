/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;

import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
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
public class BoletaPersistence
{
    private static final Logger LOGGER = Logger.getLogger(BoletaPersistence.class.getName());
    
    @PersistenceContext(unitName = "festivalPU")
    protected EntityManager em;
    /**
     * Método que crea una Boleta nueva en la base de datos.
     * @param entity BoletaEntity
     * @return BoletaEntity
     */
    public BoletaEntity create(BoletaEntity entity)
    {
        LOGGER.log(Level.INFO, "Creando una Boleta nueva.");
        em.persist(entity);
        LOGGER.log(Level.INFO, "Boleta nueva creada.");
        return entity;
    }
    
    /**
     * Busca una Boleta con el id especificado.
     * @param id Long, ID de la boleta.
     * @return BoletaEntity
     */
    public BoletaEntity find(Long id){
        LOGGER.log(Level.INFO, "Buscando Boleta con id: {0}", id);
        
        return em.find(BoletaEntity.class, id);
    }
    /**
     * Método que obtiene una Boleta según su código de Barras.
     * @param codigoDeBarras Long, Código de Baras de la Boleta.
     * @return BoletaEntity, la Boleta con el código de Barras dado.
     */
    public BoletaEntity findByCode(Long codigoDeBarras)
    {
        LOGGER.log(Level.INFO, "Consultando Boleta por codigo ", codigoDeBarras);

        // Se crea un query para buscar cityes con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From BoletaEntity e where e.codigoDeBarras = :codigoDeBarras", BoletaEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("codigoDeBarras", codigoDeBarras);
        // Se invoca el query se obtiene la lista resultado
        List<BoletaEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }
    /**
     * Método que retorna todos las boletas.
     * @return List<BoletaEntity> Lista de boletas
     */
    public List<BoletaEntity> findAll(){
        LOGGER.log(Level.INFO, "Buscando todas las boletas.");
        
        TypedQuery query = em.createQuery("select u from BoletaEntity u", BoletaEntity.class);
        
        return query.getResultList();
    }
    /**
     * Método que actualiza una Boleta.
     * @param entity BoletaEntity, Boleta a actualizar.
     * @return BoletaEntity, Boleta actualizado
     */
    public BoletaEntity update(BoletaEntity entity){
        LOGGER.log(Level.INFO, "Actualizando Boleta con id: {0}", entity.getId());
        
        return em.merge(entity);
    }
    /**
     * Método que elimina una Boleta de la base de datos.
     * @param id Long, ID de la Boleta a eliminar.
     */
    public void delete(Long id){
        LOGGER.log(Level.INFO, "Borrando la Boleta con id: {0}", id);
        
        em.remove(em.find(BoletaEntity.class, id));
    }
}
