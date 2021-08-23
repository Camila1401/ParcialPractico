package dominio;

import java.io.IOException;

public class Notificador implements Observador {
    @Override
    public void notificarTiempoAgotado(Usuario usuario, Prestable prestable) throws IOException {
        usuario.notificar(new MensajeTiempoAgotado());
    }

    @Override
    public void notificarAvisoAnticipado(Usuario usuario, Prestable prestable) throws IOException {
        usuario.notificar(new MensajeAvisoPrevio());
    }
}
