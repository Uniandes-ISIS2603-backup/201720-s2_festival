/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;

import co.edu.uniandes.ergo.festival.entities.SalaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 *
 * @author f.mayenberger10
 */
@Stateless
public class SalaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(BoletaPersistence.class.getName());
    @PersistenceContext(unitName = "festivalPU")
    protected EntityManager em;
    
    /**
     * 
     * @param nueva sala a crear
     * @return entity de la sala creada
     */
    public SalaEntity create(SalaEntity nueva) {
        LOGGER.log(Level.INFO, "Creando sala {0}", nueva.getId());
        em.persist(nueva);
        LOGGER.log(Level.INFO, "Sala {0} creada exitosamente", nueva.getId());
        return nueva;
    }
    
    /**
     * 
     * @return lista de todas las salas
     */
    public List<SalaEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando salas" );
        TypedQuery<SalaEntity> tq = em.createQuery("SELECT s FROM SalaEntity s", SalaEntity.class);
        List<SalaEntity> result = tq.getResultList();
        LOGGER.log(Level.INFO, "{0} Salas encontradas con exito", result.size());
        return result;
    }
    
    /**
     * 
     * @param id de la sala buscada
     * @return sala buscada
     */
    public SalaEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando salas");
        SalaEntity resultado = em.find(SalaEntity.class, id);
        LOGGER.log(Level.INFO, "Sala {0} encontrada con exito", id);
        return resultado;
    }
    
    /**
     * 
     * @param nueva SalaEntity a updatear
     * @return SalaEntity updateada
     */
    public SalaEntity update(SalaEntity nueva) {
        LOGGER.log(Level.INFO, "Consultando salas");
        em.merge(nueva);
        LOGGER.log(Level.INFO, "Sala {0} encontrada con exito", nueva.getId());
        return em.find(SalaEntity.class, nueva.getId());
    }
    
    /**
     * 
     * @param id de la Sala a remover
     */
    public void remove(Long id) {
        LOGGER.log(Level.INFO, "Consultando salas");
        em.remove(em.find(SalaEntity.class, id));
        LOGGER.log(Level.INFO, "Sala {0} removida con exito", id);
    }
}
