/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.modelo;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.javalite.activejdbc.Base;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Sadhu
 */
public class Util {
    public static void conectarBD(){
        Base.open(PropertiesLoader.driver, PropertiesLoader.url, PropertiesLoader.user,PropertiesLoader.password);
    }
    public static String encriptar(String password){
        MessageDigest md = null;
            
        try {
            //MD5
            md= MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] mb = md.digest();
            String hash = (new BASE64Encoder()).encode(mb);
            return hash;
            
        } catch (NoSuchAlgorithmException e) {
            //Error
        }
        return null;
    }
    
    public static void enviarCorreo(String from, String to, String asunto,String mensaje){
      final String username = "carlos.sadhu";//change accordingly
      final String password = "yosoyfitopaez";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");
      

      // Get the Session object.
      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));

         // Set Subject: header field
         message.setSubject(asunto);
         
         // Send the actual HTML message, as big as you like
         message.setContent(mensaje,"text/html");

         // Send message
         Transport.send(message);


      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
    }
}
