/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;

import co.edu.uniandes.ergo.festival.entities.CriticaEntity;
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
public class CriticaPersistenceTest {
    
    /**
     * Inyección de la dependencia a la clase CríticaPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private CriticaPersistence persistence;

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
    private List<CriticaEntity> data = new ArrayList<CriticaEntity>();
    
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Crítica, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CriticaEntity.class.getPackage())
                .addPackage(CriticaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public CriticaPersistenceTest() {
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
        em.createQuery("delete from CriticaEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            CriticaEntity entity = factory.manufacturePojo(CriticaEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Test of create method, of class CríticaPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        CriticaEntity newEntity = factory.manufacturePojo(CriticaEntity.class);
        CriticaEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        CriticaEntity entity = em.find(CriticaEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Test of find method, of class CríticaPersistence.
     */
    @Test
    public void testFind() throws Exception {
        CriticaEntity entity = data.get(0);
        CriticaEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * Test of findAll method, of class CríticaPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<CriticaEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (CriticaEntity ent : list) {
            boolean found = false;
            for (CriticaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Test of update method, of class CríticaPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        CriticaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CriticaEntity newEntity = factory.manufacturePojo(CriticaEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        CriticaEntity resp = em.find(CriticaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }

    /**
     * Test of delete method, of class CríticaPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        CriticaEntity entity = data.get(0);
        persistence.delete(entity.getId());
        CriticaEntity deleted = em.find(CriticaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
}
