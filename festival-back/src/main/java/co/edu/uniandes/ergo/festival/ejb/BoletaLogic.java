/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;


import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.entities.EspectadorEntity;
import co.edu.uniandes.ergo.festival.entities.SillaEntity;
import co.edu.uniandes.ergo.festival.entities.CalificacionEntity;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import co.edu.uniandes.ergo.festival.persistence.BoletaPersistence;
import co.edu.uniandes.ergo.festival.persistence.EspectadorPersistence;
import co.edu.uniandes.ergo.festival.persistence.SillaPersistence;
import co.edu.uniandes.ergo.festival.persistence.CalificacionPersistence;
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
public class BoletaLogic
{
    private static final Logger LOGGER = Logger.getLogger(BoletaLogic.class.getName());

    @Inject
    private BoletaPersistence persistenceBoleta;// Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
    
    @Inject
    private EspectadorPersistence persistenceEspectador;
    
    @Inject
    private SillaPersistence persistenceSilla;
    /**
     * Método que crea una boleta nueva.
     * @param entity, BoletaEntity, Boleta a introducir en la Base de datos
     * @return BoletaEntity, boleta creada.
     * @throws BusinessLogicException 
     */
    public BoletaEntity createBoleta(BoletaEntity entity)throws BusinessLogicException
    {
        LOGGER.info("Inicia proceso de creación de Boleta");
        // Verifica la regla de negocio que dice que no puede haber dos cityes con el mismo nombre
        if(entity.getCodigoBarras() == null)
        {
            throw new BusinessLogicException("La boleta no tiene un código asignado \"" + entity.getCodigoBarras()+"\"");
        }
        if(persistenceBoleta.findByCode(entity.getCodigoBarras()) != null)
        {
            throw new BusinessLogicException("Ya existe una Boleta con el código de barras \"" + entity.getCodigoBarras()+"\""); 
        }
        //if(entity.getEspectador() == null)
            //throw new BusinessLogicException("La boleta no tiene un Espectador asignado \"" + entity.getEspectador()+"\"");
        //if (persistenceEspectador.find(entity.getEspectador().getId())== null)
            //throw new BusinessLogicException("No existe el Espectador \"" + entity.getEspectador()+"\"");
        //if(persistenceSilla.find(entity.getSilla().getId()) == null)
            //throw new BusinessLogicException("No existe la Silla\""+entity.getSilla()+"\"");
        
        // Invoca la persistencia para crear la boleta
        persistenceBoleta.create(entity);
        LOGGER.info("Termina proceso de actualizacion de Boleta");
        return entity;
    }
    /**
     * Método que obtiene todas las boletas en el sistema.
     * @return List<BoletaEntity> Lista que contiene las boletas.
     */
    public List<BoletaEntity> getBoletas()
    {
        LOGGER.info("Inicia proceso de consultar todas las Boletas");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<BoletaEntity> boletas = persistenceBoleta.findAll();
        LOGGER.info("Termina proceso de consultar todas las Boletas");
        return boletas;
    }
    /**
     * Método que obtiene una boleta con ID dado.
     * @param pID Long, id de la Boleta.
     * @return BoletaEntity, Boleta que se busca.
     */
    public BoletaEntity getBoleta(Long pID)
    {
        return persistenceBoleta.find(pID);
    }
    /**
     * Método que actualiza una boleta.
     * @param id Long, id de la boleta.
     * @param entity BoletaEntity, Boleta con información nueva.
     * @return BoletaEntity, Boleta actualizada.
     * @throws BusinessLogicException 
     */
    public BoletaEntity updateBoleta(Long id, BoletaEntity entity) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar boleta con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        if(persistenceBoleta.findByCode(entity.getCodigoBarras()) != null)
        {
            throw new BusinessLogicException("Ya existe una Boleta con el código de barras \"" + entity.getCodigoBarras()+"\""); 
        }
        BoletaEntity newEntity = persistenceBoleta.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar editorial con id={0}", entity.getId());
        return newEntity;
    }
    /**
     * Método que elimina una boleta.
     * @param entity BoletaEntity, Boleta a eliminar.
     * @throws BusinessLogicException
     */
    public void deleteBoleta(Long id)throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar boleta con id={0}",id);
        persistenceBoleta.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar boleta con id={0}",id);
    }
    /**
     * Método que obtiene una boleta con un código dado.
     * @param codigoBarras, Long, código de la boleta a buscar.
     * @return BoletaEntity, entidad de la boleta buscada.
     */
    public BoletaEntity getBoletaPorCodigo(Long codigoBarras)
    {
        return persistenceBoleta.findByCode(codigoBarras);
    }
}
