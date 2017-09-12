/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

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
package co.edu.uniandes.ergo.festival.persistence;


import co.edu.uniandes.ergo.festival.entities.BoletaEntity;
import co.edu.uniandes.ergo.festival.persistence.BoletaPersistence;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
/**
 *
 * @author jc.corrales
 */
@RunWith(Arquillian.class)
public class BoletaPersistenceTest
{
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Employee, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDevelopment()
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(BoletaEntity.class.getPackage())
                .addPackage(BoletaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
        /**
     * Inyección de la dependencia a la clase BoletaPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private BoletaPersistence boletaPersistence;
    
    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;
    
    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;
    
    /**
     * Configuración inicial de la prueba.
     *
     *
     */
    @Before
    public void setUp() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from BoletaEntity").executeUpdate();
    }

    /**
     *
     */
    private List<BoletaEntity> data = new ArrayList<BoletaEntity>();
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            BoletaEntity entity = factory.manufacturePojo(BoletaEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear una Boleta.
     *
     *
     */
    @Test
    public void createBoletaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        BoletaEntity newEntity = factory.manufacturePojo(BoletaEntity.class);
        BoletaEntity result = boletaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        BoletaEntity entity = em.find(BoletaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    /**
     * Prueba para consultar la lista de Boletas.
     *
     *
     */
    @Test
    public void getBoletasTest() {
        List<BoletaEntity> list = boletaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (BoletaEntity ent : list) {
            boolean found = false;
            for (BoletaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Prueba para consultar una Boleta.
     *
     *
     */
    @Test
    public void getBoletaTest() {
        BoletaEntity entity = data.get(0);
        BoletaEntity newEntity = boletaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
    }
    
     /**
     * Prueba para eliminar una Boleta.
     *
     *
     */
    @Test
    public void deleteBoletaTest() {
        BoletaEntity entity = data.get(0);
        boletaPersistence.delete(entity.getId());
        BoletaEntity deleted = em.find(BoletaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar una Boleta.
     *
     *
     */
    @Test
    public void updateBoletaTest() {
        BoletaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        BoletaEntity newEntity = factory.manufacturePojo(BoletaEntity.class);

        newEntity.setId(entity.getId());

        boletaPersistence.update(newEntity);

        BoletaEntity resp = em.find(BoletaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }
}
