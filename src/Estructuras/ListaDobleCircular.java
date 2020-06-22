package Estructuras;

import Objetos.Conductor;

/**
 *
 * @author chepe
 */
public class ListaDobleCircular {
    private NodoL cabeza, cola;
    
    public ListaDobleCircular(){
        this.cabeza = null;
        this.cola = null;
    }
    
    public void insertar(Conductor conductor){
        if(this.cabeza == null){
            this.cabeza = this.cola = new NodoL(conductor);
            this.cabeza.setAnterior(cola);
            this.cabeza.setSiguiente(cabeza);
        }else{
            
        }
    }
}

class NodoL{
    private Conductor conductor;
    private NodoL anterior, siguiente;

    public NodoL(Conductor conductor, NodoL anterior, NodoL siguiente) {
        this.conductor = conductor;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }
    
    public NodoL(Conductor conductor){
        this.conductor = conductor;
        this.anterior = null;
        this.siguiente = null;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public NodoL getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoL anterior) {
        this.anterior = anterior;
    }

    public NodoL getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoL siguiente) {
        this.siguiente = siguiente;
    }
    
}