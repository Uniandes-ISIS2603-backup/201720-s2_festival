/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.AbonoEntity;
import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.entities.EspectadorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dj.bautista10
 */
public class EspectadorDetailDTO extends EspectadorDTO {
    /**
     * Atributo que contiene la Lista de Boletas.
     */
    private List<BoletaDTO> boletas;
    /**
     * Atributo que contiene la Lista de Abonos.
     */
    private List<AbonoDTO> abonos;
    /**
     * Método constructor por defecto.
     */
    public EspectadorDetailDTO(){ 
        super();
    }
    /**
     * Método que construye un EspectadorDetail a partir de su versión Entity.
     * @param espectador EspectadorEntity, Entidad de Espectador.
     */
    public EspectadorDetailDTO(EspectadorEntity espectador){
        super(espectador);
        if(espectador.getAbonos() != null){
            abonos = new ArrayList<>();
            for(AbonoEntity abn : espectador.getAbonos()){
                abonos.add(new AbonoDTO(abn));
            }
        }
        
        if(espectador.getBoletas() != null){
            boletas = new ArrayList<>();
            for(BoletaEntity bol : espectador.getBoletas()){
                boletas.add(new BoletaDTO(bol));
            }
        }
    }
    /**
     * Método que obtiene los Abonos del Espectador.
     * @return List<AbonoDTO>, Lista de Abonos.
     */
    public List<AbonoDTO> getAbonos(){
        return abonos;
    }
    /**
     * Método que obtiene la Lista de Boletas de este Espectador.
     * @return List<BoletaDTO>, Lista de Boletas del Espectador.
     */
    public List<BoletaDTO> getBoletas(){
        return boletas;
    }
    /**
     * Método que establece la Lista de Abonos del Espectador.
     * @param abonos List<AbonoDTO>, nueva Lista de Abonos del Espectador.
     */
    public void setAbonos(List<AbonoDTO> abonos){
        this.abonos = abonos;
    }
    /**
     * Método que establece la Lista de Boletas del Espectador.
     * @param boletas List<BoletaDTO>, nueva Lista de Boletas del Espectador.
     */
    public void setBoletas(List<BoletaDTO> boletas){
        this.boletas = boletas;
    }
    /**
     * Método que construye un objeto EspectadorEntity a partir de este DTO.
     * @return EspectadorEntity, Entidad del Espectador.
     */
    @Override
    public EspectadorEntity toEntity(){
        EspectadorEntity eEspectador = super.toEntity();
        if(this.getAbonos() != null){
            List<AbonoEntity> eAbonos = new ArrayList<>();
            for(AbonoDTO a : abonos){
                eAbonos.add(a.toEntity());
            }
            eEspectador.setAbonos(eAbonos);
        }  
        if(this.getBoletas() != null){
            List<BoletaEntity> eBoletas = new ArrayList<>();
            for(BoletaDTO b : boletas){
                eBoletas.add(b.toEntity());
            }
            eEspectador.setBoletas(eBoletas);
        }
        return eEspectador;
    }
}
