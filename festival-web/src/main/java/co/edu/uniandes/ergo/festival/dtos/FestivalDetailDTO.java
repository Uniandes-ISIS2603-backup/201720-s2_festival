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
package co.edu.uniandes.ergo.festival.dtos;
import co.edu.uniandes.ergo.festival.entities.FestivalEntity;
import co.edu.uniandes.ergo.festival.entities.*;
import java.util.*;


/**
 *
 * @author ISIS2603
 */
public final class FestivalDetailDTO extends FestivalDTO {
    /**
     * Atributo que contiene la Lista de Teatros del Festival.
     */
    private List<TeatroDTO> teatros;
    /**
     * Atributo que contiene la Lista de Películas del Festival.
     */
    private List<PeliculaDTO> peliculas;
    /**
     * Atributo que contiene la Lista de Espectadores del Festival.
     */
    private List<EspectadorDTO> espectadores;
    /**
     * Atributo que contiene la Lista de Críticos del Festival.
     */
    private List<CriticoDTO> criticos;
    /**
     * Atributo que contiene la Lista de Patrocinadores del Festival.
     */
    private List<PatrocinadorDTO> patrocinadores;
    /**
     * Atributo que contiene la Lista de Funciones del Festival.
     */
    private List<FuncionDTO> funciones;
    
    /**
     * Constructor por defecto
     */
    public FestivalDetailDTO() 
    {
       
    }
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public FestivalDetailDTO(FestivalEntity entity) {
        super(entity);
         teatros = listTeatros2DTO(entity);
         funciones = listFunciones2DTO(entity);
    }
    /**
     * Método que obtiene la Lista de Teatros del Festival.
     * @return List<TeatroDTO> Lista de Teatros del Festival.
     */
    public List<TeatroDTO> getTeatros() {
        return teatros;
    }
    /**
     * Método que establece la Lista de Teatros del Festival.
     * @param teatros List<TeatroDTO>, nueva Lista de Teatros del Festival.
     */
    public void setTeatros(List<TeatroDTO> teatros) {
        this.teatros = teatros;
    }
    /**
     * Método que obtiene la Lista de Películas del Festival.
     * @return List<PeliculaDTO> Lista de Películas del Festival.
     */
    public List<PeliculaDTO> getPeliculas() {
        return peliculas;
    }
    /**
     * Método que establece la Lista de Películas del Festival.
     * @param peliculas List<PeliculaDTO> nueva Lista de Películas del Festival.
     */
    public void setPeliculas(List<PeliculaDTO> peliculas) {
        this.peliculas = peliculas;
    }
    /**
     * Método que obtiene la Lista de Espectadores del Festival.
     * @return List<EspectadorDTO> Lista de Espectadores del Festival.
     */
    public List<EspectadorDTO> getEspectadores() {
        return espectadores;
    }
    /**
     * Método que Establece la Lista de Espectadores del Festival.
     * @param espectadores List<EspectadorDTO>, nueva Lista de Espectadores del Festival.
     */
    public void setEspectadores(List<EspectadorDTO> espectadores) {
        this.espectadores = espectadores;
    }
    /**
     * Método que obtiene la Lista de Críticos del Festival.
     * @return List<CriticoDTO> Lista de Críticos del Festival.
     */
    public List<CriticoDTO> getCriticos() {
        return criticos;
    }
    /**
     * Método que establece la Lista de Críticos del Festival.
     * @param criticos List<CriticoDTO>, nueva Lista de Críticos del Festival.
     */
    public void setCriticos(List<CriticoDTO> criticos) {
        this.criticos = criticos;
    }
    /**
     * Método que obtiene la Lista de Patrocinadores del Festival.
     * @return List<PatrocinadorDTO>, Lista de Patrocinadores del Festival.
     */
    public List<PatrocinadorDTO> getPatrocinadores() {
        return patrocinadores;
    }
    /**
     * Método que establece la Lista de Patrocinadores del Festival.
     * @param patrocinador List<PatrocinadorDTO>, Lista de Patrocinadores del Festival.
     */
    public void setPatrocinadores(List<PatrocinadorDTO> patrocinador) {
        this.patrocinadores = patrocinador;
    }
    /**
     * Método que obtiene la Lista de Funciones del Festival.
     * @return List<FuncionDTO>, Lista de Funciones del Festival.
     */
    public List<FuncionDTO> getFunciones() {
        return funciones;
    }
    /**
     * Método que establece la Lista de Funciones del Festival.
     * @param funcion List<FuncionDTO>, nueva Lista de Funciones del Festival.
     */
    public void setFunciones(List<FuncionDTO> funcion) {
        this.funciones = funcion;
    }
    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public FestivalEntity toEntity() {
        FestivalEntity festivalE = super.toEntity();
        festivalE.setTeatros(listDTO2Teatros());
        festivalE.setFunciones(listDTO2Funciones());
         return festivalE;
        
    }
    /**
     * Método que transforma una Lista de Entidades de Teatros a TeatroDTOs
     * @param entity FestivalEntity
     * @return List<TeatroDTO>, Teatros en formato DTO.
     */
    public List<TeatroDTO> listTeatros2DTO(FestivalEntity entity) {
        List<TeatroDTO> lista = new ArrayList();
        for(TeatroEntity teatro: entity.getTeatros())
        {
            lista.add(new TeatroDTO(teatro));
        }
        return lista;
    }
    /**
     * Método que transforma los DTOS de Teatros a Entidades.
     * @return List<TeatroEntity>, Teatros en formato Entity.
     */
    public List<TeatroEntity> listDTO2Teatros()
    {
        List<TeatroEntity> lista = new ArrayList();
        if(teatros != null)
        {
            for(TeatroDTO teatro : teatros)
            {
                lista.add(teatro.toEntity());
            }
        }
        return lista;
    }
    /**
     * Método que transforma las Entidades de Funciones a DTOs.
     * @param entity FestivalEntity
     * @return List<FuncionDTO>, funciones en formato DTO.
     */
    public List<FuncionDTO> listFunciones2DTO(FestivalEntity entity) {
        List<FuncionDTO> lista = new ArrayList();
        for(FuncionEntity funcion: entity.getFunciones())
        {
            lista.add(new FuncionDTO(funcion));
        }
        return lista;
    }
    /**
     * Método que transofrma los DTOs de Funciones a Entidades.
     * @return List<FuncionEntity>, Lista de Funciones en formato Entity.
     */
    public List<FuncionEntity> listDTO2Funciones()
    {
        List<FuncionEntity> lista = new ArrayList();
        if(funciones != null)
        {
            for(FuncionDTO funcion : funciones)
            {
                lista.add(funcion.toEntity());
            }
        }
        return lista;
    }
}
