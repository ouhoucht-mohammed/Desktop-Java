/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PFE.GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class Connect {
    
    
    
        
    private static Connection connect=null;
    
  
    
    

 
    
    
    public static  Connection   getInstance(){
        if(connect==null){
            new Connect();
        }
        return connect;
    }
    
         
     public  Connect(){
         
          try{
     
    Class.forName("com.mysql.jdbc.Driver");    
    connect =DriverManager.getConnection("jdbc:mysql://localhost:3306/pfe", "root","");
         
     
     
     
    }catch(ClassNotFoundException | SQLException e){
    
    
  
    
     }
    
     }
    
    
}
