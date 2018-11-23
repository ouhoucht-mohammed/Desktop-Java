/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PFE.GUI;

import static PFE.GUI.Clt.RechIdClt;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author HP
 */
public class CmdCltPrd  {
 
private String IdCmdClt;
private  String IdPdt;
private  double QteCmdClt;





    private static  Connection con;
    private static  Statement  stm;
    
    
    public static ResultSet  rst=null;
    public static PreparedStatement  ps;
 
    

  

   
    
    
    

    public CmdCltPrd(String IdCmdClt, String IdPdt, double QteCmdClt) {
        this.IdCmdClt = IdCmdClt;
        this.IdPdt = IdPdt;
        this.QteCmdClt = QteCmdClt;
        
        
 try {
             con=Connect.getInstance();
             stm=con.createStatement();
          
          } catch (Exception e) {
          }
        
       
    }

    public CmdCltPrd() {
        
      
 try {
             con=Connect.getInstance();
             stm=con.createStatement();
          
          } catch (Exception e) {
          }      
      
    }

    public String getIdCmdClt() {
        return IdCmdClt;
    }

    public void setIdCmdClt(String IdCmdClt) {
        this.IdCmdClt = IdCmdClt;
    }

    public String getIdPdt() {
        return IdPdt;
    }

    public void setIdPdt(String IdPdt) {
        this.IdPdt = IdPdt;
    }

    public double getQteCmdClt() {
        return QteCmdClt;
    }

    public void setQteCmdClt(double QteCmdClt) {
        this.QteCmdClt = QteCmdClt;
    }





           public  static  CmdCltPrd            RechIdPdtIdCmdClt (String IdPdt,String IdCmdClt){
        
        

       CmdCltPrd   cmdcltpdt=null;
        try {
            ps=con.prepareStatement("select  *  from   CmdCltPdt where IdPdt = ? and IdCmdClt=?  ;");
            ps.setString(1,IdPdt);
            ps.setString(2,IdCmdClt);
            rst=ps.executeQuery();
            boolean  test=rst.next();
            if(test){
       
                     cmdcltpdt=new CmdCltPrd(rst.getString("IdCmdClt"),rst.getString("IdPdt"),
                     rst.getDouble("QteCmdClt"));
                     return   cmdcltpdt;
           }else{
               
              return null;
               
           }
        } catch (SQLException ex) {
              System.out.println("Error Inside RechIdPdtIdCmdClt -----> : "+ex);      
              return null;
        }
   
   } 
       
           public  static double                 RechQteCmdClt(String IdPdt,String IdCmdClt){
        
        CmdCltPrd  cmd=new  CmdCltPrd();
        if((cmd=RechIdPdtIdCmdClt(IdPdt, IdCmdClt))!=null){


         return cmd.getQteCmdClt();


        }else{
            return 0;
        }
        
        
    }
       
