package dominio;

import java.util.List;

public class Paquete extends Prestable{

    private List<Prestable> prestables;

    @Override
    public int cantidadDias() {
        return 3; //esto esta mal, habria q recorrer la lista e ir sumando y dsp sumarle 3
    }

    @Override
    public void modificarEstado(Estado estado) {
        prestables.forEach(prestable -> prestable.modificarEstado(estado));
    }
}
