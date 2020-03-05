package com.managedBeans;


import com.hibernate.entities.User;
import com.hibernate.services.UserService;

import com.hibernate.entities.TypeUser;
import com.hibernate.services.TypeUserService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;

/**
 *
 * @author nadaa
 */
@ManagedBean
@SessionScoped

public class UserController{
   //////    connx
    Connection connection;
    Statement statement;
    
////
    
    private String email1Used;
 
    
     private User user;

     private UserService service;

     private User use;
    
     private User addedUsee;
    
     private User updatedUse; 
     
     private TypeUser typeUser;
    

  ResultSet resultSet1;

   
    String SQL1;







    public UserController() {
    }
    
    @PostConstruct
    public void init() {
        service = new UserService();
        
        addedUsee = new User();
        
        use = new User();
         
                        }

   
    
     public String addUser() {
         service.addUser(use) ;
          return "authorize?faces-redirect=true";
    } 
     
       
     public String addRegisterUser() {
         service.addUser(use) ;
         return "index?faces-redirect=true";
    } 
 
////////    
   public List<User> showAllUser() {
       return service.getAllUser();
   }
   

   
    public void deleteUser(User use) {
        service.deleteUser (use) ;
    } 
       
    
//////////////////////    
    public String setUseToUpdate(User use) {
        this.updatedUse = use;
        return "updateuser?faces-redirect=true";   
    }
        
    public User getUpdatedUse() {
        return updatedUse ;
   }

    public void setUpdatedUse(User updatedUse) { 
        this.updatedUse = updatedUse;
        
        
    }

       public String updateUser() {
        service.updateUser(updatedUse);
  
        return "affUser?faces-redirect=true";
    }
       
////////////////////////////       
  
   
   
           public String findUse() {
        this.use = service.findUse(use.getIdUser());
        return "updateuser?faces-redirect=true";
    } 

   public String affUser()
    {
        return "affUser?faces-redirect=true";
    }
    
     public String Off() {
        return "index?faces-redirect=true";
    }

 
       public String backToUser(){
        return "authorize?faces-redirect=true";
    }

     public String inscriptionUser()
    {
        return "registerUser?faces-redirect=true";
    }    
//////
 
////////    
     public User getUse() {
        return use;
    }
    
    public void setUse(User use) {
        this.use = use;
    }
//////////    
       public String getEmail1Used() {
        return this.email1Used;
    }
    
    public void setEmail1Used(String email1Used) {
        this.email1Used = email1Used;
    }
//    


            
            
             public TypeUser getTypeUser() {
        return this.typeUser;
    }
    
    public void setTypeUser(TypeUser typeUser) {
  
        this.typeUser = typeUser;
    }
//////   
}