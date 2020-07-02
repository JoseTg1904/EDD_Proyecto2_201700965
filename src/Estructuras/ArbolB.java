package Estructuras;

import Objetos.Vehiculo;
import java.util.ArrayList;
/**
 *
 * @author chepe
 */
public class ArbolB {
    
    private NodoAB raiz;
    private String dot;
    private ArrayList<String> placas;
    private Vehiculo vehiculo;
    private NodoAB retorno;
    private boolean band;
    
    public ArbolB(){
        this.raiz = new NodoAB();
        this.raiz.setContHijos(0);
        this.raiz.setSinHijos(true);
    }
    
    public ArrayList<String> devolverPlacas(){
        placas = new ArrayList<>();
        this.llenarPlacas(this.raiz);
        return placas;
    }
    
    private void llenarPlacas(NodoAB aux){
        //recorrer todos los hijos de cada pagina y obtener la placa de cada vehiculo
        for(int i = 0; i < aux.getVehiculos().length; i++){
            if(aux.getVehiculos()[i] != null){
               placas.add(aux.getVehiculos()[i].getPlaca());
            }
        }
        
        //llamar recursivamente al metodo con todos los hijos que tenga la pagina actual
        for(int i = 0; i < aux.getHijos().length; i++){
            if(aux.getHijos()[i] != null){
                this.llenarPlacas(aux.getHijos()[i]);
            }
        }
    }
    
    public Vehiculo retornarVehiculo(String llave, int tipo){
        this.vehiculo = null;
        this.band = false;
        this.buscar(this.raiz, llave);
        return vehiculo;
    }
    
    public NodoAB retornarNodo(String llave){
        this.retorno = null;
        this.band = false;
        this.buscarNodo(raiz, llave);
        return retorno;
    }
    
    private void buscar(NodoAB actual, String llave){
        //recorrer los vehiculos de la pagina actual
        for(int i = 0; i < actual.getVehiculos().length; i++){
            if(actual.getVehiculos()[i] != null){
               if(actual.getVehiculos()[i].equals(llave));
                    this.band = true;
                    this.vehiculo = actual.getVehiculos()[i];
            }
        }
        
        //si el vehiculo no se encuentra en la pagina actual, llamar al metodo recursivamente con los hijos de la pagina actual
        if(band == false){
            for(int i = 0; i < actual.getHijos().length; i++){
                if(actual.getHijos()[i] != null){
                    this.buscar(actual.getHijos()[i], llave);
                }
            }
        }
    }
    
    private void buscarNodo(NodoAB actual, String llave){
        //recorrer los vehiculos de la pagina actual
        for(int i = 0; i < actual.getVehiculos().length; i++){
            if(actual.getVehiculos()[i] != null){
               if(actual.getVehiculos()[i].equals(llave));
                    this.band = true;
                    this.retorno = actual;
            }
        }
        
        //si el vehiculo no se encunetra en la pagina actual, llamar al metodo recursivamente con los hijos de la pagina actual
        if(band == false){
            for(int i = 0; i < actual.getHijos().length; i++){
                if(actual.getHijos()[i] != null){
                    this.buscar(actual.getHijos()[i], llave);
                }
            }
        }

    }
    
    private void dividirNodo(NodoAB actual, int posicion, NodoAB aux){
        //creando la nueva pagina que tendra los hijos y las claves de la pagina auxiliar
        NodoAB nuevo = new NodoAB();
        
        //si la pagina auxiliar tiene hijos la nueva pagina tendra hijos
        nuevo.setSinHijos(aux.isSinHijos());
        
        //la nueva pagina tendra dos hijos
        nuevo.setContHijos(2);
        
        //la nueva pagina tendra en sus vehiculos los vehiculos de la mitad derecha de la pagina auxiliar
        int it = 0;
        while( it < 2 ){
            nuevo.getVehiculos()[it] = aux.getVehiculos()[it+3];
            it++;
        }
        
        //si la pagina auxiliar tiene hijos la nueva pagina tendra los hijos de la mitad de derecha de la pagina auxiliar
        if(aux.isSinHijos() == false){
            it = 0;
            while( it < 3 ){
                nuevo.getHijos()[it] = aux.getHijos()[it+3];
                it++;
            }
        }
        
        //ahora la pagina auxiliar solo tendra dos hijos
        aux.setContHijos(2);
        
        //la pagina actual movera sus hijos una posicion
        it = actual.getContHijos();
        while(it >= posicion+1){
            actual.getHijos()[it+1] = actual.getHijos()[it];
            it--;
        }
        
        //la pagina actual tendra como hijo la nueva pagina creada
        actual.getHijos()[posicion+1] = nuevo;
        
        //la pagina actual movera sus vehiculos una posicion
        it = actual.getContHijos()-1;
        while(it >= posicion){
            actual.getVehiculos()[it+1] = actual.getVehiculos()[it]; 
            it--;
        }
        
        //la pagina actual tendra el vehiculo de la posicion media de la pagina auxiliar
        actual.getVehiculos()[posicion] = aux.getVehiculos()[2];
        
        //la pagina actual tendra un hijo mas
        actual.setContHijos(actual.getContHijos()+1);
    }

