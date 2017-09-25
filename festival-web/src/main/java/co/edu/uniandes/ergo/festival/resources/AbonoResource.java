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

import co.edu.uniandes.ergo.festival.ejb.AbonoLogic;
import co.edu.uniandes.ergo.festival.dtos.AbonoDetailDTO;
import co.edu.uniandes.ergo.festival.entities.AbonoEntity;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import co.edu.uniandes.ergo.festival.persistence.AbonoPersistence;
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
 * Clase que implementa el recurso REST correspondiente a "abonos".
 *
 * Note que la aplicación (definida en RestConfig.java) define la ruta "/api" y
 * este recurso tiene la ruta "abono". Al ejecutar la aplicación, el recurso
 * será accesibe a través de la ruta "/api/abonos"
 * @author jc.corrales
 */
@Path("abonos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AbonoResource
{
    @Inject
    AbonoLogic abonoLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    
    private static final Logger LOGGER = Logger.getLogger(AbonoPersistence.class.getName());

     /**
     * POST http://localhost:8080/festival-web/api/abonos
     *
     * @param abono correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "AbonoDetailDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST
    public AbonoDetailDTO createAbono(AbonoDetailDTO abono) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        AbonoEntity abonoEntity = abono.toEntity();
        // Invoca la lógica para crear la editorial nueva
        AbonoEntity nuevoAbono = abonoLogic.createAbono(abonoEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new AbonoDetailDTO(nuevoAbono);
    }
    
    /**
     * GET para todas las abonos.
     * http://localhost:8080/festival-web/api/abonos
     *
     * @return la lista de todas las editoriales en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET
    public List<AbonoDetailDTO> getAbonos() throws BusinessLogicException {
        return listEntity2DetailDTO(abonoLogic.getAbonos());
    }
    
    /**
     * GET para una editorial
     * http://localhost:8080/festival-web/api/abonos/1
     *
     * @param id corresponde al id de la abono buscada.
     * @return La abono encontrada. Ejemplo: { "type": "editorialDetailDTO",
     * "id": 1, "name": "Norma" }
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la abono buscada se retorna un 404 con
     * el mensaje.
     */
    @GET
    @Path("{id: \\d+}")
    public AbonoDetailDTO getAbono(@PathParam("id") Long id) throws BusinessLogicException {
        AbonoEntity entity = abonoLogic.getAbono(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /abonos/" + id + " no existe.", 404);
        }
        return new AbonoDetailDTO(abonoLogic.getAbono(id));
    }
    
    /**
     * PUT http://localhost:8080/festival-web/api/abonos/1 Ejemplo
     *
     * @param id corresponde a la abono a actualizar.
     * @param abono corresponde a al objeto con los cambios que se van a
     * realizar.
     * @return La abono actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la editorial a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public AbonoDetailDTO updateEditorial(@PathParam("id") Long id, AbonoDetailDTO abono) throws BusinessLogicException {
        abono.setId(id);
        AbonoEntity entity = abonoLogic.getAbono(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /abonos/" + id + " no existe.", 404);
        }
        return new AbonoDetailDTO(abonoLogic.updateAbono(id, abono.toEntity()));
    }
    
     /**
     * DELETE http://localhost:8080/festival-web/api/abonos/1
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
    public void deleteAbono(@PathParam("id") Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una editorial con id {0}", id);
        AbonoEntity entity = abonoLogic.getAbono(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /abonos/" + id + " no existe.", 404);
        }
        abonoLogic.deleteAbono(id);

    }
     /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos AbonoEntity a una lista de
     * objetos AbonoDetailDTO (json)
     *
     * @param entityList corresponde a la lista de abonos de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de abonos en forma DTO (json)
     */
    private List<AbonoDetailDTO> listEntity2DetailDTO(List<AbonoEntity> entityList) {
        List<AbonoDetailDTO> list = new ArrayList<>();
        for (AbonoEntity entity : entityList) {
            list.add(new AbonoDetailDTO(entity));
        }
        return list;
    }
}
