package pl.mpr.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import pl.mpr.db.*;
import pl.mpr.list.*;


public class HsqlDelikwentDao extends HsqlDaoBase<Delikwent> implements DelikwentDao{

        
        public HsqlDelikwentDao(HsqlUnitOfWork uow) {
                super(uow);
        }

        public void setId(Delikwent c) {
                
        }

        public void setName(Delikwent c) {
                
        }

        @Override
        protected void setUpdateQuery(Delikwent ent) throws SQLException {

                update.setString(1, ent.getName());
                update.setString(2, ent.getSurname());
                update.setInt(5, ent.getId());
                
        }

        @Override
        protected Delikwent build(ResultSet rs) throws SQLException {

                Delikwent c = new Delikwent();
                
                c.setName(rs.getString("name"));
                c.setSurname(rs.getString("surname"));
                
                c.setId(rs.getInt("id"));
                return c;
        }

        @Override
        protected void setInsertQuery(Delikwent ent) throws SQLException {
                insert.setString(1, ent.getName());
                insert.setString(2, ent.getSurname());
              
                
                
        }

        @Override
        protected String getTableName() {
                return "delikwent";
        }

        @Override
        protected String getCreateQuery() {
                return "CREATE TABLE Delikwent("
                                + "id INT (30),"
                                + "name VARCHAR(50),"
                                + "surname VARCHAR(50),"
                                + ")";
        }

        @Override
        protected String getInsertQuery() {
                return "insert into client(id,name,surname) values (?,?,?)";
        }

        @Override
        protected String getUpdateQuery() {
                return "update client set"
                                + "(id, name,surname)=(?,?,?)"
                                + "where id=?";
        }

		public void setAttack(Delikwent c) {
			// TODO Auto-generated method stub
			
		}

		public void setOrg(Delikwent c) {
			// TODO Auto-generated method stub
			
		}}