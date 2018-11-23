/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PFE.GUI;



import static PFE.GUI.FactFrPdt.RechIdPdtFrPdt;
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
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author HP
 */
public class CmdClt  extends Connect{
    
    



   
    private static  Connection con;
    private static  Statement  stm;
    
    
    
    
    
    
    
    
    
    
    public static   ResultSet  rst=null;
    public static   PreparedStatement  ps;
    
    
    
    
    
    
    private  String  IdCmdClt;
    private  String   IdClt;
    private double AvanceCmdClt;
    private String    Prop1CmdClt;
    private String    Prop2CmdClt;
    private String    DateCmdClt;
    private  String   PhotoCmdClt;
    
    
      public CmdClt(String IdCmdClt, String IdClt, double AvanceCmdClt, String Prop1CmdClt, String Prop2CmdClt, String DateCmdClt, String PhotoCmdClt) {
        this.IdCmdClt = IdCmdClt;
        this.IdClt = IdClt;
        this.AvanceCmdClt = AvanceCmdClt;
        this.Prop1CmdClt = Prop1CmdClt;
        this.Prop2CmdClt = Prop2CmdClt;
        this.DateCmdClt = DateCmdClt;
        this.PhotoCmdClt = PhotoCmdClt;
        
        
              
        
 try {
             con=Connect.getInstance();
             stm=con.createStatement();
          
          } catch (Exception e) {
          }
     
        
        
    }
    
    
      
      
      
      
      public CmdClt() {
         
 try {
             con=Connect.getInstance();
             stm=con.createStatement();
          
          } catch (Exception e) {
          }
    }

    

    public String getIdCmdClt(){
        return IdCmdClt;
    }

    public String getIdClt() {
        return IdClt;
    }

    public double getAvanceCmdClt() {
        return AvanceCmdClt;
    }

    public String getProp1CmdClt() {
        return Prop1CmdClt;
    }

    public String getProp2CmdClt() {
        return Prop2CmdClt;
    }

    public String getDateCmdClt() {
        return DateCmdClt;
    }

    public String getTelecharger() {
        return PhotoCmdClt;
    }

  
    public void setIdCmdClt(String IdCmdClt) {
        this.IdCmdClt = IdCmdClt;
    }

    public void setIdClt(String IdClt) {
        this.IdClt = IdClt;
    }

    public void setAvanceCmdClt(double AvanceCmdClt) {
        this.AvanceCmdClt = AvanceCmdClt;
    }

    public void setProp1CmdClt(String Prop1CmdClt) {
        this.Prop1CmdClt = Prop1CmdClt;
    }

    public void setProp2CmdClt(String Prop2CmdClt) {
        this.Prop2CmdClt = Prop2CmdClt;
    }

    public void setDateCmdClt(String DateCmdClt) {
        this.DateCmdClt = DateCmdClt;
    }

    public void setTelecharger(String PhotoCmdClt) {
        this.PhotoCmdClt = PhotoCmdClt;
    }

    
   
    
    
    
    
    
    
    
    
    
    
      public  static CmdClt       RechIdCmdClt (String IdCmdClt){
         
      IdCmdClt=IdCmdClt+"%";
       CmdClt   cmdclt=null;
        try {
            ps=con.prepareStatement("select  *  from   CmdClt where IdCmdClt like ?  ;");
            ps.setString(1,IdCmdClt);
            rst=ps.executeQuery();
            boolean  test=rst.next();
            if(test){
       
        
                     cmdclt=new CmdClt(rst.getString("IdCmdClt"),rst.getString("IdClt"),
                     rst.getDouble("AvanceCmdClt"),rst.getString("Prop1CmdClt"),rst.getString("Prop2CmdClt"),
                     rst.getString("DateCmdClt"),rst.getString("PhotoCmdClt"));
                     return   cmdclt;
           }else{
               
              return null;
               
           }
        } catch (SQLException ex) {
              System.out.println("Error Inside RechIdClt -----> : "+ex);      
              return null;
        }
   
   } 
       
