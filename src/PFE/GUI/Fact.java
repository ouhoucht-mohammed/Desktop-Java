/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PFE.GUI;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author HP
 */
public class Fact {

    
    
    
    
    private static  Connection con;
    private static  Statement  stm;
    
    
    public static ResultSet  rst=null;
    public static PreparedStatement  ps;
 
    
    
    
    
    
    
    
    
    
    
    
    
      
    private String  IdFactFr;
    private String  IdFr;
    private double   MontFactFr;
    private String   date_t;
    private String   image; 
    
    
    
    
    
    
    public void setIdFactFr(String IdFactFr) {
        this.IdFactFr = IdFactFr;
    }

    public void setIdFr(String IdFr) {
        this.IdFr = IdFr;
    }

    public void setMontFactFr(double MontFactFr) {
        this.MontFactFr = MontFactFr;
    }

    public void setDate_t(String date_t) {
        this.date_t = date_t;
    }
    

    public String getIdFactFr() {
        return IdFactFr;
    }

    public String getIdFr() {
        return IdFr;
    }

    public double getMontFactFr() {
        return MontFactFr;
    }

    public String getDate_t() {
        return date_t;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    
    
    
   public   Fact( String IdFactFr,String IdFr,String  DateFactFr,double MontFactFr, String img ){
        
        this.IdFactFr=IdFactFr;
        this.IdFr=IdFr;
        this.date_t=DateFactFr;
        this.MontFactFr=MontFactFr;
        this.image=img;
        
     
        
       
 try {
             con=Connect.getInstance();
             stm=con.createStatement();
          
          } catch (Exception e) {
          } 
        
        
    }
       
    public   Fact(){
          
        
 try {
             con=Connect.getInstance();
             stm=con.createStatement();
          
          } catch (Exception e) {
          }
    }
    
    
    
    

   
   
   
   
   
   
   
   
   
   
    public  static Fact  Rechidfact(String idfact){
        Fact fc=null;
        idfact=idfact+"%";
        try {
            stm = con.createStatement();
            rst= stm.executeQuery("select * from factfr where IdFactFr  like '"+idfact+"';");
            boolean  test=rst.next();
            if(test){
                     fc=new Fact(rst.getString("IdFactFr"),rst.getString("IdFr"),rst.getDate("DateFactFr")+"",rst.getDouble("MontFactFr"),rst.getString("PhotoFactFr"));
                     return   fc;
           }else{
              return null;
           }
        } catch (SQLException ex) {
             System.out.println("Erreur Inside RecherIdFr cause :"+ex);      
              return null;
        }
        
   
   
        
    }
    public  static ArrayList<Fact>   RechToutesfact(){
   
        ArrayList  <Fact>   list_toutes=new ArrayList<>();
        Fact  fc = new Fact();
        try {
            ps=con.prepareStatement("select  *  from   factfr ");
            rst=ps.executeQuery();
            if(rst.next()){
            rst=ps.executeQuery();

            while (rst.next()) {
          
                     fc=new Fact(rst.getString("IdFactFr"),rst.getString("IdFr"),rst.getDate("DateFactFr")+"",rst.getDouble("MontFactFr"),rst.getString("PhotoFactFr"));
                      
                
                
                list_toutes.add(fc);
            }
            return  list_toutes;
            }else {
                return null;
            }   
            
        } catch (SQLException ex) {
             System.out.println("Erreur Inside RecherIdFr cause :"+ex);      
              return null;
        } 
       

      
  }  
 
    public  static ArrayList<Fact>  Rechdat(String datdebu,String datfin){
        
       
        ArrayList  <Fact>   list_toutes=new ArrayList<>();
        Fact  fc = new Fact();
        try {
            
            ps=con.prepareStatement("select * from factfr where DateFactFr between '"+datdebu+"' and '"+datfin+"';");
            rst=ps.executeQuery();
            if(rst.next()){
            rst=ps.executeQuery();

            while (rst.next()) {
          
                     fc=new Fact(rst.getString("IdFactFr"),rst.getString("IdFr"),rst.getDate("DateFactFr")+"",rst.getDouble("MontFactFr"),rst.getString("PhotoFactFr"));
              list_toutes.add(fc);
            }
            return  list_toutes;
            }else {
                return null;
            }   
            
        } catch (SQLException ex) {
             System.out.println("Erreur Inside Recherdat cause :"+ex);      
              return null;
        } 
       

        
   
   
        
    }
    public  static ArrayList<Fact>  RechIdFr(String idfr ){
        ArrayList  <Fact>   list_toutes=new ArrayList<>();
        Fact  fc = new Fact();
        idfr=idfr+"%";

        try {
            ps=con.prepareStatement("select * from factfr where IdFr  like '"+idfr+"';");
            rst=ps.executeQuery();
            if(rst.next()){
            rst=ps.executeQuery();

            while (rst.next()) {
          
                     fc=new Fact(rst.getString("IdFactFr"),rst.getString("IdFr"),rst.getDate("DateFactFr")+"",rst.getDouble("MontFactFr"),rst.getString("PhotoFactFr"));
                     list_toutes.add(fc);
            }
            return  list_toutes;
            }else {
                return null;
            }   
            
        } catch (SQLException ex) {
             System.out.println("Erreur Inside RechIdFr cause :"+ex);      
              return null;
        } 
       

        
   
   
        
    }
    
     
    
      
   
   public  Fact AjoutFactFr(Fact o){
        Fournisseur f = new Fournisseur();
        System.out.println("oui");
	if( f.RechIdFr(o.getIdFr())!=null   && o.Rechidfact(o.getIdFactFr())==null){
            
		try {
                    

       			ps=con.prepareStatement("insert  into   FactFr (IdFactFr,IdFr,MontFactFr,DateFactFr,PhotoFactFr)  values(?,?,?,?,?);");
                        ps.setString(1,o.getIdFactFr());
                        ps.setString(2,o.getIdFr());
                        ps.setDouble(3,o.getMontFactFr());
                        ps.setString(4,o.getDate_t());
                        ps.setString(5,o.getImage());
                        ps.executeUpdate();
     
     JLabel message = new JLabel("Opertion  a  été  avec Sucée");
     JLabel title = new JLabel("Message Information !");

     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     JOptionPane.showMessageDialog(null, message.getText(),title.getText(),JOptionPane.INFORMATION_MESSAGE);
     return null;
		  } catch (SQLException ex) {
       			return null;
    		} 
	}
        else{
             JLabel message = new JLabel("    IdFr ou IdFactFr n'existe Pas ou existe Déja  ");
     
  
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur" ,JOptionPane.ERROR_MESSAGE,null);
   
      
            return null;
        }
}
   public  boolean  Suppfact(String  idfact){
       
     
     if(Rechidfact(idfact)!=null){
         
         
        try {
          ps=con.prepareStatement("delete   from   factfr where IdFactFr = ?  ;");
          ps.setString(1,idfact);
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
     JOptionPane.showMessageDialog(null, message,"Message Erreur",JOptionPane.WARNING_MESSAGE,null);
    
            
            return false;
            
            
            
        }  
         
     }else{
         
      JLabel message = new JLabel("    Id fact N'Existe Pas        ");  
  
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur" ,JOptionPane.ERROR_MESSAGE,null);
   
      
         return   false;
     }  
   
   }
   public  Object Modiffact(Fact   Fc){
       
    if(Rechidfact(Fc.getIdFactFr())!=null){
     
    try {
          
  
          
          ps=con.prepareStatement("Update factfr  set    DateFactFr = ? , MontFactFr = ?,PhotoFactFr =?    where   IdFactFr =? and  IdFr = ? ;");
                 
          
          
          
                        ps.setString(1,Fc.getDate_t());
                        ps.setDouble(2,Fc.getMontFactFr());
                        ps.setString(3,Fc.getImage());

                        ps.setString(4,Fc.getIdFactFr());
                        ps.setString(5,Fc.getIdFr());
      
          
          
          
          
          

          
    ps.executeUpdate();
    
    
    JLabel message = new JLabel("    Modification a été avec Succée        ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Inform&tion Message" ,JOptionPane.INFORMATION_MESSAGE,null);
                   
    return  Fc; 
   
          
          
          
    }catch(Exception  e){
        
            
     JLabel message = new JLabel(""+e+"      ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0, 14));  
     JOptionPane.showMessageDialog(null, message," Message Erreur",JOptionPane.WARNING_MESSAGE,null);
       return null;
        
    }     
  
   } else{
       JLabel message = new JLabel("    Id fact exsiste Déja       ");
  
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur" ,JOptionPane.ERROR_MESSAGE,null);
    
     
     return  null;
 }  }

    
     
    
    
    
}
