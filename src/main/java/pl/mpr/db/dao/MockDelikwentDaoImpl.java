package pl.mpr.db.dao;

import java.util.ArrayList;
import java.util.List;

import pl.mpr.db.*;
import pl.mpr.list.*;

public class MockDelikwentDaoImpl implements DelikwentDao{

        private MockDb db;
        
        
        
        public MockDelikwentDaoImpl(MockDb db) {
        
                this.db = db;
        }

        public void save(Delikwent ent) {
                db.save(ent);
                
        }

        public void delete(Delikwent ent) {
                db.getItems().remove(ent);
                
        }

        public List<Delikwent> getAll() {
                List<Delikwent> result = new ArrayList<Delikwent>();
                for(EntityBase ent: db.getItems())
                {
                        if(ent instanceof Delikwent)
                                result.add((Delikwent)ent);
                }
                
                return result;
        }

        public Delikwent get(int id) {
                for(Delikwent c: getAll())
                {
                        if(c.getId()==id)
                        {
                                Delikwent c1 = new Delikwent();
                                c1.setId(c.getId());
                                c1.setSurname(c.getSurname());
                                c1.setName(c.getName());
                                return c1;
                        }
                }
                return null;
        }

        public void setAttack(Delikwent c) {
			// TODO Auto-generated method stub
			
		}

		public void setOrg(Delikwent c) {
			// TODO Auto-generated method stub
			
		}

        public void update(Delikwent ent) {
               
                
        }

		

}