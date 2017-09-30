/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;

import co.edu.uniandes.ergo.festival.dtos.PeliculaDTO;
import co.edu.uniandes.ergo.festival.dtos.PeliculaDetailDTO;
import co.edu.uniandes.ergo.festival.ejb.CriticoLogic;
import co.edu.uniandes.ergo.festival.ejb.PeliculaLogic;
import co.edu.uniandes.ergo.festival.entities.CriticoEntity;
import co.edu.uniandes.ergo.festival.entities.PeliculaEntity;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
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
 * @author dj.bautista10
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CriticoPeliculaResource {

    @Inject
    private CriticoLogic criticoLogic;
    @Inject
    private PeliculaLogic peliculaLogic;

    @GET
    public List<PeliculaDTO> getPeliculasCritico(@PathParam("CriticoId") Long idCritico) throws BusinessLogicException {
        CriticoEntity critico = criticoLogic.getCritico(idCritico);
        if (critico == null) {
            throw new WebApplicationException("El crítico con id: " + idCritico + " no existe.", 404);
        }
        return listEntity2listDTO(criticoLogic.getPeliculas(idCritico));
    }

    @GET
    @Path("{PeliculaId: \\d+}")
    public PeliculaDetailDTO getPelicula(@PathParam("CriticoId") Long criticoId, @PathParam("PeliculaId") Long pelId) throws BusinessLogicException {
        CriticoEntity critico = criticoLogic.getCritico(criticoId);
        if (critico == null) {
            throw new WebApplicationException("El crítico con id: " + criticoId + " no existe.", 404);
        }
        return new PeliculaDetailDTO(criticoLogic.getPelicula(criticoId, pelId));
    }

    @POST
    @Path("{PeliculaId: \\d+}")
    public PeliculaDetailDTO addPelicula(@PathParam("PeliculaId") Long pelId, @PathParam("CriticoId") Long crId) throws BusinessLogicException {
        CriticoEntity critico = criticoLogic.getCritico(crId);
        if (critico == null) {
            throw new WebApplicationException("El crítico con id: " + crId + " no existe.", 404);
        }
        return new PeliculaDetailDTO(criticoLogic.addPelicula(crId, pelId));
    }
    
    @DELETE
    @Path("{PeliculaId: \\d+}")
    public void removePelicula(@PathParam("CriticoId") Long crId, @PathParam("PeliculaId") Long pelId) throws BusinessLogicException{
        criticoLogic.removePelicula(crId, pelId);
    }

    private List<PeliculaDTO> listEntity2listDTO(List<PeliculaEntity> peliculas) {
        List<PeliculaDTO> pelisDTO = new ArrayList<>();

        for (PeliculaEntity peli : peliculas) {
            pelisDTO.add(new PeliculaDTO(peli));
        }
        return pelisDTO;
    }

    
}
