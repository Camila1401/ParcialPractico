package dominio;

public class PrestableSimple extends Prestable {
    private Copia copia;

    PrestableSimple(Copia copia_){
        copia = copia_;
    }

    @Override
    public int cantidadDias() {
        return copia.cantidadDias();
    }

    @Override
    public void modificarEstado(Estado estado) {
        copia.modificarEstado(estado);
    }
}
