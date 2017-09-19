/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;


import co.edu.uniandes.ergo.festival.dtos.SalaDetailDTO;
import co.edu.uniandes.ergo.festival.dtos.SalaDTO;
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
    
    @GET
    public List<SalaDetailDTO> get() {
        List<SalaEntity> respuesta = logic.get();
        List<SalaDetailDTO> retorno = new ArrayList<>();
        for (SalaEntity sala : respuesta) {
            retorno.add(new SalaDetailDTO(sala));
        }
        return retorno;
    }
    
    @GET
    @Path("{id: \\d+}")
    public SalaDetailDTO get(@PathParam("id") Long id) {
         return new SalaDetailDTO(logic.get(id));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public SalaDetailDTO update(@PathParam("id") Long id, SalaDetailDTO sala) {
        SalaEntity nueva = sala.toEntity();
        nueva.setId(id);
        logic.update(nueva);
        return new SalaDetailDTO(logic.get(id));
    }
    
    @POST
    public SalaDetailDTO create(SalaDetailDTO nueva) {
        return new SalaDetailDTO(logic.create(nueva.toEntity()));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void remove(@PathParam("id") Long id) {
        logic.remove(id);
    }
}
