/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;
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

    /**
     * Atributo que contiene la Lógica principal de este Recurso.
     */
    @Inject
    private CriticoLogic logic;
    /**
     * Método que obtiene una Lista con todos los Críticos.
     * @return List<CriticoDetailDTO>, Lista con todos los Críticos.
     */
    @GET
    public List<CriticoDetailDTO> getCriticos() {
        return listEntity2DTO(logic.getCriticos());
    }
    /**
     * Método que obtiene un Crítico según su ID.
     * @param id Long, ID del Crítico a buscar.
     * @return CriticoDetailDTO, información del Crítico a buscar.
     */
    @GET
    @Path("{id: \\d+}")
    public CriticoDetailDTO getCriticoById(@PathParam("id") Long id) {
        CriticoEntity cri = logic.getCritico(id);
        if (cri == null) {
            throw new WebApplicationException("El critico con id: " + id + " no existe.", 404);
        }
        return new CriticoDetailDTO(cri);

    }
    /**
     * Método que crea un nuevo Crítico.
     * @param cri CriticoDetailDTO, toda la Información del Crítico.
     * @return CriticoDetailDTO, información del Crítico creado.
     * @throws BusinessLogicException 
     */
    @POST
    public CriticoDetailDTO createCritico(CriticoDetailDTO cri) throws BusinessLogicException {
        return new CriticoDetailDTO(logic.createCritico(cri.toEntity()));
    }
    /**
     * Método que actualiza la información de un Crítico.
     * @param id Long, ID del Crítico a actualizar.
     * @param cri CriticoDetailDTO, nueva información del Crítico.
     * @return CriticoDetailDTO, información actualizada del Crítico.
     * @throws BusinessLogicException 
     */
    @PUT
    @Path("{id: \\d+}")
    public CriticoDetailDTO updateCritico(@PathParam("id") Long id, CriticoDetailDTO cri) throws BusinessLogicException {
        CriticoEntity entity = cri.toEntity();
        entity.setId(id);
        return new CriticoDetailDTO(logic.updateCritico(id, entity));
    }
    /**
     * Método que borra un Crítico según su ID.
     * @param id Long, ID del Crítico a eliminar.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCritico(@PathParam("id") Long id) {
        CriticoEntity entity = logic.getCritico(id);
        if (entity == null) {
            throw new WebApplicationException("El crítico con id: " + id + " no existe.", 404);
        }
        logic.deleteCritico(id);
    }
    /**
     * Método que transforma una Lsita de Entidades de Crítico a una Lista de DTOS de Críticos.
     * @param entityList List<CriticoEntity>, Lista de Entidades de Críticos.
     * @return List<CriticoDetailDTO>, Lista de DTOS de Críticos.
     */
    private List<CriticoDetailDTO> listEntity2DTO(List<CriticoEntity> entityList) {
        List<CriticoDetailDTO> list = new ArrayList<>();
        for (CriticoEntity entity : entityList) {
            list.add(new CriticoDetailDTO(entity));
        }
        return list;
    }
    /**
     * Método que transforma una Lista de Entidades de Película a una Lista de DTOS de Películas.
     * @param pelis List<PeliculaEntity>, Lista de Entidades de Película.
     * @return List<PeliculaDTO>, Lista de DTOS de Películas.
     */
    private List<PeliculaDTO> listPeliEntity2DTO(List<PeliculaEntity> pelis) {
        List<PeliculaDTO> rta = new ArrayList<>();
        for (PeliculaEntity peli : pelis) {
            rta.add(new PeliculaDTO(peli));
        }
        return rta;
    }
    /**
     * Método que obtiene la Películas de un Crítico.
     * @param id Long, ID del Crítico.
     * @return Class<CriticoPeliculaResource>
     * @throws WebApplicationException 
     */
    @Path("{CriticoId: \\d+}/peliculas")
    public Class<CriticoPeliculaResource> getCriticoPeliculaResource(@PathParam("CriticoId") Long id) throws WebApplicationException{
        CriticoEntity critico = logic.getCritico(id);
        if(critico == null){
            throw new WebApplicationException("El crítico no existe", 404);
        }
        return CriticoPeliculaResource.class;
    }
}
