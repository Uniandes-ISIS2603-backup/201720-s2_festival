/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;

import co.edu.uniandes.ergo.festival.entities.CriticaEntity;
import co.edu.uniandes.ergo.festival.entities.FuncionEntity;
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
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author m.neira10
 */
@RunWith(Arquillian.class)
public class FuncionPersistenceTest {
    @Inject
    private FuncionPersistence persistence;
    
    @PersistenceContext
    private EntityManager em;
    @Inject
    UserTransaction utx;
    
    private List<FuncionEntity> data = new ArrayList<>();
    
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(FuncionEntity.class.getPackage())
                .addPackage(FuncionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    public FuncionPersistenceTest() {
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

    
    private void clearData() {
        em.createQuery("delete from FuncionEntity").executeUpdate();
    }
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            FuncionEntity entity = factory.manufacturePojo(FuncionEntity.class);
            
            
            
            
            em.persist(entity);
            data.add(entity);
            
        }
    }
    @After
    public void tearDown() {
    }
    
    @Test 
    public void testCreate() throws Exception{
        PodamFactory factory = new PodamFactoryImpl();
        FuncionEntity newEntity = factory.manufacturePojo(FuncionEntity.class);
        FuncionEntity result = persistence.create(newEntity);
        
        Assert.assertNotNull(result);
        FuncionEntity entity = em.find(FuncionEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    @Test
    public void testFind() throws Exception{
        FuncionEntity entity = data.get(0);
        FuncionEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }
    
    

     @Test
    public void testFindAll() throws Exception {
        List<FuncionEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (FuncionEntity ent : list) {
            boolean found = false;
            for (FuncionEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void testUpdate() throws Exception {
        FuncionEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        FuncionEntity newEntity = factory.manufacturePojo(FuncionEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        FuncionEntity resp = em.find(FuncionEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }
    
    @Test
    public void testDelete() throws Exception {
        FuncionEntity entity = data.get(0);
        persistence.delete(entity.getId());
        FuncionEntity deleted = em.find(FuncionEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
}
