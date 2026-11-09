import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class InterfazJuego implements Runnable {

    private static final int N = 20;
    private GestorDatos gd;
    private final JButton[][] botones = new JButton[N][N];
    private final Random rnd = new Random();
    private JButton amarillo;
    private JFrame ventana = new JFrame("Juego");
    

    public InterfazJuego(GestorDatos gd) {
        this.gd = gd;
    }

    @Override
    public void run() {
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());

        // NORTH: el texto
        JLabel lblTitulo = new JLabel("¡ SUERTE !", SwingConstants.CENTER);
        ventana.add(lblTitulo, BorderLayout.NORTH);

        // CENTER: cuadrícula de 20x20 botones grises
        JPanel panelBotones = new JPanel(new GridLayout(N, N));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                JButton b = new JButton();
                b.setBackground(new Color(30, 41, 59));
                b.setOpaque(true);
                b.setBorderPainted(false);
                b.addActionListener(e -> {
                    gd.incrementarPuntos();
                    // Solo reacciona el botón amarillo
                    if (b == amarillo) {
                        moverAmarillo();
                    }
                });
                botones[i][j] = b;
                panelBotones.add(b);
            }
        }
        ventana.add(panelBotones, BorderLayout.CENTER);

        // Un botón aleatorio empieza en amarillo
        amarillo = botonAleatorio();
        amarillo.setBackground(new Color(34, 211, 238));

        ventana.setSize(700, 750);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    private JButton botonAleatorio() {
        return botones[rnd.nextInt(N)][rnd.nextInt(N)];
    }

    private void moverAmarillo() {
        JButton nuevo;
        do {
            nuevo = botonAleatorio();
        } while (nuevo == amarillo); 

        amarillo.setBackground(new Color(30, 41, 59));
        nuevo.setBackground(new Color(34, 211, 238));
        amarillo = nuevo;
    }

    public void cerrar() {
        if (ventana!=null) {
            System.out.println("Puntos totales: " + gd.getPuntos());
            ventana.dispose();
        }
    }



}