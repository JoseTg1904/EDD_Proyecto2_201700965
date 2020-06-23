package Estructuras;

import Objetos.Cliente;
import java.math.BigInteger;
/**
 *
 * @author chepe
 */
public class Cola {
    private NodoC cabeza;
     
    public Cliente buscar(BigInteger llave){
        
        Cliente cliente = null;
        NodoC aux = this.cabeza;
        
        while(aux != null){
            if(aux.getCliente().getDpi() == llave){
                cliente = aux.getCliente();
                break;
            }
            aux = aux.getSiguiente();
        } 
        
        return cliente;
    }
    
    public boolean eliminar(BigInteger llave){
        boolean band = false;
        
        if(this.cabeza.getCliente().getDpi() == llave){
            this.cabeza = this.cabeza.getSiguiente();
            band = true;
        }else{
            NodoC aux = this.cabeza, aux1 = this.cabeza;
            while(aux!=null){
                if(aux.getCliente().getDpi() == llave){
                    band = true;
                    break;
                }
                aux = aux.getSiguiente();
            }
            
            if(band == true){
                while(aux1.getSiguiente() != aux){
                    aux1 = aux1.getSiguiente();
                }
                aux1.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(null);
            }
        }
        return band;
    }
    
    public void insertar(Cliente cliente){
        if(this.cabeza == null){
            this.cabeza = new NodoC(cliente, null);
        }else{
            NodoC nuevo = new NodoC(cliente, this.cabeza);
            this.cabeza = nuevo;
        }
    }
    
    public String grafoCola(int origen){
        String dot = "";
        String rank = "{rank = same; " + origen + "; ";
        NodoC aux = this.cabeza;
        while(aux!=null){
            dot+= "\"" + aux.getCliente().getDpi() + "\" [label = \"Dpi: "+ aux.getCliente().getDpi() + 
                    "\nNombre completo: "+ aux.getCliente().getNombres()+" "+aux.getCliente().getApellidos()  +"\"]\n";
            rank += "\"" + aux.getCliente().getDpi() + "\"; ";
            if(aux.getSiguiente() != null){
                dot += "\"" + aux.getCliente().getDpi() + "\" -> \"" + aux.getSiguiente().getCliente().getDpi() + "\"\n";
            }
            aux = aux.getSiguiente();
        }
        rank += "}\n";
        dot += rank;
        return dot;
    }
    
    public Cola(){
        this.cabeza = null;
    }
    
    public NodoC getCabeza(){
        return cabeza;
    }
    
}

class NodoC{

    private Cliente cliente;
    private NodoC siguiente;

    public NodoC(Cliente cliente, NodoC siguiente) {
        this.cliente = cliente;
        this.siguiente = siguiente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public NodoC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoC siguiente) {
        this.siguiente = siguiente;
    }

}