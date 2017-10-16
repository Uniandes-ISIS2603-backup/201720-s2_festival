/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;


import co.edu.uniandes.ergo.festival.entities.AbonoEntity;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
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
    private FuncionLogic logicFuncion;
    
    @Inject
    private EspectadorPersistence persistenceEspectador;
    
    @Inject
    private SillaLogic logicSilla;
    @Inject
    private SillaPersistence persistenceSilla;
    @Inject
    private FuncionPersistence persistenceFuncion;
    
    @Inject
    private EspectadorLogic logicEspectador;
    
    @Inject
    private CalificacionLogic logicCalificacion;
    
    @Inject
    private AbonoLogic logicAbono;
   // @Inject
   // private CalificacionLogic calificacionLogic;
    /**
     * Método que crea una boleta nueva.
     * Restricciones:
     * La boleta debe tener una silla asignada y válida.
     * La boleta debe tener una función asignada y válida.
     * En caso de que el estado de reserva no se especifique, será asignada como DISPONIBLE por defecto.
     * @param entity, BoletaEntity, Boleta a introducir en la Base de datos
     * @return BoletaEntity, boleta creada.
     * @throws BusinessLogicException 
     */
    public BoletaEntity createBoleta(BoletaEntity entity)throws BusinessLogicException
    {
        LOGGER.info("Inicia proceso de creación de Boleta");
        LOGGER.info("Revisando parámetros básicos de Boleta.");
        if(entity.getCodigoBarras() == null)
        {
            throw new BusinessLogicException("La boleta con ID: \"" + entity.getId()+"\" no tiene un codigo de barras asignado.");
        }
        LOGGER.info("Si tiene código de barras.");
        if(entity.getFuncion() == null)
        {
            throw new BusinessLogicException("La boleta con id \"" + entity.getId()+"\" no tiene una funcion asignada.");
        }
        LOGGER.info("Si tiene Funcion.");
        if(entity.getSilla() == null)
        {
            throw new BusinessLogicException("La boleta con id \"" + entity.getId()+"\" no tiene una silla asignada.");
        }
        LOGGER.info("Si tiene silla.");
        if((entity.getEstado() == null)||(!(entity.getEstado().equals(BoletaEntity.COMPRADA))&&!(entity.getEstado().equals(BoletaEntity.RESERVADA))&&!(entity.getEstado().equals(BoletaEntity.DISPONIBLE))))
        {
            LOGGER.info("No tiene estado asignado, asignando estado DISPONIBLE");
            entity.setEstado(BoletaEntity.DISPONIBLE);
        }
        // Verifica la regla de negocio que dice que no puede haber dos boletas con el mismo codigo de barras.
        if(persistenceBoleta.findByCode(entity.getCodigoBarras()) != null)
        {
            throw new BusinessLogicException("Ya existe una Boleta con el código de barras: \"" + entity.getCodigoBarras()+"\""); 
        }
        LOGGER.info("No existe boleta con el mismo codigo de barras.");
        SillaEntity silla = persistenceSilla.find(entity.getSilla().getId());
        LOGGER.info("Revisando validez de los parámetros dados.");
        if(silla == null)
        {
            throw new BusinessLogicException("La silla con el ID: \"" + entity.getSilla().getId() +"\" no existe."); 
        }
        LOGGER.info("La Silla es válida y sí existe.");
        entity.setSilla(silla);
        FuncionEntity funcion = persistenceFuncion.find(entity.getFuncion().getId());
        if(funcion == null)
        {
            throw new BusinessLogicException("La funcion con el ID: \"" + entity.getFuncion().getId() +"\" no existe."); 
        }
        LOGGER.info("La Función es válida y sí existe.");
        entity.setFuncion(funcion);
        List <BoletaEntity> boletasSilla = logicSilla.getSilla(entity.getSilla().getId()).getBoletas();
        for(int i = 0; i < boletasSilla.size(); i++)
        {
            if((boletasSilla.get(i).getFuncion().getId().equals(entity.getFuncion().getId())))
            {
                throw new BusinessLogicException("La silla con id: \"" + entity.getSilla().getId()+"\" ya tiene una boleta asignada a esa función."); 
            }
        }
        LOGGER.info("La Silla asignada no tiene una boleta asignada para la misma función.");
        for(int i = 0; i < boletasSilla.size(); i++)
        {
            if((boletasSilla.get(i).getId().equals(entity.getId())))
            {
                throw new BusinessLogicException("La silla con id: \"" + entity.getSilla().getId()+"\" ya tiene esta misma boleta asociada."); 
            }
        }
        LOGGER.info("La Silla asignada no una boleta con igual ID asignada.");
        List<BoletaEntity> boletasFuncion = funcion.getBoletas();
        for(int i = 0; i < boletasFuncion.size(); i++)
        {
            if(boletasFuncion.get(i).getCodigoBarras().equals(entity.getCodigoBarras()))
            {
                throw new BusinessLogicException("La Función con id: \"" + entity.getFuncion().getId()+"\" ya tiene una boleta con codigoDeBarras: \"" + entity.getCodigoBarras()+"\" asignada a esa función."); 
            }
        }
        LOGGER.info("La Función asignada no una boleta con igual ID asignada.");
        LOGGER.info("Verificando si hay espectador asociado.");
        if(entity.getEspectador() != null)
        {
            LOGGER.info("Verificando la validez del espectador.");
            EspectadorEntity espectador = persistenceEspectador.find(entity.getEspectador().getId());
            if(espectador == null)
            {
                throw new BusinessLogicException("El espectador con el ID: \"" + entity.getEspectador().getId() +"\" no existe."); 
            }
        }
        LOGGER.info("El espectador es válido.");
        LOGGER.info("Reglas de negocio correctamente validadas.");
        
        // Invoca la persistencia para crear la boleta
        LOGGER.info("Creando Boleta.");
        persistenceBoleta.create(entity);
        boletasSilla.add(entity);
        boletasFuncion.add(entity);
        silla.setBoletas(boletasSilla);
        logicSilla.updateSilla(silla);
        LOGGER.info("Termina proceso de creación de Boleta");
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
        LOGGER.info("Reviando si boleta con codigo de barras: " + entity.getCodigoBarras() + " existe.");
        if(persistenceBoleta.findByCode(entity.getCodigoBarras()) != null && !persistenceBoleta.findByCode(entity.getCodigoBarras()).getId().equals(id))
        {
            throw new BusinessLogicException("Ya existe una Boleta con el código de barras \"" + entity.getCodigoBarras()+"\""); 
        }
        LOGGER.info("No existe otra boleta con el mismo codigo de barras.");
        LOGGER.info("Revisando parámetros básicos de Boleta.");
        if(entity.getCodigoBarras() == null)
        {
            throw new BusinessLogicException("La boleta con ID: \"" + entity.getId()+"\" no tiene un codigo de barras asignado.");
        }
        LOGGER.info("Si tiene código de barras.");
        if(entity.getFuncion() == null)
        {
            throw new BusinessLogicException("La boleta con id \"" + entity.getId()+"\" no tiene una funcion asignada.");
        }
        LOGGER.info("Si tiene Funcion.");
        if(entity.getSilla() == null)
        {
            throw new BusinessLogicException("La boleta con id \"" + entity.getId()+"\" no tiene una silla asignada.");
        }
        LOGGER.info("Si tiene silla.");
        if((entity.getEstado() == null)||(!(entity.getEstado().equals(BoletaEntity.COMPRADA))&&!(entity.getEstado().equals(BoletaEntity.RESERVADA))&&!(entity.getEstado().equals(BoletaEntity.DISPONIBLE))))
        {
            LOGGER.info("No tiene estado asignado, asignando estado DISPONIBLE");
            entity.setEstado(BoletaEntity.DISPONIBLE);
        }
        if(entity.getCalificacion() != null)
        {
            throw new BusinessLogicException("La calificacion de la boleta con id \"" + entity.getId() + "\" no se modifica desde aquí, usar la extension: (boletasId/calificaciones)");
        }
        // Verifica la regla de negocio que dice que no puede haber dos boletas con el mismo codigo de barras.
        
        SillaEntity silla = persistenceSilla.find(entity.getSilla().getId());
        LOGGER.info("Revisando validez de los parámetros dados.");
        if(silla == null)
        {
            throw new BusinessLogicException("La silla con el ID: \"" + entity.getSilla().getId() +"\" no existe."); 
        }
        LOGGER.info("La Silla es válida y sí existe.");
        LOGGER.info("Verificando si hay espectador asociado.");
        if(entity.getEspectador() != null)
        {
            LOGGER.info("Verificando la validez del espectador.");
            EspectadorEntity espectador = persistenceEspectador.find(entity.getEspectador().getId());
            if(espectador == null)
            {
                throw new BusinessLogicException("El espectador con el ID: \"" + entity.getEspectador().getId() +"\" no existe."); 
            }
        }
        LOGGER.info("El espectador es válido.");
        List<BoletaEntity> boletasSilla;
        List<BoletaEntity> boletasSillaVieja;
        SillaEntity sillaAAsignar;
        boolean hayCambioDeSilla = false;
        if(entity.getSilla().getId().equals(getBoleta(id).getSilla().getId()))
        {
            hayCambioDeSilla = false;
            sillaAAsignar = logicSilla.getSilla(getBoleta(id).getSilla().getId());
            boletasSilla = sillaAAsignar.getBoletas();
            for(int i = 0; i < boletasSilla.size(); i++)
            {
                if(boletasSilla.get(i).getId().equals(id))
                {
                    boletasSilla.set(i, entity);
                }
            }
        }
        else
        {
            hayCambioDeSilla = true;
            sillaAAsignar = logicSilla.getSilla(entity.getSilla().getId());
            boletasSilla = sillaAAsignar.getBoletas();
            SillaEntity sillaVieja = getBoleta(id).getSilla();
            boletasSillaVieja = sillaVieja.getBoletas();
            for(int i = 0; i < boletasSillaVieja.size(); i++)
            {
                if(boletasSillaVieja.get(i).getId().equals(id))
                {
                    boletasSillaVieja.remove(i);
                }
            }
            boletasSilla.add(entity);
            sillaVieja.setBoletas(boletasSillaVieja);
            logicSilla.updateSilla(sillaVieja);
        }
        LOGGER.info("Se ha procesado correctamente el cambio de Silla.");
        List<BoletaEntity> boletasFuncion;
        List<BoletaEntity> boletasFuncionVieja;
        FuncionEntity funcionAAsignar;
        boolean hayCambioDeFuncion = false;
        if(entity.getFuncion().getId().equals(getBoleta(id).getFuncion().getId()))
        {
            hayCambioDeFuncion= false;
            funcionAAsignar = logicFuncion.getFuncion(getBoleta(id).getFuncion().getId());
            boletasFuncion = funcionAAsignar.getBoletas();
            for(int i = 0; i < boletasFuncion.size(); i++)
            {
                if(boletasFuncion.get(i).getId().equals(id))
                {
                    boletasFuncion.set(i, entity);
                }
            }
        }
        else
        {
            hayCambioDeFuncion = true;
            funcionAAsignar = logicFuncion.getFuncion(entity.getFuncion().getId());
            boletasFuncion = funcionAAsignar.getBoletas();
            FuncionEntity funcionVieja = getBoleta(id).getFuncion();
            boletasFuncionVieja = funcionVieja.getBoletas();
            for(int i = 0; i < boletasFuncionVieja.size(); i++)
            {
                if(boletasFuncionVieja.get(i).getId().equals(id))
                {
                    boletasFuncionVieja.remove(i);
                }
            }
            boletasFuncion.add(entity);
            funcionVieja.setBoletas(boletasFuncionVieja);
            logicFuncion.updateFuncion(funcionVieja);
        }
        LOGGER.info("Se ha procesado correctamente el cambio de Funcion.");
        
        LOGGER.info("Reglas de negocio correctamente validadas.");
        
        // Invoca la persistencia para crear la boleta
        LOGGER.info("actializando Boleta.");
        BoletaEntity newEntity = persistenceBoleta.update(entity);
        funcionAAsignar.setBoletas(boletasFuncion);
        logicFuncion.updateFuncion(funcionAAsignar);
//      boletasFuncion.set(posBoletaEnBoletasFuncion, entity);
//      funcion.setBoletas(boletasFuncion);
        sillaAAsignar.setBoletas(boletasSilla);
        logicSilla.updateSilla(sillaAAsignar);
//        logicFuncion.updateFuncion(funcion);
        LOGGER.info("Termina proceso de creación de Boleta");
        
        
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
        BoletaEntity temp = getBoleta(id);
        LOGGER.info("Procesando silla asociada.");
        SillaEntity silla = logicSilla.getSilla(temp.getSilla().getId());
        List<BoletaEntity> boletasSilla = silla.getBoletas();
        for(int i = 0; i < boletasSilla.size(); i++)
        {
            if(boletasSilla.get(i).getId().equals(id))
            {
                LOGGER.info("Eliminando boleta de la silla.");
                boletasSilla.remove(i);
            }
        }
        silla.setBoletas(boletasSilla);
        logicSilla.updateSilla(silla);
        LOGGER.info("Boleta exitosamente removida de Silla.");
        if(temp.getEspectador()!= null)
        {
            LOGGER.info("Procesando Espectador asociado.");
            EspectadorEntity espectadorTemp = logicEspectador.getEspectador(temp.getEspectador().getId());
            List<BoletaEntity> boletasEspectador = espectadorTemp.getBoletas();
            for(int i = 0; i < boletasEspectador.size(); i++)
            {
                if(boletasEspectador.get(i).getId().equals(id))
                {
                    LOGGER.info("Eliminando Boleta del espectador.");
                    boletasEspectador.remove(i);
                }
            }
            espectadorTemp.setBoletas(boletasEspectador);
            logicEspectador.updateEspectador(temp.getEspectador().getId(), espectadorTemp);//BORRAR LA BOLETA DEL ESPECTADOR.
            LOGGER.info("Boleta exitosamente removida de Espectador.");
        }
        if(temp.getAbono() != null)
        {
            LOGGER.info("Procesando Abono asociado.");
            AbonoEntity abonoTemp = logicAbono.getAbono(temp.getAbono().getId());
            List<BoletaEntity> boletasAbono = abonoTemp.getBoletas();
            for(int i = 0; i < boletasAbono.size(); i++)
            {
                if(boletasAbono.get(i).getId().equals(id))
                {
                    LOGGER.info("Removiendo Boleta del Abono.");
                    boletasAbono.remove(i);
                }
            }
            abonoTemp.setBoletas(boletasAbono);
            logicAbono.updateAbono(abonoTemp.getId(), abonoTemp);
            temp.setAbono(null);
            //persistenceBoleta.update(temp);
            LOGGER.info("Boleta exitosamente removida del Abono.");
        }
        
        //persistenceBoleta.update(temp);
        LOGGER.info("Procesando Funcion asociada.");
        FuncionEntity funcion = temp.getFuncion();
        List<BoletaEntity> boletasFuncion = funcion.getBoletas();
        for(int i = 0; i < boletasFuncion.size(); i++)
        {
            if(boletasFuncion.get(i).getId().equals(id))
            {
                LOGGER.info("Removiendo Boleta de la funcion asociada.");
                boletasFuncion.remove(i);
            }
        }
        funcion.setBoletas(boletasFuncion);
        logicFuncion.updateFuncion(funcion);
        LOGGER.info("Boleta exitosamente removida de la Funcion");
        if(temp.getCalificacion() != null)
        {
            LOGGER.info("Procesando Calificacion de la boleta..");
            Long idCalificacionABorrar = temp.getCalificacion().getId();
            temp.setCalificacion(null);
            persistenceBoleta.update(temp);
            logicCalificacion.deleteCalificacion(idCalificacionABorrar);
            LOGGER.info("Calificacion exitosamente eliminada de la base de datos y de la boleta.");
        }
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
        if(getBoleta(boletaId).getSilla() == null)
        {
            throw new WebApplicationException("La Boleta con Id: \"" + boletaId +"\" no tiene una silla asociado.",404);
        }
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
        if(boletaEntity.getSilla() == null)
        {
            throw new BusinessLogicException("La Boleta con Id: \"" + boletaId +"\" ya tiene una silla asignada, usar el metodo PUT.");
        }
        if(logicSilla.getSilla(sillaId) == null)
        {
            throw new BusinessLogicException("La Silla con Id: \"" + sillaId +"\" no existe.");
        }
        //PROCESANDO REMOCIÓN DE BOLETA EN SILLA ANTIGUA.
        SillaEntity sillaVieja = logicSilla.getSilla(boletaEntity.getSilla().getId());
        List<BoletaEntity> boletasSillaVieja = sillaVieja.getBoletas();
        for(int i = 0; i < boletasSillaVieja.size(); i++)
        {
            if(boletasSillaVieja.get(i).getId().equals(boletaId))
            {
                boletasSillaVieja.remove(i);
            }
        }
        sillaVieja.setBoletas(boletasSillaVieja);
        
        //Agregando silla nueva a Boleta.
        boletaEntity.setSilla(logicSilla.getSilla(sillaId));
        //PROCESANDO AGREGR BOLETA EN SILLA NUEVA.
        SillaEntity sillaNueva = logicSilla.getSilla(sillaId);
        List<BoletaEntity> boletasSillaNueva = sillaNueva.getBoletas();
        for(int i = 0; i < boletasSillaNueva.size(); i++)
        {
            if(boletasSillaNueva.get(i).getFuncion().getId().equals(boletaEntity.getFuncion().getId()))
            {
                throw new BusinessLogicException("Ya existe una boleta asignada la silla con ID : \""+ sillaId+"\" y una función con Id: \"" + boletaEntity.getFuncion().getId() +"\".");
            }
        }
        boletasSillaNueva.add(boletaEntity);
        sillaNueva.setBoletas(boletasSillaNueva);
        //Consolidar cambios.
        logicSilla.updateSilla(sillaVieja);
        logicSilla.updateSilla(sillaNueva);
        persistenceBoleta.update(boletaEntity);
        
        LOGGER.log(Level.INFO, "Termina proceso de actualizar silla de Boleta con id={0}", boletaEntity.getId());
        return boletaEntity.getSilla();
    }
    /**
     * Método que obtiene la funcion de una boleta.
     * @param boletaId Long, ID de la boleta.
     * @return FuncionEntity, la Funcion asociada.
     */
    public FuncionEntity getFuncionFromBoleta(Long boletaId)throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una funcion de la boleta con id = {0}", boletaId);
        FuncionEntity respuesta = new FuncionEntity();
        if(getBoleta(boletaId).getFuncion() == null)
        {
            throw new WebApplicationException("La Boleta con Id: \"" + boletaId +"\" no tiene una funcion asociada.",404);
        }
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
        //Remover Boleta de la Función
        FuncionEntity funcionVieja = logicFuncion.getFuncion(boletaEntity.getFuncion().getId());
        List<BoletaEntity> boletasFuncionAntigua = funcionVieja.getBoletas();
        for(int i = 0; i < boletasFuncionAntigua.size(); i++)
        {
            if(boletasFuncionAntigua.get(i).getId().equals(boletaId))
            {
                boletasFuncionAntigua.remove(i);
            }
        }
        funcionVieja.setBoletas(boletasFuncionAntigua);
        
        //Actualizar Función de esta boleta
        boletaEntity.setFuncion(persistenceFuncion.find(funcionId));
        //Actualizar boletas de Función nueva.
        FuncionEntity funcionNueva = logicFuncion.getFuncion(funcionId);
        List<BoletaEntity> boletasFuncionNueva = funcionNueva.getBoletas();
        boletasFuncionNueva.add(boletaEntity);
        //Actualizando información.
        logicFuncion.updateFuncion(funcionVieja);
        persistenceBoleta.update(boletaEntity);
        logicFuncion.updateFuncion(funcionNueva);
        
        LOGGER.log(Level.INFO, "Termina proceso de agregar funcion de Boleta con id={0}", boletaEntity.getId());
        return boletaEntity.getFuncion();
    }
    
    
    /**
     * Método que obtiene la calificacion asociada a una boleta.
     * @param boletaId Long, ID de la boleta.
     * @return CalificaionEntity, Calificacion asociada a una boleta.
     */
    public CalificacionEntity getCalificacionFromBoleta(Long boletaId)throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una calificacion de la boleta con id = {0}", boletaId);
        CalificacionEntity respuesta = new CalificacionEntity();
        if(getBoleta(boletaId).getCalificacion() == null)
        {
            throw new WebApplicationException("La Boleta con Id: \"" + boletaId +"\" no una calificacion asociada.",404);
        }
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
        LOGGER.info("CONTROL 1");
        if(boletaEntity.getCalificacion() != null )
        {
            throw new BusinessLogicException("La Boleta con Id: \"" + boletaId +"\" ya tiene una calificacion asignada, usar el metodo PUT.");
        }
        LOGGER.info("CONTROL 2");
        CalificacionEntity temp = logicCalificacion.createCalificacion(entity, boletaEntity);
        LOGGER.info("CONTROL 3");
        boletaEntity.setCalificacion(temp);
        LOGGER.info("CONTROL 4");
        persistenceBoleta.update(boletaEntity);
        LOGGER.info("Termina proceso de creacion de calificacion en Boleta");
        return entity; 
    }
    /**
     * Método que asocia una calificacion a una boleta, la calificacion DEBE existir previamente.
     * @param boletaId Long, ID de la boleta.
     * @param calificacionId Long, ID de la calificacion a asociar.
     * @return CalificacionEntity, calificacion que se acaba de asociar.
     * @throws BusinessLogicException 
     */
