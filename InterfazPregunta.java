import javax.swing.*;
import java.awt.*;

public class InterfazPregunta implements Runnable {
    GestorDatos gd;
    

    public InterfazPregunta(GestorDatos gd) {
        this.gd = gd;
    }

    @Override
    public void run() {
        JTextField txtNombre = new JTextField(15);
        

        JPanel panel = new JPanel(new GridLayout(2, 2, 8, 8));
        panel.add(new JLabel("¿Cómo te llamas?"));
        panel.add(txtNombre);
       
        String nombre = "";
        
        boolean valido = false;

        while (!valido) {
            int opcion = JOptionPane.showConfirmDialog(null, panel, "Datos",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (opcion != JOptionPane.OK_OPTION) {
                return; // el usuario canceló
            }
            try {
                nombre = txtNombre.getText().trim();
                gd.setNombre(nombre);
                
                valido = true;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El área debe ser un número entero.",
                        "Dato no válido", JOptionPane.ERROR_MESSAGE);
            }
        }
        return ;
    }
}