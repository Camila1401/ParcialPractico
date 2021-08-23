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

        Copia harryPotter1 = new Copia(5, "Harry Potter 1", Genero.FANTASIA);
        Copia harryPotter2 = new Copia(5, "Harry Potter 2", Genero.FANTASIA);
        Copia harryPotter3 = new Copia(5, "Harry Potter 3", Genero.FANTASIA);
        Copia naruto = new Copia(5, "Naruto - Arco Pain", Genero.MANGA);

        List<Copia> copias = new ArrayList<>();
        copias.add(harryPotter1);
        copias.add(harryPotter2);
        copias.add(harryPotter3);
        copias.add(naruto);

        ControladorPrestables controladorPrestables = new ControladorPrestables();
        controladorPrestables.generarPrestable(copias);


        //PrestableSimple prestableSimple = new PrestableSimple(harryPotter);

        //ControladorPrestamos controladorPrestamos = new ControladorPrestamos();
        //controladorPrestamos.crearPrestamo(celes, prestableSimple);

    }

}
