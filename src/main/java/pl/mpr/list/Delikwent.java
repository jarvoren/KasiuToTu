package pl.mpr.list;

import java.util.*;

import pl.mpr.db.EntityBase;

public class Delikwent extends EntityBase {

    private int id;
    private String name;
    private String surname;

    public Delikwent () {
    }
    public List<Attack> attack;
    public List<Organisation> organizacja;
    
    public Delikwent (int idIn) {

          this.id = idIn;
    }
    
    public List<Organisation> getOrg() {
    	return organizacja;
    }
    public void setOrg(List<Organisation> organizacja) {
        this.organizacja = organizacja;
    }
    public List<Attack> getAttack() {
		return attack;
    }
    public void setAttack(List<Attack> attack) {
        this.attack = attack;
    }
    
    public int getId() {
          return id;
    }
    
    public void setId(int id) {
          this.id = id;
    }

    public String getName() {
          return this.name;
    }
    
    public void setName(String name) {
          this.name = name;
    }

    public String getSurname() {
          return this.surname;
    }
    
    public void setSurname(String surname) {
          this.surname = surname;
    }


    public void setAll(int id, String name, String surname) {
          this.id = id;
          this.name = name;
          this.surname = surname;
    }
}
