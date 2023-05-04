package com.mycompany.ugallery_proyecto2;

import Handlers.JPEGHandler;
import Handlers.*;
import java.awt.Image;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author manuel
 */
public class EditorJFrame extends javax.swing.JFrame {

    /**
     * Creates new form EditorJFrame
     */
    public EditorJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("EDITOR");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JpgBmpCB = new javax.swing.JCheckBox();
        copiaCB = new javax.swing.JCheckBox();
        blancoNegroCB = new javax.swing.JCheckBox();
        coloresCB = new javax.swing.JCheckBox();
        modificarCB = new javax.swing.JCheckBox();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rutaTXT = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(32, 36, 48));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EDITOR DE IMAGEN ");
        jLabel1.setToolTipText("");

        JpgBmpCB.setBackground(new java.awt.Color(32, 36, 48));
        JpgBmpCB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        JpgBmpCB.setForeground(new java.awt.Color(255, 255, 255));
        JpgBmpCB.setText("JPEG A BMP Y VICEVERSA");
        JpgBmpCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JpgBmpCBActionPerformed(evt);
            }
        });

        copiaCB.setBackground(new java.awt.Color(32, 36, 48));
        copiaCB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        copiaCB.setForeground(new java.awt.Color(255, 255, 255));
        copiaCB.setText("COPIA – JPEG");

        blancoNegroCB.setBackground(new java.awt.Color(32, 36, 48));
        blancoNegroCB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        blancoNegroCB.setForeground(new java.awt.Color(255, 255, 255));
        blancoNegroCB.setText("BLANCO Y NEGRO");

        coloresCB.setBackground(new java.awt.Color(32, 36, 48));
        coloresCB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        coloresCB.setForeground(new java.awt.Color(255, 255, 255));
        coloresCB.setText("COLORES (ROJO, VERDE, AZUL, SEPIA)");
        coloresCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coloresCBActionPerformed(evt);
            }
        });

        modificarCB.setBackground(new java.awt.Color(32, 36, 48));
        modificarCB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        modificarCB.setForeground(new java.awt.Color(255, 255, 255));
        modificarCB.setText("MODIFICAR IMAGEN");

        jButton7.setBackground(new java.awt.Color(110, 77, 252));
        jButton7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("AGREGAR IMAGEN");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("RUTA IMAGEN");
        jLabel2.setToolTipText("");

        rutaTXT.setEditable(false);
        rutaTXT.setBackground(new java.awt.Color(255, 255, 255));
        rutaTXT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        rutaTXT.setForeground(new java.awt.Color(0, 0, 0));

        jButton6.setBackground(new java.awt.Color(254, 65, 87));
        jButton6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("EJECUTAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(117, 232, 250));
        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("REGRESAR ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rutaTXT))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JpgBmpCB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(copiaCB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(blancoNegroCB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(modificarCB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(coloresCB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rutaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JpgBmpCB)
                    .addComponent(jButton7))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(copiaCB)
                    .addComponent(jButton6))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(coloresCB)
                        .addGap(30, 30, 30)
                        .addComponent(modificarCB)
                        .addGap(30, 30, 30)
                        .addComponent(blancoNegroCB))
                    .addComponent(jButton1))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void coloresCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coloresCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coloresCBActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        JFileChooser jf = new JFileChooser();
        FileFilter filtro1 = new FileNameExtensionFilter("Archivos JPG", "jpg");
        FileFilter filtro2 = new FileNameExtensionFilter("Archivos BMP", "bmp"); 
        jf.setFileFilter(filtro2);
        jf.setFileFilter(filtro1);
        jf.showOpenDialog(this);
        File archivo=jf.getSelectedFile();
        if (archivo!=null){
            rutaTXT.setText(archivo.getAbsolutePath());
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(rutaTXT.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe Seleccionar Una Imagen", "Ugallery", JOptionPane.WARNING_MESSAGE);
        }else if(blancoNegroCB.isSelected()==false&&copiaCB.isSelected()==false&&JpgBmpCB.isSelected()==false&&coloresCB.isSelected()==false&&modificarCB.isSelected()==false){
            JOptionPane.showMessageDialog(null, "Seleccionar El Filtro A Aplicar", "Ugallery", JOptionPane.WARNING_MESSAGE);
        }else{
            if(JpgBmpCB.isSelected()==true){
                File archivo = new File(rutaTXT.getText());
                String fileName=archivo.getName();
                String extension = FilenameUtils.getExtension(fileName);
                if(extension.equals("jpg")){
                    JPEGtoBMPImage JPGtoBMP = new JPEGtoBMPImage(rutaTXT.getText());
                    try{
                        JPEGHandler.runHandler(JPGtoBMP);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Filtro JPG a BMP Aplicado Correctamente", "Ugallery", JOptionPane.INFORMATION_MESSAGE); 
                }else if(extension.equals("bmp")){
                    BMPtoJPEGImage BMPtoJPG = new BMPtoJPEGImage(rutaTXT.getText());
                    try{
                        JPEGHandler.runHandler(BMPtoJPG);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Filtro BMP a JPG Aplicado Correctamente", "Ugallery", JOptionPane.INFORMATION_MESSAGE);  
                    
                } 
            }
            if(copiaCB.isSelected()==true){
                BmpHandlerCopy HanderCopiaJPG = new BmpHandlerCopy(rutaTXT.getText());
                try{
                    JPEGHandler.runHandler(HanderCopiaJPG);
                }catch(Exception e){
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Filtro Copia Aplicado Correctamente", "Ugallery", JOptionPane.INFORMATION_MESSAGE);
            }
            if(coloresCB.isSelected()==true){
                JPEGImageHandlerColors HanderColors = new JPEGImageHandlerColors(rutaTXT.getText());
                try{
                    JPEGHandler.runHandler(HanderColors);
                }catch(Exception e){
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Filtro Colores Aplicado Correctamente", "Ugallery", JOptionPane.INFORMATION_MESSAGE);  
            }if(modificarCB.isSelected()==true){
                JPEGImageHandlerRotator RotarImaen = new JPEGImageHandlerRotator(rutaTXT.getText());
                try{
                    JPEGHandler.runHandler( RotarImaen);
                }catch(Exception e){
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Filtro Rotar Aplicado Correctamente", "Ugallery", JOptionPane.INFORMATION_MESSAGE); 
            }
            if(blancoNegroCB.isSelected()==true){
                JPEGImageHandlerBN HanderBN = new JPEGImageHandlerBN(rutaTXT.getText());
                try{
                    JPEGHandler.runHandler(HanderBN);
                }catch(Exception e){
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Filtro Blanco Y Negro Aplicado Correctamente", "Ugallery", JOptionPane.INFORMATION_MESSAGE); 
            }
            JpgBmpCB.setSelected(false);
            copiaCB.setSelected(false);
            coloresCB.setSelected(false);
            modificarCB.setSelected(false);
            blancoNegroCB.setSelected(false);
            rutaTXT.setText(null);
            JOptionPane.showMessageDialog(null, "Procesamiento de Imagen Completado Correctamente", "Ugallery", JOptionPane.INFORMATION_MESSAGE);     
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LoginJFrame Menu = new LoginJFrame();
        Menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JpgBmpCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JpgBmpCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JpgBmpCBActionPerformed

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
            java.util.logging.Logger.getLogger(EditorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditorJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox JpgBmpCB;
    private javax.swing.JCheckBox blancoNegroCB;
    private javax.swing.JCheckBox coloresCB;
    private javax.swing.JCheckBox copiaCB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox modificarCB;
    private javax.swing.JTextField rutaTXT;
    // End of variables declaration//GEN-END:variables
}
