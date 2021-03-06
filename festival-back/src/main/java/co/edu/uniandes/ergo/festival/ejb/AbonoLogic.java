/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;


import co.edu.uniandes.ergo.festival.entities.AbonoEntity;
import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.entities.EspectadorEntity;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import co.edu.uniandes.ergo.festival.persistence.AbonoPersistence;
import co.edu.uniandes.ergo.festival.persistence.BoletaPersistence;
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
    @Inject
    private BoletaPersistence persistenceBoleta;
    @Inject
    private EspectadorPersistence persistenceEspectador;   
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
        if(entity.getEspectador() == null)
        {
            throw new BusinessLogicException("El Abono con ID: \"" + entity.getId()+"\" no tiene un Espectador asinado.");
        }
        if(persistenceEspectador.find(entity.getEspectador().getId()) == null)
        {
            throw new BusinessLogicException("El Espectador con ID: \"" + entity.getEspectador().getId()+"\" no existe en la base de Datos.");
        }
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
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar abono con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        if(entity.getEspectador() != null)
        {
             if(persistenceEspectador.find(entity.getEspectador().getId()) == null)
                {
                    throw new BusinessLogicException("El Espectador con ID: \"" + entity.getEspectador().getId()+"\" no existe en la base de Datos.");
                }  
        }
       
        AbonoEntity newEntity = persistenceAbono.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar abono con id={0}", entity.getId());
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
        LOGGER.info("Iniciando proceso de des asociar Espectador.");
        EspectadorEntity espectador = getAbono(id).getEspectador();
        espectador.setAbonos(null);
        persistenceEspectador.update(espectador);
        LOGGER.info("Finalizando proceso de des asociar Espectador.");
        LOGGER.info("Iniciando proceso de borrar boletas.");
        
        if(!getAbono(id).getBoletas().isEmpty())
        {
            List<BoletaEntity> boletas = getAbono(id).getBoletas();
            for(int i = 0; i < boletas.size(); i++)
            {
                deleteBoletaFromAbono(id, boletas.get(i).getId());
            }
        }
        LOGGER.info("Finalizando proceso de borrar boletas.");
        LOGGER.info("Iniciando proceso de des asociar espectador.");
        LOGGER.info("Finalizando proceso de des asociar espectador proceso de des asociar espectdor.");
        persistenceAbono.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar abono con id={0}",id);
    }
    /**
     * Método que obtiene un espectador asociado a un abono.
     * @param id Long, ID del abono.
     * @return EspectadorEntity, espectador asociado al abono.
     */
    public EspectadorEntity getEspectadorFromAbono(Long id)
    {
        return persistenceAbono.find(id).getEspectador();
    }
    /**
     * Método que agrega un espectador a un abono, el espectador DEBE previamente existir en la base de datos.
     * @param abonoId Long, ID del abono.
     * @param espectadorId Long, ID del espectador a asociar.
     * @return EspectadorEntity
     * @throws BusinessLogicException 
     */
    public EspectadorEntity addEspectadorFromAbono(Long abonoId, Long espectadorId) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de agregar un Espectador de la Abono con id = {0}", abonoId);
        AbonoEntity abonoEntity = getAbono(abonoId);
        if(abonoEntity.getEspectador() != null)
        {
            throw new BusinessLogicException("<el abono con Id: \"" + abonoId +"\" ya tiene un Espectador asignado, usar el metodo PUT.");
        }
        if(persistenceEspectador.find(espectadorId) == null)
        {
            throw new BusinessLogicException("El espectador con Id: \"" + espectadorId +"\" no existe.");
        }
        abonoEntity.setEspectador(persistenceEspectador.find(espectadorId));
        LOGGER.log(Level.INFO, "Termina proceso de agregar Espectador de Abono con id={0}", abonoId);
        return abonoEntity.getEspectador();
    }
    
    /**
     * Método que actualiza el espectador de un Abono, el espectador DEBE previamente existir.
     * @param abonoId Long, id del Abono.
     * @param espectadorId Long, id del Espectador
     * @return EspectadorEntity, espectador que se acaba de asociar.
     * @throws BusinessLogicException 
     */
    public EspectadorEntity updateEspectadorFromAbono(Long abonoId, Long espectadorId) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar un Espectador del abono con id = {0}", abonoId);
        AbonoEntity abonoEntity = getAbono(abonoId);
        if(persistenceEspectador.find(espectadorId) == null)
        {
            throw new BusinessLogicException("El espectador con Id: \"" + espectadorId +"\" no existe.");
        }
        abonoEntity.setEspectador(persistenceEspectador.find(espectadorId));
        LOGGER.log(Level.INFO, "Termina proceso de agregar espectador del abono con id={0}", abonoEntity.getId());
        return abonoEntity.getEspectador();
    }
    /**
     * Mëtodo que des asocia un espectador de un abono, el espectador NO es borrado de la base de datos.
     * @param abonoId Long, ID del abono.
     * @throws BusinessLogicException 
     */
    public void deleteEspectadorFromAbono(Long abonoId) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un espectador de la boleta con id = {0}", abonoId);
        AbonoEntity entity = getAbono(abonoId);
        if(entity.getEspectador() == null)
        {
            throw new BusinessLogicException("La Boleta con Id: \"" + abonoId +"\" no tiene un espectador asociado.");
        }
        entity.setEspectador(null);
    }
    /**
     * Método que agrega una Boleta a un abono. La boleta NO debe estar en el abono previamente, y DEBE existir en la base de datos.
     * @param abonoId Long, ID del abono.
     * @param boletaId Long, ID de la boleta
     * @return BoletaEntity Lista de las boleta.
     * @throws BusinessLogicException 
     */
    public BoletaEntity addBoletaFromAbono(Long abonoId, Long boletaId) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de agregar una Boleta a Abono con id = {0}", abonoId);
        AbonoEntity abonoEntity = getAbono(abonoId);
        if(persistenceBoleta.find(boletaId) == null)
        {
            throw new BusinessLogicException("La Boleta con Id: \"" + boletaId +"\" no existe.");
        }
        BoletaEntity boleta = persistenceBoleta.find(boletaId);
        if(boleta.getAbono() != null)
        {
            throw new BusinessLogicException("La Boleta con Id: \"" + boletaId +"\" ya tiene un abono asignado.");
        }
        boleta.setAbono(abonoEntity);
        List<BoletaEntity> boletas = abonoEntity.getBoletas();
        for(int i = 0; i < boletas.size(); i++)
        {
            if(boletas.get(i).getId().equals(boletaId))
            {
                throw new BusinessLogicException("La boleta con Id: \"" + boletaId +"\" ya está asociada a este Abono.");
            }
        }
        boletas.add(boleta);
        abonoEntity.setBoletas(boletas);
        updateAbono(abonoId, abonoEntity);
        LOGGER.log(Level.INFO, "Termina proceso de agregar Boleta a un Abono con id={0}", abonoId);
        return persistenceBoleta.find(boletaId);
    }
    /**
     * Método que obtiene todas las boletas asociadas a un abono.
     * @param abonoId Long, ID del abono.
     * @return List<BoletaEntity> Lista de boletas del abono.
     */
    public List<BoletaEntity> getBoletasFromAbono(Long abonoId)
    {
        LOGGER.log(Level.INFO, "Obteineindo boletas de un Abono con id = {0}", abonoId);
        return persistenceAbono.find(abonoId).getBoletas();
    }
    /**
     * Método que obtiene la Boleta de un Abono.
     * @param abonoId Long, ID del Abono.
     * @param boletaId Long, ID de la Boleta.
     * @return BoletaEntity, Boleta contenida en el Abono.
     */
    public BoletaEntity getBoletaFromAbono(Long abonoId, Long boletaId)
    {
        LOGGER.log(Level.INFO, "Obteineindo boletas de un Abono con id = {0}", abonoId);
        List<BoletaEntity> boletas = persistenceAbono.find(abonoId).getBoletas();
        LOGGER.info("BOLETAS: " + boletas);
        LOGGER.info("BOLETAS SIZE: " + boletas.size());
        BoletaEntity respuesta = null;
        for(int i = 0; i < boletas.size(); i++)
        {
            LOGGER.info("Entro a FOR");
            if(boletas.get(i).getId().equals(boletaId))
            {
                respuesta = boletas.get(i);
            }
        }
        LOGGER.info("TERMINO METODO LOGIC");
        return respuesta;
    }
    /**
     * Método que des asocia una boleta de un Abono.
     * @param abonoId Long, ID del abono.
     * @param boletaId Long, ID de la boleta a des asociar, la boleta debe estar en el abono.
     * @throws BusinessLogicException 
     */
    public void deleteBoletaFromAbono(Long abonoId, Long boletaId) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de des asociar una boleta a Abono con id = {0}", abonoId);
        AbonoEntity abonoEntity = getAbono(abonoId);
        List<BoletaEntity> boletas = abonoEntity.getBoletas();
        int posBoleta = 0;
        boolean control = false;
        for(int i = 0; i < boletas.size(); i++)
        {
            if(boletas.get(i).getId().equals(boletaId))
            {
                control = true;
                posBoleta = i;
            }
        }
        if(!control)
        {   
            throw new BusinessLogicException("La boleta con Id: \"" + boletaId +"\" no se encuentra asociada a este Abono.");
        }
        LOGGER.info("BOLETAS ANTES DE REMOVE: " + boletas.size());
        BoletaEntity temp = boletas.get(posBoleta);
        temp.setAbono(null);
        boletas.remove(posBoleta);
        LOGGER.info("BOLETAS DESPUES DE REMOVE: " + boletas.size());
        LOGGER.info("BOLETAS DE ABONO ENTITY ANTES DE SET: " + abonoEntity.getBoletas().size());
        abonoEntity.setBoletas(boletas);
        LOGGER.info("BOLETAS DE ABONO ENTITY DESPUES DE SET: " + abonoEntity.getBoletas().size());
        LOGGER.info("BOLETAS DE ABONO ENTITY ANTES DE UPDATE: " + getAbono(abonoId).getBoletas().size());
        updateAbono(abonoId, abonoEntity);
        persistenceBoleta.update(temp);
        LOGGER.info("BOLETAS DE ABONO ENTITY DESPUES DE UPDATE: " + getAbono(abonoId).getBoletas().size());
        LOGGER.log(Level.INFO, "Termina proceso de des asociar una boleta de Abono con id={0}", abonoId);
    }
    
    AbonoEntity addEspectador(Long abonoId, EspectadorEntity espectador) {
        AbonoEntity abono = getAbono(abonoId);
        abono.setEspectador(espectador);
        return abono;
    }
}