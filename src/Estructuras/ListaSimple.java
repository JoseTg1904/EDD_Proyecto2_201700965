package Estructuras;

import Objetos.VerticeGrafo;

/**
 *
 * @author chepe
 */
public class ListaSimple {
    
    private NodoLS cabeza, cola;

    public void insertar(String lugar, String tiempo){
        String contenido = lugar+"|"+tiempo;
        if(cabeza == null){
            cola = cabeza = new NodoLS(contenido);
        }else{
            NodoLS nuevo = new NodoLS(contenido);
            cola.setSiguiente(nuevo);
            cola = nuevo;
        }
    }
    
    public String grafoParcial(int it){
        String dot = "subgraph cluster_"+it+"{\ncolor=lightpink\nstyle=filled\nlabel=\"Lista simple\"";
        NodoLS aux = this.cabeza;
        while(aux != null){
            dot += "\""+aux+"\" [label = \"Lugar: "+aux.getVerticeGrafo().getNombre()+"\nDistancia recorrida: "+aux.getVerticeGrafo().getPeso()+"\"]\n";
            if(aux.getSiguiente()!=null){
            dot += "\""+aux+"\" -> \""+aux.getSiguiente()+"\"\n";
            }
            aux = aux.getSiguiente();
        }
        dot += "}";
        return dot;
    }
    
    
    public void recorrer(){
        NodoLS aux = this.cabeza;
        System.out.println("recorrido:");
        while(aux != null){
            System.out.println("Lugar: "+aux.getVerticeGrafo().getNombre()+" Peso: "+aux.getVerticeGrafo().getPeso());
            aux = aux.getSiguiente();
        } 
    }
    
    public boolean estaVacia(){
        if(this.cabeza == null){
            return true;
        }
        return false;
    }
    
    public VerticeGrafo obtenerCabeza(){
        VerticeGrafo vertice = null;
        if(this.cabeza != null){
            vertice = this.cabeza.getVerticeGrafo();
            this.cabeza = this.cabeza.getSiguiente();
        }
        return vertice;
    }
    
    public void insertar(VerticeGrafo verticeGrafo){
        if(cabeza == null){
            cola = cabeza = new NodoLS(verticeGrafo);
        }else{
            NodoLS nuevo = new NodoLS(verticeGrafo);
            cola.setSiguiente(nuevo);
            cola = nuevo;
        }
    }
    
    public void ordenarAscendente(){
        this.ordenarAscendente(this.cabeza);
    }
    
    private void ordenarAscendente(NodoLS aux){
        if(aux != null){
            NodoLS temp = this.cabeza;
            while(temp != null){
                if(temp.getVerticeGrafo().getPeso() > aux.getVerticeGrafo().getPeso()){
                    VerticeGrafo vertice = temp.getVerticeGrafo();
                    temp.setVerticeGrafo(aux.getVerticeGrafo());
                    aux.setVerticeGrafo(vertice);
                }
                temp = temp.getSiguiente();
            }
            this.ordenarAscendente(aux.getSiguiente());
        }
    } 
    
    public ListaSimple() {
        this.cabeza = null;
    }
    
    public NodoLS getCabeza(){
        return this.cabeza;
    }
}

class NodoLS{
    private NodoLS siguiente;
    private VerticeGrafo verticeGrafo;
    private String ruta;
    
    public  NodoLS(String ruta){
        this.siguiente = null;
        this.ruta = ruta;
    }
    
    public  NodoLS(VerticeGrafo verticeGrafo){
        this.siguiente = null;
        this.verticeGrafo = verticeGrafo;
    }

    public VerticeGrafo getVerticeGrafo() {
        return verticeGrafo;
    }

    public void setVerticeGrafo(VerticeGrafo verticeGrafo) {
        this.verticeGrafo = verticeGrafo;
    }

    public NodoLS getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLS siguiente) {
        this.siguiente = siguiente;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
}