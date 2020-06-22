package Objetos;

import java.math.BigInteger;

/**
 *
 * @author chepe
 */
public class Cliente extends Persona {

    public Cliente(BigInteger dpi, String nombres, String apellidos, String genero, String fechaNac, String telefono, String direccion) {
        super(dpi, nombres, apellidos, genero, fechaNac, telefono, direccion);
    }
    
}
