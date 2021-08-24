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

    public List<Prestamo> selectDiasPrestadoMayorA(int dias) {

        try {

            // generacion de query
            String consulta = "SELECT * FROM prestamo WHERE diasPrestado > dias";

            // Conexión
            this.conn = newConnection();

            // Ejecución
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            // Recorrer y usar cada línea retornada
            List<Prestamo> prestamos = new ArrayList<>();

            while (rs.next()) {
                Prestamo obj = new Prestamo(rs.getInt("id"), rs.getInt("dias"), rs.getInt("diasPrestado"), rs.getInt("multa"));

                prestamos.add(obj);
            }

            return prestamos;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Select");
            return null;
        }
    }
}
