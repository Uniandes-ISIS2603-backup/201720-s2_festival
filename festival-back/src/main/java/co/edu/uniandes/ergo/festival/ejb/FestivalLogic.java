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
package co.edu.uniandes.ergo.festival.ejb;

import co.edu.uniandes.ergo.festival.entities.FestivalEntity;
import co.edu.uniandes.ergo.festival.entities.*;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import co.edu.uniandes.ergo.festival.persistence.FestivalPersistence;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ISIS2603
 */
@Stateless
public class FestivalLogic {


    private static final Logger LOGGER = Logger.getLogger(FestivalLogic.class.getName());

    @Inject
    private FestivalPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    @Inject
    private TeatroLogic teatroLogic;
    @Inject
    private  FuncionLogic  funcionLogic;
    @Inject
    private EspectadorLogic espectadorLogic;
    @Inject
    private PeliculaLogic peliculaLogic;
    @Inject 
    private CriticoLogic criticoLogic;   
    @Inject
    private PatrocinadorLogic patrocinadorLogic;
    
    /**
     *Creacion de un nuevo festival
     * @param entity Entidad correspondiente al festival
     * @return El festival creado. 
     * @throws BusinessLogicException
     */
    public FestivalEntity createFestival(FestivalEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Festival");
        // Invoca la persistencia para creare el Festival
        FestivalEntity festival = persistence.find(entity.getId());
        if(festival != null)
        {
            throw new BusinessLogicException("Ya existe un festival con ese nombre");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Festival");
        return entity;
    }

    /**
     * 
     * Obtener todas los festivales existentes en la base de datos.
     *
     * @return una lista de Festivales.
     */
    public List<FestivalEntity> getfestivales() {
        LOGGER.info("Inicia proceso de consultar todas los festivales");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
       
        LOGGER.info("Termina proceso de consultar todas losfestivales");
        return  persistence.findAll();
    }

    /**
     * Obtener un festival a partir de un identificador
     * @param id Identificar del festival a consultar
     * @return Festival consultado.
     */
    public FestivalEntity getFestival(Long id)
    {
        LOGGER.log(Level.INFO,"Inicia el proceso de buscar un festival con el id dado", id);
        return persistence.find(id);
    }
    
    /**
     * Actualiza un festival con el id dado por parametro.
     * @param idFestival Identificador del festival a actualizar.
     * @param entity Nuevos datos que va adquirir el festival. 
     * @return Festival actualizado.
     */
    public FestivalEntity updateFestival (Long idFestival, FestivalEntity entity)
    {
        if(getFestival(idFestival)==null)
        {
            LOGGER.log(Level.SEVERE,"No existe un festival con ese id para actualizarlo", idFestival);
        }
        FestivalEntity nuevo = persistence.update(entity);
        return nuevo;          
    }
    
    /**
     * @param idFestival
     */
    public void deleteFestival(Long idFestival)
    {
         LOGGER.log(Level.INFO, "Inicia el proceso de eliminar un festival");
        persistence.delete(idFestival);
    }
    
      /////Operaciones sobre los teatros/////////
     
    /**
     * Asocia un teatro a un determinado festival. 
     * @param idFestival
     * @param idTeatro
     * @return 
     */
    public TeatroEntity addTeatro (Long idFestival, Long idTeatro)
    {
        FestivalEntity festival = getFestival(idFestival);
        TeatroEntity teatro = teatroLogic.getTeatro(idTeatro);
        teatro.setFestival(festival);
        return teatro;
    }
    /**
     * 
     * @param idFestival
     * @return 
     */
    public List<TeatroEntity> getTeatros(Long idFestival)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de buscar los teatros asociadosa al festival con id = {0}", idFestival);
        if(getFestival(idFestival)==null)
        {
            LOGGER.log(Level.SEVERE,"No se ha encontrado un festival con el id",idFestival);
        }
        return getFestival(idFestival).getTeatros();
    }
    
    /**
     * 
     * @param idFestival
     * @param idTeatro
     * @return 
     */
    public TeatroEntity getTeatro(Long idFestival, Long idTeatro)
    {
        LOGGER.log(Level.INFO, "Inicia el proceso de buscar un teatro en festival con el id", idFestival);
        List<TeatroEntity> listTeatros = getFestival(idFestival).getTeatros();
        TeatroEntity teatro = new TeatroEntity();
        teatro.setId(idTeatro);
        int index = listTeatros.indexOf(teatro);
        if(index >= 0)
        {
            return listTeatros.get(index);
        }
        return null;
    }
   
