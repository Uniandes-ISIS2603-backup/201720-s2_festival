/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;

import co.edu.uniandes.ergo.festival.dtos.SillaDetailDTO;
import co.edu.uniandes.ergo.festival.ejb.SillaLogic;
import co.edu.uniandes.ergo.festival.entities.SillaEntity;
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
 * @author f.reyes948
 */
@Path("/sillas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class SillaResource {
    
    @Inject
    private SillaLogic sillaLogic;
    
    /**
     * Crea una nueva SillaEntity.
     * @param dto información de la SillaEntity.
     * @return Un SillaDetailDTO con la información de la nueva entidad.
     */
    @POST
    public SillaDetailDTO createSilla(SillaDetailDTO dto){
        return new SillaDetailDTO(sillaLogic.createSilla(dto.toEntity()));
    }
    
    /**
     * Retorna la información de la SillaEntity con el id dado.
     * @param id de la SillaEntity.
     * @return Un SillaDetailDTO con la informaición de la SillaEntity.
     */
    @GET
    @Path("{id: \\d+}")
    public SillaDetailDTO getSilla(@PathParam("id") Long id){
        SillaEntity entity = sillaLogic.getSilla(id);
        if (entity == null){
            throw new WebApplicationException("La silla con id: " + id + " no existe.", 404);
        }
        return new SillaDetailDTO(sillaLogic.getSilla(id));
    }
    
    /**
     * Retorna todas las SillaEntity.
     * @return Una lista con las SillaEntity.
     */
    @GET
    public List<SillaDetailDTO> getSillas(){
        return listEntity2DTO(sillaLogic.getSillas());
    }
    
    /**
     * Actualiza la informaición de la SillaEntity con el id especificado.
     * @param id de la SillaEntity a actualizar.
     * @param dto nueva información de la SillaEntity.
     * @return Un SillaDetailDTO con la nueva información del SillaEntity.
     */
    @PUT
    @Path("{id: \\d+}")
    public SillaDetailDTO updateSilla(@PathParam("id") Long id, SillaDetailDTO dto){
        SillaEntity oldEntity = sillaLogic.getSilla(id);
        if (oldEntity == null){
            throw new WebApplicationException("La silla con id: " + id + " no existe.", 404);
        }
        SillaEntity entity = dto.toEntity();
        entity.setId(id);
        return new SillaDetailDTO(sillaLogic.updateSilla(entity));
    }
    
    /**
     * Elimina la SillaEntity con el id especificado.
     * @param id de la SillaEntity a eliminar.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteSilla(@PathParam("id") Long id){
        SillaEntity entity = sillaLogic.getSilla(id);
        if (entity == null){
            throw new WebApplicationException("La silla con id: " + id + " no existe.", 404);
        }
        sillaLogic.deleteSilla(id);
    }
            
    /**
     * Convierte una lista de SillaEntity a una lista de SillaDetailDTO.     *
     * @param entityList Lista de AuthorEntity a convertir.
     * @return Lista de AuthorDetailDTO convertida.     * 
     */
    private List<SillaDetailDTO> listEntity2DTO(List<SillaEntity> entityList) {
        List<SillaDetailDTO> list = new ArrayList<>();
        for (SillaEntity entity : entityList) {
            list.add(new SillaDetailDTO(entity));
        }
        return list;
    }
}
