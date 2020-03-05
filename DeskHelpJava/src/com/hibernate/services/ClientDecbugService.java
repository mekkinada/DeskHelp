/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.services;


import com.hibernate.config.HibernateConnectionManager;

import com.hibernate.entities.Client;
import com.hibernate.entities.ClientDecbug;
import com.hibernate.entities.Decbug;
//////// 
////////

import com.exceptions.ObjectIsAleadyExist;




import java.util.ArrayList;

import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author nadaa
 */

public class ClientDecbugService {

SessionFactory sessionFactory;




    public ClientDecbugService() {
        this.sessionFactory = HibernateConnectionManager.getSessionFactory();
    }

    

//////// 
public ClientDecbug addClientDecbug (  Decbug bug ,Client clien)
                           
{
   
        HibernateConnectionManager.beginTransaction();
        
 
 
    
        ClientDecbug  cd = new  ClientDecbug ( clien , bug ) ;
                
             
        ClientDecbug clientDecbug = (ClientDecbug) this.sessionFactory.getCurrentSession().merge(cd);
        HibernateConnectionManager.commitTransaction();
        return clientDecbug;
    }
    
//////
 
    public ClientDecbug getClientDecbug(int idClientDecbug){
    return (ClientDecbug) this.sessionFactory.getCurrentSession().get(ClientDecbug.class,idClientDecbug);
    }
    
    public List getAllClientDecbug()
    {
        return this.sessionFactory.getCurrentSession().createCriteria(ClientDecbug.class).list();
    }
    
                        
    public List <Client> getDecbugByClien(Decbug bug )
    {
        HibernateConnectionManager.beginTransaction();
        
        List<ClientDecbug> clientDecbugList = this.getAllClientDecbug();
        
      
        ArrayList<Client> returnedClient = new ArrayList<Client>();
        

        for (ClientDecbug clientDecbug : clientDecbugList){
            if 
                    
                (clientDecbug.getDecbug().equals(clientDecbug.getDecbug()))
                        
            
                         {
                returnedClient.add(clientDecbug.getClient());
            } 
        }
        
        HibernateConnectionManager.commitTransaction();
        return returnedClient; 
    }

 


} 

