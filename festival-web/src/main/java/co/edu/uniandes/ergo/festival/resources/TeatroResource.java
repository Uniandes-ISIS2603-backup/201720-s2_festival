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
     * 
     * @return 
     */
    @GET
    public List<TeatroDetailDTO> getTeatros()
    {
        return listTeatroEntity2DTO(teatroLogic.getTeatros());
    }
    /** 
     * @param id
     * @return 
     */
    @GET
    @Path("{id: \\d+}")
    public TeatroDetailDTO getTeatro(@PathParam ("id")Long id)
    {
        TeatroEntity entity = teatroLogic.getTeatro(id);
        if(entity == null)
        {
            throw new WebApplicationException("El teatro con id: " + id + " no existe.", 404);
        }
        return new TeatroDetailDTO(teatroLogic.getTeatro(id));
    }
    
    /**
     * 
     * @param id
     * @param teatro
     * @return 
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
     * 
     * @param id
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
     * 
     * @param list
     * @return 
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
     * 
     * @param teatroId
     * @return 
     */
    @GET
    @Path("{teatrosId:\\d+ }/salas")
    public  List<SalaDTO> getListSalas(@PathParam("teatrosId") Long teatroId)
    {
        TeatroEntity teatro = teatroLogic.getTeatro(teatroId);
        if (teatro == null)
        {
            throw new WebApplicationException("El teatro con id: " + teatroId + " no existe.", 404);
        }
        return salasListEntity2DTO(teatroLogic.getSalas(teatroId));
    }
    
    /**
     * 
     */
    @GET
    @Path("{teatrosId:\\d+ }/salas")
    public SalaDTO getSala(@PathParam("teatrosId") Long teatroId, @PathParam("salasId") Long salasId)
    {
        TeatroEntity teatro = teatroLogic.getTeatro(teatroId);
        if (teatro == null)
        {
            throw new WebApplicationException("El teatro con id: " + teatroId + " no existe.", 404);
        }
        return new SalaDTO(teatroLogic.getSala(teatroId, salasId));
    }
    
    @POST
    @Path("{teatrosId:\\d+ }/salas")
    public SalaDTO addSalaTeatro(@PathParam("teatrosId") Long teatroId, @PathParam("salasId") Long salasId)    
    {
        return new SalaDTO(teatroLogic.addSala(teatroId, salasId));
    }
    
    @PUT
    @Path("{teatrosId:\\d+ }/salas")
    public List<SalaDTO> replaceSalas(@PathParam("teatrosId") Long teatrosId, List<SalaEntity> salas)
    {
        return salasListEntity2DTO(teatroLogic.replaceSalas(teatrosId, salas));
    }
    
    /**
     * 
     */
    @DELETE
    @Path("{teatrosId:\\d+ }/salas")
    public void removeSalas(@PathParam("teatrosId") Long teatrosId, @PathParam("salasId") Long salasId)
    {
        teatroLogic.removeSala(teatrosId, salasId);
    }

    /**
     * 
     * @param entityList
     * @return 
     */
    private List<SalaDTO> salasListEntity2DTO(List<SalaEntity>  entityList)
    {
        List<SalaDTO> list = new ArrayList<>();
        for(SalaEntity entity : entityList)
        {
            list.add(new SalaDetailDTO( entity));
        }
        return list;
    }
    
}
