package dominio;

public class ModificadorEstado implements Observador {

    @Override
    public void notificarTiempoAgotado(Usuario usuario, Prestable prestable) {
        prestable.modificarEstado(new Moroso());
    }

    @Override
    public void notificarAvisoAnticipado(Usuario usuario, Prestable prestable) { }
}
