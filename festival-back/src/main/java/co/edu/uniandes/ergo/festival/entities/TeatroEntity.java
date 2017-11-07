/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;


/**
 *
 * @author de.gutierrez
 */
@Entity 
public class TeatroEntity extends BaseEntity implements Serializable
{
   private Double tarifaBasica;
    @PodamExclude
    @OneToMany(mappedBy="teatro")
    private List<SalaEntity> salas;

    @PodamExclude
    @ManyToOne
    private FestivalEntity festival;
    
    public Double getTarifaBasica() {
        return tarifaBasica;
    }

    public void setTarifaBasica(Double tarifaBasica) {
        this.tarifaBasica = tarifaBasica;
    }

    public List<SalaEntity> getSalas() {
        return salas;
    }

    public void setSalas(List<SalaEntity> salas) {
        this.salas = salas;
    }

    public FestivalEntity getFestival() {
        return festival;
    }

    public void setFestival(FestivalEntity festivales) {
        this.festival = festivales;
    }
    
}
