package pl.mpr.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.mpr.db.Dao;
import pl.mpr.db.DaoBase;
import pl.mpr.db.EntityBase;
import pl.mpr.db.HsqlUnitOfWork;
import pl.mpr.list.Organisation;

public class HsqlOrganisationDao extends DaoBase<Organisation> implements Dao<Organisation>{

    
    

	private Statement stmt;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement getById;
    private PreparedStatement getAll;
    
    
    public HsqlOrganisationDao(HsqlUnitOfWork uow)
    {
            super(uow);
            try {
                    Connection connection = uow.getConnection();
                    stmt = connection.createStatement();
                    
                    ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
                    
                    boolean exists = false;
                    while(rs.next())
                    {
                            if("Organisation".equalsIgnoreCase(rs.getString("TABLE_NAME")))
                            {
                                    exists = true;
                                    break;
                            }
                    }
                    
                    insert = connection.prepareStatement(""
                                    + "INSERT INTO Organisation(id_org, name_org, town)"
                                    + " VALUES(?,?,?)");
                    
                    getById = connection.prepareStatement(""
                                    + "SELECT * FROM Organisation WHERE id=?");
                    
                    delete = connection.prepareStatement("DELETE FROM Organisation WHERE id=?");
                    
                    getAll = connection.prepareStatement("SELECT * FROM Organisation");
                    
                    update = connection.prepareStatement(""
                                    + "update Organisation set"
                                    + "(id_org, name_org, town)=(?,?,?)"
                                    + "where id=?");
                    
                    if(!exists)
                    {
                            stmt.executeUpdate(""
                                            + "CREATE TABLE Organisation("
                                            + "id_org int"
                                            + "name_org varchar(50),"
                                            + "town varchar(50),"
                                            + ")");
                            
                    }
            } catch (SQLException e) {
                    e.printStackTrace();
            }
            
    }

    @Override
    public void persistAdd(EntityBase entity) {
            
            Organisation ent = (Organisation)entity;
            try {
                    insert.setInt(1, ent.getId());
                    insert.setString(2, ent.getName_org());
                    insert.setString(3, ent.getTown());
                    insert.executeUpdate();
                    
            } catch (SQLException e) {
                    e.printStackTrace();
            }
            
    }

    @Override
    public void persistDelete(EntityBase entity) {
            Organisation ent = (Organisation) entity;
            try
            {
                    delete.setInt(1, ent.getId());
                    delete.executeUpdate();

            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
    }

    @Override
    public List<Organisation> getAll() {
                    List<Organisation> delikwents = new ArrayList<Organisation>();
            
            try
            {
                    ResultSet rs = getAll.executeQuery();
                    while(rs.next()){
                            
                            Organisation p = new Organisation();
                            p.setId(rs.getInt("id"));
                            p.setName_org(rs.getString("name_org"));
                            p.setTown(rs.getString("town"));
                            
                            delikwents.add(p);
                    }
            }
            
            catch(Exception ex)
            {
                    ex.printStackTrace();
            }
            
            return delikwents;
    }

    @Override
    public Organisation get(int id) {
            Organisation p = null;
            try {
                    getById.setInt(1, id);
                    ResultSet rs = getById.executeQuery();
                    while(rs.next())
                    {
                            p = new Organisation();
                            p.setId(rs.getInt("id"));
                            p.setName_org(rs.getString("name_org"));
                            p.setTown(rs.getString("town"));
                    }
                    
            } catch (SQLException e) {
                    e.printStackTrace();
            }
            
            return p;
    }

    @Override
    public void persistUpdate(EntityBase entity) {
            Organisation ent = (Organisation) entity;
            try
            {
            		update.setInt(1, ent.getId());
            		update.setString(2, ent.getName_org());
            		update.setString(3, ent.getTown());
                    update.executeUpdate();
            }
            catch(Exception ex)
            {
                    ex.printStackTrace();
            }
            
    }


    
    
}