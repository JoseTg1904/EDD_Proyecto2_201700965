package Estructuras;

import Objetos.Conductor;
import Objetos.Vehiculo;
import Objetos.Viaje;
import Ventanas.Inicial;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 *
 * @author chepe
 */
public class ListaDobleCircular {
    private NodoL cabeza, cola;
    private int tamanio;
    
    public void insertarBlockChain(String dpiConductor, String dpiCliente, String placa, ListaSimple ruta, Viaje viaje) throws NoSuchAlgorithmException{
        LocalDateTime tiempo = LocalDateTime.now();
        String llave = placa+tiempo.getDayOfMonth()+tiempo.getMonth()+tiempo.getYear()+tiempo.getHour()+":"+tiempo.getMinute()+":"+tiempo.getSecond();
        System.out.println(llave);
        String llaveEncriptada = encriptarMD5(llave);
        NodoL conductor = Inicial.conductores.buscarNodo(new BigInteger(dpiConductor));
        NodoAB vehiculo = Inicial.vehiculos.retornarNodo(placa);
        NodoC cliente = Inicial.clientes.buscarNodo(new BigInteger(dpiCliente));
        conductor.getConductor().setContador(conductor.getConductor().getContador()+1);
        cliente.getCliente().setContador(cliente.getCliente().getContador()+1);
        Vehiculo[] ar = vehiculo.getVehiculos();
        for(int i = 0;i<ar.length;i++){
            if(ar[i] != null){
                if(ar[i].getPlaca().equals(placa)){
                    ar[i].setContador(ar[i].getContador()+1);
                    break;
                }
            }
        }
        this.insertar(llaveEncriptada, conductor, cliente, ruta, vehiculo, viaje, placa);
    }

    public String devolverRuta(String llave) throws NoSuchAlgorithmException{
        ListaSimple lista = this.buscarNodoBlockChain(llave);
        return lista.recorrer();
    }
    
    private ListaSimple buscarNodoBlockChain(String llave) throws NoSuchAlgorithmException{
        String llaveEncriptada = encriptarMD5(llave);
        ListaSimple lista = null;
        NodoL aux = this.cabeza;
        do {            
            if(aux.getLlave().equals(llaveEncriptada)){
                lista = aux.getApuntadorRuta();
            }
            aux = aux.getSiguiente();
        } while (aux != this.cabeza);
        return lista;
    }
    
