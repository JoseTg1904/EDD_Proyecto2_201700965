package Estructuras;

/**
 *
 * @author chepe
 */
public class ListaSimple {
    
    private NodoLS cabeza;

    public void insertar(){
        
        if(cabeza == null){
            cabeza = new NodoLS();
        }else{
            NodoLS nuevo = new NodoLS(cabeza);
            cabeza = nuevo;
        }
    }
    
    public ListaSimple() {
        this.cabeza = null;
    }
    
    
    
}

class NodoLS{
    private NodoLS siguiente;

    public NodoLS(NodoLS siguiente){
        this.siguiente = siguiente;
    }
    
    public  NodoLS(){
        this.siguiente = null;
    }
}