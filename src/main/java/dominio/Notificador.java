package dominio;

import java.io.IOException;

public class Notificador implements Observador {

    private NotificadorMail notificadorMail;

    Notificador(){
        notificadorMail = new NotificadorMail();
    }

    @Override
    public void notificarTiempoAgotado(Usuario usuario, Prestable prestable) throws IOException {
        MensajeTiempoAgotado mensaje = new MensajeTiempoAgotado();
        notificadorMail.enviar(mensaje.asunto, usuario.mail(), mensaje.cuerpo);
    }

    @Override
    public void notificarAvisoAnticipado(Usuario usuario, Prestable prestable) throws IOException {
        MensajeTiempoAgotado mensaje = new MensajeTiempoAgotado();
        notificadorMail.enviar(mensaje.asunto, usuario.mail(), mensaje.cuerpo);
    }
}
