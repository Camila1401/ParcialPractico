package dominio;

public class ModificadorEstado implements Observer{

    @Override
    public void notificarTiempoAgotado(Usuario usuario, Prestable prestable) {
        prestable.modificarEstado(new Moroso());
    }

    @Override
    public void notificarAvisoAnticipado(Usuario usuario, Prestable prestable) { }
}
