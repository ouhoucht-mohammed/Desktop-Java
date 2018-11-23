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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author HP
 */
public class FactFrPdt  extends Connect{
    


    private static  Connection con;
    private static  Statement  stm;
    
    
    public static ResultSet  rst=null;
    public static PreparedStatement  ps;
 
    
    
    
    private String IdFactFr;
    private String IdPdt;
    private double QteAchatPdt;
    private double  PrxAchatPdt;
        
    
    
    public   FactFrPdt(){
        
        
 try {
             con=Connect.getInstance();
             stm=con.createStatement();
          
          } catch (Exception e) {
          }
     
        
    }
      
    public   FactFrPdt(String IdFactFr,String IdPdt,double QteAchatPdt,double PrxAchatPdt){
        
       this.IdFactFr=IdFactFr;
       this.IdPdt=IdPdt;
       this.QteAchatPdt=QteAchatPdt;
       this.PrxAchatPdt=PrxAchatPdt;
       
      
 try {
             con=Connect.getInstance();
             stm=con.createStatement();
          
          } catch (Exception e) {
          }
        
        
    } 
    
        
        
    
    

    public void setIdFactFr(String IdFactFr) {
        this.IdFactFr = IdFactFr;
    }

    public void setIdPdt(String IdPdt) {
        this.IdPdt = IdPdt;
    }

    public void setQteAchatPdt(double QteAchatPdt) {
        this.QteAchatPdt = QteAchatPdt;
    }

    public void setPrxAchatPdt(double PrxAchatPdt) {
        this.PrxAchatPdt = PrxAchatPdt;
    }

    public String getIdFactFr() {
        return IdFactFr;
    }

    public String getIdPdt() {
        return IdPdt;
    }

    public double getQteAchatPdt() {
        return QteAchatPdt;
    }

    public double getPrxAchatPdt() {
        return PrxAchatPdt;
    }
    
    
    
    
    
    

   
   
