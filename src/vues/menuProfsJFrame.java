package vues;

import controls.paintComponent;
import controls.mysqlconnect;
import classes.*;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mickaël
 */
public class menuProfsJFrame extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    /**
     * Creates new form menuProfsJFrame
     */
    public menuProfsJFrame() {
        this.setContentPane(paintComponent.JP(400));
        initComponents();
        setTitle("Module Administration");
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 255, 255));
        setLocationRelativeTo(null);
        try {
            Image i = ImageIO.read(getClass().getResource("/images/logo.png"));
            setIconImage(i);
        } catch (IOException ex) {
            Logger.getLogger(menuJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        txtid.setVisible(false);
        txtidsection.setVisible(false);
        txtidmatiere.setVisible(false);
        txtid.setVisible(false);
        txtiddel.setVisible(false);
        
    }
  private void UpdateJTable(){
    

    
    String sql="select idprof as ID, nom as Nom, prenom as Prénom from professeurs";
    try{
    pst = conn.prepareStatement(sql);
    rs = pst.executeQuery();
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
}
    private void UpdateTableMatieres(){
    

    
    String sql="select idmatiere as ID, matiere as Matière, section as Section "
            + "from matieres, sections "
            + "where matieres.idprof=? and matieres.idsection=sections.idsections";
    try{
    pst = conn.prepareStatement(sql);
    pst.setString(1, txtid.getText());
    rs = pst.executeQuery();
    TableMatieres.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
}
    private void Fillcombo(){
            listesections.removeAllItems();
            String choose = "Choisir";
            listesections.addItem(choose);
            String sql="select section from sections";
            try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
              while(rs.next()){
                  String S = rs.getString("section");
                  listesections.addItem(S);
              }
            }

            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }   
    }
    private void Fillcombo2(String id){
            listematieres.removeAllItems();
            String choose = "Choisir";
            listematieres.addItem(choose);
            String sql="select idmatiere, matiere from matieres where idsection=?";
            try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();
              while(rs.next()){
                  String S = rs.getString("matiere");
                  listematieres.addItem(S);
              }
            }

            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(){

            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }

        };
        modifier = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        refresh = new javax.swing.JButton();
        profs = new javax.swing.JButton();
        txtprenom = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableMatieres = new javax.swing.JTable(){

            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }

        };
        listesections = new javax.swing.JComboBox();
        listematieres = new javax.swing.JComboBox();
        ajoutAttr = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        txtmat = new javax.swing.JTextField();
        supprAttr = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtidsection = new javax.swing.JTextField();
        txtidmatiere = new javax.swing.JTextField();
        txtiddel = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nom", "Prénom", "Section", "Matière"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        modifier.setText("Modifier");
        modifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifierMouseClicked(evt);
            }
        });

        supprimer.setText("Supprimer");
        supprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supprimerMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Liste des professeurs:");

        jLabel3.setText("Nom");

        jLabel4.setText("Prénom");

        txtnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomActionPerformed(evt);
            }
        });

        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rafraichir.png"))); // NOI18N
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        profs.setText("Ajouter un professeur");
        profs.setDefaultCapable(false);
        profs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profsMouseClicked(evt);
            }
        });
        profs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profsActionPerformed(evt);
            }
        });

        txtprenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprenomActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Gestion Des Professeurs");
        jLabel1.setToolTipText("");

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        TableMatieres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Matière", "Section"
            }
        ));
        TableMatieres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMatieresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableMatieres);

        listesections.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                listesectionsPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        listematieres.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                listematieresPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        ajoutAttr.setText("Ajouter l'attribution");
        ajoutAttr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajoutAttrMouseClicked(evt);
            }
        });

        txtmat.setEditable(false);

        supprAttr.setText("Supprimer l'attribution");
        supprAttr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supprAttrMouseClicked(evt);
            }
        });

        jLabel5.setText("Section");

        jLabel6.setText("Matière");

        txtidsection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidsectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(profs, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtprenom, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(supprimer))
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtiddel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(supprAttr, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(62, 62, 62))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtmat, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(78, 78, 78))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtidsection, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtidmatiere, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(listesections, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(listematieres, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addComponent(ajoutAttr)
                                                .addGap(86, 86, 86))))
                                    .addComponent(jSeparator4))
                                .addGap(27, 27, 27))
                            .addComponent(jSeparator2)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profs, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtprenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(listesections, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listematieres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ajoutAttr)
                            .addComponent(txtidsection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidmatiere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(txtmat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(supprAttr)
                            .addComponent(txtiddel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(588, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:


        int row = jTable1.getSelectedRow();
        txtid.setText(jTable1.getModel().getValueAt(row, 0).toString());
        txtnom.setText(jTable1.getModel().getValueAt(row, 1).toString());
        txtprenom.setText(jTable1.getModel().getValueAt(row, 2).toString());
        Fillcombo();
        UpdateTableMatieres();


        
   
        

    }//GEN-LAST:event_jTable1MouseClicked

    private void modifierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifierMouseClicked
        // TODO add your handling code here:


        String sql="UPDATE professeurs set nom=?, prenom=? where idprof=?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtnom.getText());
            pst.setString(2, txtprenom.getText());
            pst.setString(3, txtid.getText());
            pst.executeUpdate();
            UpdateJTable();
            
                


        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_modifierMouseClicked

    private void supprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supprimerMouseClicked
        // TODO add your handling code here:
        int n = JOptionPane.showConfirmDialog(
                            null, "Confirmer la suppression?",
                            "Attention",
                            JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {

        String sql="delete from professeurs where idprof=?";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtid.getText());
            pst.execute();
            UpdateJTable();
            
            txtnom.setText("");
            txtprenom.setText("");
            txtid.setText("");
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        }
    }//GEN-LAST:event_supprimerMouseClicked

    private void txtnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomActionPerformed

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        // TODO add your handling code here:
        conn = mysqlconnect.ConnectDb();
        UpdateJTable();
    }//GEN-LAST:event_refreshMouseClicked

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshActionPerformed

    private void profsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profsMouseClicked
        // TODO add your handling code here:
        addProfsJFrame s = new addProfsJFrame();
        s.setVisible(true);

    }//GEN-LAST:event_profsMouseClicked

    private void profsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profsActionPerformed

    private void txtprenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprenomActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        conn = mysqlconnect.ConnectDb();
        UpdateJTable();
    }//GEN-LAST:event_formWindowOpened

    private void TableMatieresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMatieresMouseClicked
        // TODO add your handling code here:
        int row = TableMatieres.getSelectedRow();
        txtiddel.setText(TableMatieres.getModel().getValueAt(row, 0).toString());
        txtmat.setText(TableMatieres.getModel().getValueAt(row, 1).toString());
        
    }//GEN-LAST:event_TableMatieresMouseClicked

    private void txtidsectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidsectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidsectionActionPerformed

    private void listesectionsPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_listesectionsPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String tmp = (String)listesections.getSelectedItem();
        if(tmp!="Choisir"){
            String sql = "SELECT idsections FROM sections WHERE section = ?";
            try
            {
                pst=conn.prepareStatement(sql);
                pst.setString(1, tmp);
                rs = pst.executeQuery();
                if(rs.next())
                {
                    String add = rs.getString("idsections");
                    txtidsection.setText(add);
                    Fillcombo2(add);
                }
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_listesectionsPopupMenuWillBecomeInvisible

    private void listematieresPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_listematieresPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String tmp = (String)listematieres.getSelectedItem();
        if(tmp!="Choisir"){
            String sql = "SELECT idmatiere FROM matieres WHERE matiere = ?";
            try
            {
                pst=conn.prepareStatement(sql);
                pst.setString(1, tmp);
                rs = pst.executeQuery();
                if(rs.next())
                {
                    String add = rs.getString("idmatiere");
                    txtidmatiere.setText(add);
                }
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }        
    }//GEN-LAST:event_listematieresPopupMenuWillBecomeInvisible

    private void ajoutAttrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajoutAttrMouseClicked
        // TODO add your handling code here:
        conn= mysqlconnect.ConnectDb();

        String sql="UPDATE matieres set idprof=? WHERE idmatiere=? and idsection=?";
        try {

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txtid.getText());
            pst.setString(2, txtidmatiere.getText());
            pst.setString(3, txtidsection.getText());


            int rs = pst.executeUpdate();
       
            txtidsection.setText("");
            txtidmatiere.setText("");
            
            Fillcombo();
            listematieres.removeAllItems();
            UpdateTableMatieres();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }


    
    }//GEN-LAST:event_ajoutAttrMouseClicked

    private void supprAttrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supprAttrMouseClicked
        // TODO add your handling code here:
        conn= mysqlconnect.ConnectDb();

        String sql="UPDATE matieres set idprof=0 WHERE idmatiere=?";
        try {

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txtiddel.getText());


            int rs = pst.executeUpdate();
       
            txtiddel.setText("");
            txtmat.setText("");
            
            UpdateTableMatieres();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }        
    }//GEN-LAST:event_supprAttrMouseClicked

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
            java.util.logging.Logger.getLogger(menuProfsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuProfsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuProfsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuProfsJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuProfsJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableMatieres;
    private javax.swing.JButton ajoutAttr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox listematieres;
    private javax.swing.JComboBox listesections;
    private javax.swing.JButton modifier;
    private javax.swing.JButton profs;
    private javax.swing.JButton refresh;
    private javax.swing.JButton supprAttr;
    private javax.swing.JButton supprimer;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtiddel;
    private javax.swing.JTextField txtidmatiere;
    private javax.swing.JTextField txtidsection;
    private javax.swing.JTextField txtmat;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtprenom;
    // End of variables declaration//GEN-END:variables
}
