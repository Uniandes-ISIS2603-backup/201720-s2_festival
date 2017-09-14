/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.persistence;

import co.edu.uniandes.ergo.festival.entities.FestivalEntity;
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
public class FestivalPersistenceTest
{
   /**
     * Inyección de la dependencia a la clase FestivalPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private FestivalPersistence persistence;
    
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
    private List<FestivalEntity> data = new ArrayList<FestivalEntity>();
    
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
        em.createQuery("Delete from TeatroPersistence").executeUpdate();
    }
    private void insertData()
    {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++)
        {
            FestivalEntity entity = factory.manufacturePojo(FestivalEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
    }
    public FestivalPersistenceTest() {
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

    /**
     * Test of create method, of class FestivalPersistence.
     */
    @Test
    public void testCreate() throws Exception 
    {
        PodamFactory factory = new PodamFactoryImpl();
        FestivalEntity newEntity = factory.manufacturePojo(FestivalEntity.class);
        FestivalEntity result = persistence.create(newEntity);
        
        Assert.assertNotNull(result);
        FestivalEntity entity = em.find(FestivalEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertNotEquals(newEntity.getNombre(), entity.getNombre());
    }
 @Deployment
   public static JavaArchive createDeployment()
   {   
          return ShrinkWrap.create(JavaArchive.class)
            .addPackage(FestivalEntity.class.getPackage())
            .addPackage(FestivalPersistence.class.getPackage())
            .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
            .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
   
    /**
     * Test of update method, of class FestivalPersistence.
     */
    @Test
    public void testUpdate() throws Exception 
    {
        FestivalEntity entity = data.get(0);
     PodamFactory factory = new PodamFactoryImpl();
     FestivalEntity newEntity = factory.manufacturePojo(FestivalEntity.class);
     
     newEntity.setId(entity.getId());
     
     persistence.update(newEntity);
     
     FestivalEntity res = em.find(FestivalEntity.class, entity.getId());
     Assert.assertNotEquals(newEntity.getNombre(), res.getNombre());
    } 

    /**
     * Test of delete method, of class FestivalPersistence.
     */
    @Test
    public void testDelete() throws Exception
    {
       FestivalEntity entity = data.get(0);
       persistence.delete(entity.getId());
        FestivalEntity deleted = em.find(FestivalEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class FestivalPersistence.
     */
    @Test
    public void testFind() throws Exception 
    {
        FestivalEntity entity = data.get(0);
        FestivalEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
    }

    /**
     * Test of findAll method, of class FestivalPersistence.
     */
    @Test
    public void testFindAll() throws Exception 
    {
        List<FestivalEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for(FestivalEntity ent : list)
        {
            boolean found = false;
            for(FestivalEntity entity : data)
            {
                if(ent.getId().equals(entity.getId()))
                {
                    found =  true;
                }
            }
            Assert.assertTrue(found);
        }
    } 
    
}