    private String encriptarMD5(String llave) throws NoSuchAlgorithmException{
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(llave.getBytes());
        byte[] bytes = md5.digest();
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i<bytes.length;i++){
            buffer.append(Integer.toHexString(bytes[i]&0xff).toString());
        }
        return buffer.toString();
    }
   
    public ArrayList<String> listadoDPI(){
        ArrayList<String> listado = new ArrayList<>();
        NodoL aux = this.cabeza;
        if(this.cabeza != null){ 
            do {            
                listado.add(aux.getConductor().getDpi().toString());
                aux = aux.getSiguiente();
            } while (aux != this.cabeza);
        }
        return listado;
    }
    
    public String topViajesMasLargos(){
        ListaSimple reporte = new ListaSimple();
        NodoL aux = this.cabeza;
        if(aux != null){
            do{
               reporte.insertar(aux.getApuntadorRuta());
               aux = aux.getSiguiente();
            }while(aux != this.cabeza);
        }
        reporte.ordenarXTamanio();
        return reporte.reporteTopViajes();
    }
    
    public String topClientes(){
        ListaSimple reporte = new ListaSimple();
        NodoL aux = this.cabeza;
        if(aux != null){
            do{
               reporte.insertar(aux.getApuntadorCliente().getCliente());
               aux = aux.getSiguiente();
            }while(aux != this.cabeza);
        }
        reporte.ordenarXCliente();
        return reporte.reporteTopClientes();
    }
    
    public String topConductores(){
        ListaSimple reporte = new ListaSimple();
        NodoL aux = this.cabeza;
        if(aux != null){
            do{
               reporte.insertar(aux.getApuntadorConductor().getConductor());
               aux = aux.getSiguiente();
            }while(aux != this.cabeza);
        }
        reporte.ordenarXConductor();
        return reporte.reporteTopConductores();
    }
                
    public String topVehiculos(){
        ListaSimple reporte = new ListaSimple();
        NodoL aux = this.cabeza;
        if(aux != null){
            do{
               Vehiculo[] vehiculos = aux.getApuntadorVehiculo().getVehiculos();
               for(int i = 0; i < vehiculos.length; i++){
                   if(vehiculos[i] != null  && vehiculos[i].getContador() > 0){
                       reporte.insertar(vehiculos[i]);
                   }
               }
               aux = aux.getSiguiente();
            }while(aux != this.cabeza);
        }
        reporte.ordenarXVehiculos();
        return reporte.reporteTopVehiculos();
    }
    
    public String grafoTotalBlockChain(){
        int it = 0;
        String dot = "digraph BlockChain{\n";
        //apuntar con el dpi
        dot += Inicial.clientes.grafoParcial();
        //apuntar con el dpi
        dot += Inicial.conductores.grafoParcial();
        //apuntar con direccion de memoria y placa "direccion:placa"
        dot += Inicial.vehiculos.grafoParcial();
        
        dot += "subgraph cluster_block{label=\"Block chain\"style=filled\ncolor=palegreen"; 
        NodoL aux = this.cabeza;
        do {            
            dot += "\""+aux+"\" [label = \"Llave: "+aux.getLlave()+"\"]\n";
            dot += "\""+aux+"\" -> \""+aux.getSiguiente()+"\"\n";
            dot += "\""+aux+"\" -> \""+aux.getApuntadorCliente().getCliente().getDpi()+"\"\n";
            dot += "\""+aux+"\" -> \""+aux.getApuntadorConductor().getConductor().getDpi()+"\"\n";
            dot += "\""+aux+"\" -> \""+aux.getApuntadorVehiculo()+"\"\n";
            dot += "\""+aux+"\" -> \""+aux.getApuntadorRuta().getCabeza()+"\"\n";
            dot += aux.getApuntadorRuta().grafoParcial(it);
            it++;
            aux = aux.getSiguiente();
        } while (aux != this.cabeza);
        aux = this.cabeza;
        do {            
            dot += "\""+aux + "\" -> \""+aux.getAnterior()+"\"\n";
            aux = aux.getAnterior();
        } while (aux != this.cabeza);
        dot += "}\n";
        dot += Inicial.grafo.grafo();
        dot += "}";
        return dot;
    }
    
    public String grafoBlockChain(){
        String dot = "digraph BlockChain{\n";
        NodoL aux = this.cabeza;
        do {            
            dot += "\""+aux+"\" [label = \"Llave: "+aux.getLlave()+"\nUsuario: "+aux.getApuntadorCliente().getCliente().getDpi()+
                    "\nConductor: "+aux.getApuntadorConductor().getConductor().getDpi()+"\nVehiculo: "+aux.getPlaca()+
                    "\nOrigen: "+aux.getApuntadorRuta().getCabeza().getVerticeGrafo().getNombre()+
                    "\nDestino: "+aux.getApuntadorRuta().getCola().getVerticeGrafo().getNombre()+"\"]\n";
            dot += "\""+aux+"\" -> \""+aux.getSiguiente()+"\"\n";
            aux = aux.getSiguiente();
        } while (aux != this.cabeza);
        aux = this.cabeza;
        do {            
            dot += "\""+ aux + "\" -> \""+aux.getAnterior()+"\"\n";
            aux = aux.getAnterior();
        } while (aux != this.cabeza);
        dot += "}";
        return dot;
    }
    
    public String grafoListaDobleCircular(){
        String dot = "digraph ListaDobleCircular{\n";
        NodoL aux = this.cabeza;
        do {            
            dot += "\""+aux.getConductor().getDpi()+"\" [label = \"Dpi: "+aux.getConductor().getDpi()+"\nNombre completo: "+aux.getConductor().getNombres()+" "+
                    aux.getConductor().getApellidos()+"\"]\n";
            dot += "\""+aux.getConductor().getDpi()+"\" -> \""+aux.getSiguiente().getConductor().getDpi()+"\"\n";
            aux = aux.getSiguiente();
        } while (aux != this.cabeza);
        aux = this.cabeza;
        do {            
            dot += "\""+aux.getConductor().getDpi() + "\" -> \""+aux.getAnterior().getConductor().getDpi()+"\"\n";
            aux = aux.getAnterior();
        } while (aux != this.cabeza);
        dot += "}";
        return dot;
    }
    
    public String grafoParcial(){
        String dot = "subgraph cluster_doble{\nstyle=filled\nlabel=\"Lista Doble Circular\"\nColor=aquamarine\n";
        NodoL aux = this.cabeza;
        do {            
            dot += "\""+aux.getConductor().getDpi()+"\" [label = \"Dpi: "+aux.getConductor().getDpi()+"\nNombre completo: "+aux.getConductor().getNombres()+" "+
                    aux.getConductor().getApellidos()+"\"]\n";
            dot += "\""+aux.getConductor().getDpi()+"\" -> \""+aux.getSiguiente().getConductor().getDpi()+"\"\n";
            aux = aux.getSiguiente();
        } while (aux != this.cabeza);
        aux = this.cabeza;
        do {            
            dot += "\""+aux.getConductor().getDpi() + "\" -> \""+aux.getAnterior().getConductor().getDpi()+"\"\n";
            aux = aux.getAnterior();
        } while (aux != this.cabeza);
        dot += "}\n";
        return dot;
    }
    
    public Conductor buscar(BigInteger llave){
        Conductor conductor = null;
        NodoL aux = this.cabeza;
        
        do {            
            if(aux.getConductor().getDpi().compareTo(llave) == 0){
                conductor = aux.getConductor();
                break;
            }
            aux = aux.getSiguiente();
        } while(aux != this.cabeza);
        
        return conductor;
    }
   
    public NodoL buscarNodo(BigInteger llave){
        NodoL aux = this.cabeza;
        
        do {            
            if(aux.getConductor().getDpi().compareTo(llave) == 0){
                break;
            }
            aux = aux.getSiguiente();
        } while(aux != this.cabeza);
        
        return aux;
    }
    
    public boolean eliminar(BigInteger llave){
        boolean band = false;
        if(this.tamanio == 1){
            if(this.cabeza.getConductor().getDpi().compareTo(llave) == 0){
                this.cabeza = this.cola = null;
                this.tamanio--;
                band = true;
            }
        }else{
            NodoL aux = this.cabeza;
            do {                
                if(aux.getConductor().getDpi().compareTo(llave) == 0){
                    band = true;
                    this.tamanio--;
                    break;
                }
                aux = aux.getSiguiente();
            } while(aux != this.cabeza);
            
            if(band){
                aux.getAnterior().setSiguiente(aux.getSiguiente());
                aux.getSiguiente().setAnterior(aux.getAnterior());
                aux.setAnterior(null);
                aux.setSiguiente(null);
                if(aux == cabeza){
                    this.cabeza = this.cabeza.getSiguiente();
                }
                if(aux == cola){
                    this.cola = this.cola.getAnterior();
                }
            }
            
        }
        return band;
    }
    
    public void insertar(Conductor conductor){
        if(this.cabeza == null){
            this.cabeza = this.cola = new NodoL(conductor);
            this.cabeza.setAnterior(cola);
            this.cabeza.setSiguiente(cabeza);
            this.tamanio++;
        }else{
            NodoL nuevo = new NodoL(conductor, this.cabeza, this.cola);
            this.cola.setSiguiente(nuevo);
            this.cabeza.setAnterior(nuevo);
            this.cola = nuevo;
            this.tamanio++;
            this.ordenarAsc();
        }
    }
    
        
    private void insertar(String llave, NodoL conductor, NodoC cliente, ListaSimple ruta, NodoAB vehiculo, Viaje viaje, String placa){
        if(this.cabeza == null){
            this.cabeza = this.cola = new NodoL(cliente, conductor, vehiculo, ruta, llave, viaje, placa);
            this.cabeza.setAnterior(cola);
            this.cabeza.setSiguiente(cabeza);
            this.tamanio++;
        }else{
            NodoL nuevo = new NodoL(this.cola, this.cabeza, cliente, conductor, vehiculo, ruta, llave, viaje, placa);
            this.cola.setSiguiente(nuevo);
            this.cabeza.setAnterior(nuevo);
            this.cola = nuevo;
            this.tamanio++;
        }
    }
    
    private void ordenarAsc(){
        ordenarAsc(this.cabeza, 1);
    }
    
    private void ordenarAsc(NodoL temp, int tam){   
    if(tam <= this.tamanio){
        NodoL aux = this.cabeza;
        do {
            if(aux.getConductor().getDpi().compareTo(temp.getConductor().getDpi()) == 1){
                Conductor conductor = aux.getConductor();
                aux.setConductor(temp.getConductor());
                temp.setConductor(conductor);
            }
            aux = aux.getSiguiente();
        } while (aux != this.cabeza);
        tam++;
        this.ordenarAsc(temp.getSiguiente(),tam);
        }
    }
    
    public ListaDobleCircular(){
        this.cabeza = this.cola = null;
        this.tamanio = 0;
    }
    
}

