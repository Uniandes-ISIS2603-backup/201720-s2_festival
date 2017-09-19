/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;

import co.edu.uniandes.ergo.festival.entities.SalaEntity;
import java.util.ArrayList;
import java.util.List;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author f.mayenberger10
 */
@RunWith(Arquillian.class)
public class SalaPersistenceTest {
    
    /**
     * Inyección de la dependencia a la clase Sala cuyos métodos se van a
     * probar.
     */
    @Inject
    private SalaPersistence persistence;

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
    private List<SalaEntity> data = new ArrayList<>();

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
                .addPackage(SalaEntity.class.getPackage())
                .addPackage(SalaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    public SalaPersistenceTest() {
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
        em.createQuery("delete from SalaEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            SalaEntity entity = factory.manufacturePojo(SalaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Test of create method, of class SalaPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        SalaEntity newEntity = factory.manufacturePojo(SalaEntity.class);
        
        SalaEntity result = persistence.create(newEntity);
        Assert.assertNotNull(result);
        SalaEntity entity = em.find(SalaEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());

    }

    /**
     * Test of update method, of class SalaPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update test");
        SalaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        SalaEntity generada = factory.manufacturePojo(SalaEntity.class);
        
        generada.setId(entity.getId());
        persistence.update(generada);
        
        SalaEntity actualizado = em.find(SalaEntity.class, entity.getId());
        assertNotNull(actualizado);
        assertEquals(generada.getName(), actualizado.getName());
    }

    /**
     * Test of delete method, of class SalaPersistence.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("Remove test");
        SalaEntity entity = data.get(0);
        persistence.remove(entity.getId());
        SalaEntity espNull = em.find(SalaEntity.class, entity.getId());
        Assert.assertNull(espNull);
        
    }

    /**
     * Test of find method, of class SalaPersistence.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("Test find");
        SalaEntity pelicula = data.get(0);
        SalaEntity CompSala = persistence.find(pelicula.getId());
        Assert.assertNotNull(CompSala);
        Assert.assertEquals(pelicula, CompSala);
    }

    /**
     * Test of findAll method, of class SalaPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("Test findAll");
        List<SalaEntity> peliculas = persistence.findAll();
        for (SalaEntity ent : peliculas) {
            boolean found = false;
            for (SalaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

}
