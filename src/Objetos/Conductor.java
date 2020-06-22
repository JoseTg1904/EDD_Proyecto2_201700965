package Objetos;

import java.math.BigInteger;

/**
 *
 * @author chepe
 */
public class Conductor extends Persona{
    private String licencia;

    public Conductor(String licencia, BigInteger dpi, String nombres, String apellidos, String genero, String fechaNac, String telefono, String direccion) {
        super(dpi, nombres, apellidos, genero, fechaNac, telefono, direccion);
        this.licencia = licencia;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }
    
}
