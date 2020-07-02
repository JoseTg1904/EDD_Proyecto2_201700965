package Estructuras;

import Objetos.DuplaLetra;

/**
 *
 * @author chepe
 */
public class ArbolBB {
    
    private NodoABB raiz, aux;
    private String dot;
    
    public ArbolBB(NodoABB raiz){
        this.raiz = raiz;
    }
    
    public String buscarCaracter(Character caracter){
        aux = this.raiz;
        if(aux.getDuplaLetra().getCaracter() != caracter){
            this.buscarNodo(this.raiz, caracter);
        }
        
        StringBuilder constructor = new StringBuilder(generarBinario(aux));
        return constructor.reverse().toString();
    }
    
    private void buscarNodo(NodoABB temp, Character caracter){
        if(temp.getDerecha() != null){
            if(temp.getDerecha().getDuplaLetra().getCaracter() == caracter){
                aux = temp.getDerecha();
            }
            buscarNodo(temp.getDerecha(), caracter);
        }
        if(temp.getIzquierda() != null){
            if(temp.getIzquierda().getDuplaLetra().getCaracter() == caracter){
                aux = temp.getIzquierda();
            }
            buscarNodo(temp.getIzquierda(), caracter);
        }
    } 
    
    private String generarBinario(NodoABB temp){
        String cadena = " ";
        while(temp != null){
            if(cadena.equals(" ")){
                if(temp.getPadre() != null){
                    if(temp.getPadre().getDerecha() == temp){
                        cadena = "1";
                    }else{
                        cadena = "0";
                    }    
                }
            }else{
                if(temp.getPadre() != null){
                    if(temp.getPadre().getDerecha() == temp){
                        cadena += "1";
                    }else{
                        cadena += "0";
                    }    
                }
            }
            temp = temp.getPadre();
        }
        return cadena;
    }
    
    
    public String grafo(){
        dot = "digraph G{\n";
        dot += "\""+this.raiz+"\" [label = \"Caracter: "+this.raiz.getDuplaLetra().getCaracter()+"\nFrecuencia: "+this.raiz.getDuplaLetra().getFrecuencia()+"\" ]\n";
        this.generarGrafo(this.raiz);
        dot += "}";
        return dot;
    }
    
    private void generarGrafo(NodoABB aux){
        if(aux.getDerecha() != null){
            dot += "\""+aux.getDerecha()+"\" [label = \"Caracter: "+aux.getDerecha().getDuplaLetra().getCaracter()+"\nFrecuencia: "+aux.getDerecha().getDuplaLetra().getFrecuencia()+"\" ]\n";
            dot += "\""+aux+"\" -> \""+aux.getDerecha()+"\"\n";
            generarGrafo(aux.getDerecha());
        }
        if(aux.getIzquierda() != null){
            dot += "\""+aux.getIzquierda()+"\" [label = \"Caracter: "+aux.getIzquierda().getDuplaLetra().getCaracter()+"\nFrecuencia: "+aux.getIzquierda().getDuplaLetra().getFrecuencia()+"\" ]\n";
            dot += "\""+aux+"\" -> \""+aux.getIzquierda()+"\"\n";
            generarGrafo(aux.getIzquierda());
        }
    }
    
}

class NodoABB{
    private DuplaLetra duplaLetra;
    private NodoABB izquierda, derecha, padre;

    public NodoABB(DuplaLetra duplaLetra) {
        this.duplaLetra = duplaLetra;
        this.izquierda = this.derecha = this.padre = null;
    }

    public NodoABB getPadre() {
        return padre;
    }

    public void setPadre(NodoABB padre) {
        this.padre = padre;
    }
    
    public DuplaLetra getDuplaLetra() {
        return duplaLetra;
    }

    public void setDuplaLetra(DuplaLetra duplaLetra) {
        this.duplaLetra = duplaLetra;
    }

    public NodoABB getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoABB izquierda) {
        this.izquierda = izquierda;
    }

    public NodoABB getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoABB derecha) {
        this.derecha = derecha;
    }
    
}