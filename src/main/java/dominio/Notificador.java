package dominio;

public class Notificador implements Observador {
    @Override
    public void notificarTiempoAgotado(Usuario usuario, Prestable prestable) {
        usuario.notificar(new MensajeTiempoAgotado());
    }

    @Override
    public void notificarAvisoAnticipado(Usuario usuario, Prestable prestable) {
        usuario.notificar(new MensajeAvisoPrevio());
    }
}
