package vues;

import controls.paintComponent;
import controls.mysqlconnect;
import controls.fonctions;
import classes.*;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.TableColumn;
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
public class menuNoteJFrame extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    /**
     * Creates new form menuNoteJFrame
     */
    public menuNoteJFrame() {
               
        this.setContentPane(paintComponent.JP(500));
        
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
        jLabel3.setVisible(false);
        listeeleves.setVisible(false);
        idsection.setVisible(false);
        id_eleve.setVisible(false);
        newidmatiere.setVisible(false);
        txt_id_devoir.setVisible(false);
        txt_id_semestre.setVisible(false);
        labelsection.setVisible(false);
        listesections.setVisible(false);

    }
    private void UpdateJTable(){
    
    String sql="select idnote as ID, note as NOTE, matiere as MATIERE, coef as COEFFICIENT, commentaire as COMMENTAIRE from notes, matieres where notes.idmatiere=matieres.idmatiere and notes.idetudiant=? and notes.idsemestre=? ORDER BY notes.idmatiere";
  
    try{
    pst = conn.prepareStatement(sql);
    pst.setString(1, id_eleve.getText());
    pst.setString(2, txt_id_semestre.getText());
    rs = pst.executeQuery();
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    
    
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
}
    private void Fillcombo(){
            listesections.removeAllItems();
            String choose = "Choisir une section";
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
            listeeleves.removeAllItems();
            String choose = "Choisir un étudiant";
            listeeleves.addItem(choose);
            String sql="select prenom, nom from users where idsection=?";
            try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();
              while(rs.next()){
                  String P = rs.getString("prenom");
                  String N = rs.getString("nom");
                  String S = P+" - "+N;
                  listeeleves.addItem(S);
                  
              }
            }

            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }   
    }
    private void Fillcombo3(String id){
            listematieres.removeAllItems();
            String choose = "Choisir une matière";
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
    private void Fillcombo4(String id){
            listedevoirs.removeAllItems();
            listedevoirs.addItem("Aucun");
            String sql="select devoir from devoirs where idmatiere=? and idsemestre=?";
            try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, txt_id_semestre.getText());
            rs = pst.executeQuery();
              while(rs.next()){
                  String S = rs.getString("devoir");
                  listedevoirs.addItem(S);
              }
            }

            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }   
    }
    public static void openWebpage(URI uri) {
    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
        try {
            desktop.browse(uri);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelcoeff = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        listematieres = new javax.swing.JComboBox();
        ajouternote = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        consultation = new javax.swing.JButton();
        delbouton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        delnote = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        newidmatiere = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        newcommentaire = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        delid = new javax.swing.JTextField();
        newnote = new javax.swing.JFormattedTextField();
        newcoeff = new javax.swing.JFormattedTextField();
        devoirbutton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        listedevoirs = new javax.swing.JComboBox();
        txt_id_devoir = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txt_id_semestre = new javax.swing.JTextField();
        idsection = new javax.swing.JTextField();
        id_eleve = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        labelsection = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        listesemestres = new javax.swing.JComboBox();
        listesections = new javax.swing.JComboBox();
        listeeleves = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Gestion Des Notes");
        jLabel1.setToolTipText("");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NOTE", "MATIERE", "COEFFICIENT", "COMMENTAIRE"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setText("Note");

        jLabel5.setText("Matière");

        labelcoeff.setText("Coefficient");

        jLabel7.setText("/20");

        listematieres.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                listematieresPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        ajouternote.setText("Ajouter une Note");
        ajouternote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajouternoteMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Consultation");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Ajouter une Note");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Supprimer la Note");

        jLabel12.setText("Afin de consulter le bulletin de l'élève,");

        jLabel13.setText("cliquez sur le bouton consultation");

        consultation.setText("Consultation");
        consultation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consultationMouseClicked(evt);
            }
        });
        consultation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultationActionPerformed(evt);
            }
        });

        delbouton.setText("Supprimer la note");
        delbouton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delboutonMouseClicked(evt);
            }
        });
        delbouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delboutonActionPerformed(evt);
            }
        });

        jLabel8.setText("Note");

        delnote.setEditable(false);

        jLabel14.setText("/20");

        newidmatiere.setEditable(false);
        newidmatiere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newidmatiereActionPerformed(evt);
            }
        });

        jLabel15.setText("Commentaire (facultatif)");

        jLabel17.setText("ID");

        delid.setEditable(false);

        newnote.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("00.00"))));
        newnote.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                newnoteFocusLost(evt);
            }
        });
        newnote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newnoteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newnoteKeyTyped(evt);
            }
        });

        newcoeff.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("0"))));
        newcoeff.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                newcoeffFocusLost(evt);
            }
        });
        newcoeff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newcoeffKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newcoeffKeyTyped(evt);
            }
        });

        devoirbutton.setText("Ajouter un Devoir");
        devoirbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                devoirbuttonMouseClicked(evt);
            }
        });
        devoirbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devoirbuttonActionPerformed(evt);
            }
        });

        jLabel16.setText("Devoir (facultatif)");

        listedevoirs.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                listedevoirsPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(244, 250, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMaximumSize(new java.awt.Dimension(400, 100));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(320, 100));

        jLabel6.setText("Semèstre");

        labelsection.setText("Section ");

        jLabel3.setText("Elève");

        listesemestres.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir le Semèstre", "Premier Semèstre", "Second Semèstre" }));
        listesemestres.setMinimumSize(null);
        listesemestres.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                listesemestresPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        listesections.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                listesectionsPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        listesections.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listesectionsMouseClicked(evt);
            }
        });
        listesections.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listesectionsActionPerformed(evt);
            }
        });

        listeeleves.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                listeelevesPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_id_semestre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(idsection, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelsection))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(id_eleve, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listeeleves, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listesections, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listesemestres, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id_semestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(listesemestres, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idsection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelsection)
                    .addComponent(listesections, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_eleve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(listeeleves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(devoirbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(49, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel15))
                                    .addGap(28, 28, 28))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(newidmatiere, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_id_devoir, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(labelcoeff))
                                .addGap(60, 60, 60)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newcoeff, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newcommentaire, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ajouternote)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(listedevoirs, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(newnote, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7))
                                    .addComponent(listematieres, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(119, 119, 119)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13))
                    .addComponent(jLabel12)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(consultation))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(delid, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(delnote, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(delbouton))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(devoirbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(delid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(delnote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addComponent(delbouton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addGap(28, 28, 28)
                        .addComponent(consultation, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel10)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(newnote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(listematieres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listedevoirs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newcoeff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelcoeff))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newcommentaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ajouternote, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(newidmatiere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_id_devoir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        conn = mysqlconnect.ConnectDb();
        Fillcombo();

    }//GEN-LAST:event_formWindowOpened

    private void listesectionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listesectionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listesectionsActionPerformed

    private void listesectionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listesectionsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listesectionsMouseClicked

    private void listesectionsPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_listesectionsPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        idsection.setText("");
        String tmp = (String)listesections.getSelectedItem();
        String sql = "SELECT * FROM sections WHERE section = ?";
        try
        {
            pst=conn.prepareStatement(sql);
            pst.setString(1, tmp);
            rs = pst.executeQuery();
            if(rs.next()){
                String add = rs.getString("idsections");
                idsection.setText(add);
                Fillcombo2(add);
                
                listeeleves.setVisible(true);
                jLabel3.setVisible(true);
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_listesectionsPopupMenuWillBecomeInvisible

    private void listeelevesPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_listeelevesPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String tmp = (String)listeeleves.getSelectedItem();
        id_eleve.setText("");
        if(tmp!="Choisir un étudiant"){
        String[] temp = tmp.split(" - ");
        
            String sql = "SELECT userid, idsection FROM users WHERE prenom = ? and nom = ?";
            try
            {
                pst=conn.prepareStatement(sql);
                pst.setString(1, temp[0]);
                pst.setString(2, temp[1]);
                rs = pst.executeQuery();
                if(rs.next())
                {
                    String add = rs.getString("userid");
                    String idsection  = rs.getString("idsection");
                    id_eleve.setText(add);  
                    Fillcombo3(idsection);
                    UpdateJTable();
                }
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_listeelevesPopupMenuWillBecomeInvisible

    private void consultationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_consultationActionPerformed

    private void delboutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delboutonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delboutonActionPerformed

    private void consultationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultationMouseClicked
        // TODO add your handling code here:
        URI url = null;
        try {
        url = new URI("http://localhost/coinetudiants/bulletin-admin.php?ideleve="+id_eleve.getText()+"&semestre="+txt_id_semestre.getText()+"/");
        } catch (URISyntaxException ex) {
            Logger.getLogger(menuNoteJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        openWebpage(url);
    }//GEN-LAST:event_consultationMouseClicked

    private void ajouternoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajouternoteMouseClicked
        // TODO add your handling code here:
        
        conn= mysqlconnect.ConnectDb();
        String note2 = newnote.getText().replace(',', '.');
        
        if(listedevoirs.getSelectedIndex()!=0){
               String sql2="INSERT INTO notes(note, coef, idmatiere, idetudiant, commentaire, iddevoir, idsemestre) VALUES(?, (SELECT coef FROM devoirs WHERE iddevoir=?), ?, ?, ?, ?, ?)";
            try {

                PreparedStatement pst = conn.prepareStatement(sql2);
                pst.setString(1, note2);
                pst.setString(2, txt_id_devoir.getText());
                pst.setString(3, newidmatiere.getText());
                pst.setString(4, id_eleve.getText());
                pst.setString(5, newcommentaire.getText());
                pst.setString(6, txt_id_devoir.getText());
                pst.setString(7, txt_id_semestre.getText());

                int rs = pst.executeUpdate();
                
                newnote.setText("");
                newcoeff.setText("");
                UpdateJTable();
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null, "Un champ n'a pas correctement été remplis");
            }
        }
        else{
            String sql="INSERT INTO notes(note, coef, idmatiere, idetudiant, commentaire, idsemestre, iddevoir) VALUES(?, ?, ?, ?, ?, ?, 0)";
            try {

                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, note2);
                pst.setString(2, newcoeff.getText());
                pst.setString(3, newidmatiere.getText());
                pst.setString(4, id_eleve.getText());
                pst.setString(5, newcommentaire.getText());
                pst.setString(6, txt_id_semestre.getText());

                int rs = pst.executeUpdate();

                newnote.setText("");
                newcoeff.setText("");
                UpdateJTable();

            }
            catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Un champ n'a pas correctement été remplis");
                    }            
        }
        
        //ENVOI PAR MAIL DE LA NOTE DE L ELEVE
        
            String sql = "SELECT email, prenom, nom FROM users WHERE userid = ?";
            try
            {
                pst=conn.prepareStatement(sql);
                pst.setString(1, id_eleve.getText());
                rs = pst.executeQuery();
                if(rs.next())
                {
                    String mail_eleve = rs.getString("email");
                    
                    if(!mail_eleve.equals("email@host.com")){
                        
                            String prenom_eleve = rs.getString("prenom");
                            String nom_eleve = rs.getString("nom");

                            String mail_titre = "Nouvelle note saisie";

                            String mail_texte = "Bonjour "+prenom_eleve+" "+nom_eleve+" \n\n"
                                    + "Une nouvelle note de "+newnote.getText()+" a été saisie pour la matière"+(String)listematieres.getSelectedItem()+"\n"
                                    + "Cet email est automatique, il vous est donc demandé de ne pas y répondre";


                            sendMail.sendMessage(mail_titre, mail_texte, mail_eleve);
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "L'email de l'élève n'a pas été enregistré, il ne sera donc pas tenu informé de la saisie de cette note");
                    }
                    
                }
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        
    }//GEN-LAST:event_ajouternoteMouseClicked

    private void newidmatiereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newidmatiereActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newidmatiereActionPerformed

    private void newnoteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newnoteKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_newnoteKeyPressed

    private void newnoteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newnoteKeyTyped
        // TODO add your handling code here:
        fonctions.changerPoint(evt, newnote);
    }//GEN-LAST:event_newnoteKeyTyped

    private void newnoteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newnoteFocusLost
        // TODO add your handling code here:
        if(newnote.getText().length()>5){
          JOptionPane.showMessageDialog(null, "Mauvais format de note");
          newnote.setText("");           
        }
        else if(Float.parseFloat(newnote.getText())>20){
          JOptionPane.showMessageDialog(null, "La note ne peut être supérieure à 20");
          newnote.setText("");
        }
    }//GEN-LAST:event_newnoteFocusLost

    private void newcoeffFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newcoeffFocusLost
        // TODO add your handling code here:
        if(newcoeff.getText().length()>2){
          JOptionPane.showMessageDialog(null, "Mauvais format de coefficient");
          newcoeff.setText("");           
        }
    }//GEN-LAST:event_newcoeffFocusLost

    private void newcoeffKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newcoeffKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_newcoeffKeyPressed

    private void newcoeffKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newcoeffKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_newcoeffKeyTyped

    private void listematieresPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_listematieresPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String tmp = (String)listematieres.getSelectedItem();
        newidmatiere.setText("");
        if(tmp!="Choisir une matière"){
            String sql = "SELECT idmatiere FROM matieres WHERE matiere = ? and idsection = ?";
            try
            {
                pst=conn.prepareStatement(sql);
                pst.setString(1, tmp);
                pst.setString(2, idsection.getText());
                rs = pst.executeQuery();
                if(rs.next())
                {
                    String add = rs.getString("idmatiere");
                    newidmatiere.setText(add);
                    Fillcombo4(add);
                }
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_listematieresPopupMenuWillBecomeInvisible

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        delid.setText(jTable1.getModel().getValueAt(row, 0).toString());
        delnote.setText(jTable1.getModel().getValueAt(row, 1).toString());
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void delboutonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delboutonMouseClicked
        // TODO add your handling code here:
        
        int n = JOptionPane.showConfirmDialog(
                            null, "Confirmer la suppression?",
                            "Attention",
                            JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            String sql="delete from notes where idnote=?";
           try{
               pst = conn.prepareStatement(sql);
               pst.setString(1, delid.getText());
               pst.execute();
               UpdateJTable();
               
               delnote.setText("");
               delid.setText("");
           }

           catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
           }   
       }
        
        
    }//GEN-LAST:event_delboutonMouseClicked

    private void devoirbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devoirbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_devoirbuttonActionPerformed

    private void listedevoirsPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_listedevoirsPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        String tmp = (String)listedevoirs.getSelectedItem();
        txt_id_devoir.setText("");
        if(tmp!="Aucun"){
            String sql = "SELECT iddevoir FROM devoirs WHERE devoir = ? and idmatiere = ?";
            try
            {
                pst=conn.prepareStatement(sql);
                pst.setString(1, tmp);
                pst.setString(2, newidmatiere.getText());
                rs = pst.executeQuery();
                if(rs.next())
                {
                    String add = rs.getString("iddevoir");
                    txt_id_devoir.setText(add);
                }
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
            labelcoeff.setVisible(false);
            newcoeff.setVisible(false);
        }
        else{
            labelcoeff.setVisible(true);
            newcoeff.setVisible(true);
        }
    }//GEN-LAST:event_listedevoirsPopupMenuWillBecomeInvisible

    private void listesemestresPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_listesemestresPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
         String tmp = (String)listesemestres.getSelectedItem();
            txt_id_semestre.setText("");
            labelsection.setVisible(false);
            listesections.setVisible(false);
        if(tmp=="Premier Semèstre"){
            txt_id_semestre.setText("1");
            labelsection.setVisible(true);
            listesections.setVisible(true);
        }
        else if(tmp=="Second Semèstre"){
            txt_id_semestre.setText("2");
            labelsection.setVisible(true);
            listesections.setVisible(true);
                    
        }        
   
    }//GEN-LAST:event_listesemestresPopupMenuWillBecomeInvisible

    private void devoirbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_devoirbuttonMouseClicked
        // TODO add your handling code here:
        addDevoirJFrame s = new addDevoirJFrame();
        s.setVisible(true);
    }//GEN-LAST:event_devoirbuttonMouseClicked

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
            java.util.logging.Logger.getLogger(menuNoteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuNoteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuNoteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuNoteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuNoteJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouternote;
    private javax.swing.JButton consultation;
    private javax.swing.JButton delbouton;
    private javax.swing.JTextField delid;
    private javax.swing.JTextField delnote;
    private javax.swing.JButton devoirbutton;
    private javax.swing.JTextField id_eleve;
    private javax.swing.JTextField idsection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelcoeff;
    private javax.swing.JLabel labelsection;
    private javax.swing.JComboBox listedevoirs;
    private javax.swing.JComboBox listeeleves;
    private javax.swing.JComboBox listematieres;
    private javax.swing.JComboBox listesections;
    private javax.swing.JComboBox listesemestres;
    private javax.swing.JFormattedTextField newcoeff;
    private javax.swing.JTextField newcommentaire;
    private javax.swing.JTextField newidmatiere;
    private javax.swing.JFormattedTextField newnote;
    private javax.swing.JTextField txt_id_devoir;
    private javax.swing.JTextField txt_id_semestre;
    // End of variables declaration//GEN-END:variables
}