//    public CalificacionEntity addCalificacionYaExistenteFromBoleta(Long boletaId, Long calificacionId) throws BusinessLogicException
//    {
//        LOGGER.log(Level.INFO, "Inicia proceso de agregar una calificacion ya existente a la Boleta con id = {0}", boletaId);
//        BoletaEntity boletaEntity = getBoleta(boletaId);
//        if(boletaEntity.getCalificacion() != null)
//        {
//            throw new BusinessLogicException("La Boleta con Id: \"" + boletaId +"\" ya tiene una calificacion asignada, usar el metodo PUT.");
//        }
//        if(persistenceCalificacion.find(calificacionId) == null)
//        {
//            throw new BusinessLogicException("La Funcion con Id: \"" + calificacionId +"\" no existe, usar el metodo POST auxiliar y crear una calificacion alli");
//        }
//        boletaEntity.setCalificacion(persistenceCalificacion.find(calificacionId));
//        LOGGER.log(Level.INFO, "Termina proceso de agregar una calificacion a Boleta con id={0}", boletaEntity.getId());
//        return boletaEntity.getCalificacion();
//    }
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
            throw new BusinessLogicException("La Boleta con Id: \"" + boletaId +"\" no tiene una calificacion asignada, usar el metodo POST.");
        }
        boletaEntity.setCalificacion(entity);
        logicCalificacion.updateCalificacion(entity);
        persistenceBoleta.update(boletaEntity);
        LOGGER.info("Termina proceso de actualizacion de Calificacion de Boleta");
        return entity;
    }
    /**
     * Método que actualiza una calificacion de una boleta con otra que PREVIAMENTE existe en la base de datos.
     * @param boletaId Long, ID de la boleta.
     * @param calificacionId Long, ID de la calificacion a asociar.
     * @return CalificacionEntity, calificacion que se acaba de asociar.
     * @throws co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException
     */
