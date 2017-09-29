/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;


import co.edu.uniandes.ergo.festival.dtos.BoletaDTO;
import co.edu.uniandes.ergo.festival.dtos.CriticaDTO;
import co.edu.uniandes.ergo.festival.dtos.FuncionDetailDTO;
import co.edu.uniandes.ergo.festival.ejb.CriticaLogic;
import co.edu.uniandes.ergo.festival.ejb.FuncionLogic;
import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.entities.CriticaEntity;
import co.edu.uniandes.ergo.festival.entities.FuncionEntity;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
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
import org.hibernate.validator.HibernateValidator;

/**
 *
 * @author m.neira10
 */
@Path("/funciones")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class FuncionResource {
     @Inject
    private FuncionLogic funcionLogic;
     
     /**
  * Crea una nueva FuncionEntity.
  * @param dto información de la FuncionEntity.
  * @return Un FuncionDetailDTO con la información de la nueva entidad.
  */
 @POST
 public FuncionDetailDTO createFuncion(FuncionDetailDTO dto){
     if(dto.getSala()==null){
         throw new WebApplicationException("La Funcion no tiene una sala como parametro.", 404);
     }
     if(dto.getFestival()==null){
         throw new WebApplicationException("La Funcion no tiene un festival como parametro.", 404);
     }
     if(dto.getPelicula()==null){
         throw new WebApplicationException("La Funcion no tiene una pelicula como parametro.", 404);
     }
     return new FuncionDetailDTO(funcionLogic.createFuncion(dto.toEntity()));
 }
 
 /**
  * Retorna la información de la FuncionEntity con el id dado.
  * @param id de la FuncionEntity.
  * @return Un FuncionDetailDTO con la informaición de la FuncionEntity.
  */
 @GET
 @Path("{id: \\d+}")
 public FuncionDetailDTO getFuncion(@PathParam("id") Long id){
     FuncionEntity entity = funcionLogic.getFuncion(id);
     if (entity == null){
         throw new WebApplicationException("La Funcion con id: " + id + " no existe.", 404);
     }
     return new FuncionDetailDTO(funcionLogic.getFuncion(id));
 }
 
 /**
  * Retorna todas las FuncionEntity.
  * @return Una lista con las FuncionEntity.
  */
 @GET
 public List<FuncionDetailDTO> getFuncions(){
     return listEntity2DTO(funcionLogic.getFunciones());
 }
 
 /**
  * Actualiza la informaición de la FuncionEntity con el id especificado.
  * @param id de la FuncionEntity a actualizar.
  * @param dto nueva información de la FuncionEntity.
  * @return Un FuncionDetailDTO con la nueva información del FuncionEntity.
  */
 @PUT
 @Path("{id: \\d+}")
 public FuncionDetailDTO updateFuncion(@PathParam("id") Long id, FuncionDetailDTO dto){
     FuncionEntity oldEntity = funcionLogic.getFuncion(id);
     if (oldEntity == null){
         throw new WebApplicationException("La Funcion con id: " + id + " no existe.", 404);
     }
     if(dto.getSala()==null){
         throw new WebApplicationException("La Funcion no tiene una sala como parametro.", 404);
     }
     if(dto.getFestival()==null){
         throw new WebApplicationException("La Funcion no tiene un festival como parametro.", 404);
     }
     if(dto.getPelicula()==null){
         throw new WebApplicationException("La Funcion no tiene una pelicula como parametro.", 404);
     }
     FuncionEntity entity = dto.toEntity();
     entity.setId(id);
     return new FuncionDetailDTO(funcionLogic.updateFuncion(entity));
 }
 
 /**
  * Elimina la FuncionEntity con el id especificado.
  * @param id de la FuncionEntity a eliminar.
  */
 @DELETE
 @Path("{id: \\d+}")
 public void deleteFuncion(@PathParam("id") Long id){
     FuncionEntity entity = funcionLogic.getFuncion(id);
     if (entity == null){
         throw new WebApplicationException("La Funcion con id: " + id + " no existe.", 404);
     }
     funcionLogic.deleteFuncion(id);
 }
         
 /**
  * Convierte una lista de FuncionEntity a una lista de FuncionDetailDTO.     *
  * @param entityList Lista de AuthorEntity a convertir.
  * @return Lista de AuthorDetailDTO convertida.     * 
  */
 private List<FuncionDetailDTO> listEntity2DTO(List<FuncionEntity> entityList) {
     List<FuncionDetailDTO> list = new ArrayList<>();
     for (FuncionEntity entity : entityList) {
         list.add(new FuncionDetailDTO(entity));
     }
     return list;
 }
 
    @GET
    @Path("{id:\\d+}/criticas")
    public List<CriticaDTO> getCriticasFromFuncion(@PathParam("id")Long id) throws BusinessLogicException
    {
        FuncionEntity entity = funcionLogic.getFuncion(id);
        if (entity == null) {
            throw new WebApplicationException("La funcion con el id:" + id + " no existe.", 404);
        }
        List<CriticaEntity> preAns =  funcionLogic.getCriticas(id);
        ArrayList<CriticaDTO> ans = new ArrayList<>();
        for(CriticaEntity ent : preAns){
            ans.add(new CriticaDTO(ent));
        }
        return ans;
    }
    
    @GET
    @Path("{funcionid:\\d+}/criticas/{criticaid:\\d+}")
    public CriticaDTO getCriticaFromFuncion(@PathParam("funcionid")Long idFuncion,@PathParam("criticaid")Long idCritica) throws BusinessLogicException
    {
        FuncionEntity entity = funcionLogic.getFuncion(idFuncion);
        if (entity == null) {
            throw new WebApplicationException("La funcion con el id:" + idFuncion + " no existe.", 404);
        }       
        CriticaEntity preAns = funcionLogic.getCritica(idFuncion,idCritica);
        if(preAns==null){
            throw new WebApplicationException("La critica con el id:" + idCritica + " no existe en la funcion.", 404);
        }
        return new CriticaDTO(preAns);
    }
    
    @GET
    @Path("{id:\\d+}/boletas")
    public List<BoletaDTO> getBoletasFromFuncion(@PathParam("id")Long id) throws BusinessLogicException
    {
        FuncionEntity entity = funcionLogic.getFuncion(id);
        if (entity == null) {
            throw new WebApplicationException("La funcion con el id:" + id + " no existe.", 404);
        }
        List<BoletaEntity> preAns =  funcionLogic.getBoletas(id);
        ArrayList<BoletaDTO> ans = new ArrayList<>();
        for(BoletaEntity bol : preAns){
            ans.add(new BoletaDTO(bol));
        }
        return ans;
    }
    @GET
    @Path("{funcionid:\\d+}/boletas/{boletaid:\\d+}")
    public BoletaDTO getBoletaFromFuncion(@PathParam("funcionid")Long idFuncion,@PathParam("boletaid")Long idBoleta) throws BusinessLogicException
    {
        FuncionEntity entity = funcionLogic.getFuncion(idFuncion);
        if (entity == null) {
            throw new WebApplicationException("La funcion con el id:" + idFuncion + " no existe.", 404);
        }       
        BoletaEntity preAns = funcionLogic.getBoleta(idFuncion,idBoleta);
        if(preAns==null){
            throw new WebApplicationException("La boleta con el id:" + idBoleta + " no existe en la funcion.", 404);
        }
        return new BoletaDTO(preAns);
    }
    
}
