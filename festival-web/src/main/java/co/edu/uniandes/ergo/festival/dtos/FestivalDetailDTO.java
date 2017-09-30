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
public class FestivalDetailDTO extends FestivalDTO {
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
        if(entity != null)
        {
            teatros = new ArrayList<>();
            for(TeatroEntity entityTeatro : entity.getTeatros())
            {
                teatros.add(new TeatroDTO(entityTeatro));
            }
            
            peliculas = new ArrayList<>();
            for(PeliculaEntity entityPelicula : entity.getPeliculas())
            {
                peliculas.add(new PeliculaDTO(entityPelicula));
            }
            
            espectadores = new ArrayList<>();
            for(EspectadorEntity entityEspectador : entity.getEspectadores())
            {
                espectadores.add(new EspectadorDTO(entityEspectador));
            }
            
            criticos = new ArrayList<>();
            for(CriticoEntity entityCritico : entity.getCriticos())
            {
                criticos.add(new CriticoDTO(entityCritico));
            }
            
            patrocinadores = new ArrayList<>();
            for(PatrocinadorEntity entityPatrtociandor : entity.getPatrocinadores())
            {
                patrocinadores.add(new PatrocinadorDTO(entityPatrtociandor));
            }
            
            funciones = new ArrayList<>();
            for(FuncionEntity entityFuncion : entity.getFunciones())
            {
                funciones.add(new FuncionDTO(entityFuncion));
            }
        }
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
        
        if(getTeatros() != null)
        {
            List<TeatroEntity> teatrosEntity = new ArrayList<>();
            for(TeatroDTO dtoTeatro : getTeatros())
            {
                teatrosEntity.add(dtoTeatro.toEntity());
            }
            festivalE.setTeatros(teatrosEntity);
        }
        
        if(getPeliculas() != null)
        {
            List<PeliculaEntity> peliculasEntity = new ArrayList<>();
            for(PeliculaDTO dtoPelicula : getPeliculas())
            {
               peliculasEntity.add(dtoPelicula.toEntity());
            }
            festivalE.setPeliculas(peliculasEntity);
        }
        
        if(getEspectadores() != null)
        {
            List<EspectadorEntity> espectadoresEntity = new ArrayList<>();
            for(EspectadorDTO dtoEspectador : getEspectadores())
            {
                espectadoresEntity.add(dtoEspectador.toEntity());
            }
            festivalE.setEspectadores(espectadoresEntity);           
        }
        
        if(getCriticos() != null)
        {
            List<CriticoEntity> criticosEntity = new ArrayList<>();
            for(CriticoDTO dtoCritico : getCriticos())
            {
                criticosEntity.add(dtoCritico.toEntity());
            }
            festivalE.setCriticos(criticosEntity);
        }
        
         if(getFunciones() != null)
        {
            List<FuncionEntity> funcionesEntity = new ArrayList<>();
            for(FuncionDTO dtoFuncion : getFunciones())
            {
                funcionesEntity.add(dtoFuncion.toEntity());
            }
            festivalE.setFunciones(funcionesEntity);
        }
         
         if(getPatrocinadores()!= null)
        {
            List<PatrocinadorEntity> patrocinadoresEntity = new ArrayList<>();
            for(PatrocinadorDTO dtoPatrocinador : getPatrocinadores())
            {
                patrocinadoresEntity.add(dtoPatrocinador.toEntity());
            }
            festivalE.setPatrocinadores(patrocinadoresEntity);
        }
      return festivalE;
    }

}
