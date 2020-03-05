/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedBeans;

import com.hibernate.entities.Decbug;
import com.hibernate.entities.Client;
import com.hibernate.entities.ClientDecbug;

////////////
import com.hibernate.services.ClientDecbugService;
import com.hibernate.services.DecbugService;
import com.hibernate.services.ClientService;

////////
import com.exceptions.ObjectIsAleadyExist;
import com.hibernate.config.HibernateConnectionManager;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;

import javax.faces.bean.SessionScoped;

/**
 *
 * @author nadaa
 */
@ManagedBean
@SessionScoped
public class DecbugController{
    
    
    private DecbugService service;
    private Decbug bug;
    private Decbug addedBugg;
    
    private int bugidDecbug ;
    
    private Decbug updatedBug;

 

    private Date datedebut;
    private Date datefin;
    private String activeDecbug;
    private String rqActiveDecbug;
    private String titre;
    private String description;


////////  
    private Client clien ;
    private ClientService clientService;
    private ClientDecbugService clientDecbugService ;
    private Client updatedClien;
    
////////    aff client
       public List<Client> showAllClient() {
       return clientService.getAllClient();
   }
  
   

////////
    public String setClienToUpdate(Client clien) {
        this.updatedClien = clien;
        
        return "updateclient?faces-redirect=true";
    }     
   
    public Client getUpdatedClien() {
        return updatedClien;
    }
     
    
            
//////////////
     public int getBugidDecbug() {
        return bugidDecbug;
    }

 public void setUpdatedClien(Client updatedClien) { 
        this.updatedClien = updatedClien;
        
    }

 public String updateCLient() {
        clientService.updateClien(updatedClien) ;
        return "affClient?faces-redirect=true";
    }
       
     public String findClien() {
        this.clien = clientService.findClien(clien.getIdClient());
        return "updateclient?faces-redirect=true";
    } 
//////////////////////////////////////////////////////////////////  

    public String setBug(Decbug d) {
       
        this.bug = d;
        
        this.bugidDecbug = d.getIdDecbug();
      
       this.datedebut = bug.getDatedebut();
       this.datefin = bug.getDatefin();
       this.titre = bug.getTitre();
       this.description = bug.getDescription();
       this.activeDecbug= bug.getActiveDecbug();
       this.rqActiveDecbug= bug.getActiveDecbug();
                    
       return "affBug?faces-redirect=true";
              
    }
   
 public DecbugController() {
    }

    @PostConstruct
    public void init() {
        clien = new Client();
        clientService = new ClientService();
        service = new DecbugService();
        addedBugg = new Decbug();
        clientDecbugService = new ClientDecbugService();
    }

    public Client getClien() {
        return clien;
    }

    public void setClien(Client clien) {
        this.clien = clien;
    }

    public Decbug getAddedBugg() {
        return addedBugg;
    }

    public void setAddedBugg(Decbug addedBugg) {
        this.addedBugg = addedBugg;
    }

    public List<Decbug> showAllIDecbug() {
        return service.getAllDecbug();
    }
////////   
     
  
    

////////    
   

    public Decbug getBug() {
        return bug;
    }

    public void deleteBug(Decbug bug) {
        service.deleteBug(bug);
    }

    public String addBug() {
        service.addBug(addedBugg);
        return "affBug?faces-redirect=true";
    }         

   
    public String findBug() {
        this.bug = service.findBug(bug.getIdDecbug());
        return "updatebug?faces-redirect=true";
    }

    public Decbug  getUpdatedBug() {
        return updatedBug ;
    }

    public void setUpdatedBug(Decbug updatedBug) {
        this.updatedBug = updatedBug;
    }

    public String updateDecBug() {
        service.updateDecBug(updatedBug);
        return "affBug?faces-redirect=true";
    }
//////////
    
    public String addClien() {

        Client c = clientService.addClien(clien);

        clientDecbugService.addClientDecbug( bug ,clien);

     
       return "authorize?faces-redirect=true";
    }  
    
////////////    
        public String addRegisterClien() {

        Client c = clientService.addClien(clien);

        clientDecbugService.addClientDecbug( bug ,clien);

        return "index?faces-redirect=true";
    }
////////        

    public String deleteClien(Client c) {
        clientService.deleteClien(c);
        return "affClient?faces-redirect=true";
    }        

     public List<Client> getClientInBug(){
       return clientDecbugService.getDecbugByClien(bug);
   }
      

      
////////////////////////////////////////////////////////////////////////////////    
   
    
    public String setBugToUpdate(Decbug  bug) {
        this.updatedBug =bug;

        return "updatebug?faces-redirect=true";
    }
  
         
    
     public String setBugToValid(Decbug  bug) {
        this.updatedBug =bug;

        return "validationDecbug?faces-redirect=true";
    }
   
    public String logOff() {
        return "authorize?faces-redirect=true";
    }
   
    
     
       public String backToDecbug(){
        return "affUser?faces-redirect=true";
    }
       
     
    public Date getDatedebut() {
        return this.datedebut;
    }
    
    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }
    public Date getDatefin() {
        return this.datefin;
    }
    
    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }
   

  public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
       
    public String getActiveDecbug() {
        return this.activeDecbug;
    }
    
    public void setActiveDecbug(String activeDecbug) {
        this.activeDecbug = activeDecbug;
    }
    
    public String getRqActiveDecbug() {
        return this.rqActiveDecbug;
    }
    
    public void setRqActiveDecbug(String rqActiveDecbug) {
        this.rqActiveDecbug = rqActiveDecbug;
    }
   
}