    public void insertarNormal(final Vehiculo vehiculo){
        NodoAB actual = this.raiz;
        if(actual.getContHijos() == 5){
            NodoAB aux = new NodoAB();
            this.raiz = aux;
            aux.setSinHijos(false);
            aux.setContHijos(0);
            aux.getHijos()[0] = actual;
            this.dividirNodo(aux, 0, actual);
            this.insertarEspecial(aux, vehiculo);
        }else{
            this.insertarEspecial(actual, vehiculo);
        }
    }
    
    public String grafoParcial(){
        dot = "subgraph cluster_arbolB{\nstyle=filled\nlabel=\"Arbol B\"\ncolor=beige\n";
        this.grafoArbolB(this.raiz);
        dot += "}\n";
        return dot;
    }
    
    public String devolverGrafo(){
        dot = "digraph ArbolB{\nnode[shape=record]\n";
        this.grafoArbolB(this.raiz);
        dot += "}";
        return dot;
    }
    
    private void grafoArbolB(NodoAB aux){
        dot += "\""+aux+"\" [shape = record label = \"";
        
        for(int i = 0; i < aux.getVehiculos().length; i++){
            if(aux.getVehiculos()[i] != null){
                if(i == aux.getVehiculos().length-1){
                    dot += "<"+aux.getVehiculos()[i].getPlaca()+">Placa: "+aux.getVehiculos()[i].getPlaca()+"\n Marca: "+aux.getVehiculos()[i].getMarca()+
                    "\n Modelo: "+aux.getVehiculos()[i].getModelo();
                }else{
                    dot += "<"+aux.getVehiculos()[i].getPlaca()+">Placa: "+aux.getVehiculos()[i].getPlaca()+"\n Marca: "+aux.getVehiculos()[i].getMarca()+
                    "\n Modelo: "+aux.getVehiculos()[i].getModelo()+"|";
                }
            
            }
            
        }
        dot += "\"]\n";
        
        for(int i = 0; i < aux.getHijos().length; i++){
            if(aux.getHijos()[i] != null){
                dot += "\""+aux+"\" -> \""+aux.getHijos()[i]+"\"\n";
                this.grafoArbolB(aux.getHijos()[i]);
            }
        }
    }
    
    final private void insertarEspecial(NodoAB actual, Vehiculo vehiculo){
        int it = actual.getContHijos() - 1;
        if(actual.isSinHijos()){
            while(it >= 0 && vehiculo.getPlaca().compareTo(actual.getVehiculos()[it].getPlaca()) < 0){
                actual.getVehiculos()[it+1] = actual.getVehiculos()[it];
                it--;
            }
            actual.getVehiculos()[it+1] = vehiculo;
            actual.setContHijos(actual.getContHijos()+1);
        }else{
            for(it = actual.getContHijos()-1; it >= 0 && vehiculo.getPlaca().compareTo(actual.getVehiculos()[it].getPlaca()) < 0; it-- ){   
            }
            it++;
            NodoAB temp = actual.getHijos()[it];
            if(temp.getContHijos() == 5){
                this.dividirNodo(actual, it, temp);
                if(vehiculo.getPlaca().compareTo(actual.getVehiculos()[it].getPlaca()) > 0){
                    it++;
                }
            }
            this.insertarEspecial(actual.getHijos()[it], vehiculo);
        }
    }
}

class NodoAB{
    private NodoAB [] hijos;
    private Vehiculo[] vehiculos;
    private int contHijos;
    private boolean sinHijos;
    
    public NodoAB(){
        this.hijos = new NodoAB[6];
        this.vehiculos = new Vehiculo[5];
        this.contHijos = 0;
        this.sinHijos = true;
    }

    public NodoAB[] getHijos() {
        return hijos;
    }

    public void setHijos(NodoAB[] hijos) {
        this.hijos = hijos;
    }

    public Vehiculo[] getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculo[] vehiculos) {
        this.vehiculos = vehiculos;
    }

    public int getContHijos() {
        return contHijos;
    }

    public void setContHijos(int contHijos) {
        this.contHijos = contHijos;
    }

    public boolean isSinHijos() {
        return sinHijos;
    }

    public void setSinHijos(boolean sinHijos) {
        this.sinHijos = sinHijos;
    }

}