    /**
     * Método que reemplaza una Lista de Teatros con otra.
     * @param idFestival Long, ID del Festival.
     * @param listaTeatros List<TeatroEntity>, nueva Lista de Teatros.
     * @return List<TeatroEntity>, nueva Lista de Teatros del Festival.
     */
    public List<TeatroEntity> replaceTeatros(Long idFestival, List<TeatroEntity> listaTeatros)
    {
        FestivalEntity festival = getFestival(idFestival);
        List<TeatroEntity> teatros = teatroLogic.getTeatros();
        for(TeatroEntity entity : teatros)
        {
            if(listaTeatros.contains(entity))
            {
                entity.setFestival(festival);
            }
            else if(entity.getFestival() != null && entity.getFestival().equals(festival))
            {
                entity.setFestival(null);
            }
        }
        return listaTeatros;
    }

    /**
     * Método que remueve un Teatro de un Festival.
     * @param idFestival Long, ID del Festival.
     * @param idTeatro Long, ID del Teatro a remover.
     */
    public void removeTeatro(Long idFestival, Long idTeatro)
    {
        FestivalEntity festival = getFestival(idFestival);
        TeatroEntity teatro = teatroLogic.getTeatro(idTeatro);
        teatro.setFestival(null);
        festival.getTeatros().remove(teatro);
    }
    
