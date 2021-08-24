package dominio;

public class UsuarioMapper {

    private String nombreUsuario;
    private int dni;
    private String mail;
    private boolean premium;

    public UsuarioMapper(String nombreUsuario, int dni, String mail, boolean premium) {
        this.nombreUsuario = nombreUsuario;
        this.dni = dni;
        this.mail = mail;
        this.premium = premium;
    }

    public int insert() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.insert(this.nombreUsuario, this.dni, this.mail, this.premium);

    }
}