class NodoL{
    private Conductor conductor;
    private NodoL anterior, siguiente;
    private NodoC apuntadorCliente;
    private NodoL apuntadorConductor;
    private NodoAB apuntadorVehiculo;
    private ListaSimple apuntadorRuta;
    private String llave, placa;
    private Viaje viaje;

    public NodoL(NodoL anterior, NodoL siguiente, NodoC apuntadorCliente, NodoL apuntadorConductor, NodoAB apuntadorVehiculo, ListaSimple apuntadorRuta, String llave, Viaje viaje, String placa) {
        this.anterior = anterior;
        this.siguiente = siguiente;
        this.apuntadorCliente = apuntadorCliente;
        this.apuntadorConductor = apuntadorConductor;
        this.apuntadorVehiculo = apuntadorVehiculo;
        this.apuntadorRuta = apuntadorRuta;
        this.llave = llave;
        this.viaje = viaje;
        this.placa = placa;
    }
    
    public NodoL(NodoC apuntadorCliente, NodoL apuntadorConductor, NodoAB apuntadorVehiculo, ListaSimple apuntadorRuta, String llave, Viaje viaje, String placa) {
        this.apuntadorCliente = apuntadorCliente;
        this.apuntadorConductor = apuntadorConductor;
        this.apuntadorVehiculo = apuntadorVehiculo;
        this.apuntadorRuta = apuntadorRuta;
        this.llave = llave;
        this.viaje = viaje;
        this.anterior = this.siguiente = null;
        this.placa = placa;
    }
    
