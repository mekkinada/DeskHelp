/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedBeans;

import com.hibernate.entities.TypeUser;
import com.hibernate.services.TypeUserService;
import com.hibernate.entities.User;
import com.hibernate.services.UserService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author nadaa
 */

@ManagedBean
@SessionScoped
public class TypeUserController {
    
    private TypeUserService service;
    private TypeUser typeUse;
    private TypeUser addedTypeUsee;
    private TypeUser updatedTypeUsee; 
    

    public TypeUserController ()
    {
           
    }

    @PostConstruct
    public void init() {
        service = new TypeUserService();
        addedTypeUsee = new TypeUser();
         typeUse = new TypeUser();
    }
  ////////    
    
      public TypeUser getAddedTypeUser() {
        return addedTypeUsee;
    }
 
    public void setaddedTypeUser (TypeUser addedTypeUsee)  {
        this.addedTypeUsee = addedTypeUsee ;
        
    }
     public TypeUser getTypeUser() {
        return typeUse ;
    }
    
    public void setTypeUser (TypeUser typeUse) {
        this.typeUse = typeUse;
       }
  
    
     public String addTypeUser() {
         service.addTypeUser(typeUse) ;
        return "register?faces-redirect=true";
    } 
   
   public List<TypeUser> showAllTypeUser() {
        return service.getAllTypeUser();
    }
   
   
    public void deleteTypeUser(TypeUser typeUse) {
        service.deleteTypeUser (typeUse) ;
    } 
        public String setTypeUserToUpdate(TypeUser typeUse) {
        this.updatedTypeUsee = typeUse;
       return "updateuser?faces-redirect=true";   
    }
        
    public TypeUser getUpdatedTypeUsee() {
        return updatedTypeUsee ;
               
    }

    public void setUpdatedTypeUsee(TypeUser updatedTypeUsee) { 
        this.updatedTypeUsee = updatedTypeUsee;
        
    }
 
 
 
   
 
  
       public String UpdateTypeUser() {
        service.updateTypeUser(updatedTypeUsee);
        return "affuser?faces-redirect=true";
    }
       
   

   public String affTypeUser()
    {
        return "affuser?faces-redirect=true";
    }
    
     public String Off() {
        return "index?faces-redirect=true";
    }
     
   
 
       public String backToTypeUser(){
        return "affuser?faces-redirect=true";
    }
        
      

}
