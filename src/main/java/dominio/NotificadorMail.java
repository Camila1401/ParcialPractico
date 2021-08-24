package dominio;
// using SendGrid's Java Library
// https://github.com/sendgrid/sendgrid-java
import com.sendgrid.*;

import java.io.IOException;

public class NotificadorMail {

    public void enviar(String asunto, String mailDestino, String cuerpo) throws IOException {
        Email from = new Email("cberro@frba.utn.edu.ar");
        Email to = new Email(mailDestino);
        Content content = new Content("text/plain", cuerpo);
        Mail mail = new Mail(from, asunto, to, content);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            //System.out.println(response.getStatusCode());
            //System.out.println(response.getBody());
            //System.out.println(response.getHeaders());
            System.out.println("mail enviado");
        } catch (IOException ex) {
            throw ex;
        }

    }
}