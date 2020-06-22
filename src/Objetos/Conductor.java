package Objetos;

/**
 *
 * @author chepe
 */
public class Conductor extends Persona{
    private String licencia;

    public Conductor(String licencia, int dpi, String nombres, String apellidos, String genero, String telefono, String direccion) {
        super(dpi, nombres, apellidos, genero, telefono, direccion);
        this.licencia = licencia;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }
    
}
