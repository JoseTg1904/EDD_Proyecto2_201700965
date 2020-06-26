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
        for(int i = 0; i < aux.getVehiculos().length; i++){
            if(aux.getVehiculos()[i] != null){
               placas.add(aux.getVehiculos()[i].getPlaca());
            }
        }
        
        for(int i = 0; i < aux.getHijos().length; i++){
            if(aux.getHijos()[i] != null){
                this.llenarPlacas(aux.getHijos()[i]);
            }
        }
    }
    
    public Vehiculo retornarVehiculo(String llave, int tipo){
        vehiculo = null;
        band = false;
        if(tipo == 0){
            this.buscar(this.raiz, llave);
        }else{
            //metodo para retornar el nodo completo
        }
        return vehiculo;
    }
    
    private void buscar(NodoAB actual, String llave){
        for(int i = 0; i < actual.getVehiculos().length; i++){
            if(actual.getVehiculos()[i] != null){
               if(actual.getVehiculos()[i].equals(llave));
                    band = true;
                    vehiculo = actual.getVehiculos()[i];
            }
        }
        
        if(band == false){
            for(int i = 0; i < actual.getHijos().length; i++){
                if(actual.getHijos()[i] != null){
                    this.buscar(actual.getHijos()[i], llave);
                }
            }
        }

    }
    
    private void dividirNodo(NodoAB actual, int posicion, NodoAB aux){
        NodoAB nuevo = new NodoAB();
        nuevo.setSinHijos(aux.isSinHijos());
        nuevo.setContHijos(2);
        int it = 0;
        while( it < 2 ){
            nuevo.getVehiculos()[it] = aux.getVehiculos()[it+3];
            it++;
        }
        if(aux.isSinHijos() == false){
            it = 0;
            while( it < 3 ){
                nuevo.getHijos()[it] = aux.getHijos()[it+3];
                it++;
            }
        }
        aux.setContHijos(2);
        it = actual.getContHijos();
        while(it >= posicion+1){
            actual.getHijos()[it+1] = actual.getHijos()[it];
            it--;
        }
        actual.getHijos()[posicion+1] = nuevo;
        it = actual.getContHijos()-1;
        while(it >= posicion){
            actual.getVehiculos()[it+1] = actual.getVehiculos()[it]; 
            it--;
        }
        actual.getVehiculos()[posicion] = aux.getVehiculos()[2];
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
    
    public String devolverGrafo(){
        dot = "digraph ArbolB{\nnode[shape=record]\n";
        this.grafoArbolB(this.raiz);
        dot += "}";
        return dot;
    }
    
    private void grafoArbolB(NodoAB aux){
        dot += "\""+aux+"\" [label = \"";
        
        for(int i = 0; i < aux.getVehiculos().length; i++){
            if(aux.getVehiculos()[i] != null){
            dot += "<"+aux.getVehiculos()[i].getPlaca()+">Placa: "+aux.getVehiculos()[i].getPlaca()+"\nMarca: "+aux.getVehiculos()[i].getMarca()+
                    "\nModelo: "+aux.getVehiculos()[i].getModelo()+"|";
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
            /*
            while(it >= 0){
                if(actual.getVehiculos()[it] != null){
                if(){
                    it--;
                }else{
                    break;
                }
                }
            }*/
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