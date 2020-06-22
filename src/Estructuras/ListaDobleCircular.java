package Estructuras;

import Objetos.Conductor;
import java.math.BigInteger;

/**
 *
 * @author chepe
 */
public class ListaDobleCircular {
    private NodoL cabeza, cola;
    private int tamanio;

    public Conductor buscar(BigInteger llave){
        Conductor conductor = null;
        NodoL aux = this.cabeza;
        
        do {            
            if(aux.getConductor().getDpi() == llave){
                conductor = aux.getConductor();
                break;
            }
            aux = aux.getSiguiente();
        } while(aux != this.cabeza);
        
        return conductor;
    }
    
    public boolean eliminar(BigInteger llave){
        boolean band = false;
        if(this.tamanio == 1){
            if(this.cabeza.getConductor().getDpi() == llave){
                this.cabeza = this.cola = null;
                this.tamanio--;
                band = true;
            }
        }else{
            NodoL aux = this.cabeza;
            do {                
                if(aux.getConductor().getDpi() == llave){
                    band = true;
                    this.tamanio--;
                    break;
                }
                aux = aux.getSiguiente();
            } while(aux != this.cabeza);
            
            if(band){
                aux.getAnterior().setSiguiente(aux.getSiguiente());
                aux.getSiguiente().setAnterior(aux.getAnterior());
                aux.setAnterior(null);
                aux.setSiguiente(null);
                if(aux == cabeza){
                    this.cabeza = this.cabeza.getSiguiente();
                }
                if(aux == cola){
                    this.cola = this.cola.getAnterior();
                }
            }
            
        }
        return band;
    }
    
    public void insertar(Conductor conductor){
        if(this.cabeza == null){
            this.cabeza = this.cola = new NodoL(conductor);
            this.cabeza.setAnterior(cola);
            this.cabeza.setSiguiente(cabeza);
            this.tamanio++;
        }else{
            NodoL nuevo = new NodoL(conductor, this.cabeza, this.cola);
            this.cola.setSiguiente(nuevo);
            this.cabeza.setAnterior(nuevo);
            this.cola = nuevo;
            this.tamanio++;
            this.ordenarAsc();
        }
    }
    
    private void ordenarAsc(){
        ordenarAsc(this.cabeza, 1);
    }
    
    private void ordenarAsc(NodoL temp, int tam){   
    if(tam <= this.tamanio){
        NodoL aux = this.cabeza;
        do {
            if(aux.getConductor().getDpi().compareTo(temp.getConductor().getDpi()) == 1){
                Conductor conductor = aux.getConductor();
                aux.setConductor(temp.getConductor());
                temp.setConductor(conductor);
            }
            aux = aux.getSiguiente();
        } while (aux != this.cabeza);
        tam++;
        this.ordenarAsc(temp.getSiguiente(),tam);
        }
    }
    
    public ListaDobleCircular(){
        this.cabeza = this.cola = null;
        this.tamanio = 0;
    }
    
}

class NodoL{
    private Conductor conductor;
    private NodoL anterior, siguiente;

    public NodoL(Conductor conductor, NodoL siguiente, NodoL anterior) {
        this.conductor = conductor;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }
    
    public NodoL(Conductor conductor){
        this.conductor = conductor;
        this.anterior = this.siguiente = null;
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