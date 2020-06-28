package Estructuras;

import Objetos.Cliente;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author chepe
 */
public class TablaHash {
    
    private Cola[] tabla;
    private int tamanio, ocupados;
    
    public TablaHash(){
        this.tamanio = 37;
        tabla = new Cola[37];
        this.ocupados = 0;
    }
    
    public Cliente buscar(BigInteger llave){
        Cliente cliente = null;
        int posicion = this.funcionHash(llave);
        cliente = tabla[posicion].buscar(llave);
        return cliente;
    }
    
    public NodoC buscarNodo(BigInteger llave){
        int posicion = this.funcionHash(llave);
        NodoC aux = tabla[posicion].buscarNodo(llave);
        return aux;
    }
    
    public boolean eliminar(BigInteger llave){
        boolean band = false;
        int posicion = this.funcionHash(llave); 
        System.out.print(posicion);
        band = tabla[posicion].eliminar(llave);
        return band;
    }
    
    public void insertar(Cliente cliente, BigInteger llave){
        int posicion = this.funcionHash(llave); 
        
        if(this.ocupados <= ((int)(this.tamanio*0.75)) ){
            if(tabla[posicion] == null){
                tabla[posicion] = new Cola();
                tabla[posicion].insertar(cliente);
                this.ocupados++;
            }else{
                tabla[posicion].insertar(cliente);
            }
        }else{
            expansion(cliente, llave);
        }
    }
    
    private void expansion(Cliente cliente, BigInteger llave){
        Cola aux = new Cola();
        //sacando todos los elementos de la tabla para hacer la re insercion
        for(int i = 0;i<this.tamanio;i++){
            if(tabla[i] != null){
                NodoC temp = tabla[i].getCabeza();
                while(temp != null){
                    aux.insertar(temp.getCliente());
                    temp = temp.getSiguiente();
                }
            }
        }
       
        this.ocupados = 0;
        this.tamanio = this.tamanio + 37;
        
        //aumentar el doble a la tabla
        this.tabla = new Cola[this.tamanio];
        
        //insertando el elemento que sobrepasaba el tamaño de la tabla
        this.insertar(cliente, llave);
        
        NodoC temp = aux.getCabeza();
        while(temp!=null){
            this.insertar(temp.getCliente(), temp.getCliente().getDpi());
            temp = temp.getSiguiente();
        }
    }
    
    public String grafoHash(){
        String dot = "digraph TablaHash{\n node[shape = box]\n";
        int itOrigen = 0;
        while(itOrigen < this.tamanio){
            dot += itOrigen + " [ label = \"Origen: " + itOrigen + "\" ]\n";
            if(tabla[itOrigen] != null){
                dot += itOrigen + " -> \"" + tabla[itOrigen].getCabeza().getCliente().getDpi() + "\"\n";
                dot += tabla[itOrigen].grafoCola(itOrigen);
            } 
            if( (itOrigen+1)<this.tamanio ){
                dot += itOrigen + " -> " + (itOrigen+1)+"\n";
            }
            itOrigen++;
        }
        dot += "}";
        return dot;
    }
    
    public String grafoParcial(){
        String dot = "subgraph cluster_hash{\nstyle = filled\ncolor=aliceblue\nlabel=\"Tabla Hash\"\n";
        int itOrigen = 0;
        while(itOrigen < this.tamanio){
            dot += itOrigen + " [ shape = box label = \"Origen: " + itOrigen + "\" ]\n";
            if(tabla[itOrigen] != null){
                dot += itOrigen + " -> \"" + tabla[itOrigen].getCabeza().getCliente().getDpi() + "\"\n";
                dot += tabla[itOrigen].grafoCola(itOrigen);
            } 
            if( (itOrigen+1)<this.tamanio ){
                dot += itOrigen + " -> " + (itOrigen+1)+"\n";
            }
            itOrigen++;
        }
        dot += "}\n";
        return dot;
    }
    
    public ArrayList<String> listadoDPI(){
        ArrayList<String> listado = new ArrayList<String>();
        for(int i = 0;i < this.tamanio; i++){
            if(this.tabla[i] !=null){
                this.tabla[i].agregarDPI(listado);
            }    
        }
        return listado;
    }
    
    private int funcionHash(BigInteger llave){
        return llave.mod(BigInteger.valueOf(this.tamanio)).intValue();
    }
}
