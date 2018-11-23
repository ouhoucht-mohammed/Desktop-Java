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
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
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
public class updatefacture extends javax.swing.JFrame {

    /**
     * Creates new form updatefacture
     */
    
    private  static DefaultTableModel mode;
    private static int   tr=0;
    private  static Object[] row = new Object[8];
    private String  IdFactFr;
    private String  IdFr;
    private double   MontantFactFr;
    private String   date_t;
    private String   image;
    private  Fact  fact = new Fact();
    
    
    
    
    public updatefacture() {
        initComponents();
         btn2.setSelected(true);
         saisir.setBorder(BorderFactory.createLineBorder(new Color(76,41,211)));
        
         saisir.setEnabled(false);
         mode=(DefaultTableModel) tab.getModel();
      ( (JTextField)  txt_debut.getDateEditor().getUiComponent()).setBorder(BorderFactory.createLineBorder(new Color(76,41,211)));
      ( (JTextField)  txt_fin.getDateEditor().getUiComponent()).setBorder(BorderFactory.createLineBorder(new Color(76,41,211)));

      
      
      
      btn2.addMouseListener(new MouseAdapter() {
        
        
        
        
        @Override
        public  void  mousePressed(MouseEvent  evt){
            
             txt_debut.setEnabled(true);
              txt_fin.setEnabled(true);

           
             saisir.setBorder(BorderFactory.createLineBorder(new Color(76,41,211)));
              saisir.setEnabled(false);
              saisir.setText("");

        }
});
      btn1.addMouseListener(new MouseAdapter() {
        
        
        
        
        @Override
        public  void  mousePressed(MouseEvent  evt){
            
             saisir.setEnabled(true);
             
             txt_debut.setEnabled(false);
             txt_fin.setEnabled(false);

             
           ((JTextField) txt_fin.getDateEditor().getUiComponent()).setText("");
           ((JTextField) txt_debut.getDateEditor().getUiComponent()).setText("");

           ((JTextField)  txt_debut.getDateEditor().getUiComponent()).setBorder(BorderFactory.createLineBorder(new Color(76,41,211)));
           ((JTextField)  txt_fin.getDateEditor().getUiComponent()).setBorder(BorderFactory.createLineBorder(new Color(76,41,211)));

        }
});
        
       tab.addMouseListener(new MouseAdapter() {
    
    
    
    
    
    
 @Override
 public void mousePressed(MouseEvent e) {

      
      
      
 
     
 
      try {
          
          
        int row = tab.getSelectedRow();
        int col = tab.getSelectedColumn();
        
             
        
        Runtime     rt=Runtime.getRuntime();

        String  url=mode.getValueAt(row, col).toString();
    
        
        
        
        
     
      if(!url.isEmpty()){
      
        rt.exec("rundll32 url.dll,FileProtocolHandler " +url);
      }
        
        
     
         
     }catch(IOException ex) {
     }
        
   
    

        
        
   
    

        
        
        
      }
    });

       tab.getColumn("Photo").setCellRenderer(new DefaultTableCellRenderer(){
   @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
          DefaultTableCellRenderer r =(DefaultTableCellRenderer) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
          if (column==4) {
              r.setForeground(Color.BLACK);
              String a =getText();
              setText("<html><u>"+a+"</u></html>");
          }
          
          
          
          
          return r;
      }      
   });

 
 
 
 
 
 
 
 tab.addMouseMotionListener(new MouseAdapter() {
    public void mouseMoved(MouseEvent e) 
    {
        int cModel = tab.columnAtPoint(e.getPoint());
        int cView = tab.convertColumnIndexToView(cModel);
        if (cView == 4)
        {
        tab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        }
        else
        {
        tab.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        }
    }
});
 
  
        
        
        
        
        
        
        
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choix = new javax.swing.ButtonGroup();
        btn1 = new javax.swing.JRadioButton();
        btn2 = new javax.swing.JRadioButton();
        list_item = new javax.swing.JComboBox<>();
        saisir = new javax.swing.JTextField();
        txt_debut = new com.toedter.calendar.JDateChooser();
        txt_fin = new com.toedter.calendar.JDateChooser();
        lb_date_debut = new javax.swing.JLabel();
        lb_date_fin = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        Supprimer = new javax.swing.JButton();
        Modifier = new javax.swing.JButton();
        Fermer = new javax.swing.JButton();
        pdf = new javax.swing.JButton();
        excel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        choix.add(btn1);
        btn1.setText("Critère de recherche dans la liste ");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        choix.add(btn2);
        btn2.setText("Rechercher par date");
        getContentPane().add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        list_item.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IDFact", "IDFr", "ToutesFact" }));
        getContentPane().add(list_item, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 140, 30));
        getContentPane().add(saisir, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 200, 30));

        txt_debut.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(txt_debut, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 190, 30));

        txt_fin.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(txt_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 200, 30));

        lb_date_debut.setText("Date de début ");
        getContentPane().add(lb_date_debut, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, -1, -1));

        lb_date_fin.setText("Date de fin ");
        getContentPane().add(lb_date_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, -1, -1));

        search.setText("Rechercher");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 130, 30));

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdFact", "IdFr", "Date Fact", "Montant", "Photo"
            }
        ));
        jScrollPane1.setViewportView(tab);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 880, 210));

        Supprimer.setText("Supprimer");
        Supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprimerActionPerformed(evt);
            }
        });
        getContentPane().add(Supprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 90, 30));

        Modifier.setText("Modifier");
        Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierActionPerformed(evt);
            }
        });
        getContentPane().add(Modifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 480, 90, 30));

        Fermer.setText("Fermer");
        Fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FermerActionPerformed(evt);
            }
        });
        getContentPane().add(Fermer, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 480, 90, 30));

        pdf.setText("PDF");
        pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfActionPerformed(evt);
            }
        });
        getContentPane().add(pdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 280, 70, -1));

        excel.setText("EXCEL");
        excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelActionPerformed(evt);
            }
        });
        getContentPane().add(excel, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 350, 70, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PFE/GUI/background.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void FermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FermerActionPerformed
        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_FermerActionPerformed

    private void ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierActionPerformed


int i = tab.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    
            
            setVisible(true);
            IdFactFr=mode.getValueAt(i,0).toString();
            IdFr=mode.getValueAt(i,1).toString();
            date_t=mode.getValueAt(i,2)+"";
            MontantFactFr=(double)mode.getValueAt(i,3);
            image=mode.getValueAt(i,4).toString();
            
            
        if(btn1.isSelected()){
                new ajout_modif_facture_fr(1, IdFactFr, IdFr, MontantFactFr, date_t, image,"btn1",(String) list_item.getSelectedItem(),saisir.getText()).setVisible(true);

        }else{
                new ajout_modif_facture_fr(1, IdFactFr, IdFr, MontantFactFr, date_t, image,"btn2",((JTextField)txt_debut.getDateEditor().getUiComponent()).getText(),((JTextField)txt_fin.getDateEditor().getUiComponent()).getText()).setVisible(true);
        }    
                }
     
    }//GEN-LAST:event_ModifierActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn1ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
         String   choix=(String)list_item.getSelectedItem();
         
         
         
        if(btn1.isSelected()){
            
            if(!saisir.getText().isEmpty()){
                
              saisir.setBorder(BorderFactory.createLineBorder(new Color(76,41,211)));

        
          if(choix.equals("IDFact")){
              Affichidfact(saisir.getText());
          }else if(choix.equals("IDFr")){
              Affichidfr(saisir.getText());

          }    
           
             
         }else if(choix.equals("ToutesFact")){
             saisir.setBorder(BorderFactory.createLineBorder(new Color(76,41,211)));
              saisir.setText("");
              AffichToutesfact();

          }else{
              mode.setRowCount(0);
              saisir.setBorder(BorderFactory.createLineBorder(Color.RED));
         }
        
        
        
        }
        
        if(btn2.isSelected()){
   int   Var=0;
   
        
   if(!( (JTextField)  txt_debut.getDateEditor().getUiComponent()).getText().isEmpty() && ((JTextField)  txt_debut.getDateEditor().getUiComponent()).getText().matches("\\d{4}-\\d{2}-\\d{2}")){
         ((JTextField)  txt_debut.getDateEditor().getUiComponent()).setBorder(BorderFactory.createLineBorder(new Color(76,41,211)));}
   
  
        
   if(!( (JTextField)  txt_fin.getDateEditor().getUiComponent()).getText().isEmpty() && ((JTextField)  txt_fin.getDateEditor().getUiComponent()).getText().matches("\\d{4}-\\d{2}-\\d{2}")){
       ((JTextField)  txt_fin.getDateEditor().getUiComponent()).setBorder(BorderFactory.createLineBorder(new Color(76,41,211)));}
   
  
   
   
   
   
   
   
   if(( (JTextField)  txt_debut.getDateEditor().getUiComponent()).getText().isEmpty() || !((JTextField)  txt_debut.getDateEditor().getUiComponent()).getText().matches("\\d{4}-\\d{2}-\\d{2}")   ){
   ( (JTextField)  txt_debut.getDateEditor().getUiComponent()).setBorder(BorderFactory.createLineBorder(Color.red));
    Var=1;}
    if(( (JTextField)  txt_fin.getDateEditor().getUiComponent()).getText().isEmpty() || !((JTextField)  txt_fin.getDateEditor().getUiComponent()).getText().matches("\\d{4}-\\d{2}-\\d{2}")   ){
   ( (JTextField)  txt_fin.getDateEditor().getUiComponent()).setBorder(BorderFactory.createLineBorder(Color.red));
    Var=1;}
    

   
   
   
   
   
   
   
   
   
  
if(Var==1){
    mode.setRowCount(0);
    
    return;
}
             
         
         
String   datdebu=((JTextField)  txt_debut.getDateEditor().getUiComponent()).getText();         
String   datfin=((JTextField)  txt_fin.getDateEditor().getUiComponent()).getText();    



















String tab_Debut[]=datdebu.split("-");
String tab_Fin[]=datfin.split("-");

 if(Integer.parseInt(tab_Debut[0])>Integer.parseInt(tab_Fin[0])){
   ((JTextField)  txt_debut.getDateEditor().getUiComponent()).setBorder(BorderFactory.createLineBorder(Color.red));  
   mode.setRowCount(0);
   
  return ;
   
 }else  if(Integer.parseInt(tab_Debut[0])==Integer.parseInt(tab_Fin[0])){
     
   if(Integer.parseInt(tab_Debut[1])>Integer.parseInt(tab_Fin[1])) {
       
   ((JTextField)  txt_debut.getDateEditor().getUiComponent()).setBorder(BorderFactory.createLineBorder(Color.red));  
      mode.setRowCount(0);

   return ;    
       
   }else if(Integer.parseInt(tab_Debut[1])==Integer.parseInt(tab_Fin[1])){
       
    if(Integer.parseInt(tab_Debut[2])>Integer.parseInt(tab_Fin[2])){
    ((JTextField)  txt_debut.getDateEditor().getUiComponent()).setBorder(BorderFactory.createLineBorder(Color.red));  
    mode.setRowCount(0);
     return ;        
    }
       
       
       
   }  
     
     
     
     
     
     
 }
    
    
    
    
    
    












((JTextField)  txt_debut.getDateEditor().getUiComponent()).setBorder(BorderFactory.createLineBorder(new Color(76,41,211)));  
((JTextField)  txt_fin.getDateEditor().getUiComponent()).setBorder(BorderFactory.createLineBorder(new Color(76,41,211)));
 Affichdat(datdebu, datfin);
         
         
        
        
        
        
        
        
        
        
        
        
        
         }
    }//GEN-LAST:event_searchActionPerformed

    private void SupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprimerActionPerformed
        // TODO add your handling code here:
        
        
        
        
          
                // i = the index of the selected row
                int i = tab.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    
            
           
      
     JLabel message = new JLabel("Veuillez Supprimer Cette Facture   ");
     JLabel title = new JLabel("Message Information !");
     UIManager.put("OptionPane.buttonFont",new Font("Times New Roman ",0,12)); 
     message.setFont(new Font("Times New Roman", 0, 14));  
     title.setFont(new Font("Times New Roman", 0, 14));  

   if( JOptionPane.showConfirmDialog(null, message,title.getText(),JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
       fact.Suppfact(mode.getValueAt(i,0).toString());
       mode.removeRow(i);
             
      
   }
       }
          
            
                    
     

    }//GEN-LAST:event_SupprimerActionPerformed

    private void pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfActionPerformed
        // TODO add your handling code here:
        
       if(mode.getRowCount()>=1){             
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
  Fact  factfr = new Fact();
     
   fntSize = 10.0f;
  com.itextpdf.text.Image   image=com.itextpdf.text.Image.getInstance("C:\\Users\\HP\\Desktop\\Documents\\NetBeansProjects\\Acceuil\\src\\main\\images\\logo_4.png");
  image.setWidthPercentage(100);
  image.setAlignment(Element.ALIGN_LEFT);
  document.add(image);


  Paragraph   p3 =  new Paragraph("\n\n   Les Informations De  La Liste  Des  Facture      ", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,14));
  p3.setAlignment(Element.ALIGN_CENTER);
  document.add(p3);
  PdfPTable table =  new PdfPTable(5);
  table.setWidthPercentage(105);
  table.setHorizontalAlignment(Element.ALIGN_BOTTOM);
  PdfPCell cel1;
  table.setWidths(new float[] { 104,108,104,104,104 });
  com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.WHITE);
  com.itextpdf.text.Font font2 = FontFactory.getFont(FontFactory.TIMES_ROMAN, fntSize);

            cel1 = new PdfPCell(new Phrase(" Identifiant  Facture ", font));
            cel1.setFixedHeight(20);
            cel1.setBackgroundColor(BaseColor.GRAY);
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
            cel1 = new PdfPCell(new Phrase(" Identifiant   Fournisseur", font));
            cel1.setBackgroundColor(BaseColor.GRAY);
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
            
            cel1 = new PdfPCell(new Phrase(" Date Du Facture   ", font));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setBackgroundColor(BaseColor.GRAY);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
        
            
            cel1 = new PdfPCell(new Phrase(" Montant   ", font));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setBackgroundColor(BaseColor.GRAY);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
            
            cel1 = new PdfPCell(new Phrase("Photo   ", font));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setBackgroundColor(BaseColor.GRAY);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
            
    
            
    
            
        
            
   
       
       
       
       
       
       
       
       
       
       
       
 String   choix=(String)list_item.getSelectedItem();

