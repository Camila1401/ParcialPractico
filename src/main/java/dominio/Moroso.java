package dominio;

public class Moroso implements Estado{
    @Override
    public Boolean validarPrestamo() {
        return false;
    }
}
