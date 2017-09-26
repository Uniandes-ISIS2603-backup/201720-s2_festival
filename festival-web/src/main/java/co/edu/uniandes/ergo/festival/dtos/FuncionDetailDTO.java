/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.entities.CriticaEntity;
import co.edu.uniandes.ergo.festival.entities.FuncionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m.neira10
 */
public class FuncionDetailDTO extends FuncionDTO{

    
    private List<BoletaDTO> boletas;
    private List<CriticaDTO> criticas;
    private PeliculaDTO pelicula;
    private SalaDTO sala;
    private FestivalDTO festival;
    
    public FuncionDetailDTO() {
        
    }
    


    
    public FuncionDetailDTO(FuncionEntity entity) {
        super(entity); 
        if(!(entity.getBoletas().isEmpty())){
            boletas= new ArrayList<>();
            for(BoletaEntity bol: entity.getBoletas()){
                boletas.add(new BoletaDTO(bol));
            }
        }
        else{
            boletas = new ArrayList<>();
        }
        if(!(entity.getCriticas().isEmpty())){
            criticas = new ArrayList<>();
            for(CriticaEntity crit : entity.getCriticas()){
                criticas.add(new CriticaDTO(crit));
            }
        }
        else{
            criticas = new ArrayList<>();
        }
        if(!(entity.getPelicula()==null)){
            pelicula = new PeliculaDTO(entity.getPelicula());
        }
        else{
            pelicula = new PeliculaDTO();
        }
        if(!(entity.getSala()==null)){
            sala = new SalaDTO(entity.getSala());
        }
        else{
            sala = new SalaDTO();
        }
        if(!(entity.getFestival()==null)){
            festival = new FestivalDTO(entity.getFestival());
        }
        else{
            festival = new FestivalDTO();
        }
    }

    public FuncionEntity toEntity() {
        FuncionEntity entity = new FuncionEntity();
        entity.setHoraInicio(this.getHoraInicio());
        entity.setHoraFin(this.getHoraFin());
        entity.setId(this.getId());
        entity.setName(this.getName());
        
        ArrayList<BoletaEntity> bols =  new ArrayList<>();
        for(BoletaDTO bol : boletas){
            bols.add(bol.toEntity());
        }
        
        entity.setBoletas(bols);
        
        ArrayList<CriticaEntity> crits =  new ArrayList<>();
        for(CriticaDTO crit : criticas){
            crits.add(crit.toEntity());
        }
        
        entity.setCriticas(crits);
        
        entity.setFestival(festival.toEntity());
        entity.setPelicula(pelicula.toEntity());
        entity.setSala(sala.toEntity());
        
        return entity;
    }
}
        
