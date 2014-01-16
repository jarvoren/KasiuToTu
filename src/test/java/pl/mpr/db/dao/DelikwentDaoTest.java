package pl.mpr.db.dao;



import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pl.mpr.db.HsqlUnitOfWork;
import pl.mpr.list.Delikwent;

public class DelikwentDaoTest {

        DelikwentDao dao;

        Connection connection = null;
        private Statement drop;
        
        @BeforeClass
        public static void initialize()
        {}
        
        @Before
        public void setUp()
        {

                Delikwent c = new Delikwent();
                
                c.setName("Jan");
                c.setSurname("Nowak");
                
                try {

                        HsqlUnitOfWork uow = new HsqlUnitOfWork();
                        dao = new HsqlDelikwentDao(uow);
                        dao.save(c);
                        uow.commit();
                        drop = uow.getConnection().createStatement();
                        
                } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                
        }
        
        @After
        public void teardown()
        {
                try{
                        if(connection!=null && !connection.isClosed())
                        {        
                                drop.executeUpdate("Drop table Client");
                                connection.close();
                                connection = null;
                        }}
                        catch(Exception ex)
                        {
                                ex.printStackTrace();
                        }
        }
        
        @Test
        public void testGet() {
                
                Delikwent c1 = dao.get(0);
                Delikwent c2 = dao.get(2);
                Delikwent c3 = dao.get(0);
                
                assertNotNull("Zwrócono null mimo ze obiekt jest w bazie",c1);
                assertNull("zwrócono wartosc mimo, że nie ma takiego obiektu w bazie",c2);
                
                
                assertEquals(c1.getName(),"Jan");
                assertEquals(c1.getSurname(), "Nowak");
                
                
                assertNotSame(c1,c3);
                
        }

}

