/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.services;



import com.hibernate.entities.User;
import java.util.List;
import org.hibernate.SessionFactory;
import com.hibernate.config.HibernateConnectionManager;


/**
 * @author nadaa
 */

public class UserService {

    private final  SessionFactory  factory ;
    
 public UserService() {
        this.factory = HibernateConnectionManager.getSessionFactory();
    }
   
public  User addUser(User use) {
        com.hibernate.config.HibernateConnectionManager.beginTransaction();
        User u =  (User) factory.getCurrentSession().merge(use);
        HibernateConnectionManager.commitTransaction();
        return u;
    }  





public User updateUser(User use) {
        HibernateConnectionManager.beginTransaction();
        User u = (User) factory.getCurrentSession().merge(use);
        HibernateConnectionManager.commitTransaction();
        return u;
    }


   public void deleteUser(User use) {
        HibernateConnectionManager.beginTransaction();
        factory.getCurrentSession().delete(use);
        HibernateConnectionManager.commitTransaction();
    }
    
    public User findUse(int useId){
        HibernateConnectionManager.beginTransaction();
        User use = (User) factory.getCurrentSession().get(User.class, useId);
        HibernateConnectionManager.commitTransaction();
        return use;
    }
    
        public User findUserByEmail(String email){
        HibernateConnectionManager.beginTransaction();
        User use = (User) factory.getCurrentSession().get(User.class, email);
        HibernateConnectionManager.commitTransaction();
        return use;
    }


    public List<User> getAllUser()
    {
        com.hibernate.config.HibernateConnectionManager.beginTransaction();
        List u =  factory.getCurrentSession().createCriteria(User.class).list();
        HibernateConnectionManager.commitTransaction();
        return u;
    }

   
   
 
    public User findUseByName(String name) {
        return (User) factory.getCurrentSession().get(User.class,name );
    }  


  
    
    

}
