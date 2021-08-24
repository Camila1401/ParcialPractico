package dominio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class Prestamo {
    private int id = 0;
    private final List<Observador> observadores;
    private Usuario usuario;
    private final int dias;
    private int diasPrestado;
    private final Prestable prestable;
    private int multa;
    private final Timer timer;
    private TipoPrestamo tipoPrestamo;
    private Operaciones registradorOperaciones;

    public Prestamo(List<Observador> observadores_, Usuario usuario_, Prestable prestablePrestamo, ControladorPrestamos controlador){
        observadores = observadores_;
        usuario = usuario_;
        prestable = prestablePrestamo;
        dias = prestable.cantidadDias();
        diasPrestado = 0;
        multa = 0;
        timer = new Timer();
        registradorOperaciones = new OperacionesNoSQL();
        registradorOperaciones.registrar(new OpCreacionPrestamo(prestablePrestamo, usuario.nombreUsuario(), this));

        PrestamoMapper oMapper = new PrestamoMapper(this.id, this.dias, this.diasPrestado, this.multa);
        //this.id = oMapper.insert();
    }



    public void elegirTipo(TipoPrestamo tipo){
        tipoPrestamo = tipo;
    }

    public void arrancarTimer(){
        timer.schedule(tipoPrestamo.prestamoCorriendo(), new Date(), 1000);
    }

    public void notificarTiempoAgotado(){
        registradorOperaciones.registrar(new OpMorosidad(diasPrestado, this));
        observadores.forEach(observador -> {
            try {
                observador.notificarTiempoAgotado(usuario, prestable);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void notificarAvisoAnticipado(){
        observadores.forEach(observador -> {
            try {
                observador.notificarAvisoAnticipado(usuario, prestable);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public Prestable prestable(){
        return prestable;
    }

    public void agregarDiaMulta(int cantidad) {
        multa += cantidad;
    }

    public int dias() {
        return dias;
    }

    public int diasPrestado() {
        return diasPrestado;
    }

    public void sumarDiaPrestado(){
        diasPrestado += 1;
    }

    public Usuario usuario() {
        return usuario;
    }

    public int multa(){
        return multa;
    }

    public boolean hayMulta() {
        return multa != 0;
    }

    public void restarDiaMulta(int cantidad){
        multa -= cantidad;
    }

    public Timer timer() {
        return timer;
    }

    public void devueltoConMulta() {
        timer.cancel();
        timer.purge();
        timer.schedule(tipoPrestamo.prestamoDevuelto(), new Date(), 86400000);
    }
}


