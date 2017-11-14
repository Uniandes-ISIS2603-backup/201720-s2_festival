/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;

import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.entities.SalaEntity;
import co.edu.uniandes.ergo.festival.entities.SillaEntity;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import co.edu.uniandes.ergo.festival.persistence.SillaPersistence;
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
public class SillaLogic {
    
    private static final Logger LOGGER = Logger.getLogger(SillaLogic.class.getName());
    
    @Inject
    private SillaPersistence persistence;
    
    /**
     * Ordena a la persistencia crear una SillaEntity.
     * @param entity La SillaEntity a ser creada.
     * @return La SillaEntity creada.
     * @throws co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException
     */
    public SillaEntity createSilla(SillaEntity entity) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de crear una SillaEntity.");
        return persistence.create(entity);        
    }
    
    /**
     * Obtiene la información de una SillaEntity de la persistencia.
     * @param id id de la SillaEntity a consultar.
     * @return La SillaEntity con el id buscado.
     */
    public SillaEntity getSilla(Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una SillaEntity.");
        return persistence.find(id);
    }
    
    /**
     * Obtiene la información de todas las SillaEntity de la persistencia.
     * @return 
     */
    public List<SillaEntity> getSillas(){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las SillaEntity.");
        return persistence.findAll();        
    }
    
    /**
     * Actualiza la información de una SillaEntity.
     * @param entity La información de la SillaEntity actualizada.
     * @return La SillaEntity actualizada.
     */
    public SillaEntity updateSilla(SillaEntity entity){
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una SillaEntity.");
        SillaEntity oldEntity = getSilla(entity.getId());
        entity.setBoletas(oldEntity.getBoletas());
        entity.setSala(oldEntity.getSala());
        return persistence.update(entity);
    }
    
    /**
     * Elimina una SillaEntity de la persistencia junto con sus BoletaEntity.
     * @param id el id de la SillaEntity a eliminar.
     * @throws co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException
     */
    public void deleteSilla(Long id) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una SillaEntity.");
        persistence.delete(id);
    }
    
    /**
     * Retorna el listado de las BoletaEntity asociadas a una SillaEntity.
     * @param id de la SillaEntity cuyas BoletaEntity se desean consultar.
     * @return Una lista con las BoletaEntity asociadas.
     */
    public List<BoletaEntity> getBoletasSilla(Long id){
        LOGGER.log(Level.INFO, "Consultando BoletaEntity de la SillaEntity con id: {0}", id);
        
        SillaEntity silla = persistence.find(id);
        
        return silla.getBoletas();
    }
    
    /**
     * Retorna la BoletaEntity de la SillaEntity.
     * @param sillasid Identificación de la SillaEntity.
     * @param boletaid Identificación de la BoletaEntity.
     * @return La BoletaEntity.
     */
    public BoletaEntity getBoletaSilla(Long sillasid, Long boletaid){
        LOGGER.log(Level.INFO, "Consultando BoletaEntity con id: {0} de la "
                + "SillaEntity con id: {1}.", new Object[]{boletaid, sillasid});        
        SillaEntity silla = persistence.find(sillasid);
        BoletaEntity boleta = new BoletaEntity();
        boleta.setId(boletaid);
        return silla.getBoletas().get(silla.getBoletas().indexOf(boleta));
    }
    
    /**
     * Retorna la SalaEntity asociada a una SillaEntity.
     * @param id de la SillaEntity cuya SalaEntity se desea consultar.
     * @return La SalaEntity asociada.
     */
    public SalaEntity getSalaSilla(Long id){
        LOGGER.log(Level.INFO, "Consultando SalaEntity de la SillaEntity con id: {0}", id);
        
        SalaEntity sala = getSilla(id).getSala();
        
        return sala;
    }
    
//    /**
//     * Asocia una SalaEntity a una SillaEntity.
//     * @param sillasid Identificacion de la SillaEntity.
//     * @param salaid Identificación de la SalaEntity.
//     * @return La SalaEntity asociada.
//     */
//    public SalaEntity setSalaSilla(Long sillasid, Long salaid){
//        LOGGER.log(Level.INFO, "Inicia proceso de asociar la SalaEntity "
//                + "con id: {0} a la SillaEntity con id: {1}.", 
//                new Object[]{salaid, sillasid});
//        SillaEntity silla = getSilla(sillasid);
//        SalaEntity sala = salaLogic.get(salaid);
//        silla.setSala(sala);
//        LOGGER.log(Level.INFO, "Finaliza proceso de asociar la SalaEntity "
//                + "con id: {0} a la SillaEntity con id: {1}.", 
//                new Object[]{salaid, sillasid});
//        return sala;
//    }    
}
