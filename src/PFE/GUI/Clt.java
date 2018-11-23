/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PFE.GUI;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author HP
 */
public class Clt {
    
    
    
    
    
    private static  Connection con;
    private static  Statement  stm;
   
    
    
    public static ResultSet  rst=null;
    public static PreparedStatement  ps;
 
    


    
   private String  IdClt;
   private String  NomClt;
   private String  Tel1Clt;
   private String  Tel2Clt;
   private String  Fax1Clt;
   private String  Fax2Clt;
   private String  AdrClt;   
   
   
   
   
   
   public Clt(String IdClt, String NomClt, String Tel1Clt, String Tel2Clt, String Fax1Clt, String Fax2Clt, String AdrClt){
        this.IdClt = IdClt;
        this.NomClt = NomClt;
        this.Tel1Clt = Tel1Clt;
        this.Tel2Clt = Tel2Clt;
        this.Fax1Clt = Fax1Clt;
        this.Fax2Clt = Fax2Clt;
        this.AdrClt = AdrClt;
        
          try {
             con=Connect.getInstance();
             stm=con.createStatement();
          
          } catch (Exception e) {
          }
             
        
        
    }

      
      
      
      
      
      
        public Clt()  {
        try {
             con=Connect.getInstance();
             stm=con.createStatement();
          
          } catch (Exception e) {
          }
             
    }
      
      
      
      
      
      
    public String getIdClt() {
        return IdClt;
    }

    public String getNomClt() {
        return NomClt;
    }

    public String getTel1Clt() {
        return Tel1Clt;
    }

    public String getTel2Clt() {
        return Tel2Clt;
    }

    public String getFax1Clt() {
        return Fax1Clt;
    }

    public String getFax2Clt() {
        return Fax2Clt;
    }

    public String getAdrClt() {
        return AdrClt;
    }

    public void setIdClt(String IdClt) {
        this.IdClt = IdClt;
    }

    public void setNomClt(String NomClt) {
        this.NomClt = NomClt;
    }

    public void setTel1Clt(String Tel1Clt) {
        this.Tel1Clt = Tel1Clt;
    }

    public void setTel2Clt(String Tel2Clt) {
        this.Tel2Clt = Tel2Clt;
    }

    public void setFax1Clt(String Fax1Clt) {
        this.Fax1Clt = Fax1Clt;
    }

    public void setFax2Clt(String Fax2Clt) {
        this.Fax2Clt = Fax2Clt;
    }

    public void setAdrClt(String AdrClt) {
        this.AdrClt = AdrClt;
    }

  
   
   
    
   
   
   
   
   
   
   
   
   
   
   
   

    
    
    
       public  static ArrayList<Clt>      RechTousClt(){
   

   
        ArrayList  <Clt>   list_toutes=new ArrayList<>();
        Clt   clt = new Clt();
        try {
            ps=con.prepareStatement("select  *  from   clt ");
            rst=ps.executeQuery();
            if(rst.next()){
            rst=ps.executeQuery();

            while (rst.next()) {
          
                     clt=new Clt(rst.getString("IdClt"),rst.getString("NomClt"),rst.getString("Tel1Clt"),
                     rst.getString("Tel2Clt"),rst.getString("Fax1Clt"),rst.getString("Fax2Clt"),
                     rst.getString("AdrClt"));      
                
                     
                
                list_toutes.add(clt);
            }
            return  list_toutes;
            }else {
                return null;
            }   
            
        } catch (SQLException ex) {
             System.out.println("Erreur Inside RechTousClt cause :"+ex);      
              return null;
        } 
       
       
          
      
      
      
      
      
      
      
      
      
      
  }  
       public  static  ArrayList<Clt>     RechNomClt(String NomClt){
          
          
  
  
        ArrayList  <Clt>   liste=new ArrayList<>();
        Clt   clt = new Clt();
        NomClt=NomClt+"%";
        
        
        try {
            
            rst=stm.executeQuery("select  *  from   Clt where NomClt like '"+NomClt+"'  ;");
            if(rst.next()){
            rst=stm.executeQuery("select  *  from   Clt where NomClt like '"+NomClt+"'  ;");

            while (rst.next()) {
          
                     clt=new Clt(rst.getString("IdClt"),rst.getString("NomClt"),rst.getString("Tel1Clt"),
                     rst.getString("Tel2Clt"),rst.getString("Fax1Clt"),rst.getString("Fax2Clt"),
                     rst.getString("AdrClt"));      
                
                
                liste.add(clt);
            }
            return  liste;
            }else {
                return null;
            }   
            
        } catch (SQLException ex) {
             System.out.println("Erreur Inside RechNomClt cause :"+ex);      
              return null;
        } 
       
       
       
       
       
       
       
       
       
       
       
   }
       public  static Clt                 RechIdClt(String IdClt){
       

       Clt   clt=null;
       IdClt=IdClt+"%";
        try {
            ps=con.prepareStatement("select  *  from   Clt where IdClt  like  ?  ;");
            ps.setString(1,IdClt);
            rst=ps.executeQuery();
            boolean  test=rst.next();
            if(test){
       
                     clt=new Clt(rst.getString("IdClt"),rst.getString("NomClt"),
                     rst.getString("Tel1Clt"),rst.getString("Tel2Clt"),rst.getString("Fax1Clt"),
                     rst.getString("Fax2Clt"),rst.getString("AdrClt"));
                     return   clt;
           }else{
               
              return null;
               
           }
        } catch (SQLException ex) {
              System.out.println("Error Inside RechIdClt -----> : "+ex);      
              return null;
        }
   
   } 
       
       
       
       
       
       
       
