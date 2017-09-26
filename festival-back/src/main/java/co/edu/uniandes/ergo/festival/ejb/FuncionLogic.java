/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;

import co.edu.uniandes.ergo.festival.entities.FuncionEntity;
import co.edu.uniandes.ergo.festival.persistence.FuncionPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author m.neira10
 */
@Stateless
public class FuncionLogic {
    private static final Logger LOGGER = Logger.getLogger(SillaLogic.class.getName());
    
    @Inject
    private FuncionPersistence persistence;
    
    public FuncionEntity createFuncion(FuncionEntity entity){
       LOGGER.log(Level.INFO, "Inicia proceso de crear una FuncionEntity.");
       return persistence.create(entity);  
    }
   
   public FuncionEntity getFuncion(Long id){
       LOGGER.log(Level.INFO, "Inicia proceso de consultar una FuncionEntity.");
       return persistence.find(id);
   }
   
   public List<FuncionEntity> getFunciones(){
       LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las FuncionEntity.");
       return persistence.findAll();
   }
   
   public FuncionEntity updateFuncion(FuncionEntity entity){
       LOGGER.log(Level.INFO, "Inicia proceso de actualizar una FuncionEntity.");
       return persistence.update(entity);
   }
   
   public void deleteFuncion(Long id){
       LOGGER.log(Level.INFO, "Inicia proceso de borrar una FuncionEntity.");
       persistence.delete(id);
   }
   
    
}
