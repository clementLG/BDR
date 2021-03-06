/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import controls.mysqlconnect;
import controls.paintComponent;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Arrays;

/**
 *
 * @author Mickaël
 */
public class menuConfigsJFrame extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    /**
     * Creates new form menuConfigsJFrame
     */
    public menuConfigsJFrame() {
         setTitle("Module Administration");
          
            this.setContentPane(paintComponent.JP(200));
            initComponents();
            
            
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setLocationRelativeTo(null);
        try {
            Image i = ImageIO.read(getClass().getResource("/images/logo.png"));
            setIconImage(i);
        } catch (IOException ex) {
            Logger.getLogger(menuJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        oldPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        newPassword1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        newPassword2 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        modif = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Configuration de l'application");

        jLabel2.setText("Changer le mot de passe administrateur");

        oldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldPasswordActionPerformed(evt);
            }
        });

        jLabel3.setText("Ancien mot de passe");

        newPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPassword1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Nouveau mot de passe");

        newPassword2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPassword2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Confirmation");

        modif.setText("Modifier le Compte Administrateur");
        modif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(oldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(newPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(newPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(modif)
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(28, 28, 28)
                .addComponent(modif, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void oldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldPasswordActionPerformed

    private void newPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPassword1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPassword1ActionPerformed

    private void newPassword2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPassword2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPassword2ActionPerformed

    private void modifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifMouseClicked
        // TODO add your handling code here:
        String old = oldPassword.getText();
        String new1 = newPassword1.getText();
        String new2 = newPassword2.getText();
        
        if(!Arrays.equals(newPassword1.getPassword(), newPassword2.getPassword())){
            JOptionPane.showMessageDialog(null, "Erreur: Les deux mots de passe saisis ne correspondent pas");
        }
        else{
            
            conn = mysqlconnect.ConnectDb();  
            old = controls.fonctions.encryptPassword(old);
            String sql="select password from administration where id=1 and password=?";
            try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, old);
            rs = pst.executeQuery();
            int S=0;
              while(rs.next()){
                  S = 1;
              }
              
              if(S!=1){
                  JOptionPane.showMessageDialog(null, "Erreur: L'ancien mot de passe administrateur n'est pas correct");
              }
              else{
            String newpass = controls.fonctions.encryptPassword(new1);
            String sql2="UPDATE administration set password=? where id=1";
        try{
            pst = conn.prepareStatement(sql2);
            pst.setString(1, newpass);
            pst.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Votre mot de passe a été changé");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Une erreur est survenue");
        }
              }
              
            }

            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            } 
            
        }
    }//GEN-LAST:event_modifMouseClicked

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
            java.util.logging.Logger.getLogger(menuConfigsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuConfigsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuConfigsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuConfigsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuConfigsJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton modif;
    private javax.swing.JPasswordField newPassword1;
    private javax.swing.JPasswordField newPassword2;
    private javax.swing.JPasswordField oldPassword;
    // End of variables declaration//GEN-END:variables
}
