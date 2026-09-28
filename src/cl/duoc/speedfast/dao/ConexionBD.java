package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // ruta de conexion a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/speedfast_db?useSSL=false&serverTimezone=UTC";
    // usuario de mysql
    private static final String USER = "root";
    // contrasena de acceso
    private static final String PASSWORD = "admin5356";

    // metodo que retorna la conexion activa
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}