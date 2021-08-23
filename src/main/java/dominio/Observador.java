package dominio;

import java.io.IOException;

public interface Observador {
    void notificarTiempoAgotado(Usuario usuario, Prestable prestable) throws IOException;
    void notificarAvisoAnticipado(Usuario usuario, Prestable prestable) throws IOException;
}
