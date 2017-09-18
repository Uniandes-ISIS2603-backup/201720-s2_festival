/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.ergo.festival.resources;

import co.edu.uniandes.ergo.festival.ejb.FestivalLogic;
import co.edu.uniandes.ergo.festival.dtos.FestivalDetailDTO;
import co.edu.uniandes.ergo.festival.ejb.BoletaLogic;
import co.edu.uniandes.ergo.festival.dtos.BoletaDetailDTO;
import co.edu.uniandes.ergo.festival.entities.FestivalEntity;
import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.entities.AbonoEntity;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import co.edu.uniandes.ergo.festival.persistence.BoletaPersistence;
import co.edu.uniandes.ergo.festival.persistence.FestivalPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
/**
 * Clase que implementa el recurso REST correspondiente a "boletas".
 *
 * Note que la aplicación (definida en RestConfig.java) define la ruta "/api" y
 * este recurso tiene la ruta "boleta". Al ejecutar la aplicación, el recurso
 * será accesibe a través de la ruta "/api/boletas"
 * @author jc.corrales
 */
@Path("boletas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class BoletaResource
{
    @Inject
    BoletaLogic boletaLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    
    private static final Logger LOGGER = Logger.getLogger(BoletaPersistence.class.getName());

     /**
     * POST http://localhost:8080/festival-web/api/boletas
     *
     * @param boleta correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "BoletaDetailDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST
    public BoletaDetailDTO createBoleta(BoletaDetailDTO boleta) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        BoletaEntity boletaEntity = boleta.toEntity();
        // Invoca la lógica para crear la editorial nueva
        BoletaEntity nuevoBoleta = boletaLogic.createBoleta(boletaEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new BoletaDetailDTO(nuevoBoleta);
    }
    
    /**
     * GET para todas las boletas.
     * http://localhost:8080/festival-web/api/boletas
     *
     * @return la lista de todas las editoriales en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET
    public List<BoletaDetailDTO> getBoletas() throws BusinessLogicException {
        return listEntity2DetailDTO(boletaLogic.getBoletas());
    }
    
    /**
     * GET para una editorial
     * http://localhost:8080/festival-web/api/boletas/1
     *
     * @param id corresponde al id de la boleta buscada.
     * @return La boleta encontrada. Ejemplo: { "type": "editorialDetailDTO",
     * "id": 1, "name": "Norma" }
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de laboleta buscada se retorna un 404 con
     * el mensaje.
     */
    @GET
    @Path("{id: \\d+}")
    public BoletaDetailDTO getBoleta(@PathParam("id") Long id) throws BusinessLogicException {
        BoletaEntity entity = boletaLogic.getBoleta(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /boletas/" + id + " no existe.", 404);
        }
        return new BoletaDetailDTO(boletaLogic.getBoleta(id));
    }
    
    /**
     * PUT http://localhost:8080/festival-web/api/boletas/1 Ejemplo
     * json { "id": 1, "name": "cambio de nombre" }
     *
     * @param id corresponde a la boleta a actualizar.
     * @param boleta corresponde a al objeto con los cambios que se van a
     * realizar.
     * @return La boleta actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la editorial a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public BoletaDetailDTO updateBoleta(@PathParam("id") Long id, BoletaDetailDTO boleta) throws BusinessLogicException {
        boleta.setId(id);
        BoletaEntity entity = boletaLogic.getBoleta(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /boletas/" + id + " no existe.", 404);
        }
        return new BoletaDetailDTO(boletaLogic.updateBoleta(id, boleta.toEntity()));
    }
    
     /**
     * DELETE http://localhost:8080/festival-web/api/boletas/1
     *
     * @param id corresponde a la editorial a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la editorial a actualizar se retorna un
     * 404 con el mensaje.
     * @throws java.sql.SQLException
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteBoleta(@PathParam("id") Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una editorial con id {0}", id);
        BoletaEntity entity = boletaLogic.getBoleta(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /boletas/" + id + " no existe.", 404);
        }
        boletaLogic.deleteBoleta(id);

    }
     /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos BoletaEntity a una lista de
     * objetos BoletaDetailDTO (json)
     *
     * @param entityList corresponde a la lista de boletas de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de boletas en forma DTO (json)
     */
    private List<BoletaDetailDTO> listEntity2DetailDTO(List<BoletaEntity> entityList) {
        List<BoletaDetailDTO> list = new ArrayList<>();
        for (BoletaEntity entity : entityList) {
            list.add(new BoletaDetailDTO(entity));
        }
        return list;
    }
}