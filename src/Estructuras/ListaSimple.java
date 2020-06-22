package Estructuras;

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
    
    public ListaSimple() {
        this.cabeza = null;
    }
    
}

class NodoLS{
    private NodoLS siguiente;
    private String ruta;
    
    public  NodoLS(String ruta){
        this.siguiente = null;
        this.ruta = ruta;
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