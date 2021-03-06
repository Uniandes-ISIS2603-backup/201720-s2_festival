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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
/**
 * Clase que administra los Recursos de un Patrocinador.
 */
@Path("/patrocinadores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PatrocinadorResource {
    /**
     * Atributo que contiene la Lógica de este Recurso.
     */
    @Inject
    private PatrocinadorLogic logic;
    /**
     * Método que obtiene una Lisa con todos los Patrocinadores.
     * @return List<PatrocinadorDetailDTO>, Lista con todos los Patrocinadores.
     */
    @GET
    public List<PatrocinadorDetailDTO> get() {
        List<PatrocinadorEntity> respuesta = logic.get();
        List<PatrocinadorDetailDTO> retorno = new ArrayList<>();
        for (PatrocinadorEntity patrocinador : respuesta) {
            retorno.add(new PatrocinadorDetailDTO(patrocinador));
        }
        return retorno;
    }
    /**
     * Método que obtiene un Patrocinador según su ID.
     * @param id Long, ID del Patrocinador a consultar.
     * @return PatrocinadorDetailDTO, Información del Patrocinador consultado.
     */
    @GET
    @Path("{id: \\d+}")
    public PatrocinadorDetailDTO get(@PathParam("id") Long id) {
        PatrocinadorEntity patrocinador = logic.get(id);
        if(patrocinador == null)
        {
            throw new WebApplicationException("El recurso /patrocinadores/" + id + " no existe.", 404);
        }
        return new PatrocinadorDetailDTO();
    }
    /**
     * Método que actualiza un Patrocinador.
     * @param id Long, ID del Patrocinador a actualizar.
     * @param patrocinador PatrocinadorDetailDTO, nueva información del Patrocinador.
     * @return PatrocinadorDetaiLDTO, información actualiada del Patrocinador.
     */
    @PUT
    @Path("{id: \\d+}")
    public PatrocinadorDetailDTO update(@PathParam("id") Long id, PatrocinadorDetailDTO patrocinador) {
        patrocinador.setId(id);
        PatrocinadorEntity entidad = logic.get(id);
        if(entidad == null)
        {
            throw new WebApplicationException("El recurso /patrocinadores/" + id + " no existe.", 404);
        }
        PatrocinadorEntity nuevo = patrocinador.toEntity();
        nuevo.setId(id);
        logic.update(nuevo);
        return new PatrocinadorDetailDTO(logic.get(id));
    }
    /**
     * Método que crea un Patrocinador nuevo.
     * @param nuevo PatrocinadorDetailDTO, información del Patrocinador creado.
     * @return PatrocinadorDetailDTO, Información del Patrocinador creado.
     */
    @POST
    public PatrocinadorDetailDTO create(PatrocinadorDetailDTO nuevo) {
        return new PatrocinadorDetailDTO(logic.create(nuevo.toEntity()));
    }
    /**
     * Método que borra un Patrocinador según su ID.
     * @param id Long, ID del Patrocinador a Borrar.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void remove(@PathParam("id") Long id) {
        get(id);
        logic.remove(id);
    }
}
