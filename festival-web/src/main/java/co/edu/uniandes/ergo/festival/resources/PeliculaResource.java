/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;

import co.edu.uniandes.ergo.festival.dtos.CalificacionDTO;
import co.edu.uniandes.ergo.festival.dtos.FuncionDTO;
import co.edu.uniandes.ergo.festival.dtos.FuncionDetailDTO;
import co.edu.uniandes.ergo.festival.dtos.PeliculaDetailDTO;
import co.edu.uniandes.ergo.festival.ejb.PeliculaLogic;
import co.edu.uniandes.ergo.festival.entities.CalificacionEntity;
import co.edu.uniandes.ergo.festival.entities.FuncionEntity;
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
import javax.xml.bind.annotation.XmlRootElement;

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

    /**
     * Método que obtiene todas las Películas.
     *
     * @return
     */
    @GET
    public List<PeliculaDetailDTO> getPeliculas() {
        return listEntity2DTO(logic.getPeliculas());
    }

    /**
     * Método que obtiene una Película específica.
     *
     * @param id Long, ID de la Película a buscar.
     * @return PeliculaDetailDTO, información de la Película consultada.
     * @throws BusinessLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public PeliculaDetailDTO getPeliculaById(@PathParam("id") Long id) throws BusinessLogicException {
        PeliculaEntity peli = logic.getPelicula(id);
        if (peli == null) {
            throw new WebApplicationException("La pelicula con id: " + id + " no existe.", 404);
        }
        return new PeliculaDetailDTO(peli);

    }

    /**
     * Método para crear una nueva Película.
     *
     * @param peli PeliculaDetailDTO, información de la Pelicula a c´rear.
     * @return PeliculaDetailDTO, Película creada.
     * @throws BusinessLogicException
     */
    @POST
    public PeliculaDetailDTO createPelicula(PeliculaDetailDTO peli) throws BusinessLogicException {
        System.out.println(peli.getname());
        return new PeliculaDetailDTO(logic.createPelicula(peli.toEntity()));
    }

    /**
     * Método para actualizar una Película.
     *
     * @param id Long, ID de la Película a actualizar.
     * @param peli PeliculaDetailDTO, nueva información de la Película.
     * @return PeliculaDetailDTO, información actualizada de la película.
     * @throws BusinessLogicException
     */
    @PUT
    @Path("{id: \\d+}")
    public PeliculaDetailDTO updatePelicula(@PathParam("id") Long id, PeliculaDetailDTO peli) throws BusinessLogicException {
        PeliculaEntity entity = peli.toEntity();
        entity.setId(id);
        return new PeliculaDetailDTO(logic.updatePelicula(id, entity));
    }

    /**
     * Método que borra una Película según su ID.
     *
     * @param id Long, ID de la Película a Borrar.
     * @throws BusinessLogicException
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deletePelicula(@PathParam("id") Long id) throws BusinessLogicException {
        PeliculaEntity entity = logic.getPelicula(id);
        if (entity == null) {
            throw new WebApplicationException("La silla con id: " + id + " no existe.", 404);
        }
        logic.deletePelicula(id);
    }

    /**
     * Método que asocia una Función a la Película.
     *
     * @param pelId Long, ID de Película.
     * @param funId Long, ID de la Función a asociar.
     * @return PeliculaDetailDTO, Información de la Película asociada.
     * @throws BusinessLogicException
     */
    @POST
    @Path("{id: \\d+}/funciones/{Fid: \\d+}")
    public PeliculaDetailDTO addFuncion(@PathParam("id") Long pelId, @PathParam("Fid") Long funId) throws BusinessLogicException {
        PeliculaEntity pelicula = logic.getPelicula(pelId);
        if (pelicula == null) {
            throw new WebApplicationException("La película con id: " + pelId + " no existe.", 404);
        }
        return new PeliculaDetailDTO(logic.addFuncion(pelId, funId));
    }

    /**
     * Método que obtiene las Funciones de una Película segun su ID.
     *
     * @param idpelicula Long, ID de la Película.
     * @return List<FuncionDTO>, Lista de Funciones que presentan la Película
     * con ID dado.
     * @throws BusinessLogicException
     */
    @GET
    @Path("{peliculaId: \\d+}/funciones/")
    public List<FuncionDTO> getFuncionespelicula(@PathParam("peliculaId") Long idpelicula) throws BusinessLogicException {
        PeliculaEntity pelicula = logic.getPelicula(idpelicula);
        if (pelicula == null) {
            throw new WebApplicationException("La película con id: " + idpelicula + " no existe.", 404);
        }
        return listFuncionEntity2listFuncionDTO(logic.getFunciones(idpelicula));
    }

    /**
     * Método que obtiene una Función específica de una Película.
     *
     * @param peliculaId Long, ID de la Película.
     * @param pelId Long, ID de la Función.
     * @return FuncionDetailDTO, Información de la Función asociada.
     * @throws BusinessLogicException
     */
    @GET
    @Path("{id: \\d+}/funciones/{FuncionId: \\d+}")
    public FuncionDetailDTO getFuncion(@PathParam("id") Long peliculaId, @PathParam("FuncionId") Long pelId) throws BusinessLogicException {
        PeliculaEntity pelicula = logic.getPelicula(peliculaId);
        if (pelicula == null) {
            throw new WebApplicationException("El crítico con id: " + peliculaId + " no existe.", 404);
        }
        return new FuncionDetailDTO(logic.getFuncion(peliculaId, pelId));
    }

    @GET
    @Path("{id: \\d+}/calificaciones")
    public List<CalificacionDTO> getCalificacionesFromPelicula(@PathParam("id") Long peliculaId) throws BusinessLogicException {
        PeliculaEntity pelicula = logic.getPelicula(peliculaId);
        if (pelicula == null) {
            throw new WebApplicationException("El crítico con id: " + peliculaId + " no existe.", 404);
        }
        return listCalificacionEntity2CalificacionDTO(logic.getCalificaciones(peliculaId));
    }

    @GET
    @Path("{id: \\d+}/promedioCalificaciones")
    public CalificacionDTO getPromedioCalificacionFromPelicula(@PathParam("id") Long peliculaId) throws BusinessLogicException {
        PeliculaEntity pelicula = logic.getPelicula(peliculaId);
        if (pelicula == null) {
            throw new WebApplicationException("El crítico con id: " + peliculaId + " no existe.", 404);
        }
        Double prom = logic.getCalificacionPromedioFromPelicula(peliculaId);
        CalificacionDTO calificacion = new CalificacionDTO();
        calificacion.setCalificacion(prom);
        return calificacion;
    }

    /**
     * Método que transforma una Lista de Entidades de Películas a sus versiones
     * DTOS.
     *
     * @param entityList LIst<PeliculaEntity>, Lista de Entidades de Películas.
     * @return List<PeliculaDetialDTO>, Lista de PeliculasDetailDTOS.
     */
    private List<PeliculaDetailDTO> listEntity2DTO(List<PeliculaEntity> entityList) {
        List<PeliculaDetailDTO> list = new ArrayList<>();
        for (PeliculaEntity entity : entityList) {
            list.add(new PeliculaDetailDTO(entity));
        }
        return list;
    }

    /**
     * Método que transforma una Lista de Entidades de Funciones a FuncionDTOs.
     *
     * @param funciones List<FuncionEntity>, Lista de Entidades de Función.
     * @return List<FuncionDTO>, Lista de Funciones DTO.
     */
    private List<FuncionDTO> listFuncionEntity2listFuncionDTO(List<FuncionEntity> funciones) {
        List<FuncionDTO> funcionesDTO = new ArrayList<>();

        for (FuncionEntity funcion : funciones) {
            funcionesDTO.add(new FuncionDTO(funcion));
        }
        return funcionesDTO;
    }

    private List<CalificacionDTO> listCalificacionEntity2CalificacionDTO(List<CalificacionEntity> entityList) {
        List<CalificacionDTO> list = new ArrayList<>();
        for (CalificacionEntity entity : entityList) {
            list.add(new CalificacionDTO(entity));
        }
        return list;
    }

}
