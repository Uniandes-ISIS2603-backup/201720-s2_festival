/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;

import co.edu.uniandes.ergo.festival.dtos.SalaDTO;
import co.edu.uniandes.ergo.festival.dtos.SalaDetailDTO;
import co.edu.uniandes.ergo.festival.dtos.TeatroDTO;
import co.edu.uniandes.ergo.festival.ejb.FestivalLogic;
import co.edu.uniandes.ergo.festival.entities.FestivalEntity;
import co.edu.uniandes.ergo.festival.entities.SalaEntity;
import co.edu.uniandes.ergo.festival.entities.TeatroEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author de.gutierrez
 */
@Path("festivales")
@Produces("application/json")
@Consumes("application/json")
public class FestivalTeatroResource 
{
    ///////teatros///////
    private FestivalLogic festivalLogic;
    
    
    @GET
    @Path("{festivalesId: \\d+}/teatros")
    public  List<TeatroDTO> getListTeatros(@PathParam("festivalesId") Long festivalId)
    {
        FestivalEntity festival = festivalLogic.getFestival(festivalId);
        if (festival == null)
        {
            throw new WebApplicationException("El festival con id: " + festivalId + " no existe.", 404);
        }
        return teatrosListEntity2DTO(festivalLogic.getTeatros(festivalId));
    }
    
    /**
     * 
     */
    @GET
    @Path("{festivalesId: \\d+}/teatros/{teatroId: \\d+}")
    public TeatroDTO getTeatro(@PathParam("festivalesId") Long festivalId, @PathParam("teatroId") Long teatroId)
    {
        FestivalEntity festival =festivalLogic.getFestival(festivalId);
        if (festival == null)
        {
            throw new WebApplicationException("El festival con id: " + festivalId + " no existe.", 404);
        }
        return new TeatroDTO(festivalLogic.getTeatro(festivalId, teatroId));
    }
    
    @POST
    @Path("{festivalesId: \\d+}/teatros/{teatroId: \\d+}")
    public TeatroDTO addTeatroFestival(@PathParam("festivalesId") Long festivalId, @PathParam("teatroId") Long teatroId)    
    {
        return new TeatroDTO(festivalLogic.addTeatro(festivalId, teatroId));
    }
    
    @PUT
   @Path("{festivalesId: \\d+}/teatros")
    public List<TeatroDTO> replaceTeatros(@PathParam("festivalesId") Long festivalId, List<TeatroEntity> teatros)
    {
        return teatrosListEntity2DTO(festivalLogic.replaceTeatros(festivalId, teatros));
    }
    
    /**
     * 
     */
    @DELETE
   @Path("{festivalesId: \\d+}/teatros/{teatroId: \\d+}")
    public void removeTeatro(@PathParam("festivalesId") Long festivalId, @PathParam("teatroId") Long teatroId)
    {
        festivalLogic.removeTeatro(festivalId, teatroId);
    }

    /**
     * 
     * @param entityList
     * @return 
     */
    private List<TeatroDTO> teatrosListEntity2DTO(List<TeatroEntity>  entityList)
    {
        List<TeatroDTO> list = new ArrayList<>();
        for(TeatroEntity entity : entityList)
        {
            list.add(new TeatroDTO(entity));
        }
        return list;
    }
}
