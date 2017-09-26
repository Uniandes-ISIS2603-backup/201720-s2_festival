/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;


import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.entities.EspectadorEntity;
import co.edu.uniandes.ergo.festival.entities.EspectadorEntity;
import co.edu.uniandes.ergo.festival.entities.SillaEntity;
import co.edu.uniandes.ergo.festival.entities.CalificacionEntity;
import co.edu.uniandes.ergo.festival.entities.FuncionEntity;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import co.edu.uniandes.ergo.festival.persistence.BoletaPersistence;
import co.edu.uniandes.ergo.festival.persistence.EspectadorPersistence;
import co.edu.uniandes.ergo.festival.persistence.SillaPersistence;
import co.edu.uniandes.ergo.festival.persistence.CalificacionPersistence;
import co.edu.uniandes.ergo.festival.persistence.FuncionPersistence;
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
    private SillaLogic logicSilla;
    @Inject
    private SillaPersistence persistenceSilla;
    @Inject
    private FuncionPersistence persistenceFuncion;
    
    @Inject
    private CalificacionPersistence persistenceCalificacion;
    
   // @Inject
   // private CalificacionLogic calificacionLogic;
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
            throw new BusinessLogicException("La boleta no tiene un código asignado: \"" + entity.getCodigoBarras()+"\"");
        }
        if(persistenceBoleta.findByCode(entity.getCodigoBarras()) != null)
        {
            throw new BusinessLogicException("Ya existe una Boleta con el código de barras: \"" + entity.getCodigoBarras()+"\""); 
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
        LOGGER.severe("Buscando boleta con id m:" +pID);
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
     * @param id Long, ID de la boleta a eliminar.
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
    /**
     * Método que obtiene una silla asociada a una Boleta.
     * @param boletaId Long, ID de la boleta.
     * @return SillaEntity, Silla asociada.
     */
    public SillaEntity getSillaFromBoleta(Long boletaId)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una silla de la boleta con id = {0}", boletaId);
        SillaEntity respuesta = new SillaEntity();
        if(getBoleta(boletaId).getSilla() != null)
        {
            respuesta.setId(getBoleta(boletaId).getSilla().getId());
            respuesta.setTarifa(getBoleta(boletaId).getSilla().getTarifa());
            respuesta.setEsPreferencial(getBoleta(boletaId).getSilla().isEsPreferencial());
        }
        else
        {
            respuesta = null;
        }
        return respuesta;
    }
    /**
     * Método que asigna una silla a la boleta, la silla debe existir en la base de datos.
     * @param boletaId Long, ID de la boleta.
     * @param sillaId Long, ID de la Silla a asignar.
     * @return SillaEntity, Silla asignada.
     * @throws BusinessLogicException 
     */
        public SillaEntity addSillaFromBoleta(Long boletaId, Long sillaId)throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar una Silla de la Boleta con id = {0}", boletaId);
        BoletaEntity boletaEntity = getBoleta(boletaId);
        if(boletaEntity.getSilla() != null)
        {
            throw new BusinessLogicException("La Boleta con Id: \"" + boletaId +"\" ya tiene una silla asignada, usar el metodo PUT.");
        }
        if(logicSilla.getSilla(sillaId) == null)
        {
            throw new BusinessLogicException("La Silla con Id: \"" + sillaId +"\" no existe.");
        }
        boletaEntity.setSilla(logicSilla.getSilla(sillaId));
        
        LOGGER.log(Level.INFO, "Termina proceso de agregar silla de Boleta con id={0}", boletaEntity.getId());
        return boletaEntity.getSilla();
    }
    /**
     * Método que actualiza una silla de una boleta, la silla nueva debe existir.
     * @param boletaId Long, ID de la boleta.
     * @param sillaId Long, ID de la silla a asignar.
     * @return SillaEntity, Silla que acaba de ser asociada.
     * @throws BusinessLogicException 
     */
    public SillaEntity updateSillaFromBoleta(Long boletaId, Long sillaId)throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar una Silla de la Boleta con id = {0}", boletaId);
        BoletaEntity boletaEntity = getBoleta(boletaId);
        if(logicSilla.getSilla(sillaId) == null)
        {
            throw new BusinessLogicException("La Silla con Id: \"" + sillaId +"\" no existe.");
        }
        boletaEntity.setSilla(logicSilla.getSilla(sillaId));
        LOGGER.log(Level.INFO, "Termina proceso de actualizar silla de Boleta con id={0}", boletaEntity.getId());
        return boletaEntity.getSilla();
    }
    /**
     * Método que obtiene la funcion de una boleta.
     * @param boletaId Long, ID de la boleta.
     * @return FuncionEntity, la Funcion asociada.
     */
    public FuncionEntity getFuncionFromBoleta(Long boletaId)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una funcion de la boleta con id = {0}", boletaId);
        FuncionEntity respuesta = new FuncionEntity();
        if(getBoleta(boletaId).getFuncion() != null)
        {
            respuesta.setId(getBoleta(boletaId).getFuncion().getId());
        }
        else 
        {
            respuesta = null;
        }
        return respuesta;
    }
    /**
     * Método que asocia una Funcion a una Boleta, la función debe previamente existir.
     * @param boletaId Long, ID de la boleta.
     * @param funcionId Long, ID de la funcion.
     * @return FuncionEntity, Funcion que acaba de ser asociada.
     * @throws BusinessLogicException 
     */
    public FuncionEntity addFuncionFromBoleta(Long boletaId, Long funcionId)throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de agregar una funcion a la Boleta con id = {0}", boletaId);
        BoletaEntity boletaEntity = getBoleta(boletaId);
        if(boletaEntity.getFuncion() != null)
        {
            throw new BusinessLogicException("La Boleta con Id: \"" + boletaId +"\" ya tiene una funcion asignada, usar el metodo PUT.");
        }
        if(persistenceFuncion.find(funcionId) == null)
        {
            throw new BusinessLogicException("La Funcion con Id: \"" + funcionId +"\" no existe.");
        }
        boletaEntity.setFuncion(persistenceFuncion.find(funcionId));
        LOGGER.log(Level.INFO, "Termina proceso de agregar funcion de Boleta con id={0}", boletaEntity.getId());
        return boletaEntity.getFuncion();
    }
    /**
     * Método que actualiza la función de una boleta con otra, la nueva función DEBE existir previamente ne la base de datos.
     * @param boletaId Long, ID de la boleta.
     * @param funcionId Long,ID de la funcion a agregar.
     * @return FuncionEntity, funcion que acaba de ser asociada
     * @throws BusinessLogicException 
     */
    public FuncionEntity updateFuncionFromBoleta(Long boletaId, Long funcionId)throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una funcion a la Boleta con id = {0}", boletaId);
        BoletaEntity boletaEntity = getBoleta(boletaId);
        if(persistenceFuncion.find(funcionId) == null)
        {
            throw new BusinessLogicException("La Funcion con Id: \"" + funcionId +"\" no existe.");
        }
        boletaEntity.setFuncion(persistenceFuncion.find(funcionId));
        LOGGER.log(Level.INFO, "Termina proceso de agregar funcion de Boleta con id={0}", boletaEntity.getId());
        return boletaEntity.getFuncion();
    }
    
    
    /**
     * Método que obtiene la calificacion asociada a una boleta.
     * @param boletaId Long, ID de la boleta.
     * @return CalificaionEntity, Calificacion asociada a una boleta.
     */
    public CalificacionEntity getCalificacionFromBoleta(Long boletaId)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una calificacion de la boleta con id = {0}", boletaId);
        CalificacionEntity respuesta = new CalificacionEntity();
        respuesta.setId(getBoleta(boletaId).getCalificacion().getId());
        return respuesta;
    }
    /**
     * Método que agrega una calificacion a una boleta, la calificacion NO debe existir
     * @param boletaId Long, ID de la boleta para la cual crear una Calificacion asociada.
     * @param entity CalificacionEntity, calificacion nueva que se va a asociar con la boleta.
     * @return CalificacionEntity, calificacion que se acaba de ser creada Y asociada.
     * @throws BusinessLogicException 
     */
    public CalificacionEntity createCalificacionFromBoleta(Long boletaId, CalificacionEntity entity) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de agregar una calificacion que previamente no exite a la Boleta con id = {0}", boletaId);
        BoletaEntity boletaEntity = getBoleta(boletaId);
        if(boletaEntity.getCalificacion() != null)
        {
            throw new BusinessLogicException("La Boleta con Id: \"" + boletaId +"\" ya tiene una calificacion asignada, usar el metodo PUT.");
        }
        Long idCalificacionTemp = boletaEntity.getCalificacion().getId();
        persistenceCalificacion.create(entity);
        boletaEntity.setCalificacion(entity);
        persistenceCalificacion.delete(idCalificacionTemp);
        LOGGER.info("Termina proceso de actualizacion de Boleta");
        return entity; 
    }
    /**
     * Método que asocia una calificacion a una boleta, la calificacion DEBE existir previamente.
     * @param boletaId Long, ID de la boleta.
     * @param calificacionId Long, ID de la calificacion a asociar.
     * @return CalificacionEntity, calificacion que se acaba de asociar.
     * @throws BusinessLogicException 
     */
    public CalificacionEntity addCalificacionYaExistenteFromBoleta(Long boletaId, Long calificacionId) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de agregar una calificacion ya existente a la Boleta con id = {0}", boletaId);
        BoletaEntity boletaEntity = getBoleta(boletaId);
        if(boletaEntity.getCalificacion() != null)
        {
            throw new BusinessLogicException("La Boleta con Id: \"" + boletaId +"\" ya tiene una calificacion asignada, usar el metodo PUT.");
        }
        if(persistenceCalificacion.find(calificacionId) == null)
        {
            throw new BusinessLogicException("La Funcion con Id: \"" + calificacionId +"\" no existe, usar el metodo POST auxiliar y crear una calificacion alli");
        }
        boletaEntity.setCalificacion(persistenceCalificacion.find(calificacionId));
        LOGGER.log(Level.INFO, "Termina proceso de agregar una calificacion a Boleta con id={0}", boletaEntity.getId());
        return boletaEntity.getCalificacion();
    }
    /**
     * Método que reemplaza la calificacion asociada de una boleta con otra NUEVA que previamente NO existe en la base de datos.
     * @param boletaId Long, id de la boleta.
     * @param entity CalificacionEntity, calificacion nueva a asociar con la boleta.
     * @return CalificacionEntity, calificacion nueva recientemente asociada Y creada en la Base de Datos.
     * @throws BusinessLogicException 
     */
    public CalificacionEntity updateCreateCalificacionFromBoleta(Long boletaId, CalificacionEntity entity) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una calificacion que previamente no exite a la Boleta con id = {0}", boletaId);
        BoletaEntity boletaEntity = getBoleta(boletaId);
        if(boletaEntity.getCalificacion() == null)
        {
            throw new BusinessLogicException("La Boleta con Id: \"" + boletaId +"\" ya tiene una calificacion asignada, usar el metodo POST.");
        }
        persistenceCalificacion.create(entity);
        boletaEntity.setCalificacion(entity);
        LOGGER.info("Termina proceso de actualizacion de Boleta");
        return entity;
    }
    /**
     * Método que actualiza una calificacion de una boleta con otra que PREVIAMENTE existe en la base de datos.
     * @param boletaId Long, ID de la boleta.
     * @param calificacionId Long, ID de la calificacion a asociar.
     * @return CalificacionEntity, calificacion que se acaba de asociar.
     * @throws co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException
     */
    public CalificacionEntity updateCalificacionYaExistenteFromBoleta(Long boletaId, Long calificacionId) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una calificacion ya existente a la Boleta con id = {0}", boletaId);
        BoletaEntity boletaEntity = getBoleta(boletaId);
        if(boletaEntity.getCalificacion() == null)
        {
            throw new BusinessLogicException("La Boleta con Id: \"" + boletaId +"\" no tiene una calificacion asignada, usar el metodo POST.");
        }
        if(persistenceCalificacion.find(calificacionId) == null)
        {
            throw new BusinessLogicException("La Calificacion con Id: \"" + calificacionId +"\" no existe, usar el metodo POST auxiliar y crear una calificacion alli");
        }
        Long idEntityABorrar = boletaEntity.getCalificacion().getId();
        boletaEntity.setCalificacion(persistenceCalificacion.find(calificacionId));
        persistenceCalificacion.delete(idEntityABorrar);
        LOGGER.log(Level.INFO, "Termina proceso de agregar una calificacion a Boleta con id={0}", boletaEntity.getId());
        return boletaEntity.getCalificacion();
    }
    /**
     * Método que des asocia una calificaion de una boleta, este método BORRA la calificacion de la base de datos.
     * @param boletaId
     * @throws BusinessLogicException 
     */
    public void deleteCalificacionFromBoleta(Long boletaId) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una calificacion de la boleta con id = {0}", boletaId);
        BoletaEntity entity = getBoleta(boletaId);
        if(entity.getCalificacion() == null)
        {
            throw new BusinessLogicException("La Boleta con Id: \"" + boletaId +"\" no tiene una calificacion asociada.");
        }
        Long idCalificacionABorrar = entity.getCalificacion().getId();
        persistenceCalificacion.delete(idCalificacionABorrar);
        entity.setCalificacion(null);
    }
    /**
     * Método que obtiene el espectador asociad de una boleta.
     * @param boletaId Long, ID de la boleta.
     * @return EspectadorEntity.
     */
    public EspectadorEntity getEspectadorFromBoleta(Long boletaId)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una calificacion de la boleta con id = {0}", boletaId);
        EspectadorEntity respuesta = new EspectadorEntity();
        respuesta.setId(getBoleta(boletaId).getCalificacion().getId());
        return respuesta;
    }
    /**
     * Método que agrega un espectador PREVIAMENTE EXISTENTE a una boleta.
     * @param boletaId Long, ID de la boleta.
     * @param espectadorId Long, ID del espectador a asociar.
     * @return EspectadorEntity, Espectador que acaba de ser asociado.
     * @throws BusinessLogicException 
     */
    public EspectadorEntity addEspectadorFromBoleta(Long boletaId, Long espectadorId) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de agregar un Espectador de la Boleta con id = {0}", boletaId);
        BoletaEntity boletaEntity = getBoleta(boletaId);
        if(boletaEntity.getEspectador() != null)
        {
            throw new BusinessLogicException("La Boleta con Id: \"" + boletaId +"\" ya tiene un Espectador asignado, usar el metodo PUT.");
        }
        if(persistenceEspectador.find(espectadorId) == null)
        {
            throw new BusinessLogicException("El espectador con Id: \"" + espectadorId +"\" no existe.");
        }
        boletaEntity.setEspectador(persistenceEspectador.find(espectadorId));
        LOGGER.log(Level.INFO, "Termina proceso de agregar espectador de Boleta con id={0}", boletaId);
        return boletaEntity.getEspectador();
    }
    /**
     * Método que actualiza un espectador de una boleta, el espectador DEBE existir en la base de datos previamente.
     * @param boletaId Long, ID de la boleta.
     * @param espectadorId Long, ID del espectador a asociar.
     * @return EspectadorEntity, espectador que acaba de ser asociado a esta boleta.
     * @throws BusinessLogicException 
     */
    public EspectadorEntity updateEspectadorFromBoleta(Long boletaId, Long espectadorId) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar un Espectador de la Boleta con id = {0}", boletaId);
        BoletaEntity boletaEntity = getBoleta(boletaId);
        if(persistenceEspectador.find(espectadorId) == null)
        {
            throw new BusinessLogicException("El espectador con Id: \"" + espectadorId +"\" no existe.");
        }
        boletaEntity.setEspectador(persistenceEspectador.find(espectadorId));
        LOGGER.log(Level.INFO, "Termina proceso de agregar espectador de Boleta con id={0}", boletaEntity.getId());
        return boletaEntity.getEspectador();
    }
    /**
     * Mëtodo que des asocia un espectador de una Boleta, el espectador NO es borrado de la base de datos.
     * @param boletaId Long, ID de la boleta.
     * @throws BusinessLogicException 
     */
    public void deleteEspectadorFromBoleta(Long boletaId) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un espectador de la boleta con id = {0}", boletaId);
        BoletaEntity entity = getBoleta(boletaId);
        if(entity.getEspectador() == null)
        {
            throw new BusinessLogicException("La Boleta con Id: \"" + boletaId +"\" no tiene un espectador asociado.");
        }
        entity.setEspectador(null);
    }
}