           public  static ArrayList<CmdCltPrd>   RechIdCmdCltPdt (String IdCmdClt) {
        
        
        
  
        IdCmdClt=IdCmdClt+"%";
        ArrayList  <CmdCltPrd>   liste=new ArrayList<>();
        CmdCltPrd   cmdcltpdt = new CmdCltPrd();
        
        
        
        try {
            
            rst=stm.executeQuery("select  *  from   cmdcltpdt where IdCmdClt like '"+IdCmdClt+"'  ;");
            if(rst.next()){
            rst=stm.executeQuery("select  *  from   cmdcltpdt where IdCmdClt like '"+IdCmdClt+"'  ;");

            while (rst.next()) {
          
                     cmdcltpdt=new CmdCltPrd(rst.getString("IdCmdClt"),rst.getString("IdPdt"),rst.getDouble("QteCmdClt"));     
                
                liste.add(cmdcltpdt);
            }
            return  liste;
            }else {
                return null;
            }   
            
        } catch (SQLException ex) {
             System.out.println("Erreur Inside RechIdCmdCltPdt cause :"+ex);      
              return null;
        } 
       
       
       
       
       
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
       
           public  static ArrayList<CmdCltPrd>   RechIdPdtCmdCltPdt  (String IdPdt) {
        
        
        
       
        
  
        IdPdt=IdPdt+"%";
        ArrayList  <CmdCltPrd>   liste=new ArrayList<>();
        CmdCltPrd   cmdcltpdt = new CmdCltPrd();
        
        
        
        try {
            
            rst=stm.executeQuery("select  *  from   CmdCltPdt where IdPdt like '"+IdPdt+"'  ;");
            if(rst.next()){
            rst=stm.executeQuery("select  *  from   CmdCltPdt where IdPdt like '"+IdPdt+"'  ;");

            while (rst.next()) {
          
                     cmdcltpdt=new CmdCltPrd(rst.getString("IdCmdClt"),rst.getString("IdPdt"),rst.getDouble("QteCmdClt"));     
                
                
                liste.add(cmdcltpdt);
            }
            return  liste;
            }else {
                return null;
            }   
            
        } catch (SQLException ex) {
             System.out.println("Erreur Inside RechIdPdtCmdCltPdt cause :"+ex);      
              return null;
        } 
       
       
       
       
       
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

           public  static ArrayList<CmdCltPrd>   RechToutesCmdCltPdt   () {
        
        
        
       
        
  
  
        ArrayList  <CmdCltPrd>   liste=new ArrayList<>();
        CmdCltPrd   cmdcltpdt = new CmdCltPrd();
        
        
        
        try {
            
            rst=stm.executeQuery("select  *  from   CmdCltPdt ");
            if(rst.next()){
            rst=stm.executeQuery("select  *  from   CmdCltPdt ");

            while (rst.next()) {
          
                     cmdcltpdt=new CmdCltPrd(rst.getString("IdCmdClt"),rst.getString("IdPdt"),rst.getDouble("QteCmdClt"));     
                
                
                liste.add(cmdcltpdt);
            }
            return  liste;
            }else {
                return null;
            }   
            
        } catch (SQLException ex) {
             System.out.println("Erreur Inside RechToutesCmdCltPdt cause :"+ex);      
              return null;
        } 
       
       
       
       
       
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
     
     
     
    
    
    
    
          
       
      public     CmdCltPrd               AjoutClt(CmdCltPrd  cmdcltpdt)  {
      Produit  pdt = new Produit();
      CmdClt   cmdclt = new CmdClt();
   
      
      
      
      
      
      
      
  if( pdt.RechIdPdt(cmdcltpdt.getIdPdt())!=null && (cmdclt.RechIdCmdClt(cmdcltpdt.getIdCmdClt()) !=null)  &&  RechIdPdtIdCmdClt(cmdcltpdt.getIdPdt(),cmdcltpdt.getIdCmdClt())==null    ){
   
      
      try {
        ps=con.prepareStatement("insert into  CmdCltPdt values(?,?,?);");
        ps.setString(1,cmdcltpdt.getIdCmdClt());
        ps.setString(2, cmdcltpdt.getIdPdt());
        ps.setDouble(3, cmdcltpdt.getQteCmdClt());
    
        
        
        
        
        ps.executeUpdate();  
       
       
       
 
     
     
     
     
     
     
     JLabel message = new JLabel("Opertion  a été avec Succée");
     JLabel title = new JLabel("Message Information !");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     JOptionPane.showMessageDialog(null, message.getText(),title.getText(),JOptionPane.INFORMATION_MESSAGE);
   
   return cmdcltpdt;

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
   
     JLabel message = new JLabel("   Entrer de nouvelles valeurs pour IdPdt et/ou IdCmdClt        ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur" ,JOptionPane.ERROR_MESSAGE,new ImageIcon("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\FFFFF.png"));
   
      
                 return null;

  }
   
     
   
   }
      public     boolean                 SuppCmdCltPdt(String  IdPdt,String IdCmdClt){
       
       
     if(RechIdPdtIdCmdClt(IdPdt, IdCmdClt)!=null){
         
         
        try {
          ps=con.prepareStatement("delete   from   CmdCltPdt where IdPdt = ? and  IdCmdClt=? ;");
          ps.setString(1,IdPdt);
          ps.setString(2,IdCmdClt);

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
         
      JLabel message = new JLabel(" Entrer de nouvelles valeurs pour IdPdt et IdCmdClt.   ");  
  
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur" ,JOptionPane.ERROR_MESSAGE);
   
      
         return   false;
     }  
       
       
       
       
       
       
       
       
       
       
       
       
       
   }
      public     CmdCltPrd              ModifClt(CmdCltPrd    cmdcltpdt){
       
     
    if(RechIdPdtIdCmdClt(cmdcltpdt.getIdPdt(), cmdcltpdt.getIdCmdClt())!=null){
     
    try {
          ps=con.prepareStatement("Update     CmdCltPdt  set  QteCmdClt=?  where IdPdt = ?  and IdCmdClt=? ;");
          
          
  
          ps.setDouble(1,cmdcltpdt.getQteCmdClt());
          
          ps.setString(2,cmdcltpdt.getIdPdt());
          
          ps.setString(3,cmdcltpdt.getIdCmdClt());
         

          
          
          
          
          
          
          ps.executeUpdate();
          
          
          
     JLabel message = new JLabel("    Modification a été avec Succée        ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Inform&tion Message" ,JOptionPane.INFORMATION_MESSAGE);
        
          
          
    return  cmdcltpdt;      
          
          
          
    }catch(Exception  e){
        
            
     JLabel message = new JLabel(""+e+"      ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0, 14));  
     JOptionPane.showMessageDialog(null, message," Message Erreur",JOptionPane.WARNING_MESSAGE,new ImageIcon("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\FFFFF.png"));
   
    
                  
        
       return null;
        
    }     
        
     
        
        
        
        
        
        
        
        
        
   } else{
       JLabel message = new JLabel("Entrer de nouvelles valeurs pour IdPdt et IdCmdClt.");
  
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur" ,JOptionPane.ERROR_MESSAGE,new ImageIcon("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\FFFFF.png"));
    
     
     return  null;
       
        
        
        
        
        
        
        
        
    }  
       
       
       
       
       
       
       
       
       
       
   }
   
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
   
    
    
    
    
    
    
}
