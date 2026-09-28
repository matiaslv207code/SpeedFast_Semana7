package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDAO {
    // metodo para guardar un pedido en la base de datos
    public void guardar(String direccion, String tipo, String estado) {
        // consulta sql parametrizada para insertar el pedido
        String sql = "INSERT INTO pedido (direccion, tipo, estado) VALUES (?, ?, ?)";

        // conexion y preparacion de la sentencia segura
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // asignacion de parametros
            pstmt.setString(1, direccion);
            pstmt.setString(2, tipo);
            pstmt.setString(3, estado);
            pstmt.executeUpdate();
            System.out.println("Pedido guardado exitosamente.");

            // captura de errores de base de datos
        } catch (SQLException e) {
            System.err.println("Error al guardar el pedido: " + e.getMessage());
        }
    }
}