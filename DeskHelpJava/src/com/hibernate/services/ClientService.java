package com.hibernate.services;


import com.hibernate.config.HibernateConnectionManager;
import com.hibernate.entities.Client;
import java.util.List;
import org.hibernate.SessionFactory;
/**
 *
 * @author nadaa
 */

public class  ClientService {
    
    private SessionFactory factory;

    public ClientService() {
        this.factory = HibernateConnectionManager.getSessionFactory();
    }
////////// +use
    public Client addClien(Client clien) {
        HibernateConnectionManager.beginTransaction();
        Client c =  (Client) factory.getCurrentSession().merge(clien);
        HibernateConnectionManager.commitTransaction();
////       
        return c;
    }
    
    public void deleteClien(Client clien){
        HibernateConnectionManager.beginTransaction();
        factory.getCurrentSession().delete(clien);
        HibernateConnectionManager.commitTransaction();
    }
    
    public Client findClien(int clienId){
    return (Client) factory.getCurrentSession().get(Client.class, clienId);
 }
    
//  public List<Client> getAllClient(){
//    return factory.getCurrentSession().createCriteria(Client.class).list();
//
//    }
    
      public List<Client> getAllClient()
    {
        com.hibernate.config.HibernateConnectionManager.beginTransaction();
        List client =  factory.getCurrentSession().createCriteria(Client.class).list();
        HibernateConnectionManager.commitTransaction();
        return client ;
    }

    public Client updateClien(Client clien){
        HibernateConnectionManager.beginTransaction();
         Client c = (Client) factory.getCurrentSession().merge(clien);
         HibernateConnectionManager.commitTransaction();
         return c;
    }
    
    public Client findClienByName(String name)
    {
        return (Client) factory.getCurrentSession().get(Client.class, name);
    }    
  
    }
