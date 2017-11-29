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
    /**
     * Atributo que contiene la lista de Boletas de esta Función.
     */
    private List<BoletaDTO> boletas;
    /**
     * Atributo que contiene la lista de Críticas de esta Función.
     */
    private List<CriticaDTO> criticas;
    /**
     * Atributo que contiene la Película de esta Función.
     */
    private PeliculaDTO pelicula;
    /**
     * Atributo que contiene la Sala de esta Función.
     */
    private SalaDTO sala;
    /**
     * Atributo que contiene el Festival al que pertenece esta Función.
     */
    private FestivalDTO festival;
    /**
     * Método constructor por defecto.
     */
    public FuncionDetailDTO() {
        //Método constructor por Defecto.
    }
    /**
     * Método que construye un FuncionDetailDTO a partir de la versión Entidad de Función.
     * @param entity FuncionEntity, entidad de Función.
     */
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
    /**
     * Método que obtiene la lista de Boletas de esta Función.
     * @return List<BoletaDTO>, Lista de Boletas de esta Función.
     */
    public List<BoletaDTO> getBoletas() {
        return boletas;
    }
    /**
     * Método que establece la lista de Boletas de esta Función.
     * @param boletas List<BoletaDTO>, nueva Lista de Boletas de esta Función.
     */
    public void setBoletas(List<BoletaDTO> boletas) {
        this.boletas = boletas;
    }
    /**
     * Método que obtiene la lista de Críticas de esta Función.
     * @return List<CriticaDTO>, lista de Críticas de esta Función.
     */
    public List<CriticaDTO> getCriticas() {
        return criticas;
    }
    /**
     * Método que establece la lista de Críticas de esta Función.
     * @param criticas List<CriticaDTO>, nueva lista de Críticas de esta Función.
     */
    public void setCriticas(List<CriticaDTO> criticas) {
        this.criticas = criticas;
    }
    /**
     * Método que obtiene la Película de esta Función.
     * @return PeliculaDTO, Película de esta Función.
     */
    public PeliculaDTO getPelicula() {
        return pelicula;
    }
    /**
     * Método que establece la Película de esta Función.
     * @param pelicula PeliculaDTO, nueva Película de esta Función.
     */
    public void setPelicula(PeliculaDTO pelicula) {
        this.pelicula = pelicula;
    }
    /**
     * Método que obtiene la Sala de esta Función.
     * @return SalaDTO, Sala de esta Función.
     */
    public SalaDTO getSala() {
        return sala;
    }
    /**
     * Método que establece la Sala de esta Función.
     * @param sala SalaDTO, nueva Sala de esta Función.
     */
    public void setSala(SalaDTO sala) {
        this.sala = sala;
    }
    /**
     * Método que obtiene el Festival de esta Función.
     * @return FestivalDTO, Festival al que pertenece esta Función.
     */
    public FestivalDTO getFestival() {
        return festival;
    }
    /**
     * Método que establece el Festival al que pertenece esta Función-
     * @param festival FestivalDTO, nuevo Festival al que pertenece esta Función.
     */
    public void setFestival(FestivalDTO festival) {
        this.festival = festival;
    }
    /**
     * Método que construye un objeto FuncionEntity a partir de este DTO.
     * @return FuncionEntity.
     */
    @Override
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
        
