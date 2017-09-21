/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;

import co.edu.uniandes.ergo.festival.dtos.PatrocinadorDetailDTO;
import co.edu.uniandes.ergo.festival.ejb.PatrocinadorLogic;
import co.edu.uniandes.ergo.festival.entities.PatrocinadorEntity;
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
import javax.ws.rs.core.MediaType;

@Path("/patrocinadores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class PatrocinadorResource {
    
    @Inject
    private PatrocinadorLogic logic;
    
    @GET
    public List<PatrocinadorDetailDTO> get() {
        List<PatrocinadorEntity> respuesta = logic.get();
        List<PatrocinadorDetailDTO> retorno = new ArrayList<>();
        for (PatrocinadorEntity patrocinador : respuesta) {
            retorno.add(new PatrocinadorDetailDTO(patrocinador));
        }
        return retorno;
    }
    
    @GET
    @Path("{id: \\d+}")
    public PatrocinadorDetailDTO get(@PathParam("id") Long id) {
         return new PatrocinadorDetailDTO(logic.get(id));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public PatrocinadorDetailDTO update(@PathParam("id") Long id, PatrocinadorDetailDTO patrocinador) {
        PatrocinadorEntity nuevo = patrocinador.toEntity();
        nuevo.setId(id);
        logic.update(nuevo);
        return new PatrocinadorDetailDTO(logic.get(id));
    }
    
    @POST
    public PatrocinadorDetailDTO create(PatrocinadorDetailDTO nuevo) {
        return new PatrocinadorDetailDTO(logic.create(nuevo.toEntity()));
    }
    @DELETE
    @Path("{id: \\d+}")
    public void remove(@PathParam("id") Long id) {
        logic.remove(id);
    }
}
