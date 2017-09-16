/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;

import co.edu.uniandes.ergo.festival.entities.EspectadorEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author dj.bautista10
 */
@RunWith(Arquillian.class)
public class EspectadorPersistenceTest {

    /**
     * Inyección de la dependencia a la clase Espectador cuyos métodos se van a
     * probar.
     */
    @Inject
    private EspectadorPersistence persistence;

    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para marcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;

    /**
     *
     */
    private List<EspectadorEntity> data = new ArrayList<EspectadorEntity>();

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Silla, el descriptor de la base
     * de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EspectadorEntity.class.getPackage())
                .addPackage(EspectadorPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    public EspectadorPersistenceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

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

    @After
    public void tearDown() {
    }

    private void clearData() {
        em.createQuery("delete from EspectadorEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            EspectadorEntity entity = factory.manufacturePojo(EspectadorEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Test of create method, of class EspectadorPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        EspectadorEntity newEntity = factory.manufacturePojo(EspectadorEntity.class);
        EspectadorEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        EspectadorEntity entity = em.find(EspectadorEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());
       
    }

    /**
     * Test of update method, of class EspectadorPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update test");
        EspectadorEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        EspectadorEntity generada = factory.manufacturePojo(EspectadorEntity.class);
        
        generada.setId(entity.getId());
        persistence.update(generada);
        
        EspectadorEntity actualizado = em.find(EspectadorEntity.class, entity.getId());
        assertNotNull(actualizado);
        assertEquals(generada.getName(), actualizado.getName());
       
    }

    /**
     * Test of delete method, of class EspectadorPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("Delete test");
        EspectadorEntity entity = data.get(0);
        persistence.delete(entity.getId());
        EspectadorEntity espNull = em.find(EspectadorEntity.class, entity.getId());
        Assert.assertNull(espNull);
        
        
    }

    /**
     * Test of find method, of class EspectadorPersistence.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("Test find");
        EspectadorEntity espectador = data.get(0);
        EspectadorEntity CompEspectador = persistence.find(espectador.getId());
        Assert.assertNotNull(CompEspectador);
        Assert.assertEquals(espectador, CompEspectador);
    }

    /**
     * Test of findAll method, of class EspectadorPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("Test findAll");
        List<EspectadorEntity> espectadores = persistence.findAll();
        for (EspectadorEntity ent : espectadores) {
            boolean found = false;
            for (EspectadorEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
        
    }

}