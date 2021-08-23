package dominio;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Usuario celes = new Usuario("celeslvp",
                        "Celeste",
                        "42201903",
                        "lalaydidi@gmail.com",
                        new CalculadorMulta(),
                        true);

        Copia harryPotter = new Copia(5);

        PrestableSimple prestableSimple = new PrestableSimple(harryPotter);

        ControladorPrestamos controladorPrestamos = new ControladorPrestamos();
        controladorPrestamos.crearPrestamo(celes, prestableSimple);

    }

}
