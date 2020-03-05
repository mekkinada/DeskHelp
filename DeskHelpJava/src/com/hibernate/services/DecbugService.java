/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.services;


import com.hibernate.config.HibernateConnectionManager;
import com.hibernate.entities.Decbug;

import java.util.List;
import org.hibernate.SessionFactory;

////////

public class DecbugService {

    private final SessionFactory factory;

    public DecbugService() {
        this.factory = HibernateConnectionManager.getSessionFactory();
    }

    public  Decbug addBug(Decbug  bug) {
            
        HibernateConnectionManager.beginTransaction();
        Decbug addd = (Decbug) factory.getCurrentSession().merge(bug);
        HibernateConnectionManager.commitTransaction();
        return addd;
    }
    
   
  

    public void deleteBug(Decbug bug) {
        HibernateConnectionManager.beginTransaction();
        factory.getCurrentSession().delete(bug);
        HibernateConnectionManager.commitTransaction();
    }

  public Decbug findBug(int bugId){
        HibernateConnectionManager.beginTransaction();
        Decbug bug = (Decbug) factory.getCurrentSession().get(Decbug.class, bugId);
        HibernateConnectionManager.commitTransaction();
        return bug;
    }
    
    public List<Decbug> getAllDecbug()
    {
        HibernateConnectionManager.beginTransaction();
        List li =  factory.getCurrentSession().createCriteria(Decbug.class).list();
        HibernateConnectionManager.commitTransaction();
        return li;
    }

    public Decbug updateDecBug(Decbug bug) {
        HibernateConnectionManager.beginTransaction();
        Decbug uBug = (Decbug) factory.getCurrentSession().merge(bug);
        HibernateConnectionManager.commitTransaction();
        return uBug;
    }

    public Decbug findBugByName(String name) {
        return (Decbug) factory.getCurrentSession().get(Decbug.class, name);
    }


}
 