    ///////////OPERACIONES SOBRE FUNCION///////////////////
    /**
     * Método que agrega una Función a un Festival.
     * @param idFestival Long, ID del Festival.
     * @param idFuncion Long, ID de la Función a asociar.
     * @return FuncionEntity, Función agregada.
     */
    public FuncionEntity addFuncion (Long idFestival, Long idFuncion)
    {
        FestivalEntity festival = getFestival(idFestival);
        FuncionEntity funcion = funcionLogic.getFuncion(idFuncion);
        funcion.setFestival(festival);
        return funcion;
    }
    /**
     * Método que obtiene la Lista de Funciones de un Festival.
     * @param idFestival Long, ID del Festival.
     * @return List<FuncionEntity>, Lista de Funciones del Festival.
     */
    public List<FuncionEntity> getFunciones(Long idFestival)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de buscar los teatros asociadosa al festival con id = {0}", idFestival);
        if(getFestival(idFestival)==null)
        {
            LOGGER.log(Level.SEVERE,"No se ha encontrado un festival con el id",idFestival);
        }
        return getFestival(idFestival).getFunciones();
    }
    /**
     * Método que obtiene una Función específica de un Festival.
     * @param idFestival Long, ID del Festival.
     * @param idFuncion Long, ID de la Funcion.
     * @return FuncionEntity, Función buscada.
     */
    public FuncionEntity getFuncion(Long idFestival, Long idFuncion)
    {
        LOGGER.log(Level.INFO, "Inicia el proceso de buscar un teatro en festival con el id", idFestival);
        List<FuncionEntity> listFunciones = getFestival(idFestival).getFunciones();
        FuncionEntity teatro = new FuncionEntity();
        teatro.setId(idFuncion);
        int index = listFunciones.indexOf(teatro);
        if(index >= 0)
        {
            return listFunciones.get(index);
        }
        return null;
    }
    /**
     * Método que reemplaza la Lista de Funciones de un Festival.
     * @param idFestival Long, ID del Festival.
     * @param listaFunciones List<FuncionEntity>, nueva Lista de Funciones del Festival.
     * @return List<FuncionEntity>, Lista de Funciones actualizada.
     */
    public List<FuncionEntity> replaceFunciones(Long idFestival, List<FuncionEntity> listaFunciones)
    {
        FestivalEntity festival = getFestival(idFestival);
        List<FuncionEntity> funciones = funcionLogic.getFunciones();
        for(FuncionEntity entity : funciones)
        {
            if(listaFunciones.contains(entity))
            {
                entity.setFestival(festival);
            }
            else if(entity.getFestival() != null && entity.getFestival().equals(festival))
            {
                entity.setFestival(null);
            }
        }
        return listaFunciones;
    }
    /**
     * Método que remueve una Función de un Festival.
     * @param idFestival Long, ID del Festival.
     * @param idFuncion Long, ID de la Función a des asociar.
     */
    public void removeFuncion(Long idFestival, Long idFuncion)
    {
        FestivalEntity festival = getFestival(idFestival);
        FuncionEntity funcion = funcionLogic.getFuncion(idFuncion);
        funcion.setFestival(null);
        festival.getFunciones().remove(funcion);
    }
    
    ///////////OPERACIONES SOBRE ESPECTADOR////////////////
    /**
     * Método que asocia un Espectador a un Festival.
     * @param idFestival Long, ID del Festival.
     * @param idEspectador Long, ID del Espectador.
     * @return EspectadorEntity, Espectador asociado.
     */
    public EspectadorEntity addEspectador (Long idFestival, Long idEspectador)
    {
        FestivalEntity festival = getFestival(idFestival);
        EspectadorEntity espectador = espectadorLogic.getEspectador(idEspectador);
        List<EspectadorEntity> list = new ArrayList<>();
        list.add(espectador);
        festival.setEspectadores(list);
        //  espectador.setFestival(festival);
        return espectador;
    }
    /**
     * Método que obtiene la Lista de Espectadores de un Festival.
     * @param idFestival Long, ID del Festival.
     * @return Lis<EspectadorEntity>, Lista de Espectadores del Festival.
     */
    public List<EspectadorEntity> getEspectadores(Long idFestival)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de buscar los teatros asociadosa al festival con id = {0}", idFestival);
        if(getFestival(idFestival)==null)
        {
            LOGGER.log(Level.SEVERE,"No se ha encontrado un festival con el id",idFestival);
        }
        return getFestival(idFestival).getEspectadores();
    }
    /**
     * Método que obtiene un Espectador específico de un Festival.
     * @param idFestival Long, ID del Festival.
     * @param idEspectador Long, ID del Espectador.
     * @return EspectadorEntity, Espectador.
     */
    public EspectadorEntity getEspectador(Long idFestival, Long idEspectador)
    {
        LOGGER.log(Level.INFO, "Inicia el proceso de buscar un teatro en festival con el id", idFestival);
        List<EspectadorEntity> listEspectadores = getFestival(idFestival).getEspectadores();
        EspectadorEntity espectador = new EspectadorEntity();
        espectador.setId(idEspectador);
        int index = listEspectadores.indexOf(espectador);
        if(index >= 0)
        {
            return listEspectadores.get(index);
        }
        return null;
    }
    /**
     * Método que reemplaza la Lista de Espectadores del Festival con una nueva.
     * @param idFestival Long, ID del Festival.
     * @param listaEspectadores List<EspectadorEntity>, nueva Lista de Espectadores.
     * @return List<EspectadorEntity>, Lista de Espectadores actualizada.
     */
    public List<EspectadorEntity> replaceEspectadores(Long idFestival, List<EspectadorEntity> listaEspectadores)
    {
        FestivalEntity festival = getFestival(idFestival);
        List<EspectadorEntity> espectadores = espectadorLogic.getEspectadores();
        for(EspectadorEntity entity : espectadores)
        {
            if(listaEspectadores.contains(entity))
            {
                festival.setEspectadores(listaEspectadores);
            }
       }
        return listaEspectadores;
    }
            
    /**
     * Método que des asocia un Espectador del Festival.
     * @param idFestival Long, ID del Festival.
     * @param idEspectador Long, ID del Espectador a des asociar.
     */
    public void removeEspectador(Long idFestival, Long idEspectador)
    {
        FestivalEntity festival = getFestival(idFestival);
        EspectadorEntity espectador = espectadorLogic.getEspectador(idEspectador);
        festival.getEspectadores().remove(espectador);
    }
    
    
   ////////////OPERACIONES SOBRE PATROCINADOR//////////////
      
    /**
     * Método que asocia un Patrocinador a un Festival
     * @param idFestival Long, ID del Festival.
     * @param idPatrocinador Long, ID del Patrocinador.
     * @return PatrocinadorEntity.
     */
    public PatrocinadorEntity addPatrocinador (Long idFestival, Long idPatrocinador)
    {
        FestivalEntity festival = getFestival(idFestival);
        PatrocinadorEntity patrocinador = patrocinadorLogic.get(idPatrocinador);
        patrocinador.setFestival(festival);
        return patrocinador;
    }
    /**
     * Método que obtiene la Lista de Patrocinadores.
     * @param idFestival Long, ID del Festival.
     * @return List<PatrocinadorEntity>, Lista de Patrocinadores del Festival.
     */
    public List<PatrocinadorEntity> getPatrocinadores(Long idFestival)
    {
        FestivalEntity festival = getFestival(idFestival);
        if(festival != null)
        {
            LOGGER.log(Level.SEVERE,"No se ha encontrado un festival con el id",idFestival);     
        }
        return getFestival(idFestival).getPatrocinadores();
    }
    /**
     * Método que obtiene un Patrocinador del Festival.
     * @param idFestival Long, ID del Festival.
     * @param idPatrociandor Long, ID del Patrocinador.
     * @return PatrocinadorEntity, un Patrocinador del Festival.
     */
    public PatrocinadorEntity getPatrocinador(Long idFestival, Long idPatrociandor)
    {
        List<PatrocinadorEntity> patrocinadores = getFestival(idFestival).getPatrocinadores();
        PatrocinadorEntity patrocinador = new PatrocinadorEntity();
        patrocinador.setId(idPatrociandor);
        int index = patrocinadores.indexOf(patrocinador);
        if(index >= 0)
        {
            return patrocinadores.get(index);
        }
        return null;
    }
    /**
     * Método que reemplaza la Lista de Patrocinadores con una Nueva.
     * @param idFestival Long, ID del Festival.
     * @param lista List<PatrocinadorEntity>, nueva Lista de Patrocinadores.
     * @return List<PatrocinadorEntity>, Lista de Patrocinadores actualizada.
     */
    public List<PatrocinadorEntity> replacePatrocinador(Long idFestival, List<PatrocinadorEntity> lista) 
    {
        FestivalEntity festival = getFestival(idFestival);
        List<PatrocinadorEntity> patrocinadores = patrocinadorLogic.get();
        for(PatrocinadorEntity entity : patrocinadores)
        {
            if(lista.contains(entity))
            {
                entity.setFestival(festival);
            }
            else if(entity.getFestival() != null && entity.getFestival().equals(festival))
            {
                entity.setFestival(null);
            }
        }
        return lista;
    }
    
    /**
     * Método que des asocia un Patrocinador del Festival.
     * @param idFestival Long, ID del Festival.
     * @param idPatrociandor Long, ID del Patrocinador a des asociar.
     */
   public void removePatrociandor(Long idFestival, Long idPatrociandor)
    {
        FestivalEntity festival = getFestival(idFestival);
        PatrocinadorEntity patrocinador = patrocinadorLogic.get(idPatrociandor);
        patrocinador.setFestival(null);
        festival.getPatrocinadores().remove(patrocinador);
    }


   ///////////OPERACIONES SOBRE PELICULAS///////////////////
    /**
     * Metodo que agrega una Película al Festival.
     * @param idFestival Long, ID del Festival.
     * @param idPelicula Long, ID de la Película.
     * @return PeliculaEntity, Película agregada.
     * @throws BusinessLogicException 
     */
    public PeliculaEntity addPelicula (Long idFestival, Long idPelicula) throws BusinessLogicException
    {
        FestivalEntity festival = getFestival(idFestival);
        PeliculaEntity pelicula = peliculaLogic.getPelicula(idPelicula);
        List<PeliculaEntity> list = new ArrayList<>();
        list.add(pelicula);
        festival.setPeliculas(list);
        return pelicula;
    }
    /**
     * Método que obtiene la Lista de Películas del Festival.
     * @param idFestival Long, ID del Festival.
     * @return List<PeliculaEntity>, Lista de Películas del Festival.
     */
    public List<PeliculaEntity> getPeliculas (Long idFestival)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de buscar los teatros asociadosa al festival con id = {0}", idFestival);
        if(getFestival(idFestival)==null)
        {
            LOGGER.log(Level.SEVERE,"No se ha encontrado un festival con el id",idFestival);
        }
        return getFestival(idFestival).getPeliculas();
    }
    /**
     * Método que obtiene una Película del Festival.
     * @param idFestival Long, ID del Festival.
     * @param idPelicula Long, ID de la Película.
     * @return PeliculaEntity, una Película del Festival.
     */
    public PeliculaEntity getPelicula (Long idFestival, Long idPelicula)
    {
        LOGGER.log(Level.INFO, "Inicia el proceso de buscar un teatro en festival con el id", idFestival);
        List<PeliculaEntity> listPeliculas = getFestival(idFestival).getPeliculas();
        PeliculaEntity pelicula = new PeliculaEntity();
        pelicula.setId(idPelicula);
        int index = listPeliculas.indexOf(pelicula);
        if(index >= 0)
        {
            return listPeliculas.get(index);
        }
        return null;
    }
    /**
     * Método que reemplaza una Lista de Películas con otra.
     * @param idFestival Long, ID del Festival.
     * @param listPeliculas List<PeliculaEntity>, nueva Lista de Películas del Festival.
     * @return Lista de Películas actualizadas.
     */
    public List<PeliculaEntity> replacePelicula (Long idFestival, List<PeliculaEntity> listPeliculas)
    {
        FestivalEntity festival = getFestival(idFestival);
        List<PeliculaEntity> pelicula = peliculaLogic.getPeliculas();
        for(PeliculaEntity entity : pelicula)
        {
            if(listPeliculas.contains(entity))
            {
                festival.setPeliculas(listPeliculas);
            }
       }
        return listPeliculas;
    }
    /**
     * Método que des asocia una Película de un Festival.
     * @param idFestival Long, ID del Festival.
     * @param idPelicula Long, ID de la Película.
     * @throws BusinessLogicException 
     */
    public void removePelicula(Long idFestival, Long idPelicula) throws BusinessLogicException
    {
        FestivalEntity festival = getFestival(idFestival);
        PeliculaEntity pelicula = peliculaLogic.getPelicula(idPelicula);
        festival.getPeliculas().remove(pelicula);
    }
}
