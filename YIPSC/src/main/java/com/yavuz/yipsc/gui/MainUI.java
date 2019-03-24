/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yavuz.yipsc.gui;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author codegenius
 */
public class MainUI extends javax.swing.JFrame {

    /**
     * Creates new form MainUI
     */
    public MainUI() throws IOException {
        initComponents(); 
                      
     // ImageIcon ii = ImageIcon(this.getClass().getResource("/resources/appIcon.png"));

        BufferedImage  image  = ImageIO.read(new File("src/resources/appIcon.png"));
        final List<Image> icons = new ArrayList<Image>();
        icons.add(image);
        icons.add(image);
        
       JFrame mainFrame = (JFrame) getFrames()[0];
       mainFrame.setIconImages(icons);
       mainFrame.setVisible(true);
       
       
       
               
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        uploadCodeBtn = new javax.swing.JButton();
        verifyCodeBtn = new javax.swing.JButton();
        compileCodeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("YIPSC");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setLocation(new java.awt.Point(100, 100));
        setName("frame0"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel1.setText("Copy/Paste or Upload the C code from file here.");

        uploadCodeBtn.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        uploadCodeBtn.setText("Upload Code");
        uploadCodeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadCodeBtnActionPerformed(evt);
            }
        });

        verifyCodeBtn.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        verifyCodeBtn.setText("Verify");

        compileCodeBtn.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        compileCodeBtn.setText("Compile!");
        compileCodeBtn.setActionCommand("Compile");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                        .addComponent(uploadCodeBtn)
                        .addGap(29, 29, 29)
                        .addComponent(verifyCodeBtn)
                        .addGap(26, 26, 26)
                        .addComponent(compileCodeBtn))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(uploadCodeBtn)
                    .addComponent(verifyCodeBtn)
                    .addComponent(compileCodeBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        uploadCodeBtn.getAccessibleContext().setAccessibleName("UploadCodeBtn");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void uploadCodeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadCodeBtnActionPerformed
       JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

       FileNameExtensionFilter filter = new FileNameExtensionFilter("C or CPP FILES", "c","cpp");

                jfc.setDialogTitle("Please choose C file to compile");
                jfc.setFileFilter(filter);
		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
                        
           try {
               InputStream is = new FileInputStream(selectedFile);
               BufferedReader buf = new BufferedReader(new InputStreamReader(is));

               String line = buf.readLine();
               StringBuilder sb = new StringBuilder(); 
               while(line != null){ 
                   sb.append(line).append("\n"); 
                   line = buf.readLine(); 
               }
               String fileAsString = sb.toString();
               
               jTextArea1.setText(fileAsString);

           } catch (FileNotFoundException ex) {
               Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
           }
                        
        
		}
    }//GEN-LAST:event_uploadCodeBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws MalformedURLException {
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
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton compileCodeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton uploadCodeBtn;
    private javax.swing.JButton verifyCodeBtn;
    // End of variables declaration//GEN-END:variables
}