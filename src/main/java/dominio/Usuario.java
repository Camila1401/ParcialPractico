package dominio;

import java.util.List;

public class Usuario {
    private int id;
    private String nombreUsuario;
    private String nombre;
    private String dni;
    private String mail;
    private List<Prestamo> prestamos;
    private NotificadorMail notificadorMail;

    public void notificar(Mensaje mensaje) {
        notificadorMail.enviar(mail, mensaje.asunto, mensaje.cuerpo);
    }
}
