/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;

import co.edu.uniandes.ergo.festival.entities.PeliculaEntity;
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
public class PeliculaPersistenceTest {

    /**
     * Inyección de la dependencia a la clase Pelicula cuyos métodos se van a
     * probar.
     */
    @Inject
    private PeliculaPersistence persistence;

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
    private List<PeliculaEntity> data = new ArrayList<PeliculaEntity>();

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
                .addPackage(PeliculaEntity.class.getPackage())
                .addPackage(PeliculaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    public PeliculaPersistenceTest() {
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

        } catch (Exception e) {
        }

    }

    @After
    public void tearDown() {
    }

    private void clearData() {
        em.createQuery("delete from PeliculaEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            PeliculaEntity entity = factory.manufacturePojo(PeliculaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Test of create method, of class PeliculaPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        PeliculaEntity newEntity = factory.manufacturePojo(PeliculaEntity.class);
        PeliculaEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        PeliculaEntity entity = em.find(PeliculaEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());

    }

    /**
     * Test of update method, of class PeliculaPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update test");
        PeliculaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        PeliculaEntity generada = factory.manufacturePojo(PeliculaEntity.class);
        
        generada.setId(entity.getId());
        persistence.update(generada);
        
        PeliculaEntity actualizado = em.find(PeliculaEntity.class, entity.getId());
        assertNotNull(actualizado);
        assertNotEquals(generada.getName(), actualizado.getName());
    }

    /**
     * Test of delete method, of class PeliculaPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("Delete test");
        PeliculaEntity entity = data.get(0);
        persistence.delete(entity.getId());
        PeliculaEntity espNull = em.find(PeliculaEntity.class, entity.getId());
        Assert.assertNull(espNull);
        
    }

    /**
     * Test of find method, of class PeliculaPersistence.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("Test find");
        PeliculaEntity pelicula = data.get(0);
        PeliculaEntity CompPelicula = persistence.find(pelicula.getId());
        Assert.assertNotNull(CompPelicula);
        Assert.assertEquals(pelicula, CompPelicula);
    }

    /**
     * Test of findAll method, of class PeliculaPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("Test findAll");
        List<PeliculaEntity> peliculas = persistence.findAll();
        for (PeliculaEntity ent : peliculas) {
            boolean found = false;
            for (PeliculaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

}
