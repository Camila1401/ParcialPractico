package dominio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int id;
    private String nombreUsuario;
    private int dni;
    private String mail;
    private List<Prestamo> prestamos;
    private NotificadorMail notificadorMail;
    private CalculadorMulta calculadorMulta;
    private boolean premium;

    Usuario(String nombreUsuario_,int dni_, String mail_, boolean premium_) {
        nombreUsuario = nombreUsuario_;
        dni = dni_;
        mail = mail_;
        prestamos = new ArrayList<>();
        calculadorMulta = new CalculadorMulta();
        premium = premium_;
        notificadorMail = new NotificadorMail();

        UsuarioMapper oMapper = new UsuarioMapper(this.nombreUsuario, this.dni, this.mail, this.premium);
        this.id = oMapper.insert();
    }

    public boolean baja() {
        UsuarioDAO oUsuarioDAO = new UsuarioDAO();
        return oUsuarioDAO.updateActivo(this.id);
    }

    public boolean bajaTotal() {
        UsuarioDAO oUsuarioDAO = new UsuarioDAO();
        return oUsuarioDAO.delete(this.id);
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

    public String nombreUsuario() {
        return nombreUsuario;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
