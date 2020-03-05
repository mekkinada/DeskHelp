/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedBeans;

import com.hibernate.entities.Client;
import com.hibernate.entities.ClientDecbug;
import com.hibernate.entities.Decbug;
////////////////
import com.hibernate.services.ClientDecbugService;
import com.hibernate.services.DecbugService;
import com.hibernate.services.ClientService;


////////
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty ;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author nadaa
 */
@ManagedBean
@SessionScoped
public class ClientDecbugController{

    

    private Decbug bug;
    private ClientDecbugService clientDecbugService;
    private ClientService clientService ;
   
   
    
    
    public ClientDecbugController() {
    }
    
    public Decbug getBug() {
        return bug;
    }

    public void setBug(Decbug bug) {
        this.bug = bug;
    }

   
    
    @PostConstruct
    public void init(){
         clientDecbugService = new ClientDecbugService();
        clientService = new ClientService();
     
    }
    
    
    public List<Client> getClientInBug(){
        return clientDecbugService.getDecbugByClien(bug);
    }
    

////     
////    public List<Students> getStudentsInCourse() {
////        return coursesStudentsService.getStudentsByCourse(course);
////    } 
}
