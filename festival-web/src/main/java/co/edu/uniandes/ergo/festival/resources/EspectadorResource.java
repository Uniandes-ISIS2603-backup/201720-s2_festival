/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;

import co.edu.uniandes.ergo.festival.dtos.AbonoDetailDTO;
import co.edu.uniandes.ergo.festival.dtos.EspectadorDTO;
import co.edu.uniandes.ergo.festival.dtos.EspectadorDetailDTO;
import co.edu.uniandes.ergo.festival.ejb.EspectadorLogic;
import co.edu.uniandes.ergo.festival.entities.EspectadorEntity;
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
@Path("/espectadores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class EspectadorResource {

    @Inject
    private EspectadorLogic logic;

    @GET
    public List<EspectadorDetailDTO> getEspectadores() {
        return listEntity2DTO(logic.getEspectadores());
    }

    @GET
    @Path("{id: \\d+}")
    public EspectadorDetailDTO getEspectadorById(@PathParam("id") Long id) {
        EspectadorEntity cri = logic.getEspectador(id);
        if (cri == null) {
            throw new WebApplicationException("El espectador con id: " + id + " no existe.", 404);
        }
        return new EspectadorDetailDTO(cri);

    }

    @POST
    public EspectadorDetailDTO createEspectador(EspectadorDetailDTO cri) throws BusinessLogicException {
        return new EspectadorDetailDTO(logic.createEspectador(cri.toEntity()));
    }

    @PUT
    @Path("{id: \\d+}")
    public EspectadorDetailDTO updateEspectador(@PathParam("id") Long id, EspectadorDetailDTO cri) throws BusinessLogicException {
        EspectadorEntity entity = cri.toEntity();
        entity.setId(id);
        return new EspectadorDetailDTO(logic.updateEspectador(id, entity));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteEspectador(@PathParam("id") Long id) {
        EspectadorEntity entity = logic.getEspectador(id);
        if (entity == null) {
            throw new WebApplicationException("El crítico con id: " + id + " no existe.", 404);
        }
        logic.deleteEspectador(id);
    }

    private List<EspectadorDetailDTO> listEntity2DTO(List<EspectadorEntity> entityList) {
        List<EspectadorDetailDTO> list = new ArrayList<>();
        for (EspectadorEntity entity : entityList) {
            list.add(new EspectadorDetailDTO(entity));
        }
        return list;
    }

    @POST
    @Path("{id: \\d+}/abonos/{aId: \\d+}")
    public EspectadorDetailDTO relAbono(@PathParam("id") Long id, @PathParam("aId") Long aId) throws BusinessLogicException {
        EspectadorEntity espectador = logic.getEspectador(id);
        if (espectador == null) {
            throw new WebApplicationException("El espectador con id: " + id + " no existe.", 404);
        }
        return new EspectadorDetailDTO(logic.addAbono(id, aId));
    }
}
