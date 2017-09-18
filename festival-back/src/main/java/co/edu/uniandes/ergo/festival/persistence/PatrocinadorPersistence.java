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
    
    private static final Logger LOGGER = Logger.getLogger(BoletaPersistence.class.getName());
    @PersistenceContext(unitName = "festivalPU")
    protected EntityManager em;
    
    public PatrocinadorEntity create(PatrocinadorEntity nuevo) {
        LOGGER.log(Level.INFO, "Creando patrocinador {0}", nuevo.getId());
        em.persist(nuevo);
        LOGGER.log(Level.INFO, "Patrocinador {0} creado exitosamente", nuevo.getId());
        return nuevo;
    }
    
    public List<PatrocinadorEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando patrocinadores" );
        TypedQuery<PatrocinadorEntity> tq = em.createQuery("SELECT p FROM Patrocinadores p", PatrocinadorEntity.class);
        List<PatrocinadorEntity> result = tq.getResultList();
        LOGGER.log(Level.INFO, "{0} Patrocinadores encontrados con exito", result.size());
        return result;
    }
    
    public PatrocinadorEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando patrocinadores");
        PatrocinadorEntity resultado = em.find(PatrocinadorEntity.class, id);
        LOGGER.log(Level.INFO, "Patrocinador {0} encontrado con exito", id);
        return resultado;
    }
    
    public PatrocinadorEntity update(PatrocinadorEntity nuevo) {
        LOGGER.log(Level.INFO, "Consultando patrocinadores");
        em.merge(nuevo);
        LOGGER.log(Level.INFO, "Patrocinador {0} encontrado con exito", nuevo.getId());
        return em.find(PatrocinadorEntity.class, nuevo.getId());
    }
    
    public void remove(Long id) {
        LOGGER.log(Level.INFO, "Consultando patrocinadores");
        em.remove(em.find(PatrocinadorEntity.class, id));
        LOGGER.log(Level.INFO, "Patrocinador {0} removido con exito", id);
    }
}
