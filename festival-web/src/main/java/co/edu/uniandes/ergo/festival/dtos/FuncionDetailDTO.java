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

    public List<BoletaDTO> getBoletas() {
        return boletas;
    }

    public void setBoletas(List<BoletaDTO> boletas) {
        this.boletas = boletas;
    }

    public List<CriticaDTO> getCriticas() {
        return criticas;
    }

    public void setCriticas(List<CriticaDTO> criticas) {
        this.criticas = criticas;
    }

    public PeliculaDTO getPelicula() {
        return pelicula;
    }

    public void setPelicula(PeliculaDTO pelicula) {
        this.pelicula = pelicula;
    }

    public SalaDTO getSala() {
        return sala;
    }

    public void setSala(SalaDTO sala) {
        this.sala = sala;
    }

    public FestivalDTO getFestival() {
        return festival;
    }

    public void setFestival(FestivalDTO festival) {
        this.festival = festival;
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
        if (boletas!=null){
            for(BoletaDTO bol : boletas){
            bols.add(bol.toEntity());
            }
        }
        
        
        entity.setBoletas(bols);//cuando no hay boletas, bols.size()==0
        
        ArrayList<CriticaEntity> crits =  new ArrayList<>();
        if(criticas!=null){
            for(CriticaDTO crit : criticas){
            crits.add(crit.toEntity());
            }
        }
        
        
        entity.setCriticas(crits);//cuando no hay criticas, crits.size()==0
        
        if(festival==null){
            entity.setFestival(null);
        }
        else{
            entity.setFestival(festival.toEntity());    
        }
        if(pelicula==null){
            entity.setPelicula(null);
        }
        else{
            entity.setPelicula(pelicula.toEntity());
        }
        if(sala==null){
            entity.setSala(null);
        }
        else{
            entity.setSala(sala.toEntity());
        }
        
        
        return entity;
    }
}
        
