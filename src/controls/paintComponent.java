/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Mickaël
 */
public class paintComponent {
    
public static JPanel JP(int taille){
    JPanel fenetre = new JPanel(){
protected void paintComponent(Graphics grphcs) {
            
    
            
            super.paintComponent(grphcs);
            Graphics2D g2d = (Graphics2D) grphcs;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            
            Color color1 = Color.WHITE;
            Color color2 = new Color(102, 153, 255);
            
            GradientPaint gp = new GradientPaint(0, taille,
                    color1, 0, getHeight(),
                    color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight()); 
            
            
                }
               
      };
    return fenetre;

    }      
}