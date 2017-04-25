/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;
import java.util.Formatter;
import controls.mysqlconnect;
/**
 *
 * @author Mickaël
 */
public class fonctions {
    
    static Connection conn = null;
    static ResultSet rs=null;
    static PreparedStatement pst=null;

    
    
    public static void changerPoint(java.awt.event.KeyEvent evt, JFormattedTextField textfield){
               
        if(evt.getKeyChar()== '.'){
            evt.setKeyChar(',');
        }
        
    }
    
    
    public static String encryptPassword(String password){
    String sha1 = "";
    try
    {
        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(password.getBytes("UTF-8"));
        sha1 = byteToHex(crypt.digest());
    }
    catch(NoSuchAlgorithmException e)
    {
        e.printStackTrace();
    }
    catch(UnsupportedEncodingException e)
    {
        e.printStackTrace();
    }
    return sha1;
}
    public static String byteToHex(final byte[] hash){
        Formatter formatter = new Formatter(); 
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
}
    
    public static boolean isDoublon(String champ, String colonne, String table){
        String result="";
        conn= mysqlconnect.ConnectDb();
        
        String sql= " SELECT   "+colonne+"     FROM    "+table+"   WHERE   "+colonne+"   =     ? ";
        try {

            pst = conn.prepareStatement(sql);
            pst.setString(1, champ);
            

            rs = pst.executeQuery();

      
            if( rs.next() ){
                result="true";
            }
            rs.close();
            pst.close();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        if(result=="true"){
            return true;
        }
        else{
            return false;
        }
    }
    

}
