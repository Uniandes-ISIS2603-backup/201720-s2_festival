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
package co.edu.uniandes.ergo.festival.entities;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jc.corrales
 */
@Entity
public class AbonoEntity extends BaseEntity implements Serializable
{
    /**
     * Atributo que contiene el precio de la Boleta.
     */
    private Double precio;
    /**
     * Atributo que contiene la información del espectador dueño del abono.
     */
    @ManyToOne
    @PodamExclude
    private EspectadorEntity espectador;
    /**
     * Atributo que contiene las boletas.
     */
    @OneToMany(mappedBy = "abono")
    @PodamExclude
    private List<BoletaEntity> boletas;
    
    /**
     * Método que retorna el arreglo de las boletas vinculadas a este abono.
     * @return BoletaEntity[]
     */
    public List<BoletaEntity> getBoletas()
    {
        return boletas;
    }
    /**
     * Método que establece una arreglo de Boletas vinculadas a este Abono.
     * @param boletas 
     */
    public void setBoletas(List<BoletaEntity> boletas)
    {
        this.boletas = boletas;
    }
    /**
     * Método que obtiene el Espectador dueño de este Abono.
     * @return EspectadorEntity
     */
    public EspectadorEntity getEspectador()
    {
        return espectador;
    }
    /**
     * Método que establece el Espectador dueño de este Abono.
     * @param espectador EspectadorEntity
     */
    public void setEspectador(EspectadorEntity espectador)
    {
        this.espectador = espectador;
    }
    /**
     * Método que obtiene el precio del abono.
     * @return Double, precio del abono.
     */
    public Double getPrecio()
    {
        return precio;
    }
    /**
     * Método que establece el precio del abono.
     * @param precio Double, 
     */
    public void setPrecio(Double precio)
    {
        this.precio = precio;
    }
}