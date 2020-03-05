/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.services;


import com.hibernate.entities.TypeClient;
import java.util.List;
import org.hibernate.SessionFactory;
import com.hibernate.config.HibernateConnectionManager;
/**
 *
 * @author nadaa
 */
public class TypeClientService {
    
  
    private final  SessionFactory  factory ;
    
 public TypeClientService() {
        this.factory = HibernateConnectionManager.getSessionFactory();
    }
   
public  TypeClient addTypeClient(TypeClient typeClien) {
        HibernateConnectionManager.beginTransaction();
        TypeClient tc =  (TypeClient) factory.getCurrentSession().merge(typeClien);
        HibernateConnectionManager.commitTransaction();
        return tc;
    }  

public TypeClient UpdateTypeClient(TypeClient typeClien) {
        HibernateConnectionManager.beginTransaction();
         TypeClient tc = (TypeClient) factory.getCurrentSession().merge(typeClien);
        HibernateConnectionManager.commitTransaction();
        return tc;
    }


   public void delete(TypeClient typeClien) {
        HibernateConnectionManager.beginTransaction();
        factory.getCurrentSession().delete(typeClien);
        HibernateConnectionManager.commitTransaction();
    }
    
    public TypeClient findTypeClient(int typeClienId){
        HibernateConnectionManager.beginTransaction();
        TypeClient typeClien = (TypeClient) factory.getCurrentSession().get(TypeClient.class, typeClienId);
        HibernateConnectionManager.commitTransaction();
        return typeClien;
    }

    
    public List<TypeClient> getAllTypeClient()
    {
        HibernateConnectionManager.beginTransaction();
        List ltc =  factory.getCurrentSession().createCriteria(TypeClient.class).list();
        HibernateConnectionManager.commitTransaction();
        return ltc;
    }

   
 
    public TypeClient findTypeClientByName(String name) {
        return (TypeClient) factory.getCurrentSession().get(TypeClient.class,name );
    }  

    
}
