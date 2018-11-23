/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PFE.GUI;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author MOHAMED
 */
public class rech_prix_achat_pdt extends javax.swing.JFrame {

    /**
     * Creates new form rech_prix_achat_pdt
     */
    private DefaultTableModel   model ;
    private FactFrPdt factfrpdt  = new FactFrPdt();
    private    Object[] row1_2 = new Object[3];
    private  int tr=0;
    public rech_prix_achat_pdt() {
        
        
        initComponents();
         model=(DefaultTableModel)  tab.getModel();
         txt_lb_idpdt_btn1_2.setBorder(BorderFactory.createLineBorder(new Color(45,18,232)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_idpdt_btn1_2 = new javax.swing.JLabel();
        txt_lb_idpdt_btn1_2 = new javax.swing.JTextField();
        Rechercher_btn1_2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        pdf = new javax.swing.JButton();
        excel = new javax.swing.JButton();
        Fermer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_idpdt_btn1_2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_idpdt_btn1_2.setText("Identifiant du produit : ");
        getContentPane().add(lb_idpdt_btn1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 180, 40));

        txt_lb_idpdt_btn1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lb_idpdt_btn1_2ActionPerformed(evt);
            }
        });
        getContentPane().add(txt_lb_idpdt_btn1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 300, 30));

        Rechercher_btn1_2.setText("Rechercher");
        Rechercher_btn1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rechercher_btn1_2ActionPerformed(evt);
            }
        });
        getContentPane().add(Rechercher_btn1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 110, 30));

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identifiant de la Facture", "Prix d'achat", "Date de La Facture"
            }
        ));
        jScrollPane1.setViewportView(tab);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 140, 890, 190));

        pdf.setText("PDF");
        pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfActionPerformed(evt);
            }
        });
        getContentPane().add(pdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 190, 80, 30));

        excel.setText("EXCEL");
        excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelActionPerformed(evt);
            }
        });
        getContentPane().add(excel, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 240, 80, 30));

        Fermer.setText("Fermer");
        Fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FermerActionPerformed(evt);
            }
        });
        getContentPane().add(Fermer, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 130, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PFE/GUI/background.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 499));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelActionPerformed
        // TODO add your handling code here:
        
     if(model.getRowCount()>=1){
    try {

 File selectedFile=null;       
JFileChooser fileChooser = new JFileChooser();
fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
fileChooser.showOpenDialog(null);
selectedFile = fileChooser.getSelectedFile();
if(selectedFile!=null){
    

 String  file=selectedFile.getAbsolutePath();
if(!selectedFile.getAbsolutePath().endsWith(".xls")){
 file=selectedFile.getAbsolutePath()+".xls";  
}
  
    WritableWorkbook workbook = Workbook.createWorkbook(new File(file));
    WritableSheet writablesheet1 = workbook.createSheet("Sheet1", 0);
    WritableFont times10pt = new WritableFont(WritableFont.TIMES, 12,WritableFont.BOLD);
    WritableFont times12pt = new WritableFont(WritableFont.TIMES, 11);
     int  rows =5;
   // Define the cell format
   WritableCellFormat  times = new WritableCellFormat(times10pt);
   WritableCellFormat  times2 = new WritableCellFormat(times12pt);
   times.setBorder(jxl.format.Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
   times2.setBorder(jxl.format.Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
   times.setBackground(Colour.WHITE);
   times.setAlignment(Alignment.CENTRE);
   times.setVerticalAlignment(VerticalAlignment.CENTRE);
   
    times2.setAlignment(Alignment.CENTRE);
    times2.setVerticalAlignment(VerticalAlignment.CENTRE);
   WritableCellFormat cellFormat = new WritableCellFormat(times);
   cellFormat.setBackground(Colour.YELLOW);
   cellFormat.setBorder(jxl.format.Border.ALL, BorderLineStyle.THIN);
   // Lets automatically wrap the cells
   // Create create a bold font with unterlines
   
   // Lets automatically wrap the cells
   Label label;
   Produit  pdt = new Produit();
   label = new Label(2, 0, "           Stock  Super Marché  ", new WritableCellFormat(new WritableFont(
   WritableFont.TIMES, 16, WritableFont.BOLD)));
   writablesheet1.addCell(label);
  
   
   label = new Label(0, 1, "Identifiant du Produit   :   "+txt_lb_idpdt_btn1_2.getText(), new WritableCellFormat(new WritableFont(
   WritableFont.TIMES, 12, WritableFont.BOLD)));
   writablesheet1.addCell(label);
  
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   label = new Label(2, 2, "Les Prix d'achat Du  Produit  "+pdt.RechIdPdt(txt_lb_idpdt_btn1_2.getText()).getDesigPdt(), new WritableCellFormat(new WritableFont(
   WritableFont.TIMES, 12, WritableFont.BOLD)));
   writablesheet1.addCell(label);
    
   writablesheet1.setRowView(4, 26*24);
   writablesheet1.setColumnView(1,35);
   Label label1 = new Label(1,4,"Identifiant de la Facture",cellFormat);
   writablesheet1.setColumnView(2, 35);
   Label label2 = new Label(2,4,"Prix  d'achat ",cellFormat);
   writablesheet1.setColumnView(3, 35);
   Label label3 = new Label(3,4,"Date   d'achat ",cellFormat);
    
   
   
   
    
    writablesheet1.addCell(label1);
    writablesheet1.addCell(label2);
    writablesheet1.addCell(label3);
 
    
    
        
        
  
          
    String  tab[][]=factfrpdt.RechPrxAchatPdt(txt_lb_idpdt_btn1_2.getText());
    
    for(int  i=0;i<tab.length;i++){   
        
        
     writablesheet1.setColumnView(0,30); 
     writablesheet1.addCell(new Label(1,rows,tab[i][0],times2));
     
     writablesheet1.setColumnView(1,30);
     writablesheet1.addCell(new Label(2,rows,tab[i][1],times2));
     
     
     
     
     writablesheet1.setColumnView(2,30);
     writablesheet1.addCell(new Label(3,rows,tab[i][2],times2));        
        
        
        
        
      rows++;  
        
        
        
        
    }
  
         JOptionPane.showMessageDialog(null, "Excel a éte enregistrer  ","Message Information",JOptionPane.INFORMATION_MESSAGE);

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     
    workbook.write();
    workbook.close();
    
}}  
    
catch (WriteException e) {JOptionPane.showMessageDialog(null, e);}
catch (IOException ex) {}        
                         
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
             }
    }//GEN-LAST:event_excelActionPerformed

    private void FermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FermerActionPerformed
      this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_FermerActionPerformed

    private void Rechercher_btn1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rechercher_btn1_2ActionPerformed
        // TODO add your handling code here:
        
        
 if(txt_lb_idpdt_btn1_2.getText().isEmpty() ){txt_lb_idpdt_btn1_2.setBorder(BorderFactory.createLineBorder(Color.RED));} 
                     
if(!txt_lb_idpdt_btn1_2.getText().isEmpty() ){
 txt_lb_idpdt_btn1_2.setBorder(BorderFactory.createLineBorder(new Color(45,18,232)));




    AffichPrxAchatPdt(txt_lb_idpdt_btn1_2.getText());





}
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_Rechercher_btn1_2ActionPerformed

    private void pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfActionPerformed
        // TODO add your handling code here:
        
              
     if(model.getRowCount()>=1){             
         try {
  Document document = new Document();
  
  
JFileChooser fileChooser = new JFileChooser();
fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
fileChooser.showOpenDialog(null);
File selectedFile = fileChooser.getSelectedFile();
String  file=selectedFile.getAbsolutePath();
if(!selectedFile.getAbsolutePath().endsWith(".pdf")){
 file=selectedFile.getAbsolutePath()+".pdf";  
}
  
  
 
  PdfWriter.getInstance(document, new FileOutputStream(file));
  document.open();
   float fntSize, lineSpacing;
   fntSize = 10.0f;
  lineSpacing = 20.8f;
  Produit  pdt  = new Produit();
  Image   image=Image.getInstance("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\logo_4.png");
  image.setWidthPercentage(100);
  image.setAlignment(Element.ALIGN_LEFT);
  document.add(image);
  Produit  p = new Produit();

   Paragraph   My =  new Paragraph("\nIdentifiant Produit :   "+txt_lb_idpdt_btn1_2.getText(), new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12));
   My.setAlignment(Element.ALIGN_LEFT);
   document.add(My);

   Paragraph   My2 =  new Paragraph("Les Prix  Du  Produit "+p.RechIdPdt(txt_lb_idpdt_btn1_2.getText()).getDesigPdt(), new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 14));
   My2.setAlignment(Element.ALIGN_CENTER);
   document.add(My2);
  
  
  
  
  
  

  PdfPTable table =  new PdfPTable(3);
  
  table.setWidthPercentage(105);
  table.setHorizontalAlignment(Element.ALIGN_BOTTOM);
  PdfPCell cel1;
  table.setWidths(new float[] { 174,174,173 });
  com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.WHITE);
  com.itextpdf.text.Font font2 = FontFactory.getFont(FontFactory.TIMES_ROMAN, fntSize);

            cel1 = new PdfPCell(new Phrase("Identifiant De La Facture ", font));
            cel1.setFixedHeight(20);
            cel1.setBackgroundColor(BaseColor.GRAY);
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
            cel1 = new PdfPCell(new Phrase("Prix D'Achat", font));
            cel1.setBackgroundColor(BaseColor.GRAY);
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
            
            cel1 = new PdfPCell(new Phrase("Date D'Achat ", font));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setBackgroundColor(BaseColor.GRAY);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
            
    
            
    String  tab[][]=factfrpdt.RechPrxAchatPdt(txt_lb_idpdt_btn1_2.getText());
    for(int  i=0;i<tab.length;i++){        

        
        
            cel1 = new PdfPCell(new Phrase(tab[i][0], font2));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
      
      
      cel1 = new PdfPCell(new Phrase(tab[i][1], font2));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
      cel1 = new PdfPCell(new Phrase(tab[i][2], font2));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
      
      
      
      
      
      
       
    }
                   
          JOptionPane.showMessageDialog(null, "PDF a éte enregistrer  ","Message Information",JOptionPane.INFORMATION_MESSAGE);
        
            
            
            
            
            
            
            
            
            
        
   
   
   

   
   
   
   
    document.add( new Phrase("\n") );
    document.add(table);
    document.add( Chunk.NEWLINE );

 SimpleDateFormat simpleFormatter = new SimpleDateFormat("     dd/MM/yyyy  hh:mm:ss  ");
 String date=simpleFormatter.format(new Date());
 Paragraph  p2 = new Paragraph(date,FontFactory.getFont(FontFactory.TIMES_ROMAN,12));
 p2.setAlignment(Element.ALIGN_RIGHT);
 document.add(p2);

             
     

                    
  
  
  
  
  
  
  
    document.close();

  
  
} catch (Exception e) {
}        
                 
                 
                 
     }               
                 
                 
               
    }//GEN-LAST:event_pdfActionPerformed

    private void txt_lb_idpdt_btn1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lb_idpdt_btn1_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lb_idpdt_btn1_2ActionPerformed

    /**
     * @param IdPdt the command line arguments
     */
    
           public  void AffichPrxAchatPdt (String IdPdt) {
      
    if(tr==0){  
      
      if(factfrpdt.RechIdPdtFrPdt(IdPdt)!=null){
  
          
    String   tab[][]=factfrpdt.RechPrxAchatPdt(IdPdt);      
     int  i;
     int  j;    
   for( i=0;i<tab.length;i++){
  
    for( j=0;j<3;j++){
          
     row1_2[j]=tab[i][j];  
       
       
       
       
      }    
   
    model.addRow(row1_2);
    
       
       
      }
          
          
          
          
          
 
   

            
     }else{
          
    model.setRowCount(0);
    
    
     JLabel message = new JLabel("IdPdt est inexistant ");
     JLabel title = new JLabel("Message Information !");
     UIManager.put("OptionPane.okButtonText", " Oui");
     UIManager.put("OptionPane.buttonFont", new Font("Times New Roman ",0,12)); 
     JOptionPane.showMessageDialog(null, message,title.getText(),JOptionPane.INFORMATION_MESSAGE);
          
      }
      tr=1;    
     return ;
           
 

            
            
            
        }else if(tr==1){
        tr=0;
        model.setRowCount(0);
        AffichPrxAchatPdt(IdPdt);
  
 }      
       
       
       
   }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(rech_prix_achat_pdt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rech_prix_achat_pdt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rech_prix_achat_pdt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rech_prix_achat_pdt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rech_prix_achat_pdt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Fermer;
    private javax.swing.JButton Rechercher_btn1_2;
    private javax.swing.JButton excel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_idpdt_btn1_2;
    private javax.swing.JButton pdf;
    private javax.swing.JTable tab;
    private javax.swing.JTextField txt_lb_idpdt_btn1_2;
    // End of variables declaration//GEN-END:variables
}