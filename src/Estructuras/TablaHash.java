package Estructuras;

import Objetos.Cliente;

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
    
    public Cliente buscar(int llave){
        Cliente cliente = null;
        int posicion = this.funcionHash(llave);
        cliente = tabla[posicion].buscar(llave);
        return cliente;
    }
    
    public boolean eliminar(int llave){
        boolean band = false;
        int posicion = this.funcionHash(llave);
        band = tabla[posicion].eliminar(llave);
        return band;
    }
    
    public void insertar(Cliente cliente, int llave){
        int posicion = this.funcionHash(llave); 
        
        if(this.ocupados <= ((int)(this.tamanio*0.75)) ){
            if(tabla[posicion] == null){
                tabla[posicion].insertar(cliente);
                this.ocupados++;
            }else{
                tabla[posicion].insertar(cliente);
            }
        }else{
            expansion(cliente, llave);
        }
    }
    
    private void expansion(Cliente cliente, int llave){
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
        this.tamanio = this.tamanio*2;
        
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

    private int funcionHash(int llave){
        return llave % this.tamanio;
    }
}
