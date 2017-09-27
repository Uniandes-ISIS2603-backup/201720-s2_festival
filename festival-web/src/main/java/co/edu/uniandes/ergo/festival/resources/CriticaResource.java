/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;

import co.edu.uniandes.ergo.festival.dtos.CriticaDetailDTO;
import co.edu.uniandes.ergo.festival.ejb.CriticaLogic;
import co.edu.uniandes.ergo.festival.entities.CriticaEntity;
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
@Path("/criticas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CriticaResource {
    
    @Inject
    private CriticaLogic criticaLogic;
    
    /**
     * Crea una nueva CriticaEntity.
     * @param dto información de la CriticaEntity.
     * @return Un CriticaDetailDTO con la información de la nueva entidad.
     */
    @POST
    public CriticaDetailDTO createCritica(CriticaDetailDTO dto){
        return new CriticaDetailDTO(criticaLogic.createCritica(dto.toEntity()));
    }
    
    /**
     * Retorna la información de la CriticaEntity con el id dado.
     * @param id de la CriticaEntity.
     * @return Un CriticaDetailDTO con la informaición de la CriticaEntity.
     */
    @GET
    @Path("{id: \\d+}")
    public CriticaDetailDTO getCritica(@PathParam("id") Long id){
        CriticaEntity entity = criticaLogic.getCritica(id);
        if (entity == null){
            throw new WebApplicationException("La crítica con id: " + id + " no existe.", 404);
        }
        return new CriticaDetailDTO(criticaLogic.getCritica(id));
    }
    
    /**
     * Retorna todas las CriticaEntity.
     * @return Una lista con las CriticaEntity.
     */
    @GET
    public List<CriticaDetailDTO> getCriticas(){
        return listEntity2DTO(criticaLogic.getCriticas());
    }
    
    /**
     * Actualiza la informaición de la CriticaEntity con el id especificado.
     * @param id de la CriticaEntity a actualizar.
     * @param dto nueva información de la CriticaEntity.
     * @return Un CriticaDetailDTO con la nueva información del CriticaEntity.
     */
    @PUT
    @Path("{id: \\d+}")
    public CriticaDetailDTO updateCritica(@PathParam("id") Long id, CriticaDetailDTO dto){
        CriticaEntity oldEntity = criticaLogic.getCritica(id);
        if (oldEntity == null){
            throw new WebApplicationException("La crítica con id: " + id + " no existe.", 404);
        }
        CriticaEntity entity = dto.toEntity();
        entity.setId(id);
        return new CriticaDetailDTO(criticaLogic.updateCritica(entity));
    }
    
    /**
     * Elimina la CriticaEntity con el id especificado.
     * @param id de la CriticaEntity a eliminar.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCritica(@PathParam("id") Long id){
        CriticaEntity entity = criticaLogic.getCritica(id);
        if (entity == null){
            throw new WebApplicationException("La crítica con id: " + id + " no existe.", 404);
        }
        criticaLogic.deleteCritica(id);
    }
            
    /**
     * Convierte una lista de CriticaEntity a una lista de CriticaDetailDTO.     *
     * @param entityList Lista de AuthorEntity a convertir.
     * @return Lista de AuthorDetailDTO convertida.     * 
     */
    private List<CriticaDetailDTO> listEntity2DTO(List<CriticaEntity> entityList) {
        List<CriticaDetailDTO> list = new ArrayList<>();
        for (CriticaEntity entity : entityList) {
            list.add(new CriticaDetailDTO(entity));
        }
        return list;
    }
}
