package pl.mpr.db.dao;

import java.util.List;

import pl.mpr.db.*;
import pl.mpr.list.Attack;

public interface OrganisationDao extends Dao<Attack> {

        public List<Attack> getAttackByDelikwentId(int id);
}
