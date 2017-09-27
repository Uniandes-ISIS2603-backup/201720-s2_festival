/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;

import co.edu.uniandes.ergo.festival.entities.SalaEntity;
import co.edu.uniandes.ergo.festival.entities.SillaEntity;
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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author f.reyes948
 */
@RunWith(Arquillian.class)
public class SillaPersistenceTest {
    
    /**
     * Inyección de la dependencia a la clase SillaPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private SillaPersistence persistence;

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
    private List<SillaEntity> data = new ArrayList<SillaEntity>();
    
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Silla, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(SillaEntity.class.getPackage())
                .addPackage(SillaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public SillaPersistenceTest() {
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
        em.createQuery("delete from SillaEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        SalaEntity sala = factory.manufacturePojo(SalaEntity.class);
        em.persist(sala);
        for (int i = 0; i < 3; i++) {
            SillaEntity entity = factory.manufacturePojo(SillaEntity.class);
            entity.setSala(sala);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Test of create method, of class SillaPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        SalaEntity sala = factory.manufacturePojo(SalaEntity.class);
        utx.begin();
        em.persist(sala);
        utx.commit();
        SillaEntity newEntity = factory.manufacturePojo(SillaEntity.class);
        newEntity.setSala(sala);
        SillaEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        SillaEntity entity = em.find(SillaEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Test of find method, of class SillaPersistence.
     */
    @Test
    public void testFind() throws Exception {
        SillaEntity entity = data.get(0);
        SillaEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * Test of findAll method, of class SillaPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<SillaEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (SillaEntity ent : list) {
            boolean found = false;
            for (SillaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Test of update method, of class SillaPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        SillaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        SillaEntity newEntity = factory.manufacturePojo(SillaEntity.class);

        newEntity.setId(entity.getId());
        newEntity.setSala(entity.getSala());

        persistence.update(newEntity);

        SillaEntity resp = em.find(SillaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }

    /**
     * Test of delete method, of class SillaPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        SillaEntity entity = data.get(0);
        persistence.delete(entity.getId());
        SillaEntity deleted = em.find(SillaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
}
