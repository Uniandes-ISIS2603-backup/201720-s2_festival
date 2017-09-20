/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.AbonoEntity;
import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.entities.EspectadorEntity;
import com.gs.collections.impl.list.fixed.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dj.bautista10
 */
public class EspectadorDetailDTO extends EspectadorDTO {
    
    private List<BoletaDTO> boletas;
    private List<AbonoDTO> abonos;
    
    public EspectadorDetailDTO(){ 
        super();
    }
    
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
    
    public List<AbonoDTO> getAbonos(){
        return abonos;
    }
    
    public List<BoletaDTO> getBoletas(){
        return boletas;
    }
    
    public void setAbonos(List<AbonoDTO> abonos){
        this.abonos = abonos;
    }
    
    public void setBoletas(List<BoletaDTO> boletas){
        this.boletas = boletas;
    }
    
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
