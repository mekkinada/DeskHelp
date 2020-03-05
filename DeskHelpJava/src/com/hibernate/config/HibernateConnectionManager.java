package com.hibernate.config;



import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



public class HibernateConnectionManager {

    private static  SessionFactory sessionFactory;
    private static String configFile;
    
    
    public static  SessionFactory  buildConnection () throws Exception     
    {
        if(configFile == null)
        {
            throw new Exception("config file is null");
        }
        if(sessionFactory == null)
        {
            
        
        
        Configuration configuration = new Configuration().configure(configFile);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
         StandardServiceRegistry serviceRegistry = builder.build();
         sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

    public static void setConfigFile (String configFile) throws Exception {
        HibernateConnectionManager.configFile = configFile;
        sessionFactory = buildConnection();
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    
    
        public static Transaction beginTransaction()
    {
        return sessionFactory.getCurrentSession().beginTransaction();
    }

        public static void commitTransaction()
    {
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

   
   
}
