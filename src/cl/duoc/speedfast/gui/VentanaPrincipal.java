package cl.duoc.speedfast.gui;

import dao.PedidoDAO;
import dao.ConexionBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// clase principal de la interfaz grafica
public class VentanaPrincipal extends JFrame {

    private JTextField txtDireccion;
    private JComboBox<String> cbTipo;
    private JTable jTablePedidos;
    private DefaultTableModel modeloTabla;

    // constructor de la ventana
    public VentanaPrincipal() {
        setTitle("SpeedFast - Gestión de Pedidos");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // panel superior para el formulario de registro
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Registrar Nuevo Pedido"));

        panelFormulario.add(new JLabel(" Dirección:"));
        txtDireccion = new JTextField();
        panelFormulario.add(txtDireccion);

        panelFormulario.add(new JLabel(" Tipo de Pedido:"));
        cbTipo = new JComboBox<>(new String[]{"COMIDA", "ENCOMIENDA", "EXPRESS"});
        panelFormulario.add(cbTipo);

        JButton btnGuardar = new JButton("Guardar Pedido");
        panelFormulario.add(btnGuardar);

        add(panelFormulario, BorderLayout.NORTH);

        // configuracion de la tabla central
        modeloTabla = new DefaultTableModel(new String[]{"ID", "Dirección", "Tipo", "Estado"}, 0);
        jTablePedidos = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(jTablePedidos);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Pedidos en BD"));

        add(scrollPane, BorderLayout.CENTER);

        // accion del boton para guardar el pedido
        btnGuardar.addActionListener((ActionEvent e) -> {
            String direccion = txtDireccion.getText().trim();
            String tipo = cbTipo.getSelectedItem().toString();
            String estado = "PENDIENTE";

            // validacion de campos vacios
            if (direccion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese una dirección.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // guarda el pedido usando el dao
            PedidoDAO pedidoDAO = new PedidoDAO();
            pedidoDAO.guardar(direccion, tipo, estado);

            JOptionPane.showMessageDialog(this, "¡Pedido guardado exitosamente!");
            txtDireccion.setText("");
            cargarTablaPedidos();
        });

        cargarTablaPedidos();
    }

    // metodo para consultar la base de datos y llenar la tabla
    private void cargarTablaPedidos() {
        modeloTabla.setRowCount(0);
        String sql = "SELECT id, direccion, tipo, estado FROM pedido";

        // conexion y consulta de los datos
        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // recorre los resultados y los agrega a la tabla
            while (rs.next()) {
                Object[] fila = {
                        rs.getInt("id"),
                        rs.getString("direccion"),
                        rs.getString("tipo"),
                        rs.getString("estado")
                };
                modeloTabla.addRow(fila);
            }

            // captura de errores sql
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar la tabla: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}