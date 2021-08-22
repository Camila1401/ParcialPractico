package dominio;

import java.util.List;

public class Usuario {
    private int id;
    private String nombreUsuario;
    private String nombre;
    private String dni;
    private String mail;
    private List<Prestamo> prestamos;
    private NotificadorMail notificadorMail;
    private CalculadorMulta calculadorMulta;

    public void notificar(Mensaje mensaje) {
        //notificadorMail.enviar(mail, mensaje.asunto, mensaje.cuerpo);

    }

    public int multa(){
        return calculadorMulta.calcularMulta(prestamos);
    }

    public void agregarPrestamo(Prestamo prestamo){
        prestamos.add(prestamo);
    }

    public void eliminarPrestamo(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }

    public boolean tieneMulta() {
        return calculadorMulta.calcularMulta(prestamos) != 0;
    }
}
