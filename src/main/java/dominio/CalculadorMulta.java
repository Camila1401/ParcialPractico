package dominio;

import java.util.List;

public class CalculadorMulta {

    public int calcularMulta(List<Prestamo> prestamos){
        int total = 0;
        for (Prestamo prestamo : prestamos) {
            total += prestamo.multa();
        }
        return total;
    }
}
