/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;

import co.edu.uniandes.ergo.festival.entities.PatrocinadorEntity;
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
public class PatrocinadorPersistenceTest {
    
    /**
     * Inyección de la dependencia a la clase Patrocinador cuyos métodos se van a
     * probar.
     */
    @Inject
    private PatrocinadorPersistence persistence;

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
    private List<PatrocinadorEntity> data = new ArrayList<>();

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
                .addPackage(PatrocinadorEntity.class.getPackage())
                .addPackage(PatrocinadorPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    public PatrocinadorPersistenceTest() {
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
        em.createQuery("delete from PatrocinadorEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            PatrocinadorEntity entity = factory.manufacturePojo(PatrocinadorEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Test of create method, of class PatrocinadorPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        PatrocinadorEntity newEntity = factory.manufacturePojo(PatrocinadorEntity.class);
        
        PatrocinadorEntity result = persistence.create(newEntity);
        Assert.assertNotNull(result);
        PatrocinadorEntity entity = em.find(PatrocinadorEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());

    }

    /**
     * Test of update method, of class PatrocinadorPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update test");
        PatrocinadorEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        PatrocinadorEntity generada = factory.manufacturePojo(PatrocinadorEntity.class);
        
        generada.setId(entity.getId());
        persistence.update(generada);
        
        PatrocinadorEntity actualizado = em.find(PatrocinadorEntity.class, entity.getId());
        assertNotNull(actualizado);
        assertEquals(generada.getName(), actualizado.getName());
    }

    /**
     * Test of delete method, of class PatrocinadorPersistence.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("Remove test");
        PatrocinadorEntity entity = data.get(0);
        persistence.remove(entity.getId());
        PatrocinadorEntity espNull = em.find(PatrocinadorEntity.class, entity.getId());
        Assert.assertNull(espNull);
        
    }

    /**
     * Test of find method, of class PatrocinadorPersistence.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("Test find");
        PatrocinadorEntity pelicula = data.get(0);
        PatrocinadorEntity CompPatrocinador = persistence.find(pelicula.getId());
        Assert.assertNotNull(CompPatrocinador);
        Assert.assertEquals(pelicula, CompPatrocinador);
    }

    /**
     * Test of findAll method, of class PatrocinadorPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("Test findAll");
        List<PatrocinadorEntity> peliculas = persistence.findAll();
        for (PatrocinadorEntity ent : peliculas) {
            boolean found = false;
            for (PatrocinadorEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

}

