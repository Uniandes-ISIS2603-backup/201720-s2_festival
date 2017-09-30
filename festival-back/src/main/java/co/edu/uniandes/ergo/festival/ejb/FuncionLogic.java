/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;


import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.entities.CriticaEntity;
import co.edu.uniandes.ergo.festival.entities.FuncionEntity;
import co.edu.uniandes.ergo.festival.entities.PeliculaEntity;
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

    public List<CriticaEntity> getCriticas(Long id) {
       LOGGER.log(Level.INFO, "Inicia proceso de encontrar todas las criticas de una funcion."); 
       FuncionEntity entity =  persistence.find(id);
        return persistence.getCriticas(entity);
    }

    public CriticaEntity getCritica(Long idFuncion, Long idCritica) {
        LOGGER.log(Level.INFO, "Inicia proceso de encontrar una critica de una funcion."); 
        FuncionEntity entity = persistence.find(idFuncion);
        return persistence.getCritica(entity,idCritica);
    }

    public List<BoletaEntity> getBoletas(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de encontrar todas las boletas de una funcion."); 
        FuncionEntity entity =  persistence.find(id);
        return persistence.getBoletas(entity);
    }

    public BoletaEntity getBoleta(Long idFuncion, Long idBoleta) {
         LOGGER.log(Level.INFO, "Inicia proceso de encontrar una boleta de una funcion."); 
        FuncionEntity entity = persistence.find(idFuncion);
        return persistence.getBoleta(entity,idBoleta);
    }

    public FuncionEntity addPelicula(Long funId, PeliculaEntity pelicula) {
        FuncionEntity funcion = getFuncion(funId);
        funcion.setPelicula(pelicula);
        return funcion;
    }
   
    
}
