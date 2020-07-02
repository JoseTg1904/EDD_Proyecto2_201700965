package Ventanas;

import Estructuras.ArbolB;
import Estructuras.ListaAdyacencia;
import Estructuras.ListaDobleCircular;
import Estructuras.TablaHash;
import Objetos.VerticeGrafo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author chepe
 */
public class Inicial extends javax.swing.JFrame {

    /**
     * Creates new form Inicial
     */
    public Inicial() {
        initComponents();
        this.jButton2.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cargaRutas = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Carga del grafo");

        cargaRutas.setText("Cargar archivo de rutas");
        cargaRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargaRutasActionPerformed(evt);
            }
        });

        jButton2.setText("Continuar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(cargaRutas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cargaRutas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cargaRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargaRutasActionPerformed
        JFileChooser selector = new JFileChooser();
        selector.showOpenDialog(this);
        File archivo = selector.getSelectedFile();
        if( archivo != null && !(archivo.getName().equals("")) ){
            try {
                cargaMasivaRutas(archivo);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Inicial.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Inicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cargaRutasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Seleccion seleccion = new Seleccion();
        seleccion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicial().setVisible(true);
            }
        });
    }
    
    //estructuras
    public static ListaAdyacencia grafo = new ListaAdyacencia();
    public static TablaHash clientes = new TablaHash();
    public static ArbolB vehiculos = new ArbolB();
    public static ListaDobleCircular conductores = new ListaDobleCircular();
    public static ListaDobleCircular blockChain = new ListaDobleCircular();
    
    
    private void cargaMasivaRutas(File archivoRutas) throws FileNotFoundException, IOException{
        FileReader lector = new FileReader(archivoRutas);
        BufferedReader almacenador = new BufferedReader(lector);
        String linea, contenido = "";
        String[] aux, aux1;
        while( (linea = almacenador.readLine()) != null ){
            contenido += linea;
        }
        aux1 = contenido.split("%");
        for(int i=0;i<aux1.length;i++){
            aux = aux1[i].split("/");
            grafo.insertarOrigen(new VerticeGrafo(aux[0].trim()));
            grafo.insertarOrigen(new VerticeGrafo(aux[1].trim()));
            int peso =  Integer.parseInt(aux[2].trim());
            grafo.insertarAdyacente(new VerticeGrafo(aux[1].trim(), peso), aux[0].trim());
        }
        JOptionPane.showMessageDialog(this,"Se han cargado las rutas exitosamente!\nYa puede continuar con la ejecucion del programa");
        this.jButton2.setEnabled(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cargaRutas;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
