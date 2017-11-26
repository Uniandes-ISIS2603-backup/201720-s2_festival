/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;


import co.edu.uniandes.ergo.festival.dtos.SalaDetailDTO;
import co.edu.uniandes.ergo.festival.ejb.SalaLogic;
import co.edu.uniandes.ergo.festival.entities.SalaEntity;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author f.mayenberger10
 */

@Path("/salas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class SalaResource {
    
    @Inject
    private SalaLogic logic;
    /**
     * Método que obtiene todas las Salas.
     * @return List<SalaDetailDTO>, Lista que contiene todas las Salas.
     */
    @GET
    public List<SalaDetailDTO> get() {
        return listEntity2DTO(logic.get());
    }
    /**
     * Método que obtiene una Sala con un ID especificado.
     * @param id Long, ID de la Sala.
     * @return SalaDetailDTO, información de la Sala buscada.
     */
    @GET
    @Path("{id: \\d+}")
    public SalaDetailDTO get(@PathParam("id") Long id) {
         return new SalaDetailDTO(logic.get(id));
    }
    /**
     * Método que actualiza la información de una Sala con un ID especificado.
     * @param id Long, ID de la Sala a actualizar.
     * @param sala SalaDetailDTO, nueva información de la Sala.
     * @return SalaDetailDTO, Sala con la información actualizada.
     * @throws BusinessLogicException 
     */
    @PUT
    @Path("{id: \\d+}")
    public SalaDetailDTO update(@PathParam("id") Long id, SalaDetailDTO sala) throws BusinessLogicException {
        SalaEntity nueva = sala.toEntity();
        nueva.setId(id);
        logic.update(nueva);
        return new SalaDetailDTO(logic.get(id));
    }
    /**
     * Método que crea una nueva Sala.
     * @param nueva SalaDetailDTO, información de la Sala a crear.
     * @return SalaDetaiLDTO, Información de la Sala creada.
     * @throws BusinessLogicException 
     */
    @POST
    public SalaDetailDTO create(SalaDetailDTO nueva) throws BusinessLogicException {
        return new SalaDetailDTO(logic.create(nueva.toEntity()));
    }
    /**
     * Método que Borra una Sala con un ID dado.
     * @param id Long, ID de la Sala a Borrar.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void delete(@PathParam("id") Long id) {
        logic.remove(id);
    }
    /**
     * Método que transforma una Lista de Entidades de Sala a sus versiones DTO.
     * @param entities List<SalaEntity>
     * @return List<SalaDetailDTO>
     */
    private List<SalaDetailDTO> listEntity2DTO (List<SalaEntity> entities) {
        List<SalaDetailDTO> list = new ArrayList<>();
        for (SalaEntity entity : entities) {
            list.add(new SalaDetailDTO(entity));
        }
        return list;
    }
}
