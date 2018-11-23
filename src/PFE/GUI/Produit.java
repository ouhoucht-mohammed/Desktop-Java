/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PFE.GUI;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Produit  extends Connect{
    
    
    
    
    private static  Connection con;
    private static  Statement  stm;
    
    
    public static ResultSet  rst=null;
    public static PreparedStatement  ps;
 
      
    
    
    
    
    
    
    
    
    
    
private String IdPdt ;
private String DesigPdt ;
private String  PropPdt ;
private  double  QteDispPdt;
private String   EmplcStock1Pdt ;
private String   EmplcStock2Pdt ;
private double  PrxVenteDetailPdt;
private double   PrxVenteGrosPdt ;
private   Date DateExpPdt;
private String PhotoPdt;

    













   
   
   

public  Produit   RechIdPdt (String Pdt){


    
    try{
        PreparedStatement ps =con.prepareStatement("select * from pdt where IdPdt = ?");
        ps.setString(1,Pdt);
        rst=ps.executeQuery();
        
        if(rst.next()==true){
        return  new Produit(rst.getString("IdPdt"),rst.getString("DesigPdt"),
                rst.getString("PropPdt"),rst.getDouble("QteDispPdt"), 
                rst.getString("EmplcStock1Pdt"), rst.getString("EmplcStock2Pdt"),
                rst.getDouble("PrxVenteDetailPdt"),rst.getDouble("PrxVenteGrosPdt"),
                rst.getDate("DateExpPdt") ,rst.getString("PhotoPdt"));
  
         
        }else 
            
        return null;
        
    }catch(SQLException e){
     e.printStackTrace();
     return null ;}  
    
} 

public ArrayList<Produit> RechToutesPdt(){
    ArrayList <Produit>  list = null;
    try {
        PreparedStatement ps =con.prepareStatement("select * from pdt ");
      rst=ps.executeQuery();
      while(rst.next()) {
          
          
          
          
          
     list.add(new Produit(rst.getString("IdPdt"),
             rst.getString("DesigPdt"), rst.getString("PropPdt"),
             rst.getDouble("QteDispPdt"), rst.getString("EmplcStock1Pdt"),
             rst.getString("EmplcStock2Pdt"), rst.getDouble("PrxVenteDetailPdt"),
             rst.getDouble("PrxVenteGrosPdt"),rst.getDate("DateExpPdt") ,
             rst.getString("PhotoPdt")));
          
          
          
      } 
        
        
     return   list;   
        
        
    } catch (SQLException ex) {
        ex.printStackTrace();
        return null;
    }
   
    
    
    
    
}


public  ArrayList<Produit>  RechDesigPdt(String DesigPdt){
 ArrayList <Produit>  list = null;
  
    try {
        
      PreparedStatement ps =con.prepareStatement("select * from pdt  where  DesigPdt=?");
      ps.setString(1, DesigPdt);
      rst=ps.executeQuery();
      while(rst.next()) {
     list.add(new Produit(rst.getString("IdPdt"),
             rst.getString("DesigPdt"), rst.getString("PropPdt"),
             rst.getDouble("QteDispPdt"), rst.getString("EmplcStock1Pdt"),
             rst.getString("EmplcStock2Pdt"), rst.getDouble("PrxVenteDetailPdt"),
             rst.getDouble("PrxVenteGrosPdt"),rst.getDate("DateExpPdt") ,
             rst.getString("PhotoPdt")));
          
          
          
      } 
          
        return  list;
        
        
        
        
        
        
        
        
        
        
        
        
    } catch (Exception e) {
        e.printStackTrace();
        return null;
        
        
        
    }
   
    
    
    
    
    
    
}






































    public void setPdt(String Pdt) {
        this.IdPdt = Pdt;
    }

    public void setDesigPdt(String DesigPdt) {
        this.DesigPdt = DesigPdt;
    }

    public void setPropPdt(String PropPdt) {
        this.PropPdt = PropPdt;
    }

    public void setQteDispPdt(double QteDispPdt) {
        this.QteDispPdt = QteDispPdt;
    }

    public void setEmplcStock1Pdt(String EmplcStock1Pdt) {
        this.EmplcStock1Pdt = EmplcStock1Pdt;
    }

    public void setEmplcStock2Pdt(String EmplcStock2Pdt) {
        this.EmplcStock2Pdt = EmplcStock2Pdt;
    }

    public void setPrxVenteDetailPdt(double PrxVenteDetailPdt) {
        this.PrxVenteDetailPdt = PrxVenteDetailPdt;
    }

    public void setPrxVenteGrosPdt(double PrxVenteGrosPdt) {
        this.PrxVenteGrosPdt = PrxVenteGrosPdt;
    }

    public void setDateExpPdt(Date DateExpPdt) {
        this.DateExpPdt = DateExpPdt;
    }

    public void setPhotoPdt(String PhotoPdt) {
        this.PhotoPdt = PhotoPdt;
    }

    

    public void setCon(Connection con) {
        this.con = con;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

    public void setRst(ResultSet rst) {
        this.rst = rst;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }








    public String getPdt() {
        return IdPdt;
    }

    public String getDesigPdt() {
        return DesigPdt;
    }

    public String getPropPdt() {
        return PropPdt;
    }

    public double getQteDispPdt() {
        return QteDispPdt;
    }

    public String getEmplcStock1Pdt() {
        return EmplcStock1Pdt;
    }

    public String getEmplcStock2Pdt() {
        return EmplcStock2Pdt;
    }

    public double getPrxVenteDetailPdt() {
        return PrxVenteDetailPdt;
    }

    public double getPrxVenteGrosPdt() {
        return PrxVenteGrosPdt;
    }

    public Date getDateExpPdt() {
        return DateExpPdt;
    }

    public String getPhotoPdt() {
        return PhotoPdt;
    }



















public   Produit( String Pdt ,String DesigPdt,String  PropPdt ,double  QteDispPdt,String   EmplcStock1Pdt ,String   EmplcStock2Pdt ,double  PrxVenteDetailPdt,double   PrxVenteGrosPdt ,Date DateExpPdt,String PhotoPdt){
this.IdPdt=Pdt;
this.DesigPdt =DesigPdt;
this.PropPdt=PropPdt;
this.QteDispPdt=QteDispPdt;
this.EmplcStock1Pdt=EmplcStock1Pdt;
this.EmplcStock2Pdt  =EmplcStock2Pdt;
this.PrxVenteDetailPdt=PrxVenteDetailPdt;
this.PrxVenteGrosPdt=PrxVenteGrosPdt;
this.DateExpPdt =DateExpPdt;
this.PhotoPdt=PhotoPdt;   

 try {
             con=Connect.getInstance();
             stm=con.createStatement();
          
          } catch (Exception e) {
          }

}

    public Produit(  ) {
        
 try {
             con=Connect.getInstance();
             stm=con.createStatement();
          
          } catch (Exception e) {
          }
            }

    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
