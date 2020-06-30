package Estructuras;

import Objetos.Cliente;
import Objetos.Conductor;
import Objetos.DuplaLetra;
import Objetos.DuplaResultado;
import Objetos.Vehiculo;
import Objetos.VerticeGrafo;

/**
 *
 * @author chepe
 */
public class ListaSimple {
    
    private NodoLS cabeza, cola;
    private int tamanio;
    
    public String reporteTopViajes(){
        int it = 1;
        String reporte = "";
        NodoLS aux = this.cabeza;
        while(aux!=null){
            if(it < 11){
            reporte += it + ". Origen: " + aux.getListaSimple().getCabeza().getVerticeGrafo().getNombre() +
                    " Destino: " + aux.getListaSimple().getCola().getVerticeGrafo().getNombre() + " No. Lugares: " + aux.getListaSimple().getTamanio()+"\n";
            }else{
                break;
            }
            it++;
            aux = aux.getSiguiente();
        }
        return reporte;
    }
    
    public String reporteTopClientes(){
        int it = 1;
        String reporte = "";
        NodoLS aux = this.cabeza;
        while(aux!=null){
            if(it < 11){
            reporte += it + ". Nombre completo: " + aux.getCliente().getNombres() +" "+aux.getCliente().getApellidos()+
                    " Dpi: " + aux.getCliente().getDpi() + " No. Viajes: " + aux.getCliente().getContador()+"\n";
            }else{
                break;
            }
            it++;
            aux = aux.getSiguiente();
        }
        return reporte;
    }
    
    public String reporteTopConductores(){
        int it = 1;
        String reporte = "";
        NodoLS aux = this.cabeza;
        while(aux!=null){
            if(it < 11){
                reporte += it + ". Nombre completo: " + aux.getConductor().getNombres() +" "+aux.getConductor().getApellidos()+
                    " Dpi: " + aux.getConductor().getDpi() + " No. Viajes: " + aux.getConductor().getContador()+"\n";
            }else{
                break;
            }
            it++;
            aux = aux.getSiguiente();
        }
        return reporte;
    }
    
    public String reporteTopVehiculos(){
        int it = 1;
        String reporte = "";
        NodoLS aux = this.cabeza;
        while(aux!=null){
            if(it < 11){
                reporte += it + ". Placa: " + aux.getVehiculo().getPlaca() + " No. Viajes: " + aux.getVehiculo().getContador()+"\n";
            }else{
                break;
            }
            it++;
            aux = aux.getSiguiente();
        }
        return reporte;
    }
    
    public String grafoParcial(int it){
        String dot = "subgraph cluster_"+it+"{\ncolor=lightpink\nstyle=filled\nlabel=\"Lista simple\"";
        NodoLS aux = this.cabeza;
        while(aux != null){
            dot += "\""+aux+"\" [label = \"Lugar: "+aux.getVerticeGrafo().getNombre()+"\nTiempo recorrido: "+aux.getVerticeGrafo().getPeso()+"\"]\n";
            if(aux.getSiguiente()!=null){
            dot += "\""+aux+"\" -> \""+aux.getSiguiente()+"\"\n";
            }
            aux = aux.getSiguiente();
        }
        dot += "}";
        return dot;
    }
    
