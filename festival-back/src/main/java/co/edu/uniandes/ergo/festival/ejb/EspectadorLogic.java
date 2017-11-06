/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.ejb;

import co.edu.uniandes.ergo.festival.entities.AbonoEntity;
import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.entities.EspectadorEntity;
import co.edu.uniandes.ergo.festival.exceptions.BusinessLogicException;
import co.edu.uniandes.ergo.festival.persistence.EspectadorPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author dj.bautista10
 */
@Stateless
public class EspectadorLogic {

    private static final Logger LOGGER = java.util.logging.Logger.getLogger(EspectadorLogic.class.getName());

    @Inject
    private EspectadorPersistence persistence;

    @Inject
    private AbonoLogic aLogic;

    public List<EspectadorEntity> getEspectadores() {
        LOGGER.info("Inicia el proceso de consultar todas los críticos.");
        List<EspectadorEntity> espectadores = persistence.findAll();
        LOGGER.info("Termina el proceso de consultar todas los críticos.");
        return espectadores;
    }

    public EspectadorEntity getEspectador(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el crítico con id={0}", id);

        EspectadorEntity espectador = persistence.find(id);

        if (espectador == null) {
            LOGGER.log(Level.SEVERE, "El espectador con el id {0} no existe", id);
        }

        LOGGER.log(Level.INFO, "Termina proceso de consultar el crítico con id={0}", id);
        return espectador;
    }

    public EspectadorEntity createEspectador(EspectadorEntity nueva) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de el crítico.");
        System.out.println("nombre: " + nueva.getName());
        //int val = ValidarCreate(nueva);
        int val = 0;
        if (val != 0) {
            String excepcion = (val == 1) ? "El nombre de el crítico no es válido."
                    : (val == 2) ? "Ya existe un espectador con el mismo nombre"
                            : (val == 3) ? "El espectador no puede durar 0 minutos"
                                    : "El espectador debe tener al menos 1 género";

            throw new BusinessLogicException(excepcion);
        }

        EspectadorEntity conId = persistence.create(nueva);
        LOGGER.info("Termina proceso de creación de el crítico.");
        return conId;
    }

    public EspectadorEntity updateEspectador(Long id, EspectadorEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar libro con id={0}", id);
        if (persistence.find(id) == null) {
            throw new BusinessLogicException("No se encuentra el crítico con el id " + id + " ");
        }
        EspectadorEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el crítico con id={0}", entity.getId());
        return newEntity;
    }

    public void deleteEspectador(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el crítico con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar el crítico con id={0}", id);
    }

    public EspectadorEntity addAbono(Long espectadorId, AbonoEntity abono) throws BusinessLogicException {
        EspectadorEntity espectador = getEspectador(espectadorId);
        LOGGER.log(Level.INFO, "Inicia proceso de crear el abono para el cliente con id ={0}", espectadorId);
        abono.setEspectador(espectador);

        AbonoEntity abonoRes = aLogic.createAbono(abono);

        espectador.addAbono(abonoRes);
        persistence.update(espectador); // NO ESTOY SEGURO SI SE DEBE PONER ESE UPDATE
        return espectador;
    }

    public List<AbonoEntity> darMisAbonos(Long id) {
        EspectadorEntity espectador = getEspectador(id);
        return espectador.getAbonos();
    }

    /*  public EspectadorEntity updateAbono(Long id, AbonoEntity abono) throws BusinessLogicException {
       EspectadorEntity espectador = getEspectador(id);
       abono = aLogic.updateAbono(abono.getId(), abono);
       for (AbonoEntity ab : espectador.getAbonos()){
           if (ab.getId() == abono.getId())
              espectador.getAbonos().set(espectador.getAbonos().indexOf(ab.getId()), abono);
       }
       return updateEspectador(id, espectador);
    }
     */
    public EspectadorEntity asociarBoleta(Long idEspec, BoletaEntity boleta) {
        EspectadorEntity espectador = getEspectador(idEspec);
        espectador.addBoleta(boleta);
        return persistence.update(espectador);
    }

    public List<BoletaEntity> darBoletasEspec(Long id) {
        EspectadorEntity espec = getEspectador(id);
        return espec.getBoletas();
    }
}
