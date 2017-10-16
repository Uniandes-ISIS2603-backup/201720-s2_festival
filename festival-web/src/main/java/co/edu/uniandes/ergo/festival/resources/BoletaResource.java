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
import co.edu.uniandes.ergo.festival.dtos.CalificacionDTO;
import co.edu.uniandes.ergo.festival.dtos.EspectadorDetailDTO;
import co.edu.uniandes.ergo.festival.dtos.FuncionDTO;
import co.edu.uniandes.ergo.festival.dtos.FuncionDetailDTO;
import co.edu.uniandes.ergo.festival.dtos.SillaDetailDTO;
import co.edu.uniandes.ergo.festival.entities.FestivalEntity;
import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.entities.AbonoEntity;
import co.edu.uniandes.ergo.festival.entities.CalificacionEntity;
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
        if(boleta.getSilla() == null)
        {
            boleta.setSilla(new SillaDetailDTO(entity.getSilla()));
        }
        if(boleta.getFuncion() == null)
        {
            boleta.setFuncion(new FuncionDTO(entity.getFuncion()));
        }
        if(boleta.getCodigoDeBarras() == null)
        {
            boleta.setCodigoDeBarras(entity.getCodigoBarras());
        }
        if(boleta.getEspectador() == null)
        {
            if(entity.getEspectador() != null)
            {
                boleta.setEspectador(new EspectadorDetailDTO(entity.getEspectador()));
            }
        }
        if(boleta.getEstado() == null)
        {
            if(entity.getEstado().equals(BoletaEntity.DISPONIBLE))
            {
                boleta.setEstado(BoletaDetailDTO.DISPONIBLE);
            }
            else if(entity.getEstado().equals(BoletaEntity.RESERVADA))
            {
                boleta.setEstado(BoletaDetailDTO.RESERVADA);
            }
            else if(entity.getEstado().equals(BoletaEntity.COMPRADA))
            {
                boleta.setEstado(BoletaDetailDTO.COMPRADA);
            }
        }
        if(entity.getCalificacion() != null)
        {
            boleta.setCalificacion(new CalificacionDTO(entity.getCalificacion()));
        }
        if(boleta.getPrecio() == null)
        {
            boleta.setPrecio(entity.getPrecio());
        }
        
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
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una boleta con id {0}", id);
        BoletaEntity entity = boletaLogic.getBoleta(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /boletas/" + id + " no existe.", 404);
        }
        boletaLogic.deleteBoleta(id);
    }
    /**
     * Método que obtiene la silla asociada a una boleta.
     * @param id Long, ID de la boleta.
     * @return SillaDetailDTO, silla asociada a la boleta dada por parámetro.
     * @throws BusinessLogicException 
     */
    @GET
    @Path("{id:\\d+}/sillas")
    public SillaDetailDTO getSillaFromBoleta(@PathParam("id")Long id) throws BusinessLogicException
    {
        BoletaEntity entity = boletaLogic.getBoleta(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /boletas/" + id + " no existe.", 404);
        }
        SillaDetailDTO respuesta = new SillaDetailDTO(boletaLogic.getSillaFromBoleta(id));
        if(respuesta == null)
        {
            throw new WebApplicationException("No hay una silla asociada a el recurso /boletas/"+ id ,404);
        }
        return respuesta;
    }
    /**
     * Métod que le asocia a boleta una silla, la silla debe existir en la base de datos.
     * @param boletaId Long, ID de la Boleta.
     * @param sillaId Long, ID de la silla a asociar.
     * @return SillaDetailDTO
     * @throws BusinessLogicException 
     */
    @POST
    @Path("{boletaid:\\d+}/sillas/{sillaid:\\d+}")
    public SillaDetailDTO addSillaFromBoleta(@PathParam("boletaid")Long boletaId, @PathParam("sillaid")Long sillaId ) throws BusinessLogicException
    {
        BoletaEntity entity = boletaLogic.getBoleta(boletaId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /boletas/" + boletaId + " no existe.", 404);
        }
        return new SillaDetailDTO(boletaLogic.addSillaFromBoleta(boletaId, sillaId));
    }
    
    /**
     * Método que actualiza una silla de una boleta con una silla existente.
     * @param boletaId Long, ID de la boleta.
     * @param sillaId Long, ID de la silla a asociar.
     * @return SillaDetailDTO, silla que acaba de ser asociada.
     * @throws BusinessLogicException 
     */
    @PUT
    @Path("{boletaid:\\d+}/sillas/{sillaid:\\d+}")
    public SillaDetailDTO updateSillaFromBoleta(@PathParam("boletaid")Long boletaId, @PathParam("sillaid")Long sillaId ) throws BusinessLogicException
    {
        BoletaEntity entity = boletaLogic.getBoleta(boletaId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /boletas/" + boletaId + " no existe.", 404);
        }
        return new SillaDetailDTO(boletaLogic.updateSillaFromBoleta(boletaId, sillaId));
    }
    /**
     * Método que obtiene la función asociada a una boleta.
     * @param id Long, ID de la boleta.
     * @return FuncionDTO, función asociada a la boleta dada por parámetro.
     * @throws BusinessLogicException 
     */
    @GET
    @Path("{id:\\d+}/funciones")
    public FuncionDTO getFuncionFromBoleta(@PathParam("id")Long id) throws BusinessLogicException
    {
        BoletaEntity entity = boletaLogic.getBoleta(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /boletas/" + id + " no existe.", 404);
        }
        FuncionDTO respuesta = new FuncionDTO(boletaLogic.getFuncionFromBoleta(id));
        if(respuesta == null)
        {
            throw new WebApplicationException("No hay una funcion asociada a el recurso /boletas/"+ id ,404);
        }
        return respuesta;   
    }
    /**
     * Método que asocia una función a una Boleta.
     * @param boletaId Long, ID de la boleta.
     * @param funcionId Long, ID de la función.
     * @return FunctionDTO, función que acaba de ser asociada.
     * @throws BusinessLogicException 
     */
    @POST
    @Path("{boletaid:\\d+}/funciones/{funcionid:\\d+}")
    public FuncionDTO addFuncionFromBoleta(@PathParam("boletaid")Long boletaId, @PathParam("funcionid")Long funcionId ) throws BusinessLogicException
    {
        BoletaEntity entity = boletaLogic.getBoleta(boletaId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /boletas/" + boletaId + " no existe.", 404);
        }
        return new FuncionDTO(boletaLogic.addFuncionFromBoleta(boletaId, funcionId));
    }
    /**
     * Método que actualiza la Función de una Boleta al reemplazarla con otra.
     * @param boletaId Long, ID de la Boleta.
     * @param funcionId Long, ID de la Función.
     * @return FunctionDetailDTO, nueva Función asociada a la Boleta.
     * @throws BusinessLogicException 
     */
    @PUT
    @Path("{boletaid:\\d+}/funciones/{funcionid:\\d+}")
    public FuncionDetailDTO updateFuncionFromBoleta(@PathParam("boletaid")Long boletaId, @PathParam("funcionid")Long funcionId ) throws BusinessLogicException
    {
        BoletaEntity entity = boletaLogic.getBoleta(boletaId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /boletas/" + boletaId + " no existe.", 404);
        }
        return new FuncionDetailDTO(boletaLogic.updateFuncionFromBoleta(boletaId, funcionId));
    }
    /**
     * Método que obtiene la calificación asociada a una boleta.
     * @param id Long, ID de la boleta.
     * @return CalificacionDTO, calificación asociada a la boleta dada por parámetro.
     * @throws BusinessLogicException 
     */
    @GET
    @Path("{id:\\d+}/calificaciones")
    public CalificacionDTO getCalificacionFromBoleta(@PathParam("id")Long id) throws BusinessLogicException
    {
        BoletaEntity entity = boletaLogic.getBoleta(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /boletas/" + id + " no existe.", 404);
        }
        CalificacionDTO respuesta = new CalificacionDTO(boletaLogic.getCalificacionFromBoleta(id));
        if(respuesta == null)
        {
            throw new WebApplicationException("No hay una calificacion asociada a el recurso /boletas/"+ id ,404);
        }
        return respuesta;
    }
    /**
     * Método que asocia una calificación previamente existente a una boleta, la calificación DEBE existir en la base de datos.
     * @param boletaId Long, ID de la boleta.
     * @param calificacionId Long, ID de la calificación a asociar.
     * @return CalificacionDTO, Calificación asociada.
     * @throws BusinessLogicException 
     */
