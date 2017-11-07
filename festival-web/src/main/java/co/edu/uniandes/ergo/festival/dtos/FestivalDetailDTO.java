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
    private List<TeatroDTO> teatros;
    
    private List<PeliculaDTO> peliculas;
    
    private List<EspectadorDTO> espectadores;
    
    private List<CriticoDTO> criticos;
    
    private List<PatrocinadorDTO> patrocinadores;
    
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

    public List<TeatroDTO> getTeatros() {
        return teatros;
    }

    public void setTeatros(List<TeatroDTO> teatros) {
        this.teatros = teatros;
    }

    public List<PeliculaDTO> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<PeliculaDTO> peliculas) {
        this.peliculas = peliculas;
    }

    public List<EspectadorDTO> getEspectadores() {
        return espectadores;
    }

    public void setEspectadores(List<EspectadorDTO> espectadores) {
        this.espectadores = espectadores;
    }

    public List<CriticoDTO> getCriticos() {
        return criticos;
    }

    public void setCriticos(List<CriticoDTO> criticos) {
        this.criticos = criticos;
    }

    public List<PatrocinadorDTO> getPatrocinadores() {
        return patrocinadores;
    }

    public void setPatrocinadores(List<PatrocinadorDTO> patrocinador) {
        this.patrocinadores = patrocinador;
    }

    public List<FuncionDTO> getFunciones() {
        return funciones;
    }

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

    public List<TeatroDTO> listTeatros2DTO(FestivalEntity entity) {
        List<TeatroDTO> lista = new ArrayList();
        for(TeatroEntity teatro: entity.getTeatros())
        {
            lista.add(new TeatroDTO(teatro));
        }
        return lista;
    }
    
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

    public List<FuncionDTO> listFunciones2DTO(FestivalEntity entity) {
        List<FuncionDTO> lista = new ArrayList();
        for(FuncionEntity funcion: entity.getFunciones())
        {
            lista.add(new FuncionDTO(funcion));
        }
        return lista;
    }
    
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
