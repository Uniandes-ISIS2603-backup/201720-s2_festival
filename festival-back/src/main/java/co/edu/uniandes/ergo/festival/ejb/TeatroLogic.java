/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;

import co.edu.uniandes.ergo.festival.entities.*;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import co.edu.uniandes.ergo.festival.persistence.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author de.gutierrez
 */
public class TeatroLogic 
{
    private static final Logger LOGGER = Logger.getLogger(TeatroLogic.class.getName());
    
    @Inject 
    private TeatroPersistence persistence;
    
    @Inject
    private SalaLogic salaLogic;
    
    /**
     * 
     * @param entity
     * @return 
     * @throws co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException 
     */
    public TeatroEntity createTeatro(TeatroEntity entity)throws BusinessLogicException
    {
        LOGGER.log(Level.INFO,"Inicia el proceso de crear un teatro");
        //evaluar el cado en el que exista un teatro con ese mismo nombre.
        TeatroEntity teatro = persistence.find(entity.getId());
        if(teatro != null)
        {
            throw new BusinessLogicException("Ya existe un teatro con ese nombre");
        }
        persistence.create(entity);
        return entity;
    }
    
    /**
     * Obtener la lista de todos los teatros 
     * @return Coleccion de objetos de TeatroEntity 
     */
    public List<TeatroEntity> getTeatros()
    {
        LOGGER.log(Level.INFO, "Inicia el proceso de buscar a todos los teatros");
        return persistence.findAll();
    }
    
    /**
     * Obtener el teatro a partir de un id.
     * @param id Identificador de la instacia a buscar.
     * @return Instacia de TeatroEntity con los datos del teatro consultado.
     */
    public TeatroEntity getTeatro(Long id)
    {
        LOGGER.log(Level.INFO,"Inicia el proceso de buscar un teatro con el id dado", id);
        TeatroEntity teatro = persistence.find(id);
        if(teatro == null)
        {
            LOGGER.log(Level.SEVERE,"El teatro con el id no existe",id);
        }
        return teatro;
    }
       
    /**
     * 
     * @param id
     * @param entity
     * @return 
     */
    public TeatroEntity updateTeatro(Long id, TeatroEntity entity)
    {
        LOGGER.log(Level.INFO, "Inicia el proceso de actualizar un teatro");
        if(getTeatro(id)== null)
        {
            LOGGER.log(Level.SEVERE,"No existe un teatro con ese id para actualizarlo", id);
        }
        TeatroEntity nuevo = persistence.update(entity);
        return nuevo;
    }
   
    /**
     * 
     * @param idTeatro
     */
    public void deleteTeatro(Long idTeatro)
    {
        LOGGER.log(Level.INFO, "Inicia el proceso de eliminar un teatro");
        TeatroEntity teatro = persistence.find(idTeatro);
        if(teatro == null)
        {
            LOGGER.log(Level.SEVERE,"El teatro con el id no existe",idTeatro);
        }
        persistence.delete(idTeatro);
    }
    ///////Operaciones sobre las salas/////////
    
   /**
    * Agrega una sala al teatro
     * @param idTeatro
     * @param idSala
     * @return 
    */
    public SalaEntity addSala (Long idTeatro, Long idSala)
    {
        TeatroEntity teatro = getTeatro(idTeatro);
        SalaEntity sala = salaLogic.get(idSala);
        sala.setTeatro(teatro);
        return sala;
    }
    /**
     *
     * @param idTeatro
     * @return 
     */
    public List<SalaEntity> getSalas(Long idTeatro)
    {
        LOGGER.log(Level.INFO, "Inicia el proceso de buscar las salas asociadas al teatro con el id", idTeatro);
        if(getTeatro(idTeatro) == null)
        {
            LOGGER.log(Level.SEVERE,"No se ha encontrado un teatro con el id",idTeatro);
        }
        return getTeatro(idTeatro).getSalas();
    }
   /**
     *  Asocia una sala al teatro
     * @param idTeatro
     * @param idSala
     * @return 
    */
   public SalaEntity getSala(Long idTeatro, Long idSala)
    {
        LOGGER.log(Level.INFO, "Inicia el proceso de buscar una sala en el teatro con el id", idTeatro);
        List<SalaEntity> salas = getTeatro(idTeatro).getSalas();
        SalaEntity sala = new SalaEntity();
        sala.setId(idSala);
        int index = salas.indexOf(sala);
        if(index >= 0)
        {
            return salas.get(index);
        }
        return null;
    }
    
    /**
    * Reemplaza las salas de un teatro
     * @param idTeatro
     * @param listaSalas
     * @return 
    */
   public List<SalaEntity> replaceSalas(Long idTeatro, List<SalaEntity> listaSalas)
   {
       LOGGER.log(Level.INFO, "Inicia proceso de reemplazar las salas asocidas al teatro con id = {0}", idTeatro);
       TeatroEntity teatro = getTeatro(idTeatro);
       List<SalaEntity> salas = salaLogic.get();
       for(SalaEntity pSala : salas)
       {
           if(listaSalas.contains(pSala))
           {
               pSala.setTeatro(teatro);
           }
           else if(pSala.getTeatro()!= null && pSala.getTeatro().equals(teatro))
           {
               pSala.setTeatro(null);
           }
       }
       return listaSalas;
   }
    
    /** 
     * @param idTeatro
     * @param idSala
     */
    public void removeSala(Long idTeatro, Long idSala)
    {
        TeatroEntity teatro = getTeatro(idTeatro);
        SalaEntity sala = salaLogic.get(idSala);
        sala.setTeatro(null);
        teatro.getSalas().remove(sala);
    }

}
