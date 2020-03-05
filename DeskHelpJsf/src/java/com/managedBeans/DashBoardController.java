/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedBeans;


import com.hibernate.entities.User;
import com.hibernate.config.HibernateConnectionManager;
import com.hibernate.entities.Client;
import com.hibernate.entities.TypeUser;
import com.hibernate.services.ClientService;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.hibernate.services.UserService;

/**
 *
 * @author nadaa
 */

@ManagedBean (name="dashBoardController")
@RequestScoped

public class DashBoardController  {
    
//////    connx
    Connection connection;
    Statement statement;
    
////    
    
 private UserService userService; 
     
 private  String pwdUser;
 private String email1Used;
 

 
  private User use = new User() ;
   
  private Client  clien = new Client();
  
   
  private ClientService    clientService = new ClientService();
        
  private int idUser;
  private String typeUser;
  
//////  
String SQLclient;
ResultSet resultSetclient ;
private String dbuserEmailclient;
private String dbpasswordclient;
 
////////  
    
     private String dbuserEmail;
     private String dbpassword;
    ResultSet resultSet;
    ResultSet resultSet1;

    String SQL;
    String SQL1;

////////////////////////////       
  @PostConstruct
    public void init() {
        
        try {
            HibernateConnectionManager.setConfigFile("hibernate.cfg.xml");
          
        } 
        catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage("Hibernate couldn't startup.."));
        }
    }
////////////////     DAT1 DAT2
    
          public  void dbDataUser ()  {
   
            
           try
        {
     
       dbpassword = use.getPwdUser();
       
dbuserEmail = use.getNameUsedAr();



            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/deskhelp","root","");
            statement = connection.createStatement();
            
            
//// USER @ & pwd     
            SQL = "SELECT u.* FROM user u WHERE   u.EMAIL1_USED like ('" + email1Used +"')";
            System.out.println("Ma requette est :: "+SQL);
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            dbuserEmail = resultSet.getString(8).toString();
            dbpassword = resultSet.getString(3).toString();
             
////////// TYPE USER
             
      SQL1 = "SELECT u.* FROM user u WHERE  u.ID_TYPE_USER = u.ID_TYPE_USER AND u.EMAIL1_USED    like ('" + email1Used +"')  ";
////////  SQL1 = "SELECT type_user.* FROM type_user join user u WHERE u.ID_TYPE_USER   = u.ID_TYPE_USER AND  u.EMAIL1_USED like ('" + email1Used +"') ";
  System.out.println("Ma requette est :: "+SQL1);
  resultSet1 = statement.executeQuery(SQL1);
  resultSet1.next();
  typeUser = resultSet1.getString(2).toString();
          }
     
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
    }
  //             // typeUser
//            SQL1 = "SELECT type_user.* FROM type_user join user u WHERE type_user.ID_TYPE_USER = u.ID_USER AND u.EMAIL1_USED like ('" + email1Used +"')  ";
//            System.out.println("Ma requette est :: "+SQL1);
//            resultSet1 = statement.executeQuery(SQL1);
//            resultSet1.next();
//            typeUser = resultSet1.getString(3).toString();
                            // typeUser
//  SQL1 = "SELECT type_user.* FROM type_user join user u WHERE type_user = u.ID_USER AND u.EMAIL1_USED like ('" + email1Used +"')  ";
//  SQL1 = "SELECT type_user.* FROM type_user join user u WHERE u.ID_TYPE_USER  type_user = u.ID_USER AND  u.EMAIL1_USED like ('" + email1Used +"')  ";
           
//        *******    
//            SQL1 = "SELECT type_user.* FROM type_user join user u WHERE type_user.TYPE_USER =  u.EMAIL1_USED like ('" + email1Used +"')  ";
//            System.out.println("Ma requette est :: "+SQL1);
//            resultSet1 = statement.executeQuery(SQL1);
//            resultSet1.next();
//            typeUser = resultSet1.getString(1).toString();
////            idUser = resultSet.getString(1).charAt(idUser);
//       
//****************
          
          
           public  void dbDataClient ()  {
   
            
           try
        
           {

dbpasswordclient = clien.getPwdUser();

dbuserEmailclient = clien.getEmail1Used();


            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/deskhelp","root","");
            statement = connection.createStatement();
            
     
            SQLclient = "SELECT c.* FROM client c WHERE   c.EMAIL1_USED like ('" + email1Used +"')";
            System.out.println("Ma requette est :: "+SQLclient);
            resultSetclient = statement.executeQuery(SQLclient);
            resultSetclient.next();
            dbuserEmailclient = resultSetclient.getString(8).toString();
            dbpasswordclient =  resultSetclient.getString(3).toString();
     
           }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
        
        
    }
        
   
   public String authorize()
 
    {
           System.out.println("je suis dans la method de pwd ! "+this.pwdUser+"  email : "+this.email1Used);
    
   if(clien != null)   {            
       dbDataClient();
        
                           if (email1Used.equalsIgnoreCase(dbuserEmailclient))
                               
                           {
                               
                               if 
                                       (pwdUser.equals(dbpasswordclient)) 
                                                                                                {
                                                                                                     return "homeClient?faces-redirect=true";
                                                                                                }
                           }
 }
    
   if(use != null) {
      dbDataUser();
       
                           if(email1Used.equalsIgnoreCase(dbuserEmail))
            
        {
  
            if(pwdUser.equals(dbpassword))
                            {
                                    if (this.typeUser.equals("Developer"))
                                                                           { return "affTicketDev?faces-redirect=true"; }
       
                                    else if (this.typeUser.equals("Support-client")) 
                                        
                                                                               { return "authorizeSupportClient?faces-redirect=true"; }
                            
                                    
                                    else if (this.typeUser.equals("Admin"))  
                                    
                                                                           {  return "authorize?faces-redirect=true"; }
                            }
           
        }
    }
       return "index?faces-redirect=true";      
    }
    
 public String logOut()
    {
        return "index?faces-redirect=true";
    }     
  
    
    
  public String getPwdUser() {
        return this.pwdUser;
    }
    
    public void setPwdUser(String pwdUser) {
        this.pwdUser = pwdUser;
    }
    
   public String getEmail1Used() {
        return this.email1Used;
    }
    
    public void setEmail1Used(String email1Used) {
        this.email1Used = email1Used;
    }
    
//////    
      public String getTypeUser() {
        return this.typeUser ;
    }
    
    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser ;
    }
//////////    

////    
     public String getDbuserEmail() {
        return dbuserEmail;
    }
 
    public void setDbuserEmail(String dbuserEmail) {
        this.dbuserEmail = dbuserEmail;
    }
 
    public String getDbpassword() {
        return dbpassword;
    }
 
    public void setDbpassword(String dbpassword) {
        this.dbpassword = dbpassword;
    }
    
//////////client    
     public String getDbuserEmailclient() {
        return dbuserEmailclient;
    }
 
    public void setDbuserEmailclient(String dbuserEmailclient) {
        this.dbuserEmailclient = dbuserEmailclient;
    }
 
    public String getDbpasswordclient() {
        return dbpasswordclient;
    }
 
    public void setDbpasswordclient(String dbpasswordclient) {
        this.dbpasswordclient = dbpasswordclient;
    }
    
}