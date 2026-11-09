public class App {
    public static void main(String[] args) {
        GestorDatos gd = new GestorDatos();
        Interfaz ui = new Interfaz(gd);

        Thread hiloInterfaz = new Thread(ui);
        hiloInterfaz.start();
        
    }
}