       public  static  ArrayList<CmdClt>   RechCmdClt (String IdClt){
          
          
  
        IdClt=IdClt+"%";
        ArrayList  <CmdClt>   liste=new ArrayList<>();
        CmdClt   cmdclt = new CmdClt();
        
        
        try {
            
            rst=stm.executeQuery("select  *  from   CmdClt where IdClt  like '"+IdClt+"'  ;");
            if(rst.next()){
            rst=stm.executeQuery("select  *  from   CmdClt where IdClt  like'"+IdClt+"'  ;");

            while (rst.next()) {
          
                     cmdclt=new CmdClt(rst.getString("IdCmdClt"),rst.getString("IdClt"),
                     rst.getDouble("AvanceCmdClt"),rst.getString("Prop1CmdClt"),rst.getString("Prop2CmdClt"),
                     rst.getString("DateCmdClt"),rst.getString("PhotoCmdClt"));    
                
                
                liste.add(cmdclt);
            }
            return  liste;
            }else {
                return null;
            }   
            
        } catch (SQLException ex) {
             System.out.println("Erreur Inside RechCmdClt cause :"+ex);      
              return null;
        } 
       
       
       
       
       
       
       
       
       
       
       
   }
       public  static  ArrayList<CmdClt>   RechAvanceCmdCltNonNull  (){
          
          
  
  
        ArrayList  <CmdClt>   liste=new ArrayList<>();
        CmdClt   cmdclt = new CmdClt();
        
        
        try {
            
            rst=stm.executeQuery("select  *  from   CmdClt where AvanceCmdClt <> 0 ;");
            if(rst.next()){
            rst=stm.executeQuery("select  *  from   CmdClt where AvanceCmdClt <> 0 ;");

            while (rst.next()) {
          
                     cmdclt=new CmdClt(rst.getString("IdCmdClt"),rst.getString("IdClt"),
                     rst.getDouble("AvanceCmdClt"),rst.getString("Prop1CmdClt"),rst.getString("Prop2CmdClt"),
                     rst.getString("DateCmdClt"),rst.getString("PhotoCmdClt"));    
                
                
                liste.add(cmdclt);
            }
            return  liste;
            }else {
                return null;
            }   
            
        } catch (SQLException ex) {
             System.out.println("Erreur Inside RechAvanceCmdCltNonNull cause :"+ex);      
              return null;
        } 
       
       
       
       
       
       
       
       
       
       
       
   }
       public  static  ArrayList<CmdClt>   RechToutesCmdClt (){
          
          
  
  
        ArrayList  <CmdClt>   liste=new ArrayList<>();
        CmdClt   cmdclt = new CmdClt();
        
        
        try {
            
            rst=stm.executeQuery("select  *  from   CmdClt ;");
            if(rst.next()){
            rst=stm.executeQuery("select  *  from   CmdClt  ;");

            while (rst.next()) {
          
                     cmdclt=new CmdClt(rst.getString("IdCmdClt"),rst.getString("IdClt"),
                     rst.getDouble("AvanceCmdClt"),rst.getString("Prop1CmdClt"),rst.getString("Prop2CmdClt"),
                     rst.getString("DateCmdClt"),rst.getString("PhotoCmdClt"));    
                
                
                liste.add(cmdclt);
            }
            return  liste;
            }else {
                return null;
            }   
            
        } catch (SQLException ex) {
             System.out.println("Erreur Inside RechToutesCmdClt cause :"+ex);      
              return null;
        } 
       
       
       
       
       
       
       
       
       
       
       
   }
       public  static ArrayList<CmdClt>  RechDateCmdClt (String datdebu,String datfin){
        
       
        ArrayList  <CmdClt>   list_toutes=new ArrayList<>();
        CmdClt  cmdclt = new CmdClt();
        try {
            ps=con.prepareStatement("select * from CmdClt where DateCmdClt between '"+datdebu+"' and '"+datfin+"';");
            rst=ps.executeQuery();
            if(rst.next()){
            rst=ps.executeQuery();

            while (rst.next()) {
          
                     cmdclt=new CmdClt(rst.getString("IdCmdClt"),rst.getString("IdClt"),
                     rst.getDouble("AvanceCmdClt"),rst.getString("Prop1CmdClt"),rst.getString("Prop2CmdClt"),
                     rst.getString("DateCmdClt"),rst.getString("PhotoCmdClt"));    
                              list_toutes.add(cmdclt);
            }
            return  list_toutes;
            }else {
                return null;
            }   
            
        } catch (SQLException ex) {
             System.out.println("Erreur Inside RechDateCmdClt cause :"+ex);      
              return null;
        } 
       

        
   
   
        
    }
     
  
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
       public  static ArrayList<String>   RechToutesInfoCmdClt(String DateDebut,String DateFin){
        
        
     ArrayList<CmdClt>  liste=RechDateCmdClt(DateDebut, DateFin);
     Clt  clt = new Clt();
     CmdCltPrd  cmdcltpdt = new CmdCltPrd();
     Produit  pdt = new Produit();
       if(liste!=null){
    
      ArrayList <String>   tab=new ArrayList<>();

       
       
      
       
 for(CmdClt   cmdclt : liste){
    ArrayList<CmdCltPrd>  liste2=cmdcltpdt.RechIdCmdCltPdt(cmdclt.getIdCmdClt());
  if(liste2!=null){ 
    for(CmdCltPrd  cmdCltpdt : liste2 ){           
                        
       tab.add(cmdclt.getIdCmdClt());
       tab.add(cmdclt.getDateCmdClt());
       tab.add(cmdCltpdt.getIdPdt());
       tab.add(pdt.RechIdPdt(cmdCltpdt.getIdPdt()).getDesigPdt());
       tab.add(cmdclt.getProp1CmdClt());
       tab.add(cmdCltpdt.getQteCmdClt()+"");
       tab.add(clt.RechIdClt(cmdclt.getIdClt()).getIdClt());
       tab.add(clt.RechIdClt(cmdclt.getIdClt()).getNomClt());
        

           
           
       }}
       
         
        }           
           
           
           
           
       

    return    tab;



       }else{
           
           
           return null;
       }
      
      
      
      
      
      
      
        
        
        
        
        
        
        
        
    }
      
       

       
      public  static ArrayList<String>   RechDesigPdtQteCmdClt(String DateDebut,String DateFin){
        
        
     ArrayList<CmdClt>  liste=RechDateCmdClt(DateDebut, DateFin);
     CmdCltPrd  cmdcltpdt = new CmdCltPrd();
     Produit  pdt = new Produit();
       if(liste!=null){
    
       ArrayList <String>   tab=new ArrayList<>();


       
       
      
       
 for(CmdClt   cmdclt : liste){
   
     ArrayList<CmdCltPrd>  liste2=cmdcltpdt.RechIdCmdCltPdt(cmdclt.getIdCmdClt());
   
 if(liste2!=null){
     
        for(CmdCltPrd  cmdCltpdt : liste2 ){     
            
        tab.add(cmdclt.getIdCmdClt());
        tab.add(pdt.RechIdPdt(cmdCltpdt.getIdPdt()).getDesigPdt());
        tab.add(cmdclt.getProp1CmdClt()) ;
        tab.add(cmdCltpdt.getQteCmdClt()+"");

      
      
      
        
      
     

           
       }
 }
       
         
        }           
           
           
           
           
       

    return    tab;



       }else{
           
           
           return null;
       }
      
      
      
      
      
      
      
        
        
        
        
        
        
        
        
    }
  
       
       