    public String recorrer(){
        String retorno = "";
        NodoLS aux = this.cabeza;
        while(aux != null){
            retorno += "Lugar: " + aux.getVerticeGrafo().getNombre() + " Tiempo: "+aux.getVerticeGrafo().getPeso()+"\n";
            aux = aux.getSiguiente();
        } 
        return retorno;
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
    
    public void insertar(DuplaLetra duplaLetra){
        if(cabeza == null){
            cola = cabeza = new NodoLS(new NodoABB(duplaLetra));
            this.tamanio++;
        }else{
            if(this.buscar(duplaLetra) == false){
                NodoLS nuevo = new NodoLS(new NodoABB(duplaLetra));
                cola.setSiguiente(nuevo);
                cola = nuevo;
                this.tamanio++;
            }
        }
    }
    
    public void recorrerHuffman(){
        NodoLS aux = this.cabeza;
        while(aux!=null){
            System.out.println("Caracter: "+aux.getNodoABB().getDuplaLetra().getCaracter()+" Frecuencia: "+aux.getNodoABB().getDuplaLetra().getFrecuencia());
            aux = aux.getSiguiente();
        }
    }
    
    public ArbolBB crearABBHuffman(ListaSimple lista){
        this.crearABBHuffman(lista.getCabeza(), lista);
        ArbolBB huffman = new ArbolBB(lista.getCola().getNodoABB());
        return huffman;
    }
    
    private void crearABBHuffman(NodoLS aux, ListaSimple lista){
        if(aux.getSiguiente() != null){
            NodoABB izquierda = aux.getNodoABB();
            NodoABB derecha = aux.getSiguiente().getNodoABB();
            DuplaLetra nuevo = new DuplaLetra('\t');
            nuevo.setFrecuencia(izquierda.getDuplaLetra().getFrecuencia()+derecha.getDuplaLetra().getFrecuencia());
            NodoABB raiz = new NodoABB(nuevo);
            raiz.setIzquierda(izquierda);
            raiz.setDerecha(derecha);
            izquierda.setPadre(raiz);
            derecha.setPadre(raiz);
            lista.insertarCola(raiz);
            crearABBHuffman(aux.getSiguiente().getSiguiente(), lista);
        } 
    }
    
    public void copiarLista(ListaSimple original, ListaSimple copia){
        NodoLS aux = original.cabeza;
        while(aux != null){
            copia.insertar(aux.getNodoABB().getDuplaLetra());
            aux = aux.getSiguiente();
        }
    }
    
    public DuplaResultado[] obtenerCodigos(ListaSimple lista, ArbolBB arbol){
        DuplaResultado[] dupla = new DuplaResultado[lista.getTamanio()];
        int it = 0;
        NodoLS aux = lista.getCabeza();
        while(aux != null){
            dupla[it] = new DuplaResultado(aux.getNodoABB().getDuplaLetra().getCaracter() ,arbol.buscarCaracter(aux.getNodoABB().getDuplaLetra().getCaracter()));  
            aux = aux.getSiguiente();
            it++;
        }
        return dupla;
    }
    
    public void insertarCola(NodoABB nodo){
        NodoLS nuevo = new NodoLS(nodo);
        cola.setSiguiente(nuevo);
        cola = nuevo;
    }
    
    public void insertar(VerticeGrafo verticeGrafo){
        if(cabeza == null){
            cola = cabeza = new NodoLS(verticeGrafo);
            this.tamanio++;
        }else{
            NodoLS nuevo = new NodoLS(verticeGrafo);
            cola.setSiguiente(nuevo);
            cola = nuevo;
            this.tamanio++;
        }
    }
    
    public void insertar(ListaSimple listaSimple){
        if(cabeza == null){
            cola = cabeza = new NodoLS(listaSimple);
            this.tamanio++;
        }else{
            NodoLS nuevo = new NodoLS(listaSimple);
            cola.setSiguiente(nuevo);
            cola = nuevo;
            this.tamanio++;
        }
    }
    
    public void insertar(Cliente cliente){
        if(cabeza == null){
            cola = cabeza = new NodoLS(cliente);
            this.tamanio++;
        }else{
            if(this.buscar(cliente) == false){
                NodoLS nuevo = new NodoLS(cliente);
                cola.setSiguiente(nuevo);
                cola = nuevo;
                this.tamanio++;
            }
        }
    }
    
    public void insertar(Conductor conductor){
        if(cabeza == null){
            cola = cabeza = new NodoLS(conductor);
            this.tamanio++;
        }else{
            if(this.buscar(conductor) == false){
                NodoLS nuevo = new NodoLS(conductor);
                cola.setSiguiente(nuevo);
                cola = nuevo;
                this.tamanio++;
            }
        }
    }
    
    public void insertar(Vehiculo vehiculo){
        if(cabeza == null){
            cola = cabeza = new NodoLS(vehiculo);
            this.tamanio++;
        }else{
            if(this.buscar(vehiculo)==false){
                NodoLS nuevo = new NodoLS(vehiculo);
                cola.setSiguiente(nuevo);
                cola = nuevo;
                this.tamanio++;
            }
        }
    }
    
    private boolean buscar(Cliente cliente){
        boolean retorno = false;
        NodoLS aux = this.cabeza;
        while(aux!=null){
            if(aux.getCliente().getDpi().compareTo(cliente.getDpi()) == 0){
                retorno = true;
                break;
            }
            aux = aux.getSiguiente();
        }
        return retorno;
    }
    
    private boolean buscar(DuplaLetra duplaLetra){
        boolean retorno = false;
        NodoLS aux = this.cabeza;
        while(aux != null){
            if(aux.getNodoABB().getDuplaLetra().getCaracter() == duplaLetra.getCaracter()){
                aux.getNodoABB().getDuplaLetra().setFrecuencia(aux.getNodoABB().getDuplaLetra().getFrecuencia()+1);
                retorno = true;
                break;
            }
            aux = aux.getSiguiente();
        }
        return retorno;
    }
    
    private boolean buscar(Vehiculo vehiculo){
        boolean retorno = false;
        NodoLS aux = this.cabeza;
        while(aux!=null){
            if(aux.getVehiculo().getPlaca().equals(vehiculo.getPlaca())){
                retorno = true;
                break;
            }
            aux = aux.getSiguiente();
        }
        return retorno;
    }
    
    private boolean buscar(Conductor conductor){
        boolean retorno = false;
        NodoLS aux = this.cabeza;
        while(aux!=null){
            if(aux.getConductor().getDpi().compareTo(conductor.getDpi()) == 0){
                retorno = true;
                break;
            }
            aux = aux.getSiguiente();
        }
        return retorno;
    }
    
    public void ordenarHuffman(){
        this.ordenarHuffman(this.cabeza);
    }
    
    private void ordenarHuffman(NodoLS aux){
        if(aux != null){
            NodoLS temp = this.cabeza;
            while(temp != null){
                if(temp.getNodoABB().getDuplaLetra().getFrecuencia() > aux.getNodoABB().getDuplaLetra().getFrecuencia()){
                    NodoABB nodo = temp.getNodoABB();
                    temp.setNodoABB(aux.getNodoABB());
                    aux.setNodoABB(nodo);
                }
                temp = temp.getSiguiente();
            }
            this.ordenarHuffman(aux.getSiguiente());
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
    
    public void ordenarXTamanio(){
        this.ordenarXTamanio(this.cabeza);
    }
    
    private void ordenarXTamanio(NodoLS aux){
        if(aux != null){
            NodoLS temp = this.cabeza;
            while(temp != null){
                if(temp.getListaSimple().getTamanio() < aux.getListaSimple().getTamanio()){
                    ListaSimple lista = temp.getListaSimple();
                    temp.setListaSimple(aux.getListaSimple());
                    aux.setListaSimple(lista);
                }
                temp = temp.getSiguiente();
            }
            this.ordenarXTamanio(aux.getSiguiente());
        }
    } 
    
    public void ordenarXCliente(){
        this.ordenarXCliente(this.cabeza);
    }
    
    private void ordenarXCliente(NodoLS aux){
        if(aux != null){
            NodoLS temp = this.cabeza;
            while(temp != null){
                if(temp.getCliente().getContador() < aux.getCliente().getContador()){
                    ListaSimple lista = temp.getListaSimple();
                    temp.setListaSimple(aux.getListaSimple());
                    aux.setListaSimple(lista);
                }
                temp = temp.getSiguiente();
            }
            this.ordenarXCliente(aux.getSiguiente());
        }
    } 
    
    public void ordenarXConductor(){
        this.ordenarXConductor(this.cabeza);
    }
    
    private void ordenarXConductor(NodoLS aux){
        if(aux != null){
            NodoLS temp = this.cabeza;
            while(temp != null){
                if(temp.getConductor().getContador() < aux.getConductor().getContador()){
                    ListaSimple lista = temp.getListaSimple();
                    temp.setListaSimple(aux.getListaSimple());
                    aux.setListaSimple(lista);
                }
                temp = temp.getSiguiente();
            }
            this.ordenarXConductor(aux.getSiguiente());
        }
    } 
    
    
    public void ordenarXVehiculos(){
        this.ordenarXVehiculos(this.cabeza);
    }
    
    private void ordenarXVehiculos(NodoLS aux){
        if(aux != null){
            NodoLS temp = this.cabeza;
            while(temp != null){
                if(temp.getVehiculo().getContador() < aux.getVehiculo().getContador()){
                    ListaSimple lista = temp.getListaSimple();
                    temp.setListaSimple(aux.getListaSimple());
                    aux.setListaSimple(lista);
                }
                temp = temp.getSiguiente();
            }
            this.ordenarXVehiculos(aux.getSiguiente());
        }
    } 
    
    public int getTamanio(){
        return this.tamanio;
    }
    
    public ListaSimple() {
        this.cabeza = null;
        this.tamanio = 0;
    }
    
    public NodoLS getCabeza(){
        return this.cabeza;
    }
    
    public void setCabeza(NodoLS cabeza){
        this.cabeza = cabeza;
    }
    
    public NodoLS getCola(){
        return this.cola;
    }
    
}

class NodoLS{
    private NodoLS siguiente;
    private VerticeGrafo verticeGrafo;
    private String ruta;
    private ListaSimple listaSimple;
    private Cliente cliente;
    private Conductor conductor;
    private Vehiculo vehiculo;
    private NodoABB nodoABB;
    
    public NodoLS(NodoABB nodoABB){
        this.nodoABB = nodoABB;
        this.siguiente = null;
    }
    
    public NodoLS(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
        this.siguiente = null;
    }
    
    public NodoLS(Conductor conductor){
        this.conductor = conductor;
        this.siguiente = null;
    }
    
    public NodoLS(Cliente cliente){
        this.cliente = cliente;
        this.siguiente = null;
    }
    
    public NodoLS(ListaSimple listaSimple){
        this.listaSimple = listaSimple;
        this.siguiente = null;
    }
    
    public  NodoLS(String ruta){
        this.siguiente = null;
        this.ruta = ruta;
    }
    
    public  NodoLS(VerticeGrafo verticeGrafo){
        this.siguiente = null;
        this.verticeGrafo = verticeGrafo;
    }

    NodoLS(DuplaLetra duplaLetra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public NodoABB getNodoABB() {
        return nodoABB;
    }

    public void setNodoABB(NodoABB nodoABB) {
        this.nodoABB = nodoABB;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ListaSimple getListaSimple() {
        return listaSimple;
    }

    public void setListaSimple(ListaSimple listaSimple) {
        this.listaSimple = listaSimple;
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