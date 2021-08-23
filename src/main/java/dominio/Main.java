package dominio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Usuario celes = new Usuario("celeslvp",
                        "42201903",
                        "lalaydidi@gmail.com",
                        new CalculadorMulta(),
                        true);

        Copia harryPotter1 = new Copia(5);
        Copia harryPotter2 = new Copia(5);
        Copia harryPotter3 = new Copia(5);

        List<Copia> copias = new ArrayList<>();
        copias.add(new Copia(1));
        copias.add(new Copia(2));
        copias.add(new Copia(3));

        ControladorPrestables controladorPrestables = new ControladorPrestables();
        controladorPrestables.generarPrestable(copias);


        //PrestableSimple prestableSimple = new PrestableSimple(harryPotter);

        //ControladorPrestamos controladorPrestamos = new ControladorPrestamos();
        //controladorPrestamos.crearPrestamo(celes, prestableSimple);

    }

}
