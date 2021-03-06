package com.hibernate.entities;



import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private int idUser;
     private String idTypeUser;
     private String pwdUser;
     private String nameUsedAr;
     private String firstNameUsedAr;
     private Integer telfUsedPers;
     private String sexUsed;
     private String email1Used;
     private String address1Used;
     private Set decbugs = new HashSet(0);

    public User() {
    }

	
    public User(int idUser) {
        this.idUser = idUser;
    }
    public User(int idUser, String idTypeUser, String pwdUser, String nameUsedAr, String firstNameUsedAr, Integer telfUsedPers, String sexUsed, String email1Used, String address1Used, Set decbugs) {
       this.idUser = idUser;
       this.idTypeUser = idTypeUser;
       this.pwdUser = pwdUser;
       this.nameUsedAr = nameUsedAr;
       this.firstNameUsedAr = firstNameUsedAr;
       this.telfUsedPers = telfUsedPers;
       this.sexUsed = sexUsed;
       this.email1Used = email1Used;
       this.address1Used = address1Used;
       this.decbugs = decbugs;
    }
   
    public int getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public String getIdTypeUser() {
        return this.idTypeUser;
    }
    
    public void setIdTypeUser(String idTypeUser) {
        this.idTypeUser = idTypeUser;
    }
    public String getPwdUser() {
        return this.pwdUser;
    }
    
    public void setPwdUser(String pwdUser) {
        this.pwdUser = pwdUser;
    }
    public String getNameUsedAr() {
        return this.nameUsedAr;
    }
    
    public void setNameUsedAr(String nameUsedAr) {
        this.nameUsedAr = nameUsedAr;
    }
    public String getFirstNameUsedAr() {
        return this.firstNameUsedAr;
    }
    
    public void setFirstNameUsedAr(String firstNameUsedAr) {
        this.firstNameUsedAr = firstNameUsedAr;
    }
    public Integer getTelfUsedPers() {
        return this.telfUsedPers;
    }
    
    public void setTelfUsedPers(Integer telfUsedPers) {
        this.telfUsedPers = telfUsedPers;
    }
    public String getSexUsed() {
        return this.sexUsed;
    }
    
    public void setSexUsed(String sexUsed) {
        this.sexUsed = sexUsed;
    }
    public String getEmail1Used() {
        return this.email1Used;
    }
    
    public void setEmail1Used(String email1Used) {
        this.email1Used = email1Used;
    }
    public String getAddress1Used() {
        return this.address1Used;
    }
    
    public void setAddress1Used(String address1Used) {
        this.address1Used = address1Used;
    }
    public Set getDecbugs() {
        return this.decbugs;
    }
    
    public void setDecbugs(Set decbugs) {
        this.decbugs = decbugs;
    }




}


