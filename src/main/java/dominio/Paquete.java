package dominio;

import java.util.ArrayList;
import java.util.List;

public class Paquete extends Prestable{

    private List<Prestable> prestables;

    Paquete(){
        prestables = new ArrayList<>();
    }

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

    public void agregarPrestable(Prestable prestable){
        prestables.add(prestable);
    }
}

