/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;


import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.entities.CriticaEntity;
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
    /**
     * Método que crea una Función.
     * @param entity FuncionEntity, información de una Función.
     * @return FuncionEntity, Función agregada.
     */
     public FuncionEntity create(FuncionEntity entity){
        LOGGER.log(Level.INFO, "Creando una Funcion nueva.");
        
        em.persist(entity);
        
        LOGGER.log(Level.INFO, "Silla nueva creada.");
        
        return entity;
    }
    /**
     * Método que obtiene una Función según su ID.
     * @param id Long, ID de la función.
     * @return FuncionEntity, Información de la Función.
     */
    public FuncionEntity find(Long id){
        LOGGER.log(Level.INFO, "Buscando Funcion con id: {0}", id);
        
        return em.find(FuncionEntity.class, id);
    }
    /**
     * Método que obtiene una Lista con todas las Funciones.
     * @return  List<FuncionEntity>, Lista con todas las Funciones.
     */
    public List<FuncionEntity> findAll(){
        LOGGER.log(Level.INFO, "Buscando todas las Funciones.");
        
        TypedQuery query = em.createQuery("select u from FuncionEntity u", FuncionEntity.class);
        
        return query.getResultList();
    }
    /**
     * Método que actualizar una Función.
     * @param entity FuncionEntity, nueva información de la Función.
     * @return FuncionEntity, información actualizada de la Función.
     */
    public FuncionEntity update(FuncionEntity entity){
        LOGGER.log(Level.INFO, "Actualizando Funcion con id: {0}", entity.getId());
        
        return em.merge(entity);
    }
    /**
     * Método que borra una Función.
     * @param id Long, ID de la Función a borrar.
     * @return FuncionEntity, Función Borrada.
     */
    public FuncionEntity delete(Long id){
        LOGGER.log(Level.INFO, "Borrando la Funcion con id: {0}", id);
        FuncionEntity ent = em.find(FuncionEntity.class, id);
        em.remove(ent);
        return ent;
    }
    /**
     * Método que obtiene las Críticas de una Función.
     * @param entity FuncionEntity, Información de la función cuyas críticas de desea buscar.
     * @return List<CriticaEntity>, Lista con la Críticas de la Función.
     */
    public List<CriticaEntity> getCriticas(FuncionEntity entity) {
        LOGGER.log(Level.INFO, "Getting all criticas from function");        
        TypedQuery query = em.createQuery("SELECT c FROM CriticaEntity c WHERE c.funcion= :id",CriticaEntity.class);
        query.setParameter("id", entity);
        return query.getResultList();
    }
    /**
     * Metodo que obtiene una Crítica específica de una Función.
     * @param entity FuncionEntity, información de la Función cuya crítica se desea buscar.
     * @param idCritica Long, ID de la Crítica a buscar.
     * @return CriticaEntity, información de la Crítica buscada.
     */
    public CriticaEntity getCritica(FuncionEntity entity, Long idCritica) {
        LOGGER.log(Level.INFO, "Getting a particular critica from function");  
        TypedQuery query = em.createQuery("SELECT c FROM CriticaEntity c WHERE c.funcion= :idFunc AND c.id = :idCrit",CriticaEntity.class);
        query.setParameter("idFunc", entity);
        query.setParameter("idCrit", idCritica);
        return (CriticaEntity) query.getSingleResult();
    }
    /**
     * Método que obtiene las Boletas de una Función.
     * @param entity FuncionEntity, Información de la Función cuyas Boletas se desean obtener.
     * @return List<BoletaEntity>, Lista de Boletas de la Función.
     */
    public List<BoletaEntity> getBoletas(FuncionEntity entity) {
        LOGGER.log(Level.INFO, "Getting all boletas from function");   
        TypedQuery query = em.createQuery("SELECT b FROM BoletaEntity b WHERE b.funcion= :id",BoletaEntity.class);
        query.setParameter("id", entity);
        return query.getResultList();
    }
    /**
     * Método que obtiene una Boleta específica de una Función.
     * @param entity FuncionEntity, Información de la Función cuya Boleta se desea consultar.
     * @param idBoleta Long, ID de la Boleta a consultar.
     * @return BoletaEntity, Información de la Boleta consultada.
     */
    public BoletaEntity getBoleta(FuncionEntity entity, Long idBoleta) {
        LOGGER.log(Level.INFO, "Getting a particular boleta from function");  
        TypedQuery query = em.createQuery("SELECT b FROM BoletaEntity b WHERE b.funcion= :idFunc AND b.id = :idBol",BoletaEntity.class);
        query.setParameter("idFunc", entity);
        query.setParameter("idBol", idBoleta);
        return (BoletaEntity) query.getSingleResult();
    }    
}
