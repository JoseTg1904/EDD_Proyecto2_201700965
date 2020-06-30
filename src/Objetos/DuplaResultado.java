package Objetos;
/**
 *
 * @author chepe
 */
public class DuplaResultado {
    private Character caracter;
    private String codigo;

    public DuplaResultado(Character caracter, String codigo) {
        this.caracter = caracter;
        this.codigo = codigo;
    }

    public Character getCaracter() {
        return caracter;
    }

    public void setCaracter(Character caracter) {
        this.caracter = caracter;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
}
