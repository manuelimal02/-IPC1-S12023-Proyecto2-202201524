package com.mycompany.ugallery_proyecto2;
import Handlers.*;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.*;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author manuel
 */
public class ConvertidorJFrame extends javax.swing.JFrame {
    DefaultListModel modeloCategoria = new DefaultListModel();
    public HiloImagenes hiloImagenes;
    public Thread HiloImagenes;
    
    public int imagenesProcesadas=0;
    public int TotalImagenes=0;
    
    
    public class HiloImagenes implements Runnable{     
        public ArrayList<String> listaRutaImagen;
        JTextArea colaEjecucion;
        JProgressBar BarraDeProgreso;
        JList listaImagenLT;
        int total=0;
        int progreso=0;
        DefaultListModel<String> modelo1 = new DefaultListModel();
        public HiloImagenes(ArrayList<String>listaRutaImagen, JTextArea colaEjecucion, JProgressBar BarraDeProgreso, JList listaImagenLT){
            this.listaRutaImagen=listaRutaImagen;
            this.colaEjecucion=colaEjecucion;
            this.BarraDeProgreso=BarraDeProgreso;
            this.listaImagenLT=listaImagenLT;
            for (int i = 0; i <listaRutaImagen.size(); i++) {
                total++;
            }
            progreso=100/total;
            modelo1.removeAllElements();
        } 
        @Override
        public void run() {
            for (int i = 0; i <listaRutaImagen.size(); i++) {
                if(JpgBmpCB.isSelected()==true){
                    JPEGtoBMPImage JPGtoBMP = new JPEGtoBMPImage(listaRutaImagen.get(i));
                    try{
                        JPEGHandler.runHandler(JPGtoBMP);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    File archivo = new File(listaRutaImagen.get(i));String fileName=archivo.getName();String nombre = FilenameUtils.getBaseName(fileName);
                    colaEjecucion.append("Filtro JPG a BMP Aplicado a la imagen: "+nombre+"\n");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ConvertidorJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(copiaCB.isSelected()==true){
                    BmpHandlerCopy HanderCopiaJPG = new BmpHandlerCopy(listaRutaImagen.get(i));
                    try{
                        JPEGHandler.runHandler(HanderCopiaJPG);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    File archivo = new File(listaRutaImagen.get(i));String fileName=archivo.getName();String nombre = FilenameUtils.getBaseName(fileName);
                    colaEjecucion.append("Filtro Copia Aplicado a la imagen: "+nombre+"\n");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ConvertidorJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(coloresCB.isSelected()==true){
                    JPEGImageHandlerColors HanderColors = new JPEGImageHandlerColors(listaRutaImagen.get(i));
                    try{
                        JPEGHandler.runHandler(HanderColors);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    File archivo = new File(listaRutaImagen.get(i));String fileName=archivo.getName();String nombre = FilenameUtils.getBaseName(fileName);
                    colaEjecucion.append("Filtro Colores Aplicado a la imagen: "+nombre+"\n");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ConvertidorJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(modificarCB.isSelected()==true){
                    JPEGImageHandlerRotator RotarImaen = new JPEGImageHandlerRotator(listaRutaImagen.get(i));
                    try{
                        JPEGHandler.runHandler( RotarImaen);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    File archivo = new File(listaRutaImagen.get(i));String fileName=archivo.getName();String nombre = FilenameUtils.getBaseName(fileName);
                    colaEjecucion.append("Filtro Rotar Aplicado a la imagen: "+nombre+"\n");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ConvertidorJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }
                if(blancoNegroCB.isSelected()==true){
                    JPEGImageHandlerBN HanderBN = new JPEGImageHandlerBN(listaRutaImagen.get(i));
                    try{
                        JPEGHandler.runHandler(HanderBN);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    File archivo = new File(listaRutaImagen.get(i));String fileName=archivo.getName();String nombre = FilenameUtils.getBaseName(fileName);
                    colaEjecucion.append("Filtro Blanco Y Negro Aplicado a la imagen: "+nombre+"\n");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ConvertidorJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                imagenesProcesadas++;
                if(imagenesProcesadas<=TotalImagenes){
                    BarraDeProgreso.setValue(BarraDeProgreso.getValue()+(progreso+1));
                }
            }
            JOptionPane.showMessageDialog(null, "Procesamiento de Imágenes Completado Correctamente", "Ugallery", JOptionPane.INFORMATION_MESSAGE);
            JpgBmpCB.setSelected(false);
            copiaCB.setSelected(false);
            coloresCB.setSelected(false);
            modificarCB.setSelected(false);
            blancoNegroCB.setSelected(false);
            imagenesProcesadas=0;
            TotalImagenes=0;
            listaImagenLT.setModel(modelo1);
        }
    }
    
    public ConvertidorJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("CONVERTIDOR");
        listaImagenesLT.setModel(modeloCategoria);
        AppState.listaUsuario.LlenarUsuarios(usuarioTXT);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaImagenesLT = new javax.swing.JList<>();
        JpgBmpCB = new javax.swing.JCheckBox();
        copiaCB = new javax.swing.JCheckBox();
        coloresCB = new javax.swing.JCheckBox();
        modificarCB = new javax.swing.JCheckBox();
        blancoNegroCB = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        usuarioTXT = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        categoriaTXT = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        JBarraDeProgreso = new javax.swing.JProgressBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        colaTXTA = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Usuario:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(32, 36, 48));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CONVERTIDOR (PROCESAMIENTO POR LOTES)");
        jLabel2.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cola de Procesamiento");

        listaImagenesLT.setBackground(new java.awt.Color(255, 255, 255));
        listaImagenesLT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        listaImagenesLT.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(listaImagenesLT);

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

        blancoNegroCB.setBackground(new java.awt.Color(32, 36, 48));
        blancoNegroCB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        blancoNegroCB.setForeground(new java.awt.Color(255, 255, 255));
        blancoNegroCB.setText("BLANCO Y NEGRO");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuario:");

        usuarioTXT.setBackground(new java.awt.Color(255, 255, 255));
        usuarioTXT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        usuarioTXT.setForeground(new java.awt.Color(0, 0, 0));
        usuarioTXT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                usuarioTXTItemStateChanged(evt);
            }
        });
        usuarioTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioTXTActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Categoría:");

        categoriaTXT.setBackground(new java.awt.Color(255, 255, 255));
        categoriaTXT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        categoriaTXT.setForeground(new java.awt.Color(0, 0, 0));
        categoriaTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaTXTActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(110, 77, 252));
        jButton7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("AGREGAR LOTE");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        JBarraDeProgreso.setForeground(new java.awt.Color(254, 65, 87));

        colaTXTA.setBackground(new java.awt.Color(255, 255, 255));
        colaTXTA.setColumns(20);
        colaTXTA.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        colaTXTA.setForeground(new java.awt.Color(0, 0, 0));
        colaTXTA.setRows(5);
        jScrollPane2.setViewportView(colaTXTA);

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad Procesada");

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Consola De Ejecución");

        jButton1.setBackground(new java.awt.Color(117, 232, 250));
        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("REGRESAR ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(254, 65, 87));
        jButton10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("EJECUTAR EN PARALELO");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuarioTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoriaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(41, 41, 41)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JpgBmpCB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(copiaCB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(blancoNegroCB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(modificarCB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(coloresCB))
                                .addGap(122, 122, 122)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JBarraDeProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(usuarioTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(categoriaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JpgBmpCB)
                            .addComponent(jButton10))
                        .addGap(27, 27, 27)
                        .addComponent(copiaCB)
                        .addGap(30, 30, 30)
                        .addComponent(coloresCB)
                        .addGap(30, 30, 30)
                        .addComponent(modificarCB)
                        .addGap(34, 34, 34)
                        .addComponent(blancoNegroCB)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBarraDeProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
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

    private void JpgBmpCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JpgBmpCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JpgBmpCBActionPerformed

    private void coloresCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coloresCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coloresCBActionPerformed

    private void usuarioTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioTXTActionPerformed
        // TODO add your handling code here:
        this.categoriaTXT.removeAllItems();
        Usuario usuarioActual = (Usuario) AppState.listaUsuario.find(usuarioTXT.getSelectedItem()); 
        for (int i=0; i<usuarioActual.listaCategoria.size(); i++) {
            categoriaTXT.addItem(usuarioActual.listaCategoria.get(i).getNombreCategoria());
        }
     
    }//GEN-LAST:event_usuarioTXTActionPerformed

    private void categoriaTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoriaTXTActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Usuario usuarioActual = (Usuario) AppState.listaUsuario.find(usuarioTXT.getSelectedItem()); 
        Categoria categoria = (Categoria)usuarioActual.listaCategoria.get(categoriaTXT.getSelectedIndex());
        if(categoria.getListaImagen().get(0)==null){
            JOptionPane.showMessageDialog(null, "No existen imágenes en la categoria "+categoriaTXT.getSelectedItem()+".", "Ugallery", JOptionPane.WARNING_MESSAGE);
        }else{
            JBarraDeProgreso.setValue(0);
            colaTXTA.setText("");
            categoria.retornarNombre(listaImagenesLT);
            JOptionPane.showMessageDialog(null, "Imágenes de la categoría "+categoriaTXT.getSelectedItem()+" agregadas a la cola de procesamiento.", "Ugallery", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LoginJFrame Menu = new LoginJFrame();
        Menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void usuarioTXTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_usuarioTXTItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioTXTItemStateChanged

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if(listaImagenesLT.getModel().getSize()==0){
            JOptionPane.showMessageDialog(null, "Agregar Un Lote de Imágenes.", "Ugallery", JOptionPane.WARNING_MESSAGE);
        }else if(JpgBmpCB.isSelected()==false&&copiaCB.isSelected()==false&&coloresCB.isSelected()==false&&modificarCB.isSelected()==false&&blancoNegroCB.isSelected()==false){
            JOptionPane.showMessageDialog(null, "Seleccionar El Filtro A Aplicar", "Ugallery", JOptionPane.WARNING_MESSAGE);
        }else{
            ArrayList<String>listaRutaImagen1= new ArrayList<String>();
            Usuario usuarioActual = (Usuario) AppState.listaUsuario.find(usuarioTXT.getSelectedItem());
            Categoria categoria = (Categoria)usuarioActual.listaCategoria.get(categoriaTXT.getSelectedIndex());
            categoria.getListaImagen().ArrayListRuta(listaRutaImagen1);
            TotalImagenes = listaImagenesLT.getModel().getSize();
            hiloImagenes= new HiloImagenes(listaRutaImagen1, colaTXTA, JBarraDeProgreso, listaImagenesLT);
            HiloImagenes = new Thread(hiloImagenes);
            HiloImagenes.start(); 
        }
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(ConvertidorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConvertidorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConvertidorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConvertidorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConvertidorJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar JBarraDeProgreso;
    private javax.swing.JCheckBox JpgBmpCB;
    private javax.swing.JCheckBox blancoNegroCB;
    private javax.swing.JComboBox<String> categoriaTXT;
    private javax.swing.JTextArea colaTXTA;
    private javax.swing.JCheckBox coloresCB;
    private javax.swing.JCheckBox copiaCB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaImagenesLT;
    private javax.swing.JCheckBox modificarCB;
    private javax.swing.JComboBox<String> usuarioTXT;
    // End of variables declaration//GEN-END:variables
}
