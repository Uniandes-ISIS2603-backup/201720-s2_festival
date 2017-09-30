/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;

import co.edu.uniandes.ergo.festival.dtos.*;
import co.edu.uniandes.ergo.festival.ejb.FestivalLogic;
import co.edu.uniandes.ergo.festival.entities.FestivalEntity;
import co.edu.uniandes.ergo.festival.entities.*;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author de.gutierrez
 */
public class FestivalPeliculaResource
{
     ///////teatros///////
    private FestivalLogic festivalLogic;
    
    
    @GET
    @Path("{festivalesId:\\d+ }/peliculas")
    public  List<PeliculaDTO> getListTeatros(@PathParam("festivalesId") Long festivalId)
    {
        FestivalEntity festival = festivalLogic.getFestival(festivalId);
        if (festival == null)
        {
            throw new WebApplicationException("El festival con id: " + festivalId + " no existe.", 404);
        }
        return peliculasListEntity2DTO(festivalLogic.getPeliculas(festivalId));
    }
    
    /**
     * 
     */
    @GET
    @Path("{festivalesId:\\d+ }/peliculas")
    public PeliculaDTO getPelicula(@PathParam("festivalesId") Long festivalId, @PathParam("teatrosId") Long peliculasId)
    {
        FestivalEntity festival =festivalLogic.getFestival(festivalId);
        if (festival == null)
        {
            throw new WebApplicationException("El festival con id: " + festivalId + " no existe.", 404);
        }
        return new PeliculaDTO(festivalLogic.getPelicula(festivalId, peliculasId));
    }
    
    @POST
    @Path("{festivalesId:\\d+ }/peliculas")
    public PeliculaDTO addTeatroFestival(@PathParam("festivalesId") Long festivalId, @PathParam("teatrosId") Long peliculasId) throws BusinessLogicException    
    {
        return new PeliculaDTO(festivalLogic.addPelicula(festivalId, peliculasId));
    }
    
    @PUT
   @Path("{festivalesId:\\d+ }/peliculas")
    public List<PeliculaDTO> replaceTeatros(@PathParam("festivalesId") Long festivalId, List<PeliculaEntity> peliculas)
    {
        return peliculasListEntity2DTO(festivalLogic.replacePelicula(festivalId, peliculas));
    }
    
    /**
     * 
     */
    @DELETE
  @Path("{festivalesId:\\d+ }/peliculas")
    public void removeTeatro(@PathParam("festivalesId") Long festivalId, @PathParam("teatrosId") Long peliculasId) throws BusinessLogicException
    {
        festivalLogic.removePelicula(festivalId, peliculasId);
    }

    /**
     * 
     * @param entityList
     * @return 
     */
    private List<PeliculaDTO> peliculasListEntity2DTO(List<PeliculaEntity>  entityList)
    {
        List<PeliculaDTO> list = new ArrayList<>();
        for(PeliculaEntity entity : entityList)
        {
            list.add(new PeliculaDTO(entity));
        }
        return list;
    }
}