//    @POST
//    @Path("{boletaid:\\d+}/calificaciones/{calificacionid:\\d+}")
//    public CalificacionDTO addCalificacionExistenteFromBoleta(@PathParam("boletaid")Long boletaId, @PathParam("calificacionid")Long calificacionId) throws BusinessLogicException
//    {
//        BoletaEntity entity = boletaLogic.getBoleta(boletaId);
//        if (entity == null) {
//            throw new WebApplicationException("El recurso /boletas/" + boletaId + " no existe.", 404);
//        }
//        return new CalificacionDTO(boletaLogic.addCalificacionYaExistenteFromBoleta(boletaId, calificacionId));
//    }
    /**
     * Método que crea una nueva calificacion y la asocia inmediatamente a la boleta designada por parámetro, se CREA una NUEVA calificación en la base de datos.
     * @param boletaId Long, ID de la boleta.
     * @param calificacion CalificacionDTO, calificacion nueva a crear y asociar.
     * @return CalificacionDTO, Calificacion que se acaba de crar.
     * @throws BusinessLogicException 
     */
    @POST
    @Path("{boletaid:\\d+}/calificaciones")
    public CalificacionDTO createCalificacionFromBoleta(@PathParam("boletaid")Long boletaId, CalificacionDTO calificacion) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        BoletaEntity entity = boletaLogic.getBoleta(boletaId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /boletas/" + boletaId + " no existe.", 404);
        }
        CalificacionEntity calificacionEntity = calificacion.toEntity();
        // Invoca la lógica para crear la editorial nueva
        CalificacionEntity nuevaCalificacion = boletaLogic.createCalificacionFromBoleta(boletaId, calificacionEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new CalificacionDTO(nuevaCalificacion);
    }
    /**
     * Método que actualiza la calificación de una boleta, al reemplazarla con otra, la calificacion original no es eliminada de la base de datos.
     * @param boletaId Long, ID de la boleta.
     * @param calificacionId Long, ID de la calificacion nueva a asociar.
     * @return CalificacionDTO, calificación nueva asociada a la boleta.
     * @throws BusinessLogicException 
     */
