/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;

import co.edu.uniandes.ergo.festival.dtos.CriticaDTO;
import co.edu.uniandes.ergo.festival.dtos.CriticaDetailDTO;
import co.edu.uniandes.ergo.festival.dtos.CriticoDetailDTO;
import co.edu.uniandes.ergo.festival.ejb.CriticaLogic;
import co.edu.uniandes.ergo.festival.ejb.CriticoLogic;
import co.edu.uniandes.ergo.festival.entities.CriticaEntity;
import co.edu.uniandes.ergo.festival.entities.CriticoEntity;
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
 * @author f.reyes948
 */
@Path("/criticas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class CriticaResource {
    
    @Inject
    private CriticaLogic criticaLogic;
    
    @Inject CriticoLogic criticoLogic;
    
    /**
     * Crea una nueva CriticaEntity.
     * @param dto información de la CriticaEntity.
     * @return Un CriticaDTO con la información de la nueva entidad.
     */
    @POST
    public CriticaDTO createCritica(CriticaDTO dto){
        return new CriticaDTO(criticaLogic.createCritica(dto.toEntity()));
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
    public List<CriticaDTO> getCriticas(){
        return listEntity2DTO(criticaLogic.getCriticas());
    }
    
    /**
     * Actualiza la informaición de la CriticaEntity con el id especificado.
     * @param id de la CriticaEntity a actualizar.
     * @param dto nueva información de la CriticaEntity.
     * @return Un CriticaDTO con la nueva información del CriticaEntity.
     */
    @PUT
    @Path("{id: \\d+}")
    public CriticaDTO updateCritica(@PathParam("id") Long id, CriticaDTO dto){
        CriticaEntity oldEntity = criticaLogic.getCritica(id);
        if (oldEntity == null){
            throw new WebApplicationException("La crítica con id: " + id + " no existe.", 404);
        }
        CriticaEntity entity = dto.toEntity();
        entity.setId(id);
        return new CriticaDTO(criticaLogic.updateCritica(entity));
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
     * Convierte una lista de CriticaEntity a una lista de CriticaDTO.     
     * @param entityList Lista de CriticaEntity a convertir.
     * @return Lista de CriticaDTO convertida.      
     */
    private List<CriticaDTO> listEntity2DTO(List<CriticaEntity> entityList) {
        List<CriticaDTO> list = new ArrayList<>();
        for (CriticaEntity entity : entityList) {
            list.add(new CriticaDTO(entity));
        }
        return list;
    }
    
    /**
     * Asocia una CriticoEntity a una CriticaEntity.
     * @param criticasid Identificación de la CriticaEntity.
     * @param criticoid Identificación de la CriticoEntity.
     * @return La CriticoEntity en Representación Detail.
     */
    @POST
    @Path("{criticasid: \\d+}/critico/{criticoid: \\d+}")
    public CriticoDetailDTO setCritico(@PathParam("criticasid") Long criticasid, 
            @PathParam("criticoid") Long criticoid){
        CriticoEntity critico = criticoLogic.getCritico(criticoid);
        CriticaEntity critica = criticaLogic.getCritica(criticasid);
        if (critica == null){
            throw new WebApplicationException("La CriticaEntity con id: " + criticasid + " no existe.", 404);
        } else if (critico == null){
            throw new WebApplicationException("La CriticoEntity con id: " + criticoid + " no existe.", 404);
        }
        return new CriticoDetailDTO(criticaLogic.setCriticoCritica(criticasid, criticoid));
    }
    
    /**
     * Retorna la CriticoEntity asociada a una CriticaEntity.
     * @param id de la CriticaEntity.
     * @return Representacion Detail de la CriticoEntity asociada.
     */
    @GET
    @Path("{id: \\d+}/critico")
    public CriticoDetailDTO getCriticoCritica(@PathParam("id") Long id){
        CriticaEntity critica = criticaLogic.getCritica(id);
        if (critica == null){
            throw new WebApplicationException("La CriticaEntity con id: " + id + " no existe.", 404);
        }
        CriticoEntity critico = criticaLogic.getCriticoCritica(id);
        if (critico == null){
            return new CriticoDetailDTO();
        }
        return new CriticoDetailDTO(critico);
    }
    
    /**
     * Quita la CriticoEntity de una CriticaEntity.
     * @param criticasid Identificación de la CriticaEntity.
     * @throws BusinessLogicException Si la CriticaEntity no tiene una CriticoEntity 
     * asociada.
     */
    @DELETE
    @Path("{criticasid: \\d+}/critico")
    public void deleteCriticoCritica(@PathParam("criticasid") Long criticasid) 
            throws BusinessLogicException{
        CriticaEntity critica = criticaLogic.getCritica(criticasid);    
        if (critica == null){
            throw new WebApplicationException("La CriticaEntity con id: " + criticasid + " no existe.", 404);
        } 
        criticaLogic.deleteCriticoCritica(criticasid);
    }


}
