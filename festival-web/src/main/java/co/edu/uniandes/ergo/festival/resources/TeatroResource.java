/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;

import co.edu.uniandes.ergo.festival.dtos.SalaDTO;
import co.edu.uniandes.ergo.festival.dtos.SalaDetailDTO;
import co.edu.uniandes.ergo.festival.dtos.TeatroDetailDTO;
import co.edu.uniandes.ergo.festival.ejb.TeatroLogic;
import co.edu.uniandes.ergo.festival.entities.SalaEntity;
import co.edu.uniandes.ergo.festival.entities.TeatroEntity;
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
 * @author de.gutierrez
 */
@Path("/teatros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class TeatroResource 
{
    /**
     * Atributo que contiene la injección a teatroLogic.
     */
    @Inject 
    private TeatroLogic teatroLogic;
    
    /** 
     * @param teatro
     * @return 
     * @throws BusinessLogicException
     */
    @POST
    public TeatroDetailDTO createTeatro(TeatroDetailDTO teatro) throws BusinessLogicException
    {
        return new TeatroDetailDTO(teatroLogic.createTeatro(teatro.toEntity()));
    }
    
    /**
     * Método que obtiene los Teatros.
     * @return List<TeatroDetailDTO>, lita de Teatros.
     */
    @GET
    public List<TeatroDetailDTO> getTeatros()
    {
        return listTeatroEntity2DTO(teatroLogic.getTeatros());
    }
    /** 
     * Método que obtiene une Teatro dado su ID.
     * @param id Long, ID del teatro.
     * @return TeatroDetailDTO, Teatro.
     */
    @GET
    @Path("{id: \\d+}")
    public TeatroDetailDTO getTeatro(@PathParam ("id") Long id)
    {
        TeatroEntity entity = teatroLogic.getTeatro(id);
        if(entity == null)
        {
            throw new WebApplicationException("El teatro con id: " + id + " no existe.", 404);
        }
        return new TeatroDetailDTO(teatroLogic.getTeatro(id));
    }
    
    /**
     * Método que actualiza un Teatro con información nueva.
     * @param id Long, ID del Teatro a actualizar.
     * @param teatro TeatroDetailDTO, nueva información del Teatro.
     * @return  TeatroDetailDTO, Teatro actualizado.
     */
    @PUT
    @Path("{id: \\d+}")    
    public TeatroDetailDTO updateTeatro(@PathParam("id") Long id, TeatroDetailDTO teatro)
    {
        TeatroEntity entity = teatroLogic.getTeatro(id);
        if(entity == null)
        {
            throw new WebApplicationException("El teatro con id: " + id + " no existe.", 404);
        }
        teatro.setId(id);
        return new TeatroDetailDTO(teatroLogic.updateTeatro(id, teatro.toEntity()));
    }
    
    /**
     * Método que borra un Teatro dado su ID.
     * @param id Long, ID del Teatro a Borrar.
     */
    @DELETE
    @Path("{id: \\d+}")  
    public void deleteTeatro(@PathParam("id") Long id)
    {
        TeatroEntity teatroEntity = teatroLogic.getTeatro(id);
        if(teatroEntity == null)
        {
             throw new WebApplicationException("El teatro con id: " + id + " no existe.", 404);
        }
        teatroLogic.deleteTeatro(id);
    }
    
    /**
     * Método que convierte la lista de Teatros a DTOs
     * @param list List<TeatroEntity>, Lista de teatros.
     * @return list List<TeatroDetailDTO
     */
    public List<TeatroDetailDTO> listTeatroEntity2DTO(List<TeatroEntity> list)
    {
        List<TeatroDetailDTO> listaTeatros = new ArrayList<>();
        for(TeatroEntity teatro : list)
        {
            listaTeatros.add(new TeatroDetailDTO(teatro));
        }
        return listaTeatros;
    }
      
    ///////salas///////
    
    /**
     * Método que obtiene las salas de un Teatro.
     * @param id Long, ID del Teatro.
     * @return List<SalaDTO>, lista de Salas de un Teatro.
     */
    @GET
    @Path("{id: \\d+ }/salas")
    public  List<SalaDTO> getListSalas(@PathParam("id") Long id)
    {
        TeatroEntity teatro = teatroLogic.getTeatro(id);
        if (teatro == null)
        {
            throw new WebApplicationException("El teatro con id: " + id + " no existe.", 404);
        }
        return salasListEntity2DTO(teatroLogic.getSalas(id));
    }
    
    /**
     * Método que obtiene una sala específca de un teatro.
     * @param teatroId Long, ID del Teatro.
     * @param salasId Long, ID de la Sala del Teatro.
     * @return SalaDTO.
     */
    @GET
    @Path("{TeatroId: \\d+ }/salas/{salasId: \\d+ }")
    public SalaDTO getSala(@PathParam("TeatroId") Long teatroId, @PathParam("salasId") Long salasId)
    {
        TeatroEntity teatro = teatroLogic.getTeatro(teatroId);
        if (teatro == null)
        {
            throw new WebApplicationException("El teatro con id: " + teatroId + " no existe.", 404);
        }
        return new SalaDTO(teatroLogic.getSala(teatroId, salasId));
    }
    /**
     * Método que asocia una Sala a un Teatro.
     * @param teatroId Long, ID del Teatro.
     * @param salasId Long, ID de la Sala a asociar.
     * @return SalaDTO, Sala asociada.
     */
    @POST
    @Path("{TeatroId: \\d+ }/salas/{salasId: \\d+ }")
    public SalaDTO addSalaTeatro(@PathParam("TeatroId") Long teatroId, @PathParam("salasId") Long salasId)    
    {
        return new SalaDTO(teatroLogic.addSala(teatroId, salasId));
    }
    /**
     * Método que actualiza una Sala de un Teatro.
     * @param TeatroId Long, ID del teatro.
     * @param salas List<SalaEntity>, 
     * @return 
     */
    @PUT
    @Path("{TeatroId: \\d+ }/salas")
    public List<SalaDTO> replaceSalas(@PathParam("TeatroId") Long TeatroId, List<SalaEntity> salas)
    {
        return salasListEntity2DTO(teatroLogic.replaceSalas(TeatroId, salas));
    }
    
    /**
     * Método que elimina una Sala de un Teatro.
     * @param TeatroId Long, ID del Teatro.
     * @param salasId Long, ID de la Sala.
     */
    @DELETE
    @Path("{TeatroId: \\d+ }/salas/{salasId: \\d+ }")
    public void removeSalas(@PathParam("TeatroId") Long TeatroId, @PathParam("salasId") Long salasId)
    {
        teatroLogic.removeSala(TeatroId, salasId);
    }

    /**
     * Método que convierte una lista de entidades de sala a una lista de DTOS de Sala.
     * @param entityList List<SalaEntity>, Entidades de Salas.
     * @return List<SalaDTO>, DTOS de Salas.
     */
    private List<SalaDTO> salasListEntity2DTO(List<SalaEntity>  entityList)
    {
        List<SalaDTO> list = new ArrayList<>();
        for(SalaEntity entity : entityList)
        {
            list.add(new SalaDTO( entity));
        }
        return list;
    }
    
}
