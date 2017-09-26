/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;

import co.edu.uniandes.ergo.festival.dtos.CalificacionDetailDTO;
import co.edu.uniandes.ergo.festival.ejb.CalificacionLogic;
import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.entities.CalificacionEntity;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author m.neira10
 */
@Path("/calificaciones")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class CalificacionResource {
    
    @Inject
    private CalificacionLogic calificacionLogic;
    
      /**
    * Crea una nueva CalificacionEntity.
    * @param dto información de la CalificacionEntity.
    * @return Un CalificacionDetailDTO con la información de la nueva entidad.
    */
   @POST
   public CalificacionDetailDTO createCalificacion(CalificacionDetailDTO dto)throws BusinessLogicException{
       if(dto.getBoleta()==null){
           throw new WebApplicationException("La calificacion no tiene una boleta asociada",404);
       }
       if(dto.getBoleta().getId()==null){
           throw new WebApplicationException("La calificacion no tiene un id de boleta",404);
       }
       BoletaEntity bolEnt = dto.getBoleta().toEntity();
       if(bolEnt==null){
           throw new WebApplicationException("La boleta entity es null",404);
       }
       CalificacionEntity ans =calificacionLogic.createCalificacion(dto.toEntity(),bolEnt);
        return new CalificacionDetailDTO(ans);
   }
   
   /**
    * Retorna la información de la CalificacionEntity con el id dado.
    * @param id de la CalificacionEntity.
    * @return Un CalificacionDetailDTO con la informaición de la CalificacionEntity.
    */
   @GET
   @Path("{id: \\d+}")
   public CalificacionDetailDTO getCalificacion(@PathParam("id") Long id){
       CalificacionEntity entity = calificacionLogic.getCalificacion(id);
       if (entity == null){
           throw new WebApplicationException("La Calificacion con id: " + id + " no existe.", 404);
       }
       return new CalificacionDetailDTO(calificacionLogic.getCalificacion(id));
   }
   
   /**
    * Retorna todas las CalificacionEntity.
    * @return Una lista con las CalificacionEntity.
    */
   @GET
   public List<CalificacionDetailDTO> getCalificacions(){
       return listEntity2DTO(calificacionLogic.getCalificaciones());
   }
   
   /**
    * Actualiza la informaición de la CalificacionEntity con el id especificado.
    * @param id de la CalificacionEntity a actualizar.
    * @param dto nueva información de la CalificacionEntity.
    * @return Un CalificacionDetailDTO con la nueva información del CalificacionEntity.
    */
   @PUT
   @Path("{id: \\d+}")
   public CalificacionDetailDTO updateCalificacion(@PathParam("id") Long id, CalificacionDetailDTO dto){
       CalificacionEntity oldEntity = calificacionLogic.getCalificacion(id);
       if (oldEntity == null){
           throw new WebApplicationException("La Calificacion con id: " + id + " no existe.", 404);
       }
       CalificacionEntity entity = dto.toEntity();
       entity.setId(id);
       return new CalificacionDetailDTO(calificacionLogic.updateCalificacion(entity));
   }
   
   /**
    * Elimina la CalificacionEntity con el id especificado.
    * @param id de la CalificacionEntity a eliminar.
    */
   @DELETE
   @Path("{id: \\d+}")
   public void deleteCalificacion(@PathParam("id") Long id){
       CalificacionEntity entity = calificacionLogic.getCalificacion(id);
       if (entity == null){
           throw new WebApplicationException("La Calificacion con id: " + id + " no existe.", 404);
       }
       calificacionLogic.deleteCalificacion(id);
   }
           
   /**
    * Convierte una lista de CalificacionEntity a una lista de CalificacionDetailDTO.     *
    * @param entityList Lista de AuthorEntity a convertir.
    * @return Lista de AuthorDetailDTO convertida.     * 
    */
   private List<CalificacionDetailDTO> listEntity2DTO(List<CalificacionEntity> entityList) {
       List<CalificacionDetailDTO> list = new ArrayList<>();
       for (CalificacionEntity entity : entityList) {
           list.add(new CalificacionDetailDTO(entity));
       }
       return list;
   }
    
}