   public  static ArrayList<Double>   RechPrxAchatPdtFr (String  IdPdt, String IdFr){
    
    if(RechIdPdtFrPdt(IdPdt)!=null){
     ArrayList<FactFrPdt>  list =RechIdPdtFrPdt(IdPdt);
     ArrayList<Double>  list_prix =new ArrayList<>();
     Fact     factfr =  new Fact();
     for(FactFrPdt  elt : list){
         
       if(factfr.Rechidfact(elt.getIdFactFr()).getIdFr().equals(IdFr)){
           
           
           
           list_prix.add(elt.getPrxAchatPdt());
           
           
      
         
         
         
     }
     }





return   list_prix;






    }else{
        
        return null;
    }
    
    
    }
   public   double    RechPrxAchatPdtFactFr  (String IdFactFr,  String IdPdt){
       
       
   if(RechIdPdtIdFactFr(IdFactFr, IdPdt)!=null){
       
      return   RechIdPdtIdFactFr(IdFactFr, IdPdt).getPrxAchatPdt();
       
       
   }else{
       return 0;
   }  
       
       
       
       
       
       
       
       
       
       
   }
   public   static ArrayList  <FactFrPdt>    RechToutesFactFrPdt (){
       
     ArrayList  <FactFrPdt>   list = new ArrayList<>();
     FactFrPdt    factfrpdt;
            try {
          
            rst=stm.executeQuery("select  *  from   factfrpdt ; ");
            if(rst.next()){
            rst=stm.executeQuery("select  *  from   factfrpdt  ;");

            while (rst.next()) {
          
       factfrpdt=new FactFrPdt(rst.getString("IdFactFr"),rst.getString("IdPdt"),rst.getDouble("QteAchatPdt"),rst.getDouble("PrxAchatPdt"));      
                
                
                list.add(factfrpdt);
            }
            return  list;
            
            
            
            }else {
                return null;
            }   
            
        } catch (SQLException ex) {
               
               
                    
     JLabel message = new JLabel(""+ex+"      ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0, 14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur",JOptionPane.WARNING_MESSAGE,new ImageIcon("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\FFFFF.png"));
   
    
            
    return null;
                
               
               
               
               
               
               
               
           }    
        
        
        
        
        
        
        
        
    }
   public   static ArrayList<FactFrPdt>  RechIdPdtFrPdt (String  IdPdt)  {
       

       ArrayList  <FactFrPdt>   list_pdt=new ArrayList<>();
       FactFrPdt   factfrpdt;
       IdPdt=IdPdt+"%";
        try {
          
            rst=stm.executeQuery("select  *  from   factfrpdt where idpdt  like '"+IdPdt+"'  ;");
            if(rst.next()){
            rst=stm.executeQuery("select  *  from   factfrpdt where idpdt like '"+IdPdt+"'  ;");

            while (rst.next()) {
          
       factfrpdt=new FactFrPdt(rst.getString("IdFactFr"),rst.getString("IdPdt"),rst.getDouble("QteAchatPdt"),rst.getDouble("PrxAchatPdt"));      
                
                
                list_pdt.add(factfrpdt);
            }
            return  list_pdt;
            }else {
                return null;
            }   
            
        } catch (SQLException ex) {
                          
     JLabel message = new JLabel(""+ex+"      ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0, 14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur",JOptionPane.WARNING_MESSAGE,new ImageIcon("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\FFFFF.png"));
   
    
            
    return null;
                
               
        }
   
         
    }
   public   double    RechQteFactFr (String IdFactFr,  String IdPdt){
       
       
   if(RechIdPdtIdFactFr(IdFactFr, IdPdt)!=null){
       
      return   RechIdPdtIdFactFr(IdFactFr, IdPdt).getQteAchatPdt();
       
       
   }else{
       
     JLabel message = new JLabel("« IdPdt et IdFactFr  inexistants   ");
     message.setFont(new Font("Times New Roman ",0,12));
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     JOptionPane.showMessageDialog(null, message," Message d'Information ",JOptionPane.INFORMATION_MESSAGE);
          
       
       
       
       return 0.00;
   }  
       
       
       
       
       
       
       
       
       
       
   }    
   public   static ArrayList<FactFrPdt>   RechIdFactFrPdt (String  IdFactFr){
         
       ArrayList  <FactFrPdt>  liste=new ArrayList<>();
       FactFrPdt   factfrpdt;
       IdFactFr=IdFactFr+"%";
       
        try {
          
            rst=stm.executeQuery("select  *  from   factfrpdt where IdFactFr like '"+IdFactFr+"'  ;");
            if(rst.next()){
            rst=stm.executeQuery("select  *  from   factfrpdt where IdFactFr like '"+IdFactFr+"'  ;");

            while (rst.next()) {
          
       factfrpdt=new FactFrPdt(rst.getString("IdFactFr"),rst.getString("IdPdt"),rst.getDouble("QteAchatPdt"),rst.getDouble("PrxAchatPdt"));      
                
                
                liste.add(factfrpdt);
            }
            return  liste;
            }else {
                return null;
            }   
            
        } catch (SQLException ex) {
                          
     JLabel message = new JLabel(""+ex+"      ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0, 14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur",JOptionPane.WARNING_MESSAGE,new ImageIcon("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\FFFFF.png"));
   
    
            
    return null;
                
               
        }
   
       
       
               
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
     }
   public  static FactFrPdt  RechIdPdtIdFactFr(String IdFactFr,String IdPdt){
       
  
           try {
               
            rst= stm.executeQuery("select  * from    factfrpdt  where  IdPdt like  '"+IdPdt+"' and IdFactFr like '"+IdFactFr+"' ;");
               
               
              
            boolean  test=rst.next();
            if(test){
                  
                    
    
                    return  new FactFrPdt(rst.getString("IdFactFr"),rst.getString("IdPdt"),rst.getDouble("QteAchatPdt"),rst.getDouble("PrxAchatPdt"));
                   
           }else{
      
              return null;
               
           }
                   
      
               
               
               
           } catch (SQLException ex) {
               
               
                    
     JLabel message = new JLabel(""+ex+"      ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0, 14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur",JOptionPane.WARNING_MESSAGE,new ImageIcon("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\FFFFF.png"));
   
    
            
    return null;
                
               
        }
        
     
     
       
       
   }
   public  static String [][]  RechPrxAchatPdt (String   IdPdt)  {
      
      
         
  
       if(RechIdPdtFrPdt(IdPdt)!=null){
    
       ArrayList<FactFrPdt>  list_factfrpdt=RechIdPdtFrPdt(IdPdt);
       int   size= list_factfrpdt.size();
       String table [][]=new  String[size][3];
       Fact  factfr =  new Fact();
       int   ligne=0;
       
       
      
       
       for(FactFrPdt   factfrpdt : list_factfrpdt){
     
        table[ligne][0]=factfrpdt.getIdFactFr();
        table[ligne][1]=factfrpdt.getPrxAchatPdt()+"";
        table[ligne][2]=factfr.Rechidfact(factfrpdt.getIdFactFr()).getDate_t();

            ligne++;
            
        }           
           
           
           
           
       

    return    table;
















       }else{
           
           
           return null;
       }
      
      
      
      
      
      
      
      
      
      
  }    
 
    
    
   
   
   
   
   
   
   
   
   
   
   
   
   
   public FactFrPdt AjoutFactFrPdt(FactFrPdt   factfrpdt) {
       Produit   pdt = new Produit();
       Fact   factfr = new Fact();
        
   if(RechIdPdtIdFactFr(factfrpdt.getIdFactFr(),factfrpdt.getIdPdt() )!=null ){
         
    
     JLabel message = new JLabel(" IdFactFr et IdPdt existe déja, Changer  IdPdt ou/et IdFactFr   ");
     JLabel title = new JLabel("Message Information !");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12));    
     JOptionPane.showMessageDialog(null, message.getText(),title.getText(),JOptionPane.INFORMATION_MESSAGE);
       
       
       
       
       
       
       
