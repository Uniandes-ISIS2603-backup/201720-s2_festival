/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;

import co.edu.uniandes.ergo.festival.entities.TeatroEntity;
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
 * @author de.gutierrez
 */
@RunWith(Arquillian.class)
public class TeatroPersistenceTest {
 
    /**
     * Inyección de la dependencia a la clase TeatroPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private TeatroPersistence persistence;
    
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
    private List<TeatroEntity> data = new ArrayList<TeatroEntity>();
    
    @Before
    public void setUp()
    {
        try
        {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            try{
                utx.rollback();
            }
            catch(Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    private void clearData()
    {
        em.createQuery("Delete from TeatroEntity").executeUpdate();
    }
    private void insertData()
    {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++)
        {
            TeatroEntity entity = factory.manufacturePojo(TeatroEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
    }
      @Deployment
   public static JavaArchive createDeployment()
   {   
          return ShrinkWrap.create(JavaArchive.class)
            .addPackage(TeatroEntity.class.getPackage())
            .addPackage(TeatroPersistence.class.getPackage())
            .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
            .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
   
  
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @After
    public void tearDown() {
    }

  @Test
    public void testCreate() throws Exception
    {
        PodamFactory factory = new PodamFactoryImpl();
        TeatroEntity newEntity = factory.manufacturePojo(TeatroEntity.class);
        TeatroEntity result = persistence.create(newEntity);
        
        Assert.assertNotNull(result);
        TeatroEntity entity = em.find(TeatroEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    /**
     * Test of find method, of class TeatroPersistence.
     */
    @Test
    public void testFind() throws Exception {
        TeatroEntity entity = data.get(0);
        TeatroEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * Test of findAll method, of class TeatroPersistence.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindAll() throws Exception 
    {
         List<TeatroEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for(TeatroEntity ent : list)
        {
            boolean found = false;
            for(TeatroEntity entity : data)
            {
                if(ent.getId().equals(entity.getId()))
                {
                    found =  true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Test of update method, of class TeatroPersistence.
     */
    @Test
    public void testUpdate() throws Exception
    {
     TeatroEntity entity = data.get(0);
     PodamFactory factory = new PodamFactoryImpl();
     TeatroEntity newEntity = factory.manufacturePojo(TeatroEntity.class);
     
     newEntity.setId(entity.getId());
     
     persistence.update(newEntity);
     
     TeatroEntity res = em.find(TeatroEntity.class, entity.getId());
     Assert.assertEquals(newEntity.getName(), res.getName());
    }

    /**
     * Test of delete method, of class TeatroPersistence.
     */
    @Test
    public void testDelete() throws Exception
    {
       TeatroEntity entity = data.get(0);
       persistence.delete(entity.getId());
        TeatroEntity deleted = em.find(TeatroEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
}
