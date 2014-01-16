package pl.mpr.list;

//import java.util.*;

import pl.mpr.db.EntityBase;

public class Attack extends EntityBase {

 
    private int id;
    private String place;
    private String organisation;
    
    //public List<Delikwent> delikwent;
    //public List<Organisation> organizacja;

    public Attack () {

    }
    
    private Delikwent delikwent;
    
    public Delikwent getDelikwent(){
    	return delikwent;
 
    }
    
    public void setDelikwent (Delikwent delikwent){
    	this.delikwent=delikwent;
    }

    public Attack (int idIn) {

          this.id = idIn;

    }

    public int getId() {
          return this.id;
    }
    public void setId(int id) {
          this.id = id;
    }

    public String getPlace() {
          return this.place;
    }
    public void setPlace(String place) {
          this.place = place;
    }

    public String getOrganisation() {
          return this.organisation;
    }
    public void setOrganisation(String organisation) {
          this.organisation = organisation;
    }

    public void setAll(String place, String organisation, int id) {
          this.id = id;
          this.place = place;
          this.organisation = organisation;
    }
}