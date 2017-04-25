/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.*;

/**
 *
 * @author Mickaël
 */
public class sendMail {
    
    public static void sendMessage(String subject, String text, String destinataire) { 
        
    // 1 -> Création de la session 
    Properties properties = new Properties(); 
    properties.setProperty("mail.transport.protocol", "smtp"); 
    properties.setProperty("mail.smtp.host", SMTP_HOST1); 
    properties.setProperty("mail.smtp.user", LOGIN_SMTP1); 
    properties.setProperty("mail.from", ACCOUNT1); 
    Session session = Session.getInstance(properties); 
    
    
    // 2 -> Création du message 
    MimeMessage message = new MimeMessage(session); 
    try { 
        message.setText(text); 
        message.setSubject(subject); 
        message.addRecipients(Message.RecipientType.TO, destinataire); 
    } catch (MessagingException e) { 
        e.printStackTrace(); 
    } 
    
    
    // 3 -> Envoi du message 
    try { 
        Transport transport = session.getTransport("smtp"); 
        transport.connect(LOGIN_SMTP1, PASSWORD_SMTP1); 
        transport.sendMessage(message, new Address[] { new InternetAddress(destinataire), 
                                                        new InternetAddress(copyDest) }); 
    } catch (MessagingException e) { 
        e.printStackTrace(); 
    } finally { 
        try { 
            if (transport != null) { 
                transport.close(); 
            } 
        } catch (MessagingException e) { 
            e.printStackTrace(); 
        } 
    } 
} 
    
}
