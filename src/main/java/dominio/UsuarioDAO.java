package dominio;

import java.sql.*;

public class UsuarioDAO {

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

    public int insert(String nombreUsuario, int dni, String mail, boolean premium) {
        String consulta = "INSERT INTO usuario (nombreUsuario, dni, mail, premium) VALUES ('" + nombreUsuario + "','" + dni + "','" + mail + "'," + premium + ");";

        try {

            this.conn = newConnection();

            // Ejecución
            PreparedStatement stmt = this.conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

            // execute the preparedstatement
            stmt.executeUpdate();

            // obtener último id generado
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
                return generatedKeys.getInt(1);
            else
                return 0;


        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Insert");
            return 0;
        }

    }

    public boolean updateActivo(int idUsuario) {
        String consulta = "UPDATE usuario SET activo = 0 WHERE id = " + idUsuario + ";";

        try {

            this.conn = newConnection();

            // Ejecución
            PreparedStatement stmt = this.conn.prepareStatement(consulta);

            // execute the preparedstatement
            stmt.executeUpdate();
            return true;


        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Update");
            return false;
        }

    }

    public boolean delete(int idUsuario) {
        String consulta = "DELETE FROM usuario WHERE id = " + idUsuario + ";";

        try {

            this.conn = newConnection();

            // Ejecución
            PreparedStatement stmt = this.conn.prepareStatement(consulta);

            // execute the preparedstatement
            stmt.execute();
            return true;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Delete");
            return false;
        }

    }
}
