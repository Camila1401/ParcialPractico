package dominio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamosDAO {

    private List<Prestamo> prestamos;
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
}
