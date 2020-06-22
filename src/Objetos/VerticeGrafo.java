package Objetos;

/**
 *
 * @author chepe
 */
public class VerticeGrafo {
    
    int peso;
    String nombre;

    public VerticeGrafo(String nombre, int peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public VerticeGrafo(String nombre) {
        this.nombre = nombre;
        this.peso = 0;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
