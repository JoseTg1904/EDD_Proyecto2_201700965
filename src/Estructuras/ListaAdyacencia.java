package Estructuras;

import Objetos.VerticeGrafo;
import java.util.ArrayList;

/**
 *
 * @author chepe
 */
public class ListaAdyacencia {
    
    private NodoLA cabeza;

    public ArrayList<String> devolverLugares(){
        ArrayList<String> listado = new ArrayList<>();
        NodoLA aux = this.cabeza;
        while(aux != null){
            listado.add(aux.getVerticeGrafo().getNombre());
            aux = aux.getSiguiente();
        }
        return listado;
    }
    
    private VerticeGrafo obtenerRutaCorta(String origen, String destino){
        String[] ruta;
        VerticeGrafo temp = null;
        ListaSimple actual = new ListaSimple(), aux;
        actual.insertar(new VerticeGrafo(origen, 0));
        while(actual.estaVacia() == false){
            temp = actual.obtenerCabeza();
            ruta = temp.getNombre().split("%");
            if(ruta[ruta.length-1].equals(destino)){
                break;
            }
            aux = obtenerSucesores(ruta[ruta.length-1]);
            NodoLS aux1 = aux.getCabeza();
            while(aux1 != null){
                actual.insertar(new VerticeGrafo(temp.getNombre()+"%"+aux1.getVerticeGrafo().getNombre(),
                        temp.getPeso()+aux1.getVerticeGrafo().getPeso()));
                aux1 = aux1.getSiguiente();
            }
            actual.ordenarAscendente();
        }
        return temp;
    }
    
    public ListaSimple generarRuta(String origen, String destino){
        ListaSimple ruta = new ListaSimple();
        VerticeGrafo vertice = this.obtenerRutaCorta(origen, destino), aux;
        System.out.println(vertice.getNombre());
        String[] temp = vertice.getNombre().split("%");
        int peso = 0;
        if(temp[temp.length-1].equals(destino)){
            ruta.insertar(new VerticeGrafo(temp[0],0));
            for(int i = 1; i < temp.length;i++){                
                aux = this.devolverAdyacente(temp[i-1], temp[i]);
                peso += aux.getPeso();
                ruta.insertar(new VerticeGrafo(aux.getNombre(), peso));
            }
            ruta.recorrer();
        }
        return ruta;
    }
    
    private ListaSimple obtenerSucesores(String origen){
        NodoLA aux = this.cabeza, aux1 = null;
        ListaSimple retorno = new ListaSimple();
        while(aux != null){
            if(aux.getVerticeGrafo().getNombre().equals(origen)){
                aux1 = aux.getAdyacente();
                while(aux1 != null){
                    retorno.insertar(aux1.getVerticeGrafo());
                    aux1 = aux1.getAdyacente();
                }
                break;
            }
            aux = aux.getSiguiente();
        }
        return retorno;
    }
    
    public void insertarOrigen(VerticeGrafo verticeGrafo){
        if(cabeza == null){
            cabeza = new NodoLA(verticeGrafo);
        }else{
            if(devolverOrigen(verticeGrafo.getNombre()) == null ){
                NodoLA nuevo = new NodoLA(verticeGrafo, cabeza);
                cabeza = nuevo;
            }
        }
    }
    
    private VerticeGrafo devolverAdyacente(String llave, String llave2){
        VerticeGrafo vertice = null;
        NodoLA origen = devolverOrigen(llave);
        origen = origen.getAdyacente();
        while(origen != null){
            if(origen.getVerticeGrafo().getNombre().equals(llave2)){
                vertice = origen.getVerticeGrafo();
                break;
            }
            origen = origen.getAdyacente();
        } 
        return vertice;
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
    
    public String grafoLista(){
        String dot = "digraph ListaAdyacencia{\n node[shape = box] \n";
        String rank;
        int itOrigen = 0, itAdy = -1;
        boolean primero = true;
        NodoLA aux = this.cabeza, auxAdyacente;
        while(aux != null){
            dot += itOrigen + " [ label = \"Origen: " + aux.getVerticeGrafo().getNombre() + "\" ]\n";
            rank = "{rank = same; " + itOrigen + "; ";
            auxAdyacente = aux.getAdyacente();
            primero = true;
            while(auxAdyacente != null){
                dot += itAdy  + " [ label = \"Destino: " + auxAdyacente.getVerticeGrafo().getNombre() + "\n Costo: " + auxAdyacente.getVerticeGrafo().getPeso() + "\" ]\n";
                if(primero){
                    dot += itOrigen + " -> " + itAdy + "\n";
                }else{
                    dot += (itAdy+1) + " -> " + itAdy + "\n";
                }
                primero = false;
                rank += itAdy + "; ";
                itAdy--;
                auxAdyacente = auxAdyacente.getAdyacente();
            }
            rank += "}\n";
            dot += rank;
            if(aux.getSiguiente() != null){
                dot += itOrigen + " -> " + (itOrigen+1) + "\n";
            }
            itOrigen++;
            aux = aux.getSiguiente();
        }
        dot += "}";
        return dot;
    }
    
    public String grafo(){
        String dot = "digraph ListaAdyacencia{\n node[shape = circle] \n";
        NodoLA aux = this.cabeza, auxAdyacente;
        while(aux != null){
            if(aux.getAdyacente() != null){
            dot += "\"" + aux.getVerticeGrafo().getNombre() + "\" [ label = \" " + aux.getVerticeGrafo().getNombre() + "\" ]\n";
            auxAdyacente = aux.getAdyacente();
            while(auxAdyacente != null){
                dot += "\"" + auxAdyacente.getVerticeGrafo().getNombre() +  "\" [ label = \"" + auxAdyacente.getVerticeGrafo().getNombre() + "\" ]\n";
                dot += "\"" + aux.getVerticeGrafo().getNombre() + "\" -> \"" + auxAdyacente.getVerticeGrafo().getNombre() + "\" [ label = \""+ auxAdyacente.getVerticeGrafo().getPeso() +"\"]\n";
                auxAdyacente = auxAdyacente.getAdyacente();
            }
            }
            aux = aux.getSiguiente();
        }
        dot += "}";
        return dot;
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