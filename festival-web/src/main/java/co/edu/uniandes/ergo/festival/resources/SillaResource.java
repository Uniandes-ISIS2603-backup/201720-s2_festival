/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;

import co.edu.uniandes.ergo.festival.dtos.BoletaDTO;
import co.edu.uniandes.ergo.festival.dtos.SalaDetailDTO;
import co.edu.uniandes.ergo.festival.dtos.SillaDTO;
import co.edu.uniandes.ergo.festival.dtos.SillaDetailDTO;
import co.edu.uniandes.ergo.festival.ejb.SillaLogic;
import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.entities.SalaEntity;
import co.edu.uniandes.ergo.festival.entities.SillaEntity;
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
    public SillaDetailDTO createSilla(SillaDetailDTO dto) throws BusinessLogicException{
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
     * @return Una lista con las SillaDTO.
     */
    @GET
    public List<SillaDTO> getSillas(){
        return listSillaEntity2DTO(sillaLogic.getSillas());
    }
    
    /**
     * Actualiza la informaición de la SillaEntity con el id especificado.
     * @param id de la SillaEntity a actualizar.
     * @param dto nueva información de la SillaEntity.
     * @return Un SillaDTO con la nueva información del SillaEntity.
     */
    @PUT
    @Path("{id: \\d+}")
    public SillaDTO updateSilla(@PathParam("id") Long id, SillaDTO dto){
        SillaEntity oldEntity = sillaLogic.getSilla(id);
        if (oldEntity == null){
            throw new WebApplicationException("La silla con id: " + id + " no existe.", 404);
        }
        SillaEntity entity = dto.toEntity();
        entity.setId(id);
        return new SillaDTO(sillaLogic.updateSilla(entity));
    }
    
    /**
     * Elimina la SillaEntity con el id especificado.
     * @param id de la SillaEntity a eliminar.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteSilla(@PathParam("id") Long id) throws BusinessLogicException{
        SillaEntity entity = sillaLogic.getSilla(id);
        if (entity == null){
            throw new WebApplicationException("La silla con id: " + id + " no existe.", 404);
        }
        sillaLogic.deleteSilla(id);
    }
            
    /**
     * Convierte una lista de SillaEntity a una lista de SillaDTO.     *
     * @param entityList Lista de SillaEntity a convertir.
     * @return Lista de SillaDTO convertida.     * 
     */
    private List<SillaDTO> listSillaEntity2DTO(List<SillaEntity> entityList) {
        List<SillaDTO> list = new ArrayList<>();
        for (SillaEntity entity : entityList) {
            list.add(new SillaDTO(entity));
        }
        return list;
    }    
    
    /**
     * Retorna las BoletaEntity asociadas a una SillaEntity.
     * @param id de la SillaEntity.
     * @return Lista con los DTO de las BoletaEntity asociadas.
     */
    @GET
    @Path("{id: \\d+}/boletas")
    public List<BoletaDTO> getBoletasSilla(@PathParam("id") Long id){
        SillaEntity silla = sillaLogic.getSilla(id);
        if (silla == null){
            throw new WebApplicationException("La SillaEntity con id: " + id + " no existe.", 404);
        }
        return listBoletaEntity2DTO(sillaLogic.getBoletasSilla(id));
    }
    
//    /**
//     * Quita una BoletaEntity de una SillaEntity.
//     * @param sillasid Identificación de la SillaEntity.
//     * @param boletasid Identificación de la BoletaEntity.
//     * @throws BusinessLogicException Si la BoletaEntity no tiene una SillaEntity 
//     * asociada o si la BoletaEntity no está asociada a la SillaEntity especificada.
//     */
//    @DELETE
//    @Path("{sillasid: \\d+}/boletas/{boletasid: \\d+}")
//    public void deleteBoletaSilla(@PathParam("sillasid") Long sillasid, 
//            @PathParam("boletasid") Long boletasid) throws BusinessLogicException{
//        BoletaEntity boleta = boletaLogic.getBoleta(boletasid);
//        SillaEntity silla = sillaLogic.getSilla(sillasid);
//        if (silla == null){
//            throw new WebApplicationException("La SillaEntity con id: " + sillasid + " no existe.", 404);
//        } else if (boleta == null){
//            throw new WebApplicationException("La BoletaEntity con id: " + boletasid + " no existe.", 404);
//        }
//        sillaLogic.deleteBoletaSilla(sillasid, boletasid);
//    }
    
    /**
     * Convierte una lista de BolataEntity en BoletaDTO.
     * @param entityList Lista de los Entity.
     * @return Una lista con los DTO.
     */
    private List<BoletaDTO> listBoletaEntity2DTO(List<BoletaEntity> entityList) {
        List<BoletaDTO> list = new ArrayList<>();
        for (BoletaEntity entity : entityList) {
            list.add(new BoletaDTO(entity));
        }
        return list;
    }    
    /**
     * Retorna la SalaEntity asociada a una SillaEntity.
     * @param id de la SillaEntity.
     * @return Representación Detail de la SalaEntity asociada.
     */
    @GET
    @Path("{id: \\d+}/sala")
    public SalaDetailDTO getSalaSilla(@PathParam("id") Long id){
        SillaEntity silla = sillaLogic.getSilla(id);
        if (silla == null){
            throw new WebApplicationException("La SillaEntity con id: " + id + " no existe.", 404);
        }
        SalaEntity sala = sillaLogic.getSalaSilla(id);
        if (sala == null){
            return new SalaDetailDTO();
        }
        return new SalaDetailDTO(sala);
    }
}
