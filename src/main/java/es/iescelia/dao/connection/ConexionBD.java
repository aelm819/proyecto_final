package es.iescelia.dao.connection;

import java.sql.*;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/bigData";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    
    public static Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión a BD establecida.");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la BD: " + e.getMessage());
        }
        return conexion;
    }

}
