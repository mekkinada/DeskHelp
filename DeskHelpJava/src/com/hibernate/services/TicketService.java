/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.services;



import com.hibernate.entities.Ticket;
import java.util.List;
import org.hibernate.SessionFactory;
import com.hibernate.config.HibernateConnectionManager;


/**
 * @author nadaa
 */

public class TicketService {
    
    
    private final  SessionFactory  factory ;
    
 public TicketService() {
        this.factory = HibernateConnectionManager.getSessionFactory();
    }
   
public  Ticket addTicket(Ticket ticke) {
        HibernateConnectionManager.beginTransaction();
        Ticket t =  (Ticket) factory.getCurrentSession().merge(ticke);
        HibernateConnectionManager.commitTransaction();
        return t;
    }  

public Ticket updateTicket(Ticket ticke) {
        HibernateConnectionManager.beginTransaction();
        Ticket t = (Ticket) factory.getCurrentSession().merge(ticke);
        HibernateConnectionManager.commitTransaction();
        return t;
    }



   public void deleteTicket(Ticket ticke) {
        HibernateConnectionManager.beginTransaction();
        factory.getCurrentSession().delete(ticke);
        HibernateConnectionManager.commitTransaction();
    }
    
    public Ticket findTicket(int tickeId){
        HibernateConnectionManager.beginTransaction();
        Ticket ticke = (Ticket) factory.getCurrentSession().get(Ticket.class, tickeId);
        HibernateConnectionManager.commitTransaction();
        return ticke;
    }

    
    public List<Ticket> getAllTicket()
    {
        HibernateConnectionManager.beginTransaction();
        List lt =  factory.getCurrentSession().createCriteria(Ticket.class).list();
        HibernateConnectionManager.commitTransaction();
        return lt;
    }

   
 
    public Ticket findTicketByName(String name) {
        return (Ticket) factory.getCurrentSession().get(Ticket.class,name );
    }  

}
