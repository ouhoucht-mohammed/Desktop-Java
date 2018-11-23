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
public class Fournisseur extends Connect{
    
 

   
   
    private  static  Connection con;
    private  static  Statement  stm;
    
    
    public static ResultSet  rst=null;
    public static PreparedStatement  ps;
    
    
    
    
    private  static Fournisseur  fr=null;
 
    












private  String  IdFr;
private  String  NomFr;
private  String  CategFr;
private  String  Tel1 ;
private  String  Tel2 ;
private  String  Fax1 ;
private  String  Fax2 ;
private  String  adresse ;
    





      
    /**
     *Constructeur  de la class   Fournisseur qui ne contient aucun param
     */
    public  Fournisseur(){
        

 try {
             con=Connect.getInstance();
             stm=con.createStatement();
          
          } catch (Exception e) {
          }
        
    }

    /**
     *
     * @param IdFr
     * @param NomFr
     * @param CategFr
     * @param Tel1
     * @param Tel2
     * @param Fax1
     * @param Fax2
     * @param adresse
     */
    public Fournisseur(String IdFr, String NomFr, String CategFr, String Tel1, String Tel2, String Fax1, String Fax2, String adresse) {
            
 
        
        
        this.IdFr = IdFr;
        this.NomFr = NomFr;
        this.CategFr = CategFr;
        this.Tel1 = Tel1;
        this.Tel2 = Tel2;
        this.Fax1 = Fax1;
        this.Fax2 = Fax2;
        this.adresse = adresse;
        
  

 try {
             con=Connect.getInstance();
             stm=con.createStatement();
          
          } catch (Exception e) {
          }
        
        
        
    }

    /**
     *
     * @param IdFr identifinat de Fournisseur
     */
    public void setIdFr(String IdFr) {
        this.IdFr = IdFr;
    }

    /**
     *
     * @param NomFr  Nom de Fournisseur
     */
    public void setNomFr(String NomFr) {
        this.NomFr = NomFr;
    }

    /**
     *
     * @param CategFr  Categorie de Fournisseur
     */
    public void setCategFr(String CategFr) {
        this.CategFr = CategFr;
    }

    /**
     *
     * @param Tel1   N° Tel1 de Fournisseur
     */
    public void setTel1(String Tel1) {
        this.Tel1 = Tel1;
    }

    /**
     *
     * @param Tel2  N° Tel2 de Fournisseur
     */
    public void setTel2(String Tel2) {
        this.Tel2 = Tel2;
    }

    /**
     *
     * @param Fax1 N° Fax1 de Fournisseur
     */
    public void setFax1(String Fax1) {
        this.Fax1 = Fax1;
    }

    /**
     *
     * @param Fax2  N° Fax2 de Fournisseur
     */
    public void setFax2(String Fax2) {
        this.Fax2 = Fax2;
    }

    /**
     *
     * @param adresse  adresse de Fournisseur
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     *
     * @return  IdFr
     */
    public String getIdFr() {
        return IdFr;
    }

    /**
     *
     * @return NomFr
     */
    public String getNomFr() {
        return NomFr;
    }

    /**
     *
     * @return CategFr
     */
    public String getCategFr() {
        return CategFr;
    }

    /**
     *
     * @return Tel1
     */
    public String getTel1() {
        return Tel1;
    }

    /**
     *
     * @return Tel2
     */
    public String getTel2() {
        return Tel2;
    }

    /**
     *
     * @return Fax1
     */
    public String getFax1() {
        return Fax1;
    }

    /**
     *
     * @return Fax2
     */
    public String getFax2() {
        return Fax2;
    }

