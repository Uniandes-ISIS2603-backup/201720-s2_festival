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
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;
/**
 * Clase que contiene la información de una boleta.
 * @author jc.corrales
 */
@Entity
public class BoletaEntity extends BaseEntity implements Serializable
{
    /**
     * Constante que representa que esta boleta está disponible.
     */
    public final static Integer DISPONIBLE=1;
    /**
     * Constante que representa que esta boleta está reservada.
     */
    public final static Integer RESERVADA=2;
    /**
     * Constate que representa que esta boleta está comprada.
     */
    public final static Integer COMPRADA=3;
    /**
     * Atributo que contiene el código de barras de a boleta.
     */
    private Long codigoDeBarras;
    /**
     * Atributo que contiene el precio de la Boleta.
     */
    private Double precio;
    /**
     * Atributo que contiene el estado de la boleta.
     */
    private Integer estado;
    /**
     * Atributo que contiene la calificación asociada.
     */
    @OneToOne
    @PodamExclude
    private CalificacionEntity calificacion;
    /**
     * Atributo que contiene la información del espectador asociado.
     */
    @OneToOne
    @PodamExclude
    private EspectadorEntity espectador;
    /**
     * Atributo que contiene la información de la silla asignada.
     */
    @OneToOne
    @PodamExclude
    private SillaEntity silla;
    /**
     * Función a la que la Boleta concede acceso a.
     */
    @ManyToOne
    @PodamExclude
    private FuncionEntity funcion;
    /**
     * Atributo que contiene el Abono al cual está asociado, si hay.
     */
    @ManyToOne
    @PodamExclude
    private AbonoEntity abono;
    /**
     * Atributo que obtiene la calificación asociada.
     * @return CalificacionEntity
     */

    public CalificacionEntity getCalificacion()
    {
        return calificacion;
    }
    /**
     * Método que establece la calificación asociada.
     * @param calificacion CalificacionEntity
     */
    public void setCalificacion(CalificacionEntity calificacion)
    {
        this.calificacion = calificacion;
    }
    /**
     * Método que obtiene el espectador asociado.
     * @return EspectadorEntity
     */
    public EspectadorEntity getEspectador()
    {
        return espectador;
    }
    /**
     * Método que establece el espectador asociado.
     * @param espectador EspectadorEntity
     */
    public void setEspectador(EspectadorEntity espectador)
    {
        this.espectador = espectador;
    }
    /**
     * Método que obtiene la silla asociada.
     * @return SillaEntity
     */
    public SillaEntity getSilla()
    {
        return silla;
    }
    /**
     * Método que establece la silla asociada.
     * @param silla SillaEntity
     */
    public void setSilla (SillaEntity silla)
    {
        this.silla = silla;
    }
    /**
     * Mérodo que returna la función de la Boleta.
     * @return 
     */
    public FuncionEntity getFuncion()
    {
        return funcion;
    }
    /**
     * Método que establece la función de la Boleta.
     * @param funcion 
     */
    public void setFuncion(FuncionEntity funcion)
    {
        this.funcion = funcion;
    }
    /**
     * Método qque retorna el Abono asociado, si lo hay.
     * @return Abono AbonoEntity
     */
    public AbonoEntity getAbono()
    {
        return abono;
    }
    /**
     * Método que establece el Abono al que esta Boleta pertenece.
     * @param abono AbonoEntity
     */
    public void setAbono(AbonoEntity abono)
    {
        this.abono = abono;
    }
    /**
     * Método que retorna el código de barras.
     * @return Long, codigoDeBarras
     */
    public Long getCodigoBarras()
    {
        return codigoDeBarras;
    }
    /**
     * Método que establece el código de barras.
     * @param codigoDeBarras Long, nuevo codigo de barras.
     */
    public void setCodigoDeBarras(Long codigoDeBarras)
    {
        this.codigoDeBarras = codigoDeBarras;
    }
    /**
     * Método que obtiene el precio de esta boleta.
     * @return Double, precio de la boleta.
     */
    public Double getPrecio()
    {
        return precio;
    }
    /**
     * Método que establece el precio de esta boleta.
     * @param precio Double, precio nuevo de la boleta.
     */
    public void setPrecio(Double precio)
    {
        this.precio = precio;
    }
    /**
     * Método que devuelve el estado de esta boleta.
     * 1 si está disponible.
     * 2 si está reservada.
     * 3 si está comprada.
     * @return Integer, 1, 2 o 3.
     */
    public Integer getEstado()
    {
        return estado;
    }
    /**
     * Metodo que establece el estado de esta boleta.
     * @param estado Estado de la boleta, sólo puede tener un valor entre 1 y 3
     * 1 para disponible.
     * 2 para reservada.
     * 3 para comprada.
     */
    public void setEstado(Integer estado)
    {
        if(Objects.equals(estado, DISPONIBLE))
        {
            this.estado = estado;
        }
        else if(Objects.equals(estado, RESERVADA))
        {
            this.estado = estado;
        }
        else if(Objects.equals(estado, COMPRADA))
        {
            this.estado = estado;
        }
        else
        {
            
        }
    }
}
