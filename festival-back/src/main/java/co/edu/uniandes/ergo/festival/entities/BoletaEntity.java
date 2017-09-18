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
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
/**
 * Clase que contiene la información de una boleta.
 * @author jc.corrales
 */
@Entity
public class BoletaEntity extends BaseEntity implements Serializable
{
    /**
     * Atributo que contiene la calificación asociada.
     */
    //@OneToOne
    //private CalificacionEntity calificacion;
    /**
     * Atributo que contiene la información del espectador asociado.
     */
   // @OneToOne
    //private EspectadorEntity espectador;
    /**
     * Atributo que contiene la información de la silla asignada.
     */
    //@OneToOne
    //private SillaEntity silla;
    /**
     * Función a la que la Boleta concede acceso a.
     */
    //@ManyToMany
    //private FuncionEntity funcion;
    /**
     * Atributo que contiene el Abono al cual está asociado, si hay.
     */
    //@ManyToOne
    //private AbonoEntity abono;
    /**
     * Atributo que obtiene la calificación asociada.
     * @return CalificacionEntity
     */

    //public CalificacionEntity getCalificacion()
    //{
        //return calificacion;
    //}
    /**
     * Método que establece la calificación asociada.
     * @param calificacion CalificacionEntity
     */
    //public void setCalificacion(CalificacionEntity calificacion)
    //{
        //this.calificacion = calificacion;
    //}
    /**
     * Método que obtiene el espectador asociado.
     * @return EspectadorEntity
     */
    //public EspectadorEntity getEspectador()
    //{
       // return espectador;
    //}
    /**
     * Método que establece el espectador asociado.
     * @param espectador EspectadorEntity
     */
    //public void setEspectador(EspectadorEntity espectador)
    //{
       // this.espectador = espectador;
    //}
    /**
     * Método que obtiene la silla asociada.
     * @return SillaEntity
     */
    //public SillaEntity getSilla()
    //{
        //return silla;
    //}
    /**
     * Método que establece la silla asociada.
     * @param silla SillaEntity
     */
    //public void setSilla (SillaEntity silla)
    //{
        //this.silla = silla;
    //}
    /**
     * Mérodo que returna la función de la Boleta.
     * @return 
     */
    //public FuncionEntity getFuncion()
    //{
       // return funcion;
    //}
    /**
     * Método que establece la función de la Boleta.
     * @param funcion 
     */
    //public void setFuncion(FuncionEntity funcion)
    //{
        //this.funcion = funcion;
    //}
    /**
     * Método qque retorna el Abono asociado, si lo hay.
     * @return Abono AbonoEntity
     */
    //public AbonoEntity getAbono()
    //{
        //return abono;
    //}
    /**
     * Método que establece el Abono al que esta Boleta pertenece.
     * @param abono AbonoEntity
     */
    //public void setAbono(AbonoEntity abono)
    //{
        //this.abono = abono;
    //}
}