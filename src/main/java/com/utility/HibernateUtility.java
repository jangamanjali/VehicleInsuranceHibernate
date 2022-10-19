package com.utility;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.entity.Insurance;
import com.entity.User;
public class HibernateUtility {
private static SessionFactory sessionFactory=null;
    
    
    public static SessionFactory getSessionFactory()
    {
        
        if(sessionFactory==null)
        {
           try 
           {
               Configuration configuration=new Configuration();
               
               Properties settings=new Properties();
               
               settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
               settings.put(Environment.URL, "jdbc:mysql://localhost:3307/mydb7462");
               settings.put(Environment.USER, "Anjali");
               settings.put(Environment.PASS, "Anjali@8910");
               settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
               settings.put(Environment.SHOW_SQL, true);
               settings.put(Environment.FORMAT_SQL, true);
               settings.put(Environment.HBM2DDL_AUTO, "update");
               
               configuration.setProperties(settings);
               
               configuration.addAnnotatedClass(User.class);
               configuration.addAnnotatedClass(Insurance.class);
               
               ServiceRegistry serviceRegistry=(ServiceRegistry) new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
               
               sessionFactory=configuration.buildSessionFactory(serviceRegistry);
               
               
               
           }
           catch (Exception e)
           {
            System.out.println(e);
           }
        }
        
        return sessionFactory;
    }

    
}
