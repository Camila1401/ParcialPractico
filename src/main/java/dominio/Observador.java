package dominio;

public interface Observador {
    void notificarTiempoAgotado(Usuario usuario, Prestable prestable);
    void notificarAvisoAnticipado(Usuario usuario, Prestable prestable);
}
