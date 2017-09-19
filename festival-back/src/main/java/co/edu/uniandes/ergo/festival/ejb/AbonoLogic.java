/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;


//import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.entities.AbonoEntity;
import co.edu.uniandes.ergo.festival.entities.EspectadorEntity;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
//import co.edu.uniandes.ergo.festival.persistence.BoletaPersistence;
import co.edu.uniandes.ergo.festival.persistence.AbonoPersistence;
import co.edu.uniandes.ergo.festival.persistence.EspectadorPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 *
 * @author jc.corrales
 */
@Stateless
public class AbonoLogic
{
    private static final Logger LOGGER = Logger.getLogger(AbonoLogic.class.getName());
    @Inject
    private AbonoPersistence persistenceAbono;// Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
    //@Inject
    //private BoletaPersistence persistenceBoleta;
    
    /**
     * Método que crea un Abono nueva.
     * @param entity, AbonoEntity, Abono a introducir en la Base de datos
     * @return AbonoEntity, Abono creada.
     * @throws BusinessLogicException 
     */
    public AbonoEntity createAbono(AbonoEntity entity)throws BusinessLogicException
    {
        LOGGER.info("Inicia proceso de creación de Abono");
        // Verifica la regla de negocio que dice que no puede haber dos cityes con el mismo nombre        
        // Invoca la persistencia para crear el Abono.
        persistenceAbono.create(entity);
        LOGGER.info("Termina proceso de creación de Abono");
        return entity;
    }
    /**
     * Método que obtiene todas los abonos en el sistema.
     * @return List<AbonoEntity> Lista que contiene los Abonos.
     */
    public List<AbonoEntity> getAbonos()
    {
        LOGGER.info("Inicia proceso de consultar todos los Abonos");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<AbonoEntity> abonos = persistenceAbono.findAll();
        LOGGER.info("Termina proceso de consultar todos los Abonos");
        return abonos;
    }
    /**
     * Método que obtiene un Abono con ID dado.
     * @param pID Long, id del Abono.
     * @return AbonoEntity, Abono que se busca.
     */
    public AbonoEntity getAbono(Long pID)
    {
        return persistenceAbono.find(pID);
    }
    /**
     * Método que actualiza un Abono.
     * @param id Long, id del abono.
     * @param entity AbonoEntity, Abono con información nueva.
     * @return AbonoEntity, Abono actualizado.
     * @throws BusinessLogicException 
     */
    public AbonoEntity updateAbono(Long id, AbonoEntity entity) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar editorial con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        AbonoEntity newEntity = persistenceAbono.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar editorial con id={0}", entity.getId());
        return newEntity;
    }
    /**
     * Método que elimina un Abono.
     * @param id Long, id del abono.
     * @throws BusinessLogicException
     */
    public void deleteAbono(Long id)throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar abono con id={0}",id);
        persistenceAbono.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar abono con id={0}",id);
    }
}
