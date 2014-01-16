package pl.mpr.list;

import java.util.*;

import pl.mpr.db.EntityBase;

public class Organisation extends EntityBase {

  
    private int id_org;
    private String name_org;
    private String town;
    
    public List<Attack> attack;
    

    public Organisation () {

    }

    public Organisation (int id_orgIn) {

          this.id_org = id_orgIn;

    }
    public List<Attack> getAttack() {
		return attack;
    }
    public void setAttack(List<Attack> attack) {
        this.attack = attack;
    }

    public int getId_org() {
          return this.id_org;
    }
    public void setId_org(int id_org) {
          this.id_org = id_org;
    }

    public String getName_org() {
          return this.name_org;
    }
    public void setName_org(String name_org) {
          this.name_org = name_org;
    }


    public String getTown() {
          return this.town;
    }
    public void setTown(String town) {
          this.town = town;
    }

    public void setAll(int id_org,
          String name_org,
          String town) {
          this.id_org = id_org;
          this.name_org = name_org;
          this.town = town;
    }    
}