    /**
     *
     * @return adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     *
     * @param  fr 
     * @return
     */
    public  Fournisseur  AjoutFr(Fournisseur  fr)  {
       
       
  if(RechIdFr(fr.getIdFr())==null){
    try {
        ps=con.prepareStatement("insert into  fr values(?,?,?,?,?,?,?,?);");
        ps.setString(1,fr.getIdFr());
        ps.setString(2, fr.getNomFr());
        ps.setString(3, fr.getCategFr());
        ps.setString(4, fr.getTel1());
        ps.setString(5, fr.getTel2());
        ps.setString(6, fr.getFax1());
        ps.setString(7, fr.getFax2());
        ps.setString(8, fr.getAdresse());
        ps.executeUpdate();  
       
       
       
       //  Pour  la Vérifiation
       
       
  
     JLabel message = new JLabel("Opertion  a été avec Succée");
     JLabel title = new JLabel("Message Information !");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     JOptionPane.showMessageDialog(null, message.getText(),title.getText(),JOptionPane.INFORMATION_MESSAGE);
   
   return fr;

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
   
     JLabel message = new JLabel("    Id Fournisseur Exsite Déja        ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur" ,JOptionPane.ERROR_MESSAGE,new ImageIcon("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\FFFFF.png"));
   
      
                 return null;

  }
   
     
   
   }

    /**
     *
     * @param IdFr
     * @return   boolean
     */
    public  boolean      SuppFr(String  IdFr){
       
       
     if(RechIdFr(IdFr)!=null){
         
         
        try {
          ps=con.prepareStatement("delete   from   fr where IdFr = ?  ;");
          ps.setString(1,IdFr);
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
         
      JLabel message = new JLabel("    Id Fournisseur N'Existe Pas        ");  
  
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur" ,JOptionPane.ERROR_MESSAGE);
   
      
         return   false;
     }  
       
       
       
       
       
       
       
       
       
       
       
       
       
   }

    /**
     *
     * @param Fr
     * @return
     */
    public  Object       ModifFr(Fournisseur    Fr){
       
     
    if(RechIdFr(Fr.getIdFr())!=null){
     
    try {
          ps=con.prepareStatement("Update     fr  set  Nomfr=?,CategFr=?,Tel1Fr=?,Tel2Fr=?,"
                                  + "Fax1Fr=?,Fax2Fr=?,AdrFr=?  where IdFr = ?  ;");
          
          
  
          ps.setString(1,Fr.getNomFr());
          
          ps.setString(2,Fr.getCategFr());
          
          ps.setString(3,Fr.getTel1());
          
          ps.setString(4,Fr.getTel2());
          
          ps.setString(5,Fr.getFax1());
          
          ps.setString(6,Fr.getFax2());
          
          ps.setString(7,Fr.getAdresse());
          
          ps.setString(8,Fr.getIdFr());
          
          ps.executeUpdate();
          
          
          
          
          
          
     JLabel message = new JLabel("    Modification a été avec Succée        ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Inform&tion Message" ,JOptionPane.INFORMATION_MESSAGE);
        
               
               
          
          
          
          
          
          
          
          
          
    return  Fr;      
          
          
          
    }catch(Exception  e){
        
            
     JLabel message = new JLabel(""+e+"      ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0, 14));  
     JOptionPane.showMessageDialog(null, message," Message Erreur",JOptionPane.WARNING_MESSAGE,new ImageIcon("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\FFFFF.png"));
   
    
                  
        
       return null;
        
    }     
        
     
        
        
        
        
        
        
        
        
        
   } else{
       JLabel message = new JLabel("    Id Fournisseur n'exsite pas        ");
  
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur" ,JOptionPane.ERROR_MESSAGE,new ImageIcon("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\FFFFF.png"));
    
     
     return  null;
       
        
        
        
        
        
        
        
        
    }  
       
       
       
       
       
       
       
       
       
       
   }
   
    /**
     *
     * @param IdFr
     * @return
     */
    public  static Fournisseur  RechIdFr(String IdFr){
       
       IdFr=IdFr+"%";

        try {
            
            
            
            rst=stm.executeQuery("select  *  from   fr where IdFr like '"+IdFr+"'  ;");
            boolean  test=rst.next();
            if(test){
       
                     fr=new Fournisseur(rst.getString("IdFr"),rst.getString("NomFr"),rst.getString("CategFr"),
                     rst.getString("Tel1Fr"),rst.getString("Tel2Fr"),rst.getString("Fax1Fr"),
                     rst.getString("Fax2Fr"),rst.getString("AdrFr"));
                     return   fr;
           }else{
               
              return null;
               
           }
        } catch (SQLException ex) {
             System.out.println("Erreur Inside RecherIdFr cause :"+ex);      
              return null;
        }
   
   } 

    /**
     *
     * @param NomFr
     * @return
     */
    public  static ArrayList    RechNomFr(String NomFr){
      ArrayList  <Fournisseur>   list_frs=new ArrayList<>();
      NomFr=NomFr+"%";
        try {
          
            rst=stm.executeQuery("select  *  from   fr where NomFr like '"+NomFr+"'  ;");
            if(rst.next()){
            rst=stm.executeQuery("select  *  from   fr where NomFr  like '"+NomFr+"'  ;");

            while (rst.next()) {
          
                     fr=new Fournisseur(rst.getString("IdFr"),rst.getString("NomFr"),rst.getString("CategFr"),
                     rst.getString("Tel1Fr"),rst.getString("Tel2Fr"),rst.getString("Fax1Fr"),
                     rst.getString("Fax2Fr"),rst.getString("AdrFr"));      
                
                
                list_frs.add(fr);
            }
            return  list_frs;
            }else {
                return null;
            }   
            
        } catch (SQLException ex) {
             System.out.println("Erreur Inside RecherIdFr cause :"+ex);      
              return null;
        }
   
       
       
       
       
       
       
       
       
   }  

    /**
     *
     * @return
     */
    public  static ArrayList    RechToutesFr(){
   

        ArrayList  <Fournisseur>   list_toutes=new ArrayList<>();
        Fournisseur   fr = new Fournisseur();
        try {
            ps=con.prepareStatement("select  *  from   fr ");
            rst=ps.executeQuery();
            if(rst.next()){
            rst=ps.executeQuery();

            while (rst.next()) {
          
                     fr=new Fournisseur(rst.getString("IdFr"),rst.getString("NomFr"),rst.getString("CategFr"),
                     rst.getString("Tel1Fr"),rst.getString("Tel2Fr"),rst.getString("Fax1Fr"),
                     rst.getString("Fax2Fr"),rst.getString("AdrFr"));      
               
                     
                
                list_toutes.add(fr);
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

    /**
     *
     * @param CategFr
     * @return
     */
    public  static ArrayList    RechCategFr(String   CategFr){
       
  
        CategFr=CategFr+"%";
        ArrayList  <Fournisseur>   list_categ=new ArrayList<>();
        
        
        try {
            
            rst=stm.executeQuery("select  *  from   fr where CategFr like '"+CategFr+"'  ;");
            if(rst.next()){
            rst=stm.executeQuery("select  *  from   fr where CategFr like '"+CategFr+"'  ;");

            while (rst.next()) {
          
                     fr=new Fournisseur(rst.getString("IdFr"),rst.getString("NomFr"),rst.getString("CategFr"),
                     rst.getString("Tel1Fr"),rst.getString("Tel2Fr"),rst.getString("Fax1Fr"),
                     rst.getString("Fax2Fr"),rst.getString("AdrFr"));      
                
                
                list_categ.add(fr);
            }
            return  list_categ;
            }else {
                return null;
            }   
            
        } catch (SQLException ex) {
             System.out.println("Erreur Inside RecherIdFr cause :"+ex);      
              return null;
        } 
       
       
       
       
       
       
       
       
       
       
       
   }
   
   
   
   
   
   
   
   
   
   
   

   
   
   
   
   




    
    
}
