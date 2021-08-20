package dominio;

public class EnBiblioteca implements Estado{
    @Override
    public Boolean validarPrestamo() {
        return true;
    }
}
