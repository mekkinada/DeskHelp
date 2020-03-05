/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.services;
import com.hibernate.entities.TypeUser;
import java.util.List;
import org.hibernate.SessionFactory;
import com.hibernate.config.HibernateConnectionManager;

/**
 *
 * @author nadaa
 */
public class TypeUserService {
    
    
     private final  SessionFactory  factory ;
    
 public TypeUserService() {
        this.factory = HibernateConnectionManager.getSessionFactory();
    }
   
public  TypeUser addTypeUser(TypeUser typeUser) {
        HibernateConnectionManager.beginTransaction();
        TypeUser tu =  (TypeUser) factory.getCurrentSession().merge(typeUser);
        HibernateConnectionManager.commitTransaction();
        return tu;
    }  

public TypeUser updateTypeUser(TypeUser typeUse) {
        HibernateConnectionManager.beginTransaction();
        TypeUser tu = (TypeUser) factory.getCurrentSession().merge(typeUse);
        HibernateConnectionManager.commitTransaction();
        return tu;
    }


   public void deleteTypeUser(TypeUser typeUse) {
        HibernateConnectionManager.beginTransaction();
        factory.getCurrentSession().delete(typeUse);
        HibernateConnectionManager.commitTransaction();
    }
    
    public TypeUser findTypeUser(int typeUseId){
        HibernateConnectionManager.beginTransaction();
        TypeUser ticke = (TypeUser) factory.getCurrentSession().get(TypeUser.class, typeUseId);
        HibernateConnectionManager.commitTransaction();
        return ticke;
    }

    
    public List<TypeUser> getAllTypeUser()
    {
        HibernateConnectionManager.beginTransaction();
        List ltu =  factory.getCurrentSession().createCriteria(TypeUser.class).list();
        HibernateConnectionManager.commitTransaction();
        return ltu;
    }

   
 
    public TypeUser findTypeUserByName(String name) {
        return (TypeUser) factory.getCurrentSession().get(TypeUser.class,name );
    }  


}
