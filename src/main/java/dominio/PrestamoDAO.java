package dominio;

import java.sql.*;

public class PrestamoDAO {
    private Connection conn;

    public Connection newConnection() {
        Connection conn = null;
        try {
            String connectionUrl = "jdbc:mysql://localhost:3306/scoobydoo";
            conn = DriverManager.getConnection(connectionUrl, "root", "camila");

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

    public int insert(int id, int dias, int diasPrestado, int multa, int dniUsuario) {
        String consulta = "INSERT prestamo (id, dias, diasPrestado, multa, dniUsuario) VALUES (" + id + "," + dias + ", "+ diasPrestado + "," + multa + "," + dniUsuario + ");";
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
            ex.printStackTrace();
            //System.out.println("Error en Insert");
            return 0;
        }

    }

    public boolean updateDiasPrestado(int idPrestamo) {
        String consulta = "UPDATE prestamo SET diasPrestado = 0 WHERE id = " + idPrestamo + ";";

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

    public boolean delete(int idPrestamo) {
        String consulta = "DELETE FROM prestamo WHERE id = " + idPrestamo + ";";

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
