/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedBeans;


import com.hibernate.entities.Ticket;
import com.hibernate.services.TicketService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;




/**
 *
 * @author nadaa
 */

@ManagedBean
@SessionScoped
public class TicketController {



    private TicketService service;
    private Ticket ticke;
    private Ticket addedTickee;
    private Ticket updatedTickee; 
   
    private Boolean activeTicket;

    public TicketController() {
           
    }

    @PostConstruct
    public void init() {
        service = new TicketService();
        addedTickee = new Ticket();
         ticke = new Ticket();
    }
  ////////    
    
   
    
     public String addTicket() {
         service.addTicket(ticke) ;
        return "affTicket?faces-redirect=true";
    } 
   
   public List<Ticket> showAllTicket() {
        return service.getAllTicket();
    }
   
          public String findTicke() {
        this.ticke = service.findTicket(ticke.getIdTicket());
        return "updateticket?faces-redirect=true";
    }
 
    public void deleteTicket(Ticket ticke) {
        service.deleteTicket (ticke) ;
    }
    
    ////////////////   Updated
    
        public String setTicketToUpdate(Ticket ticke) {
        this.updatedTickee = ticke;
       return "updateticket?faces-redirect=true";   
    }
         
////////   validation
           public String setTicketTovalide(Ticket ticke) {
        this.updatedTickee = ticke;
       return "validationTicket?faces-redirect=true";   
    }
           
           
           
    public Ticket getUpdatedTickee() {
        return updatedTickee ;
               
    }

    public void setUpdatedTickee(Ticket updatedTickee) { 
        this.updatedTickee = updatedTickee;
        
    }
             
        public String updateTicket()
    {
        service.updateTicket(updatedTickee);
        return "affTicket?faces-redirect=true";
    }   

//////     
        
   public String affTicket()
    {
        return "affticket?faces-redirect=true";
    }
    
     public String off() {
        return "index?faces-redirect=true";
    }
     
    
       public String backToTicket(){
        return "affticket?faces-redirect=true";
    }

      public Ticket getAddedTickee() {
        return addedTickee;
    }
 
    public void setaddedTickee (Ticket addedTickee)  {
        this.addedTickee = addedTickee ;
        
    }
     public Ticket getTicke() {
        return ticke;
    }
    
    public void setTicke(Ticket ticke) {
        this.ticke = ticke;
       }
       
}
