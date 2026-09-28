package cl.duoc.speedfast;

import cl.duoc.speedfast.gui.VentanaPrincipal;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // metodo principal que inicia la aplicacion
        SwingUtilities.invokeLater(() -> {
            // crea y muestra la ventana principal
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}