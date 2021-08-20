package dominio;

public class Prestado implements Estado{
    @Override
    public Boolean validarPrestamo() {
        return false;
    }
}
