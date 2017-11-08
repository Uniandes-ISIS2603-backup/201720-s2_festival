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
import co.edu.uniandes.ergo.festival.entities.FestivalEntity;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import co.edu.uniandes.ergo.festival.persistence.FestivalPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

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
 * Clase que implementa el recurso REST correspondiente a "festivales".
 *
 * Note que la aplicación (definida en RestConfig.java) define la ruta "/api" y
 * este recurso tiene la ruta "festivales". Al ejecutar la aplicación, el
 * recurso será accesibe a través de la ruta "/api/festivales"
 *
 * @author ISIS2603
 *
 */
@Path("festivales")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class FestivalResource {

    @Inject
    FestivalLogic festivalLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    private static final Logger LOGGER = Logger.getLogger(FestivalResource.class.getName());

    /**
     * POST http://localhost:8080/festival-web/api/festivales
     *
     * @param Festival correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "FestivalDetailDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST
    public FestivalDetailDTO createFestival(FestivalDetailDTO Festival) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        FestivalEntity FestivalEntity = Festival.toEntity();
        // Invoca la lógica para crear la festival nuevo
        FestivalEntity nuevoFestival = festivalLogic.createFestival(FestivalEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new FestivalDetailDTO(nuevoFestival);
    }

    /**
     * GET para todas losfestivales.
     * http://localhost:8080/festival-web/api/festivales
     *
     * @return la lista de todas losfestivales en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET
    public List<FestivalDetailDTO> getfestivales() throws BusinessLogicException {
        return listEntity2DetailDTO(festivalLogic.getfestivales());
    }

    /**
     * 
     */
    @GET
    @Path("{id: \\d+}") 
    public FestivalDetailDTO getFestival(@PathParam ("id") Long id)
    {
        FestivalEntity entity = festivalLogic.getFestival(id);
        if(entity == null)
        {
            throw new WebApplicationException("El festival con id: " + id + " no existe.", 404);
        }
        return new FestivalDetailDTO(festivalLogic.getFestival(id));
    }
   
    /**
     * PUT http://localhost:8080/festival-web/api/festivales/1 Ejemplo
     * json { "id": 1, "atirbuto1": "Valor nuevo" }
     *
     * @param id corresponde al Festival a actualizar.
     * @param festival corresponde  al objeto con los cambios que se van a
     * realizar.
     * @return La Festival actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Festival a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public FestivalDetailDTO updateFestival(@PathParam("id") Long id, FestivalDetailDTO festival) 
    {
        FestivalEntity entity = festivalLogic.getFestival(id);
        if(entity == null)
        {
            throw new WebApplicationException("El festival con id: " + id + " no existe.", 404);
        }
        festival.setId(id);
        return new FestivalDetailDTO(festivalLogic.updateFestival(id, festival.toEntity()));
    }

    /**
     * DELETE http://localhost:8080/festival-web/api/festivales/{id}
     *
     * @param id corresponde al Festival a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Festival a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteFestival(@PathParam("id") Long id) throws BusinessLogicException {
        FestivalEntity entity = festivalLogic.getFestival(id);
        if(entity == null)
        {
            throw new WebApplicationException("El festival con id: " + id + " no existe.", 404);
        }
        festivalLogic.deleteFestival(id);
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos FestivalEntity a una lista de
     * objetos FestivalDetailDTO (json)
     *
     * @param entityList corresponde a la lista de Festivales de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de Festivales en forma DTO (json)
     */
    private List<FestivalDetailDTO> listEntity2DetailDTO(List<FestivalEntity> entityList) {
        List<FestivalDetailDTO> list = new ArrayList<>();
        for (FestivalEntity entity : entityList) {
            list.add(new FestivalDetailDTO(entity));
        }
        return list;
    }

}
