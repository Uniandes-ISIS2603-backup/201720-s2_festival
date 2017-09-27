/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;

import co.edu.uniandes.ergo.festival.entities.CriticaEntity;
import co.edu.uniandes.ergo.festival.entities.CriticoEntity;
import co.edu.uniandes.ergo.festival.entities.FuncionEntity;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import co.edu.uniandes.ergo.festival.persistence.CriticaPersistence;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 *
 * @author f.reyes948
 */
@Stateless
public class CriticaLogic {
    
    private static final Logger LOGGER = Logger.getLogger(CriticaLogic.class.getName());
    
    @Inject
    private CriticaPersistence persistence;
    
//    @Inject 
//    private FuncionLogic funcionLogic;
    
    @Inject
    private CriticoLogic criticoLogic;
    
    /**
     * Ordena a la persistencia crear una CriticaEntity.
     * @param entity La CriticaEntity a ser creada.
     * @return La CriticaEntity creada.
     */
    public CriticaEntity createCritica(CriticaEntity entity){
        LOGGER.log(Level.INFO, "Inicia proceso de crear una CriticaEntity.");
        return persistence.create(entity);
    }
    
    /**
     * Obtiene la información de una CriticaEntity de la persistencia.
     * @param id id de la CriticaEntity a consultar.
     * @return La CriticaEntity con el id buscado.
     */
    public CriticaEntity getCritica(Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una CriticaEntity.");
        return persistence.find(id);
    }
    
    /**
     * Obtiene la información de todas las CriticaEntity de la persistencia.
     * @return 
     */
    public List<CriticaEntity> getCriticas(){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las CriticaEntity.");
        return persistence.findAll();        
    }
    
    /**
     * Actualiza la información de una CriticaEntity.
     * @param entity La información de la CriticaEntity actualizada.
     * @return La CriticaEntity actualizada.
     */
    public CriticaEntity updateCritica(CriticaEntity entity){
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una CriticaEntity.");
        return persistence.update(entity);
    }
    
    /**
     * Elimina una CriticaEntity de la persistencia.
     * @param id el id de la CriticaEntity a eliminar.
     */
    public void deleteCritica(Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una CriticaEntity.");
        persistence.delete(id);
    }
    
//    /**
//     * Asocia una FuncionEntity a una CriticaEntity.
//     * @param criticasid Identificacion de la CriticaEntity.
//     * @param funcionid Identificación de la FuncionEntity.
//     * @return La FuncionEntity asociada.
//     */
//    public FuncionEntity setFuncionCritica(Long criticasid, Long funcionid){
//        LOGGER.log(Level.INFO, "Inicia proceso de asociar la FuncionEntity "
//                + "con id: {0} a la CriticaEntity con id: {1}.", 
//                new Object[]{funcionid, criticasid});
//        CriticaEntity critica = getCritica(criticasid);
//        FuncionEntity funcion = funcionLogic.get(funcionid);
//        critica.setFuncion(funcion);
//        LOGGER.log(Level.INFO, "Finaliza proceso de asociar la FuncionEntity "
//                + "con id: {0} a la CriticaEntity con id: {1}.", 
//                new Object[]{funcionid, criticasid});
//        return funcion;
//    }
//    
//    /**
//     * Retorna la FuncionEntity asociada a una CriticaEntity.
//     * @param id de la CriticaEntity cuya FuncionEntity se desea consultar.
//     * @return La FuncionEntity asociada.
//     */
//    public FuncionEntity getFuncionCritica(Long id){
//        LOGGER.log(Level.INFO, "Consultando FuncionEntity de la CriticaEntity con id: {0}", id);
//        
//        FuncionEntity funcion = getCritica(id).getFuncion();
//        
//        return funcion;
//    }
//    
//    /**
//     * Desasocia una FuncionEntity de una CriticaEntity.
//     * @param criticasid La identificación de la CriticaEntity.
//     * @throws BusinessLogicException Si la CriticaEntity no tiene una 
//     * FuncionEntity asociada.
//     */
//    public void deleteFuncionCritica(Long criticasid) throws BusinessLogicException{
//        LOGGER.log(Level.INFO, "Inicia proceso de desasociar la FuncionEntity "
//                + "a la CriticaEntity con id: {0}.", 
//                criticasid);
//        CriticaEntity critica = getCritica(criticasid);
//        FuncionEntity funcion = critica.getFuncion();
//        if (funcion == null){
//            throw new BusinessLogicException("La CriticaEntity con id: " + criticasid 
//            + " no tiene una FuncionEntity asociada.");
//        } 
//        critica.setFuncion(null);
//        LOGGER.log(Level.INFO, "Finaliza proceso de desasociar la FuncionEntity "
//                + "a la CriticaEntity con id: {0}.", 
//                criticasid);
//    }
    
    /**
     * Asocia una CriticoEntity a una CriticaEntity.
     * @param criticasid Identificacion de la CriticaEntity.
     * @param criticoid Identificación de la CriticoEntity.
     * @return La CriticoEntity asociada.
     */
    public CriticoEntity setCriticoCritica(Long criticasid, Long criticoid){
        LOGGER.log(Level.INFO, "Inicia proceso de asociar la CriticoEntity "
                + "con id: {0} a la CriticaEntity con id: {1}.", 
                new Object[]{criticoid, criticasid});
        CriticaEntity critica = getCritica(criticasid);
        CriticoEntity critico = criticoLogic.getCritico(criticoid);
        critica.setCritico(critico);
        LOGGER.log(Level.INFO, "Finaliza proceso de asociar la CriticoEntity "
                + "con id: {0} a la CriticaEntity con id: {1}.", 
                new Object[]{criticoid, criticasid});
        return critico;
    }
    
    /**
     * Retorna la CriticoEntity asociada a una CriticaEntity.
     * @param id de la CriticaEntity cuya CriticoEntity se desea consultar.
     * @return La CriticoEntity asociada.
     */
    public CriticoEntity getCriticoCritica(Long id){
        LOGGER.log(Level.INFO, "Consultando CriticoEntity de la CriticaEntity con id: {0}", id);
        
        CriticoEntity critico = getCritica(id).getCritico();
        
        return critico;
    }
    
    /**
     * Desasocia una CriticoEntity de una CriticaEntity.
     * @param criticasid La identificación de la CriticaEntity.
     * @throws BusinessLogicException Si la CriticaEntity no tiene una 
     * CriticoEntity asociada.
     */
    public void deleteCriticoCritica(Long criticasid) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de desasociar la CriticoEntity "
                + "a la CriticaEntity con id: {0}.", 
                criticasid);
        CriticaEntity critica = getCritica(criticasid);
        CriticoEntity critico = critica.getCritico();
        if (critico == null){
            throw new BusinessLogicException("La CriticaEntity con id: " + criticasid 
            + " no tiene una CriticoEntity asociada.");
        } 
        critica.setCritico(null);
        LOGGER.log(Level.INFO, "Finaliza proceso de desasociar la CriticoEntity "
                + "a la CriticaEntity con id: {0}.", 
                criticasid);
    }


}
