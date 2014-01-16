package pl.mpr.db.dao;



import pl.mpr.db.*;
import pl.mpr.list.*;

public interface DelikwentDao extends Dao<Delikwent>{
        
        public void setAttack(Delikwent c);
        public void setOrg(Delikwent c);
}

