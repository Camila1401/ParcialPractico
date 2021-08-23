package dominio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private final String nombreUsuario;
    private final String nombre;
    private final String dni;
    private String mail;
    private final List<Prestamo> prestamos;
    private NotificadorMail notificadorMail;
    private final CalculadorMulta calculadorMulta;
    private boolean premium;

    Usuario(String nombreUsuario_,String nombre_,String dni_, String mail_, CalculadorMulta calculador, boolean premium_){
        nombreUsuario = nombreUsuario_;
        nombre = nombre_;
        dni = dni_;
        mail = mail_;
        prestamos = new ArrayList<>();
        calculadorMulta = calculador;
        premium = premium_;
        notificadorMail = new NotificadorMail();
    }

    public void notificar(Mensaje mensaje) throws IOException {
        notificadorMail.enviar(mensaje.asunto, mail, mensaje.cuerpo);
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

    public boolean esUsuarioPremium(){
        return premium;
    }
}
