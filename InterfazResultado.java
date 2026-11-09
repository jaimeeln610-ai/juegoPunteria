import javax.swing.*;
import java.awt.*;

public class InterfazResultado implements Runnable {

    private JFrame ventana;
    private GestorDatos gd;


    

    public InterfazResultado(GestorDatos gd) {
        this.gd = gd;
    }




    @Override
    public void run() {
        ventana = new JFrame("Resultado");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setLayout(new GridLayout(2, 1));

        JLabel lblResultado = new JLabel("RESULTADO", SwingConstants.CENTER);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel lblPuntuacion = new JLabel("PUNTUACIÓN: " + gd.getPuntos(), SwingConstants.CENTER);
        lblPuntuacion.setFont(new Font("Arial", Font.BOLD, 24));

        ventana.add(lblResultado);
        ventana.add(lblPuntuacion);

        ventana.setSize(400, 250);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

}