//    public CalificacionEntity updateCalificacionYaExistenteFromBoleta(Long boletaId, Long calificacionId) throws BusinessLogicException
//    {
//        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una calificacion ya existente a la Boleta con id = {0}", boletaId);
//        BoletaEntity boletaEntity = getBoleta(boletaId);
//        if(boletaEntity.getCalificacion() == null)
//        {
//            throw new BusinessLogicException("La Boleta con Id: \"" + boletaId +"\" no tiene una calificacion asignada, usar el metodo POST.");
//        }
//        if(persistenceCalificacion.find(calificacionId) == null)
//        {
//            throw new BusinessLogicException("La Calificacion con Id: \"" + calificacionId +"\" no existe, usar el metodo POST auxiliar y crear una calificacion alli");
//        }
//        Long idEntityABorrar = boletaEntity.getCalificacion().getId();
//        boletaEntity.setCalificacion(persistenceCalificacion.find(calificacionId));
//        persistenceCalificacion.delete(idEntityABorrar);
//        LOGGER.log(Level.INFO, "Termina proceso de agregar una calificacion a Boleta con id={0}", boletaEntity.getId());
//        return boletaEntity.getCalificacion();
//    }
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
        entity.setCalificacion(null);
        persistenceBoleta.update(entity);
        logicCalificacion.deleteCalificacion(idCalificacionABorrar);
    }
    /**
     * Método que obtiene el espectador asociad de una boleta.
     * @param boletaId Long, ID de la boleta.
     * @return EspectadorEntity.
     */
    public EspectadorEntity getEspectadorFromBoleta(Long boletaId)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una calificacion de la boleta con id = {0}", boletaId);
        if(getBoleta(boletaId).getEspectador() == null)
        {
            throw new WebApplicationException("La Boleta con Id: \"" + boletaId +"\" no tiene un espectador asociado.",404);
        }
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