  public  static ArrayList<String>   RechCmdCltAPasser(String DateDebut,String DateFin){
        
 
       ArrayList  <String>   list=new ArrayList<>();
         
         
         
         
        try {
          
    rst=stm.executeQuery("select DesigPdt,Prop1CmdClt,QteCmdClt  from cmdclt,cmdcltpdt,pdt where cmdclt.IdCmdClt=cmdcltpdt.IdCmdClt and cmdcltpdt.IdPdt=pdt.IdPdt and DateCmdClt >= '"+DateDebut+"' and DateCmdClt <= '"+DateFin+"'  GROUP BY DesigPdt,Prop1CmdClt;");
       if(rst.next()){
    rst=stm.executeQuery("select DesigPdt,Prop1CmdClt,QteCmdClt  from cmdclt,cmdcltpdt,pdt where cmdclt.IdCmdClt=cmdcltpdt.IdCmdClt and cmdcltpdt.IdPdt=pdt.IdPdt and DateCmdClt >= '"+DateDebut+"' and DateCmdClt <= '"+DateFin+"'  GROUP BY DesigPdt,Prop1CmdClt;");

            while (rst.next()) {
          
                   
                
             list.add(rst.getString("DesigPdt"));
             list.add(rst.getString("Prop1CmdClt"));
             list.add(rst.getDouble("QteCmdClt")+"");

                



            }
            return  list;
            }else {
                return null;
            }    
        
            
            
            
            
            
            
            
        } catch (SQLException ex) {
             System.out.println("Erreur Inside RechCmdCltAPasser cause :"+ex);      
              return null;
        } 
       

     
     
        
        
        
        
        
        
    }

       
       
       
       
       
       
       
       
       
       
       
       public     CmdClt       AjoutCmdClt(CmdClt  cmdclt)  {
       Clt  clt = new Clt();
       
       
  if(RechIdCmdClt(cmdclt.getIdCmdClt())==null && clt.RechIdClt(cmdclt.getIdClt())!=null){
    try {
        ps=con.prepareStatement("insert into  CmdClt(IdCmdClt,IdClt,AvanceCmdClt,Prop1CmdClt,Prop2CmdClt,DateCmdClt,PhotoCmdClt) values(?,?,?,?,?,?,?);");
        ps.setString(1,cmdclt.getIdCmdClt());
        ps.setString(2, cmdclt.getIdClt());
        ps.setDouble(3, cmdclt.getAvanceCmdClt());
        ps.setString(4, cmdclt.getProp1CmdClt());
        ps.setString(5, cmdclt.getProp2CmdClt());
        ps.setString(6, cmdclt.getDateCmdClt());
        ps.setString(7, cmdclt.getTelecharger());
        ps.executeUpdate();  
       
       
       
       
   
     
     
     
     
     
     JLabel message = new JLabel("Opertion  a été avec Succée");
     JLabel title = new JLabel("Message Information !");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     JOptionPane.showMessageDialog(null, message.getText(),title.getText(),JOptionPane.INFORMATION_MESSAGE);
   
   return cmdclt;

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
   
     JLabel message = new JLabel("    IdCmdClt exsite Déja ou IdClt n'existe Pas         ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur" ,JOptionPane.ERROR_MESSAGE,new ImageIcon("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\FFFFF.png"));
   
      
                 return null;

  }
        
         
         
         
         
         
         
         
         
         
         
     }
       public     boolean      SuppCmdClt (String  IdCmdClt){
       
       
     if(RechIdCmdClt(IdCmdClt)!=null){
         
         
        try {
          ps=con.prepareStatement("delete   from   CmdClt where IdCmdClt = ?   ;");
          ps.setString(1,IdCmdClt);
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
         
      JLabel message = new JLabel("    IdCmdClt n'existe Pas        ");  
  
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur" ,JOptionPane.ERROR_MESSAGE);
   
      
         return   false;
     }  
       
       
       
       
       
       
       
       
       
       
       
       
       
   }
       public     CmdClt       ModifCmdClt(CmdClt    cmdclt){
       
     
    if(RechIdCmdClt(cmdclt.getIdCmdClt())!=null){
     
    try {
          ps=con.prepareStatement("Update     CmdClt  set  AvanceCmdClt=?,Prop1CmdClt=?,Prop2CmdClt=?,DateCmdClt=?,"
                                  + "PhotoCmdClt=?   where  IdCmdClt= ? and IdClt = ?  ;");
          
          
  
          ps.setDouble(1,cmdclt.getAvanceCmdClt());
          
          ps.setString(2,cmdclt.getProp1CmdClt());
          
          ps.setString(3,cmdclt.getProp2CmdClt());
          
          ps.setString(4,cmdclt.getDateCmdClt());
          
          ps.setString(5,cmdclt.getTelecharger());

          ps.setString(6,cmdclt.getIdCmdClt());
          
          ps.setString(7,cmdclt.getIdClt());
          

          
          
          
          
          
          
        ps.executeUpdate();
                
      JLabel message = new JLabel("    Modification a été avec Succée        ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Inform&tion Message" ,JOptionPane.INFORMATION_MESSAGE);
        
               

          
          
          
          
          
          
          
    return  cmdclt;      
          
          
          
    }catch(Exception  e){
        
            
     JLabel message = new JLabel(""+e+"      ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0, 14));  
     JOptionPane.showMessageDialog(null, message," Message Erreur",JOptionPane.WARNING_MESSAGE,new ImageIcon("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\FFFFF.png"));
   
    
                  
        
       return null;
        
    }     
        
     
        
        
        
        
        
        
        
        
        
   } else{
       JLabel message = new JLabel("  IdCmdClt n'exsite pas,Entrer de nouvelles valeurs.  ");
  
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur" ,JOptionPane.ERROR_MESSAGE,new ImageIcon("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\FFFFF.png"));
    
     
     return  null;
       
        
        
        
        
        
        
        
        
    }  
       
       
       
       
       
       
       
       
       
       
   }
   
   
    
    
    
    
      
    
    
    
    
}
