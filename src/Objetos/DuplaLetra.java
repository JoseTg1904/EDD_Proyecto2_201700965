package Objetos;

/**
 *
 * @author chepe
 */
public class DuplaLetra {

    private char caracter;
    private int frecuencia; 

    public DuplaLetra(char caracter) {
        this.caracter = caracter;
        this.frecuencia = 1;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }
           
}
