package falah.falah_api.config;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.Console;
import java.util.Properties;

public class EmailUtil {
    public static void sendEmail(String recipient, String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");                //default port 25  //587
        props.put("mail.smtp.starttls.enable", "true");   // Gmail requires TLS, server may not
        Session session = Session.getDefaultInstance(props);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("falahchemnitzteam@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message, "falahchemnitzteam", "falah2020" );  //pass needed
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
}
