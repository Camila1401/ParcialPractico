package dominio;

import java.util.List;

public class Paquete extends Prestable{

    private List<Prestable> prestables;

    @Override
    public int cantidadDias() {
        int total = 3;
        for (Prestable prestable : prestables) {
            total += prestable.cantidadDias();
        }
        return total; //horrible pero no me salia de otra forma u.u
    }

    @Override
    public void modificarEstado(Estado estado) {
        prestables.forEach(prestable -> prestable.modificarEstado(estado));
    }
}
