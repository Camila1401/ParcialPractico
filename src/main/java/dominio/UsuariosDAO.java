package dominio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UsuariosDAO {

    private List<Usuario> usuarios;
    private Connection conn;

    public Connection newConnection() {
        Connection conn = null;
        try {
            String connectionUrl = "jdbc:mysql://localhost:3306/scoobydoo";
            conn = DriverManager.getConnection(connectionUrl, "root", "root");

            // Do something with the Connection
            System.out.println("Conexión realizada");

            return conn;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
        }
    }

    public List<Usuario> selectActivas() {

        try {

            // generacion de query
            String consulta = "SELECT * FROM usuario WHERE activo = 1";

            // Conexión
            this.conn = newConnection();

            // Ejecución
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            // Recorrer y usar cada línea retornada
            List<Usuario> usuarios = new ArrayList<>();

            while (rs.next()) {
                Usuario obj = new Usuario(rs.getString("nombreUsuario"), rs.getInt("dni"), rs.getString("mail"), rs.getBoolean("premium"));

                usuarios.add(obj);
            }

            return usuarios;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Select");
            return null;
        }
    }

}
