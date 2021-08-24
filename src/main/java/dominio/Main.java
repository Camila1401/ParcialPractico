package dominio;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Usuario celes = new Usuario("celeslvp",
                        42201903,
                        "lalaydidi@gmail.com",
                        true);

        Copia harryPotter1 = new Copia(1, "Harry Potter 1", Genero.FANTASIA);
        Copia harryPotter2 = new Copia(2, "Harry Potter 2", Genero.FANTASIA);
        Copia harryPotter3 = new Copia(1, "Harry Potter 3", Genero.FANTASIA);
        Copia naruto = new Copia(1, "Naruto - Arco Pain", Genero.MANGA);

        List<Copia> copias = new ArrayList<>();
        copias.add(harryPotter1);
        copias.add(harryPotter2);
        copias.add(harryPotter3);
        copias.add(naruto);

        ControladorPrestables controladorPrestables = new ControladorPrestables();
        ControladorPrestamos controladorPrestamos = new ControladorPrestamos(controladorPrestables);

        controladorPrestamos.crearPrestamo(celes, copias);

    }

}
