/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;

import co.edu.uniandes.ergo.festival.entities.PatrocinadorEntity;
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
public class PatrocinadorPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(PatrocinadorPersistence.class.getName());
    @PersistenceContext(unitName = "festivalPU")
    protected EntityManager em;
    /**
     * Método que crea un Patrocinador.
     * @param nuevo PatrocinadorEntity, Información del Patrocinador a crear.
     * @return PatrocinadorEntity, Patrocinador creado.
     */
    public PatrocinadorEntity create(PatrocinadorEntity nuevo) {
        LOGGER.log(Level.INFO, "Creando patrocinador {0}", nuevo.getId());
        em.persist(nuevo);
        LOGGER.log(Level.INFO, "Patrocinador {0} creado exitosamente", nuevo.getId());
        return nuevo;
    }
    /**
     * Método que obtiene una Lista con todos los Patrocinadores.
     * @return List<PatrocinadorEntity>, Lista con todos los Patrocinadores.
     */
    public List<PatrocinadorEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando salas" );
        TypedQuery<PatrocinadorEntity> tq = em.createQuery("SELECT p FROM PatrocinadorEntity p", PatrocinadorEntity.class);
        List<PatrocinadorEntity> result = tq.getResultList();
        LOGGER.log(Level.INFO, "{0} Patrocinadores encontrados con exito", result.size());
        return result;
    }
    /**
     * Método que obtiene un Patrocinador según su ID.
     * @param id Long, ID del Patrocinador a buscar.
     * @return PatrocinadorEntity, Información del Patrocinador buscado.
     */
    public PatrocinadorEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando salas");
        PatrocinadorEntity resultado = em.find(PatrocinadorEntity.class, id);
        LOGGER.log(Level.INFO, "Patrocinador {0} encontrado con exito", id);
        return resultado;
    }
    /**
     * Método que actualiza un Patrocinador.
     * @param nuevo PatrocinadorEntity, nueva información del Patrocinador.
     * @return PatrocinadorEntity, nueva información del Patrocinador.
     */
    public PatrocinadorEntity update(PatrocinadorEntity nuevo) {
        LOGGER.log(Level.INFO, "Consultando salas");
        em.merge(nuevo);
        LOGGER.log(Level.INFO, "Patrocinador {0} encontrado con exito", nuevo.getId());
        return em.find(PatrocinadorEntity.class, nuevo.getId());
    }
    /**
     * Método que borra un Patrocinador según su ID.
     * @param id Long, ID del Patrocinador a eliminar.
     */
    public void remove(Long id) {
        LOGGER.log(Level.INFO, "Consultando salas");
        em.remove(em.find(PatrocinadorEntity.class, id));
        LOGGER.log(Level.INFO, "Patrocinador {0} removido con exito", id);
    }
}