if(btn1.isSelected()){
             
   
          if(choix.equals("IDFact")){
              
              
               
 Fact   Myfact =fact.Rechidfact(saisir.getText());
   cel1 = new PdfPCell(new Phrase(Myfact.getIdFactFr(), font2));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
      
      
      cel1 = new PdfPCell(new Phrase(Myfact.getIdFr(), font2));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
      cel1 = new PdfPCell(new Phrase(Myfact.getDate_t(), font2));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
      
     cel1 = new PdfPCell(new Phrase(Myfact.getMontFactFr()+"", font2));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
            
  if(!Myfact.getImage().equals("")){
      
           
  com.itextpdf.text.Image   images=com.itextpdf.text.Image.getInstance(Myfact.getImage());
  PdfPCell cell = new PdfPCell(images, true);




            cell.setFixedHeight(40);
            cel1.setBorder(2);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           
            cell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
            cell.setRotation(180);

            cell.setNoWrap(true);
            cell.setPadding(38f);
            table.addCell(cell);
     }else{
    PdfPCell cell = new PdfPCell();




            cell.setFixedHeight(40);
            cel1.setBorder(2);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           
            cell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
            cell.setRotation(180);

            cell.setNoWrap(true);
            cell.setPadding(38f);
            table.addCell(cell);
  }  
             
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
          }
          else if(choix.equals("IDFr")){

              
              
              
              
              
    ArrayList <Fact>  list_fact =fact.RechIdFr(saisir.getText());
    
    
    
    
    
    
    
  
    for(Fact  Myfact :list_fact){
        
     cel1 = new PdfPCell(new Phrase(Myfact.getIdFactFr(), font2));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
      
      
      cel1 = new PdfPCell(new Phrase(Myfact.getIdFr(), font2));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
      cel1 = new PdfPCell(new Phrase(Myfact.getDate_t(), font2));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
      
     cel1 = new PdfPCell(new Phrase(Myfact.getMontFactFr()+"", font2));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
     if(!Myfact.getImage().equals("")){
      
           
  com.itextpdf.text.Image   images=com.itextpdf.text.Image.getInstance(Myfact.getImage());
  PdfPCell cell = new PdfPCell(images, true);




            cell.setFixedHeight(40);
            cel1.setBorder(2);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           
            cell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
            cell.setRotation(180);

            cell.setNoWrap(true);
            cell.setPadding(38f);
            table.addCell(cell);
     }else{
    PdfPCell cell = new PdfPCell();




            cell.setFixedHeight(40);
            cel1.setBorder(2);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           
            cell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
            cell.setRotation(180);

            cell.setNoWrap(true);
            cell.setPadding(38f);
            table.addCell(cell);
  }  
             
     
          
    }
   
             
              
                   
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
          }else if(choix.equals("ToutesFact")){

      
              
    ArrayList <Fact>  list_fact =fact.RechToutesfact();
    
    
    
    
    
    
    
  
    for(Fact  Myfact :list_fact){
        
     cel1 = new PdfPCell(new Phrase(Myfact.getIdFactFr(), font2));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
      
      
      cel1 = new PdfPCell(new Phrase(Myfact.getIdFr(), font2));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
      cel1 = new PdfPCell(new Phrase(Myfact.getDate_t(), font2));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
      
     cel1 = new PdfPCell(new Phrase(Myfact.getMontFactFr()+"", font2));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
     if(!Myfact.getImage().equals("")){
      
           
  com.itextpdf.text.Image   images=com.itextpdf.text.Image.getInstance(Myfact.getImage());
  PdfPCell cell = new PdfPCell(images, true);




            cell.setFixedHeight(40);
            cel1.setBorder(2);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           
            cell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
            cell.setRotation(180);

            cell.setNoWrap(true);
            cell.setPadding(38f);
            table.addCell(cell);
     }else{
    PdfPCell cell = new PdfPCell();




            cell.setFixedHeight(40);
            cel1.setBorder(2);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           
            cell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
            cell.setRotation(180);

            cell.setNoWrap(true);
            cell.setPadding(38f);
            table.addCell(cell);
  }  
             
     
    }
   
             
              
                   
              
              
              
              
              
              
              
              

          }    
             
             
         }
        
 if(btn2.isSelected()){
                
       


String   datdebu=((JTextField)  txt_debut.getDateEditor().getUiComponent()).getText();         
String  datfin=((JTextField)  txt_fin.getDateEditor().getUiComponent()).getText();    


            
    ArrayList <Fact>  list_fact =fact.Rechdat(datdebu, datfin);
    
    
    
    
    
    
    
  
    for(Fact  Myfact :list_fact){
        
     cel1 = new PdfPCell(new Phrase(Myfact.getIdFactFr(), font2));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
      
      
      cel1 = new PdfPCell(new Phrase(Myfact.getIdFr(), font2));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
      cel1 = new PdfPCell(new Phrase(Myfact.getDate_t(), font2));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
      
     cel1 = new PdfPCell(new Phrase(Myfact.getMontFactFr()+"", font2));
            cel1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cel1);
      
     if(!Myfact.getImage().equals("")){
      
           
  com.itextpdf.text.Image   images=com.itextpdf.text.Image.getInstance(Myfact.getImage());
  PdfPCell cell = new PdfPCell(images, true);




            cell.setFixedHeight(40);
            cel1.setBorder(2);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           
            cell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
            cell.setRotation(180);

            cell.setNoWrap(true);
            cell.setPadding(38f);
            table.addCell(cell);
     }else{
    PdfPCell cell = new PdfPCell();




            cell.setFixedHeight(40);
            cel1.setBorder(2);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           
            cell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
            cell.setRotation(180);

            cell.setNoWrap(true);
            cell.setPadding(38f);
            table.addCell(cell);
  }  
             
     
    }

     
            
 }      
            
            
  
  
  
  
  
  
  
  
  
  
  
  
  
            
            
            
                   
   JOptionPane.showMessageDialog(null, "PDF a éte enregistrer  ","Message Information",JOptionPane.INFORMATION_MESSAGE);
        
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            

   
   
   
   
    document.add( new Phrase("\n") );
    document.add(table);
    document.add( Chunk.NEWLINE );

 SimpleDateFormat simpleFormatter = new SimpleDateFormat("         dd/MM/yyyy  hh:mm:ss");
 String date=simpleFormatter.format(new Date());
 Paragraph  p2 = new Paragraph(date,FontFactory.getFont(FontFactory.TIMES_ROMAN,12));
 p2.setAlignment(Element.ALIGN_RIGHT);
 document.add(p2);

           
                    
  
  
  
  
  
  
  
    document.close();

  
  
} catch (Exception e) {
}        
                 
                 
                 
     }               
                 
                 
                 
                 
                   
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_pdfActionPerformed

    private void excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelActionPerformed
        // TODO add your handling code here:
        
        
         
                 if(mode.getRowCount()>=1){
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

    
    
    int  rows =6;
   // Define the cell format
   WritableCellFormat  times = new WritableCellFormat(times10pt);
   WritableCellFormat  times2 = new WritableCellFormat(times12pt);
   times.setBorder(jxl.format.Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
   times2.setBorder(jxl.format.Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
   times.setBackground(Colour.WHITE);
   times.setAlignment(Alignment.CENTRE);
   times.setVerticalAlignment(VerticalAlignment.CENTRE);
   times2.setWrap(true);
   
   times2.setAlignment(Alignment.CENTRE);
   times2.setVerticalAlignment(VerticalAlignment.CENTRE);
   WritableCellFormat cellFormat = new WritableCellFormat(times);
   cellFormat.setBackground(Colour.YELLOW);
   cellFormat.setBorder(jxl.format.Border.ALL, BorderLineStyle.THIN);
   // Lets automatically wrap the cells
   // Create create a bold font with unterlines
   WritableFont times10ptBoldUnderline = new WritableFont(
   WritableFont.TIMES, 12, WritableFont.BOLD, false,
   UnderlineStyle.SINGLE);
   // Lets automatically wrap the cells

   Label label;
   Fact factfr = new Fact();
   label = new Label(2, 0, "                         Stock  Super Marché  ", new WritableCellFormat(new WritableFont(
   WritableFont.TIMES, 24, WritableFont.BOLD)));
   writablesheet1.addCell(label);
  
   Label label_3;
   label_3 = new Label(3, 3, "La  Liste  Des  Factures  ", new WritableCellFormat(new WritableFont(
   WritableFont.TIMES, 18, WritableFont.BOLD)));
   writablesheet1.addCell(label_3);
  





   
   
   
   
   writablesheet1.setRowView(5, 26*24);
   
   
   writablesheet1.setColumnView(1,35);
   Label label1 = new Label(1,5,"Identifiant Fcature",cellFormat);
   writablesheet1.setColumnView(2, 35);
   Label label2 = new Label(2,5,"Designation Fournisseur",cellFormat);
   writablesheet1.setColumnView(3, 35);
   Label label3 = new Label(3,5,"Date Du Facture ",cellFormat);
   writablesheet1.setColumnView(4, 35);
   Label label4 = new Label(4,5,"Montant  ",cellFormat);
   writablesheet1.setColumnView(5, 35);
   Label label5 = new Label(5,5,"Photo ",cellFormat);
    
   
   
     
   
   
    
   
   
  
    writablesheet1.addCell(label1);
    writablesheet1.addCell(label2);
    writablesheet1.addCell(label3);
    writablesheet1.addCell(label4);
    writablesheet1.addCell(label5);
    
    
        
       
    
    
    
    
    
    
    
    
    
String   choix=(String)list_item.getSelectedItem();

if(btn1.isSelected()){
             
       
             
          if(choix.equals("IDFact")){
              
              
              
      Fact   facte =fact.Rechidfact(saisir.getText());



        
     writablesheet1.setColumnView(0,30); 
     writablesheet1.addCell(new Label(1,rows,facte.getIdFactFr(),times2));
     
     writablesheet1.setColumnView(1,30);
     writablesheet1.addCell(new Label(2,rows,facte.getIdFr(),times2));
     
     
     
     
     writablesheet1.setColumnView(2,30);
     writablesheet1.addCell(new Label(3,rows,facte.getDate_t(),times2));        
    
     
       
     
     writablesheet1.setColumnView(4,30);
     writablesheet1.addCell(new Label(4,rows,facte.getMontFactFr()+"",times2));        
     
    
     writablesheet1.setColumnView(5,30);
  
     
     
     writablesheet1.addCell(new Label(5,rows,facte.getImage(),times2));        
     
        
        
        
        
            
              
              
              
              
              
              
              
              
              
              
          }else if(choix.equals("IDFr")){
              
    ArrayList   <Fact> list =fact.RechIdFr(saisir.getText());


    for(Fact   facte  :  list){        

        
     writablesheet1.setColumnView(0,30); 
     writablesheet1.addCell(new Label(1,rows,facte.getIdFactFr(),times2));
     
     writablesheet1.setColumnView(1,30);
     writablesheet1.addCell(new Label(2,rows,facte.getIdFr(),times2));
     
          
     writablesheet1.setColumnView(2,30);
     writablesheet1.addCell(new Label(3,rows,facte.getDate_t(),times2));        
    
          
     writablesheet1.setColumnView(4,30);
     writablesheet1.addCell(new Label(4,rows,facte.getMontFactFr()+"",times2));        
     
     writablesheet1.setColumnView(5,30);
     writablesheet1.addCell(new Label(5,rows,facte.getImage(),times2));        
     
               
        
      rows++;  
        
        
        
        
    }
          
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
          }else if(choix.equals("ToutesFact")){
              
              
     ArrayList   <Fact> list =fact.RechToutesfact();


    for(Fact   facte :  list){        

        
     writablesheet1.setColumnView(0,30); 
     writablesheet1.addCell(new Label(1,rows,facte.getIdFactFr(),times2));
     
     writablesheet1.setColumnView(1,30);
     writablesheet1.addCell(new Label(2,rows,facte.getIdFr(),times2));
     
     
     
     
     writablesheet1.setColumnView(2,30);
     writablesheet1.addCell(new Label(3,rows,facte.getDate_t(),times2));        
    
     
       
     
     writablesheet1.setColumnView(4,30);
     writablesheet1.addCell(new Label(4,rows,facte.getMontFactFr()+"",times2));        
     
     writablesheet1.setColumnView(5,30);
     writablesheet1.addCell(new Label(5,rows,facte.getImage(),times2));        
     
        
        
        
        
      rows++;  
        
        
        
        
    }            
              
              
              
              
              
              
              
              
              
              
              
              
              
          }    
             
             
         }
        
 if(btn2.isSelected()){
         

String   datdebu=((JTextField)  txt_debut.getDateEditor().getUiComponent()).getText();         
String  datfin=((JTextField)  txt_fin.getDateEditor().getUiComponent()).getText();    


            
    ArrayList <Fact>  list_fact =fact.Rechdat(datdebu, datfin);
    
    
               


    for(Fact   facte  :  list_fact){        

        
     writablesheet1.setColumnView(0,30); 
     writablesheet1.addCell(new Label(1,rows,facte.getIdFactFr(),times2));
     
     writablesheet1.setColumnView(1,30);
     writablesheet1.addCell(new Label(2,rows,facte.getIdFr(),times2));
     
     
     
     
     writablesheet1.setColumnView(2,30);
     writablesheet1.addCell(new Label(3,rows,facte.getDate_t(),times2));        
    
     
       
     
     writablesheet1.setColumnView(4,30);
     writablesheet1.addCell(new Label(4,rows,facte.getMontFactFr()+"",times2));        
     
     writablesheet1.setColumnView(5,30);
     writablesheet1.addCell(new Label(5,rows,facte.getImage(),times2));        
     
        
        
        
        
      rows++;  
        
        
        
        
    } 
    
 }  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
         JOptionPane.showMessageDialog(null, "Excel a éte enregistrer  ","Message Information",JOptionPane.INFORMATION_MESSAGE);

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     
    workbook.write();
    workbook.close();
    
}}  
    
catch (WriteException e) {
    JOptionPane.showMessageDialog(null, e);}
catch (IOException ex) {}        
                         
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
             }
    }//GEN-LAST:event_excelActionPerformed

    
    
    
    
    
    
    
    
    
    
    
    
        
   public  static void   AffichToutesfact(){
       
      ArrayList   <Fact>  Mylist = (Fact.RechToutesfact());

 if(tr==0){
   if(Fact.RechToutesfact()!=null){
   for(Fact    fc: Mylist){   
   row[0]=fc.getIdFactFr();
   row[1]=fc.getIdFr();
   row[2]=fc.getDate_t();
   row[3]=fc.getMontFactFr();
   row[4]=fc.getImage();
  
   mode.addRow(row);}
  
   }else{
   mode.setRowCount(0);
   System.out.println("rah list khawya");   
   
   }       
   tr=1;    
    return ;
 }
 
 else if(tr==1){
        tr=0;
        mode.setRowCount(0);
        AffichToutesfact();
  
 }      
        
       
       
       
   }
   public  static void   Affichidfact(String idfact){
   if(tr==0){

   if(Fact.Rechidfact(idfact)!=null){
      
  Fact  fc = (Fact)Fact.Rechidfact(idfact);
  
  
   row[0]=fc.getIdFactFr();
   row[1]=fc.getIdFr();
   row[2]=fc.getDate_t();
   row[3]=fc.getMontFactFr();
   
   
   row[4]=fc.getImage();
  
   mode.addRow(row);
   
 if(mode.getRowCount()>=2){
  
       mode.removeRow(0);
   } 
}else{
   mode.setRowCount(0);
   
   }       
   tr=1;    
    return ;
     

   
   
   } else if(tr==1){
        tr=0;
        mode.setRowCount(0);
        Affichidfact(idfact);
  
 }  
 
       

      } 
   public  static void   Affichdat(String datdebu,String datfin){
 
  ArrayList   <Fact>  Mylist = (Fact.Rechdat(datdebu,datfin));

 if(tr==0){
   if(Fact.Rechdat(datdebu,datfin)!=null){
   for(Fact    fc: Mylist){   
   row[0]=fc.getIdFactFr();
   row[1]=fc.getIdFr();
   row[2]=fc.getDate_t();
   row[3]=fc.getMontFactFr();
   row[4]=fc.getImage();
  
  
   mode.addRow(row);}
  
   }else{
   mode.setRowCount(0);
   
   }       
   tr=1;    
    return ;
 }
 
 else if(tr==1){
        tr=0;
        mode.setRowCount(0);
        Affichdat( datdebu, datfin);
  
 }      
        
      }
   public  static void   Affichidfr(String idfr){
     ArrayList   <Fact>  Mylist = (Fact.RechIdFr(idfr));

 
  if(tr==0){
   if(Fact.RechIdFr(idfr)!=null){
   for(Fact    fc: Mylist){   
   row[0]=fc.getIdFactFr();
   row[1]=fc.getIdFr();
   row[2]=fc.getDate_t();
   row[3]=fc.getMontFactFr();
   row[4]=fc.getImage();
  
   mode.addRow(row);}
  
   }else{
   mode.setRowCount(0);
   
   }       
   tr=1;    
    return ;
 }
 
 else if(tr==1){
        tr=0;
        mode.setRowCount(0);
        Affichidfr( idfr);
  
 }  
 
  

      } 
   
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(updatefacture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updatefacture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updatefacture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updatefacture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updatefacture().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Fermer;
    private javax.swing.JButton Modifier;
    private javax.swing.JButton Supprimer;
    private javax.swing.JRadioButton btn1;
    private javax.swing.JRadioButton btn2;
    private javax.swing.ButtonGroup choix;
    private javax.swing.JButton excel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_date_debut;
    private javax.swing.JLabel lb_date_fin;
    private javax.swing.JComboBox<String> list_item;
    private javax.swing.JButton pdf;
    private javax.swing.JTextField saisir;
    private javax.swing.JButton search;
    private javax.swing.JTable tab;
    private com.toedter.calendar.JDateChooser txt_debut;
    private com.toedter.calendar.JDateChooser txt_fin;
    // End of variables declaration//GEN-END:variables
}