    public NodoL(Conductor conductor, NodoL siguiente, NodoL anterior) {
        this.conductor = conductor;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }
    
    public NodoL(Conductor conductor){
        this.conductor = conductor;
        this.anterior = this.siguiente = null;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public NodoC getApuntadorCliente() {
        return apuntadorCliente;
    }

    public void setApuntadorCliente(NodoC apuntadorCliente) {
        this.apuntadorCliente = apuntadorCliente;
    }

    public NodoL getApuntadorConductor() {
        return apuntadorConductor;
    }

    public void setApuntadorConductor(NodoL apuntadorConductor) {
        this.apuntadorConductor = apuntadorConductor;
    }

    public NodoAB getApuntadorVehiculo() {
        return apuntadorVehiculo;
    }

    public void setApuntadorVehiculo(NodoAB apuntadorVehiculo) {
        this.apuntadorVehiculo = apuntadorVehiculo;
    }

    public ListaSimple getApuntadorRuta() {
        return apuntadorRuta;
    }

    public void setApuntadorRuta(ListaSimple apuntadorRuta) {
        this.apuntadorRuta = apuntadorRuta;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    
    
    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public NodoL getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoL anterior) {
        this.anterior = anterior;
    }

    public NodoL getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoL siguiente) {
        this.siguiente = siguiente;
    }
    
}