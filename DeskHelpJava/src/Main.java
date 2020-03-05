import com.hibernate.entities.Client ; 
import com.hibernate.entities.Decbug;

import com.hibernate.entities.ClientDecbug;


import com.hibernate.entities.Ticket;
import com.hibernate.entities.TypeClient;

import com.hibernate.entities.TypeUser;
import com.hibernate.entities.User;
//////
import com.hibernate.services.ClientService;
import com.hibernate.services.DecbugService;
import com.hibernate.services.ClientDecbugService;

import com.hibernate.services.TicketService;
import com.hibernate.services.TypeClientService;
import com.hibernate.services.UserService;
import com.hibernate.services.TypeUserService;
//////////////////////
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author nadaa
 */
public class Main {
   
    public static void main(String[] args) {
        
        try {

  com.hibernate.config.HibernateConnectionManager.setConfigFile("hibernate.cfg.xml");

 
//////
TypeClientService typeClientService = new TypeClientService();

////////
TypeUserService typeUserService = new TypeUserService();

////

            UserService userService  = new UserService();

//////////////////////////    
            TicketService ticketService  = new TicketService();
//////        
         ClientService clientService = new ClientService();
         List<Client> allClient = clientService.getAllClient();
            for(Client c : allClient){
               System.out.println("Name:" + c.getIdClient());
            }
//////// 
         
 DecbugService decbugService = new DecbugService();
  List<Decbug> allDecbug = decbugService.getAllDecbug();
            for(Decbug d : allDecbug){
               System.out.println("Name:" + d.getIdDecbug());
            }
//////////////////////////////////   
         
        
            
            
            
////////         
        } 
               catch (Exception ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            
          
        }
        
        
    }
}
