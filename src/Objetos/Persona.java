package Objetos;

import java.math.BigInteger;

/**
 *
 * @author chepe
 */
public class Persona {
    private BigInteger dpi;
    private String nombres, apellidos, genero, fechaNac, telefono, direccion;
    
    public Persona(BigInteger dpi, String nombres, String apellidos, String genero, String fechaNac, String telefono, String direccion){
        this.dpi = dpi;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
        this.genero = genero;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public BigInteger getDpi() {
        return dpi;
    }

    public void setDpi(BigInteger dpi) {
        this.dpi = dpi;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
