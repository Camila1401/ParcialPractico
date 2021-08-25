package dominio;

public class PrestamoMapper {

    private int id;
    private int dias;
    private int diasPrestado;
    private int multa;
    private int dniUsuario;

    public PrestamoMapper(int id, int dias, int diasPrestado, int multa) {
        this.id = id;
        this.dias = dias;
        this.diasPrestado = diasPrestado;
        this.multa = multa;
        this.dniUsuario = dniUsuario;
    }

    public int insert() {
        PrestamoDAO prestamoDAO = new PrestamoDAO();
        return prestamoDAO.insert(this.id, this.dias, this.diasPrestado, this.multa, this.dniUsuario);

    }
}
