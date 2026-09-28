package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepartidorDAO {
    // metodo para listar todos los repartidores
    public List<String[]> listarTodos() {
        List<String[]> lista = new ArrayList<>();
        // consulta sql para obtener los datos
        String sql = "SELECT id, nombre FROM repartidor";

        // conexion y ejecucion de la consulta
        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // recorre los registros obtenidos
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String nombre = rs.getString("nombre");
                lista.add(new String[]{id, nombre});
            }

            // captura de errores sql
        } catch (SQLException e) {
            System.err.println("Error al listar repartidores: " + e.getMessage());
        }
        return lista;
    }
}