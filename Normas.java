import javax.swing.*;
import java.awt.*;

public class Normas implements Runnable {

    private final String normas = "El juego trata de acertar con punteria al cuadradito amarillo en 10 segundos (No apto para menores ni personas con problemas cardiovasculares)";
    private JDialog ventana;

    public Normas() {

    }

    @Override
    public void run() {
        ventana = new JDialog((Frame) null, "Normas", true);
        ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ventana.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("NORMAS", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));

        JTextArea txtNormas = new JTextArea(normas);
        txtNormas.setFont(new Font("Arial", Font.BOLD, 14));
        txtNormas.setEditable(false);
        txtNormas.setOpaque(false);
        txtNormas.setLineWrap(true); // las líneas largas bajan solas
        txtNormas.setWrapStyleWord(true); // sin cortar palabras a medias
        txtNormas.setMargin(new Insets(10, 15, 10, 15));

        JScrollPane scroll = new JScrollPane(txtNormas);
        scroll.setBorder(null);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);

        JButton btnCerrar = new JButton("CERRAR");
        btnCerrar.addActionListener(e -> ventana.dispose());

        ventana.add(lblTitulo, BorderLayout.NORTH);
        ventana.add(scroll, BorderLayout.CENTER);
        ventana.add(btnCerrar, BorderLayout.SOUTH);

        ventana.setSize(400, 250);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

}
