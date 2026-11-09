
public class Interfaz implements Runnable {
    GestorDatos gd;



    
    public Interfaz(GestorDatos gd) {
        this.gd = gd;
    }



    @Override
    public void run() {
        InterfazPregunta tp = new InterfazPregunta(gd);
        Normas normas = new Normas();
        InterfazJuego ij = new InterfazJuego(gd);
        InterfazResultado ir= new InterfazResultado(gd);
        Temporizador temp = new Temporizador();


        Thread hiloTemporizador = new Thread(temp);
        Thread hiloNormas = new Thread(normas);
        Thread hiloPregunta = new Thread(tp);
        Thread hiloJuego = new Thread(ij);
        Thread hiloResultado = new Thread(ir);


        hiloPregunta.start();
        try {
            hiloPregunta.join();
            hiloNormas.start();
            hiloNormas.join();
            hiloJuego.start();
            hiloTemporizador.start();
            hiloTemporizador.join();
            ij.cerrar();
            hiloResultado.start();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
