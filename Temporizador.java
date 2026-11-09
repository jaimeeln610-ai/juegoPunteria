public class Temporizador implements Runnable{
    public Temporizador() {
    }

    @Override
    public void run() {
        long dormir = 10000;
        try {
            Thread.sleep(dormir);
            
            System.out.println("Se acabo el tiempo");
        } catch (Exception e) {
            System.err.println("Error en el temporizador");
        }
        
    }

}