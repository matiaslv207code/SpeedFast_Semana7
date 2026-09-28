package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EntregaDAO {
    // metodo para guardar una entrega en la base de datos
    public void guardar(int idPedido, int idRepartidor, String fecha, String hora) {
        // consulta sql parametrizada para insertar la entrega
        String sql = "INSERT INTO entrega (id_pedido, id_repartidor, fecha, hora) VALUES (?, ?, ?, ?)";

        // conexion y preparacion de la sentencia segura
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // asignacion de parametros
            pstmt.setInt(1, idPedido);
            pstmt.setInt(2, idRepartidor);
            pstmt.setString(3, fecha);
            pstmt.setString(4, hora);
            pstmt.executeUpdate();
            System.out.println("Entrega registrada exitosamente.");

            // captura de errores de base de datos
        } catch (SQLException e) {
            System.err.println("Error al registrar la entrega: " + e.getMessage());
        }
    }
}