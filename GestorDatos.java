public class GestorDatos {
    private String Nombre;
    private int puntos = 0;

    public GestorDatos() {
    }


    public String getNombre() {
        return Nombre;
    }


    public void setNombre(String nombre) {
        Nombre = nombre;
    }



    public void incrementarPuntos(){
        puntos++;
    }


    public int getPuntos() {
        return puntos;
    }


    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
}
