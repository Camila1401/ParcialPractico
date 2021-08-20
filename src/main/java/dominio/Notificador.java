package dominio;

public class Notificador implements Observer{
    @Override
    public void notificarTiempoAgotado(Usuario usuario, Prestable prestable) {
        usuario.notificar(new MensajeTiempoAgotado());
    }

    @Override
    public void notificarAvisoAnticipado(Usuario usuario, Prestable prestable) {
        usuario.notificar(new MensajeAvisoPrevio());
    }
}
