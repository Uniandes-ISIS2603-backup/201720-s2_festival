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
    /**
     * Método que crea una Función.
     * @param entity FunctionEntity, información de la nueva Función.
     * @return FuncionEntity, Función recientemente creada.
     */
    public FuncionEntity createFuncion(FuncionEntity entity){
       LOGGER.log(Level.INFO, "Inicia proceso de crear una FuncionEntity.");
       return persistence.create(entity);  
    }
   /**
    * Método que obtiene una Función mediante su ID.
    * @param id Long, ID de la Función.
    * @return FuncionEntity, Función con el ID dado.
    */
   public FuncionEntity getFuncion(Long id){
       LOGGER.log(Level.INFO, "Inicia proceso de consultar una FuncionEntity.");
       return persistence.find(id);
   }
   /**
    * Método que obtiene todas las Funciones.
    * @return List<FuncionEntity>, Lista de Funciones.
    */
   public List<FuncionEntity> getFunciones(){
       LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las FuncionEntity.");
       return persistence.findAll();
   }
   /**
    * Método que actualiza una Función.
    * @param entity FuncionEntity, información nueva de la Función.
    * @return FunctionEnityt, Función actualizada.
    */
   public FuncionEntity updateFuncion(FuncionEntity entity){
       LOGGER.log(Level.INFO, "Inicia proceso de actualizar una FuncionEntity.");
       
       return persistence.update(entity);
   }
   /**
    * Método que elimina una Función con un ID dado.
    * @param id Long, ID de la Función.
    */
   public void deleteFuncion(Long id){
       LOGGER.log(Level.INFO, "Inicia proceso de borrar una FuncionEntity.");
       persistence.delete(id);
   }
   /**
    * Método que obtiene la Lista de Críticas de una Función.
    * @param id Long, ID de la Función.
    * @return List<CriticaEntity>, Lista de Críticas de la Función.
    */
    public List<CriticaEntity> getCriticas(Long id) {
       LOGGER.log(Level.INFO, "Inicia proceso de encontrar todas las criticas de una funcion."); 
       FuncionEntity entity =  persistence.find(id);
        return persistence.getCriticas(entity);
    }
    /**
     * Método que obtiene una Crítica de una Función.
     * @param idFuncion Long, ID de la Función.
     * @param idCritica Long, ID de la Crítica.
     * @return CriticaEntity, Crítica de la Función.
     */
    public CriticaEntity getCritica(Long idFuncion, Long idCritica) {
        LOGGER.log(Level.INFO, "Inicia proceso de encontrar una critica de una funcion."); 
        FuncionEntity entity = persistence.find(idFuncion);
        return persistence.getCritica(entity,idCritica);
    }
    /**
     * Método que obtiene la Lista de Boletas de la Función.
     * @param id Long, ID de la Función.
     * @return List<BoletaEntity>, Lista de Boletas de la Función.
     */
    public List<BoletaEntity> getBoletas(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de encontrar todas las boletas de una funcion."); 
        FuncionEntity entity =  persistence.find(id);
        return persistence.getBoletas(entity);
    }
    /**
     * Método que obtiene una Boleta de una Función.
     * @param idFuncion Long, ID de la Función.
     * @param idBoleta Long, ID de la Boleta.
     * @return BoletaEntity, una Boleta de la Función.
     */
    public BoletaEntity getBoleta(Long idFuncion, Long idBoleta) {
         LOGGER.log(Level.INFO, "Inicia proceso de encontrar una boleta de una funcion."); 
        FuncionEntity entity = persistence.find(idFuncion);
        return persistence.getBoleta(entity,idBoleta);
    }
    /**
     * Método que agrega una Película a una Función.
     * @param funId Long, ID de la Función.
     * @param pelicula PeliculaEntity, información de la Película.
     * @return FuncionEntity, Función con la Película agregada.
     */
    public FuncionEntity addPelicula(Long funId, PeliculaEntity pelicula) {
        FuncionEntity funcion = getFuncion(funId);
        funcion.setPelicula(pelicula);
        return funcion;
    }
}
