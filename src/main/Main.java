
import java.sql.Connection;
import java.sql.DriverManager;

import pl.mpr.list.Delikwent;

		//import org.example.db.HsqlUnitOfWork;
		//import org.example.db.dao.ClientDao;
		//import org.example.db.dao.HsqlClientDao;
		//import org.example.db.dao.HsqlProductDao;
		

		public class Main {

		        public static void main(String[] args) {
		                
		                
		                
		                     //   HsqlUnitOfWork uow = new HsqlUnitOfWork();
		                     //   ClientDao dao = new HsqlClientDao(uow);
		                        Delikwent c = new Delikwent();
		                        
		                        c.setEmail("a@wp.pl");
		                        c.setName("Jan");
		                        c.setSurname("Nowak");
		                        c.setNumber("1234");
		                        c.setId(0);
		                        
		                        Delikwent c1 = new Delikwent();
		                        c1.setId(0);
		                    //   dao.delete(c1);
		                     //   dao.save(c);
		                     //   uow.commit();
		                     //   uow.close();
		                System.out.println("koniec");
		        }

		}

	


