/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedBeans;


import com.hibernate.config.HibernateConnectionManager;
import com.hibernate.entities.Client;
 
////////
import com.hibernate.services.ClientService;
import com.hibernate.services.ClientDecbugService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;
/**
 *
 * @author nadaa
 */
@ManagedBean
@SessionScoped
public class ClientController{
  private Client clien ;
    private ClientService clientService;
    private ClientDecbugService clientInterventionService ;
    
 Client addedClien  ;
    
    private ClientService service;
    
    private Client updatedClien; 
    
      private String email1Used;
      
      private String idTypeClient;
      
    public ClientController() {
    }

    

    public Client getClien() {
        return clien;
    }

    public void setClien(Client clien) {
        this.clien = clien;
    }
    
 
        
      public String inscriptionClient()
    {
        return "registerClient?faces-redirect=true";
    }     
  
//////////   new 9/17

    
    @PostConstruct
    public void init() {
        service = new ClientService();
        
        addedClien = new Client();
        
        clien = new Client();
         
                        }

   
    
     public String addUser() {
         service.addClien(clien) ;
          return "authorize?faces-redirect=true";
    } 
     
       
     public String addRegisterClient() {
         service.addClien(clien) ;
         return "index?faces-redirect=true";
    } 
 
////////    
   public List<Client> showAllClient() {
       return service.getAllClient();
   }
   

   
    public void deleteClient(Client clien) {
        service.deleteClien(clien); ;
    } 
       
    
//////////////////////    
    public String setClienToUpdate(Client clien) {
        this.updatedClien = clien;
        return "updateclient?faces-redirect=true";   
    }
        
    public Client getUpdatedClien() {
        return updatedClien ;
   }

    public void setUpdatedClien(Client updatedClien) { 
        this.updatedClien = updatedClien;
        
        
    }

       public String updateClient() {
        service.updateClien(updatedClien);
  
        return "affClient?faces-redirect=true";
    }
       
////////////////////////////       
  
   
   
           public String findClien() {
        this.clien = service.findClien(clien.getIdClient());
              
        return "updateclient?faces-redirect=true";
    } 

   public String affClient()
    {
        return "affClient?faces-redirect=true";
    }
    
     public String Off() {
        return "index?faces-redirect=true";
    }

 
       public String backToClient(){
        return "authorize?faces-redirect=true";
    }

   
//////
 
////////    
     public Client getClient() {
        return clien;
    }
    
    public void setClient(Client clien) {
        this.clien = clien;
    }
//////////    
      public String getEmail1Used() {
        return this.email1Used;
    }
    
    public void setEmail1Used(String email1Used) {
        this.email1Used = email1Used;
    }
//    


     public String getIdTypeClient() {
        return this.idTypeClient;
    }
    
    public void setIdTypeClient(String idTypeClient) {
        this.idTypeClient = idTypeClient;
    }
//////   

        
}