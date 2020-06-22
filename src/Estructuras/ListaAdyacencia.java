package Estructuras;

import Objetos.VerticeGrafo;

/**
 *
 * @author chepe
 */
public class ListaAdyacencia {
    
    private NodoLA cabeza;

    public void insertarOrigen(VerticeGrafo verticeGrafo){
        if(cabeza == null){
            cabeza = new NodoLA(verticeGrafo);
        }else{
            NodoLA nuevo = new NodoLA(verticeGrafo, cabeza);
            cabeza = nuevo;
        }
    }
    
    public void insertarAdyacente(VerticeGrafo verticeGrafo, String llave){
        NodoLA origen = devolverOrigen(llave);
        if(origen != null){
            while(origen.getAdyacente() != null){
                origen = origen.getAdyacente();
            }
            origen.setAdyacente(new NodoLA(verticeGrafo));
        }
    }
    
    private NodoLA devolverOrigen(String llave){
        NodoLA retorno = null;
        NodoLA aux = this.cabeza;
        while(aux != null){
            if(aux.getVerticeGrafo().getNombre().equals(llave)){
                retorno = aux;
                break;
            }
            aux = aux.getSiguiente();
        }
        return retorno;
    }
    
    public ListaAdyacencia() {
        this.cabeza = null;
    }
    
}

class NodoLA{
    
    private NodoLA siguiente, adyacente;
    private VerticeGrafo verticeGrafo;

    public NodoLA(VerticeGrafo verticeGrafo) {
        this.verticeGrafo = verticeGrafo;
        this.siguiente = this.adyacente = null;
    }
    
    public NodoLA(VerticeGrafo verticeGrafo, NodoLA siguiente) {
        this.verticeGrafo = verticeGrafo;
        this.siguiente = siguiente; 
        this.adyacente = null;
    }

    public NodoLA getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLA siguiente) {
        this.siguiente = siguiente;
    }

    public NodoLA getAdyacente() {
        return adyacente;
    }

    public void setAdyacente(NodoLA adyacente) {
        this.adyacente = adyacente;
    }

    public VerticeGrafo getVerticeGrafo() {
        return verticeGrafo;
    }

    public void setVerticeGrafo(VerticeGrafo verticeGrafo) {
        this.verticeGrafo = verticeGrafo;
    }
    
}