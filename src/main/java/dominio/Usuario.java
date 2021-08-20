package dominio;

import java.util.List;

public class Usuario {
    private int id;
    private String nombreUsuario;
    private String nombre;
    private String dni;
    private List<Prestamo> prestamos;
    private Multa multa;

    public void notificar(Mensaje mensaje) {
    }
}