       return null;
   }
   
   
   else  if(pdt.RechIdPdt(factfrpdt.getIdPdt())==null){
          
     JLabel message = new JLabel("IdPdt n'existe pas, Changer  IdPdt  ");
     JLabel title = new JLabel("Message Information !");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12));    
     JOptionPane.showMessageDialog(null, message.getText(),title.getText(),JOptionPane.INFORMATION_MESSAGE);
       
       
           return null;
           
      }  else if(  factfr.Rechidfact(factfrpdt.getIdFactFr())==null ){
          
     JLabel message = new JLabel("IdFactFrPdt n'existe pas, Changer  IdFactFrPdt  ");
     JLabel title = new JLabel("Message Information !");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12));    
     JOptionPane.showMessageDialog(null, message.getText(),title.getText(),JOptionPane.INFORMATION_MESSAGE);
          
    return  null;
         
     }else{
     
    
           try {
               ps=con.prepareStatement("insert into   factfrpdt(IdFactFr,IdPdt,QteAchatPdt,PrxAchatPdt)   values(?,?,?,?)  ;");
               ps.setString(1,factfrpdt.getIdFactFr());
               ps.setString(2,factfrpdt.getIdPdt());
               ps.setDouble(3,factfrpdt.getQteAchatPdt());
               ps.setDouble(4,factfrpdt.getPrxAchatPdt());

               ps.executeUpdate();
                   
     JLabel message = new JLabel("Operation  a été avec Succée   ");
     JLabel title = new JLabel("Message Information !");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     JOptionPane.showMessageDialog(null, message.getText(),title.getText(),JOptionPane.INFORMATION_MESSAGE);
     return  factfrpdt;     
               
               
               
    }catch (SQLException ex) {
     JLabel message = new JLabel(""+ex+"      ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0, 14));  
     JOptionPane.showMessageDialog(null, message,"Message Erreur",JOptionPane.WARNING_MESSAGE,new ImageIcon("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\FFFFF.png"));
     return null;}
                
               
         }

         
    
   
   
   }
   public    boolean   SuppFactFrPdt (String IdFactFr,String IdPdt) {
      
      
      
  if(RechIdPdtIdFactFr(IdFactFr, IdPdt)!=null){
      
    try {
          ps=con.prepareStatement("delete   from   factfrpdt where  idfactfr = ? and   idpdt=? ;");
          ps.setString(1,IdFactFr);
          ps.setString(2,IdPdt);

          ps.executeUpdate();
          
          
          
     JLabel message = new JLabel("Operation  a été avec Succée   ");
     message.setFont(new Font("Times New Roman ",0,12));
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     JOptionPane.showMessageDialog(null, message," Message d'Information ",JOptionPane.INFORMATION_MESSAGE);
       
          
          
          
          
          
          
          
          
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
      
  
    
     JLabel message = new JLabel(" Veuillez  Changer  IdPdt ou/et IdFactFr  ?  ");
     JLabel title = new JLabel("Message Information !");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
    if(JOptionPane.showConfirmDialog(null, message,title.getText(),JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
        
  String idfactfr;
  String idpdt;
   do{
     idfactfr=JOptionPane.showInputDialog(null, "Entrez Identifiant  de la facture du Fournisseur");
     idpdt=JOptionPane.showInputDialog(null, "Entrez Identifiant  du Produit");
   
   }while(idfactfr.isEmpty() && idpdt.isEmpty());
    


return    SuppFactFrPdt(idfactfr, idpdt);

      
  }else{
        return false;
    }    
      
      
      
      
      
      
      
      
      
  }    
      
}
   public   FactFrPdt  ModifFactFrPdt (FactFrPdt factfrpdt ) {
    
    
    if(RechIdPdtIdFactFr(factfrpdt.getIdFactFr(), factfrpdt.getIdPdt())!=null){
        
      
    try {
          ps=con.prepareStatement("Update     factfrpdt  set  QteAchatPdt=?,PrxAchatPdt=?  where  IdFactFr=? and IdPdt=? ;");
          ps.setDouble(1,factfrpdt.getQteAchatPdt());
          ps.setDouble(2,factfrpdt.getPrxAchatPdt());
          ps.setString(3,factfrpdt.getIdFactFr());
          ps.setString(4,factfrpdt.getIdPdt());
          
         ps.executeUpdate();
         
     JLabel message = new JLabel("    Modification a été avec Succée        ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0 ,14));  
     JOptionPane.showMessageDialog(null, message,"Inform&tion Message" ,JOptionPane.INFORMATION_MESSAGE,null);
                
        return factfrpdt;      
          
          
          
    }catch(Exception  e){
        
            
     JLabel message = new JLabel(""+e+"      ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0, 14));  
     JOptionPane.showMessageDialog(null, message," Message d'information",JOptionPane.INFORMATION_MESSAGE);
   
     
     
     
     

     
     
     
     return null;
     
     
     
     
        
    }     
          
        
        
        
        
        
    }else{
        
        
     JLabel message = new JLabel("« IdPdt et IdFactPdt  inexistants     ");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0, 14));  
     JOptionPane.showMessageDialog(null, message," Message d'information",JOptionPane.WARNING_MESSAGE);
   
        
        
         
     
        
        return  null;
    }
    
    
    
    
    
    
    
    
}  


    
    
    
    
    
    
    
    
    
}