      public    Clt               AjoutClt(Clt  clt)  {
       
       
  if(RechIdClt(clt.getIdClt())==null){
    try {
        ps=con.prepareStatement("insert into  Clt values(?,?,?,?,?,?,?);");
        ps.setString(1,clt.getIdClt());
        ps.setString(2, clt.getNomClt());
        ps.setString(3, clt.getTel1Clt());
        ps.setString(4, clt.getTel2Clt());
        ps.setString(5, clt.getFax1Clt());
        ps.setString(6, clt.getFax2Clt());
        ps.setString(7, clt.getAdrClt());
        ps.executeUpdate();  
       
       
       
 
     
     
     
     
     
     
     JLabel message = new JLabel("Opertion  a été avec Succée");
     JLabel title = new JLabel("Message Information !");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     JOptionPane.showMessageDialog(null, message.getText(),title.getText(),JOptionPane.INFORMATION_MESSAGE);
   
   return clt;

    } catch (SQLException ex) {

               //  Pour  la Vérifiation

     JLabel message = new JLabel(""+ex+"      ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0, 14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur",JOptionPane.WARNING_MESSAGE,new ImageIcon("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\FFFFF.png"));
   
    
  
    
       return null;
    }     
       
       
   }else{
          //  Pour  la Vérifiation
   
     JLabel message = new JLabel("    IdClt exsite Déja        ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur" ,JOptionPane.ERROR_MESSAGE,new ImageIcon("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\FFFFF.png"));
   
      
                 return null;

  }
   
     
   
   }
      public     boolean          SuppClt(String  IdClt){
       
       
     if(RechIdClt(IdClt)!=null){
         
         
        try {
          ps=con.prepareStatement("delete   from   Clt where IdClt = ?  ;");
          ps.setString(1,IdClt);
          ps.executeUpdate();
          
          
          
     JLabel message = new JLabel("Operation  a été avec Succée   ");
     JLabel title = new JLabel("Message Information !");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     JOptionPane.showMessageDialog(null, message.getText(),title.getText(),JOptionPane.INFORMATION_MESSAGE);
       
          
          
          
          
          
          
          
          
          return  true;
          
         
        }catch(Exception e){
            
            
            
     JLabel message = new JLabel(""+e+"      ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0, 14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur",JOptionPane.WARNING_MESSAGE,new ImageIcon("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\FFFFF.png"));
   
    
            
            return false;
            
            
            
        }  
         
     }else{
         
      JLabel message = new JLabel("   << IdClt n'existe Pas >>   ");  
  
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur" ,JOptionPane.ERROR_MESSAGE);
   
      
         return   false;
     }  
       
       
       
       
       
       
       
       
       
       
       
       
       
   }
      public       Clt            ModifClt(Clt    clt){
       
     
    if(RechIdClt(clt.getIdClt())!=null){
     
    try {
          ps=con.prepareStatement("Update     clt  set  NomClt=?,Tel1Clt=?,Tel2Clt=?,Fax1Clt=?,"
                                  + "Fax2Clt=?,AdrClt=?  where IdClt = ?  ;");
          
          
  
          ps.setString(1,clt.getNomClt());
          
          ps.setString(2,clt.getTel1Clt());
          
          ps.setString(3,clt.getTel2Clt());
          
          ps.setString(4,clt.getFax1Clt());
          
          ps.setString(5,clt.getFax2Clt());
          
          ps.setString(6,clt.getAdrClt());
          
          ps.setString(7,clt.getIdClt());

          
          
          
          
          
          
          ps.executeUpdate();
          
          
          
     JLabel message = new JLabel("    Modification a été avec Succée        ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Inform&tion Message" ,JOptionPane.INFORMATION_MESSAGE);
        
          
          
    return  clt;      
          
          
          
    }catch(Exception  e){
        
            
     JLabel message = new JLabel(""+e+"      ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0, 14));  
     JOptionPane.showMessageDialog(null, message," Message Erreur",JOptionPane.WARNING_MESSAGE,new ImageIcon("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\FFFFF.png"));
   
    
                  
        
       return null;
        
    }     
        
     
        
        
        
        
        
        
        
        
        
   } else{
       JLabel message = new JLabel("IdClt n'exsite pas,Entrer une nouvelle valeur pour IdClt.");
  
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur" ,JOptionPane.ERROR_MESSAGE,new ImageIcon("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\FFFFF.png"));
    
     
     return  null;
       
        
        
        
        
        
        
        
        
    }  
       
       
       
       
       
       
       
       
       
       
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   


  
          
          
          
          
       
     
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
