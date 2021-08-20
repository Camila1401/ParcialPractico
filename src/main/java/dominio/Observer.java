package dominio;

public interface Observer {
    void notificarTiempoAgotado(Usuario usuario, Prestable prestable);
    void notificarAvisoAnticipado(Usuario usuario, Prestable prestable);
}
