/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.resources;

import co.edu.uniandes.ergo.festival.dtos.AbonoDTO;
import co.edu.uniandes.ergo.festival.dtos.AbonoDetailDTO;
import co.edu.uniandes.ergo.festival.dtos.BoletaDTO;
import co.edu.uniandes.ergo.festival.dtos.BoletaDetailDTO;
import co.edu.uniandes.ergo.festival.dtos.EspectadorDTO;
import co.edu.uniandes.ergo.festival.dtos.EspectadorDetailDTO;
import co.edu.uniandes.ergo.festival.ejb.BoletaLogic;
import co.edu.uniandes.ergo.festival.ejb.EspectadorLogic;
import co.edu.uniandes.ergo.festival.entities.AbonoEntity;
import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
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
import javax.ws.rs.QueryParam;
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
    @Inject BoletaLogic bLogic;

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
        System.out.println("-------------------------------------------------------> " + cri.getName());
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

    //ABONOS DE ESPECTADOR 
    @GET
    @Path("{id: \\d+}/abonos")
    public List<AbonoDTO> darAbonos(@PathParam("id") Long id) {
        return listAbonoEntity2DTO(logic.darMisAbonos(id));
    }

    @POST
    @Path("{id: \\d+}/abonos")
    public EspectadorDetailDTO crearAbono(@PathParam("id") Long id, AbonoEntity abono) throws BusinessLogicException {
        EspectadorEntity espectador = logic.getEspectador(id);
        if (espectador == null) {
            throw new WebApplicationException("El espectador con id: " + id + " no existe.", 404);
        }
        return new EspectadorDetailDTO(logic.addAbono(id, abono));
    }

    /*
    @PUT
    @Path("{id: \\d+}/abonos/{idA: \\d+}")
    public EspectadorDetailDTO actualizarAbono(@PathParam("id") Long id, @PathParam("idA") Long idAbono, AbonoEntity abono) throws BusinessLogicException {
        EspectadorEntity espectador = logic.getEspectador(id);
        if (espectador == null) {
            throw new WebApplicationException("El espectador con id: " + id + " no existe.", 404);
        }
        abono.setId(idAbono);
        return new EspectadorDetailDTO(logic.updateAbono(id, abono));
    }
     */
    //FIN ABONOS
    //BOLETAS DE ESPECTADOR
    @GET
    @Path("{especId: \\d+}/boletas")
    public List<BoletaDTO> darBoletasDeEspectador(@PathParam("especId") Long id) {
        EspectadorEntity espectador = logic.getEspectador(id);
        if (espectador == null) {
            throw new WebApplicationException("El espectador con id: " + id + " no existe.", 404);
        }
        return listBoletaEntity2DTO(logic.darBoletasEspec(id));
    }
    /*
      @POST
    public EspectadorDetailDTO agregarBoleta(@PathParam("espectadorId") Long id, @QueryParam("idBoleta") Long idBoleta) throws BusinessLogicException {
        EspectadorEntity espectador = logic.getEspectador(id);
        if (espectador == null) {
            throw new WebApplicationException("El espectador con id: " + id + " no existe.", 404);
        }
        BoletaEntity boleta = bLogic.getBoleta(idBoleta);
        if (boleta == null) {
            throw new WebApplicationException("La boleta con id: " + idBoleta + " no existe.", 404);
        }

        espectador.addBoleta(boleta);
        bLogic.addEspectadorFromBoleta(idBoleta, espectador.getId());

        return new EspectadorDetailDTO(logic.asociarBoleta(id, bLogic.getBoleta(idBoleta)));
    }
*/
    //FIN DE BOLETAS
    
    
    
    
    private List<EspectadorDetailDTO> listEntity2DTO(List<EspectadorEntity> entityList) {
        List<EspectadorDetailDTO> list = new ArrayList<>();
        for (EspectadorEntity entity : entityList) {
            list.add(new EspectadorDetailDTO(entity));
        }
        return list;
    }

    private List<AbonoDTO> listAbonoEntity2DTO(List<AbonoEntity> entityList) {
        List<AbonoDTO> list = new ArrayList<>();
        for (AbonoEntity entity : entityList) {
            list.add(new AbonoDTO(entity));
        }
        return list;
    }

    private List<BoletaDTO> listBoletaEntity2DTO(List<BoletaEntity> entityList) {
        List<BoletaDTO> list = new ArrayList<>();
        for (BoletaEntity entity : entityList) {
            list.add(new BoletaDTO(entity));
        }
        return list;
    }

}
