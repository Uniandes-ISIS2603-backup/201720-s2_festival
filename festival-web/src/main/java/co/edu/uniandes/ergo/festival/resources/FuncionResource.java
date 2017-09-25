/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;


import co.edu.uniandes.ergo.festival.dtos.FuncionDetailDTO;
import co.edu.uniandes.ergo.festival.ejb.FuncionLogic;
import co.edu.uniandes.ergo.festival.entities.FuncionEntity;
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
@Path("/funciones")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class FuncionResource {
     @Inject
    private FuncionLogic funcionLogic;
     
     /**
  * Crea una nueva FuncionEntity.
  * @param dto información de la FuncionEntity.
  * @return Un FuncionDetailDTO con la información de la nueva entidad.
  */
 @POST
 public FuncionDetailDTO createFuncion(FuncionDetailDTO dto){
     return new FuncionDetailDTO(funcionLogic.createFuncion(dto.toEntity()));
 }
 
 /**
  * Retorna la información de la FuncionEntity con el id dado.
  * @param id de la FuncionEntity.
  * @return Un FuncionDetailDTO con la informaición de la FuncionEntity.
  */
 @GET
 @Path("{id: \\d+}")
 public FuncionDetailDTO getFuncion(@PathParam("id") Long id){
     FuncionEntity entity = funcionLogic.getFuncion(id);
     if (entity == null){
         throw new WebApplicationException("La Funcion con id: " + id + " no existe.", 404);
     }
     return new FuncionDetailDTO(funcionLogic.getFuncion(id));
 }
 
 /**
  * Retorna todas las FuncionEntity.
  * @return Una lista con las FuncionEntity.
  */
 @GET
 public List<FuncionDetailDTO> getFuncions(){
     return listEntity2DTO(funcionLogic.getFunciones());
 }
 
 /**
  * Actualiza la informaición de la FuncionEntity con el id especificado.
  * @param id de la FuncionEntity a actualizar.
  * @param dto nueva información de la FuncionEntity.
  * @return Un FuncionDetailDTO con la nueva información del FuncionEntity.
  */
 @PUT
 @Path("{id: \\d+}")
 public FuncionDetailDTO updateFuncion(@PathParam("id") Long id, FuncionDetailDTO dto){
     FuncionEntity oldEntity = funcionLogic.getFuncion(id);
     if (oldEntity == null){
         throw new WebApplicationException("La Funcion con id: " + id + " no existe.", 404);
     }
     FuncionEntity entity = dto.toEntity();
     entity.setId(id);
     return new FuncionDetailDTO(funcionLogic.updateFuncion(entity));
 }
 
 /**
  * Elimina la FuncionEntity con el id especificado.
  * @param id de la FuncionEntity a eliminar.
  */
 @DELETE
 @Path("{id: \\d+}")
 public void deleteFuncion(@PathParam("id") Long id){
     FuncionEntity entity = funcionLogic.getFuncion(id);
     if (entity == null){
         throw new WebApplicationException("La Funcion con id: " + id + " no existe.", 404);
     }
     funcionLogic.deleteFuncion(id);
 }
         
 /**
  * Convierte una lista de FuncionEntity a una lista de FuncionDetailDTO.     *
  * @param entityList Lista de AuthorEntity a convertir.
  * @return Lista de AuthorDetailDTO convertida.     * 
  */
 private List<FuncionDetailDTO> listEntity2DTO(List<FuncionEntity> entityList) {
     List<FuncionDetailDTO> list = new ArrayList<>();
     for (FuncionEntity entity : entityList) {
         list.add(new FuncionDetailDTO(entity));
     }
     return list;
 }
     
    
}
