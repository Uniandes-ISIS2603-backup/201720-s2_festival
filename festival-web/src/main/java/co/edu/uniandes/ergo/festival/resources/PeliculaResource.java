/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;

import co.edu.uniandes.ergo.festival.dtos.PeliculaDTO;
import co.edu.uniandes.ergo.festival.dtos.PeliculaDetailDTO;
import co.edu.uniandes.ergo.festival.ejb.PeliculaLogic;
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
@Path("/peliculas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class PeliculaResource {

    @Inject
    private PeliculaLogic logic;

    @GET
    public List<PeliculaDetailDTO> getPeliculas() {
        return listEntity2DTO(logic.getPeliculas());
    }

    @GET
    @Path("{id: \\d+}")
    public PeliculaDetailDTO getPeliculaById(@PathParam("id") Long id) {
        PeliculaEntity peli = logic.getPelicula(id);
        if (peli == null) {
            throw new WebApplicationException("La pelicula con id: " + id + " no existe.", 404);
        }
        return new PeliculaDetailDTO(peli);

    }

    @POST
    public PeliculaDetailDTO createPelicula(PeliculaDetailDTO peli) throws BusinessLogicException {
        return new PeliculaDetailDTO(logic.createPelicula(peli.toEntity()));
    }

    @PUT
    @Path("{id: \\d+}")
    public PeliculaDetailDTO updatePelicula(@PathParam("id") Long id, PeliculaDetailDTO peli) throws BusinessLogicException {
        PeliculaEntity entity = peli.toEntity();
        entity.setId(id);
        return new PeliculaDetailDTO(logic.updatePelicula(id, entity));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deletePelicula(@PathParam("id") Long id) {
        PeliculaEntity entity = logic.getPelicula(id);
        if (entity == null) {
            throw new WebApplicationException("La silla con id: " + id + " no existe.", 404);
        }
        logic.deletePelicula(id);
    }

    private List<PeliculaDetailDTO> listEntity2DTO(List<PeliculaEntity> entityList) {
        List<PeliculaDetailDTO> list = new ArrayList<>();
        for (PeliculaEntity entity : entityList) {
            list.add(new PeliculaDetailDTO(entity));
        }
        return list;
    }
}