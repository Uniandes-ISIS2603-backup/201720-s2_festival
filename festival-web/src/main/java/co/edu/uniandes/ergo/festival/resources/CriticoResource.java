/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;

import co.edu.uniandes.ergo.festival.dtos.CriticoDTO;
import co.edu.uniandes.ergo.festival.dtos.CriticoDetailDTO;
import co.edu.uniandes.ergo.festival.dtos.PeliculaDTO;
import co.edu.uniandes.ergo.festival.ejb.CriticoLogic;
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
@Path("/criticos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class CriticoResource {

    @Inject
    private CriticoLogic logic;

    @GET
    public List<CriticoDetailDTO> getCriticos() {
        return listEntity2DTO(logic.getCriticos());
    }

    @GET
    @Path("{id: \\d+}")
    public CriticoDetailDTO getCriticoById(@PathParam("id") Long id) {
        CriticoEntity cri = logic.getCritico(id);
        if (cri == null) {
            throw new WebApplicationException("El critico con id: " + id + " no existe.", 404);
        }
        return new CriticoDetailDTO(cri);

    }

    @POST
    public CriticoDetailDTO createCritico(CriticoDetailDTO cri) throws BusinessLogicException {
        return new CriticoDetailDTO(logic.createCritico(cri.toEntity()));
    }

    @PUT
    @Path("{id: \\d+}")
    public CriticoDetailDTO updateCritico(@PathParam("id") Long id, CriticoDetailDTO cri) throws BusinessLogicException {
        CriticoEntity entity = cri.toEntity();
        entity.setId(id);
        return new CriticoDetailDTO(logic.updateCritico(id, entity));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteCritico(@PathParam("id") Long id) {
        CriticoEntity entity = logic.getCritico(id);
        if (entity == null) {
            throw new WebApplicationException("El crítico con id: " + id + " no existe.", 404);
        }
        logic.deleteCritico(id);
    }

    private List<CriticoDetailDTO> listEntity2DTO(List<CriticoEntity> entityList) {
        List<CriticoDetailDTO> list = new ArrayList<>();
        for (CriticoEntity entity : entityList) {
            list.add(new CriticoDetailDTO(entity));
        }
        return list;
    }
    
    @GET
    @Path("{criticosid: \\d+}/peliculas")
    public List<PeliculaDTO> getPeliculasCritico(@PathParam("criticosid") Long 
            criticosid){
        CriticoEntity entity = logic.getCritico(criticosid);
        if (entity == null) {
            throw new WebApplicationException("El crítico con id: " + criticosid
                    + " no existe.", 404);
        }
        return listPelicula2DTO(logic.getPeliculasCritico(criticosid));
    }
    
    @PUT
    @Path("{criticosid: \\d+}/peliculas")
    public CriticoDetailDTO updatePeliculasCritico(@PathParam("criticosid") Long
            criticosid, List<PeliculaDTO> peliculas){
        CriticoEntity entity = logic.getCritico(criticosid);
        if (entity == null) {
            throw new WebApplicationException("El crítico con id: " + criticosid
                    + " no existe.", 404);
        }
        return new CriticoDetailDTO(
                logic.updatePeliculasCritico(criticosid, 
                        listDTO2Pelicula(peliculas)));
    }
    
    /**
     * Convierte una lista de PeliculaEntity a DTO.
     * @param peliculas La lista de las PeliculaEntity.
     * @return La lista de las PeliculaDTO.
     */
    private List<PeliculaDTO> listPelicula2DTO(List<PeliculaEntity> peliculas){
        List<PeliculaDTO> peliculasDTO = new ArrayList();
        for (PeliculaEntity pelicula : peliculas){
            peliculasDTO.add(new PeliculaDTO(pelicula));
        }
        return peliculasDTO;
    }
    
    /**
     * Convierte una lista de PeliculaDTO a PeliculaEntity.
     * @param peliculas Listado de PeliculaDTO.
     * @return Lista de PeliculaEntity.
     */
    private List<PeliculaEntity> listDTO2Pelicula(List<PeliculaDTO> peliculas){
        List<PeliculaEntity> peliculasEntity = new ArrayList();
        for (PeliculaDTO pelicula : peliculas){
            peliculasEntity.add(pelicula.toEntity());
        }
        return peliculasEntity;
    }
}