//    @PUT
//    @Path("{boletaid:\\d+}/calificaciones/{calificacionid:\\d+}")
//    public CalificacionDTO updateCalificacionExistenteFromBoleta(@PathParam("boletaid")Long boletaId, @PathParam("calificacionid")Long calificacionId) throws BusinessLogicException
//    {
//        BoletaEntity entity = boletaLogic.getBoleta(boletaId);
//        if (entity == null) {
//            throw new WebApplicationException("El recurso /boletas/" + boletaId + " no existe.", 404);
//        }
//        return new CalificacionDTO(boletaLogic.updateCalificacionYaExistenteFromBoleta(boletaId, calificacionId));
//    }
    /**
     * Metodo que actualizar una calificación con otra nueva, este método CREA una calificación nueva en la base de datos Y la calificación originao NO es eliminada de la base de datos.
     * @param boletaId Long, ID de la boleta.
     * @param calificacion CalificacionDTO, nueva calificación a crear y asociar.
     * @return CalificacionDTO, calificación que acab de ser creada y asociada.
     * @throws BusinessLogicException 
     */
    @PUT
    @Path("{boletaid:\\d+}/calificaciones")
    public CalificacionDTO createUpdateCalificacionFromBoleta(@PathParam("boletaid")Long boletaId, CalificacionDTO calificacion) throws BusinessLogicException {
        BoletaEntity entity = boletaLogic.getBoleta(boletaId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /boletas/" + boletaId + " no existe.", 404);
        }
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        CalificacionEntity calificacionEntity = calificacion.toEntity();
        // Invoca la lógica para crear la editorial nueva
        CalificacionEntity nuevaCalificacion = boletaLogic.updateCreateCalificacionFromBoleta(boletaId, calificacionEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new CalificacionDTO(nuevaCalificacion);
    }
    /**
     * Método que des asocia una calificacion de una boleta, NO elimina la boleta de la base ded atos.
     * @param id Long, ID de la boleta.
     * @throws BusinessLogicException 
     */
    @DELETE
    @Path("{boletaid:\\d+}/calificaciones")
    public void deleteCalificacionFromBoleta(@PathParam("boletaid") Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un espectador de una boleta con id {0}", id);
        BoletaEntity entity = boletaLogic.getBoleta(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /boletas/" + id + " no existe.", 404);
        }
        boletaLogic.deleteCalificacionFromBoleta(id);
    }
    /**
     * Método que obtiene el espectador asociada a una boleta.
     * @param id Long, ID de la boleta.
     * @return EspectadorDetailDTO, espectador asociado a la boleta dada por parámetro.
     * @throws BusinessLogicException 
     */
    @GET
    @Path("{id:\\d+}/espectadores")
    public EspectadorDetailDTO getEspectadorFromBoleta(@PathParam("id")Long id) throws BusinessLogicException
    {
        BoletaEntity entity = boletaLogic.getBoleta(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /boletas/" + id + " no existe.", 404);
        }
        EspectadorDetailDTO respuesta = new EspectadorDetailDTO(boletaLogic.getEspectadorFromBoleta(id));
        if(respuesta == null)
        {
            throw new WebApplicationException("No hay un espectador asociada a el recurso /boletas/"+ id ,404);
        }
        return respuesta;
    }
    /**
     * Método que asocia un espectador previamente existente con una Boleta.
     * @param boletaId Long, ID de la boleta.
     * @param espectadorId Long, ID del espectador a asociar.
     * @return EspectadorDetailDTO, espectador asociado.
     * @throws BusinessLogicException 
     */
    @POST
    @Path("{boletaid:\\d+}/escpectadores/{espectadorid:\\d+}")
    public EspectadorDetailDTO addEspectadorFromBoleta(@PathParam("boletaid")Long boletaId, @PathParam("espectadorid")Long espectadorId ) throws BusinessLogicException
    {
        BoletaEntity entity = boletaLogic.getBoleta(boletaId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /boletas/" + boletaId + " no existe.", 404);
        }
        return new EspectadorDetailDTO(boletaLogic.addEspectadorFromBoleta(boletaId, espectadorId));
    }
    /**
     * Método que actualiza un espectador asociado a una boleta.
     * @param boletaId Long, ID de la boleta.
     * @param espectadorId Long, ID del espectador.
     * @return EspectadorDetailDTO, espectador nuevo que acaba de ser asociado.
     * @throws BusinessLogicException 
     */
    @PUT
    @Path("{boletaid:\\d+}/espectadores/{espectadorid:\\d+}")
    public EspectadorDetailDTO updateEspectadorFromBoleta(@PathParam("boletaid")Long boletaId, @PathParam("spectadorid")Long espectadorId ) throws BusinessLogicException
    {
        BoletaEntity entity = boletaLogic.getBoleta(boletaId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /boletas/" + boletaId + " no existe.", 404);
        }
        return new EspectadorDetailDTO(boletaLogic.updateEspectadorFromBoleta(boletaId, espectadorId));
    }
    
    /**
     * Método que des asocia un espectador de una Boleta, NO borra el espectador de la base de datos.
     * @param id Long, ID de la boleta.
     * @throws BusinessLogicException 
     */
    @DELETE
    @Path("{id:\\d+}/espectadores")
    public void deleteEspectadorFromBoleta(@PathParam("id") Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un espectador de una boleta con id {0}", id);
        BoletaEntity entity = boletaLogic.getBoleta(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /boletas/" + id + " no existe.", 404);
        }
        boletaLogic.deleteEspectadorFromBoleta(id);
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